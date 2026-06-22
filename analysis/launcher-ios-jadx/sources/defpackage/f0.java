package defpackage;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final fz1 a;

    public f0(fz1 fz1Var) {
        this.a = fz1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return this.a.equals(((f0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        ux uxVar = (ux) this.a.h;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) uxVar.a.getEditText();
        if (autoCompleteTextView == null || autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int i = z ? 2 : 1;
        WeakHashMap weakHashMap = qs1.a;
        uxVar.c.setImportantForAccessibility(i);
    }
}
