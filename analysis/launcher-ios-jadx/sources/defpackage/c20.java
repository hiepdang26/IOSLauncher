package defpackage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c20 extends e0 {
    public static final Rect t = new Rect(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
    public static final jl1 u = new jl1(17);
    public static final iy v = new iy();
    public final AccessibilityManager n;
    public final View o;
    public b20 p;
    public final Rect j = new Rect();
    public final Rect k = new Rect();
    public final Rect l = new Rect();
    public final int[] m = new int[2];
    public int q = RtlSpacingHelper.UNDEFINED;
    public int r = RtlSpacingHelper.UNDEFINED;
    public int s = RtlSpacingHelper.UNDEFINED;

    public c20(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.o = view;
        this.n = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = qs1.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Override // defpackage.e0
    public final ow1 b(View view) {
        if (this.p == null) {
            this.p = new b20(this);
        }
        return this.p;
    }

    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        this.g.onInitializeAccessibilityNodeInfo(view, r0Var.a);
        s(r0Var);
    }

    public final boolean j(int i) {
        if (this.r != i) {
            return false;
        }
        this.r = RtlSpacingHelper.UNDEFINED;
        u(i, false);
        w(i, 8);
        return true;
    }

    public final r0 k(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        r0 r0Var = new r0(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        r0Var.i("android.view.View");
        Rect rect = t;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        View view = this.o;
        accessibilityNodeInfoObtain.setParent(view);
        t(i, r0Var);
        if (r0Var.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.k;
        r0Var.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        r0Var.b = i;
        accessibilityNodeInfoObtain.setSource(view, i);
        if (this.q == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            r0Var.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            r0Var.a(64);
        }
        boolean z = this.r == i;
        if (z) {
            r0Var.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            r0Var.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.m;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.j;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            r0Var.f(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.l;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            r0Var.a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return r0Var;
    }

    public final boolean l(MotionEvent motionEvent) {
        int i;
        AccessibilityManager accessibilityManager = this.n;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iM = m(motionEvent.getX(), motionEvent.getY());
            int i2 = this.s;
            if (i2 != iM) {
                this.s = iM;
                w(iM, 128);
                w(i2, MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
            }
            if (iM == Integer.MIN_VALUE) {
                return false;
            }
        } else {
            if (action != 10 || (i = this.s) == Integer.MIN_VALUE) {
                return false;
            }
            if (i != Integer.MIN_VALUE) {
                this.s = RtlSpacingHelper.UNDEFINED;
                w(i, MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
                return true;
            }
        }
        return true;
    }

    public abstract int m(float f, float f2);

    public abstract void n(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c20.o(int, android.graphics.Rect):boolean");
    }

    public final r0 p(int i) {
        if (i != -1) {
            return k(i);
        }
        View view = this.o;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        r0 r0Var = new r0(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = qs1.a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        n(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            r0Var.a.addChild(view, ((Integer) arrayList.get(i2)).intValue());
        }
        return r0Var;
    }

    public abstract boolean q(int i, int i2);

    public abstract void t(int i, r0 r0Var);

    public final boolean v(int i) {
        int i2;
        View view = this.o;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.r) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            j(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.r = i;
        u(i, true);
        w(i, 8);
        return true;
    }

    public final void w(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.n.isEnabled() || (parent = (view = this.o).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            r0 r0VarP = p(i);
            accessibilityEventObtain.getText().add(r0VarP.g());
            AccessibilityNodeInfo accessibilityNodeInfo = r0VarP.a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            r(i, accessibilityEventObtain);
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }

    public void s(r0 r0Var) {
    }

    public void r(int i, AccessibilityEvent accessibilityEvent) {
    }

    public void u(int i, boolean z) {
    }
}
