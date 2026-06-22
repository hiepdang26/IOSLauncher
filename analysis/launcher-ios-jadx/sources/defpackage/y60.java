package defpackage;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
public class y60 implements xk1, AutoCloseable {
    public final SQLiteProgram g;

    public y60(SQLiteProgram sQLiteProgram) {
        qg0.l(sQLiteProgram, "delegate");
        this.g = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.g.close();
    }

    @Override // defpackage.xk1
    public final void e(int i, String str) {
        qg0.l(str, "value");
        this.g.bindString(i, str);
    }

    @Override // defpackage.xk1
    public final void g(int i) {
        this.g.bindNull(i);
    }

    @Override // defpackage.xk1
    public final void i(int i, double d) {
        this.g.bindDouble(i, d);
    }

    @Override // defpackage.xk1
    public final void q(int i, long j) {
        this.g.bindLong(i, j);
    }

    @Override // defpackage.xk1
    public final void s(int i, byte[] bArr) {
        this.g.bindBlob(i, bArr);
    }
}
