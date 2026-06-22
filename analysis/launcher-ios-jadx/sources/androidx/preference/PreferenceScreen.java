package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import defpackage.np1;
import defpackage.o41;
import defpackage.w50;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean Y;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, np1.j(context, o41.preferenceScreenStyle, R.attr.preferenceScreenStyle));
        this.Y = true;
    }

    @Override // androidx.preference.Preference
    public final void l() {
        w50 w50Var;
        if (this.r != null || this.s != null || this.T.size() == 0 || (w50Var = this.h.j) == null) {
            return;
        }
        for (w50Var = this.h.j; w50Var != null; w50Var = w50Var.B) {
        }
    }
}
