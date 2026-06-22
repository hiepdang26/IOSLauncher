package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public final class zt implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ View h;
    public final /* synthetic */ au i;

    public zt(ViewGroup viewGroup, View view, au auVar) {
        this.g = viewGroup;
        this.h = view;
        this.i = auVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.g.post(new o1(this, 14));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
