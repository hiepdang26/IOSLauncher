package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import defpackage.g31;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import defpackage.wh;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final wh X;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iJ = np1.j(context, o41.checkBoxPreferenceStyle, R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iJ, 0);
        this.X = new wh(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.CheckBoxPreference, iJ, 0);
        int i = o71.CheckBoxPreference_summaryOn;
        int i2 = o71.CheckBoxPreference_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i);
        this.T = string == null ? typedArrayObtainStyledAttributes.getString(i2) : string;
        if (this.S) {
            g();
        }
        int i3 = o71.CheckBoxPreference_summaryOff;
        int i4 = o71.CheckBoxPreference_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i3);
        this.U = string2 == null ? typedArrayObtainStyledAttributes.getString(i4) : string2;
        if (!this.S) {
            g();
        }
        this.W = typedArrayObtainStyledAttributes.getBoolean(o71.CheckBoxPreference_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(o71.CheckBoxPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        super.k(g31Var);
        y(g31Var.v(R.id.checkbox));
        x(g31Var.v(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void r(View view) {
        super.r(view);
        if (((AccessibilityManager) this.g.getSystemService("accessibility")).isEnabled()) {
            y(view.findViewById(R.id.checkbox));
            x(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.S);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.X);
        }
    }
}
