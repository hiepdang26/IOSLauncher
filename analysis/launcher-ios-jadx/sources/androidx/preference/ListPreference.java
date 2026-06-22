package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.jl1;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import defpackage.t21;
import defpackage.xn0;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] Y;
    public final CharSequence[] Z;
    public String a0;
    public final String b0;
    public boolean c0;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.ListPreference, i, i2);
        int i3 = o71.ListPreference_entries;
        int i4 = o71.ListPreference_android_entries;
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(i3);
        this.Y = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(i4) : textArray;
        int i5 = o71.ListPreference_entryValues;
        int i6 = o71.ListPreference_android_entryValues;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(i5);
        this.Z = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(i6) : textArray2;
        int i7 = o71.ListPreference_useSimpleSummaryProvider;
        if (typedArrayObtainStyledAttributes.getBoolean(i7, typedArrayObtainStyledAttributes.getBoolean(i7, false))) {
            if (jl1.n == null) {
                jl1.n = new jl1(25);
            }
            this.Q = jl1.n;
            g();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, o71.Preference, i, i2);
        int i8 = o71.Preference_summary;
        int i9 = o71.Preference_android_summary;
        String string = typedArrayObtainStyledAttributes2.getString(i8);
        this.b0 = string == null ? typedArrayObtainStyledAttributes2.getString(i9) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence e() {
        CharSequence[] charSequenceArr;
        t21 t21Var = this.Q;
        if (t21Var != null) {
            return t21Var.n(this);
        }
        int iW = w(this.a0);
        CharSequence charSequence = (iW < 0 || (charSequenceArr = this.Y) == null) ? null : charSequenceArr[iW];
        CharSequence charSequenceE = super.e();
        String str = this.b0;
        if (str != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            String str2 = String.format(str, charSequence);
            if (!TextUtils.equals(str2, charSequenceE)) {
                return str2;
            }
        }
        return charSequenceE;
    }

    @Override // androidx.preference.Preference
    public final Object n(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void o(Parcelable parcelable) {
        if (!parcelable.getClass().equals(xn0.class)) {
            super.o(parcelable);
            return;
        }
        xn0 xn0Var = (xn0) parcelable;
        super.o(xn0Var.getSuperState());
        x(xn0Var.g);
    }

    @Override // androidx.preference.Preference
    public final Parcelable p() {
        super.p();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.w) {
            return absSavedState;
        }
        xn0 xn0Var = new xn0();
        xn0Var.g = this.a0;
        return xn0Var;
    }

    @Override // androidx.preference.Preference
    public final void q(Object obj) {
        x(d((String) obj));
    }

    public final int w(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.Z) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final void x(String str) {
        boolean zEquals = TextUtils.equals(this.a0, str);
        if (zEquals && this.c0) {
            return;
        }
        this.a0 = str;
        this.c0 = true;
        s(str);
        if (zEquals) {
            return;
        }
        g();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, np1.j(context, o41.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context) {
        this(context, null);
    }
}
