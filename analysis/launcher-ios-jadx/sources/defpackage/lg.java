package defpackage;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lg implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ lg(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ObjectAnimator objectAnimatorD;
        Activity activity;
        Object obj = this.h;
        int i = 0;
        z = false;
        z = false;
        boolean z = false;
        switch (this.g) {
            case 0:
                pg pgVar = (pg) obj;
                if (pgVar.isShowing()) {
                    ArrayList arrayList = pgVar.o;
                    if (arrayList.size() > 0 && !((og) arrayList.get(0)).a.isModal()) {
                        View view = pgVar.v;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj2 = arrayList.get(i);
                                i++;
                                ((og) obj2).a.show();
                            }
                        } else {
                            pgVar.dismiss();
                        }
                        break;
                    }
                }
                break;
            case 1:
                ViewGroup viewGroup = (ViewGroup) obj;
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if ("crop_bg_top_and_sides".equals(viewGroup.getTag())) {
                    viewGroup.setTranslationY(-viewGroup.getMeasuredHeight());
                    objectAnimatorD = ik0.b(viewGroup, Key.TRANSLATION_Y, 0.0f);
                } else {
                    viewGroup.setScaleX(0.0f);
                    viewGroup.setScaleY(0.0f);
                    objectAnimatorD = ik0.d(viewGroup, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
                }
                objectAnimatorD.setDuration(250L);
                objectAnimatorD.setInterpolator(new sp0());
                objectAnimatorD.start();
                break;
            case 2:
                NavigationView navigationView = (NavigationView) obj;
                int[] iArr = navigationView.p;
                navigationView.getLocationOnScreen(iArr);
                boolean z2 = iArr[1] == 0;
                ow0 ow0Var = navigationView.m;
                if (ow0Var.B != z2) {
                    ow0Var.B = z2;
                    int i2 = (ow0Var.h.getChildCount() == 0 && ow0Var.B) ? ow0Var.D : 0;
                    NavigationMenuView navigationMenuView = ow0Var.g;
                    navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z2 && navigationView.s);
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    boolean z3 = activity.findViewById(R.id.content).getHeight() == navigationView.getHeight();
                    boolean z4 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                    if (z3 && z4 && navigationView.t) {
                        z = true;
                    }
                    navigationView.setDrawBottomInsetForeground(z);
                }
                break;
            case 3:
                ng1 ng1Var = (ng1) obj;
                int measuredWidth = ng1Var.getMeasuredWidth();
                xu xuVar = ng1Var.p;
                ng1Var.l = measuredWidth / xuVar.a.d;
                ng1Var.m = ng1Var.getMeasuredHeight() / xuVar.a.c;
                ng1Var.c();
                ng1Var.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
            default:
                xi1 xi1Var = (xi1) obj;
                if (xi1Var.isShowing() && !xi1Var.o.isModal()) {
                    View view2 = xi1Var.t;
                    if (view2 != null && view2.isShown()) {
                        xi1Var.o.show();
                    } else {
                        xi1Var.dismiss();
                    }
                    break;
                }
                break;
        }
    }
}
