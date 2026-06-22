package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
final class zzbye implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyf zza;
    private final String zzb;

    public zzbye(zzbyf zzbyfVar, String str) {
        this.zza = zzbyfVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            try {
                for (zzbyd zzbydVar : this.zza.zzb) {
                    zzbydVar.zza.zzb(zzbydVar.zzb, sharedPreferences, this.zzb, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
