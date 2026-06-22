package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class rp {
    public static final rp g;
    public static final rp h;
    public static final /* synthetic */ rp[] i;

    static {
        rp rpVar = new rp("RECTANGLE", 0);
        g = rpVar;
        rp rpVar2 = new rp("OVAL", 1);
        h = rpVar2;
        i = new rp[]{rpVar, rpVar2};
    }

    public static rp valueOf(String str) {
        return (rp) Enum.valueOf(rp.class, str);
    }

    public static rp[] values() {
        return (rp[]) i.clone();
    }
}
