package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r20 extends s81 implements y81 {
    public static final int[] I = {R.attr.state_pressed};
    public static final int[] J = new int[0];
    public final ValueAnimator F;
    public int G;
    public final o1 H;
    public final int g;
    public final int h;
    public final StateListDrawable i;
    public final Drawable j;
    public final int k;
    public final int l;
    public final StateListDrawable m;
    public final Drawable n;
    public final int o;
    public final int p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public float v;
    public final RecyclerView y;
    public int w = 0;
    public int x = 0;
    public boolean z = false;
    public boolean A = false;
    public int B = 0;
    public int C = 0;
    public final int[] D = new int[2];
    public final int[] E = new int[2];

    public r20(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F = valueAnimatorOfFloat;
        this.G = 0;
        o1 o1Var = new o1(this, 20);
        this.H = o1Var;
        hb hbVar = new hb(this, 3);
        this.i = stateListDrawable;
        this.j = drawable;
        this.m = stateListDrawable2;
        this.n = drawable2;
        this.k = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.l = Math.max(i, drawable.getIntrinsicWidth());
        this.o = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.p = Math.max(i, drawable2.getIntrinsicWidth());
        this.g = i2;
        this.h = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new zc(this));
        valueAnimatorOfFloat.addUpdateListener(new q7(this, 8));
        RecyclerView recyclerView2 = this.y;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.g0(this);
            RecyclerView recyclerView3 = this.y;
            recyclerView3.w.remove(this);
            if (recyclerView3.x == this) {
                recyclerView3.x = null;
            }
            ArrayList arrayList = this.y.p0;
            if (arrayList != null) {
                arrayList.remove(hbVar);
            }
            this.y.removeCallbacks(o1Var);
        }
        this.y = recyclerView;
        if (recyclerView != null) {
            recyclerView.k(this);
            this.y.w.add(this);
            this.y.l(hbVar);
        }
    }

    public static int k(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 != 0) {
            int i5 = i - i3;
            int i6 = (int) (((f2 - f) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 < i5 && i7 >= 0) {
                return i6;
            }
        }
        return 0;
    }

    @Override // defpackage.y81
    public final void b(MotionEvent motionEvent) {
        if (this.B == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zJ = j(motionEvent.getX(), motionEvent.getY());
            boolean zI = i(motionEvent.getX(), motionEvent.getY());
            if (zJ || zI) {
                if (zI) {
                    this.C = 1;
                    this.v = (int) motionEvent.getX();
                } else if (zJ) {
                    this.C = 2;
                    this.s = (int) motionEvent.getY();
                }
                l(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.B == 2) {
            this.s = 0.0f;
            this.v = 0.0f;
            l(1);
            this.C = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.B == 2) {
            m();
            int i = this.C;
            int i2 = this.h;
            if (i == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.E;
                iArr[0] = i2;
                int i3 = this.w - i2;
                iArr[1] = i3;
                float fMax = Math.max(i2, Math.min(i3, x));
                if (Math.abs(this.u - fMax) >= 2.0f) {
                    int iK = k(this.v, fMax, iArr, this.y.computeHorizontalScrollRange(), this.y.computeHorizontalScrollOffset(), this.w);
                    if (iK != 0) {
                        this.y.scrollBy(iK, 0);
                    }
                    this.v = fMax;
                }
            }
            if (this.C == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.D;
                iArr2[0] = i2;
                int i4 = this.x - i2;
                iArr2[1] = i4;
                float fMax2 = Math.max(i2, Math.min(i4, y));
                if (Math.abs(this.r - fMax2) < 2.0f) {
                    return;
                }
                int iK2 = k(this.s, fMax2, iArr2, this.y.computeVerticalScrollRange(), this.y.computeVerticalScrollOffset(), this.x);
                if (iK2 != 0) {
                    this.y.scrollBy(0, iK2);
                }
                this.s = fMax2;
            }
        }
    }

    @Override // defpackage.y81
    public final boolean c(MotionEvent motionEvent) {
        int i = this.B;
        if (i != 1) {
            return i == 2;
        }
        boolean zJ = j(motionEvent.getX(), motionEvent.getY());
        boolean zI = i(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!zJ && !zI) {
            return false;
        }
        if (zI) {
            this.C = 1;
            this.v = (int) motionEvent.getX();
        } else if (zJ) {
            this.C = 2;
            this.s = (int) motionEvent.getY();
        }
        l(2);
        return true;
    }

    @Override // defpackage.s81
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        int i = this.w;
        RecyclerView recyclerView2 = this.y;
        if (i != recyclerView2.getWidth() || this.x != recyclerView2.getHeight()) {
            this.w = recyclerView2.getWidth();
            this.x = recyclerView2.getHeight();
            l(0);
            return;
        }
        if (this.G != 0) {
            if (this.z) {
                int i2 = this.w;
                int i3 = this.k;
                int i4 = i2 - i3;
                int i5 = this.r;
                int i6 = this.q;
                int i7 = i5 - (i6 / 2);
                StateListDrawable stateListDrawable = this.i;
                stateListDrawable.setBounds(0, 0, i3, i6);
                int i8 = this.x;
                int i9 = this.l;
                Drawable drawable = this.j;
                drawable.setBounds(0, 0, i9, i8);
                WeakHashMap weakHashMap = qs1.a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i3, i7);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i3, -i7);
                } else {
                    canvas.translate(i4, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i7);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i4, -i7);
                }
            }
            if (this.A) {
                int i10 = this.x;
                int i11 = this.o;
                int i12 = i10 - i11;
                int i13 = this.u;
                int i14 = this.t;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.m;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.w;
                int i17 = this.p;
                Drawable drawable2 = this.n;
                drawable2.setBounds(0, 0, i16, i17);
                canvas.translate(0.0f, i12);
                drawable2.draw(canvas);
                canvas.translate(i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i15, -i12);
            }
        }
    }

    public final boolean i(float f, float f2) {
        if (f2 < this.x - this.o) {
            return false;
        }
        int i = this.u;
        int i2 = this.t;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) ((i2 / 2) + i));
    }

    public final boolean j(float f, float f2) {
        RecyclerView recyclerView = this.y;
        WeakHashMap weakHashMap = qs1.a;
        boolean z = recyclerView.getLayoutDirection() == 1;
        int i = this.k;
        if (!z ? f >= this.w - i : f <= i) {
            int i2 = this.r;
            int i3 = this.q / 2;
            if (f2 >= i2 - i3 && f2 <= i3 + i2) {
                return true;
            }
        }
        return false;
    }

    public final void l(int i) {
        o1 o1Var = this.H;
        StateListDrawable stateListDrawable = this.i;
        if (i == 2 && this.B != 2) {
            stateListDrawable.setState(I);
            this.y.removeCallbacks(o1Var);
        }
        if (i == 0) {
            this.y.invalidate();
        } else {
            m();
        }
        if (this.B == 2 && i != 2) {
            stateListDrawable.setState(J);
            this.y.removeCallbacks(o1Var);
            this.y.postDelayed(o1Var, 1200);
        } else if (i == 1) {
            this.y.removeCallbacks(o1Var);
            this.y.postDelayed(o1Var, 1500);
        }
        this.B = i;
    }

    public final void m() {
        int i = this.G;
        ValueAnimator valueAnimator = this.F;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.G = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // defpackage.y81
    public final void e(boolean z) {
    }
}
