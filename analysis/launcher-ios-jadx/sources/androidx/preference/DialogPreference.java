package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import defpackage.ca;
import defpackage.ev;
import defpackage.ev0;
import defpackage.h60;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import defpackage.oy;
import defpackage.w50;
import defpackage.z21;
import defpackage.zn0;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public final CharSequence S;
    public final String T;
    public final Drawable U;
    public final String V;
    public final String W;
    public final int X;

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.DialogPreference, i, i2);
        int i3 = o71.DialogPreference_dialogTitle;
        int i4 = o71.DialogPreference_android_dialogTitle;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        string = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        this.S = string;
        if (string == null) {
            this.S = this.m;
        }
        int i5 = o71.DialogPreference_dialogMessage;
        int i6 = o71.DialogPreference_android_dialogMessage;
        String string2 = typedArrayObtainStyledAttributes.getString(i5);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(i6) : string2;
        int i7 = o71.DialogPreference_dialogIcon;
        int i8 = o71.DialogPreference_android_dialogIcon;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(i7);
        this.U = drawable == null ? typedArrayObtainStyledAttributes.getDrawable(i8) : drawable;
        int i9 = o71.DialogPreference_positiveButtonText;
        int i10 = o71.DialogPreference_android_positiveButtonText;
        String string3 = typedArrayObtainStyledAttributes.getString(i9);
        this.V = string3 == null ? typedArrayObtainStyledAttributes.getString(i10) : string3;
        int i11 = o71.DialogPreference_negativeButtonText;
        int i12 = o71.DialogPreference_android_negativeButtonText;
        String string4 = typedArrayObtainStyledAttributes.getString(i11);
        this.W = string4 == null ? typedArrayObtainStyledAttributes.getString(i12) : string4;
        this.X = typedArrayObtainStyledAttributes.getResourceId(o71.DialogPreference_dialogLayout, typedArrayObtainStyledAttributes.getResourceId(o71.DialogPreference_android_dialogLayout, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void l() {
        ev ev0Var;
        z21 z21Var = this.h.i;
        if (z21Var != null) {
            for (w50 w50Var = z21Var; w50Var != null; w50Var = w50Var.B) {
            }
            if (z21Var.r().A("androidx.preference.PreferenceFragment.DIALOG") != null) {
                return;
            }
            if (this instanceof EditTextPreference) {
                ev0Var = new oy();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", this.q);
                ev0Var.Q(bundle);
            } else if (this instanceof ListPreference) {
                ev0Var = new zn0();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", this.q);
                ev0Var.Q(bundle2);
            } else {
                if (!(this instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                ev0Var = new ev0();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", this.q);
                ev0Var.Q(bundle3);
            }
            ev0Var.R(z21Var);
            h60 h60VarR = z21Var.r();
            ev0Var.k0 = false;
            ev0Var.l0 = true;
            ca caVar = new ca(h60VarR);
            caVar.e(0, ev0Var, "androidx.preference.PreferenceFragment.DIALOG", 1);
            caVar.d(false);
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, np1.j(context, o41.dialogPreferenceStyle, R.attr.dialogPreferenceStyle), 0);
    }
}
