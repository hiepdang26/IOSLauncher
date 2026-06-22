package defpackage;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class z21 extends w50 {
    public e31 a0;
    public RecyclerView b0;
    public boolean c0;
    public boolean d0;
    public final y21 Z = new y21(this);
    public int e0 = i61.preference_list_fragment;
    public final q3 f0 = new q3(this, Looper.getMainLooper());
    public final fl0 g0 = new fl0(this, 7);

    @Override // defpackage.w50
    public final void B() {
        fl0 fl0Var = this.g0;
        q3 q3Var = this.f0;
        q3Var.removeCallbacks(fl0Var);
        q3Var.removeMessages(1);
        if (this.c0) {
            this.b0.setAdapter(null);
            PreferenceScreen preferenceScreen = this.a0.g;
            if (preferenceScreen != null) {
                preferenceScreen.m();
            }
        }
        this.b0 = null;
        this.J = true;
    }

    @Override // defpackage.w50
    public final void G(Bundle bundle) {
        PreferenceScreen preferenceScreen = this.a0.g;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.b(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // defpackage.w50
    public void H() {
        this.J = true;
        e31 e31Var = this.a0;
        e31Var.h = this;
        e31Var.i = this;
    }

    @Override // defpackage.w50
    public final void I() {
        this.J = true;
        e31 e31Var = this.a0;
        e31Var.h = null;
        e31Var.i = null;
    }

    @Override // defpackage.w50
    public void J(View view, Bundle bundle) {
        PreferenceScreen preferenceScreen;
        Bundle bundle2;
        PreferenceScreen preferenceScreen2;
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreen2 = this.a0.g) != null) {
            preferenceScreen2.a(bundle2);
        }
        if (this.c0 && (preferenceScreen = this.a0.g) != null) {
            this.b0.setAdapter(new c31(preferenceScreen));
            preferenceScreen.i();
        }
        this.d0 = true;
    }

    public final void U(int i) {
        e31 e31Var = this.a0;
        if (e31Var == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        Context contextN = N();
        PreferenceScreen preferenceScreen = this.a0.g;
        e31Var.e = true;
        d31 d31Var = new d31(contextN, e31Var);
        XmlResourceParser xml = contextN.getResources().getXml(i);
        try {
            PreferenceGroup preferenceGroupC = d31Var.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) preferenceGroupC;
            preferenceScreen2.j(e31Var);
            SharedPreferences.Editor editor = e31Var.d;
            if (editor != null) {
                editor.apply();
            }
            e31Var.e = false;
            e31 e31Var2 = this.a0;
            PreferenceScreen preferenceScreen3 = e31Var2.g;
            if (preferenceScreen2 != preferenceScreen3) {
                if (preferenceScreen3 != null) {
                    preferenceScreen3.m();
                }
                e31Var2.g = preferenceScreen2;
                this.c0 = true;
                if (this.d0) {
                    q3 q3Var = this.f0;
                    if (q3Var.hasMessages(1)) {
                        return;
                    }
                    q3Var.obtainMessage(1).sendToTarget();
                }
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public abstract void V();

    @Override // defpackage.w50
    public void y(Bundle bundle) {
        super.y(bundle);
        TypedValue typedValue = new TypedValue();
        N().getTheme().resolveAttribute(o41.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = a71.PreferenceThemeOverlay;
        }
        N().getTheme().applyStyle(i, false);
        e31 e31Var = new e31(N());
        this.a0 = e31Var;
        e31Var.j = this;
        Bundle bundle2 = this.m;
        if (bundle2 != null) {
            bundle2.getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        }
        V();
    }

    @Override // defpackage.w50
    public View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        TypedArray typedArrayObtainStyledAttributes = N().obtainStyledAttributes(null, o71.PreferenceFragmentCompat, o41.preferenceFragmentCompatStyle, 0);
        this.e0 = typedArrayObtainStyledAttributes.getResourceId(o71.PreferenceFragmentCompat_android_layout, this.e0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(o71.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(o71.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(o71.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(N());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.e0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        if (!N().getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup2.findViewById(e61.recycler_view)) == null) {
            recyclerView = (RecyclerView) layoutInflaterCloneInContext.inflate(i61.preference_recyclerview, viewGroup2, false);
            N();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAccessibilityDelegateCompat(new f31(recyclerView));
        }
        this.b0 = recyclerView;
        y21 y21Var = this.Z;
        recyclerView.k(y21Var);
        if (drawable != null) {
            y21Var.getClass();
            y21Var.h = drawable.getIntrinsicHeight();
        } else {
            y21Var.h = 0;
        }
        y21Var.g = drawable;
        z21 z21Var = y21Var.j;
        RecyclerView recyclerView2 = z21Var.b0;
        if (recyclerView2.v.size() != 0) {
            u81 u81Var = recyclerView2.t;
            if (u81Var != null) {
                u81Var.c("Cannot invalidate item decorations during a scroll or layout");
            }
            recyclerView2.V();
            recyclerView2.requestLayout();
        }
        if (dimensionPixelSize != -1) {
            y21Var.h = dimensionPixelSize;
            RecyclerView recyclerView3 = z21Var.b0;
            if (recyclerView3.v.size() != 0) {
                u81 u81Var2 = recyclerView3.t;
                if (u81Var2 != null) {
                    u81Var2.c("Cannot invalidate item decorations during a scroll or layout");
                }
                recyclerView3.V();
                recyclerView3.requestLayout();
            }
        }
        y21Var.i = z;
        if (this.b0.getParent() == null) {
            viewGroup2.addView(this.b0);
        }
        this.f0.post(this.g0);
        return viewInflate;
    }
}
