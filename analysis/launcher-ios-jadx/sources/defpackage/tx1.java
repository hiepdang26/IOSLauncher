package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class tx1 extends j1 implements et0 {
    public final Context i;
    public final gt0 j;
    public tu k;
    public WeakReference l;
    public final /* synthetic */ ux1 m;

    public tx1(ux1 ux1Var, Context context, tu tuVar) {
        this.m = ux1Var;
        this.i = context;
        this.k = tuVar;
        gt0 gt0Var = new gt0(context);
        gt0Var.r = 1;
        this.j = gt0Var;
        gt0Var.k = this;
    }

    @Override // defpackage.j1
    public final void a() {
        ux1 ux1Var = this.m;
        if (ux1Var.D != this) {
            return;
        }
        if (ux1Var.L) {
            ux1Var.E = this;
            ux1Var.F = this.k;
        } else {
            this.k.k(this);
        }
        this.k = null;
        ux1Var.E(false);
        ux1Var.A.closeMode();
        ux1Var.x.setHideOnContentScrollEnabled(ux1Var.Q);
        ux1Var.D = null;
    }

    @Override // defpackage.j1
    public final View b() {
        WeakReference weakReference = this.l;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.j1
    public final gt0 c() {
        return this.j;
    }

    @Override // defpackage.j1
    public final MenuInflater d() {
        return new tk1(this.i);
    }

    @Override // defpackage.j1
    public final CharSequence e() {
        return this.m.A.getSubtitle();
    }

    @Override // defpackage.j1
    public final CharSequence f() {
        return this.m.A.getTitle();
    }

    @Override // defpackage.j1
    public final void g() {
        if (this.m.D != this) {
            return;
        }
        gt0 gt0Var = this.j;
        gt0Var.w();
        try {
            this.k.l(this, gt0Var);
        } finally {
            gt0Var.v();
        }
    }

    @Override // defpackage.j1
    public final boolean h() {
        return this.m.A.isTitleOptional();
    }

    @Override // defpackage.j1
    public final void i(View view) {
        this.m.A.setCustomView(view);
        this.l = new WeakReference(view);
    }

    @Override // defpackage.j1
    public final void j(int i) {
        k(this.m.v.getResources().getString(i));
    }

    @Override // defpackage.j1
    public final void k(CharSequence charSequence) {
        this.m.A.setSubtitle(charSequence);
    }

    @Override // defpackage.j1
    public final void l(int i) {
        m(this.m.v.getResources().getString(i));
    }

    @Override // defpackage.j1
    public final void m(CharSequence charSequence) {
        this.m.A.setTitle(charSequence);
    }

    @Override // defpackage.j1
    public final void n(boolean z) {
        this.h = z;
        this.m.A.setTitleOptional(z);
    }

    @Override // defpackage.et0
    public final boolean onMenuItemSelected(gt0 gt0Var, MenuItem menuItem) {
        tu tuVar = this.k;
        if (tuVar != null) {
            return ((ol1) tuVar.h).k(this, menuItem);
        }
        return false;
    }

    @Override // defpackage.et0
    public final void onMenuModeChange(gt0 gt0Var) {
        if (this.k == null) {
            return;
        }
        g();
        this.m.A.showOverflowMenu();
    }
}
