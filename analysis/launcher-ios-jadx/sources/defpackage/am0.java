package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class am0 {
    public static final am0 g;
    public static final am0 h;
    public static final am0 i;
    public static final am0 j;
    public static final am0 k;
    public static final am0 l;
    public static final am0 m;
    public static final am0 n;
    public static final am0 o;
    public static final am0 p;
    public static final /* synthetic */ am0[] q;

    static {
        am0 am0Var = new am0("TRANSLATION_X", 0);
        g = am0Var;
        am0 am0Var2 = new am0("TRANSLATION_Y", 1);
        h = am0Var2;
        am0 am0Var3 = new am0("SCALE_X", 2);
        i = am0Var3;
        am0 am0Var4 = new am0("SCALE_Y", 3);
        j = am0Var4;
        am0 am0Var5 = new am0("ROTATION_Y", 4);
        k = am0Var5;
        am0 am0Var6 = new am0("ALPHA", 5);
        l = am0Var6;
        am0 am0Var7 = new am0("START_DELAY", 6);
        m = am0Var7;
        am0 am0Var8 = new am0("DURATION", 7);
        n = am0Var8;
        am0 am0Var9 = new am0("INTERPOLATOR", 8);
        o = am0Var9;
        am0 am0Var10 = new am0("WITH_LAYER", 9);
        p = am0Var10;
        q = new am0[]{am0Var, am0Var2, am0Var3, am0Var4, am0Var5, am0Var6, am0Var7, am0Var8, am0Var9, am0Var10};
    }

    public static am0 valueOf(String str) {
        return (am0) Enum.valueOf(am0.class, str);
    }

    public static am0[] values() {
        return (am0[]) q.clone();
    }
}
