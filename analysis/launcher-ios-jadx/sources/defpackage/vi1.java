package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class vi1 extends j1 implements et0 {
    public Context i;
    public ActionBarContextView j;
    public tu k;
    public WeakReference l;
    public boolean m;
    public gt0 n;

    @Override // defpackage.j1
    public final void a() {
        if (this.m) {
            return;
        }
        this.m = true;
        this.k.k(this);
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
        return this.n;
    }

    @Override // defpackage.j1
    public final MenuInflater d() {
        return new tk1(this.j.getContext());
    }

    @Override // defpackage.j1
    public final CharSequence e() {
        return this.j.getSubtitle();
    }

    @Override // defpackage.j1
    public final CharSequence f() {
        return this.j.getTitle();
    }

    @Override // defpackage.j1
    public final void g() {
        this.k.l(this, this.n);
    }

    @Override // defpackage.j1
    public final boolean h() {
        return this.j.isTitleOptional();
    }

    @Override // defpackage.j1
    public final void i(View view) {
        this.j.setCustomView(view);
        this.l = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.j1
    public final void j(int i) {
        k(this.i.getString(i));
    }

    @Override // defpackage.j1
    public final void k(CharSequence charSequence) {
        this.j.setSubtitle(charSequence);
    }

    @Override // defpackage.j1
    public final void l(int i) {
        m(this.i.getString(i));
    }

    @Override // defpackage.j1
    public final void m(CharSequence charSequence) {
        this.j.setTitle(charSequence);
    }

    @Override // defpackage.j1
    public final void n(boolean z) {
        this.h = z;
        this.j.setTitleOptional(z);
    }

    @Override // defpackage.et0
    public final boolean onMenuItemSelected(gt0 gt0Var, MenuItem menuItem) {
        return ((ol1) this.k.h).k(this, menuItem);
    }

    @Override // defpackage.et0
    public final void onMenuModeChange(gt0 gt0Var) {
        g();
        this.j.showOverflowMenu();
    }
}
