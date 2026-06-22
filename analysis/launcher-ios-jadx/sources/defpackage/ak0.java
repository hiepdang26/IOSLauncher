package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class ak0 {
    public static final ak0 g;
    public static final ak0 h;
    public static final ak0 i;
    public static final ak0 j;
    public static final ak0 k;
    public static final ak0 l;
    public static final /* synthetic */ ak0[] m;

    static {
        ak0 ak0Var = new ak0("NONE", 0);
        g = ak0Var;
        ak0 ak0Var2 = new ak0("WORKSPACE", 1);
        h = ak0Var2;
        ak0 ak0Var3 = new ak0("APPS", 2);
        i = ak0Var3;
        ak0 ak0Var4 = new ak0("APPS_SPRING_LOADED", 3);
        j = ak0Var4;
        ak0 ak0Var5 = new ak0("WIDGETS", 4);
        k = ak0Var5;
        ak0 ak0Var6 = new ak0("WIDGETS_SPRING_LOADED", 5);
        l = ak0Var6;
        m = new ak0[]{ak0Var, ak0Var2, ak0Var3, ak0Var4, ak0Var5, ak0Var6};
    }

    public static ak0 valueOf(String str) {
        return (ak0) Enum.valueOf(ak0.class, str);
    }

    public static ak0[] values() {
        return (ak0[]) m.clone();
    }
}
