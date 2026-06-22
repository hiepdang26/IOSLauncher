package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import defpackage.ib2;
import defpackage.n42;
import defpackage.qg0;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final za2 zzc;
    private String zzd = "-1";
    private int zze = -1;

    public zzbxm(Context context, za2 za2Var) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = za2Var;
        this.zza = context;
    }

    private final void zzb() {
        ((ib2) this.zzc).g(true);
        qg0.U(this.zza);
    }

    private final void zzc(String str, int i) {
        Context context;
        zzbbn zzbbnVar = zzbbw.zzaq;
        n42 n42Var = n42.d;
        boolean z = true;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() ? !(str.isEmpty() || str.charAt(0) != '1') : !(i == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1")))) {
            z = false;
        }
        ((ib2) this.zzc).g(z);
        if (((Boolean) n42Var.c.zza(zzbbw.zzfB)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxm.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (((Boolean) n42.d.c.zza(zzbbw.zzas)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
        } else {
            onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
        }
    }
}
