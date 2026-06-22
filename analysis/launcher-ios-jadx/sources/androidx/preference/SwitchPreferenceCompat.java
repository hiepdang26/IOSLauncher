package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;
import defpackage.e61;
import defpackage.g31;
import defpackage.o41;
import defpackage.o71;
import defpackage.wh;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final wh X;
    public final String Y;
    public final String Z;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.X = new wh(this, 3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.SwitchPreferenceCompat, i, i2);
        int i3 = o71.SwitchPreferenceCompat_summaryOn;
        int i4 = o71.SwitchPreferenceCompat_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        this.T = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        if (this.S) {
            g();
        }
        int i5 = o71.SwitchPreferenceCompat_summaryOff;
        int i6 = o71.SwitchPreferenceCompat_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i5);
        this.U = string2 == null ? typedArrayObtainStyledAttributes.getString(i6) : string2;
        if (!this.S) {
            g();
        }
        int i7 = o71.SwitchPreferenceCompat_switchTextOn;
        int i8 = o71.SwitchPreferenceCompat_android_switchTextOn;
        String string3 = typedArrayObtainStyledAttributes.getString(i7);
        this.Y = string3 == null ? typedArrayObtainStyledAttributes.getString(i8) : string3;
        g();
        int i9 = o71.SwitchPreferenceCompat_switchTextOff;
        int i10 = o71.SwitchPreferenceCompat_android_switchTextOff;
        String string4 = typedArrayObtainStyledAttributes.getString(i9);
        this.Z = string4 == null ? typedArrayObtainStyledAttributes.getString(i10) : string4;
        g();
        this.W = typedArrayObtainStyledAttributes.getBoolean(o71.SwitchPreferenceCompat_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(o71.SwitchPreferenceCompat_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        super.k(g31Var);
        y(g31Var.v(e61.switchWidget));
        x(g31Var.v(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void r(View view) {
        super.r(view);
        if (((AccessibilityManager) this.g.getSystemService("accessibility")).isEnabled()) {
            y(view.findViewById(e61.switchWidget));
            x(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.S);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.Y);
            switchCompat.setTextOff(this.Z);
            switchCompat.setOnCheckedChangeListener(this.X);
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, o41.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, null);
    }
}
