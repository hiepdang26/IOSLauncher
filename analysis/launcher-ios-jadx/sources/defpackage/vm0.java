package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class vm0 {
    public static final vm0 g;
    public static final vm0 h;
    public static final vm0 i;
    public static final vm0 j;
    public static final vm0 k;
    public static final /* synthetic */ vm0[] l;

    static {
        vm0 vm0Var = new vm0("DESTROYED", 0);
        g = vm0Var;
        vm0 vm0Var2 = new vm0("INITIALIZED", 1);
        h = vm0Var2;
        vm0 vm0Var3 = new vm0("CREATED", 2);
        i = vm0Var3;
        vm0 vm0Var4 = new vm0("STARTED", 3);
        j = vm0Var4;
        vm0 vm0Var5 = new vm0("RESUMED", 4);
        k = vm0Var5;
        l = new vm0[]{vm0Var, vm0Var2, vm0Var3, vm0Var4, vm0Var5};
    }

    public static vm0 valueOf(String str) {
        return (vm0) Enum.valueOf(vm0.class, str);
    }

    public static vm0[] values() {
        return (vm0[]) l.clone();
    }
}
