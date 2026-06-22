package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class j01 extends wy {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j01(u81 u81Var, int i) {
        super(u81Var);
        this.d = i;
    }

    @Override // defpackage.wy
    public final int b(View view) {
        switch (this.d) {
            case 0:
                v81 v81Var = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.C(view) + ((ViewGroup.MarginLayoutParams) v81Var).rightMargin;
            default:
                v81 v81Var2 = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.y(view) + ((ViewGroup.MarginLayoutParams) v81Var2).bottomMargin;
        }
    }

    @Override // defpackage.wy
    public final int c(View view) {
        switch (this.d) {
            case 0:
                v81 v81Var = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                Rect rect = ((v81) view.getLayoutParams()).b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) v81Var).leftMargin + ((ViewGroup.MarginLayoutParams) v81Var).rightMargin;
            default:
                v81 v81Var2 = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.B(view) + ((ViewGroup.MarginLayoutParams) v81Var2).topMargin + ((ViewGroup.MarginLayoutParams) v81Var2).bottomMargin;
        }
    }

    @Override // defpackage.wy
    public final int d(View view) {
        switch (this.d) {
            case 0:
                v81 v81Var = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.B(view) + ((ViewGroup.MarginLayoutParams) v81Var).topMargin + ((ViewGroup.MarginLayoutParams) v81Var).bottomMargin;
            default:
                v81 v81Var2 = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                Rect rect = ((v81) view.getLayoutParams()).b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) v81Var2).leftMargin + ((ViewGroup.MarginLayoutParams) v81Var2).rightMargin;
        }
    }

    @Override // defpackage.wy
    public final int e(View view) {
        switch (this.d) {
            case 0:
                v81 v81Var = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.A(view) - ((ViewGroup.MarginLayoutParams) v81Var).leftMargin;
            default:
                v81 v81Var2 = (v81) view.getLayoutParams();
                ((u81) this.b).getClass();
                return u81.D(view) - ((ViewGroup.MarginLayoutParams) v81Var2).topMargin;
        }
    }

    @Override // defpackage.wy
    public final int f() {
        switch (this.d) {
            case 0:
                return ((u81) this.b).n;
            default:
                return ((u81) this.b).o;
        }
    }

    @Override // defpackage.wy
    public final int g() {
        switch (this.d) {
            case 0:
                u81 u81Var = (u81) this.b;
                return u81Var.n - u81Var.H();
            default:
                u81 u81Var2 = (u81) this.b;
                return u81Var2.o - u81Var2.F();
        }
    }

    @Override // defpackage.wy
    public final int h() {
        switch (this.d) {
            case 0:
                return ((u81) this.b).H();
            default:
                return ((u81) this.b).F();
        }
    }

    @Override // defpackage.wy
    public final int i() {
        switch (this.d) {
            case 0:
                return ((u81) this.b).l;
            default:
                return ((u81) this.b).m;
        }
    }

    @Override // defpackage.wy
    public final int j() {
        switch (this.d) {
            case 0:
                return ((u81) this.b).m;
            default:
                return ((u81) this.b).l;
        }
    }

    @Override // defpackage.wy
    public final int k() {
        switch (this.d) {
            case 0:
                return ((u81) this.b).G();
            default:
                return ((u81) this.b).I();
        }
    }

    @Override // defpackage.wy
    public final int l() {
        switch (this.d) {
            case 0:
                u81 u81Var = (u81) this.b;
                return (u81Var.n - u81Var.G()) - u81Var.H();
            default:
                u81 u81Var2 = (u81) this.b;
                return (u81Var2.o - u81Var2.I()) - u81Var2.F();
        }
    }

    @Override // defpackage.wy
    public final int m(View view) {
        switch (this.d) {
            case 0:
                u81 u81Var = (u81) this.b;
                Rect rect = (Rect) this.c;
                u81Var.M(view, rect);
                return rect.right;
            default:
                u81 u81Var2 = (u81) this.b;
                Rect rect2 = (Rect) this.c;
                u81Var2.M(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // defpackage.wy
    public final int n(View view) {
        switch (this.d) {
            case 0:
                u81 u81Var = (u81) this.b;
                Rect rect = (Rect) this.c;
                u81Var.M(view, rect);
                return rect.left;
            default:
                u81 u81Var2 = (u81) this.b;
                Rect rect2 = (Rect) this.c;
                u81Var2.M(view, rect2);
                return rect2.top;
        }
    }

    @Override // defpackage.wy
    public final void o(int i) {
        switch (this.d) {
            case 0:
                ((u81) this.b).Q(i);
                break;
            default:
                ((u81) this.b).R(i);
                break;
        }
    }
}
