package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.a31;
import defpackage.o71;
import defpackage.ug1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final ug1 S;
    public final ArrayList T;
    public boolean U;
    public int V;
    public boolean W;
    public int X;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.S = new ug1(0);
        new Handler(Looper.getMainLooper());
        this.U = true;
        this.V = 0;
        this.W = false;
        this.X = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.T = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.PreferenceGroup, i, 0);
        int i2 = o71.PreferenceGroup_orderingFromXml;
        this.U = typedArrayObtainStyledAttributes.getBoolean(i2, typedArrayObtainStyledAttributes.getBoolean(i2, true));
        if (typedArrayObtainStyledAttributes.hasValue(o71.PreferenceGroup_initialExpandedChildrenCount)) {
            int i3 = o71.PreferenceGroup_initialExpandedChildrenCount;
            int i4 = typedArrayObtainStyledAttributes.getInt(i3, typedArrayObtainStyledAttributes.getInt(i3, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            if (i4 != Integer.MAX_VALUE) {
                TextUtils.isEmpty(this.q);
            }
            this.X = i4;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void a(Bundle bundle) {
        super.a(bundle);
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            x(i).a(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            x(i).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void h(boolean z) {
        super.h(z);
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceX = x(i);
            if (preferenceX.A == z) {
                preferenceX.A = !z;
                preferenceX.h(preferenceX.u());
                preferenceX.g();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void i() {
        super.i();
        this.W = true;
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            x(i).i();
        }
    }

    @Override // androidx.preference.Preference
    public final void m() {
        super.m();
        this.W = false;
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            x(i).m();
        }
    }

    @Override // androidx.preference.Preference
    public final void o(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a31.class)) {
            super.o(parcelable);
            return;
        }
        a31 a31Var = (a31) parcelable;
        this.X = a31Var.g;
        super.o(a31Var.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable p() {
        super.p();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        return new a31(this.X);
    }

    public final Preference w(String str) {
        Preference preferenceW;
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(this.q, str)) {
            return this;
        }
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceX = x(i);
            if (TextUtils.equals(preferenceX.q, str)) {
                return preferenceX;
            }
            if ((preferenceX instanceof PreferenceGroup) && (preferenceW = ((PreferenceGroup) preferenceX).w(str)) != null) {
                return preferenceW;
            }
        }
        return null;
    }

    public final Preference x(int i) {
        return (Preference) this.T.get(i);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
