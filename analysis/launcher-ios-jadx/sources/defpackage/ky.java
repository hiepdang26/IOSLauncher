package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ky implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ my h;

    public /* synthetic */ ky(my myVar, int i) {
        this.g = i;
        this.h = myVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        my myVar = this.h;
        int i2 = 1;
        switch (this.g) {
            case 0:
                t tVar = myVar.x;
                tVar.cancelShakingAnimation();
                tVar.openWidgetView(true, true);
                break;
            case 1:
                myVar.getClass();
                ky kyVar = new ky(myVar, i);
                ObjectAnimator objectAnimatorD = ik0.d(myVar, PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
                objectAnimatorD.setDuration(230L);
                boolean z = ar1.m;
                if (z) {
                    objectAnimatorD.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                if (z) {
                    myVar.setLayerType(2, null);
                }
                objectAnimatorD.addListener(new um(myVar, kyVar, i2));
                objectAnimatorD.start();
                break;
            case 2:
                t tVar2 = myVar.x;
                tVar2.cancelShakingAnimation();
                tVar2.openCustomizeColorAppStyle();
                break;
            default:
                myVar.setLayerType(0, null);
                break;
        }
    }
}
