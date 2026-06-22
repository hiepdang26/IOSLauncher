package androidx.drawerlayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.e0;
import defpackage.n0;
import defpackage.qs1;
import defpackage.r0;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e0 {
    public final Rect j = new Rect();
    public final /* synthetic */ DrawerLayout k;

    public a(DrawerLayout drawerLayout) {
        this.k = drawerLayout;
    }

    @Override // defpackage.e0
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        CharSequence drawerTitle;
        if (accessibilityEvent.getEventType() != 32) {
            return this.g.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        List<CharSequence> text = accessibilityEvent.getText();
        DrawerLayout drawerLayout = this.k;
        View viewFindVisibleDrawer = drawerLayout.findVisibleDrawer();
        if (viewFindVisibleDrawer == null || (drawerTitle = drawerLayout.getDrawerTitle(drawerLayout.getDrawerViewAbsoluteGravity(viewFindVisibleDrawer))) == null) {
            return true;
        }
        text.add(drawerTitle);
        return true;
    }

    @Override // defpackage.e0
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }

    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        boolean z = DrawerLayout.CAN_HIDE_DESCENDANTS;
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        if (z) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
            r0Var.b = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap weakHashMap = qs1.a;
            Object parentForAccessibility = view.getParentForAccessibility();
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfo.setParent((View) parentForAccessibility);
            }
            Rect rect = this.j;
            accessibilityNodeInfoObtain.getBoundsInScreen(rect);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
            r0Var.i(accessibilityNodeInfoObtain.getClassName());
            r0Var.k(accessibilityNodeInfoObtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
            accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
            r0Var.a(accessibilityNodeInfoObtain.getActions());
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }
        r0Var.i("androidx.drawerlayout.widget.DrawerLayout");
        accessibilityNodeInfo.setFocusable(false);
        accessibilityNodeInfo.setFocused(false);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) n0.e.a);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) n0.f.a);
    }

    @Override // defpackage.e0
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
            return this.g.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        return false;
    }
}
