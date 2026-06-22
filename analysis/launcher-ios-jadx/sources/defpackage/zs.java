package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class zs {
    public static final /* synthetic */ int a = 0;

    static {
        String property;
        int i = ul1.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            ys ysVar = ys.o;
            return;
        }
        xt xtVar = aw.a;
        za0 za0Var = kq0.a;
        za0 za0Var2 = za0Var.k;
        if (za0Var != null) {
            return;
        }
        ys ysVar2 = ys.o;
    }
}
