package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class x60 implements wk1, AutoCloseable {
    public final Context g;
    public final String h;
    public final ei i;
    public final boolean j;
    public final boolean k;
    public final fl1 l;
    public boolean m;

    public x60(Context context, String str, ei eiVar, boolean z, boolean z2) {
        qg0.l(context, "context");
        qg0.l(eiVar, "callback");
        this.g = context;
        this.h = str;
        this.i = eiVar;
        this.j = z;
        this.k = z2;
        this.l = new fl1(new w60(this, 0));
    }

    public final v60 a() {
        return (v60) this.l.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.l.h != iy.k) {
            a().close();
        }
    }

    @Override // defpackage.wk1
    public final void setWriteAheadLoggingEnabled(boolean z) {
        if (this.l.h != iy.k) {
            v60 v60VarA = a();
            qg0.l(v60VarA, "sQLiteOpenHelper");
            v60VarA.setWriteAheadLoggingEnabled(z);
        }
        this.m = z;
    }

    @Override // defpackage.wk1
    public final s60 v() {
        return a().a(true);
    }
}
