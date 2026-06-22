package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class tw {
    public static final tw g;
    public static final tw h;
    public static final tw i;
    public static final /* synthetic */ tw[] j;

    static {
        tw twVar = new tw("DRAG", 0);
        g = twVar;
        tw twVar2 = new tw("OPEN", 1);
        h = twVar2;
        tw twVar3 = new tw("CLOSE", 2);
        i = twVar3;
        j = new tw[]{twVar, twVar2, twVar3};
    }

    public static tw valueOf(String str) {
        return (tw) Enum.valueOf(tw.class, str);
    }

    public static tw[] values() {
        return (tw[]) j.clone();
    }
}
