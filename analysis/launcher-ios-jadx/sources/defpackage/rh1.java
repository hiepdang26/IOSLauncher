package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class rh1 {
    public static final rh1 g;
    public static final rh1 h;
    public static final rh1 i;
    public static final rh1 j;
    public static final rh1 k;
    public static final /* synthetic */ rh1[] l;

    static {
        rh1 rh1Var = new rh1("EXPANDED", 0);
        g = rh1Var;
        rh1 rh1Var2 = new rh1("COLLAPSED", 1);
        h = rh1Var2;
        rh1 rh1Var3 = new rh1("ANCHORED", 2);
        i = rh1Var3;
        rh1 rh1Var4 = new rh1("HIDDEN", 3);
        j = rh1Var4;
        rh1 rh1Var5 = new rh1("DRAGGING", 4);
        k = rh1Var5;
        l = new rh1[]{rh1Var, rh1Var2, rh1Var3, rh1Var4, rh1Var5};
    }

    public static rh1 valueOf(String str) {
        return (rh1) Enum.valueOf(rh1.class, str);
    }

    public static rh1[] values() {
        return (rh1[]) l.clone();
    }
}
