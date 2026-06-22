package defpackage;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* JADX INFO: loaded from: classes.dex */
public final class aw1 implements Animation.AnimationListener {
    public final /* synthetic */ ImageFilterView g;
    public final /* synthetic */ TranslateAnimation h;

    public aw1(ImageFilterView imageFilterView, TranslateAnimation translateAnimation) {
        this.g = imageFilterView;
        this.h = translateAnimation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.g.startAnimation(this.h);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
