package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class bv1 {
    public static final bv1 g;
    public static final bv1 h;
    public static final bv1 i;
    public static final /* synthetic */ bv1[] j;

    static {
        bv1 bv1Var = new bv1("ConnectionFailed", 0);
        g = bv1Var;
        bv1 bv1Var2 = new bv1("NoLocationFound", 1);
        h = bv1Var2;
        bv1 bv1Var3 = new bv1("ParsingFailed", 2);
        bv1 bv1Var4 = new bv1("NoLocationPermissionOrFunction", 3);
        i = bv1Var4;
        j = new bv1[]{bv1Var, bv1Var2, bv1Var3, bv1Var4, new bv1("Unknown", 4)};
    }

    public static bv1 valueOf(String str) {
        return (bv1) Enum.valueOf(bv1.class, str);
    }

    public static bv1[] values() {
        return (bv1[]) j.clone();
    }
}
