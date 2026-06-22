package defpackage;

import android.graphics.Color;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l11 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;
    public int g;
    public int h;
    public float[] i;

    public l11(int i, int i2) {
        this.a = Color.red(i);
        this.b = Color.green(i);
        this.c = Color.blue(i);
        this.d = i;
        this.e = i2;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        int i = this.d;
        int iE = ik.e(4.5f, -1, i);
        int iE2 = ik.e(3.0f, -1, i);
        if (iE != -1 && iE2 != -1) {
            this.h = ik.h(-1, iE);
            this.g = ik.h(-1, iE2);
            this.f = true;
            return;
        }
        int iE3 = ik.e(4.5f, -16777216, i);
        int iE4 = ik.e(3.0f, -16777216, i);
        if (iE3 == -1 || iE4 == -1) {
            this.h = iE != -1 ? ik.h(-1, iE) : ik.h(-16777216, iE3);
            this.g = iE2 != -1 ? ik.h(-1, iE2) : ik.h(-16777216, iE4);
            this.f = true;
        } else {
            this.h = ik.h(-16777216, iE3);
            this.g = ik.h(-16777216, iE4);
            this.f = true;
        }
    }

    public final float[] b() {
        if (this.i == null) {
            this.i = new float[3];
        }
        ik.a(this.a, this.b, this.c, this.i);
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l11.class == obj.getClass()) {
            l11 l11Var = (l11) obj;
            if (this.e == l11Var.e && this.d == l11Var.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.d * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(l11.class.getSimpleName());
        sb.append(" [RGB: #");
        sb.append(Integer.toHexString(this.d));
        sb.append("] [HSL: ");
        sb.append(Arrays.toString(b()));
        sb.append("] [Population: ");
        sb.append(this.e);
        sb.append("] [Title Text: #");
        a();
        sb.append(Integer.toHexString(this.g));
        sb.append("] [Body Text: #");
        a();
        sb.append(Integer.toHexString(this.h));
        sb.append(']');
        return sb.toString();
    }
}
