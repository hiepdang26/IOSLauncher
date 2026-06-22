package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbs implements zzfcc {
    private final zzfcc zza;
    private zzcvx zzb;

    public zzfbs(zzfcc zzfccVar) {
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcvx zzd() {
        return this.zzb;
    }

    public final synchronized do0 zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, zzcvx zzcvxVar) {
        this.zzb = zzcvxVar;
        if (zzfcdVar.zza == null) {
            return ((zzfbr) this.zza).zzb(zzfcdVar, zzfcbVar, zzcvxVar);
        }
        zzctc zzctcVarZzb = zzcvxVar.zzb();
        return zzctcVarZzb.zzi(zzctcVarZzb.zzk(zzgcj.zzh(zzfcdVar.zza)));
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ do0 zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }
}
