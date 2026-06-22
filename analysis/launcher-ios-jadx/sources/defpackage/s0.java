package defpackage;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s0 extends AccessibilityNodeProvider {
    public final ow1 a;

    public s0(ow1 ow1Var) {
        this.a = ow1Var;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        r0 r0VarB = this.a.b(i);
        if (r0VarB == null) {
            return null;
        }
        return r0VarB.a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        r0 r0VarI = this.a.i(i);
        if (r0VarI == null) {
            return null;
        }
        return r0VarI.a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.u(i, i2, bundle);
    }
}
