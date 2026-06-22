package com.bumptech.glide.manager;

import defpackage.cn0;
import defpackage.dn0;
import defpackage.en0;
import defpackage.um0;
import defpackage.vm0;
import defpackage.vq1;
import defpackage.vy0;
import defpackage.wm0;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleLifecycle implements wm0, dn0 {
    public final HashSet g = new HashSet();
    public final androidx.lifecycle.a h;

    public LifecycleLifecycle(androidx.lifecycle.a aVar) {
        this.h = aVar;
        aVar.a(this);
    }

    @Override // defpackage.wm0
    public final void g(cn0 cn0Var) {
        this.g.remove(cn0Var);
    }

    @Override // defpackage.wm0
    public final void h(cn0 cn0Var) {
        this.g.add(cn0Var);
        vm0 vm0Var = this.h.c;
        if (vm0Var == vm0.g) {
            cn0Var.onDestroy();
        } else if (vm0Var.compareTo(vm0.j) >= 0) {
            cn0Var.j();
        } else {
            cn0Var.b();
        }
    }

    @vy0(um0.ON_DESTROY)
    public void onDestroy(en0 en0Var) {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((cn0) obj).onDestroy();
        }
        en0Var.l().f(this);
    }

    @vy0(um0.ON_START)
    public void onStart(en0 en0Var) {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((cn0) obj).j();
        }
    }

    @vy0(um0.ON_STOP)
    public void onStop(en0 en0Var) {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((cn0) obj).b();
        }
    }
}
