package defpackage;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class xu {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public final boolean N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V = 0;
    public final boolean W;
    public final int X;
    public int Y;
    public int Z;
    public final xg0 a;
    public int a0;
    public final boolean b;
    public int b0;
    public final boolean c;
    public int c0;
    public final boolean d;
    public int d0;
    public final boolean e;
    public int e0;
    public final boolean f;
    public int f0;
    public final boolean g;
    public int g0;
    public final float h;
    public int h0;
    public final int i;
    public int i0;
    public final int j;
    public int j0;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final float r;
    public final int s;
    public final int t;
    public final Rect u;
    public int v;
    public final int w;
    public int x;
    public int y;
    public int z;

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xu(android.content.Context r17, defpackage.xg0 r18, android.graphics.Point r19, android.graphics.Point r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xu.<init>(android.content.Context, xg0, android.graphics.Point, android.graphics.Point, int, int, boolean):void");
    }

    public final int a() {
        boolean z = this.e;
        int i = this.k;
        int i2 = this.j;
        return z ? Math.min(i2, i) : Math.max(i2, i);
    }

    public final int b() {
        boolean z = this.e;
        int i = this.k;
        int i2 = this.j;
        return z ? Math.max(i2, i) : Math.min(i2, i);
    }

    public final Rect c() {
        Rect rect = new Rect();
        int i = this.a0 + this.d0 + this.g0 + this.j0;
        boolean z = this.b;
        int i2 = this.l;
        if (!z) {
            Rect rect2 = this.u;
            int i3 = rect2.left;
            int i4 = this.s;
            rect.set(i4 - i3, 0, i2 - (i4 - rect2.right), i);
            return rect;
        }
        int iB = b();
        int i5 = this.t;
        int i6 = this.a.d;
        int i7 = (((iB - (i5 * 2)) - (this.H * i6)) / ((i6 + 1) * 2)) + i5;
        rect.set(i7, 0, i2 - i7, i);
        return rect;
    }

    public final Rect d() {
        int i;
        c();
        Rect rect = new Rect();
        boolean z = this.N;
        if (!this.b || this.e) {
            int i2 = this.U;
            int i3 = this.v;
            int i4 = i2 + i3 + (z ? this.O : 0);
            boolean z2 = this.g;
            if (this.f) {
                i3 = (int) ((((double) this.h) + (z2 ? 2.2d : 2.0d)) * ((double) this.C));
            } else if (!z2) {
                i3 = 0;
            }
            i = i3 + i4;
        } else {
            int iA = a();
            int i5 = this.D;
            int i6 = this.a.c;
            i = this.U + this.v + ((iA - (i5 * i6)) / (i6 + 3)) + (z ? this.O : 0);
        }
        rect.set(0, 0, 0, i);
        return rect;
    }

    public final void e(int i) {
        if (i == 1) {
            this.U = this.T;
            this.j0 = this.i0;
            this.g0 = this.f0;
            this.d0 = this.d ? this.b0 : this.c0;
            return;
        }
        this.U = this.S;
        this.j0 = this.h0;
        this.g0 = this.e0;
        this.d0 = this.c0;
    }

    public final void f(int i, Resources resources) {
        xg0 xg0Var = this.a;
        this.D = xg0Var.h;
        int iB = b();
        int i2 = this.D;
        int i3 = (iB - (i2 * 4)) / 10;
        this.C = i3;
        int i4 = (i3 * 4) + (i2 * 3);
        this.y = i4;
        this.x = i4;
        this.E = i2 / 5;
        int iB2 = b() / 15;
        this.z = iB2;
        this.A = iB2 / 3;
        float f = this.E;
        Paint paint = new Paint();
        paint.setTypeface(Typeface.createFromAsset(resources.getAssets(), "fonts/SFProTextMedium.otf"));
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.F = (int) ((-fontMetrics.top) + fontMetrics.bottom);
        this.G = i;
        this.R = this.D;
        this.V = (int) (((double) this.C) / 3.9d);
        this.h0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_height);
        this.i0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_height_tall);
        this.Y = resources.getDimensionPixelSize(e51.qsb_internal_padding_top);
        this.Z = resources.getDimensionPixelSize(e51.qsb_internal_padding_bottom);
        this.c0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_extra_top_padding);
        this.b0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_negative_top_padding_short);
        boolean z = this.b;
        if (z) {
            this.a0 = this.Y;
            int dimensionPixelSize = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_bottom_padding_tablet) + this.Z;
            this.e0 = dimensionPixelSize;
            this.f0 = dimensionPixelSize;
        } else {
            this.a0 = this.Y;
            this.e0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_bottom_padding) + this.Z;
            this.f0 = resources.getDimensionPixelSize(e51.dynamic_grid_search_bar_bottom_negative_padding_short) + this.Z;
        }
        resources.getDimensionPixelSize(e51.dragViewScale);
        int i5 = this.D;
        double d = (((double) this.z) * 0.8d) + ((double) (this.F + i5));
        int i6 = this.V;
        int i7 = (int) (((double) (i6 * 2)) + d);
        this.S = i7;
        this.T = (int) d;
        this.v = (int) (i7 / 3.3f);
        this.P = i5;
        this.Q = i5;
        this.O = this.C - i6;
        this.H = (b() - (this.C * 2)) / xg0Var.d;
        int iA = a();
        int i8 = this.v;
        int i9 = iA - i8;
        boolean z2 = this.g;
        boolean z3 = this.f;
        int i10 = (((((i9 - ((z3 && z2) ? this.O : 0)) - this.U) - (this.N ? this.O : 0)) - this.i) - ((!xg0Var.w || xg0Var.x) ? 0 : xg0Var.y)) - (z3 ? this.C : 0);
        if (z3) {
            i8 = (int) ((((double) this.h) + (z2 ? 2.2d : 2.0d)) * ((double) this.C));
        } else if (!z2) {
            i8 = 0;
        }
        int i11 = (i10 - i8) / xg0Var.c;
        this.I = i11;
        int i12 = this.D;
        this.B = (int) (((double) i12) * 0.45d);
        int i13 = this.H;
        if (z) {
            i13 = (int) (((double) i13) * 1.2d);
        }
        this.K = i13;
        if (z) {
            i11 = (int) (((double) i11) * 1.2d);
        }
        this.L = i11;
        this.J = i12;
        float f2 = this.E;
        Rect rect = ar1.a;
        Paint paint2 = new Paint();
        paint2.setTextSize(f2);
        Paint.FontMetrics fontMetrics2 = paint2.getFontMetrics();
        this.M = (this.C * 2) - ((this.L - this.J) - Math.round((-fontMetrics2.top) + fontMetrics2.bottom));
    }
}
