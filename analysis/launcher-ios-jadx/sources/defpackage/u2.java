package defpackage;

import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class u2 {
    public static final u2 h = new u2(320, 50, "320x50_mb");
    public static final u2 i;
    public static final u2 j;
    public final int a;
    public final int b;
    public final String c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;

    static {
        new u2(468, 60, "468x60_as");
        new u2(320, 100, "320x100_as");
        new u2(728, 90, "728x90_as");
        new u2(t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, 250, "300x250_as");
        new u2(160, 600, "160x600_as");
        new u2(-1, -2, "smart_banner");
        i = new u2(-3, -4, "fluid");
        j = new u2(0, 0, "invalid");
        new u2(50, 50, "50x50_mb");
        new u2(-3, 0, "search_v2");
    }

    public u2(int i2, int i3) {
        this(i2, i3, (i2 == -1 ? "FULL" : String.valueOf(i2)) + "x" + (i3 == -2 ? "AUTO" : String.valueOf(i3)) + "_as");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        return this.a == u2Var.a && this.b == u2Var.b && this.c.equals(u2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return this.c;
    }

    public u2(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException(k31.k(i2, "Invalid width for AdSize: "));
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            throw new IllegalArgumentException(k31.k(i3, "Invalid height for AdSize: "));
        }
        this.a = i2;
        this.b = i3;
        this.c = str;
    }
}
