package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.InfoDropTarget;
import com.luutinhit.launcher6.UninstallDropTarget;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class dk0 extends View.AccessibilityDelegate implements lw {
    public static final int k = v51.action_remove;
    public static final int l = v51.action_info;
    public static final int m = v51.action_uninstall;
    public static final int n = v51.action_add_to_workspace;
    public static final int o = v51.action_move;
    public static final int p = v51.action_move_to_workspace;
    public static final int q = v51.action_resize;
    public final SparseArray g;
    public final t h;
    public xk i;
    public ViewGroup j;

    public dk0(t tVar) {
        SparseArray sparseArray = new SparseArray();
        this.g = sparseArray;
        this.i = null;
        this.j = null;
        this.h = tVar;
        CharSequence text = tVar.getText(w61.delete_target_label);
        int i = k;
        sparseArray.put(i, new AccessibilityNodeInfo.AccessibilityAction(i, text));
        CharSequence text2 = tVar.getText(w61.info_target_label);
        int i2 = l;
        sparseArray.put(i2, new AccessibilityNodeInfo.AccessibilityAction(i2, text2));
        CharSequence text3 = tVar.getText(w61.delete_target_uninstall_label);
        int i3 = m;
        sparseArray.put(i3, new AccessibilityNodeInfo.AccessibilityAction(i3, text3));
        CharSequence text4 = tVar.getText(w61.action_add_to_workspace);
        int i4 = n;
        sparseArray.put(i4, new AccessibilityNodeInfo.AccessibilityAction(i4, text4));
        CharSequence text5 = tVar.getText(w61.action_move);
        int i5 = o;
        sparseArray.put(i5, new AccessibilityNodeInfo.AccessibilityAction(i5, text5));
        CharSequence text6 = tVar.getText(w61.action_move_to_workspace);
        int i6 = p;
        sparseArray.put(i6, new AccessibilityNodeInfo.AccessibilityAction(i6, text6));
        CharSequence text7 = tVar.getText(w61.action_resize);
        int i7 = q;
        sparseArray.put(i7, new AccessibilityNodeInfo.AccessibilityAction(i7, text7));
    }

    public static ArrayList b(View view, qk0 qk0Var) {
        ArrayList arrayList = new ArrayList();
        AppWidgetProviderInfo appWidgetInfo = ((pk0) view).getAppWidgetInfo();
        if (appWidgetInfo != null) {
            CellLayout cellLayout = (CellLayout) view.getParent().getParent();
            if ((appWidgetInfo.resizeMode & 1) != 0) {
                if (cellLayout.u(qk0Var.k + qk0Var.m, qk0Var.l, 1, qk0Var.n) || cellLayout.u(qk0Var.k - 1, qk0Var.l, 1, qk0Var.n)) {
                    arrayList.add(Integer.valueOf(w61.action_increase_width));
                }
                int i = qk0Var.m;
                if (i > qk0Var.o && i > 1) {
                    arrayList.add(Integer.valueOf(w61.action_decrease_width));
                }
            }
            if ((appWidgetInfo.resizeMode & 2) != 0) {
                if (cellLayout.u(qk0Var.k, qk0Var.l + qk0Var.n, qk0Var.m, 1) || cellLayout.u(qk0Var.k, qk0Var.l - 1, qk0Var.m, 1)) {
                    arrayList.add(Integer.valueOf(w61.action_increase_height));
                }
                int i2 = qk0Var.n;
                if (i2 > qk0Var.p && i2 > 1) {
                    arrayList.add(Integer.valueOf(w61.action_decrease_height));
                }
            }
        }
        return arrayList;
    }

    public final long a(qh0 qh0Var, int[] iArr) {
        Workspace workspace = this.h.getWorkspace();
        ArrayList<Long> screenOrder = workspace.getScreenOrder();
        int currentPage = workspace.getCurrentPage();
        long jLongValue = screenOrder.get(currentPage).longValue();
        boolean zO = ((CellLayout) workspace.getChildAt(currentPage)).o(iArr, qh0Var.m, qh0Var.n);
        for (int iI0 = workspace.I0(); !zO && iI0 < screenOrder.size(); iI0++) {
            jLongValue = screenOrder.get(iI0).longValue();
            zO = ((CellLayout) workspace.getChildAt(iI0)).o(iArr, qh0Var.m, qh0Var.n);
        }
        if (zO) {
            return jLongValue;
        }
        workspace.i0();
        long jQ0 = workspace.q0();
        workspace.H0(jQ0).o(iArr, qh0Var.m, qh0Var.n);
        return jQ0;
    }

    public final void c(View view, Rect rect, String str) {
        if (this.i != null) {
            int[] iArr = new int[2];
            if (rect == null) {
                iArr[0] = view.getWidth() / 2;
                iArr[1] = view.getHeight() / 2;
            } else {
                iArr[0] = rect.centerX();
                iArr[1] = rect.centerY();
            }
            t tVar = this.h;
            tVar.getDragLayer().getDescendantCoordRelativeToSelf(view, iArr);
            mw dragController = tVar.getDragController();
            dragController.getClass();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = dragController.d;
            ox oxVarG = dragController.g(iArr2, i, i2);
            nx nxVar = dragController.k;
            nxVar.a = iArr2[0];
            nxVar.b = iArr2[1];
            dragController.c(oxVarG);
            oxVarG.f();
            dragController.e(iArr[0], iArr[1]);
            dragController.f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            tVar.getDragLayer().announceForAccessibility(str);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        if (view.getTag() instanceof qh0) {
            qh0 qh0Var = (qh0) view.getTag();
            boolean zW = DeleteDropTarget.w(qh0Var);
            SparseArray sparseArray = this.g;
            if (zW) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(k));
            }
            if (UninstallDropTarget.x(view.getContext(), qh0Var)) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(m));
            }
            view.getContext();
            if (InfoDropTarget.w(qh0Var)) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(l));
            }
            if ((qh0Var instanceof og1) || (qh0Var instanceof qk0) || (qh0Var instanceof w40)) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(o));
                if (qh0Var.i >= 0) {
                    accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(p));
                } else if ((qh0Var instanceof qk0) && !b(view, (qk0) qh0Var).isEmpty()) {
                    accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(q));
                }
            }
            if ((qh0Var instanceof v6) || (qh0Var instanceof u11)) {
                accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) sparseArray.get(n));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x014c A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.ViewGroup, ck0] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.view.ViewGroup, ck0] */
    @Override // android.view.View.AccessibilityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performAccessibilityAction(android.view.View r20, int r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dk0.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup, ck0] */
    @Override // defpackage.lw
    public final void t() {
        this.h.getDragController().m.remove(this);
        this.i = null;
        ?? r1 = this.j;
        if (r1 != 0) {
            r1.h(false);
            this.j = null;
        }
    }

    @Override // defpackage.lw
    public final void s(xw xwVar, Object obj) {
    }
}
