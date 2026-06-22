package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzerx implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzerx(Context context, zzgcu zzgcuVar) {
        this.zza = context;
        this.zzb = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 18;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeru
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzerw zzc() {
        Bundle bundle;
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        zzbbn zzbbnVar = zzbbw.zzfu;
        n42 n42Var = n42.d;
        String string = !((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() ? "" : this.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
        String string2 = ((Boolean) n42Var.c.zza(zzbbw.zzfw)).booleanValue() ? this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        cd2 cd2Var2 = hd2Var.c;
        Context context = this.zza;
        if (((Boolean) n42Var.c.zza(zzbbw.zzfv)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
        } else {
            bundle = null;
        }
        return new zzerw(string, string2, bundle, null);
    }
}
