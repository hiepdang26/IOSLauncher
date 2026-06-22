package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c31 extends m81 {
    public final PreferenceGroup j;
    public ArrayList k;
    public ArrayList l;
    public final ArrayList m;
    public final fl0 o = new fl0(this, 8);
    public final Handler n = new Handler(Looper.getMainLooper());

    public c31(PreferenceGroup preferenceGroup) {
        this.j = preferenceGroup;
        preferenceGroup.L = this;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            o(((PreferenceScreen) preferenceGroup).Y);
        } else {
            o(true);
        }
        s();
    }

    @Override // defpackage.m81
    public final int c() {
        return this.l.size();
    }

    @Override // defpackage.m81
    public final long d(int i) {
        if (this.h) {
            return r(i).c();
        }
        return -1L;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        b31 b31Var = new b31(r(i));
        ArrayList arrayList = this.m;
        int iIndexOf = arrayList.indexOf(b31Var);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = arrayList.size();
        arrayList.add(b31Var);
        return size;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        ColorStateList colorStateList;
        g31 g31Var = (g31) m91Var;
        Preference preferenceR = r(i);
        View view = g31Var.g;
        Drawable background = view.getBackground();
        Drawable drawable = g31Var.A;
        if (background != drawable) {
            WeakHashMap weakHashMap = qs1.a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) g31Var.v(R.id.title);
        if (textView != null && (colorStateList = g31Var.B) != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        preferenceR.k(g31Var);
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        b31 b31Var = (b31) this.m.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, o71.BackgroundStyle);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(o71.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = hg0.o(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(b31Var.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap weakHashMap = qs1.a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = b31Var.b;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new g31(viewInflate);
    }

    public final ArrayList p(PreferenceGroup preferenceGroup) {
        char c;
        int i = 1;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.T.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Preference preferenceX = preferenceGroup.x(i3);
            if (preferenceX.B) {
                int i4 = preferenceGroup.X;
                if (i4 == Integer.MAX_VALUE || i2 < i4) {
                    arrayList.add(preferenceX);
                } else {
                    arrayList2.add(preferenceX);
                }
                if (preferenceX instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceX;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.X != Integer.MAX_VALUE && preferenceGroup2.X != Integer.MAX_VALUE) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        ArrayList arrayListP = p(preferenceGroup2);
                        int size2 = arrayListP.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            Object obj = arrayListP.get(i5);
                            i5++;
                            Preference preference = (Preference) obj;
                            int i6 = preferenceGroup.X;
                            if (i6 == Integer.MAX_VALUE || i2 < i6) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i2++;
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        int i7 = preferenceGroup.X;
        if (i7 == Integer.MAX_VALUE || i2 <= i7) {
            return arrayList;
        }
        long j = preferenceGroup.i;
        CharSequence string = null;
        x10 x10Var = new x10(preferenceGroup.g, null);
        x10Var.J = i61.expand_button;
        int i8 = h51.ic_arrow_down_24dp;
        Context context = x10Var.g;
        Drawable drawableO = hg0.o(context, i8);
        if (x10Var.p != drawableO) {
            x10Var.p = drawableO;
            x10Var.o = 0;
            x10Var.g();
        }
        x10Var.o = i8;
        String string2 = context.getString(r61.expand_button_title);
        if (!TextUtils.equals(string2, x10Var.m)) {
            x10Var.m = string2;
            x10Var.g();
        }
        if (999 != x10Var.l) {
            x10Var.l = 999;
            c31 c31Var = x10Var.L;
            if (c31Var != null) {
                Handler handler = c31Var.n;
                fl0 fl0Var = c31Var.o;
                handler.removeCallbacks(fl0Var);
                handler.post(fl0Var);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size3 = arrayList2.size();
        int i9 = 0;
        while (i9 < size3) {
            Object obj2 = arrayList2.get(i9);
            i9 += i;
            Preference preference2 = (Preference) obj2;
            CharSequence charSequence = preference2.m;
            boolean z = preference2 instanceof PreferenceGroup;
            if (!z || TextUtils.isEmpty(charSequence)) {
                c = 0;
            } else {
                c = 0;
                arrayList3.add((PreferenceGroup) preference2);
            }
            if (arrayList3.contains(preference2.N)) {
                if (z) {
                    arrayList3.add((PreferenceGroup) preference2);
                }
            } else if (!TextUtils.isEmpty(charSequence)) {
                if (string == null) {
                    string = charSequence;
                } else {
                    int i10 = r61.summary_collapsed_preference_list;
                    Object[] objArr = new Object[2];
                    objArr[c] = string;
                    objArr[1] = charSequence;
                    string = context.getString(i10, objArr);
                }
            }
            i = 1;
        }
        if (x10Var.Q != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (!TextUtils.equals(x10Var.n, string)) {
            x10Var.n = string;
            x10Var.g();
        }
        x10Var.S = j + 1000000;
        x10Var.k = new q11(this, preferenceGroup, 18, false);
        arrayList.add(x10Var);
        return arrayList;
    }

    public final void q(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.T);
        }
        int size = preferenceGroup.T.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceX = preferenceGroup.x(i);
            arrayList.add(preferenceX);
            b31 b31Var = new b31(preferenceX);
            if (!this.m.contains(b31Var)) {
                this.m.add(b31Var);
            }
            if (preferenceX instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceX;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    q(arrayList, preferenceGroup2);
                }
            }
            preferenceX.L = this;
        }
    }

    public final Preference r(int i) {
        if (i < 0 || i >= this.l.size()) {
            return null;
        }
        return (Preference) this.l.get(i);
    }

    public final void s() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Preference) obj).L = null;
        }
        ArrayList arrayList2 = new ArrayList(this.k.size());
        this.k = arrayList2;
        PreferenceGroup preferenceGroup = this.j;
        q(arrayList2, preferenceGroup);
        this.l = p(preferenceGroup);
        f();
        ArrayList arrayList3 = this.k;
        int size2 = arrayList3.size();
        while (i < size2) {
            Object obj2 = arrayList3.get(i);
            i++;
            ((Preference) obj2).getClass();
        }
    }
}
