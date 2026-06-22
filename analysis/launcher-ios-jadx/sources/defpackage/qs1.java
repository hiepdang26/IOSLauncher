package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class qs1 {
    public static WeakHashMap a = null;
    public static Field b = null;
    public static boolean c = false;
    public static ThreadLocal d;
    public static final int[] e = {y51.accessibility_custom_action_0, y51.accessibility_custom_action_1, y51.accessibility_custom_action_2, y51.accessibility_custom_action_3, y51.accessibility_custom_action_4, y51.accessibility_custom_action_5, y51.accessibility_custom_action_6, y51.accessibility_custom_action_7, y51.accessibility_custom_action_8, y51.accessibility_custom_action_9, y51.accessibility_custom_action_10, y51.accessibility_custom_action_11, y51.accessibility_custom_action_12, y51.accessibility_custom_action_13, y51.accessibility_custom_action_14, y51.accessibility_custom_action_15, y51.accessibility_custom_action_16, y51.accessibility_custom_action_17, y51.accessibility_custom_action_18, y51.accessibility_custom_action_19, y51.accessibility_custom_action_20, y51.accessibility_custom_action_21, y51.accessibility_custom_action_22, y51.accessibility_custom_action_23, y51.accessibility_custom_action_24, y51.accessibility_custom_action_25, y51.accessibility_custom_action_26, y51.accessibility_custom_action_27, y51.accessibility_custom_action_28, y51.accessibility_custom_action_29, y51.accessibility_custom_action_30, y51.accessibility_custom_action_31};
    public static final cs1 f = new cs1();
    public static final es1 g = new es1();

    public static zt1 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        zt1 zt1Var = (zt1) a.get(view);
        if (zt1Var != null) {
            return zt1Var;
        }
        zt1 zt1Var2 = new zt1(view);
        a.put(view, zt1Var2);
        return zt1Var2;
    }

    public static ly1 b(View view, ly1 ly1Var) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsG = ly1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsA = i >= 30 ? ns1.a(view, windowInsetsG) : fs1.a(view, windowInsetsG);
            if (!windowInsetsA.equals(windowInsetsG)) {
                return ly1.h(windowInsetsA, view);
            }
        }
        return ly1Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = ps1.d;
        ps1 ps1Var = (ps1) view.getTag(y51.tag_unhandled_key_event_manager);
        if (ps1Var == null) {
            ps1Var = new ps1();
            ps1Var.a = null;
            ps1Var.b = null;
            ps1Var.c = null;
            view.setTag(y51.tag_unhandled_key_event_manager, ps1Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = ps1Var.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = ps1.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (ps1Var.a == null) {
                            ps1Var.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = ps1.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                ps1Var.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    ps1Var.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = ps1Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (ps1Var.b == null) {
                    ps1Var.b = new SparseArray();
                }
                ps1Var.b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ms1.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(y51.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(y51.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static Rect f() {
        if (d == null) {
            d = new ThreadLocal();
        }
        Rect rect = (Rect) d.get();
        if (rect == null) {
            rect = new Rect();
            d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static String[] g(View view) {
        return Build.VERSION.SDK_INT >= 31 ? os1.a(view) : (String[]) view.getTag(y51.tag_on_receive_content_mime_types);
    }

    public static void h(int i, View view) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i2 = y51.tag_accessibility_pane_title;
            int i3 = Build.VERSION.SDK_INT;
            Object objA = null;
            if (i3 >= 28) {
                tag = ls1.a(view);
            } else {
                tag = view.getTag(i2);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    int i4 = y51.tag_accessibility_pane_title;
                    if (i3 >= 28) {
                        objA = ls1.a(view);
                    } else {
                        Object tag2 = view.getTag(i4);
                        if (CharSequence.class.isInstance(tag2)) {
                            objA = tag2;
                        }
                    }
                    text.add((CharSequence) objA);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError unused) {
                        view.getParent().getClass();
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            int i5 = y51.tag_accessibility_pane_title;
            if (i3 >= 28) {
                objA = ls1.a(view);
            } else {
                Object tag3 = view.getTag(i5);
                if (CharSequence.class.isInstance(tag3)) {
                    objA = tag3;
                }
            }
            text2.add((CharSequence) objA);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void i(int i, View view) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect rectF = f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectF.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectF.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            s(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                s((View) parent2);
            }
        }
        if (z && rectF.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectF);
        }
    }

    public static void j(int i, View view) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect rectF = f();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectF.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectF.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            s(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                s((View) parent2);
            }
        }
        if (z && rectF.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectF);
        }
    }

    public static ly1 k(View view, ly1 ly1Var) {
        WindowInsets windowInsetsG = ly1Var.g();
        if (windowInsetsG != null) {
            WindowInsets windowInsetsB = fs1.b(view, windowInsetsG);
            if (!windowInsetsB.equals(windowInsetsG)) {
                return ly1.h(windowInsetsB, view);
            }
        }
        return ly1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn l(View view, xn xnVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(xnVar);
            view.getClass();
            view.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return os1.b(view, xnVar);
        }
        kn1 kn1Var = (kn1) view.getTag(y51.tag_on_receive_content_listener);
        az0 az0Var = f;
        if (kn1Var == null) {
            if (view instanceof az0) {
                az0Var = (az0) view;
            }
            return az0Var.onReceiveContent(xnVar);
        }
        xn xnVarA = kn1.a(view, xnVar);
        if (xnVarA == null) {
            return null;
        }
        if (view instanceof az0) {
            az0Var = (az0) view;
        }
        return az0Var.onReceiveContent(xnVarA);
    }

    public static void m(int i, View view) {
        ArrayList arrayListE = e(view);
        for (int i2 = 0; i2 < arrayListE.size(); i2++) {
            if (((n0) arrayListE.get(i2)).a() == i) {
                arrayListE.remove(i2);
                return;
            }
        }
    }

    public static void n(View view, n0 n0Var, b1 b1Var) {
        if (b1Var == null) {
            m(n0Var.a(), view);
            h(0, view);
            return;
        }
        n0 n0Var2 = new n0(null, n0Var.b, null, b1Var, n0Var.c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        e0 e0Var = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof d0 ? ((d0) accessibilityDelegateD).a : new e0(accessibilityDelegateD);
        if (e0Var == null) {
            e0Var = new e0();
        }
        p(view, e0Var);
        m(n0Var2.a(), view);
        e(view).add(n0Var2);
        h(0, view);
    }

    public static void o(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            ms1.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void p(View view, e0 e0Var) {
        if (e0Var == null && (d(view) instanceof d0)) {
            e0Var = new e0();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(e0Var == null ? null : e0Var.h);
    }

    public static void q(View view, CharSequence charSequence) {
        new ds1(y51.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        es1 es1Var = g;
        if (charSequence == null) {
            es1Var.g.remove(view);
            view.removeOnAttachStateChangeListener(es1Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(es1Var);
        } else {
            es1Var.g.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(es1Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(es1Var);
            }
        }
    }

    public static void r(View view, ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        hs1.j(view, colorStateList);
        if (i == 21) {
            Drawable background = view.getBackground();
            boolean z = (hs1.c(view) == null && hs1.d(view) == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void s(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
