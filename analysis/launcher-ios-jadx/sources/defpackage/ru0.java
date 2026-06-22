package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ru0 {
    public final ug1 a = new ug1(0);
    public final ug1 b = new ug1(0);

    public static ru0 a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static ru0 b(Context context, int i) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return c(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i);
            return null;
        }
    }

    public static ru0 c(ArrayList arrayList) {
        ru0 ru0Var = new ru0();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            ru0Var.b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = n5.b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = n5.c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = n5.d;
            }
            su0 su0Var = new su0();
            su0Var.d = 0;
            su0Var.e = 1;
            su0Var.a = startDelay;
            su0Var.b = duration;
            su0Var.c = interpolator;
            su0Var.d = objectAnimator.getRepeatCount();
            su0Var.e = objectAnimator.getRepeatMode();
            ru0Var.a.put(propertyName, su0Var);
        }
        return ru0Var;
    }

    public final su0 d(String str) {
        ug1 ug1Var = this.a;
        if (ug1Var.get(str) != null) {
            return (su0) ug1Var.get(str);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ru0) {
            return this.a.equals(((ru0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "\n" + ru0.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}
