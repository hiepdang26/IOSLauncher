package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class hp {
    public static final hp g;
    public static final /* synthetic */ hp[] h;

    static {
        hp hpVar = new hp("COROUTINE_SUSPENDED", 0);
        g = hpVar;
        h = new hp[]{hpVar, new hp("UNDECIDED", 1), new hp("RESUMED", 2)};
    }

    public static hp valueOf(String str) {
        return (hp) Enum.valueOf(hp.class, str);
    }

    public static hp[] values() {
        return (hp[]) h.clone();
    }
}
