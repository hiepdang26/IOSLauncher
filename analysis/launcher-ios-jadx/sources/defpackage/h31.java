package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class h31 {
    public static final h31 g;
    public static final /* synthetic */ h31[] h;

    /* JADX INFO: Fake field, exist only in values array */
    h31 EF2;

    static {
        h31 h31Var = new h31("SRGB", 0);
        h31 h31Var2 = new h31("DISPLAY_P3", 1);
        g = h31Var2;
        h = new h31[]{h31Var, h31Var2};
    }

    public static h31 valueOf(String str) {
        return (h31) Enum.valueOf(h31.class, str);
    }

    public static h31[] values() {
        return (h31[]) h.clone();
    }
}
