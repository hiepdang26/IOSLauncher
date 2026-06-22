package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class j31 {
    public static final j31 g;
    public static final j31 h;
    public static final j31 i;
    public static final j31 j;
    public static final /* synthetic */ j31[] k;

    static {
        j31 j31Var = new j31("IMMEDIATE", 0);
        g = j31Var;
        j31 j31Var2 = new j31("HIGH", 1);
        h = j31Var2;
        j31 j31Var3 = new j31("NORMAL", 2);
        i = j31Var3;
        j31 j31Var4 = new j31("LOW", 3);
        j = j31Var4;
        k = new j31[]{j31Var, j31Var2, j31Var3, j31Var4};
    }

    public static j31 valueOf(String str) {
        return (j31) Enum.valueOf(j31.class, str);
    }

    public static j31[] values() {
        return (j31[]) k.clone();
    }
}
