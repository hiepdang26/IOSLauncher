package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class cv1 {
    public static final cv1 g;
    public static final /* synthetic */ cv1[] h;

    /* JADX INFO: Fake field, exist only in values array */
    cv1 EF2;

    static {
        cv1 cv1Var = new cv1("FAHRENHEIT", 0);
        cv1 cv1Var2 = new cv1("CELSIUS", 1);
        g = cv1Var2;
        h = new cv1[]{cv1Var, cv1Var2};
    }

    public static cv1 valueOf(String str) {
        return (cv1) Enum.valueOf(cv1.class, str);
    }

    public static cv1[] values() {
        return (cv1[]) h.clone();
    }
}
