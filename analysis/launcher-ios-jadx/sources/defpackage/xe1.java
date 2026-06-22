package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class xe1 {
    public static final xe1 g;
    public static final xe1 h;
    public static final xe1 i;
    public static final /* synthetic */ xe1[] j;

    static {
        xe1 xe1Var = new xe1("OPENING", 0);
        g = xe1Var;
        xe1 xe1Var2 = new xe1("OPENED", 1);
        h = xe1Var2;
        xe1 xe1Var3 = new xe1("CLOSING", 2);
        xe1 xe1Var4 = new xe1("CLOSED", 3);
        i = xe1Var4;
        j = new xe1[]{xe1Var, xe1Var2, xe1Var3, xe1Var4};
    }

    public static xe1 valueOf(String str) {
        return (xe1) Enum.valueOf(xe1.class, str);
    }

    public static xe1[] values() {
        return (xe1[]) j.clone();
    }
}
