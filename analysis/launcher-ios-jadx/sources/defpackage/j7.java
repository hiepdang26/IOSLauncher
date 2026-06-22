package defpackage;

import android.content.ContentUris;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.text.format.DateFormat;
import androidx.work.impl.WorkDatabase;
import com.luutinhit.launcher6.leftpage.widgets.BatteryWidget;
import com.luutinhit.launcher6.widget.AppSuggestionsWidget;
import com.luutinhit.launcher6.widget.CalendarWidget;
import com.luutinhit.launcher6.widget.CalendarWidget_2x2;
import com.luutinhit.launcher6.widget.FavoriteContactWidget;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j7 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ j7(l8 l8Var, ArrayList arrayList) {
        this.g = 2;
        this.h = arrayList;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        gh0 gh0Var;
        SQLiteDatabase sQLiteDatabaseOpenDatabase;
        Cursor cursorQuery;
        int i;
        String str;
        String string;
        Cursor cursor;
        String string2;
        int i2;
        Bitmap bitmapDecodeStream;
        SQLiteDatabase sQLiteDatabaseOpenDatabase2;
        Cursor cursorQuery2;
        SQLiteDatabase sQLiteDatabaseOpenDatabase3;
        Cursor cursorQuery3;
        String str2 = "dtend";
        String str3 = "dtstart";
        String str4 = "allDay";
        String str5 = "title";
        String str6 = "eventColor";
        Object obj = this.h;
        switch (this.g) {
            case 0:
                int i3 = AppSuggestionsWidget.s;
                AppSuggestionsWidget appSuggestionsWidget = (AppSuggestionsWidget) obj;
                appSuggestionsWidget.getClass();
                ArrayList arrayList = new ArrayList();
                try {
                    String path = appSuggestionsWidget.k.getDatabasePath("app_icons.db").getPath();
                    if (!path.isEmpty()) {
                        SQLiteDatabase sQLiteDatabaseOpenDatabase4 = SQLiteDatabase.openDatabase(path, null, 1);
                        if (sQLiteDatabaseOpenDatabase4.isOpen()) {
                            Cursor cursorQuery4 = sQLiteDatabaseOpenDatabase4.query("icons", null, null, null, null, null, "history DESC", "8");
                            if (cursorQuery4 != null) {
                                int i4 = 0;
                                while (cursorQuery4.moveToNext()) {
                                    try {
                                        String string3 = cursorQuery4.getString(cursorQuery4.getColumnIndexOrThrow("label"));
                                        String string4 = cursorQuery4.getString(cursorQuery4.getColumnIndexOrThrow("componentName"));
                                        int columnIndex = cursorQuery4.getColumnIndex("icon");
                                        if (columnIndex >= 0) {
                                            byte[] blob = cursorQuery4.getBlob(columnIndex);
                                            try {
                                                gh0Var = new gh0(i4, string3, string4, BitmapFactory.decodeByteArray(blob, 0, blob.length));
                                                i4++;
                                            } catch (Throwable th) {
                                                th = th;
                                                th.getMessage();
                                            }
                                            try {
                                                arrayList.add(gh0Var);
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th.getMessage();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                cursorQuery4.close();
                            }
                            sQLiteDatabaseOpenDatabase4.close();
                        }
                    }
                    break;
                } catch (Throwable th4) {
                    th4.getMessage();
                }
                return arrayList;
            case 1:
                int i5 = AppsLibraryCategoryActivity.J;
                AppsLibraryCategoryActivity appsLibraryCategoryActivity = (AppsLibraryCategoryActivity) obj;
                appsLibraryCategoryActivity.getClass();
                Thread.currentThread().getName();
                String path2 = appsLibraryCategoryActivity.getDatabasePath("app_icons.db").getPath();
                try {
                    if (!path2.isEmpty() && (sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(path2, null, 1)) != null && (cursorQuery = sQLiteDatabaseOpenDatabase.query("icons", null, null, null, null, null, "label ASC")) != null) {
                        cursorQuery.getCount();
                        ArrayList arrayList2 = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            byte[] blob2 = cursorQuery.getBlob(cursorQuery.getColumnIndex("icon"));
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(blob2, 0, blob2.length);
                            int i6 = appsLibraryCategoryActivity.F;
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, i6, i6, true);
                            int i7 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("label"));
                            String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("componentName"));
                            int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("data2"));
                            if (bitmapCreateScaledBitmap != null && string5 != null && string6 != null) {
                                arrayList2.add(new y6(i7, bitmapCreateScaledBitmap, string5, string6, i8));
                            }
                        }
                        sQLiteDatabaseOpenDatabase.close();
                        cursorQuery.close();
                        return arrayList2;
                    }
                } catch (Throwable unused) {
                }
                return null;
            case 2:
                Thread.currentThread().getName();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = (ArrayList) obj;
                int size = arrayList4.size();
                String str7 = "";
                int i9 = 0;
                while (i9 < size) {
                    Object obj2 = arrayList4.get(i9);
                    i9++;
                    v6 v6Var = (v6) obj2;
                    CharSequence charSequence = v6Var != null ? v6Var.u : null;
                    if (charSequence != null && charSequence.length() > 0) {
                        String strSubstring = charSequence.toString().toUpperCase().trim().substring(0, 1);
                        if (!str7.equals(strSubstring)) {
                            arrayList3.add(new w6(strSubstring, 1));
                            str7 = strSubstring;
                        }
                        arrayList3.add(new w6(v6Var, 0));
                    }
                }
                return arrayList3;
            case 3:
                return BatteryWidget.w((BatteryWidget) obj);
            case 4:
                String str8 = "dtstart";
                String str9 = "allDay";
                String str10 = "title";
                int i10 = CalendarWidget.F;
                CalendarWidget calendarWidget = (CalendarWidget) obj;
                calendarWidget.getClass();
                Thread.currentThread().getName();
                try {
                    ArrayList arrayList5 = calendarWidget.u;
                    if (arrayList5 == null) {
                        calendarWidget.u = new ArrayList();
                    } else {
                        arrayList5.clear();
                    }
                    ArrayList arrayList6 = calendarWidget.v;
                    if (arrayList6 == null) {
                        calendarWidget.v = new ArrayList();
                    } else {
                        arrayList6.clear();
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.getTimeInMillis();
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    calendar.add(5, 1);
                    long timeInMillis2 = calendar.getTimeInMillis();
                    Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                    calendar2.set(11, 0);
                    calendar2.set(12, 0);
                    calendar2.set(13, 0);
                    calendar2.set(14, 0);
                    calendar2.getTimeInMillis();
                    calendar2.add(5, 1);
                    calendar2.getTimeInMillis();
                    Uri.Builder builderBuildUpon = CalendarContract.Instances.CONTENT_URI.buildUpon();
                    ContentUris.appendId(builderBuildUpon, timeInMillis);
                    ContentUris.appendId(builderBuildUpon, timeInMillis2);
                    Cursor cursorQuery5 = calendarWidget.k.getContentResolver().query(builderBuildUpon.build(), new String[]{"event_id", "eventColor", "title", "dtstart", "dtend", "allDay"}, "visible=1", null, "startDay ASC, startMinute ASC, endDay ASC, endMinute ASC");
                    if (cursorQuery5 != null) {
                        int i11 = 0;
                        while (cursorQuery5.moveToNext()) {
                            try {
                                int i12 = i11 + 1;
                                try {
                                    int i13 = cursorQuery5.getInt(cursorQuery5.getColumnIndex("event_id"));
                                    int i14 = cursorQuery5.getInt(cursorQuery5.getColumnIndex(str6));
                                    String str11 = str10;
                                    String string7 = cursorQuery5.getString(cursorQuery5.getColumnIndex(str11));
                                    String str12 = str9;
                                    int i15 = cursorQuery5.getInt(cursorQuery5.getColumnIndex(str12));
                                    String str13 = str8;
                                    long j = cursorQuery5.getLong(cursorQuery5.getColumnIndex(str13));
                                    String str14 = str6;
                                    long j2 = cursorQuery5.getLong(cursorQuery5.getColumnIndex(str2));
                                    if (i15 == 1) {
                                        string = calendarWidget.k.getString(w61.all_day);
                                        str = str2;
                                    } else {
                                        str = str2;
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.is24HourFormat(calendarWidget.k) ? "hh:mm" : "kk:mm", calendarWidget.l);
                                        string = simpleDateFormat.format(new Date(j)) + " - " + simpleDateFormat.format(new Date(j2));
                                    }
                                    int i16 = i14 == 0 ? -6543440 : i14;
                                    if (string7 == null || string7.isEmpty()) {
                                        string7 = calendarWidget.k.getString(w61.unknown);
                                    }
                                    w00 w00Var = new w00(i13, i16, string7, string);
                                    if (i12 <= 2) {
                                        calendarWidget.u.add(w00Var);
                                    } else {
                                        calendarWidget.v.add(w00Var);
                                    }
                                    i11 = i12;
                                    str10 = str11;
                                    str9 = str12;
                                    str8 = str13;
                                    str6 = str14;
                                    str2 = str;
                                } catch (Throwable th5) {
                                    th = th5;
                                    i = i12;
                                    th.getMessage();
                                    return Integer.valueOf(i);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i = i11;
                            }
                        }
                        cursorQuery5.close();
                        i = i11;
                    } else {
                        i = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    i = 0;
                }
                return Integer.valueOf(i);
            case 5:
                int i17 = CalendarWidget_2x2.z;
                CalendarWidget_2x2 calendarWidget_2x2 = (CalendarWidget_2x2) obj;
                calendarWidget_2x2.getClass();
                Thread.currentThread().getName();
                ArrayList arrayList7 = new ArrayList();
                try {
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.getTimeInMillis();
                    calendar3.set(11, 0);
                    calendar3.set(12, 0);
                    calendar3.set(13, 0);
                    calendar3.set(14, 0);
                    long timeInMillis3 = calendar3.getTimeInMillis();
                    calendar3.add(5, 1);
                    long timeInMillis4 = calendar3.getTimeInMillis();
                    Calendar calendar4 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                    calendar4.set(11, 0);
                    calendar4.set(12, 0);
                    calendar4.set(13, 0);
                    calendar4.set(14, 0);
                    calendar4.getTimeInMillis();
                    calendar4.add(5, 1);
                    calendar4.getTimeInMillis();
                    Uri.Builder builderBuildUpon2 = CalendarContract.Instances.CONTENT_URI.buildUpon();
                    ContentUris.appendId(builderBuildUpon2, timeInMillis3);
                    ContentUris.appendId(builderBuildUpon2, timeInMillis4);
                    Cursor cursorQuery6 = calendarWidget_2x2.k.getContentResolver().query(builderBuildUpon2.build(), new String[]{"event_id", "eventColor", "title", "dtstart", "dtend", "allDay"}, "visible=1", null, "startDay ASC, startMinute ASC, endDay ASC, endMinute ASC");
                    if (cursorQuery6 != null) {
                        int i18 = 0;
                        while (cursorQuery6.moveToNext()) {
                            int i19 = i18 + 1;
                            int i20 = cursorQuery6.getInt(cursorQuery6.getColumnIndex("event_id"));
                            int i21 = cursorQuery6.getInt(cursorQuery6.getColumnIndex("eventColor"));
                            String string8 = cursorQuery6.getString(cursorQuery6.getColumnIndex(str5));
                            int i22 = cursorQuery6.getInt(cursorQuery6.getColumnIndex(str4));
                            String str15 = str3;
                            long j3 = cursorQuery6.getLong(cursorQuery6.getColumnIndex(str3));
                            String str16 = str4;
                            String str17 = str5;
                            long j4 = cursorQuery6.getLong(cursorQuery6.getColumnIndex("dtend"));
                            if (i22 == 1) {
                                string2 = calendarWidget_2x2.k.getString(w61.all_day);
                                cursor = cursorQuery6;
                            } else {
                                cursor = cursorQuery6;
                                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormat.is24HourFormat(calendarWidget_2x2.k) ? "hh:mm" : "kk:mm", calendarWidget_2x2.l);
                                string2 = simpleDateFormat2.format(new Date(j3)) + " - " + simpleDateFormat2.format(new Date(j4));
                            }
                            if (i21 == 0) {
                                i21 = -6543440;
                            }
                            if (string8 == null || string8.isEmpty()) {
                                string8 = calendarWidget_2x2.k.getString(w61.unknown);
                            }
                            w00 w00Var2 = new w00(i20, i21, string8, string2);
                            if (i19 <= 2) {
                                arrayList7.add(w00Var2);
                            }
                            i18 = i19;
                            cursorQuery6 = cursor;
                            str3 = str15;
                            str4 = str16;
                            str5 = str17;
                        }
                        cursorQuery6.close();
                    }
                    break;
                } catch (Throwable th8) {
                    th8.getMessage();
                }
                return arrayList7;
            case 6:
                int i23 = FavoriteContactWidget.D;
                FavoriteContactWidget favoriteContactWidget = (FavoriteContactWidget) obj;
                Thread.currentThread().getName();
                ArrayList arrayList8 = favoriteContactWidget.t;
                if (arrayList8 == null) {
                    favoriteContactWidget.t = new ArrayList();
                } else {
                    arrayList8.clear();
                }
                ArrayList arrayList9 = favoriteContactWidget.u;
                if (arrayList9 == null) {
                    favoriteContactWidget.u = new ArrayList();
                } else {
                    arrayList9.clear();
                }
                Cursor cursorQuery7 = favoriteContactWidget.k.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id", "display_name", "starred"}, "starred='1'", null, null);
                if (cursorQuery7 != null) {
                    int i24 = 0;
                    while (cursorQuery7.moveToNext()) {
                        s20 s20Var = new s20();
                        ArrayList arrayList10 = new ArrayList();
                        s20Var.a = cursorQuery7.getString(cursorQuery7.getColumnIndex("_id"));
                        s20Var.b = cursorQuery7.getString(cursorQuery7.getColumnIndex("display_name"));
                        try {
                            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(favoriteContactWidget.k.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.valueOf(s20Var.a).longValue()));
                            bitmapDecodeStream = inputStreamOpenContactPhotoInputStream != null ? BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream) : null;
                            if (inputStreamOpenContactPhotoInputStream != null) {
                                inputStreamOpenContactPhotoInputStream.close();
                            }
                        } catch (Throwable unused2) {
                            bitmapDecodeStream = null;
                        }
                        s20Var.d = bitmapDecodeStream;
                        Cursor cursorQuery8 = favoriteContactWidget.k.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + s20Var.a, null, null);
                        if (cursorQuery8 != null) {
                            while (cursorQuery8.moveToNext()) {
                                arrayList10.add(cursorQuery8.getString(cursorQuery8.getColumnIndex("data1")));
                            }
                            cursorQuery8.close();
                        }
                        s20Var.c = arrayList10;
                        int i25 = i24 + 1;
                        if (i25 <= 4) {
                            favoriteContactWidget.t.add(s20Var);
                        } else {
                            favoriteContactWidget.u.add(s20Var);
                        }
                        i24 = i25;
                    }
                    cursorQuery7.close();
                    i2 = i24;
                } else {
                    i2 = 0;
                }
                return Integer.valueOf(i2);
            case 7:
                int i26 = IconChangeActivity.M;
                IconChangeActivity iconChangeActivity = (IconChangeActivity) obj;
                iconChangeActivity.getClass();
                Thread.currentThread().getName();
                String path3 = iconChangeActivity.getDatabasePath("app_icons.db").getPath();
                try {
                    if (!path3.isEmpty() && (sQLiteDatabaseOpenDatabase2 = SQLiteDatabase.openDatabase(path3, null, 1)) != null && (cursorQuery2 = sQLiteDatabaseOpenDatabase2.query("icons", null, null, null, null, null, "label ASC")) != null) {
                        cursorQuery2.getCount();
                        ArrayList arrayList11 = new ArrayList();
                        while (cursorQuery2.moveToNext()) {
                            byte[] blob3 = cursorQuery2.getBlob(cursorQuery2.getColumnIndex("icon"));
                            Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(blob3, 0, blob3.length);
                            int i27 = iconChangeActivity.G;
                            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray2, i27, i27, true);
                            int i28 = cursorQuery2.getInt(cursorQuery2.getColumnIndex("_id"));
                            String string9 = cursorQuery2.getString(cursorQuery2.getColumnIndex("label"));
                            String string10 = cursorQuery2.getString(cursorQuery2.getColumnIndex("componentName"));
                            int i29 = cursorQuery2.getInt(cursorQuery2.getColumnIndex("data2"));
                            if (bitmapCreateScaledBitmap2 != null && string9 != null && string10 != null) {
                                arrayList11.add(new y6(i28, bitmapCreateScaledBitmap2, string9, string10, i29));
                            }
                        }
                        sQLiteDatabaseOpenDatabase2.close();
                        cursorQuery2.close();
                        return arrayList11;
                    }
                } catch (Throwable unused3) {
                }
                return null;
            case 8:
                WorkDatabase workDatabase = (WorkDatabase) ((mc1) obj).h;
                Long lM = workDatabase.q().m("next_alarm_manager_id");
                int iLongValue = lM != null ? (int) lM.longValue() : 0;
                workDatabase.q().p(new u21("next_alarm_manager_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                return Integer.valueOf(iLongValue);
            default:
                int i30 = LabelChangeActivity.H;
                LabelChangeActivity labelChangeActivity = (LabelChangeActivity) obj;
                labelChangeActivity.getClass();
                Thread.currentThread().getName();
                String path4 = labelChangeActivity.getDatabasePath("app_icons.db").getPath();
                try {
                    if (!path4.isEmpty() && (sQLiteDatabaseOpenDatabase3 = SQLiteDatabase.openDatabase(path4, null, 1)) != null && (cursorQuery3 = sQLiteDatabaseOpenDatabase3.query("icons", null, null, null, null, null, "label ASC")) != null) {
                        cursorQuery3.getCount();
                        ArrayList arrayList12 = new ArrayList();
                        while (cursorQuery3.moveToNext()) {
                            byte[] blob4 = cursorQuery3.getBlob(cursorQuery3.getColumnIndex("icon"));
                            Bitmap bitmapDecodeByteArray3 = BitmapFactory.decodeByteArray(blob4, 0, blob4.length);
                            int i31 = labelChangeActivity.E;
                            Bitmap bitmapCreateScaledBitmap3 = Bitmap.createScaledBitmap(bitmapDecodeByteArray3, i31, i31, true);
                            int i32 = cursorQuery3.getInt(cursorQuery3.getColumnIndex("_id"));
                            String string11 = cursorQuery3.getString(cursorQuery3.getColumnIndex("label"));
                            String string12 = cursorQuery3.getString(cursorQuery3.getColumnIndex("componentName"));
                            int i33 = cursorQuery3.getInt(cursorQuery3.getColumnIndex("data2"));
                            if (bitmapCreateScaledBitmap3 != null && string11 != null && string12 != null) {
                                arrayList12.add(new y6(i32, bitmapCreateScaledBitmap3, string11, string12, i33));
                            }
                        }
                        sQLiteDatabaseOpenDatabase3.close();
                        cursorQuery3.close();
                        return arrayList12;
                    }
                } catch (Throwable unused4) {
                }
                return null;
        }
    }

    public /* synthetic */ j7(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }
}
