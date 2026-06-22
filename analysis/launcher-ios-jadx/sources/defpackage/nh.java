package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class nh extends xo1 {
    public static final String[] C = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final jh D;
    public static final jh E;
    public static final jh F;
    public static final jh G;
    public static final jh H;

    static {
        new ih(PointF.class, "boundsOrigin").b = new Rect();
        D = new jh(PointF.class, "topLeft", 0);
        E = new jh(PointF.class, "bottomRight", 1);
        F = new jh(PointF.class, "bottomRight", 2);
        G = new jh(PointF.class, "topLeft", 3);
        H = new jh(PointF.class, "position", 4);
    }

    public static void F(fp1 fp1Var) {
        View view = fp1Var.b;
        WeakHashMap weakHashMap = qs1.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = fp1Var.a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", fp1Var.b.getParent());
    }

    @Override // defpackage.xo1
    public final void c(fp1 fp1Var) {
        F(fp1Var);
    }

    @Override // defpackage.xo1
    public final void f(fp1 fp1Var) {
        F(fp1Var);
    }

    @Override // defpackage.xo1
    public final Animator j(ViewGroup viewGroup, fp1 fp1Var, fp1 fp1Var2) {
        int i;
        nh nhVar;
        Animator animatorOfObject;
        if (fp1Var != null && fp1Var2 != null) {
            HashMap map = fp1Var.a;
            HashMap map2 = fp1Var2.a;
            ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                Rect rect = (Rect) map.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                int i2 = rect.left;
                int i3 = rect2.left;
                int i4 = rect.top;
                int i5 = rect2.top;
                int i6 = rect.right;
                int i7 = rect2.right;
                int i8 = rect.bottom;
                int i9 = rect2.bottom;
                int i10 = i6 - i2;
                int i11 = i8 - i4;
                int i12 = i7 - i3;
                int i13 = i9 - i5;
                Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                    i = 0;
                } else {
                    i = (i2 == i3 && i4 == i5) ? 0 : 1;
                    if (i6 != i7 || i8 != i9) {
                        i++;
                    }
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    i++;
                }
                if (i > 0) {
                    View view = fp1Var2.b;
                    pu1.a(view, i2, i4, i6, i8);
                    if (i != 2) {
                        nhVar = this;
                        if (i2 == i3 && i4 == i5) {
                            nhVar.y.getClass();
                            animatorOfObject = ObjectAnimator.ofObject(view, F, (TypeConverter) null, b21.g(i6, i8, i7, i9));
                        } else {
                            nhVar.y.getClass();
                            animatorOfObject = ObjectAnimator.ofObject(view, G, (TypeConverter) null, b21.g(i2, i4, i3, i5));
                        }
                    } else if (i10 == i12 && i11 == i13) {
                        nhVar = this;
                        nhVar.y.getClass();
                        animatorOfObject = ObjectAnimator.ofObject(view, H, (TypeConverter) null, b21.g(i2, i4, i3, i5));
                    } else {
                        nhVar = this;
                        mh mhVar = new mh();
                        mhVar.e = view;
                        nhVar.y.getClass();
                        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(mhVar, D, (TypeConverter) null, b21.g(i2, i4, i3, i5));
                        nhVar.y.getClass();
                        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(mhVar, E, (TypeConverter) null, b21.g(i6, i8, i7, i9));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
                        animatorSet.addListener(new kh(mhVar));
                        animatorOfObject = animatorSet;
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                        n90.E(viewGroup4, true);
                        nhVar.a(new lh(viewGroup4));
                    }
                    return animatorOfObject;
                }
            }
        }
        return null;
    }

    @Override // defpackage.xo1
    public final String[] o() {
        return C;
    }
}
