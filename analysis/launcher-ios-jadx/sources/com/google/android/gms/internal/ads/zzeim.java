package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.n42;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzeim {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;
    final Integer zze;

    public zzeim(String str, String str2, int i, long j, Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = j;
        this.zze = num;
    }

    public final String toString() {
        String strI = this.zza + "." + this.zzc + "." + this.zzd;
        if (!TextUtils.isEmpty(this.zzb)) {
            strI = uo.i(strI, ".", this.zzb);
        }
        if (!((Boolean) n42.d.c.zza(zzbbw.zzbs)).booleanValue() || this.zze == null || TextUtils.isEmpty(this.zzb)) {
            return strI;
        }
        return strI + "." + this.zze;
    }
}
