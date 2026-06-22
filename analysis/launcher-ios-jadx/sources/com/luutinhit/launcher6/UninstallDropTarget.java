package com.luutinhit.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.UserManager;
import android.util.AttributeSet;
import android.util.Pair;
import defpackage.ar1;
import defpackage.jq1;
import defpackage.l51;
import defpackage.ng;
import defpackage.nx;
import defpackage.og1;
import defpackage.qh0;
import defpackage.v6;
import defpackage.x41;
import defpackage.xw;
import defpackage.yp1;

/* JADX INFO: loaded from: classes.dex */
public class UninstallDropTarget extends ButtonDropTarget {
    public static final /* synthetic */ int t = 0;

    public UninstallDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static Pair u(Object obj) {
        if (obj instanceof v6) {
            v6 v6Var = (v6) obj;
            return Pair.create(v6Var.A, Integer.valueOf(v6Var.C));
        }
        if (!(obj instanceof og1)) {
            return null;
        }
        og1 og1Var = (og1) obj;
        ComponentName componentNameG = og1Var.g();
        if (og1Var.h != 0 || componentNameG == null) {
            return null;
        }
        return Pair.create(componentNameG, Integer.valueOf(og1Var.G));
    }

    public static boolean w(t tVar, Object obj) {
        Pair pairU = u(obj);
        return tVar.startApplicationUninstallActivity((ComponentName) pairU.first, ((Integer) pairU.second).intValue(), ((qh0) obj).w);
    }

    public static boolean x(Context context, Object obj) {
        if (ar1.p) {
            Bundle userRestrictions = ((UserManager) context.getSystemService("user")).getUserRestrictions();
            if (userRestrictions.getBoolean("no_control_apps", false) || userRestrictions.getBoolean("no_uninstall_apps", false)) {
                return false;
            }
        }
        Pair pairU = u(obj);
        return (pairU == null || (((Integer) pairU.second).intValue() & 1) == 0) ? false : true;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final void n(nx nxVar) {
        Pair pairU = u(nxVar.g);
        Object obj = nxVar.g;
        jq1 jq1Var = ((qh0) obj).w;
        if (w(this.g, obj)) {
            this.g.addOnResumeCallback(new ng(this, pairU, jq1Var, nxVar, 10));
        } else {
            xw xwVar = nxVar.h;
            if (xwVar instanceof yp1) {
                ((yp1) xwVar).o(false);
            }
        }
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    public final boolean o(xw xwVar, Object obj) {
        return x(getContext(), obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.m = getResources().getColor(x41.uninstall_target_hover_tint);
        setDrawable(l51.ic_uninstall_launcher);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, defpackage.ox
    public final void v(nx nxVar) {
        xw xwVar = nxVar.h;
        if (xwVar instanceof yp1) {
            ((yp1) xwVar).g();
        }
        super.v(nxVar);
    }
}
