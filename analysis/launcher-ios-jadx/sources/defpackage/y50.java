package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public final class y50 extends AnimationSet implements Runnable {
    public final ViewGroup g;
    public final View h;
    public boolean i;
    public boolean j;
    public boolean k;

    public y50(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.k = true;
        this.g = viewGroup;
        this.h = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.k = true;
        if (this.i) {
            return !this.j;
        }
        if (!super.getTransformation(j, transformation)) {
            this.i = true;
            lz0.a(this.g, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.i;
        ViewGroup viewGroup = this.g;
        if (z || !this.k) {
            viewGroup.endViewTransition(this.h);
            this.j = true;
        } else {
            this.k = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.k = true;
        if (this.i) {
            return !this.j;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.i = true;
            lz0.a(this.g, this);
        }
        return true;
    }
}
