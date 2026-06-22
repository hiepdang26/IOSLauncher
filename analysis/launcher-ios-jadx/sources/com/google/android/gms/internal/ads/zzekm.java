package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.do0;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzekm implements zzeet {
    private final Context zza;
    private final zzcql zzb;
    private final zzbcr zzc;
    private final zzgcu zzd;
    private final zzfjl zze;

    public zzekm(Context context, zzcql zzcqlVar, zzfjl zzfjlVar, zzgcu zzgcuVar, zzbcr zzbcrVar) {
        this.zza = context;
        this.zzb = zzcqlVar;
        this.zze = zzfjlVar;
        this.zzd = zzgcuVar;
        this.zzc = zzbcrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(zzfex zzfexVar, zzfel zzfelVar) {
        zzekk zzekkVar = new zzekk(this, new View(this.zza), null, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzeki
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final x82 zza() {
                return null;
            }
        }, (zzfem) zzfelVar.zzu.get(0));
        zzcpl zzcplVarZza = this.zzb.zza(new zzcsk(zzfexVar, zzfelVar, null), zzekkVar);
        zzekl zzeklVarZzl = zzcplVarZza.zzl();
        zzfeq zzfeqVar = zzfelVar.zzs;
        final zzbcm zzbcmVar = new zzbcm(zzeklVarZzl, zzfeqVar.zzb, zzfeqVar.zza);
        zzfjf zzfjfVar = zzfjf.CUSTOM_RENDER_SYN;
        return zzfiv.zzd(new zzfip() { // from class: com.google.android.gms.internal.ads.zzekj
            @Override // com.google.android.gms.internal.ads.zzfip
            public final void zza() {
                this.zza.zzc(zzbcmVar);
            }
        }, this.zzd, zzfjfVar, this.zze).zzb(zzfjf.CUSTOM_RENDER_ACK).zzd(zzgcj.zzh(zzcplVarZza.zza())).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar;
        return (this.zzc == null || (zzfeqVar = zzfelVar.zzs) == null || zzfeqVar.zza == null) ? false : true;
    }

    public final /* synthetic */ void zzc(zzbcm zzbcmVar) {
        this.zzc.zze(zzbcmVar);
    }
}
