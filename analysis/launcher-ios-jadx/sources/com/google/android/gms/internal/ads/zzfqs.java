package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfqs extends zzfqy {
    private final String zzb;
    private final int zzc;

    public /* synthetic */ zzfqs(String str, boolean z, boolean z2, zzfqo zzfqoVar, zzfqp zzfqpVar, int i, zzfqr zzfqrVar) {
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfqy) {
            zzfqy zzfqyVar = (zzfqy) obj;
            if (this.zzb.equals(zzfqyVar.zzc())) {
                zzfqyVar.zzd();
                zzfqyVar.zze();
                zzfqyVar.zza();
                zzfqyVar.zzb();
                int i = this.zzc;
                int iZzf = zzfqyVar.zzf();
                if (i == 0) {
                    throw null;
                }
                if (iZzf == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        if (this.zzc != 0) {
            return (((((iHashCode * 1000003) ^ 1237) * 1000003) ^ 1237) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str = this.zzc != 1 ? "null" : "READ_AND_WRITE";
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=false, skipChecks=false, dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + str + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqo zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqp zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final int zzf() {
        return this.zzc;
    }
}
