package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
public class nm extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public final int C;
    public final int D;
    public float E;
    public float F;
    public String G;
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public float R;
    public float S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public int Z;
    public int a;
    public boolean a0;
    public int b;
    public boolean b0;
    public float c;
    public boolean c0;
    public final boolean d;
    public boolean d0;
    public int e;
    public boolean e0;
    public int f;
    public int f0;
    public int g;
    public int g0;
    public int h;
    public int h0;
    public int i;
    public int i0;
    public int j;
    public int j0;
    public int k;
    public int k0;
    public int l;
    public float l0;
    public int m;
    public int m0;
    public int n;
    public int n0;
    public int o;
    public float o0;
    public int p;
    public jn p0;
    public int q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public final int w;
    public int x;
    public final int y;
    public int z;

    public nm(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = -1;
        this.b = -1;
        this.c = -1.0f;
        this.d = true;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0.0f;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = RtlSpacingHelper.UNDEFINED;
        this.x = RtlSpacingHelper.UNDEFINED;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.z = RtlSpacingHelper.UNDEFINED;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.B = RtlSpacingHelper.UNDEFINED;
        this.C = RtlSpacingHelper.UNDEFINED;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.a0 = true;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.i0 = -1;
        this.j0 = RtlSpacingHelper.UNDEFINED;
        this.k0 = RtlSpacingHelper.UNDEFINED;
        this.l0 = 0.5f;
        this.p0 = new jn();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
            setMarginStart(marginLayoutParams.getMarginStart());
            setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (layoutParams instanceof nm) {
            nm nmVar = (nm) layoutParams;
            this.a = nmVar.a;
            this.b = nmVar.b;
            this.c = nmVar.c;
            this.d = nmVar.d;
            this.e = nmVar.e;
            this.f = nmVar.f;
            this.g = nmVar.g;
            this.h = nmVar.h;
            this.i = nmVar.i;
            this.j = nmVar.j;
            this.k = nmVar.k;
            this.l = nmVar.l;
            this.m = nmVar.m;
            this.n = nmVar.n;
            this.o = nmVar.o;
            this.p = nmVar.p;
            this.q = nmVar.q;
            this.r = nmVar.r;
            this.s = nmVar.s;
            this.t = nmVar.t;
            this.u = nmVar.u;
            this.v = nmVar.v;
            this.w = nmVar.w;
            this.x = nmVar.x;
            this.y = nmVar.y;
            this.z = nmVar.z;
            this.A = nmVar.A;
            this.B = nmVar.B;
            this.C = nmVar.C;
            this.D = nmVar.D;
            this.E = nmVar.E;
            this.F = nmVar.F;
            this.G = nmVar.G;
            this.H = nmVar.H;
            this.I = nmVar.I;
            this.J = nmVar.J;
            this.K = nmVar.K;
            this.W = nmVar.W;
            this.X = nmVar.X;
            this.L = nmVar.L;
            this.M = nmVar.M;
            this.N = nmVar.N;
            this.P = nmVar.P;
            this.O = nmVar.O;
            this.Q = nmVar.Q;
            this.R = nmVar.R;
            this.S = nmVar.S;
            this.T = nmVar.T;
            this.U = nmVar.U;
            this.V = nmVar.V;
            this.a0 = nmVar.a0;
            this.b0 = nmVar.b0;
            this.c0 = nmVar.c0;
            this.d0 = nmVar.d0;
            this.f0 = nmVar.f0;
            this.g0 = nmVar.g0;
            this.h0 = nmVar.h0;
            this.i0 = nmVar.i0;
            this.j0 = nmVar.j0;
            this.k0 = nmVar.k0;
            this.l0 = nmVar.l0;
            this.Y = nmVar.Y;
            this.Z = nmVar.Z;
            this.p0 = nmVar.p0;
        }
    }

    public final void a() {
        this.d0 = false;
        this.a0 = true;
        this.b0 = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.W) {
            this.a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i2 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i2 == -2 && this.X) {
            this.b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.a0 = false;
            if (i == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.W = true;
            }
        }
        if (i2 == 0 || i2 == -1) {
            this.b0 = false;
            if (i2 == 0 && this.M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.X = true;
            }
        }
        if (this.c == -1.0f && this.a == -1 && this.b == -1) {
            return;
        }
        this.d0 = true;
        this.a0 = true;
        this.b0 = true;
        if (!(this.p0 instanceof va0)) {
            this.p0 = new va0();
        }
        ((va0) this.p0).R(this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nm.resolveLayoutDirection(int):void");
    }

    public nm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1.0f;
        this.d = true;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0.0f;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = RtlSpacingHelper.UNDEFINED;
        this.x = RtlSpacingHelper.UNDEFINED;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.z = RtlSpacingHelper.UNDEFINED;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.B = RtlSpacingHelper.UNDEFINED;
        this.C = RtlSpacingHelper.UNDEFINED;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.a0 = true;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.i0 = -1;
        this.j0 = RtlSpacingHelper.UNDEFINED;
        this.k0 = RtlSpacingHelper.UNDEFINED;
        this.l0 = 0.5f;
        this.p0 = new jn();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j71.ConstraintLayout_Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = mm.a.get(index);
            switch (i2) {
                case 1:
                    this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                    this.p = resourceId;
                    if (resourceId == -1) {
                        this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.q);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, this.r) % 360.0f;
                    this.r = f;
                    if (f < 0.0f) {
                        this.r = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    this.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                    break;
                case 6:
                    this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                    break;
                case 7:
                    this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                    this.e = resourceId2;
                    if (resourceId2 == -1) {
                        this.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                    this.f = resourceId3;
                    if (resourceId3 == -1) {
                        this.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.g);
                    this.g = resourceId4;
                    if (resourceId4 == -1) {
                        this.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.h);
                    this.h = resourceId5;
                    if (resourceId5 == -1) {
                        this.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.i);
                    this.i = resourceId6;
                    if (resourceId6 == -1) {
                        this.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                    this.j = resourceId7;
                    if (resourceId7 == -1) {
                        this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.k);
                    this.k = resourceId8;
                    if (resourceId8 == -1) {
                        this.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                    this.l = resourceId9;
                    if (resourceId9 == -1) {
                        this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                    this.m = resourceId10;
                    if (resourceId10 == -1) {
                        this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                    this.s = resourceId11;
                    if (resourceId11 == -1) {
                        this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                    this.t = resourceId12;
                    if (resourceId12 == -1) {
                        this.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                    this.u = resourceId13;
                    if (resourceId13 == -1) {
                        this.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                    this.v = resourceId14;
                    if (resourceId14 == -1) {
                        this.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case zzbbc.zzt.zzm /* 21 */:
                    this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                    break;
                case 22:
                    this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                    break;
                case 23:
                    this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                    break;
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                    this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                    break;
                case 25:
                    this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                    break;
                case 26:
                    this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                    break;
                case 27:
                    this.W = typedArrayObtainStyledAttributes.getBoolean(index, this.W);
                    break;
                case 28:
                    this.X = typedArrayObtainStyledAttributes.getBoolean(index, this.X);
                    break;
                case 29:
                    this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                    break;
                case 30:
                    this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                    break;
                case 31:
                    this.L = typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 32:
                    this.M = typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 33:
                    try {
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                            this.N = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.P) == -2) {
                            this.P = -2;
                        }
                    }
                    break;
                case 35:
                    this.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.R));
                    this.L = 2;
                    break;
                case 36:
                    try {
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.O) == -2) {
                            this.O = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                            this.Q = -2;
                        }
                    }
                    break;
                case 38:
                    this.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.S));
                    this.M = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            en.q(typedArrayObtainStyledAttributes.getString(index), this);
                            break;
                        case 45:
                            this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                            break;
                        case 46:
                            this.I = typedArrayObtainStyledAttributes.getFloat(index, this.I);
                            break;
                        case 47:
                            this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                            break;
                        case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                            this.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                            break;
                        case 51:
                            this.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.n);
                            this.n = resourceId15;
                            if (resourceId15 == -1) {
                                this.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.o);
                            this.o = resourceId16;
                            if (resourceId16 == -1) {
                                this.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 55:
                            this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    en.p(this, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    en.p(this, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                    break;
                                case 67:
                                    this.d = typedArrayObtainStyledAttributes.getBoolean(index, this.d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public nm(int i, int i2) {
        super(i, i2);
        this.a = -1;
        this.b = -1;
        this.c = -1.0f;
        this.d = true;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0.0f;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = RtlSpacingHelper.UNDEFINED;
        this.x = RtlSpacingHelper.UNDEFINED;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.z = RtlSpacingHelper.UNDEFINED;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.B = RtlSpacingHelper.UNDEFINED;
        this.C = RtlSpacingHelper.UNDEFINED;
        this.D = 0;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = null;
        this.H = -1.0f;
        this.I = -1.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = null;
        this.Z = 0;
        this.a0 = true;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.i0 = -1;
        this.j0 = RtlSpacingHelper.UNDEFINED;
        this.k0 = RtlSpacingHelper.UNDEFINED;
        this.l0 = 0.5f;
        this.p0 = new jn();
    }
}
