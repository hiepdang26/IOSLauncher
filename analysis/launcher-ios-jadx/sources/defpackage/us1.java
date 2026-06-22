package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class us1 {
    public static final md u = new md(5);
    public int a;
    public int b;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public VelocityTracker k;
    public final float l;
    public float m;
    public final int n;
    public final OverScroller o;
    public final ow1 p;
    public View q;
    public boolean r;
    public final sh1 s;
    public int c = -1;
    public final fl0 t = new fl0(this, 17);

    public us1(Context context, sh1 sh1Var, Interpolator interpolator, ow1 ow1Var) {
        this.s = sh1Var;
        this.p = ow1Var;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.n = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.l = viewConfiguration.getScaledMaximumFlingVelocity();
        this.m = viewConfiguration.getScaledMinimumFlingVelocity();
        this.o = new OverScroller(context, interpolator == null ? u : interpolator);
    }

    public final void a() {
        b();
        if (this.a == 2) {
            OverScroller overScroller = this.o;
            overScroller.getCurrX();
            overScroller.getCurrY();
            overScroller.abortAnimation();
            overScroller.getCurrX();
            this.p.t(overScroller.getCurrY(), this.q);
        }
        l(0);
    }

    public final void b() {
        this.c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
        }
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.k = null;
        }
    }

    public final void c(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            return;
        }
        fArr[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
    }

    public final int d(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        float width = this.s.getWidth() / 2;
        float fSin = (((float) Math.sin((float) (((double) (Math.min(1.0f, Math.abs(i) / r0) - 0.5f)) * 0.4712389167638204d))) * width) + width;
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(float r9) {
        /*
            r8 = this;
            r0 = 1
            r8.r = r0
            android.view.View r1 = r8.q
            ow1 r2 = r8.p
            java.util.Objects.toString(r1)
            java.lang.Object r2 = r2.h
            sh1 r2 = (defpackage.sh1) r2
            boolean r3 = r2.n
            if (r3 == 0) goto L13
            float r9 = -r9
        L13:
            r3 = 0
            int r4 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r4 <= 0) goto L25
            float r5 = r2.z
            float r6 = r2.B
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L25
            int r9 = r2.b(r6)
            goto L77
        L25:
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r4 <= 0) goto L36
            float r4 = r2.z
            float r6 = r2.B
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L36
            int r9 = r2.b(r5)
            goto L77
        L36:
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L47
            float r4 = r2.z
            float r6 = r2.B
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L47
            int r9 = r2.b(r6)
            goto L77
        L47:
            if (r9 >= 0) goto L56
            float r9 = r2.z
            float r4 = r2.B
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 >= 0) goto L56
            int r9 = r2.b(r3)
            goto L77
        L56:
            float r9 = r2.z
            float r4 = r2.B
            float r6 = r4 + r5
            r7 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r7
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 < 0) goto L68
            int r9 = r2.b(r5)
            goto L77
        L68:
            float r5 = r4 / r7
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 < 0) goto L73
            int r9 = r2.b(r4)
            goto L77
        L73:
            int r9 = r2.b(r3)
        L77:
            us1 r3 = r2.L
            if (r3 == 0) goto La1
            int r1 = r1.getLeft()
            boolean r4 = r3.r
            if (r4 == 0) goto L99
            android.view.VelocityTracker r4 = r3.k
            int r5 = r3.c
            float r4 = r4.getXVelocity(r5)
            int r4 = (int) r4
            android.view.VelocityTracker r5 = r3.k
            int r6 = r3.c
            float r5 = r5.getYVelocity(r6)
            int r5 = (int) r5
            r3.g(r1, r9, r4, r5)
            goto La1
        L99:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased"
            r9.<init>(r0)
            throw r9
        La1:
            r2.invalidate()
            r9 = 0
            r8.r = r9
            int r1 = r8.a
            if (r1 != r0) goto Lae
            r8.l(r9)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.us1.e(float):void");
    }

    public final View f(int i, int i2) {
        sh1 sh1Var = this.s;
        for (int childCount = sh1Var.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = sh1Var.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean g(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.q.getLeft();
        int top = this.q.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.o;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            l(0);
            return false;
        }
        View view = this.q;
        int i7 = (int) this.m;
        int i8 = (int) this.l;
        int iAbs = Math.abs(i3);
        if (iAbs < i7) {
            i3 = 0;
        } else if (iAbs > i8) {
            i3 = i3 > 0 ? i8 : -i8;
        }
        int i9 = (int) this.m;
        int iAbs2 = Math.abs(i4);
        if (iAbs2 < i9) {
            i4 = 0;
        } else if (iAbs2 > i8) {
            i4 = i4 > 0 ? i8 : -i8;
        }
        int iAbs3 = Math.abs(i5);
        int iAbs4 = Math.abs(i6);
        int iAbs5 = Math.abs(i3);
        int iAbs6 = Math.abs(i4);
        int i10 = iAbs5 + iAbs6;
        int i11 = iAbs3 + iAbs4;
        if (i3 != 0) {
            f = iAbs5;
            f2 = i10;
        } else {
            f = iAbs3;
            f2 = i11;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = iAbs6;
            f4 = i10;
        } else {
            f3 = iAbs4;
            f4 = i11;
        }
        float f6 = f3 / f4;
        ow1 ow1Var = this.p;
        int iD = d(i5, i3, 0);
        Objects.toString(view);
        overScroller.startScroll(left, top, i5, i6, (int) ((d(i6, i4, ((sh1) ow1Var.h).A) * f6) + (iD * f5)));
        l(2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.us1.h(android.view.MotionEvent):void");
    }

    public final void i() {
        VelocityTracker velocityTracker = this.k;
        float f = this.l;
        velocityTracker.computeCurrentVelocity(zzbbc.zzq.zzf, f);
        Math.abs(this.k.getXVelocity(this.c));
        float yVelocity = this.k.getYVelocity(this.c);
        float f2 = this.m;
        float fAbs = Math.abs(yVelocity);
        if (fAbs < f2) {
            f = 0.0f;
        } else if (fAbs <= f) {
            f = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f = -f;
        }
        e(f);
    }

    public final void j(int i, float f, float f2) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr9 = this.d;
        this.f[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.e;
        this.g[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.h;
        int i3 = (int) f;
        int i4 = (int) f2;
        sh1 sh1Var = this.s;
        int left = sh1Var.getLeft();
        int i5 = this.n;
        int i6 = i3 < left + i5 ? 1 : 0;
        if (i4 < sh1Var.getTop() + i5) {
            i6 |= 4;
        }
        if (i3 > sh1Var.getRight() - i5) {
            i6 |= 2;
        }
        if (i4 > sh1Var.getBottom() - i5) {
            i6 |= 8;
        }
        iArr7[i] = i6;
    }

    public final void k(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            float[] fArr2 = this.f;
            if (fArr2 != null && (fArr = this.g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public final void l(int i) {
        if (this.a != i) {
            this.a = i;
            sh1 sh1Var = (sh1) this.p.h;
            us1 us1Var = sh1Var.L;
            if (us1Var != null && us1Var.a == 0) {
                sh1Var.z = sh1Var.c(sh1Var.v.getTop());
                if (sh1Var.m > 0) {
                    sh1Var.w.setTranslationY(sh1Var.getCurrentParallaxOffset());
                }
                float f = sh1Var.z;
                if (f == 1.0f) {
                    sh1Var.h();
                    sh1Var.setPanelStateInternal(rh1.g);
                } else if (f == 0.0f) {
                    sh1Var.setPanelStateInternal(rh1.h);
                } else if (f < 0.0f) {
                    sh1Var.setPanelStateInternal(rh1.j);
                    sh1Var.v.setVisibility(4);
                } else {
                    sh1Var.h();
                    sh1Var.setPanelStateInternal(rh1.i);
                }
            }
            if (this.a == 0) {
                this.q = null;
            }
        }
    }

    public final boolean m(int i, View view) {
        if (view == this.q && this.c == i) {
            return true;
        }
        if (view != null) {
            ow1 ow1Var = this.p;
            Objects.toString(view);
            sh1 sh1Var = (sh1) ow1Var.h;
            if (!sh1Var.C && view == sh1Var.v) {
                this.c = i;
                ViewParent parent = view.getParent();
                sh1 sh1Var2 = this.s;
                if (parent != sh1Var2) {
                    throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + sh1Var2 + ")");
                }
                this.q = view;
                this.c = i;
                Objects.toString(view);
                int childCount = sh1Var.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = sh1Var.getChildAt(i2);
                    if (childAt.getVisibility() == 4) {
                        childAt.setVisibility(0);
                    }
                }
                l(1);
                return true;
            }
        }
        return false;
    }
}
