package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ik0 {
    public static final WeakHashMap a = new WeakHashMap();
    public static final hk0 b = new hk0();

    public static AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(b);
        return animatorSet;
    }

    public static ObjectAnimator b(View view, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues(fArr);
        objectAnimator.addListener(b);
        new b30(objectAnimator, view);
        return objectAnimator;
    }

    public static ValueAnimator c(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        valueAnimator.addListener(b);
        return valueAnimator;
    }

    public static ObjectAnimator d(View view, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setValues(propertyValuesHolderArr);
        objectAnimator.addListener(b);
        new b30(objectAnimator, view);
        return objectAnimator;
    }
}
