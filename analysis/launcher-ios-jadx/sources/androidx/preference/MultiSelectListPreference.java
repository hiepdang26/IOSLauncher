package androidx.preference;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.cv0;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] Y;
    public final CharSequence[] Z;
    public final HashSet a0;

    /* JADX WARN: Illegal instructions before constructor call */
    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        int iJ = np1.j(context, o41.dialogPreferenceStyle, R.attr.dialogPreferenceStyle);
        super(context, attributeSet, iJ, 0);
        this.a0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.MultiSelectListPreference, iJ, 0);
        int i = o71.MultiSelectListPreference_entries;
        int i2 = o71.MultiSelectListPreference_android_entries;
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(i);
        this.Y = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(i2) : textArray;
        int i3 = o71.MultiSelectListPreference_entryValues;
        int i4 = o71.MultiSelectListPreference_android_entryValues;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(i3);
        this.Z = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(i4) : textArray2;
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object n(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void o(Parcelable parcelable) {
        if (!parcelable.getClass().equals(cv0.class)) {
            super.o(parcelable);
            return;
        }
        cv0 cv0Var = (cv0) parcelable;
        super.o(cv0Var.getSuperState());
        w(cv0Var.g);
    }

    @Override // androidx.preference.Preference
    public final Parcelable p() {
        super.p();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.w) {
            return absSavedState;
        }
        cv0 cv0Var = new cv0();
        cv0Var.g = this.a0;
        return cv0Var;
    }

    @Override // androidx.preference.Preference
    public final void q(Object obj) {
        Set<String> stringSet = (Set) obj;
        if (v()) {
            stringSet = this.h.e().getStringSet(this.q, stringSet);
        }
        w(stringSet);
    }

    public final void w(Set set) {
        HashSet hashSet = this.a0;
        hashSet.clear();
        hashSet.addAll(set);
        if (v()) {
            if (!set.equals(v() ? this.h.e().getStringSet(this.q, null) : null)) {
                SharedPreferences.Editor editorC = this.h.c();
                editorC.putStringSet(this.q, set);
                if (!this.h.e) {
                    editorC.apply();
                }
            }
        }
        g();
    }
}
