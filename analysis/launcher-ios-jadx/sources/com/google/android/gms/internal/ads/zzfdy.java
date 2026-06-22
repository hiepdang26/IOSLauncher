package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdy implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzfdo zzd;
    private final zzfcc zze;
    private final zzfey zzf;
    private final zzfki zzg;
    private final zzffe zzh;
    private do0 zzi;

    public zzfdy(Context context, Executor executor, zzcgj zzcgjVar, zzfcc zzfccVar, zzfdo zzfdoVar, zzffe zzffeVar, zzfey zzfeyVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zze = zzfccVar;
        this.zzd = zzfdoVar;
        this.zzh = zzffeVar;
        this.zzf = zzfeyVar;
        this.zzg = zzcgjVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdot zzk(zzfca zzfcaVar) {
        zzdot zzdotVarZzi = this.zzc.zzi();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zza);
        zzcvyVar.zzi(((zzfdx) zzfcaVar).zza);
        zzcvyVar.zzh(this.zzf);
        zzdotVarZzi.zzd(zzcvyVar.zzj());
        zzdotVarZzi.zzc(new zzdci().zzn());
        return zzdotVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    @Override // com.google.android.gms.internal.ads.zzena
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(defpackage.tb2 r26, java.lang.String r27, com.google.android.gms.internal.ads.zzemy r28, com.google.android.gms.internal.ads.zzemz r29) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdy.zzb(tb2, java.lang.String, com.google.android.gms.internal.ads.zzemy, com.google.android.gms.internal.ads.zzemz):boolean");
    }

    public final /* synthetic */ void zzi() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzj(int i) {
        this.zzh.zzp().zza(i);
    }
}
