package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
final class zzbbt implements zzbeh {
    final /* synthetic */ SharedPreferences zza;

    public zzbbt(zzbbu zzbbuVar, SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
    }

    @Override // com.google.android.gms.internal.ads.zzbeh
    public final Boolean zza(String str, boolean z) {
        try {
            return Boolean.valueOf(this.zza.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.getString(str, String.valueOf(z)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeh
    public final Double zzb(String str, double d) {
        try {
            return Double.valueOf(this.zza.getFloat(str, (float) d));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.getString(str, String.valueOf(d)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeh
    public final Long zzc(String str, long j) {
        try {
            return Long.valueOf(this.zza.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zza.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeh
    public final String zzd(String str, String str2) {
        return this.zza.getString(str, str2);
    }
}
