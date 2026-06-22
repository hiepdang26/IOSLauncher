package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class yz0 {
    public static final yz0 g;
    public static final yz0 h;
    public static final /* synthetic */ yz0[] i;

    static {
        yz0 yz0Var = new yz0("FAHRENHEIT", 0);
        g = yz0Var;
        yz0 yz0Var2 = new yz0("CELSIUS", 1);
        h = yz0Var2;
        i = new yz0[]{yz0Var, yz0Var2};
    }

    public static yz0 valueOf(String str) {
        return (yz0) Enum.valueOf(yz0.class, str);
    }

    public static yz0[] values() {
        return (yz0[]) i.clone();
    }
}
