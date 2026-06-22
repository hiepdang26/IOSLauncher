package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class rd extends EdgeEffect {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BouncyRecyclerView c;
    public final /* synthetic */ BouncyRecyclerView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rd(RecyclerView recyclerView, int i, BouncyRecyclerView bouncyRecyclerView, BouncyRecyclerView bouncyRecyclerView2, Context context) {
        super(context);
        this.a = recyclerView;
        this.b = i;
        this.c = bouncyRecyclerView;
        this.d = bouncyRecyclerView2;
    }

    public final void a(RecyclerView recyclerView, int i, float f) {
        float width;
        float overscrollAnimationSize;
        float height;
        float overscrollAnimationSize2;
        if (Float.isNaN(f)) {
            return;
        }
        BouncyRecyclerView bouncyRecyclerView = this.c;
        if (Float.isNaN(bouncyRecyclerView.getOverscrollAnimationSize())) {
            return;
        }
        Integer orientation = bouncyRecyclerView.getOrientation();
        BouncyRecyclerView bouncyRecyclerView2 = this.d;
        if (orientation != null && orientation.intValue() == 1) {
            if (i == 3) {
                height = recyclerView.getHeight() * (-1) * f;
                overscrollAnimationSize2 = bouncyRecyclerView.getOverscrollAnimationSize();
            } else {
                height = recyclerView.getHeight() * f;
                overscrollAnimationSize2 = bouncyRecyclerView.getOverscrollAnimationSize();
            }
            bouncyRecyclerView2.setTranslationY(bouncyRecyclerView2.getTranslationY() + (overscrollAnimationSize2 * height));
            bouncyRecyclerView.t0();
            bouncyRecyclerView2.getTranslationY();
            mi1 mi1Var = bouncyRecyclerView.a1;
            mi1Var.getClass();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
            }
            if (mi1Var.e) {
                mi1Var.b();
            }
        } else {
            if (i == 2) {
                width = recyclerView.getWidth() * (-1) * f;
                overscrollAnimationSize = bouncyRecyclerView.getOverscrollAnimationSize();
            } else {
                width = recyclerView.getWidth() * f;
                overscrollAnimationSize = bouncyRecyclerView.getOverscrollAnimationSize();
            }
            bouncyRecyclerView2.setTranslationX(bouncyRecyclerView2.getTranslationX() + (overscrollAnimationSize * width));
            bouncyRecyclerView.t0();
            bouncyRecyclerView2.getTranslationX();
            mi1 mi1Var2 = bouncyRecyclerView.a1;
            mi1Var2.getClass();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
            }
            if (mi1Var2.e) {
                mi1Var2.b();
            }
        }
        int childCount = bouncyRecyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (bouncyRecyclerView.P(bouncyRecyclerView.getChildAt(i2)) == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            }
        }
    }

    @Override // android.widget.EdgeEffect
    public final boolean draw(Canvas canvas) {
        setSize(0, 0);
        return super.draw(canvas);
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int i) {
        float f;
        float flingAnimationSize;
        float f2;
        float flingAnimationSize2;
        super.onAbsorb(i);
        BouncyRecyclerView bouncyRecyclerView = this.c;
        if (Float.isNaN(bouncyRecyclerView.getFlingAnimationSize())) {
            return;
        }
        Integer orientation = bouncyRecyclerView.getOrientation();
        int i2 = this.b;
        if (orientation != null && orientation.intValue() == 1) {
            if (i2 == 3) {
                f2 = i * (-1);
                flingAnimationSize2 = bouncyRecyclerView.getFlingAnimationSize();
            } else {
                f2 = i;
                flingAnimationSize2 = bouncyRecyclerView.getFlingAnimationSize();
            }
            float f3 = flingAnimationSize2 * f2;
            mi1 mi1Var = bouncyRecyclerView.a1;
            mi1Var.a = f3;
            mi1Var.d();
        } else {
            if (i2 == 2) {
                f = i * (-1);
                flingAnimationSize = bouncyRecyclerView.getFlingAnimationSize();
            } else {
                f = i;
                flingAnimationSize = bouncyRecyclerView.getFlingAnimationSize();
            }
            float f4 = flingAnimationSize * f;
            mi1 mi1Var2 = bouncyRecyclerView.a1;
            mi1Var2.a = f4;
            mi1Var2.d();
        }
        int childCount = bouncyRecyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (bouncyRecyclerView.P(bouncyRecyclerView.getChildAt(i3)) == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            }
        }
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f) {
        super.onPull(f);
        a(this.a, this.b, f);
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        super.onRelease();
        BouncyRecyclerView bouncyRecyclerView = this.c;
        bouncyRecyclerView.getOnOverPullListener();
        BouncyRecyclerView bouncyRecyclerView2 = this.d;
        bouncyRecyclerView2.getTranslationX();
        bouncyRecyclerView.getClass();
        bouncyRecyclerView2.getTranslationY();
        bouncyRecyclerView.getClass();
        bouncyRecyclerView.a1.d();
        int childCount = bouncyRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (bouncyRecyclerView.P(bouncyRecyclerView.getChildAt(i)) == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            }
        }
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f, float f2) {
        super.onPull(f, f2);
        RecyclerView recyclerView = this.a;
        int i = this.b;
        a(recyclerView, i, f);
        BouncyRecyclerView bouncyRecyclerView = this.c;
        if (i != 3) {
            if (i == 1) {
                bouncyRecyclerView.getOnOverPullListener();
            }
        } else {
            wy0 onOverPullListener = bouncyRecyclerView.getOnOverPullListener();
            if (onOverPullListener != null) {
                ((wq) ((mc1) onOverPullListener).h).m.invalidate();
            }
        }
    }
}
