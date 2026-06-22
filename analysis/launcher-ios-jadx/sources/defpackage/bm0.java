package defpackage;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public final class bm0 extends Animator implements Animator.AnimatorListener {
    public ViewPropertyAnimator h;
    public final View i;
    public float j;
    public float k;
    public float l;
    public float m;
    public long n;
    public long o;
    public TimeInterpolator p;
    public b30 s;
    public final EnumSet g = EnumSet.noneOf(am0.class);
    public final ArrayList q = new ArrayList();
    public boolean r = false;

    public bm0(View view) {
        this.i = view;
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.q.add(animatorListener);
    }

    @Override // android.animation.Animator
    public final void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.h;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.animation.Animator
    public final Object clone() {
        return super.clone();
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.o;
    }

    @Override // android.animation.Animator
    public final ArrayList getListeners() {
        return this.q;
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return this.n;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return this.r;
    }

    @Override // android.animation.Animator
    public final boolean isStarted() {
        return this.h != null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.q;
            if (i >= arrayList.size()) {
                this.r = false;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i)).onAnimationCancel(this);
                i++;
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.q;
            if (i >= arrayList.size()) {
                this.r = false;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i)).onAnimationEnd(this);
                i++;
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.q;
            if (i >= arrayList.size()) {
                return;
            }
            ((Animator.AnimatorListener) arrayList.get(i)).onAnimationRepeat(this);
            i++;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.s.onAnimationStart(animator);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.q;
            if (i >= arrayList.size()) {
                this.r = true;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i)).onAnimationStart(this);
                i++;
            }
        }
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.q.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.q.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long j) {
        this.g.add(am0.n);
        this.o = j;
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.g.add(am0.o);
        this.p = timeInterpolator;
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long j) {
        this.g.add(am0.m);
        this.n = j;
    }

    @Override // android.animation.Animator
    public final void setTarget(Object obj) {
        throw new RuntimeException("Not implemented");
    }

    @Override // android.animation.Animator
    public final void start() {
        View view = this.i;
        this.h = view.animate();
        ViewPropertyAnimator viewPropertyAnimator = this.h;
        b30 b30Var = new b30();
        b30Var.i = -1L;
        b30Var.g = view;
        viewPropertyAnimator.setListener(b30Var);
        this.s = b30Var;
        am0 am0Var = am0.g;
        EnumSet enumSet = this.g;
        if (enumSet.contains(am0Var)) {
            this.h.translationX(0.0f);
        }
        if (enumSet.contains(am0.h)) {
            this.h.translationY(this.j);
        }
        if (enumSet.contains(am0.i)) {
            this.h.scaleX(this.k);
        }
        if (enumSet.contains(am0.k)) {
            this.h.rotationY(0.0f);
        }
        if (enumSet.contains(am0.j)) {
            this.h.scaleY(this.l);
        }
        if (enumSet.contains(am0.l)) {
            this.h.alpha(this.m);
        }
        if (enumSet.contains(am0.m)) {
            this.h.setStartDelay(this.n);
        }
        if (enumSet.contains(am0.n)) {
            this.h.setDuration(this.o);
        }
        if (enumSet.contains(am0.o)) {
            this.h.setInterpolator(this.p);
        }
        if (enumSet.contains(am0.p)) {
            this.h.withLayer();
        }
        this.h.setListener(this);
        this.h.start();
        addListener(ik0.b);
    }

    @Override // android.animation.Animator
    public final void setupEndValues() {
    }

    @Override // android.animation.Animator
    public final void setupStartValues() {
    }
}
