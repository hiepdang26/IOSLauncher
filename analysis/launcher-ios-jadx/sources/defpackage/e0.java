package defpackage;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 {
    public static final View.AccessibilityDelegate i = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate g;
    public final d0 h;

    public e0() {
        this(i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.g.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public ow1 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.g.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new ow1(accessibilityNodeProvider, 1);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.g.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, r0 r0Var) {
        this.g.onInitializeAccessibilityNodeInfo(view, r0Var.a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.g.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.g.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i2, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(y51.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            n0 n0Var = (n0) list.get(i3);
            if (n0Var.a() == i2) {
                b1 b1Var = n0Var.d;
                if (b1Var != null) {
                    Class cls = n0Var.c;
                    if (cls != null) {
                        try {
                            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception unused) {
                        }
                    }
                    zPerformAccessibilityAction = b1Var.f(view);
                }
            } else {
                i3++;
            }
        }
        zPerformAccessibilityAction = false;
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.g.performAccessibilityAction(view, i2, bundle);
        }
        if (zPerformAccessibilityAction || i2 != y51.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(y51.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i4)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i5 = 0;
            while (true) {
                if (clickableSpanArr == null || i5 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i5])) {
                    clickableSpan.onClick(view);
                    z = true;
                    break;
                }
                i5++;
            }
        }
        return z;
    }

    public void h(View view, int i2) {
        this.g.sendAccessibilityEvent(view, i2);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.g.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public e0(View.AccessibilityDelegate accessibilityDelegate) {
        this.g = accessibilityDelegate;
        this.h = new d0(this);
    }
}
