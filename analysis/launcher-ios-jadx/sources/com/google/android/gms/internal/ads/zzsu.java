package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzsu {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzsu(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzsu.class) {
            zzsu zzsuVar = (zzsu) obj;
            if (TextUtils.equals(this.zza, zzsuVar.zza) && this.zzb == zzsuVar.zzb && this.zzc == zzsuVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31) + (true != this.zzc ? 1237 : 1231);
    }
}
