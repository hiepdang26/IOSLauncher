package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class nq1 {
    public static final nq1 g;
    public static final nq1 h;
    public static final nq1 i;
    public static final /* synthetic */ nq1[] j;

    static {
        nq1 nq1Var = new nq1("FIND_LOCATION_NOT_PERMITTED", 0);
        g = nq1Var;
        nq1 nq1Var2 = new nq1("LOCATION_SERVICE_IS_NOT_AVAILABLE", 1);
        h = nq1Var2;
        nq1 nq1Var3 = new nq1("Unknown", 2);
        i = nq1Var3;
        j = new nq1[]{nq1Var, nq1Var2, nq1Var3};
    }

    public static nq1 valueOf(String str) {
        return (nq1) Enum.valueOf(nq1.class, str);
    }

    public static nq1[] values() {
        return (nq1[]) j.clone();
    }
}
