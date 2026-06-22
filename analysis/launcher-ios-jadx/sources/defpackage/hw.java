package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class hw {
    public static final hw b = new hw(2);
    public static final hw c = new hw(0);
    public static final hw d;
    public static final hw e;
    public static final hw f;
    public static final e01 g;
    public static final boolean h;
    public final /* synthetic */ int a;

    static {
        hw hwVar = new hw(1);
        d = hwVar;
        e = new hw(3);
        f = hwVar;
        g = e01.a(hwVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        h = true;
    }

    public /* synthetic */ hw(int i) {
        this.a = i;
    }

    public final int a(int i, int i2, int i3, int i4) {
        switch (this.a) {
            case 0:
                if (b(i, i2, i3, i4) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i, int i2, int i3, int i4) {
        switch (this.a) {
            case 0:
                return Math.min(1.0f, b.b(i, i2, i3, i4));
            case 1:
                return Math.max(i3 / i, i4 / i2);
            case 2:
                if (h) {
                    return Math.min(i3 / i, i4 / i2);
                }
                if (Math.max(i2 / i4, i / i3) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
