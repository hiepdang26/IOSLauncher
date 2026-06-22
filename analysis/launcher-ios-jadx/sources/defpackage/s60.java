package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class s60 implements AutoCloseable, Closeable {
    public static final String[] h = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] i = new String[0];
    public final SQLiteDatabase g;

    public s60(SQLiteDatabase sQLiteDatabase) {
        this.g = sQLiteDatabase;
    }

    public final boolean A() {
        SQLiteDatabase sQLiteDatabase = this.g;
        qg0.l(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public final Cursor B(yk1 yk1Var) {
        final r60 r60Var = new r60(yk1Var);
        Cursor cursorRawQueryWithFactory = this.g.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: q60
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                r60 r60Var2 = r60Var;
                qg0.h(sQLiteQuery);
                r60Var2.g.h(new y60(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, yk1Var.b(), i, null);
        qg0.k(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    public final Cursor C(String str) {
        qg0.l(str, "query");
        return B(new wg1(str));
    }

    public final void D() {
        this.g.setTransactionSuccessful();
    }

    public final void a() {
        this.g.beginTransaction();
    }

    public final void b() {
        this.g.beginTransactionNonExclusive();
    }

    @Override // java.lang.AutoCloseable, java.io.Closeable
    public final void close() {
        this.g.close();
    }

    public final z60 h(String str) {
        SQLiteStatement sQLiteStatementCompileStatement = this.g.compileStatement(str);
        qg0.k(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new z60(sQLiteStatementCompileStatement);
    }

    public final void k() {
        this.g.endTransaction();
    }

    public final void n(String str) {
        qg0.l(str, "sql");
        this.g.execSQL(str);
    }

    public final void r(Object[] objArr) {
        qg0.l(objArr, "bindArgs");
        this.g.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final boolean z() {
        return this.g.inTransaction();
    }
}
