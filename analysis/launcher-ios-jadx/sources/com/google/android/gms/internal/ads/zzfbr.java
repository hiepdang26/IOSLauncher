package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbr implements zzfcc {
    private zzcvx zza;

    @Override // com.google.android.gms.internal.ads.zzfcc
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcvx zzd() {
        return this.zza;
    }

    public final synchronized do0 zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, zzcvx zzcvxVar) {
        zzctc zzctcVarZzb;
        try {
            if (zzcvxVar != null) {
                this.zza = zzcvxVar;
            } else {
                this.zza = (zzcvx) zzfcbVar.zza(zzfcdVar.zzb).zzh();
            }
            zzctcVarZzb = this.zza.zzb();
        } catch (Throwable th) {
            throw th;
        }
        return zzctcVarZzb.zzi(zzctcVarZzb.zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ do0 zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }
}
