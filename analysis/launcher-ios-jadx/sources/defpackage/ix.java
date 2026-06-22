package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes.dex */
public final class ix extends e0 {
    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        if (DrawerLayout.includeChildForAccessibility(view)) {
            return;
        }
        accessibilityNodeInfo.setParent(null);
    }
}
