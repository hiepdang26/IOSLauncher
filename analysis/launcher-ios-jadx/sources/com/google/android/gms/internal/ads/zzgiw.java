package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiw extends zzgex {
    private final zzgiv zza;

    private zzgiw(zzgiv zzgivVar) {
        this.zza = zzgivVar;
    }

    public static zzgiw zzc(zzgiv zzgivVar) {
        return new zzgiw(zzgivVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgiw) && ((zzgiw) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgiw.class, this.zza);
    }

    public final String toString() {
        return uo.t("XChaCha20Poly1305 Parameters (variant: ", this.zza.toString(), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zza != zzgiv.zzc;
    }

    public final zzgiv zzb() {
        return this.zza;
    }
}
