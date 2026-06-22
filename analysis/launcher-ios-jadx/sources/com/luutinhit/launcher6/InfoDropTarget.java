package com.luutinhit.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.util.AttributeSet;
import defpackage.jk0;
import defpackage.jq1;
import defpackage.l51;
import defpackage.nx;
import defpackage.og1;
import defpackage.qh0;
import defpackage.u11;
import defpackage.v6;
import defpackage.x41;
import defpackage.xw;

/* JADX INFO: loaded from: classes.dex */
public class InfoDropTarget extends ButtonDropTarget {
    public InfoDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void u(t tVar, Object obj) {
        ComponentName component = obj instanceof v6 ? ((v6) obj).A : obj instanceof og1 ? ((og1) obj).x.getComponent() : obj instanceof u11 ? ((u11) obj).x : null;
        jq1 jq1VarB = obj instanceof qh0 ? ((qh0) obj).w : jq1.b();
        if (component != null) {
            tVar.startApplicationDetailsActivity(component, jq1VarB);
        }
    }

    public static boolean w(Object obj) {
        boolean z = (obj instanceof v6) || (obj instanceof u11);
        if (obj instanceof og1) {
            og1 og1Var = (og1) obj;
            if (jk0.a().e.b) {
                return og1Var.h == 0;
            }
        }
        return z;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final void n(nx nxVar) {
        u(this.g, nxVar.g);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final boolean o(xw xwVar, Object obj) {
        if (!xwVar.i()) {
            return false;
        }
        getContext();
        return w(obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.m = getResources().getColor(x41.info_target_hover_tint);
        setDrawable(l51.ic_info_launcher);
    }
}
