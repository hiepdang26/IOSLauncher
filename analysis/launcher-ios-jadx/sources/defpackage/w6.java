package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class w6 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ w6(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public final String a() {
        switch (this.a) {
            case 0:
                v6 v6Var = (v6) this.b;
                if (v6Var != null) {
                    return String.valueOf(v6Var.u);
                }
                return null;
            default:
                return (String) this.b;
        }
    }

    public final int b() {
        switch (this.a) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }
}
