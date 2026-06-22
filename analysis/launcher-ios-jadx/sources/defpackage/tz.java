package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class tz implements cw {
    public static final tz g;
    public static final /* synthetic */ tz[] h;

    static {
        tz tzVar = new tz("INSTANCE", 0);
        g = tzVar;
        h = new tz[]{tzVar, new tz("NEVER", 1)};
    }

    public static tz valueOf(String str) {
        return (tz) Enum.valueOf(tz.class, str);
    }

    public static tz[] values() {
        return (tz[]) h.clone();
    }

    @Override // defpackage.cw
    public final void b() {
    }
}
