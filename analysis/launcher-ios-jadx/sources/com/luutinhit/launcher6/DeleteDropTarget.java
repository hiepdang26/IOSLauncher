package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import defpackage.jk0;
import defpackage.l51;
import defpackage.nx;
import defpackage.og1;
import defpackage.qh0;
import defpackage.qk0;
import defpackage.w40;
import defpackage.w61;
import defpackage.x41;
import defpackage.xw;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDropTarget extends ButtonDropTarget {
    public DeleteDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void u(t tVar, qh0 qh0Var, View view) {
        tVar.removeItem(view, qh0Var, true);
        tVar.getWorkspace().b1();
        tVar.getDragLayer().announceForAccessibility(tVar.getString(w61.item_removed));
    }

    public static boolean w(Object obj) {
        boolean z = obj instanceof og1;
        boolean z2 = z || (obj instanceof qk0) || (obj instanceof w40);
        if (z) {
            og1 og1Var = (og1) obj;
            if (jk0.a().e.b) {
                return og1Var.h == 1;
            }
        }
        return z2;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final void n(nx nxVar) {
        qh0 qh0Var = (qh0) nxVar.g;
        xw xwVar = nxVar.h;
        if ((xwVar instanceof Workspace) || (xwVar instanceof Folder)) {
            u(this.g, qh0Var, null);
        }
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final boolean o(xw xwVar, Object obj) {
        return xwVar.m() && w(obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.m = getResources().getColor(x41.delete_target_hover_tint);
        setDrawable(l51.ic_remove_launcher);
    }
}
