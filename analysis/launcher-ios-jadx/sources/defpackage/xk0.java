package defpackage;

import android.app.backup.BackupDataInputStream;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.app.backup.BackupManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import com.luutinhit.launcher6.CommonAppTypeParser;
import com.luutinhit.launcher6.LauncherBackupAgentHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public final class xk0 implements BackupHelper {
    public static final String[] r = {"_id", "modified", "intent", "appWidgetProvider", "appWidgetId", "cellX", "cellY", "container", "icon", "iconPackage", "iconResource", "iconType", "itemType", "screen", "spanX", "spanY", "title", "profileId", "rank"};
    public static final String[] s = {"_id", "modified", "screenRank"};
    public final LauncherBackupAgentHelper a;
    public final long e;
    public BackupManager f;
    public long h;
    public boolean i;
    public oe0 j;
    public ha k;
    public xg0 l;
    public ha m;
    public byte[] g = new byte[512];
    public final HashSet n = new HashSet();
    public int p = 1;
    public int q = 0;
    public final HashSet b = new HashSet();
    public final ArrayList c = new ArrayList();
    public boolean o = true;
    public final wk0[] d = new wk0[7];

    public xk0(LauncherBackupAgentHelper launcherBackupAgentHelper) {
        this.a = launcherBackupAgentHelper;
        this.e = iy.n(launcherBackupAgentHelper).o(jq1.b());
    }

    public static ka d(String str) throws sj {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            try {
                ka kaVar = new ka();
                au0.c(kaVar, bArrDecode, bArrDecode.length);
                if (kaVar.e == g(kaVar)) {
                    return kaVar;
                }
                throw new sj("invalid key read from stream" + str);
            } catch (IllegalArgumentException e) {
                e = e;
                throw new sj(e);
            }
        } catch (IllegalArgumentException | tg0 e2) {
            e = e2;
        }
    }

    public static long g(ka kaVar) {
        CRC32 crc32 = new CRC32();
        crc32.update(kaVar.b);
        crc32.update((int) (kaVar.d & 65535));
        crc32.update((int) ((kaVar.d >> 32) & 65535));
        if (!TextUtils.isEmpty(kaVar.c)) {
            crc32.update(kaVar.c.getBytes());
        }
        return crc32.getValue();
    }

    public static ha k(xg0 xg0Var) {
        ha haVar = new ha();
        haVar.b = xg0Var.c;
        haVar.c = xg0Var.d;
        haVar.d = xg0Var.k;
        haVar.e = xg0Var.l;
        return haVar;
    }

    public static String m(ka kaVar) {
        return Base64.encodeToString(au0.d(kaVar), 2);
    }

    public static la o(int i, Bitmap bitmap) {
        la laVar = new la();
        laVar.b = i;
        laVar.c = ar1.n(bitmap);
        return laVar;
    }

    public static byte[] q(int i, byte[] bArr) throws tg0 {
        ga gaVar = new ga();
        au0.c(gaVar, bArr, i);
        CRC32 crc32 = new CRC32();
        crc32.update(gaVar.b);
        if (gaVar.c == crc32.getValue()) {
            return gaVar.b;
        }
        throw new tg0("checksum does not match");
    }

    public static byte[] v(au0 au0Var) {
        ga gaVar = new ga();
        gaVar.b = au0.d(au0Var);
        CRC32 crc32 = new CRC32();
        crc32.update(gaVar.b);
        gaVar.c = crc32.getValue();
        return au0.d(gaVar);
    }

    public final void a(ja jaVar) {
        this.h = jaVar.c;
        HashSet hashSet = this.b;
        hashSet.clear();
        ka[] kaVarArr = jaVar.f;
        if (kaVarArr != null) {
            for (ka kaVar : kaVarArr) {
                hashSet.add(m(kaVar));
            }
        }
        this.p = jaVar.g;
    }

    public final void b(BackupDataOutput backupDataOutput) {
        Cursor cursorQuery = this.a.getContentResolver().query(wl0.a, r, j(), null, null);
        try {
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(0);
                long j2 = cursorQuery.getLong(1);
                ka kaVar = new ka();
                kaVar.b = 1;
                kaVar.d = j;
                kaVar.e = g(kaVar);
                this.c.add(kaVar);
                if (!this.b.contains(Base64.encodeToString(au0.d(kaVar), 2)) || j2 >= this.h || this.p < 4) {
                    w(Base64.encodeToString(au0.d(kaVar), 2), n(cursorQuery), backupDataOutput);
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public final void c(BackupDataOutput backupDataOutput) {
        ka kaVar;
        String strEncodeToString;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        int i = launcherBackupAgentHelper.getResources().getDisplayMetrics().densityDpi;
        jq1 jq1VarB = jq1.b();
        Cursor cursorQuery = contentResolver.query(wl0.a, r, "(itemType=0 OR itemType=1) AND " + j(), null, null);
        try {
            cursorQuery.moveToPosition(-1);
            int i2 = 0;
            while (cursorQuery.moveToNext()) {
                cursorQuery.getLong(0);
                try {
                    Intent uri = Intent.parseUri(cursorQuery.getString(2), 0);
                    ComponentName component = uri.getComponent();
                    if (component != null) {
                        String strFlattenToShortString = component.flattenToShortString();
                        kaVar = new ka();
                        kaVar.b = 3;
                        kaVar.c = strFlattenToShortString;
                        kaVar.e = g(kaVar);
                        strEncodeToString = Base64.encodeToString(au0.d(kaVar), 2);
                    } else {
                        kaVar = null;
                        strEncodeToString = null;
                    }
                    boolean zContains = this.b.contains(strEncodeToString);
                    ArrayList arrayList = this.c;
                    if (zContains) {
                        arrayList.add(kaVar);
                    } else if (strEncodeToString != null) {
                        if (i2 < 10) {
                            Bitmap bitmapP = this.j.p(uri, jq1VarB);
                            if (bitmapP != null && !this.j.x(bitmapP, jq1VarB)) {
                                w(m(kaVar), o(i, bitmapP), backupDataOutput);
                                arrayList.add(kaVar);
                                i2++;
                            }
                        } else {
                            h();
                        }
                    }
                } catch (IOException | URISyntaxException unused) {
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public final void e(BackupDataOutput backupDataOutput) {
        Cursor cursorQuery = this.a.getContentResolver().query(yl0.a, s, null, null, null);
        try {
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(0);
                long j2 = cursorQuery.getLong(1);
                ka kaVar = new ka();
                kaVar.b = 2;
                kaVar.d = j;
                kaVar.e = g(kaVar);
                this.c.add(kaVar);
                if (!this.b.contains(Base64.encodeToString(au0.d(kaVar), 2)) || j2 >= this.h) {
                    ma maVar = new ma();
                    maVar.b = cursorQuery.getLong(0);
                    maVar.c = cursorQuery.getInt(2);
                    w(Base64.encodeToString(au0.d(kaVar), 2), maVar, backupDataOutput);
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public final void f(BackupDataOutput backupDataOutput) {
        ka kaVar;
        String strEncodeToString;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        int i = launcherBackupAgentHelper.getResources().getDisplayMetrics().densityDpi;
        Cursor cursorQuery = contentResolver.query(wl0.a, r, "itemType=4 AND " + j(), null, null);
        m7 m7VarF = m7.f(launcherBackupAgentHelper);
        if (cursorQuery != null) {
            try {
                cursorQuery.moveToPosition(-1);
                int i2 = 0;
                while (cursorQuery.moveToNext()) {
                    cursorQuery.getLong(0);
                    String string = cursorQuery.getString(3);
                    if (ComponentName.unflattenFromString(string) != null) {
                        kaVar = new ka();
                        kaVar.b = 4;
                        kaVar.c = string;
                        kaVar.e = g(kaVar);
                        strEncodeToString = Base64.encodeToString(au0.d(kaVar), 2);
                    } else {
                        kaVar = null;
                        strEncodeToString = null;
                    }
                    boolean zContains = this.b.contains(strEncodeToString);
                    ArrayList arrayList = this.c;
                    if (zContains && this.p >= 3) {
                        arrayList.add(kaVar);
                    } else if (strEncodeToString != null) {
                        if (i2 < 5) {
                            rk0 rk0VarG = m7VarF.g(cursorQuery.getInt(4));
                            if (rk0VarG != null) {
                                w(m(kaVar), p(i, rk0VarG), backupDataOutput);
                                arrayList.add(kaVar);
                                i2++;
                            }
                        } else {
                            h();
                        }
                    }
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    public final void h() {
        if (this.f == null) {
            this.f = new BackupManager(this.a);
        }
        this.f.dataChanged();
    }

    public final ja i() {
        ja jaVar = new ja();
        jaVar.c = this.h;
        int i = 0;
        jaVar.f = (ka[]) this.c.toArray(new ka[0]);
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.a;
        try {
            i = launcherBackupAgentHelper.getPackageManager().getPackageInfo(launcherBackupAgentHelper.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jaVar.b = i;
        jaVar.g = 4;
        jaVar.h = this.k;
        return jaVar;
    }

    public final String j() {
        return "profileId=" + iy.n(this.a).o(jq1.b());
    }

    public final boolean l(ja jaVar) {
        boolean z;
        ha haVar = this.k;
        ha haVar2 = jaVar.h;
        if (haVar2 != null) {
            float f = haVar2.c;
            if (f != 0.0f) {
                int i = haVar.e;
                float f2 = i;
                float f3 = haVar2.d;
                if (f2 >= f3) {
                    this.q = 0;
                    z = true;
                } else {
                    z = false;
                }
                int i2 = haVar2.e;
                if (i >= i2 && haVar.d - f2 >= f3 - i2) {
                    this.q = i - i2;
                    z = true;
                }
                if (z) {
                    if (haVar.c < f || haVar.b < haVar2.b) {
                        if (sa0.q) {
                            ha haVarK = k(this.l);
                            this.m = haVarK;
                            haVarK.c = haVar2.c;
                            haVarK.b = haVar2.b;
                            haVarK.d = haVar2.d;
                            haVarK.e = haVar2.e;
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final ia n(Cursor cursor) {
        Intent uri;
        int i;
        ia iaVar = new ia();
        iaVar.b = cursor.getLong(0);
        iaVar.f = cursor.getInt(13);
        iaVar.e = cursor.getInt(7);
        iaVar.g = cursor.getInt(5);
        iaVar.h = cursor.getInt(6);
        iaVar.i = cursor.getInt(14);
        iaVar.j = cursor.getInt(15);
        iaVar.p = cursor.getInt(11);
        iaVar.u = cursor.getInt(18);
        String string = cursor.getString(16);
        if (!TextUtils.isEmpty(string)) {
            iaVar.d = string;
        }
        String string2 = cursor.getString(2);
        ActivityInfo activityInfo = null;
        if (TextUtils.isEmpty(string2)) {
            uri = null;
        } else {
            try {
                uri = Intent.parseUri(string2, 0);
                try {
                    uri.removeExtra("profile");
                    iaVar.n = uri.toUri(0);
                } catch (URISyntaxException unused) {
                }
            } catch (URISyntaxException unused2) {
                uri = null;
            }
        }
        int i2 = cursor.getInt(12);
        iaVar.c = i2;
        if (i2 == 4) {
            iaVar.l = cursor.getInt(4);
            String string3 = cursor.getString(3);
            if (!TextUtils.isEmpty(string3)) {
                iaVar.m = string3;
            }
        } else if (i2 == 1) {
            if (iaVar.p == 0) {
                String string4 = cursor.getString(9);
                if (!TextUtils.isEmpty(string4)) {
                    iaVar.q = string4;
                }
                String string5 = cursor.getString(10);
                if (!TextUtils.isEmpty(string5)) {
                    iaVar.r = string5;
                }
            }
            byte[] blob = cursor.getBlob(8);
            if (blob != null && blob.length > 0) {
                iaVar.s = blob;
            }
        }
        if (iaVar.e == -101 && iaVar.n != null && (((i = iaVar.c) == 0 || i == 1) && uri != null && uri.getComponent() != null)) {
            PackageManager packageManager = this.a.getPackageManager();
            try {
                activityInfo = packageManager.getActivityInfo(uri.getComponent(), 0);
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (activityInfo != null) {
                int i3 = 0;
                loop0: while (true) {
                    wk0[] wk0VarArr = this.d;
                    if (i3 >= wk0VarArr.length) {
                        break;
                    }
                    if (wk0VarArr[i3] == null) {
                        wk0VarArr[i3] = new wk0(this, CommonAppTypeParser.getResourceForItemType(i3));
                    }
                    ArrayList arrayList = wk0VarArr[i3].a;
                    int size = arrayList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        Intent intent = (Intent) obj;
                        intent.setPackage(activityInfo.packageName);
                        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
                        if (resolveInfoResolveActivity != null && (resolveInfoResolveActivity.activityInfo.name.equals(activityInfo.name) || resolveInfoResolveActivity.activityInfo.name.equals(activityInfo.targetActivity))) {
                            break loop0;
                        }
                    }
                    i3++;
                }
                iaVar.t = i3;
            }
        }
        return iaVar;
    }

    public final na p(int i, rk0 rk0Var) {
        Resources resourcesForApplication;
        na naVar = new na();
        naVar.b = ((AppWidgetProviderInfo) rk0Var).provider.flattenToShortString();
        naVar.c = ((AppWidgetProviderInfo) rk0Var).label;
        naVar.d = ((AppWidgetProviderInfo) rk0Var).configure != null;
        if (((AppWidgetProviderInfo) rk0Var).icon != 0) {
            naVar.e = new la();
            oe0 oe0Var = this.j;
            String packageName = ((AppWidgetProviderInfo) rk0Var).provider.getPackageName();
            int i2 = ((AppWidgetProviderInfo) rk0Var).icon;
            oe0Var.getClass();
            try {
                resourcesForApplication = oe0Var.h.getResourcesForApplication(packageName);
            } catch (PackageManager.NameNotFoundException unused) {
                resourcesForApplication = null;
            }
            naVar.e.c = ar1.n(ar1.h((resourcesForApplication == null || i2 == 0) ? oe0Var.m() : oe0Var.n(i2, resourcesForApplication), this.a));
            naVar.e.b = i;
        }
        int i3 = ((AppWidgetProviderInfo) rk0Var).resizeMode;
        Point point = new Point((i3 & 1) != 0 ? rk0Var.i : -1, (i3 & 2) != 0 ? rk0Var.j : -1);
        naVar.g = point.x;
        naVar.h = point.y;
        return naVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00f6  */
    @Override // android.app.backup.BackupHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void performBackup(android.os.ParcelFileDescriptor r11, android.app.backup.BackupDataOutput r12, android.os.ParcelFileDescriptor r13) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xk0.performBackup(android.os.ParcelFileDescriptor, android.app.backup.BackupDataOutput, android.os.ParcelFileDescriptor):void");
    }

    public final void r(int i, byte[] bArr) throws sj, tg0 {
        int i2;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        ia iaVar = new ia();
        byte[] bArrQ = q(i, bArr);
        au0.c(iaVar, bArrQ, bArrQ.length);
        if (iaVar.e == -101) {
            iaVar.f += this.q;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(iaVar.b));
        contentValues.put("screen", Integer.valueOf(iaVar.f));
        contentValues.put("container", Integer.valueOf(iaVar.e));
        contentValues.put("cellX", Integer.valueOf(iaVar.g));
        contentValues.put("cellY", Integer.valueOf(iaVar.h));
        contentValues.put("spanX", Integer.valueOf(iaVar.i));
        contentValues.put("spanY", Integer.valueOf(iaVar.j));
        contentValues.put("rank", Integer.valueOf(iaVar.u));
        if (iaVar.c == 1) {
            contentValues.put("iconType", Integer.valueOf(iaVar.p));
            if (iaVar.p == 0) {
                contentValues.put("iconPackage", iaVar.q);
                contentValues.put("iconResource", iaVar.r);
            }
            contentValues.put("icon", iaVar.s);
        }
        if (TextUtils.isEmpty(iaVar.d)) {
            contentValues.put("title", "");
        } else {
            contentValues.put("title", iaVar.d);
        }
        if (!TextUtils.isEmpty(iaVar.n)) {
            contentValues.put("intent", iaVar.n);
        }
        contentValues.put("itemType", Integer.valueOf(iaVar.c));
        contentValues.put("profileId", Long.valueOf(iy.n(launcherBackupAgentHelper).o(jq1.b())));
        ha haVar = this.m;
        if (haVar == null) {
            haVar = this.k;
        }
        int i3 = iaVar.c;
        if (i3 == 4) {
            if (!TextUtils.isEmpty(iaVar.m)) {
                contentValues.put("appWidgetProvider", iaVar.m);
            }
            contentValues.put("appWidgetId", Integer.valueOf(iaVar.l));
            contentValues.put("restored", (Integer) 7);
            if (iaVar.g + iaVar.i > haVar.c || iaVar.h + iaVar.j > haVar.b) {
                this.o = false;
                throw new sj("Widget not in screen bounds, aborting restore");
            }
        } else {
            if (iaVar.e != -101 || iaVar.n == null || (!(i3 == 0 || i3 == 1) || (i2 = iaVar.t) == 0 || i2 >= 7)) {
                contentValues.put("restored", (Integer) 1);
            } else {
                contentValues.put("restored", Integer.valueOf(CommonAppTypeParser.encodeItemTypeToFlag(i2) | 1));
            }
            if (iaVar.e == -101) {
                int i4 = iaVar.f;
                if (i4 >= haVar.d || i4 == haVar.e) {
                    this.o = false;
                    throw new sj("Item not in hotseat bounds, aborting restore");
                }
            } else if (iaVar.g >= haVar.c || iaVar.h >= haVar.b) {
                this.o = false;
                throw new sj("Item not in desktop bounds, aborting restore");
            }
        }
        contentResolver.insert(wl0.a, contentValues);
    }

    @Override // android.app.backup.BackupHelper
    public final void restoreEntity(BackupDataInputStream backupDataInputStream) {
        if (this.o) {
            if (this.k == null) {
                LauncherBackupAgentHelper launcherBackupAgentHelper = this.a;
                xg0 xg0Var = new xg0(launcherBackupAgentHelper);
                this.l = xg0Var;
                this.k = k(xg0Var);
                this.j = new oe0(launcherBackupAgentHelper, this.l);
            }
            int size = backupDataInputStream.size();
            if (this.g.length < size) {
                this.g = new byte[size];
            }
            try {
                backupDataInputStream.read(this.g, 0, size);
                String key = backupDataInputStream.getKey();
                boolean zEquals = "#".equals(key);
                ArrayList arrayList = this.c;
                if (zEquals) {
                    if (!arrayList.isEmpty()) {
                        m((ka) arrayList.get(0));
                        this.o = false;
                        return;
                    }
                    ja jaVar = new ja();
                    byte[] bArrQ = q(size, this.g);
                    au0.c(jaVar, bArrQ, bArrQ.length);
                    a(jaVar);
                    this.o = l(jaVar);
                    return;
                }
                HashSet hashSet = this.b;
                if (hashSet.isEmpty() || hashSet.contains(key)) {
                    ka kaVarD = d(key);
                    arrayList.add(kaVarD);
                    int i = kaVarD.b;
                    if (i == 1) {
                        r(size, this.g);
                        return;
                    }
                    if (i == 2) {
                        t(size, this.g);
                        return;
                    }
                    if (i == 3) {
                        s(kaVarD, this.g, size);
                    } else if (i != 4) {
                        arrayList.remove(kaVarD);
                    } else {
                        u(kaVarD, this.g, size);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final void s(ka kaVar, byte[] bArr, int i) throws tg0 {
        la laVar = new la();
        byte[] bArrQ = q(i, bArr);
        au0.c(laVar, bArrQ, bArrQ.length);
        byte[] bArr2 = laVar.c;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
        if (bitmapDecodeByteArray == null) {
            return;
        }
        this.j.C(ComponentName.unflattenFromString(kaVar.c), bitmapDecodeByteArray, "", this.e, this.l);
    }

    public final void t(int i, byte[] bArr) throws tg0 {
        ContentResolver contentResolver = this.a.getContentResolver();
        ma maVar = new ma();
        byte[] bArrQ = q(i, bArr);
        au0.c(maVar, bArrQ, bArrQ.length);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(maVar.b));
        contentValues.put("screenRank", Integer.valueOf(maVar.c));
        contentResolver.insert(yl0.a, contentValues);
    }

    public final void u(ka kaVar, byte[] bArr, int i) throws tg0 {
        Bitmap bitmapDecodeByteArray;
        na naVar = new na();
        byte[] bArrQ = q(i, bArr);
        au0.c(naVar, bArrQ, bArrQ.length);
        byte[] bArr2 = naVar.e.c;
        if (bArr2 != null && (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length)) != null) {
            oe0 oe0Var = this.j;
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(naVar.b);
            int i2 = naVar.e.b;
            oe0Var.C(componentNameUnflattenFromString, bitmapDecodeByteArray, naVar.c, this.e, this.l);
        }
        this.n.add(naVar.b + "#" + naVar.g + "," + naVar.h);
    }

    public final void w(String str, au0 au0Var, BackupDataOutput backupDataOutput) throws IOException {
        byte[] bArrV = v(au0Var);
        backupDataOutput.writeEntityHeader(str, bArrV.length);
        backupDataOutput.writeEntityData(bArrV, bArrV.length);
        this.i = true;
    }

    @Override // android.app.backup.BackupHelper
    public final void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(v(i()));
        } catch (IOException unused) {
        }
    }
}
