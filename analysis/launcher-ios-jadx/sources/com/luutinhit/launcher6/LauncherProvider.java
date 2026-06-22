package com.luutinhit.launcher6;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import defpackage.ar1;
import defpackage.hl0;
import defpackage.jk0;
import defpackage.k31;
import defpackage.rl0;
import defpackage.sl0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class LauncherProvider extends ContentProvider {
    public static final /* synthetic */ int i = 0;
    public t g;
    public sl0 h;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long b(defpackage.sl0 r16, android.database.sqlite.SQLiteDatabase r17, java.lang.String r18, android.content.ContentValues r19) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LauncherProvider.b(sl0, android.database.sqlite.SQLiteDatabase, java.lang.String, android.content.ContentValues):long");
    }

    public static long e(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MAX(_id) FROM ".concat(str), null);
        long j = (cursorRawQuery == null || !cursorRawQuery.moveToNext()) ? -1L : cursorRawQuery.getLong(0);
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (j != -1) {
            return j;
        }
        throw new RuntimeException("Error: could not query max id in ".concat(str));
    }

    public static void i() {
        jk0 jk0Var;
        if (!ar1.i || Binder.getCallingPid() == Process.myPid() || (jk0Var = jk0.j) == null) {
            return;
        }
        rl0 rl0Var = jk0Var.a;
        rl0Var.w(false);
        hl0 hl0VarL = rl0Var.l();
        if (hl0VarL == null || hl0VarL.setLoadOnResume()) {
            return;
        }
        rl0Var.A(-1001, 0);
    }

    public final synchronized void a() {
        sl0 sl0Var = this.h;
        sl0Var.r(sl0Var.getWritableDatabase());
    }

    @Override // android.content.ContentProvider
    public final ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = this.h.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] contentProviderResultArrApplyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            i();
            return contentProviderResultArrApplyBatch;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        if (uri.getPathSegments().size() != 1) {
            throw new IllegalArgumentException(k31.l(uri, "Invalid URI: "));
        }
        String str = uri.getPathSegments().get(0);
        SQLiteDatabase writableDatabase = this.h.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int length = contentValuesArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                contentValuesArr[i2].put("modified", Long.valueOf(System.currentTimeMillis()));
                if (b(this.h, writableDatabase, str, contentValuesArr[i2]) < 0) {
                    return 0;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            h();
            i();
            return contentValuesArr.length;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void c() {
        sl0 sl0Var = this.h;
        sl0Var.r(sl0Var.getWritableDatabase());
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        if (Binder.getCallingUid() != Process.myUid()) {
            return null;
        }
        str.getClass();
        if (str.equals("get_boolean_setting")) {
            Bundle bundle2 = new Bundle();
            if ("pref_allowRotation".equals(str2)) {
                bundle2.putBoolean("value", ar1.r(getContext()));
                return bundle2;
            }
            bundle2.putBoolean("value", ar1.q(getContext()).getBoolean(str2, bundle.getBoolean("default_value")));
            return bundle2;
        }
        if (!str.equals("set_boolean_setting")) {
            return null;
        }
        boolean z = bundle.getBoolean("value");
        ar1.q(getContext()).edit().putBoolean(str2, z).apply();
        t tVar = this.g;
        if (tVar != null) {
            tVar.onSettingsChanged(str2, z);
        }
        if (bundle.getBoolean("notify_backup")) {
            LauncherBackupAgentHelper.a(getContext());
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("value", z);
        return bundle3;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.h.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            try {
                Cursor cursorQuery = writableDatabase.query("favorites", new String[]{"_id"}, "itemType = 2 AND _id NOT IN (SELECT container FROM favorites)", null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
                }
                cursorQuery.close();
                if (arrayList.size() > 0) {
                    writableDatabase.delete("favorites", ar1.d("_id", arrayList), null);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return arrayList;
            } catch (SQLException e) {
                e.getMessage();
                arrayList.clear();
                writableDatabase.endTransaction();
                return arrayList;
            }
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        String str2;
        if (uri.getPathSegments().size() == 1) {
            str2 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(k31.l(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(k31.l(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            strArr = null;
            str = "_id=" + ContentUris.parseId(uri);
            str2 = str3;
        }
        int iDelete = this.h.getWritableDatabase().delete(str2, str, strArr);
        if (iDelete > 0) {
            h();
        }
        i();
        return iDelete;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #1 {all -> 0x0072, blocks: (B:3:0x0001, B:5:0x0012, B:17:0x004d, B:20:0x0064, B:25:0x0077, B:27:0x0085, B:29:0x0097, B:31:0x00aa, B:35:0x00bd, B:36:0x00db, B:39:0x00ec, B:40:0x0115, B:8:0x0019, B:11:0x0030, B:13:0x0038), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:3:0x0001, B:5:0x0012, B:17:0x004d, B:20:0x0064, B:25:0x0077, B:27:0x0085, B:29:0x0097, B:31:0x00aa, B:35:0x00bd, B:36:0x00db, B:39:0x00ec, B:40:0x0115, B:8:0x0019, B:11:0x0030, B:13:0x0038), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void f() {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LauncherProvider.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0364 A[Catch: all -> 0x019d, TryCatch #4 {all -> 0x019d, blocks: (B:12:0x009f, B:14:0x00a5, B:15:0x0143, B:17:0x014b, B:23:0x0162, B:25:0x0187, B:27:0x018d, B:32:0x01b3, B:33:0x01cd, B:37:0x01ff, B:40:0x0209, B:44:0x022c, B:45:0x0230, B:47:0x023a, B:50:0x0258, B:55:0x027d, B:59:0x028e, B:61:0x02a7, B:62:0x02ae, B:66:0x02c3, B:68:0x0364, B:72:0x0373, B:74:0x03a1, B:76:0x03ad, B:77:0x03b5, B:53:0x0277, B:64:0x02b4, B:30:0x01a0, B:79:0x03e7, B:81:0x03fc, B:83:0x040c, B:85:0x0414, B:87:0x041a, B:92:0x0430, B:93:0x0439, B:94:0x0444, B:96:0x0459, B:99:0x0470, B:101:0x048d, B:102:0x048f, B:104:0x0493, B:105:0x049b, B:107:0x04a3, B:117:0x04c9, B:127:0x04ef, B:128:0x04f2, B:126:0x04eb, B:130:0x04fa, B:136:0x051f, B:143:0x0531, B:144:0x053b, B:145:0x053e, B:133:0x0500, B:142:0x052e), top: B:162:0x009f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0373 A[Catch: all -> 0x019d, TryCatch #4 {all -> 0x019d, blocks: (B:12:0x009f, B:14:0x00a5, B:15:0x0143, B:17:0x014b, B:23:0x0162, B:25:0x0187, B:27:0x018d, B:32:0x01b3, B:33:0x01cd, B:37:0x01ff, B:40:0x0209, B:44:0x022c, B:45:0x0230, B:47:0x023a, B:50:0x0258, B:55:0x027d, B:59:0x028e, B:61:0x02a7, B:62:0x02ae, B:66:0x02c3, B:68:0x0364, B:72:0x0373, B:74:0x03a1, B:76:0x03ad, B:77:0x03b5, B:53:0x0277, B:64:0x02b4, B:30:0x01a0, B:79:0x03e7, B:81:0x03fc, B:83:0x040c, B:85:0x0414, B:87:0x041a, B:92:0x0430, B:93:0x0439, B:94:0x0444, B:96:0x0459, B:99:0x0470, B:101:0x048d, B:102:0x048f, B:104:0x0493, B:105:0x049b, B:107:0x04a3, B:117:0x04c9, B:127:0x04ef, B:128:0x04f2, B:126:0x04eb, B:130:0x04fa, B:136:0x051f, B:143:0x0531, B:144:0x053b, B:145:0x053e, B:133:0x0500, B:142:0x052e), top: B:162:0x009f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03ad A[Catch: all -> 0x019d, TryCatch #4 {all -> 0x019d, blocks: (B:12:0x009f, B:14:0x00a5, B:15:0x0143, B:17:0x014b, B:23:0x0162, B:25:0x0187, B:27:0x018d, B:32:0x01b3, B:33:0x01cd, B:37:0x01ff, B:40:0x0209, B:44:0x022c, B:45:0x0230, B:47:0x023a, B:50:0x0258, B:55:0x027d, B:59:0x028e, B:61:0x02a7, B:62:0x02ae, B:66:0x02c3, B:68:0x0364, B:72:0x0373, B:74:0x03a1, B:76:0x03ad, B:77:0x03b5, B:53:0x0277, B:64:0x02b4, B:30:0x01a0, B:79:0x03e7, B:81:0x03fc, B:83:0x040c, B:85:0x0414, B:87:0x041a, B:92:0x0430, B:93:0x0439, B:94:0x0444, B:96:0x0459, B:99:0x0470, B:101:0x048d, B:102:0x048f, B:104:0x0493, B:105:0x049b, B:107:0x04a3, B:117:0x04c9, B:127:0x04ef, B:128:0x04f2, B:126:0x04eb, B:130:0x04fa, B:136:0x051f, B:143:0x0531, B:144:0x053b, B:145:0x053e, B:133:0x0500, B:142:0x052e), top: B:162:0x009f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03b5 A[Catch: all -> 0x019d, TryCatch #4 {all -> 0x019d, blocks: (B:12:0x009f, B:14:0x00a5, B:15:0x0143, B:17:0x014b, B:23:0x0162, B:25:0x0187, B:27:0x018d, B:32:0x01b3, B:33:0x01cd, B:37:0x01ff, B:40:0x0209, B:44:0x022c, B:45:0x0230, B:47:0x023a, B:50:0x0258, B:55:0x027d, B:59:0x028e, B:61:0x02a7, B:62:0x02ae, B:66:0x02c3, B:68:0x0364, B:72:0x0373, B:74:0x03a1, B:76:0x03ad, B:77:0x03b5, B:53:0x0277, B:64:0x02b4, B:30:0x01a0, B:79:0x03e7, B:81:0x03fc, B:83:0x040c, B:85:0x0414, B:87:0x041a, B:92:0x0430, B:93:0x0439, B:94:0x0444, B:96:0x0459, B:99:0x0470, B:101:0x048d, B:102:0x048f, B:104:0x0493, B:105:0x049b, B:107:0x04a3, B:117:0x04c9, B:127:0x04ef, B:128:0x04f2, B:126:0x04eb, B:130:0x04fa, B:136:0x051f, B:143:0x0531, B:144:0x053b, B:145:0x053e, B:133:0x0500, B:142:0x052e), top: B:162:0x009f, inners: #1, #3 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 1429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LauncherProvider.g():void");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        String str;
        String str2 = null;
        if (uri.getPathSegments().size() == 1) {
            str = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(k31.l(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(null)) {
                throw new UnsupportedOperationException(k31.l(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            str2 = "_id=" + ContentUris.parseId(uri);
            str = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            return "vnd.android.cursor.dir/" + str;
        }
        return "vnd.android.cursor.item/" + str;
    }

    public final void h() {
        LauncherBackupAgentHelper.a(getContext());
        t tVar = this.g;
        if (tVar != null) {
            tVar.onLauncherProviderChange();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.net.Uri insert(android.net.Uri r18, android.content.ContentValues r19) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LauncherProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context.getApplicationContext();
        Context context2 = jk0.i;
        if (context2 != null) {
            Objects.toString(context2);
            Objects.toString(applicationContext);
        }
        jk0.i = applicationContext.getApplicationContext();
        jk0.h = new WeakReference(this);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        this.h = new sl0(context);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        if (uri.getPathSegments().size() == 1) {
            str3 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(k31.l(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(k31.l(uri, "WHERE clause not supported: "));
            }
            str3 = uri.getPathSegments().get(0);
            str = "_id=" + ContentUris.parseId(uri);
            strArr2 = null;
        }
        String str4 = str;
        String[] strArr3 = strArr2;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(str3);
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.h.getWritableDatabase(), strArr, str4, strArr3, null, null, str2);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        if (uri.getPathSegments().size() == 1) {
            str2 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(k31.l(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(k31.l(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            strArr = null;
            str = "_id=" + ContentUris.parseId(uri);
            str2 = str3;
        }
        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
        int iUpdate = this.h.getWritableDatabase().update(str2, contentValues, str, strArr);
        if (iUpdate > 0) {
            h();
        }
        i();
        return iUpdate;
    }
}
