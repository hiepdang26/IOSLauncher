package com.luutinhit.launcherios.fragment;

import android.content.SharedPreferences;
import defpackage.ar1;
import defpackage.r71;
import defpackage.z21;

/* JADX INFO: loaded from: classes.dex */
public class LiquidGlassConfigFragment extends z21 implements SharedPreferences.OnSharedPreferenceChangeListener {
    public boolean h0 = false;

    @Override // defpackage.w50
    public final void E() {
        this.J = true;
        SharedPreferences sharedPreferencesE = this.a0.e();
        if (sharedPreferencesE != null) {
            sharedPreferencesE.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    @Override // defpackage.w50
    public final void F() {
        this.J = true;
        SharedPreferences sharedPreferencesE = this.a0.e();
        if (sharedPreferencesE != null) {
            sharedPreferencesE.registerOnSharedPreferenceChangeListener(this);
            this.h0 = sharedPreferencesE.getBoolean("preference_liquid_glass", false);
        }
    }

    @Override // defpackage.z21
    public final void V() {
        U(r71.liquid_glass_config);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        boolean z;
        if (!"preference_liquid_glass".equals(str) || this.h0 == (z = sharedPreferences.getBoolean(str, false))) {
            return;
        }
        this.h0 = z;
        if (d() != null) {
            ar1.z(d());
        }
    }
}
