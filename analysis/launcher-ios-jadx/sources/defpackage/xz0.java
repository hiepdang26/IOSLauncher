package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class xz0 {
    public static final xz0 g;
    public static final xz0 h;
    public static final xz0 i;
    public static final /* synthetic */ xz0[] j;

    static {
        xz0 xz0Var = new xz0("ConnectionFailed", 0);
        g = xz0Var;
        xz0 xz0Var2 = new xz0("NoLocationFound", 1);
        h = xz0Var2;
        xz0 xz0Var3 = new xz0("ParsingFailed", 2);
        xz0 xz0Var4 = new xz0("NoLocationPermissionOrFunction", 3);
        i = xz0Var4;
        j = new xz0[]{xz0Var, xz0Var2, xz0Var3, xz0Var4, new xz0("Unknown", 4)};
    }

    public static xz0 valueOf(String str) {
        return (xz0) Enum.valueOf(xz0.class, str);
    }

    public static xz0[] values() {
        return (xz0[]) j.clone();
    }
}
