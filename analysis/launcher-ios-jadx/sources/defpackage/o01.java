package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final class o01 extends View.AccessibilityDelegate {
    public static final int c = v51.action_move_screen_backwards;
    public static final int d = v51.action_move_screen_forwards;
    public final SparseArray a;
    public final Workspace b;

    public o01(Workspace workspace) {
        SparseArray sparseArray = new SparseArray();
        this.a = sparseArray;
        this.b = workspace;
        Context context = workspace.getContext();
        boolean zV = ar1.v(context.getResources());
        CharSequence text = context.getText(zV ? w61.action_move_screen_right : w61.action_move_screen_left);
        int i = c;
        sparseArray.put(i, new AccessibilityNodeInfo.AccessibilityAction(i, text));
        CharSequence text2 = context.getText(zV ? w61.action_move_screen_left : w61.action_move_screen_right);
        int i2 = d;
        sparseArray.put(i2, new AccessibilityNodeInfo.AccessibilityAction(i2, text2));
    }

    public final void a(int i, View view) {
        Workspace workspace = this.b;
        workspace.R();
        workspace.removeView(view);
        workspace.addView(view, i);
        workspace.L();
        workspace.announceForAccessibility(workspace.getContext().getText(w61.screen_moved));
        workspace.c1();
        view.performAccessibilityAction(64, null);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Workspace workspace = this.b;
        int iIndexOfChild = workspace.indexOfChild(view);
        int childCount = workspace.getChildCount() - 1;
        SparseArray sparseArray = this.a;
        if (iIndexOfChild < childCount) {
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(d));
        }
        if (iIndexOfChild > workspace.R0()) {
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(c));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (view != null) {
            Workspace workspace = this.b;
            if (i == 64) {
                workspace.setCurrentPage(workspace.indexOfChild(view));
            } else {
                if (i == d) {
                    a(workspace.indexOfChild(view) + 1, view);
                    return true;
                }
                if (i == c) {
                    a(workspace.indexOfChild(view) - 1, view);
                    return true;
                }
            }
        }
        return super.performAccessibilityAction(view, i, bundle);
    }
}
