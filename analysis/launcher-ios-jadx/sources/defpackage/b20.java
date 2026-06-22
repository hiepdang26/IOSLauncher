package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.profileinstaller.ProfileVerifier;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b20 extends ow1 {
    public final /* synthetic */ c20 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b20(c20 c20Var) {
        super(1);
        this.i = c20Var;
    }

    @Override // defpackage.ow1
    public final r0 b(int i) {
        return new r0(AccessibilityNodeInfo.obtain(this.i.p(i).a));
    }

    @Override // defpackage.ow1
    public final r0 i(int i) {
        c20 c20Var = this.i;
        int i2 = i == 2 ? c20Var.q : c20Var.r;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return b(i2);
    }

    @Override // defpackage.ow1
    public final boolean u(int i, int i2, Bundle bundle) {
        int i3;
        c20 c20Var = this.i;
        View view = c20Var.o;
        if (i == -1) {
            WeakHashMap weakHashMap = qs1.a;
            return view.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return c20Var.v(i);
        }
        if (i2 == 2) {
            return c20Var.j(i);
        }
        if (i2 != 64) {
            if (i2 != 128) {
                return c20Var.q(i, i2);
            }
            if (c20Var.q != i) {
                return false;
            }
            c20Var.q = RtlSpacingHelper.UNDEFINED;
            view.invalidate();
            c20Var.w(i, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            return true;
        }
        AccessibilityManager accessibilityManager = c20Var.n;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = c20Var.q) == i) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            c20Var.q = RtlSpacingHelper.UNDEFINED;
            c20Var.o.invalidate();
            c20Var.w(i3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        }
        c20Var.q = i;
        view.invalidate();
        c20Var.w(i, 32768);
        return true;
    }
}
