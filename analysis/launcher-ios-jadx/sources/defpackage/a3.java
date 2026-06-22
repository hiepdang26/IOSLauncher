package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class a3 {
    public static final a3 g;
    public static final a3 h;
    public static final /* synthetic */ a3[] i;

    static {
        a3 a3Var = new a3("NOT_READY", 0);
        g = a3Var;
        a3 a3Var2 = new a3("READY", 1);
        h = a3Var2;
        i = new a3[]{a3Var, a3Var2};
    }

    public static a3 valueOf(String str) {
        return (a3) Enum.valueOf(a3.class, str);
    }

    public static a3[] values() {
        return (a3[]) i.clone();
    }
}
