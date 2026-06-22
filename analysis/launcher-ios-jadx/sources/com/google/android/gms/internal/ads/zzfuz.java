package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfuz extends zzfus {
    private final Object zza;

    public zzfuz(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfuz) {
            return this.zza.equals(((zzfuz) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return uo.t("Optional.of(", this.zza.toString(), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzfus
    public final zzfus zza(zzful zzfulVar) {
        Object objApply = zzfulVar.apply(this.zza);
        zzfuu.zzc(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzfuz(objApply);
    }

    @Override // com.google.android.gms.internal.ads.zzfus
    public final Object zzb(Object obj) {
        return this.zza;
    }
}
