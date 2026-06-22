package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rq1 extends qq1 {
    @Override // defpackage.iy
    public final boolean v(jq1 jq1Var) {
        if (jq1Var == null) {
            return false;
        }
        try {
            return this.p.isQuietModeEnabled(jq1Var.a);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
