package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgls {
    private final zzgea zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    public /* synthetic */ zzgls(zzgea zzgeaVar, int i, String str, String str2, zzglr zzglrVar) {
        this.zza = zzgeaVar;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgls)) {
            return false;
        }
        zzgls zzglsVar = (zzgls) obj;
        return this.zza == zzglsVar.zza && this.zzb == zzglsVar.zzb && this.zzc.equals(zzglsVar.zzc) && this.zzd.equals(zzglsVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        return "(status=" + this.zza + ", keyId=" + this.zzb + ", keyType='" + this.zzc + "', keyPrefix='" + this.zzd + "')";
    }

    public final int zza() {
        return this.zzb;
    }
}
