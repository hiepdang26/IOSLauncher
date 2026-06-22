package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class yp {
    public static final yp g;
    public static final yp h;
    public static final /* synthetic */ yp[] i;

    static {
        yp ypVar = new yp("FIT_CENTER", 0);
        g = ypVar;
        yp ypVar2 = new yp("CENTER", 1);
        yp ypVar3 = new yp("CENTER_CROP", 2);
        yp ypVar4 = new yp("CENTER_INSIDE", 3);
        h = ypVar4;
        i = new yp[]{ypVar, ypVar2, ypVar3, ypVar4};
    }

    public static yp valueOf(String str) {
        return (yp) Enum.valueOf(yp.class, str);
    }

    public static yp[] values() {
        return (yp[]) i.clone();
    }
}
