package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class w01 {
    public static final w01 g;
    public static final w01 h;
    public static final w01 i;
    public static final /* synthetic */ w01[] j;

    static {
        w01 w01Var = new w01("SMALL", 0);
        g = w01Var;
        w01 w01Var2 = new w01("INACTIVE", 1);
        h = w01Var2;
        w01 w01Var3 = new w01("ACTIVE", 2);
        i = w01Var3;
        j = new w01[]{w01Var, w01Var2, w01Var3};
    }

    public static w01 valueOf(String str) {
        return (w01) Enum.valueOf(w01.class, str);
    }

    public static w01[] values() {
        return (w01[]) j.clone();
    }
}
