package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class i2 {
    public static final i2 g;
    public static final i2 h;
    public static final i2 i;
    public static final i2 j;
    public static final i2 k;
    public static final i2 l;
    public static final /* synthetic */ i2[] m;

    static {
        i2 i2Var = new i2("BANNER", 0);
        g = i2Var;
        i2 i2Var2 = new i2("INTERSTITIAL", 1);
        h = i2Var2;
        i2 i2Var3 = new i2("REWARDED", 2);
        i = i2Var3;
        i2 i2Var4 = new i2("REWARDED_INTERSTITIAL", 3);
        j = i2Var4;
        i2 i2Var5 = new i2("NATIVE", 4);
        k = i2Var5;
        i2 i2Var6 = new i2("APP_OPEN_AD", 5);
        l = i2Var6;
        m = new i2[]{i2Var, i2Var2, i2Var3, i2Var4, i2Var5, i2Var6};
    }

    public static i2 valueOf(String str) {
        return (i2) Enum.valueOf(i2.class, str);
    }

    public static i2[] values() {
        return (i2[]) m.clone();
    }
}
