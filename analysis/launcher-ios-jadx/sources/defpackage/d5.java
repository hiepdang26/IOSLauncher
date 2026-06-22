package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.StateSet;

/* JADX INFO: loaded from: classes.dex */
public final class d5 extends Drawable.ConstantState {
    public boolean A;
    public ColorFilter B;
    public boolean C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public boolean F;
    public boolean G;
    public int[][] H;
    public xp0 I;
    public ji1 J;
    public final g5 a;
    public Resources b;
    public int c;
    public int d;
    public int e;
    public SparseArray f;
    public Drawable[] g;
    public int h;
    public boolean i;
    public boolean j;
    public Rect k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public int z;

    public d5(d5 d5Var, g5 g5Var, Resources resources) {
        this.i = false;
        this.l = false;
        this.w = true;
        this.y = 0;
        this.z = 0;
        this.a = g5Var;
        this.b = resources != null ? resources : d5Var != null ? d5Var.b : null;
        int i = d5Var != null ? d5Var.c : 0;
        int i2 = bx.s;
        i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
        i = i == 0 ? 160 : i;
        this.c = i;
        if (d5Var != null) {
            this.d = d5Var.d;
            this.e = d5Var.e;
            this.u = true;
            this.v = true;
            this.i = d5Var.i;
            this.l = d5Var.l;
            this.w = d5Var.w;
            this.x = d5Var.x;
            this.y = d5Var.y;
            this.z = d5Var.z;
            this.A = d5Var.A;
            this.B = d5Var.B;
            this.C = d5Var.C;
            this.D = d5Var.D;
            this.E = d5Var.E;
            this.F = d5Var.F;
            this.G = d5Var.G;
            if (d5Var.c == i) {
                if (d5Var.j) {
                    this.k = d5Var.k != null ? new Rect(d5Var.k) : null;
                    this.j = true;
                }
                if (d5Var.m) {
                    this.n = d5Var.n;
                    this.o = d5Var.o;
                    this.p = d5Var.p;
                    this.q = d5Var.q;
                    this.m = true;
                }
            }
            if (d5Var.r) {
                this.s = d5Var.s;
                this.r = true;
            }
            if (d5Var.t) {
                this.t = true;
            }
            Drawable[] drawableArr = d5Var.g;
            this.g = new Drawable[drawableArr.length];
            this.h = d5Var.h;
            SparseArray sparseArray = d5Var.f;
            if (sparseArray != null) {
                this.f = sparseArray.clone();
            } else {
                this.f = new SparseArray(this.h);
            }
            int i3 = this.h;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f.put(i4, constantState);
                    } else {
                        this.g[i4] = drawableArr[i4];
                    }
                }
            }
        } else {
            this.g = new Drawable[10];
            this.h = 0;
        }
        if (d5Var != null) {
            this.H = d5Var.H;
        } else {
            this.H = new int[this.g.length][];
        }
        if (d5Var != null) {
            this.I = d5Var.I;
            this.J = d5Var.J;
        } else {
            this.I = new xp0();
            this.J = new ji1();
        }
    }

    public final int a(Drawable drawable) {
        int i = this.h;
        if (i >= this.g.length) {
            int i2 = i + 10;
            Drawable[] drawableArr = new Drawable[i2];
            Drawable[] drawableArr2 = this.g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.g = drawableArr;
            int[][] iArr = new int[i2][];
            System.arraycopy(this.H, 0, iArr, 0, i);
            this.H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.a);
        this.g[i] = drawable;
        this.h++;
        this.e = drawable.getChangingConfigurations() | this.e;
        this.r = false;
        this.t = false;
        this.k = null;
        this.j = false;
        this.m = false;
        this.u = false;
        return i;
    }

    public final void b() {
        this.m = true;
        c();
        int i = this.h;
        Drawable[] drawableArr = this.g;
        this.o = -1;
        this.n = -1;
        this.q = 0;
        this.p = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.n) {
                this.n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.o) {
                this.o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.p) {
                this.p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.q) {
                this.q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = this.f.keyAt(i);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.valueAt(i);
                Drawable[] drawableArr = this.g;
                Drawable drawableNewDrawable = constantState.newDrawable(this.b);
                if (Build.VERSION.SDK_INT >= 23) {
                    az1.G(drawableNewDrawable, this.x);
                }
                Drawable drawableMutate = drawableNewDrawable.mutate();
                drawableMutate.setCallback(this.a);
                drawableArr[iKeyAt] = drawableMutate;
            }
            this.f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i = this.h;
        Drawable[] drawableArr = this.g;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.get(i2);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i) {
        int iIndexOfKey;
        Drawable drawable = this.g[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f.valueAt(iIndexOfKey)).newDrawable(this.b);
        if (Build.VERSION.SDK_INT >= 23) {
            az1.G(drawableNewDrawable, this.x);
        }
        Drawable drawableMutate = drawableNewDrawable.mutate();
        drawableMutate.setCallback(this.a);
        this.g[i] = drawableMutate;
        this.f.removeAt(iIndexOfKey);
        if (this.f.size() == 0) {
            this.f = null;
        }
        return drawableMutate;
    }

    public final int e(int i) {
        Object obj;
        if (i < 0) {
            return 0;
        }
        ji1 ji1Var = this.J;
        Object obj2 = 0;
        int iD = z71.d(ji1Var.g, ji1Var.i, i);
        if (iD >= 0 && (obj = ji1Var.h[iD]) != z71.d) {
            obj2 = obj;
        }
        return ((Integer) obj2).intValue();
    }

    public final int f(int[] iArr) {
        int[][] iArr2 = this.H;
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.d | this.e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new g5(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new g5(this, resources);
    }
}
