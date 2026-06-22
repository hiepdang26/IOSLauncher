package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private OnChooseActivityListener mActivityChoserModelPolicy;
    final Context mContext;
    final String mHistoryFileName;
    private Intent mIntent;
    private static final Object sRegistryLock = new Object();
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private final Object mInstanceLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private ActivitySorter mActivitySorter = new DefaultSorter();
    private int mHistoryMaxSize = 50;
    boolean mCanReadHistoricalData = true;
    private boolean mReadShareHistoryCalled = false;
    private boolean mHistoricalRecordsChanged = true;
    private boolean mReloadActivities = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f) + activityResolveInfo2.weight;
                    f *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return Float.floatToIntBits(this.weight) + ((((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        public PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Object... r14) {
            /*
                r13 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                r2 = 0
                r3 = r14[r2]
                java.util.List r3 = (java.util.List) r3
                r4 = 1
                r14 = r14[r4]
                java.lang.String r14 = (java.lang.String) r14
                r5 = 0
                androidx.appcompat.widget.ActivityChooserModel r6 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.io.FileNotFoundException -> La2
                android.content.Context r6 = r6.mContext     // Catch: java.io.FileNotFoundException -> La2
                java.io.FileOutputStream r14 = r6.openFileOutput(r14, r2)     // Catch: java.io.FileNotFoundException -> La2
                org.xmlpull.v1.XmlSerializer r6 = android.util.Xml.newSerializer()
                r6.setOutput(r14, r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r7 = "UTF-8"
                java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.startDocument(r7, r8)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.startTag(r5, r1)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                int r7 = r3.size()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r8 = 0
            L2d:
                if (r8 >= r7) goto L60
                java.lang.Object r9 = r3.remove(r2)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r9 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r9     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.startTag(r5, r0)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r10 = "activity"
                android.content.ComponentName r11 = r9.activity     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r11 = r11.flattenToString()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.attribute(r5, r10, r11)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r10 = "time"
                long r11 = r9.time     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.attribute(r5, r10, r11)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r10 = "weight"
                float r9 = r9.weight     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.attribute(r5, r10, r9)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.endTag(r5, r0)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                int r8 = r8 + r4
                goto L2d
            L5e:
                r0 = move-exception
                goto L98
            L60:
                r6.endTag(r5, r1)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                r6.endDocument()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L70 java.lang.IllegalStateException -> L7d java.lang.IllegalArgumentException -> L8a
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r4
                if (r14 == 0) goto L97
            L6c:
                r14.close()     // Catch: java.io.IOException -> L97
                goto L97
            L70:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L5e
                java.lang.String r0 = r0.mHistoryFileName     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r4
                if (r14 == 0) goto L97
                goto L6c
            L7d:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L5e
                java.lang.String r0 = r0.mHistoryFileName     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r4
                if (r14 == 0) goto L97
                goto L6c
            L8a:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch: java.lang.Throwable -> L5e
                java.lang.String r0 = r0.mHistoryFileName     // Catch: java.lang.Throwable -> L5e
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r4
                if (r14 == 0) goto L97
                goto L6c
            L97:
                return r5
            L98:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.mCanReadHistoricalData = r4
                if (r14 == 0) goto La1
                r14.close()     // Catch: java.io.IOException -> La1
            La1:
                throw r0
            La2:
                java.lang.String r14 = androidx.appcompat.widget.ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
        } else {
            this.mHistoryFileName = str.concat(HISTORY_FILE_EXTENSION);
        }
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean zAdd = this.mHistoricalRecords.add(historicalRecord);
        if (zAdd) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return zAdd;
    }

    private void ensureConsistentState() {
        boolean zLoadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (zLoadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            try {
                Map<String, ActivityChooserModel> map = sDataModelRegistry;
                activityChooserModel = map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> listQueryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.mActivities.add(new ActivityResolveInfo(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if (TextUtils.isEmpty(this.mHistoryFileName)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
        }
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < size; i++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() throws IOException {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() throws IOException {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.mContext.openFileInput(this.mHistoryFileName);
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                }
                if (!TAG_HISTORICAL_RECORDS.equals(xmlPullParserNewPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.mHistoricalRecords;
                list.clear();
                while (true) {
                    int next2 = xmlPullParserNewPullParser.next();
                    if (next2 == 1) {
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                            return;
                        }
                        return;
                    } else if (next2 != 3 && next2 != 4) {
                        if (!TAG_HISTORICAL_RECORD.equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new HistoricalRecord(xmlPullParserNewPullParser.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, ATTRIBUTE_TIME)), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, ATTRIBUTE_WEIGHT))));
                    }
                }
            } catch (IOException unused) {
                if (fileInputStreamOpenFileInput == null) {
                    return;
                }
                fileInputStreamOpenFileInput.close();
            } catch (XmlPullParserException unused2) {
                if (fileInputStreamOpenFileInput == null) {
                    return;
                }
                fileInputStreamOpenFileInput.close();
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException | IOException unused4) {
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public Intent chooseActivity(int i) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mIntent == null) {
                    return null;
                }
                ensureConsistentState();
                ActivityInfo activityInfo = this.mActivities.get(i).resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.mIntent);
                intent.setComponent(componentName);
                if (this.mActivityChoserModelPolicy != null) {
                    if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                        return null;
                    }
                }
                addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                List<ActivityResolveInfo> list = this.mActivities;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i).resolveInfo == resolveInfo) {
                        return i;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                if (this.mActivities.isEmpty()) {
                    return null;
                }
                return this.mActivities.get(0).resolveInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mActivitySorter == activitySorter) {
                    return;
                }
                this.mActivitySorter = activitySorter;
                if (sortActivitiesIfNeeded()) {
                    notifyChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
                ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
                float f = activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : DEFAULT_HISTORICAL_RECORD_WEIGHT;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                addHistoricalRecord(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mHistoryMaxSize == i) {
                    return;
                }
                this.mHistoryMaxSize = i;
                pruneExcessiveHistoricalRecordsIfNeeded();
                if (sortActivitiesIfNeeded()) {
                    notifyChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mIntent == intent) {
                    return;
                }
                this.mIntent = intent;
                this.mReloadActivities = true;
                ensureConsistentState();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
