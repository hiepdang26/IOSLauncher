package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;
import defpackage.g31;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import defpackage.wh;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final wh X;
    public final String Y;
    public final String Z;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(Context context, AttributeSet attributeSet) {
        int iJ = np1.j(context, o41.switchPreferenceStyle, R.attr.switchPreferenceStyle);
        super(context, attributeSet, iJ, 0);
        this.X = new wh(this, 2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.SwitchPreference, iJ, 0);
        int i = o71.SwitchPreference_summaryOn;
        int i2 = o71.SwitchPreference_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i);
        this.T = string == null ? typedArrayObtainStyledAttributes.getString(i2) : string;
        if (this.S) {
            g();
        }
        int i3 = o71.SwitchPreference_summaryOff;
        int i4 = o71.SwitchPreference_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i3);
        this.U = string2 == null ? typedArrayObtainStyledAttributes.getString(i4) : string2;
        if (!this.S) {
            g();
        }
        int i5 = o71.SwitchPreference_switchTextOn;
        int i6 = o71.SwitchPreference_android_switchTextOn;
        String string3 = typedArrayObtainStyledAttributes.getString(i5);
        this.Y = string3 == null ? typedArrayObtainStyledAttributes.getString(i6) : string3;
        g();
        int i7 = o71.SwitchPreference_switchTextOff;
        int i8 = o71.SwitchPreference_android_switchTextOff;
        String string4 = typedArrayObtainStyledAttributes.getString(i7);
        this.Z = string4 == null ? typedArrayObtainStyledAttributes.getString(i8) : string4;
        g();
        this.W = typedArrayObtainStyledAttributes.getBoolean(o71.SwitchPreference_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(o71.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        super.k(g31Var);
        y(g31Var.v(R.id.switch_widget));
        x(g31Var.v(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void r(View view) {
        super.r(view);
        if (((AccessibilityManager) this.g.getSystemService("accessibility")).isEnabled()) {
            y(view.findViewById(R.id.switch_widget));
            x(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.S);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.Y);
            r4.setTextOff(this.Z);
            r4.setOnCheckedChangeListener(this.X);
        }
    }
}
