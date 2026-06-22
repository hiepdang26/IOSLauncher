package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class sp {
    public static final sp g;
    public static final sp h;
    public static final /* synthetic */ sp[] i;

    /* JADX INFO: Fake field, exist only in values array */
    sp EF3;

    static {
        sp spVar = new sp("OFF", 0);
        sp spVar2 = new sp("ON_TOUCH", 1);
        g = spVar2;
        sp spVar3 = new sp("ON", 2);
        h = spVar3;
        i = new sp[]{spVar, spVar2, spVar3};
    }

    public static sp valueOf(String str) {
        return (sp) Enum.valueOf(sp.class, str);
    }

    public static sp[] values() {
        return (sp[]) i.clone();
    }
}
