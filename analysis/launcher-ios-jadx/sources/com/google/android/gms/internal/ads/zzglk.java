package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzglk extends zzgen {
    private final zzgnm zza;

    public zzglk(zzgnm zzgnmVar) {
        this.zza = zzgnmVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzglk)) {
            return false;
        }
        zzgnm zzgnmVar = ((zzglk) obj).zza;
        return this.zza.zzc().zzg().equals(zzgnmVar.zzc().zzg()) && this.zza.zzc().zzi().equals(zzgnmVar.zzc().zzi()) && this.zza.zzc().zzh().equals(zzgnmVar.zzc().zzh());
    }

    public final int hashCode() {
        zzgnm zzgnmVar = this.zza;
        return Objects.hash(zzgnmVar.zzc(), zzgnmVar.zzd());
    }

    public final String toString() {
        String strZzi = this.zza.zzc().zzi();
        int iOrdinal = this.zza.zzc().zzg().ordinal();
        return "(typeUrl=" + strZzi + ", outputPrefixType=" + (iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK") + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zza.zzc().zzg() != zzgtz.RAW;
    }

    public final zzgnm zzb() {
        return this.zza;
    }
}
