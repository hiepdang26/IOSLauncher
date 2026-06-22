package com.google.android.gms.internal.ads;

import defpackage.e22;
import defpackage.n42;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdof {
    private final zzcwo zza;
    private final zzcxx zzb;
    private final zzcyk zzc;
    private final zzcyw zzd;
    private final zzdbn zze;
    private final zzdeo zzf;
    private final zzdsk zzg;
    private final zzfll zzh;
    private final zzedh zzi;
    private final zzcni zzj;

    public zzdof(zzcwo zzcwoVar, zzcxx zzcxxVar, zzcyk zzcykVar, zzcyw zzcywVar, zzdbn zzdbnVar, zzdeo zzdeoVar, zzdsk zzdskVar, zzfll zzfllVar, zzedh zzedhVar, zzcni zzcniVar) {
        this.zza = zzcwoVar;
        this.zzb = zzcxxVar;
        this.zzc = zzcykVar;
        this.zzd = zzcywVar;
        this.zze = zzdbnVar;
        this.zzf = zzdeoVar;
        this.zzg = zzdskVar;
        this.zzh = zzfllVar;
        this.zzi = zzedhVar;
        this.zzj = zzcniVar;
    }

    public final void zza(zzdog zzdogVar, zzcej zzcejVar) throws Throwable {
        zzdod zzdodVar = zzdogVar.zza;
        final zzcxx zzcxxVar = this.zzb;
        Objects.requireNonNull(zzcxxVar);
        zzdodVar.zzi(this.zza, this.zzc, this.zzd, this.zze, new e22() { // from class: com.google.android.gms.internal.ads.zzdoe
            @Override // defpackage.e22
            public final void zzg() {
                zzcxxVar.zzb();
            }
        }, this.zzf);
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjm)).booleanValue() || zzcejVar == null || zzcejVar.zzN() == null) {
            return;
        }
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        zzcgbVarZzN.zzI(this.zzj, this.zzi, this.zzh);
        zzcgbVarZzN.zzK(this.zzj, this.zzi, this.zzg);
    }
}
