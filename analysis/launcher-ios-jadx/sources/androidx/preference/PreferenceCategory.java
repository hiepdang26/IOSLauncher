package androidx.preference;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import defpackage.g31;
import defpackage.np1;
import defpackage.o41;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, np1.j(context, o41.preferenceCategoryStyle, R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public final boolean f() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        super.k(g31Var);
        if (Build.VERSION.SDK_INT >= 28) {
            g31Var.g.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final boolean u() {
        return !super.f();
    }
}
