package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfp extends zzgex {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgfn zze;
    private final zzgfm zzf;

    public /* synthetic */ zzgfp(int i, int i2, int i3, int i4, zzgfn zzgfnVar, zzgfm zzgfmVar, zzgfo zzgfoVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzgfnVar;
        this.zzf = zzgfmVar;
    }

    public static zzgfl zzf() {
        return new zzgfl(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfp)) {
            return false;
        }
        zzgfp zzgfpVar = (zzgfp) obj;
        return zzgfpVar.zza == this.zza && zzgfpVar.zzb == this.zzb && zzgfpVar.zzc == this.zzc && zzgfpVar.zzd == this.zzd && zzgfpVar.zze == this.zze && zzgfpVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzgfp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzgfm zzgfmVar = this.zzf;
        String strValueOf = String.valueOf(this.zze);
        String strValueOf2 = String.valueOf(zzgfmVar);
        StringBuilder sb = new StringBuilder("AesCtrHmacAead Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(this.zzc);
        sb.append("-byte IV, and ");
        sb.append(this.zzd);
        sb.append("-byte tags, and ");
        sb.append(this.zza);
        sb.append("-byte AES key, and ");
        return uo.j(sb, this.zzb, "-byte HMAC key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zze != zzgfn.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzgfm zzg() {
        return this.zzf;
    }

    public final zzgfn zzh() {
        return this.zze;
    }
}
