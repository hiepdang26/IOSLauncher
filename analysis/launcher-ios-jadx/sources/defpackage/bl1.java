package defpackage;

import android.animation.ValueAnimator;
import com.luutinhit.launcher6.widget.SwipeMenuLayout;

/* JADX INFO: loaded from: classes.dex */
public final class bl1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ SwipeMenuLayout h;

    public /* synthetic */ bl1(SwipeMenuLayout swipeMenuLayout, int i) {
        this.g = i;
        this.h = swipeMenuLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.g) {
            case 0:
                this.h.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            default:
                this.h.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
        }
    }
}
