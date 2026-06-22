package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzghr extends zzgex {
    private final String zza;
    private final zzghq zzb;

    private zzghr(String str, zzghq zzghqVar) {
        this.zza = str;
        this.zzb = zzghqVar;
    }

    public static zzghr zzc(String str, zzghq zzghqVar) {
        return new zzghr(str, zzghqVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghr)) {
            return false;
        }
        zzghr zzghrVar = (zzghr) obj;
        return zzghrVar.zza.equals(this.zza) && zzghrVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzghr.class, this.zza, this.zzb);
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + this.zzb.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzb != zzghq.zzb;
    }

    public final zzghq zzb() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }
}
