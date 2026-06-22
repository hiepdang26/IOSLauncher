package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class ps {
    public static final ps g;
    public static final ps h;
    public static final ps i;
    public static final /* synthetic */ ps[] j;

    static {
        ps psVar = new ps("PREFER_ARGB_8888", 0);
        g = psVar;
        ps psVar2 = new ps("PREFER_RGB_565", 1);
        h = psVar2;
        j = new ps[]{psVar, psVar2};
        i = psVar;
    }

    public static ps valueOf(String str) {
        return (ps) Enum.valueOf(ps.class, str);
    }

    public static ps[] values() {
        return (ps[]) j.clone();
    }
}
