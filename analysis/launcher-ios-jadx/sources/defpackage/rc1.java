package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rc1 extends bf1 {
    @Override // defpackage.bf1
    public final void g(gg1 gg1Var, float f, float f2) {
        gg1Var.d(f2 * f, 180.0f, 90.0f);
        float f3 = f2 * 2.0f * f;
        cg1 cg1Var = new cg1(0.0f, 0.0f, f3, f3);
        cg1Var.f = 180.0f;
        cg1Var.g = 90.0f;
        gg1Var.f.add(cg1Var);
        ag1 ag1Var = new ag1(cg1Var);
        gg1Var.a(180.0f);
        gg1Var.g.add(ag1Var);
        gg1Var.d = 270.0f;
        float f4 = (0.0f + f3) * 0.5f;
        float f5 = (f3 - 0.0f) / 2.0f;
        double d = 270.0f;
        gg1Var.b = (((float) Math.cos(Math.toRadians(d))) * f5) + f4;
        gg1Var.c = (f5 * ((float) Math.sin(Math.toRadians(d)))) + f4;
    }
}
