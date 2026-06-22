package defpackage;

import android.appwidget.AppWidgetHost;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.luutinhit.launcher6.LauncherProvider;
import com.luutinhit.launcher6.t;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class sl0 extends SQLiteOpenHelper implements w9 {
    public final Context g;
    public final AppWidgetHost h;
    public long i;
    public long j;
    public t k;

    public sl0(Context context) {
        super(context, "launcher.db", (SQLiteDatabase.CursorFactory) null, 26);
        this.i = -1L;
        this.j = -1L;
        this.g = context;
        this.h = new AppWidgetHost(context, 1024);
        if (!B("favorites") || !B("workspaceScreens")) {
            b(true, getWritableDatabase());
            k(true, getWritableDatabase());
            a(getWritableDatabase());
        }
        if (this.i == -1) {
            this.i = LauncherProvider.e(getWritableDatabase(), "favorites");
        }
        if (this.j == -1) {
            this.j = LauncherProvider.e(getWritableDatabase(), "workspaceScreens");
        }
    }

    public static boolean C(boolean z, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        if (z) {
            try {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN rank INTEGER NOT NULL DEFAULT 0;");
                } catch (SQLException e) {
                    e.getMessage();
                    sQLiteDatabase.endTransaction();
                    return false;
                }
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT container, MAX(cellX) FROM favorites WHERE container IN (SELECT _id FROM favorites WHERE itemType = ?) GROUP BY container;", new String[]{Integer.toString(2)});
        while (cursorRawQuery.moveToNext()) {
            sQLiteDatabase.execSQL("UPDATE favorites SET rank=cellX+(cellY*?) WHERE container=? AND cellX IS NOT NULL AND cellY IS NOT NULL;", new Object[]{Long.valueOf(cursorRawQuery.getLong(1) + 1), Long.valueOf(cursorRawQuery.getLong(0))});
        }
        cursorRawQuery.close();
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        return true;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS appType (_id INTEGER PRIMARY KEY AUTOINCREMENT,appType TEXT,packageName TEXT,className TEXT,title TEXT,modified INTEGER NOT NULL DEFAULT 0,item_type INTEGER NOT NULL DEFAULT 0);");
    }

    public static boolean h(SQLiteDatabase sQLiteDatabase, String str, long j) {
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN " + str + " INTEGER NOT NULL DEFAULT " + j + ";");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                return true;
            } catch (SQLException e) {
                e.getMessage();
                sQLiteDatabase.endTransaction();
                return false;
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public static void k(boolean z, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z ? " IF NOT EXISTS " : "") + "workspaceScreens (_id INTEGER PRIMARY KEY,screenRank INTEGER,modified INTEGER NOT NULL DEFAULT 0);");
    }

    public final int A(SQLiteDatabase sQLiteDatabase, y9 y9Var) {
        int i;
        ArrayList arrayList = new ArrayList();
        y9Var.m = sQLiteDatabase;
        try {
            i = y9Var.i(arrayList, y9Var.d);
        } catch (Exception unused) {
            i = -1;
        }
        Collections.sort(arrayList);
        ContentValues contentValues = new ContentValues();
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            contentValues.clear();
            contentValues.put("_id", (Long) obj);
            contentValues.put("screenRank", Integer.valueOf(i2));
            if (LauncherProvider.b(this, sQLiteDatabase, "workspaceScreens", contentValues) < 0) {
                throw new RuntimeException("Failed initialize screen tablefrom default layout");
            }
            i2++;
        }
        this.i = LauncherProvider.e(sQLiteDatabase, "favorites");
        this.j = LauncherProvider.e(sQLiteDatabase, "workspaceScreens");
        return i;
    }

    public final boolean B(String str) {
        try {
            Cursor cursorQuery = getReadableDatabase().query(true, "sqlite_master", new String[]{"tbl_name"}, "tbl_name = ?", new String[]{str}, null, null, null, null, null);
            z = cursorQuery.getCount() > 0;
            cursorQuery.close();
            return z;
        } catch (Throwable th) {
            th.getMessage();
            return z;
        }
    }

    public final void b(boolean z, SQLiteDatabase sQLiteDatabase) {
        StringBuilder sbO = uo.o("CREATE TABLE ", z ? " IF NOT EXISTS " : "", "favorites (_id INTEGER PRIMARY KEY,title TEXT,intent TEXT,container INTEGER,screen INTEGER,cellX INTEGER,cellY INTEGER,spanX INTEGER,spanY INTEGER,itemType INTEGER,appWidgetId INTEGER NOT NULL DEFAULT -1,isShortcut INTEGER,iconType INTEGER,iconPackage TEXT,iconResource TEXT,icon BLOB,uri TEXT,displayMode INTEGER,appWidgetProvider TEXT,modified INTEGER NOT NULL DEFAULT 0,restored INTEGER NOT NULL DEFAULT 0,profileId INTEGER DEFAULT ");
        sbO.append(iy.n(this.g).o(jq1.b()));
        sbO.append(",rank INTEGER NOT NULL DEFAULT 0,options INTEGER NOT NULL DEFAULT 0);");
        sQLiteDatabase.execSQL(sbO.toString());
    }

    @Override // defpackage.w9
    public final long generateNewItemId() {
        long j = this.i;
        if (j < 0) {
            throw new RuntimeException("Error: max item id was not initialized");
        }
        long j2 = j + 1;
        this.i = j2;
        return j2;
    }

    @Override // defpackage.w9
    public final long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return LauncherProvider.b(this, sQLiteDatabase, "favorites", contentValues);
    }

    public final void n(SQLiteDatabase sQLiteDatabase) throws Throwable {
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        sQLiteDatabase.beginTransaction();
        Cursor cursor = null;
        sQLiteStatementCompileStatement = null;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = sQLiteDatabase.query("favorites", new String[]{"_id", "intent"}, "itemType=1 AND profileId=" + iy.n(this.g).o(jq1.b()), null, null, null, null);
            try {
                sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("UPDATE favorites SET itemType=0 WHERE _id=?");
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("intent");
                while (cursorQuery.moveToNext()) {
                    try {
                        if (ar1.u(Intent.parseUri(cursorQuery.getString(columnIndexOrThrow2), 0))) {
                            sQLiteStatementCompileStatement.bindLong(1, cursorQuery.getLong(columnIndexOrThrow));
                            sQLiteStatementCompileStatement.executeUpdateDelete();
                        }
                    } catch (URISyntaxException unused) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                cursorQuery.close();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
            } catch (SQLException unused2) {
                sQLiteStatement2 = sQLiteStatementCompileStatement;
                cursor2 = cursorQuery;
                sQLiteDatabase.endTransaction();
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
            } catch (Throwable th) {
                th = th;
                sQLiteStatement = sQLiteStatementCompileStatement;
                cursor = cursorQuery;
                sQLiteDatabase.endTransaction();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (SQLException unused3) {
            sQLiteStatement2 = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.i = 1L;
        this.j = 0L;
        b(false, sQLiteDatabase);
        k(false, sQLiteDatabase);
        a(sQLiteDatabase);
        AppWidgetHost appWidgetHost = this.h;
        if (appWidgetHost != null) {
            appWidgetHost.deleteHost();
            new zp0().execute(new fl0(this, 2));
        }
        this.i = LauncherProvider.e(sQLiteDatabase, "favorites");
        Context context = this.g;
        ar1.q(context).edit().putBoolean("EMPTY_DATABASE_CREATED", true).apply();
        nq0.e(context, Collections.EMPTY_LIST);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        r(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (h(r19, "restored", 0) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010a, code lost:
    
        if (h(r19, "options", 0) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r19, int r20, int r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sl0.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public final void r(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorites");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
        onCreate(sQLiteDatabase);
    }

    public final long z() {
        long j = this.j;
        if (j < 0) {
            throw new RuntimeException("Error: max screen id was not initialized");
        }
        long j2 = j + 1;
        this.j = j2;
        return j2;
    }
}
