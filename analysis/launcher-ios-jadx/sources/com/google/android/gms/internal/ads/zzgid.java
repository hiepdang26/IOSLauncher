package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgid extends zzgex {
    private final zzgib zza;
    private final String zzb;
    private final zzgia zzc;
    private final zzgex zzd;

    public /* synthetic */ zzgid(zzgib zzgibVar, String str, zzgia zzgiaVar, zzgex zzgexVar, zzgic zzgicVar) {
        this.zza = zzgibVar;
        this.zzb = str;
        this.zzc = zzgiaVar;
        this.zzd = zzgexVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgid)) {
            return false;
        }
        zzgid zzgidVar = (zzgid) obj;
        return zzgidVar.zzc.equals(this.zzc) && zzgidVar.zzd.equals(this.zzd) && zzgidVar.zzb.equals(this.zzb) && zzgidVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzgid.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzgib zzgibVar = this.zza;
        zzgex zzgexVar = this.zzd;
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + String.valueOf(this.zzc) + ", dekParametersForNewKeys: " + String.valueOf(zzgexVar) + ", variant: " + String.valueOf(zzgibVar) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zza != zzgib.zzb;
    }

    public final zzgex zzb() {
        return this.zzd;
    }

    public final zzgib zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }
}
