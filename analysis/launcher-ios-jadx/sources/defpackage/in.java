package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class in {
    public static final in g;
    public static final in h;
    public static final in i;
    public static final in j;
    public static final /* synthetic */ in[] k;

    static {
        in inVar = new in("FIXED", 0);
        g = inVar;
        in inVar2 = new in("WRAP_CONTENT", 1);
        h = inVar2;
        in inVar3 = new in("MATCH_CONSTRAINT", 2);
        i = inVar3;
        in inVar4 = new in("MATCH_PARENT", 3);
        j = inVar4;
        k = new in[]{inVar, inVar2, inVar3, inVar4};
    }

    public static in valueOf(String str) {
        return (in) Enum.valueOf(in.class, str);
    }

    public static in[] values() {
        return (in[]) k.clone();
    }
}
