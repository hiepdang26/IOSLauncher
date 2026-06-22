package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import defpackage.b42;
import defpackage.bn0;
import defpackage.ca;
import defpackage.e6;
import defpackage.e82;
import defpackage.h60;
import defpackage.hg0;
import defpackage.xm0;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleCallback {
    public final Object g;

    public LifecycleCallback(bn0 bn0Var) {
        this.g = bn0Var;
    }

    public static bn0 b(Activity activity) {
        b42 b42Var;
        e82 e82Var;
        hg0.j(activity, "Activity must not be null");
        if (!(activity instanceof e6)) {
            WeakHashMap weakHashMap = b42.j;
            WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
            if (weakReference != null && (b42Var = (b42) weakReference.get()) != null) {
                return b42Var;
            }
            try {
                b42 b42Var2 = (b42) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (b42Var2 == null || b42Var2.isRemoving()) {
                    b42Var2 = new b42();
                    activity.getFragmentManager().beginTransaction().add(b42Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                weakHashMap.put(activity, new WeakReference(b42Var2));
                return b42Var2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        e6 e6Var = (e6) activity;
        WeakHashMap weakHashMap2 = e82.c0;
        WeakReference weakReference2 = (WeakReference) weakHashMap2.get(e6Var);
        if (weakReference2 != null && (e82Var = (e82) weakReference2.get()) != null) {
            return e82Var;
        }
        try {
            e82 e82Var2 = (e82) e6Var.o().A("SupportLifecycleFragmentImpl");
            if (e82Var2 == null || e82Var2.s) {
                e82Var2 = new e82();
                h60 h60VarO = e6Var.o();
                h60VarO.getClass();
                ca caVar = new ca(h60VarO);
                caVar.e(0, e82Var2, "SupportLifecycleFragmentImpl", 1);
                caVar.d(true);
            }
            weakHashMap2.put(e6Var, new WeakReference(e82Var2));
            return e82Var2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    private static bn0 getChimeraLifecycleFragmentImpl(xm0 xm0Var) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [bn0, java.lang.Object] */
    public final Activity a() {
        Activity activityD = this.g.d();
        hg0.i(activityD);
        return activityD;
    }

    public void c(int i, int i2, Intent intent) {
    }

    public void d(Bundle bundle) {
    }

    public void e() {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }
}
