package defpackage;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class wf0 implements fs {
    public final cq0 a;

    public wf0(cq0 cq0Var) {
        this.a = cq0Var;
    }

    @Override // defpackage.fs
    public final Class a() {
        return InputStream.class;
    }

    @Override // defpackage.fs
    public final gs b(Object obj) {
        return new fz1((InputStream) obj, this.a);
    }
}
