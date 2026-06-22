package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzghb extends zzgex {
    private final int zza;
    private final zzggz zzb;

    public /* synthetic */ zzghb(int i, zzggz zzggzVar, zzgha zzghaVar) {
        this.zza = i;
        this.zzb = zzggzVar;
    }

    public static zzggy zzc() {
        return new zzggy(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghb)) {
            return false;
        }
        zzghb zzghbVar = (zzghb) obj;
        return zzghbVar.zza == this.zza && zzghbVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzghb.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return uo.j(uo.o("AesGcmSiv Parameters (variant: ", String.valueOf(this.zzb), ", "), this.zza, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzb != zzggz.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzggz zzd() {
        return this.zzb;
    }
}
