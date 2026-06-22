package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Matrix;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.PageIndicator;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.v;

/* JADX INFO: loaded from: classes.dex */
public final class a11 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ v i;

    public a11(v vVar, int i, int i2) {
        this.i = vVar;
        this.g = i;
        this.h = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar = this.i;
        int i = this.g;
        vVar.Z(i);
        int i2 = this.h;
        int i3 = i2 < i ? -1 : 1;
        int i4 = i2 > i ? i2 - 1 : i;
        for (int i5 = i2 < i ? i2 + 1 : i; i5 <= i4; i5++) {
            View childAt = vVar.getChildAt(i5);
            int iZ = vVar.z(i5) + vVar.getViewportOffsetX();
            int iZ2 = vVar.z(i5 + i3) + vVar.getViewportOffsetX();
            AnimatorSet animatorSet = (AnimatorSet) childAt.getTag(100);
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            childAt.setTranslationX(iZ - iZ2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            Matrix matrix = v.p0;
            animatorSet2.setDuration(t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
            animatorSet2.playTogether(ObjectAnimator.ofFloat(childAt, Key.TRANSLATION_X, 0.0f));
            animatorSet2.start();
            childAt.setTag(animatorSet2);
        }
        vVar.removeView(vVar.g0);
        vVar.addView(vVar.g0, i);
        vVar.i0 = -1;
        PageIndicator pageIndicator = vVar.c0;
        if (pageIndicator != null) {
            pageIndicator.setActiveMarker(vVar.getNextPage());
        }
    }
}
