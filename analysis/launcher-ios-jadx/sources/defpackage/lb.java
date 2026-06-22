package defpackage;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lb {
    public AllAppsRecyclerView a;
    public mb b;
    public AnimatorSet c;
    public int d;
    public int e;
    public Point f;
    public Paint g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Path m;
    public Paint n;
    public float o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public Rect v;
    public Rect w;

    public final void a(int i, int i2, int i3, MotionEvent motionEvent) {
        String str;
        AllAppsRecyclerView allAppsRecyclerView = this.a;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(allAppsRecyclerView.getContext());
        int action = motionEvent.getAction();
        int y = (int) motionEvent.getY();
        if (action == 0) {
            Point point = this.f;
            int i4 = point.x;
            int i5 = point.y;
            int i6 = this.j + i4;
            int i7 = this.k + i5;
            Rect rect = this.w;
            rect.set(i4, i5, i6, i7);
            int i8 = this.p;
            rect.inset(i8, i8);
            if (rect.contains(i, i2)) {
                this.u = i2 - this.f.y;
                return;
            }
            return;
        }
        mb mbVar = this.b;
        if (action != 1) {
            if (action == 2) {
                int i9 = y - i2;
                boolean z = this.t | (Math.abs(i9) > viewConfiguration.getScaledPagingTouchSlop());
                this.t = z;
                if (!this.q && !z) {
                    allAppsRecyclerView.X0.getClass();
                    Point point2 = this.f;
                    int i10 = point2.x;
                    int i11 = point2.y;
                    int i12 = this.j + i10;
                    int i13 = this.k + i11;
                    Rect rect2 = this.w;
                    rect2.set(i10, i11, i12, i13);
                    int i14 = this.p;
                    rect2.inset(i14, i14);
                    if (rect2.contains(i, i3) && Math.abs(i9) > viewConfiguration.getScaledTouchSlop()) {
                        allAppsRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                        this.q = true;
                        if (this.s) {
                            this.r = true;
                        }
                        this.u = (i3 - i2) + this.u;
                        mbVar.a(true);
                        c(true);
                    }
                }
                if (this.q) {
                    int i15 = allAppsRecyclerView.getBackgroundPadding().top;
                    float fMax = Math.max(i15, Math.min((allAppsRecyclerView.getHeight() - allAppsRecyclerView.getBackgroundPadding().bottom) - this.k, y - this.u));
                    float f = (fMax - i15) / (r2 - i15);
                    if (allAppsRecyclerView.X0.q == 0) {
                        str = "";
                    } else {
                        allAppsRecyclerView.s0();
                        ArrayList arrayList = allAppsRecyclerView.X0.g;
                        j4 j4Var = (j4) arrayList.get(0);
                        int i16 = 1;
                        while (i16 < arrayList.size()) {
                            j4 j4Var2 = (j4) arrayList.get(i16);
                            if (j4Var2.c > f) {
                                break;
                            }
                            i16++;
                            j4Var = j4Var2;
                        }
                        ib ibVar = allAppsRecyclerView.Z0;
                        int iU0 = (allAppsRecyclerView.u0(ibVar.a) + allAppsRecyclerView.getPaddingTop()) - ibVar.b;
                        int iT0 = allAppsRecyclerView.t0(allAppsRecyclerView.X0.q);
                        x3 x3Var = allAppsRecyclerView.Y0;
                        int i17 = x3Var.c;
                        int i18 = j4Var.b.a;
                        String str2 = j4Var.a;
                        if (i17 != i18) {
                            x3Var.c = i18;
                            w3 w3Var = x3Var.k;
                            AllAppsRecyclerView allAppsRecyclerView2 = x3Var.a;
                            allAppsRecyclerView2.removeCallbacks(w3Var);
                            w3 w3Var2 = x3Var.l;
                            allAppsRecyclerView2.removeCallbacks(w3Var2);
                            int childCount = allAppsRecyclerView2.getChildCount();
                            for (int i19 = 0; i19 < childCount; i19++) {
                                KeyEvent.Callback childAt = allAppsRecyclerView2.getChildAt(i19);
                                if (childAt instanceof kb) {
                                    x3Var.h.add((kb) childAt);
                                }
                            }
                            if (x3Var.f) {
                                x3Var.d = str2;
                                x3Var.e = null;
                                x3Var.a();
                            } else {
                                x3Var.d = null;
                                x3Var.e = str2;
                                x3Var.f = false;
                                x3Var.a();
                                allAppsRecyclerView2.postDelayed(w3Var2, x3Var.g ? 200L : 100L);
                            }
                            int iMin = Math.min(iT0, allAppsRecyclerView2.u0(j4Var.b.f) + allAppsRecyclerView2.getPaddingTop());
                            int[] iArr = x3Var.j;
                            int length = iArr.length;
                            for (int i20 = 0; i20 < length; i20++) {
                                iArr[i20] = (iMin - iU0) / length;
                            }
                            x3Var.i = 0;
                            allAppsRecyclerView2.postOnAnimation(w3Var);
                        }
                        str = str2;
                    }
                    if (!str.equals(mbVar.c)) {
                        mbVar.c = str;
                        Paint paint = mbVar.d;
                        int length2 = str.length();
                        Rect rect3 = mbVar.e;
                        paint.getTextBounds(str, 0, length2, rect3);
                        rect3.right = (int) (paint.measureText(str) + rect3.left);
                    }
                    mbVar.a(!str.isEmpty());
                    Rect rect4 = mbVar.b;
                    Rect rect5 = mbVar.a;
                    rect4.set(rect5);
                    rect5.setEmpty();
                    rect4.union(rect5);
                    allAppsRecyclerView.invalidate(rect4);
                    this.o = fMax;
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        this.u = 0;
        this.o = 0.0f;
        this.t = false;
        if (this.q) {
            this.q = false;
            mbVar.a(false);
            c(false);
        }
    }

    public final void b(int i, int i2) {
        Point point = this.f;
        int i3 = point.x;
        if (i3 == i && point.y == i2) {
            return;
        }
        int i4 = i3 - this.l;
        int i5 = point.y;
        int i6 = this.j;
        int i7 = this.k;
        Rect rect = this.v;
        rect.set(i4, i5, i3 + i6, i5 + i7);
        point.set(i, i2);
        this.l = this.i - i6;
        Path path = this.m;
        path.reset();
        float f = i6;
        path.moveTo(point.x + f, point.y);
        float f2 = i7;
        path.lineTo(point.x + f, point.y + f2);
        path.lineTo(point.x, point.y + f2);
        float f3 = point.x;
        float f4 = point.y;
        path.cubicTo(f3, f4 + f2, f3 - this.l, (f2 / 2.0f) + f4, f3, f4);
        path.close();
        int i8 = point.x;
        int i9 = i8 - this.l;
        int i10 = point.y;
        rect.union(i9, i10, i8 + i6, i7 + i10);
        this.a.invalidate(rect);
    }

    public final void c(boolean z) {
        int i = 1;
        AnimatorSet animatorSet = this.c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.c = new AnimatorSet();
        int i2 = this.h;
        int i3 = this.i;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "trackWidth", z ? i3 : i2);
        if (z) {
            i2 = i3;
        }
        this.c.playTogether(objectAnimatorOfInt, ObjectAnimator.ofInt(this, "thumbWidth", i2));
        int i4 = this.d;
        int i5 = this.e;
        if (i5 != i4) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Integer numValueOf = Integer.valueOf(this.g.getColor());
            if (z) {
                i4 = i5;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, numValueOf, Integer.valueOf(i4));
            valueAnimatorOfObject.addUpdateListener(new q7(this, i));
            this.c.play(valueAnimatorOfObject);
        }
        this.c.setDuration(150L);
        this.c.start();
    }
}
