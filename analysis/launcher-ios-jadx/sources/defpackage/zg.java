package defpackage;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class zg extends ViewGroup.MarginLayoutParams {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;

    public zg(int i, int i2, int i3, int i4) {
        super(-1, -1);
        this.h = true;
        this.i = false;
        this.j = true;
        this.a = i;
        this.b = i2;
        this.f = i3;
        this.g = i4;
    }

    public final void a(boolean z, int i, int i2, int i3) {
        if (this.h) {
            int i4 = this.f;
            int i5 = this.g;
            boolean z2 = this.e;
            int i6 = z2 ? this.c : this.a;
            int i7 = z2 ? this.d : this.b;
            if (z) {
                i6 = (i3 - i6) - i4;
            }
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            ((ViewGroup.MarginLayoutParams) this).width = ((i4 * i) - i8) - ((ViewGroup.MarginLayoutParams) this).rightMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).topMargin;
            ((ViewGroup.MarginLayoutParams) this).height = ((i5 * i2) - i9) - ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            this.k = (i * i6) + i8;
            this.l = (i2 * i7) + i9;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.a);
        sb.append(", ");
        return uo.j(sb, this.b, ")");
    }
}
