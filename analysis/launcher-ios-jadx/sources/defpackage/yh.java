package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public final class yh extends e0 {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public /* synthetic */ yh(Object obj, int i) {
        this.j = i;
        this.k = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // defpackage.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            int r0 = r2.j
            switch(r0) {
                case 0: goto L47;
                case 5: goto L9;
                default: goto L5;
            }
        L5:
            super.c(r3, r4)
            return
        L9:
            super.c(r3, r4)
            java.lang.Class<androidx.viewpager.widget.ViewPager> r3 = androidx.viewpager.widget.ViewPager.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            java.lang.Object r3 = r2.k
            androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3
            d11 r0 = r3.k
            if (r0 == 0) goto L25
            int r0 = r0.c()
            r1 = 1
            if (r0 <= r1) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            r4.setScrollable(r1)
            int r0 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 != r1) goto L46
            d11 r0 = r3.k
            if (r0 == 0) goto L46
            int r0 = r0.c()
            r4.setItemCount(r0)
            int r0 = r3.l
            r4.setFromIndex(r0)
            int r3 = r3.l
            r4.setToIndex(r3)
        L46:
            return
        L47:
            super.c(r3, r4)
            java.lang.Object r3 = r2.k
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            boolean r3 = r3.g
            r4.setChecked(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yh.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        int i;
        z = false;
        boolean z = false;
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        Object obj = this.k;
        switch (this.j) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.h);
                accessibilityNodeInfo.setChecked(checkableImageButton.g);
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, r0Var.a);
                int i2 = MaterialButtonToggleGroup.q;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                if (view instanceof MaterialButton) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < materialButtonToggleGroup.getChildCount(); i4++) {
                        if (materialButtonToggleGroup.getChildAt(i4) == view) {
                            i = i3;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.c(i4)) {
                                i3++;
                            }
                        }
                    }
                    i = -1;
                } else {
                    i = -1;
                }
                r0Var.j(nx0.v(0, 1, i, 1, false, ((MaterialButton) view).q));
                break;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, r0Var.a);
                ir0 ir0Var = (ir0) obj;
                r0Var.l(ir0Var.i0.getVisibility() == 0 ? ir0Var.t(v61.mtrl_picker_toggle_to_year_selection) : ir0Var.t(v61.mtrl_picker_toggle_to_day_selection));
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo2 = r0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).o);
                break;
            case 4:
                f31 f31Var = (f31) obj;
                f31Var.m.d(view, r0Var);
                RecyclerView recyclerView = f31Var.l;
                recyclerView.getClass();
                int iO = RecyclerView.O(view);
                m81 adapter = recyclerView.getAdapter();
                if (adapter instanceof c31) {
                    ((c31) adapter).r(iO);
                    break;
                }
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo3 = r0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                r0Var.i(ViewPager.class.getName());
                ViewPager viewPager = (ViewPager) obj;
                d11 d11Var = viewPager.k;
                if (d11Var != null && d11Var.c() > 1) {
                    z = true;
                }
                accessibilityNodeInfo3.setScrollable(z);
                if (viewPager.canScrollHorizontally(1)) {
                    r0Var.a(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
                }
                if (viewPager.canScrollHorizontally(-1)) {
                    r0Var.a(8192);
                }
                break;
        }
    }

    @Override // defpackage.e0
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.j) {
            case 4:
                return ((f31) this.k).m.g(view, i, bundle);
            case 5:
                if (super.g(view, i, bundle)) {
                    return true;
                }
                ViewPager viewPager = (ViewPager) this.k;
                if (i != 4096) {
                    if (i == 8192 && viewPager.canScrollHorizontally(-1)) {
                        viewPager.setCurrentItem(viewPager.l - 1);
                        return true;
                    }
                } else if (viewPager.canScrollHorizontally(1)) {
                    viewPager.setCurrentItem(viewPager.l + 1);
                    return true;
                }
                return false;
            default:
                return super.g(view, i, bundle);
        }
    }
}
