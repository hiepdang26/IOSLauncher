package defpackage;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class sr0<S> extends a21 {
    public int a0;
    public lf b0;

    @Override // defpackage.w50
    public final void G(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.a0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.b0);
    }

    @Override // defpackage.w50
    public final void y(Bundle bundle) {
        super.y(bundle);
        if (bundle == null) {
            bundle = this.m;
        }
        this.a0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.b0 = (lf) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(p(), this.a0));
        throw null;
    }
}
