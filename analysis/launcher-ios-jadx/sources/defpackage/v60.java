package defpackage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class v60 extends SQLiteOpenHelper implements AutoCloseable {
    public static final /* synthetic */ int n = 0;
    public final Context g;
    public final ow1 h;
    public final ei i;
    public final boolean j;
    public boolean k;
    public final p31 l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v60(Context context, String str, final ow1 ow1Var, final ei eiVar, boolean z) {
        String string;
        super(context, str, null, eiVar.b, new DatabaseErrorHandler() { // from class: t60
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                qg0.l(eiVar, "$callback");
                ow1 ow1Var2 = ow1Var;
                int i = v60.n;
                qg0.k(sQLiteDatabase, "dbObj");
                s60 s60VarG = os.g(ow1Var2, sQLiteDatabase);
                SQLiteDatabase sQLiteDatabase2 = s60VarG.g;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        ei.d(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                qg0.k(obj, "p.second");
                                ei.d((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                ei.d(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    s60VarG.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            }
        });
        qg0.l(context, "context");
        qg0.l(eiVar, "callback");
        this.g = context;
        this.h = ow1Var;
        this.i = eiVar;
        this.j = z;
        if (str == null) {
            string = UUID.randomUUID().toString();
            qg0.k(string, "randomUUID().toString()");
        } else {
            string = str;
        }
        this.l = new p31(string, context.getCacheDir(), false);
    }

    public final s60 a(boolean z) {
        p31 p31Var = this.l;
        try {
            p31Var.a((this.m || getDatabaseName() == null) ? false : true);
            this.k = false;
            SQLiteDatabase sQLiteDatabaseH = h(z);
            if (!this.k) {
                s60 s60VarG = os.g(this.h, sQLiteDatabaseH);
                p31Var.b();
                return s60VarG;
            }
            close();
            s60 s60VarA = a(z);
            p31Var.b();
            return s60VarA;
        } catch (Throwable th) {
            p31Var.b();
            throw th;
        }
    }

    public final SQLiteDatabase b(boolean z) {
        if (z) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            qg0.k(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        qg0.k(readableDatabase, "{\n                super.…eDatabase()\n            }");
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        p31 p31Var = this.l;
        try {
            p31Var.a(p31Var.a);
            super.close();
            this.h.h = null;
            this.m = false;
        } finally {
            p31Var.b();
        }
    }

    public final SQLiteDatabase h(boolean z) throws Throwable {
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z2 = this.m;
        Context context = this.g;
        if (databaseName != null && !z2 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                parentFile.toString();
            }
        }
        try {
            return b(z);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return b(z);
            } catch (Throwable th) {
                super.close();
                if (th instanceof u60) {
                    u60 u60Var = th;
                    int iV = uo.v(u60Var.g);
                    Throwable th2 = u60Var.h;
                    if (iV == 0 || iV == 1 || iV == 2 || iV == 3 || !(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else if (!(th instanceof SQLiteException) || databaseName == null || !this.j) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    return b(z);
                } catch (u60 e) {
                    throw e.h;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        qg0.l(sQLiteDatabase, "db");
        boolean z = this.k;
        ei eiVar = this.i;
        if (!z && eiVar.b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            os.g(this.h, sQLiteDatabase);
            eiVar.getClass();
        } catch (Throwable th) {
            throw new u60(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        qg0.l(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.i.o(os.g(this.h, sQLiteDatabase));
        } catch (Throwable th) {
            throw new u60(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        qg0.l(sQLiteDatabase, "db");
        this.k = true;
        try {
            this.i.q(os.g(this.h, sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new u60(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        qg0.l(sQLiteDatabase, "db");
        if (!this.k) {
            try {
                this.i.p(os.g(this.h, sQLiteDatabase));
            } catch (Throwable th) {
                throw new u60(5, th);
            }
        }
        this.m = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        qg0.l(sQLiteDatabase, "sqLiteDatabase");
        this.k = true;
        try {
            this.i.q(os.g(this.h, sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new u60(3, th);
        }
    }
}
