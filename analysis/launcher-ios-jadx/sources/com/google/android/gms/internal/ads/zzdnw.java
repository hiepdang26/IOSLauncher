package com.google.android.gms.internal.ads;

import defpackage.e22;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnw {
    private final zzcwo zza;
    private final zzcxx zzb;
    private final zzcyk zzc;
    private final zzcyw zzd;
    private final zzdbn zze;
    private final zzfel zzf;
    private final zzfeo zzg;
    private final zzcni zzh;

    public zzdnw(zzcwo zzcwoVar, zzcxx zzcxxVar, zzcyk zzcykVar, zzcyw zzcywVar, zzdbn zzdbnVar, zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar) {
        this.zza = zzcwoVar;
        this.zzb = zzcxxVar;
        this.zzc = zzcykVar;
        this.zzd = zzcywVar;
        this.zze = zzdbnVar;
        this.zzf = zzfelVar;
        this.zzg = zzfeoVar;
        this.zzh = zzcniVar;
    }

    public final void zza(zzdoa zzdoaVar) {
        final zzcxx zzcxxVar = this.zzb;
        zzdnn zzdnnVar = zzdoaVar.zza;
        Objects.requireNonNull(zzcxxVar);
        zzdnnVar.zzh(this.zza, this.zzc, this.zzd, this.zze, new e22() { // from class: com.google.android.gms.internal.ads.zzdnv
            @Override // defpackage.e22
            public final void zzg() {
                zzcxxVar.zzb();
            }
        });
        zzdoaVar.zzh(this.zzf, this.zzg, this.zzh);
    }
}
