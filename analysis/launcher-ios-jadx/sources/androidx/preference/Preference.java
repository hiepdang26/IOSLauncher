package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.c31;
import defpackage.c60;
import defpackage.ca;
import defpackage.e31;
import defpackage.e61;
import defpackage.fl0;
import defpackage.g31;
import defpackage.h60;
import defpackage.hg0;
import defpackage.i61;
import defpackage.np1;
import defpackage.o41;
import defpackage.o71;
import defpackage.q11;
import defpackage.q21;
import defpackage.qs1;
import defpackage.s21;
import defpackage.t21;
import defpackage.uo;
import defpackage.w50;
import defpackage.z21;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public int J;
    public final int K;
    public c31 L;
    public ArrayList M;
    public PreferenceGroup N;
    public boolean O;
    public s21 P;
    public t21 Q;
    public final q21 R;
    public final Context g;
    public e31 h;
    public long i;
    public boolean j;
    public q11 k;
    public int l;
    public CharSequence m;
    public CharSequence n;
    public int o;
    public Drawable p;
    public final String q;
    public Intent r;
    public final String s;
    public Bundle t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final String x;
    public final Object y;
    public boolean z;

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.l = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.u = true;
        this.v = true;
        this.w = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.C = true;
        this.D = true;
        this.F = true;
        this.I = true;
        this.J = i61.preference;
        this.R = new q21(this);
        this.g = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.Preference, i, i2);
        this.o = typedArrayObtainStyledAttributes.getResourceId(o71.Preference_icon, typedArrayObtainStyledAttributes.getResourceId(o71.Preference_android_icon, 0));
        int i3 = o71.Preference_key;
        int i4 = o71.Preference_android_key;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        this.q = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        int i5 = o71.Preference_title;
        int i6 = o71.Preference_android_title;
        CharSequence text = typedArrayObtainStyledAttributes.getText(i5);
        this.m = text == null ? typedArrayObtainStyledAttributes.getText(i6) : text;
        int i7 = o71.Preference_summary;
        int i8 = o71.Preference_android_summary;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(i7);
        this.n = text2 == null ? typedArrayObtainStyledAttributes.getText(i8) : text2;
        this.l = typedArrayObtainStyledAttributes.getInt(o71.Preference_order, typedArrayObtainStyledAttributes.getInt(o71.Preference_android_order, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        int i9 = o71.Preference_fragment;
        int i10 = o71.Preference_android_fragment;
        String string2 = typedArrayObtainStyledAttributes.getString(i9);
        this.s = string2 == null ? typedArrayObtainStyledAttributes.getString(i10) : string2;
        this.J = typedArrayObtainStyledAttributes.getResourceId(o71.Preference_layout, typedArrayObtainStyledAttributes.getResourceId(o71.Preference_android_layout, i61.preference));
        this.K = typedArrayObtainStyledAttributes.getResourceId(o71.Preference_widgetLayout, typedArrayObtainStyledAttributes.getResourceId(o71.Preference_android_widgetLayout, 0));
        this.u = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_enabled, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_enabled, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_selectable, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_selectable, true));
        this.v = z;
        this.w = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_persistent, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_persistent, true));
        int i11 = o71.Preference_dependency;
        int i12 = o71.Preference_android_dependency;
        String string3 = typedArrayObtainStyledAttributes.getString(i11);
        this.x = string3 == null ? typedArrayObtainStyledAttributes.getString(i12) : string3;
        int i13 = o71.Preference_allowDividerAbove;
        this.C = typedArrayObtainStyledAttributes.getBoolean(i13, typedArrayObtainStyledAttributes.getBoolean(i13, z));
        int i14 = o71.Preference_allowDividerBelow;
        this.D = typedArrayObtainStyledAttributes.getBoolean(i14, typedArrayObtainStyledAttributes.getBoolean(i14, z));
        if (typedArrayObtainStyledAttributes.hasValue(o71.Preference_defaultValue)) {
            this.y = n(typedArrayObtainStyledAttributes, o71.Preference_defaultValue);
        } else if (typedArrayObtainStyledAttributes.hasValue(o71.Preference_android_defaultValue)) {
            this.y = n(typedArrayObtainStyledAttributes, o71.Preference_android_defaultValue);
        }
        this.I = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_shouldDisableView, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_shouldDisableView, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(o71.Preference_singleLineTitle);
        this.E = zHasValue;
        if (zHasValue) {
            this.F = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_singleLineTitle, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_singleLineTitle, true));
        }
        this.G = typedArrayObtainStyledAttributes.getBoolean(o71.Preference_iconSpaceReserved, typedArrayObtainStyledAttributes.getBoolean(o71.Preference_android_iconSpaceReserved, false));
        int i15 = o71.Preference_isPreferenceVisible;
        this.B = typedArrayObtainStyledAttributes.getBoolean(i15, typedArrayObtainStyledAttributes.getBoolean(i15, true));
        int i16 = o71.Preference_enableCopying;
        this.H = typedArrayObtainStyledAttributes.getBoolean(i16, typedArrayObtainStyledAttributes.getBoolean(i16, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void t(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                t(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void a(Bundle bundle) {
        Parcelable parcelable;
        if (TextUtils.isEmpty(this.q) || (parcelable = bundle.getParcelable(this.q)) == null) {
            return;
        }
        this.O = false;
        o(parcelable);
        if (!this.O) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void b(Bundle bundle) {
        if (TextUtils.isEmpty(this.q)) {
            return;
        }
        this.O = false;
        Parcelable parcelableP = p();
        if (!this.O) {
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
        if (parcelableP != null) {
            bundle.putParcelable(this.q, parcelableP);
        }
    }

    public long c() {
        return this.i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.l;
        int i2 = preference2.l;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.m;
        CharSequence charSequence2 = preference2.m;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.m.toString());
    }

    public final String d(String str) {
        return !v() ? str : this.h.e().getString(this.q, str);
    }

    public CharSequence e() {
        t21 t21Var = this.Q;
        return t21Var != null ? t21Var.n(this) : this.n;
    }

    public boolean f() {
        return this.u && this.z && this.A;
    }

    public void g() {
        int iIndexOf;
        c31 c31Var = this.L;
        if (c31Var == null || (iIndexOf = c31Var.l.indexOf(this)) == -1) {
            return;
        }
        c31Var.g.d(iIndexOf, 1, this);
    }

    public void h(boolean z) {
        ArrayList arrayList = this.M;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Preference preference = (Preference) arrayList.get(i);
            if (preference.z == z) {
                preference.z = !z;
                preference.h(preference.u());
                preference.g();
            }
        }
    }

    public void i() {
        PreferenceScreen preferenceScreen;
        String str = this.x;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e31 e31Var = this.h;
        Preference preferenceW = null;
        if (e31Var != null && (preferenceScreen = e31Var.g) != null) {
            preferenceW = preferenceScreen.w(str);
        }
        if (preferenceW == null) {
            StringBuilder sbO = uo.o("Dependency \"", str, "\" not found for preference \"");
            sbO.append(this.q);
            sbO.append("\" (title: \"");
            sbO.append((Object) this.m);
            sbO.append("\"");
            throw new IllegalStateException(sbO.toString());
        }
        if (preferenceW.M == null) {
            preferenceW.M = new ArrayList();
        }
        preferenceW.M.add(this);
        boolean zU = preferenceW.u();
        if (this.z == zU) {
            this.z = !zU;
            h(u());
            g();
        }
    }

    public final void j(e31 e31Var) {
        this.h = e31Var;
        if (!this.j) {
            this.i = e31Var.d();
        }
        if (v()) {
            e31 e31Var2 = this.h;
            if ((e31Var2 != null ? e31Var2.e() : null).contains(this.q)) {
                q(null);
                return;
            }
        }
        Object obj = this.y;
        if (obj != null) {
            q(obj);
        }
    }

    public void k(g31 g31Var) {
        Integer numValueOf;
        q21 q21Var = this.R;
        View view = g31Var.g;
        view.setOnClickListener(q21Var);
        view.setId(0);
        TextView textView = (TextView) g31Var.v(R.id.summary);
        if (textView != null) {
            CharSequence charSequenceE = e();
            if (TextUtils.isEmpty(charSequenceE)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceE);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) g31Var.v(R.id.title);
        boolean z = this.v;
        if (textView2 != null) {
            CharSequence charSequence = this.m;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.E) {
                    textView2.setSingleLine(this.F);
                }
                if (!z && f() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) g31Var.v(R.id.icon);
        boolean z2 = this.G;
        if (imageView != null) {
            int i = this.o;
            if (i != 0 || this.p != null) {
                if (this.p == null) {
                    this.p = hg0.o(this.g, i);
                }
                Drawable drawable = this.p;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.p != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z2 ? 4 : 8);
            }
        }
        View viewV = g31Var.v(e61.icon_frame);
        if (viewV == null) {
            viewV = g31Var.v(R.id.icon_frame);
        }
        if (viewV != null) {
            if (this.p != null) {
                viewV.setVisibility(0);
            } else {
                viewV.setVisibility(z2 ? 4 : 8);
            }
        }
        if (this.I) {
            t(view, f());
        } else {
            t(view, true);
        }
        view.setFocusable(z);
        view.setClickable(z);
        g31Var.D = this.C;
        g31Var.E = this.D;
        boolean z3 = this.H;
        if (z3 && this.P == null) {
            this.P = new s21(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.P : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap weakHashMap = qs1.a;
        view.setBackground(null);
    }

    public void l() {
    }

    public void m() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.x;
        if (str != null) {
            e31 e31Var = this.h;
            Preference preferenceW = null;
            if (e31Var != null && (preferenceScreen = e31Var.g) != null) {
                preferenceW = preferenceScreen.w(str);
            }
            if (preferenceW == null || (arrayList = preferenceW.M) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object n(TypedArray typedArray, int i) {
        return null;
    }

    public void o(Parcelable parcelable) {
        this.O = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable p() {
        this.O = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void q(Object obj) {
    }

    public void r(View view) {
        z21 z21Var;
        String str;
        if (f() && this.v) {
            l();
            q11 q11Var = this.k;
            if (q11Var != null) {
                ((PreferenceGroup) q11Var.h).X = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                c31 c31Var = (c31) q11Var.i;
                Handler handler = c31Var.n;
                fl0 fl0Var = c31Var.o;
                handler.removeCallbacks(fl0Var);
                handler.post(fl0Var);
                return;
            }
            e31 e31Var = this.h;
            if (e31Var == null || (z21Var = e31Var.h) == null || (str = this.s) == null) {
                Intent intent = this.r;
                if (intent != null) {
                    this.g.startActivity(intent);
                    return;
                }
                return;
            }
            for (w50 w50Var = z21Var; w50Var != null; w50Var = w50Var.B) {
            }
            h60 h60VarR = z21Var.r();
            if (this.t == null) {
                this.t = new Bundle();
            }
            Bundle bundle = this.t;
            c60 c60VarC = h60VarR.C();
            z21Var.M().getClassLoader();
            w50 w50VarA = c60VarC.a(str);
            w50VarA.Q(bundle);
            w50VarA.R(z21Var);
            ca caVar = new ca(h60VarR);
            caVar.g(((View) z21Var.O().getParent()).getId(), w50VarA);
            if (!caVar.h) {
                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
            }
            caVar.g = true;
            caVar.i = null;
            caVar.d(false);
        }
    }

    public final void s(String str) {
        if (v() && !TextUtils.equals(str, d(null))) {
            SharedPreferences.Editor editorC = this.h.c();
            editorC.putString(this.q, str);
            if (this.h.e) {
                return;
            }
            editorC.apply();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.m;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceE = e();
        if (!TextUtils.isEmpty(charSequenceE)) {
            sb.append(charSequenceE);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public boolean u() {
        return !f();
    }

    public final boolean v() {
        return (this.h == null || !this.w || TextUtils.isEmpty(this.q)) ? false : true;
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, np1.j(context, o41.preferenceStyle, R.attr.preferenceStyle), 0);
    }
}
