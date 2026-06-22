package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.util.DeleteCircleView;

/* JADX INFO: loaded from: classes.dex */
public final class lm0 extends m91 {
    public final DeleteCircleView A;
    public final ObjectAnimator B;

    public lm0(View view) {
        super(view);
        this.A = (DeleteCircleView) view.findViewById(v51.icon_delete_widget);
        float width = view.getWidth();
        float height = view.getHeight();
        ObjectAnimator objectAnimatorD = ik0.d(view, PropertyValuesHolder.ofFloat("pivotX", ((((float) Math.random()) * 0.38f) + 0.2f) * width, ((((float) Math.random()) * 0.38f) + 0.2f) * width), PropertyValuesHolder.ofFloat("pivotY", ((((float) Math.random()) * 0.38f) + 0.2f) * height, ((((float) Math.random()) * 0.38f) + 0.2f) * height), PropertyValuesHolder.ofFloat(Key.ROTATION, ((float) (Math.random() * 0.10000000149011612d)) - 0.3926991f, ((float) (Math.random() * 0.10000000149011612d)) + 0.3926991f));
        this.B = objectAnimatorD;
        objectAnimatorD.setDuration((long) ((Math.random() * 36.0d) + 113.0d));
        objectAnimatorD.setRepeatCount(-1);
        objectAnimatorD.setRepeatMode(2);
        objectAnimatorD.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorD.addListener(new ce(2));
    }

    public final void v() {
        DeleteCircleView deleteCircleView = this.A;
        if (deleteCircleView != null) {
            deleteCircleView.c(8, true);
        }
        ObjectAnimator objectAnimator = this.B;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.g.setRotation(0.0f);
        }
    }

    public final void w() {
        DeleteCircleView deleteCircleView = this.A;
        if (deleteCircleView != null) {
            deleteCircleView.c(0, true);
        }
        ObjectAnimator objectAnimator = this.B;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }
}
