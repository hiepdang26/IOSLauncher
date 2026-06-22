package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class hz0 {
    public final GestureDetector a;
    public final int b;
    public final int c;
    public boolean d;
    public final int e;
    public final int f;
    public float g;
    public float h;
    public boolean i = true;
    public final mi1 j;
    public final t k;
    public final SearchViewLayout l;

    public hz0(t tVar, int i) {
        this.h = 100.0f;
        this.k = tVar;
        SearchViewLayout searchView = tVar.getSearchView();
        this.l = searchView;
        this.e = i / 10;
        this.h = i / 6.0f;
        this.f = i;
        this.a = new GestureDetector(tVar, new gz0(this, 0));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(tVar);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.c = viewConfiguration.getScaledMinimumFlingVelocity();
        mi1 mi1Var = new mi1(searchView, mi1.m);
        this.j = mi1Var;
        ni1 ni1Var = new ni1();
        ni1Var.a(1.0f);
        ni1Var.b(200.0f);
        mi1Var.j = ni1Var;
        dz0 dz0Var = new dz0(this);
        ArrayList arrayList = mi1Var.h;
        if (arrayList.contains(dz0Var)) {
            return;
        }
        arrayList.add(dz0Var);
    }

    public final void a(float f) {
        int iMax = Math.max(168, (int) ((f / this.f) * 3689.0f));
        AnimatorSet animatorSetA = ik0.a();
        int i = 1;
        int i2 = 0;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.l, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f));
        t tVar = this.k;
        if (tVar.isRenderEffectSupport) {
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.setDuration(iMax);
            objectAnimatorOfPropertyValuesHolder.addListener(new fz0(this, i2));
            objectAnimatorOfPropertyValuesHolder.addUpdateListener(new ez0(this, 0));
            objectAnimatorOfPropertyValuesHolder.start();
        } else {
            animatorSetA.playTogether(objectAnimatorOfPropertyValuesHolder, ObjectAnimator.ofFloat(tVar.getBlurBackground(), Key.ALPHA, 0.0f));
            animatorSetA.setInterpolator(new DecelerateInterpolator());
            animatorSetA.setDuration(iMax);
            animatorSetA.addListener(new fz0(this, i));
            animatorSetA.start();
        }
        this.i = false;
    }

    public final void b(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.i && this.l.y()) {
                if (Math.abs(this.g) > this.e) {
                    c(this.g, this.c);
                } else {
                    a(this.g);
                }
            }
            this.i = true;
            this.d = false;
            this.g = 0.0f;
            this.h = this.f / 6.0f;
        }
    }

    public final void c(float f, float f2) {
        int iMax = Math.max(189, (int) ((f / this.f) * 2689.0f));
        AnimatorSet animatorSetA = ik0.a();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.l, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f));
        t tVar = this.k;
        if (tVar.isRenderEffectSupport) {
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.setDuration(iMax);
            objectAnimatorOfPropertyValuesHolder.addUpdateListener(new ez0(this, 1));
            objectAnimatorOfPropertyValuesHolder.start();
        } else {
            animatorSetA.playTogether(objectAnimatorOfPropertyValuesHolder, ObjectAnimator.ofFloat(tVar.getBlurBackground(), Key.ALPHA, 1.0f));
            animatorSetA.setInterpolator(new DecelerateInterpolator());
            animatorSetA.setDuration(iMax);
            animatorSetA.start();
        }
        mi1 mi1Var = this.j;
        mi1Var.a = f2;
        if (mi1Var.e) {
            mi1Var.k = 0.0f;
        } else {
            if (mi1Var.j == null) {
                mi1Var.j = new ni1(0);
            }
            mi1Var.j.i = 0.0f;
            mi1Var.d();
        }
        mi1Var.d();
        this.i = false;
    }

    public final void d(float f) {
        t tVar = this.k;
        tVar.showBlurWallpaperBackground(f);
        if (f <= 0.1f) {
            tVar.getDragLayer().setRenderEffect(null);
            return;
        }
        float f2 = f * 36.0f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        tVar.getDragLayer().setRenderEffect(RenderEffect.createBlurEffect(f2, f2, Shader.TileMode.CLAMP));
    }
}
