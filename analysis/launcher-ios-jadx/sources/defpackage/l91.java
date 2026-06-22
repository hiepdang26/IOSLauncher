package defpackage;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l91 implements Runnable {
    public int g;
    public int h;
    public OverScroller i;
    public Interpolator j;
    public boolean k;
    public boolean l;
    public final /* synthetic */ RecyclerView m;

    public l91(RecyclerView recyclerView) {
        this.m = recyclerView;
        md mdVar = RecyclerView.O0;
        this.j = mdVar;
        this.k = false;
        this.l = false;
        this.i = new OverScroller(recyclerView.getContext(), mdVar);
    }

    public final void a(int i, int i2) {
        RecyclerView recyclerView = this.m;
        recyclerView.setScrollState(2);
        this.h = 0;
        this.g = 0;
        Interpolator interpolator = this.j;
        md mdVar = RecyclerView.O0;
        if (interpolator != mdVar) {
            this.j = mdVar;
            this.i = new OverScroller(recyclerView.getContext(), mdVar);
        }
        this.i.fling(0, 0, i, i2, RtlSpacingHelper.UNDEFINED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, RtlSpacingHelper.UNDEFINED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        b();
    }

    public final void b() {
        if (this.k) {
            this.l = true;
            return;
        }
        RecyclerView recyclerView = this.m;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = qs1.a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i, int i2, int i3, Interpolator interpolator) {
        RecyclerView recyclerView = this.m;
        if (i3 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.O0;
        }
        if (this.j != interpolator) {
            this.j = interpolator;
            this.i = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.h = 0;
        this.g = 0;
        recyclerView.setScrollState(2);
        this.i.startScroll(0, 0, i, i2, i4);
        if (Build.VERSION.SDK_INT < 23) {
            this.i.computeScrollOffset();
        }
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        RecyclerView recyclerView = this.m;
        if (recyclerView.t == null) {
            recyclerView.removeCallbacks(this);
            this.i.abortAnimation();
            return;
        }
        this.l = false;
        this.k = true;
        recyclerView.r();
        OverScroller overScroller = this.i;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i5 = currX - this.g;
            int i6 = currY - this.h;
            this.g = currX;
            this.h = currY;
            int iQ = RecyclerView.q(i5, recyclerView.O, recyclerView.Q, recyclerView.getWidth());
            int iQ2 = RecyclerView.q(i6, recyclerView.P, recyclerView.R, recyclerView.getHeight());
            int[] iArr = recyclerView.z0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean zY = recyclerView.y(iQ, iQ2, 1, iArr, null);
            int[] iArr2 = recyclerView.z0;
            if (zY) {
                iQ -= iArr2[0];
                iQ2 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.p(iQ, iQ2);
            }
            if (recyclerView.s != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.k0(iArr2, iQ, iQ2);
                int i7 = iArr2[0];
                int i8 = iArr2[1];
                int i9 = iQ - i7;
                int i10 = iQ2 - i8;
                pn0 pn0Var = recyclerView.t.e;
                if (pn0Var != null && !pn0Var.d && pn0Var.e) {
                    int iB = recyclerView.n0.b();
                    if (iB == 0) {
                        pn0Var.g();
                    } else if (pn0Var.a >= iB) {
                        pn0Var.a = iB - 1;
                        pn0Var.e(i7, i8);
                    } else {
                        pn0Var.e(i7, i8);
                    }
                }
                i = i9;
                i3 = i7;
                i2 = i10;
                i4 = i8;
            } else {
                i = iQ;
                i2 = iQ2;
                i3 = 0;
                i4 = 0;
            }
            if (!recyclerView.v.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.z0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.z(i3, i4, i, i2, null, 1, iArr3);
            int i11 = i - iArr2[0];
            int i12 = i2 - iArr2[1];
            if (i3 != 0 || i4 != 0) {
                recyclerView.A(i3, i4);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
            pn0 pn0Var2 = recyclerView.t.e;
            if ((pn0Var2 == null || !pn0Var2.d) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                    if (i12 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i12 <= 0) {
                        currVelocity = 0;
                    }
                    if (i13 < 0) {
                        recyclerView.C();
                        if (recyclerView.O.isFinished()) {
                            recyclerView.O.onAbsorb(-i13);
                        }
                    } else if (i13 > 0) {
                        recyclerView.D();
                        if (recyclerView.Q.isFinished()) {
                            recyclerView.Q.onAbsorb(i13);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.E();
                        if (recyclerView.P.isFinished()) {
                            recyclerView.P.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.B();
                        if (recyclerView.R.isFinished()) {
                            recyclerView.R.onAbsorb(currVelocity);
                        }
                    }
                    if (i13 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = qs1.a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.M0) {
                    c80 c80Var = recyclerView.m0;
                    int[] iArr4 = (int[]) c80Var.d;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    c80Var.c = 0;
                }
            } else {
                b();
                e80 e80Var = recyclerView.l0;
                if (e80Var != null) {
                    e80Var.a(recyclerView, i3, i4);
                }
            }
        }
        pn0 pn0Var3 = recyclerView.t.e;
        if (pn0Var3 != null && pn0Var3.d) {
            pn0Var3.e(0, 0);
        }
        this.k = false;
        if (!this.l) {
            recyclerView.setScrollState(0);
            recyclerView.r0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = qs1.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
