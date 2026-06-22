package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class ld0 implements lu0 {
    public static final e01 b = e01.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");
    public final ow1 a;

    public ld0(ow1 ow1Var) {
        this.a = ow1Var;
    }

    @Override // defpackage.lu0
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        x90 x90Var = (x90) obj;
        ow1 ow1Var = this.a;
        if (ow1Var != null) {
            ju0 ju0VarA = ju0.a(x90Var);
            iu0 iu0Var = (iu0) ow1Var.h;
            Object objA = iu0Var.a(ju0VarA);
            ArrayDeque arrayDeque = ju0.b;
            synchronized (arrayDeque) {
                arrayDeque.offer(ju0VarA);
            }
            x90 x90Var2 = (x90) objA;
            if (x90Var2 == null) {
                iu0Var.d(ju0.a(x90Var), x90Var);
            } else {
                x90Var = x90Var2;
            }
        }
        return new ku0(x90Var, new pd0(x90Var, ((Integer) g01Var.c(b)).intValue()));
    }
}
