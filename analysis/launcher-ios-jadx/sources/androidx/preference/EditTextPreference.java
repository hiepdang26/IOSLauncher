package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.ka0;
import defpackage.np1;
import defpackage.ny;
import defpackage.o41;
import defpackage.o71;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String Y;

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iJ = np1.j(context, o41.editTextPreferenceStyle, R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iJ, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.EditTextPreference, iJ, 0);
        int i = o71.EditTextPreference_useSimpleSummaryProvider;
        if (typedArrayObtainStyledAttributes.getBoolean(i, typedArrayObtainStyledAttributes.getBoolean(i, false))) {
            if (ka0.p == null) {
                ka0.p = new ka0(15);
            }
            this.Q = ka0.p;
            g();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object n(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void o(Parcelable parcelable) {
        if (!parcelable.getClass().equals(ny.class)) {
            super.o(parcelable);
            return;
        }
        ny nyVar = (ny) parcelable;
        super.o(nyVar.getSuperState());
        w(nyVar.g);
    }

    @Override // androidx.preference.Preference
    public final Parcelable p() {
        super.p();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.w) {
            return absSavedState;
        }
        ny nyVar = new ny();
        nyVar.g = this.Y;
        return nyVar;
    }

    @Override // androidx.preference.Preference
    public final void q(Object obj) {
        w(d((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean u() {
        return TextUtils.isEmpty(this.Y) || super.u();
    }

    public final void w(String str) {
        boolean zU = u();
        this.Y = str;
        s(str);
        boolean zU2 = u();
        if (zU2 != zU) {
            h(zU2);
        }
        g();
    }
}
