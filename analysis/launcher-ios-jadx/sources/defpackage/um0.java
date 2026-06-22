package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class um0 {
    private static final /* synthetic */ um0[] $VALUES;
    public static final sm0 Companion;
    public static final um0 ON_ANY;
    public static final um0 ON_CREATE;
    public static final um0 ON_DESTROY;
    public static final um0 ON_PAUSE;
    public static final um0 ON_RESUME;
    public static final um0 ON_START;
    public static final um0 ON_STOP;

    static {
        um0 um0Var = new um0("ON_CREATE", 0);
        ON_CREATE = um0Var;
        um0 um0Var2 = new um0("ON_START", 1);
        ON_START = um0Var2;
        um0 um0Var3 = new um0("ON_RESUME", 2);
        ON_RESUME = um0Var3;
        um0 um0Var4 = new um0("ON_PAUSE", 3);
        ON_PAUSE = um0Var4;
        um0 um0Var5 = new um0("ON_STOP", 4);
        ON_STOP = um0Var5;
        um0 um0Var6 = new um0("ON_DESTROY", 5);
        ON_DESTROY = um0Var6;
        um0 um0Var7 = new um0("ON_ANY", 6);
        ON_ANY = um0Var7;
        $VALUES = new um0[]{um0Var, um0Var2, um0Var3, um0Var4, um0Var5, um0Var6, um0Var7};
        Companion = new sm0();
    }

    public static um0 valueOf(String str) {
        return (um0) Enum.valueOf(um0.class, str);
    }

    public static um0[] values() {
        return (um0[]) $VALUES.clone();
    }

    public final vm0 a() {
        switch (tm0.a[ordinal()]) {
            case 1:
            case 2:
                return vm0.i;
            case 3:
            case 4:
                return vm0.j;
            case 5:
                return vm0.k;
            case 6:
                return vm0.g;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
