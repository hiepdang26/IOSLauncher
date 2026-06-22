package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class zzchx extends zzexg {
    private final zzeyj zza;
    private final zzcif zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;
    private final zzhfl zzk;
    private final zzhfl zzl;
    private final zzhfl zzm;

    public /* synthetic */ zzchx(zzcif zzcifVar, zzeyj zzeyjVar, zzchw zzchwVar) {
        this.zzb = zzcifVar;
        this.zza = zzeyjVar;
        zzeyl zzeylVar = new zzeyl(zzeyjVar);
        this.zzc = zzeylVar;
        zzhfl zzhflVarZzc = zzhfb.zzc(zzdrf.zza());
        this.zzd = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(zzdrd.zza());
        this.zze = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(zzdrh.zza());
        this.zzf = zzhflVarZzc3;
        zzhfl zzhflVarZzc4 = zzhfb.zzc(zzdrj.zza());
        this.zzg = zzhflVarZzc4;
        zzhff zzhffVarZzc = zzhfg.zzc(4);
        zzhffVarZzc.zzb(zzfjf.GMS_SIGNALS, zzhflVarZzc);
        zzhffVarZzc.zzb(zzfjf.BUILD_URL, zzhflVarZzc2);
        zzhffVarZzc.zzb(zzfjf.HTTP, zzhflVarZzc3);
        zzhffVarZzc.zzb(zzfjf.PRE_PROCESS, zzhflVarZzc4);
        zzhfg zzhfgVarZzc = zzhffVarZzc.zzc();
        this.zzh = zzhfgVarZzc;
        zzhfl zzhflVarZzc5 = zzhfb.zzc(new zzdrk(zzeylVar, zzcifVar.zzh, zzfig.zza(), zzhfgVarZzc));
        this.zzi = zzhflVarZzc5;
        zzhfp zzhfpVarZza = zzhfq.zza(0, 1);
        zzhfpVarZza.zza(zzhflVarZzc5);
        zzhfq zzhfqVarZzc = zzhfpVarZza.zzc();
        this.zzj = zzhfqVarZzc;
        zzfjo zzfjoVar = new zzfjo(zzhfqVarZzc);
        this.zzk = zzfjoVar;
        this.zzl = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcifVar.zze, zzfjoVar));
        this.zzm = zzhfb.zzc(new zzfkg(zzcifVar.zzz));
    }

    @Override // com.google.android.gms.internal.ads.zzexg
    public final zzevr zza() {
        Context contextZzb = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb);
        zzbys zzbysVar = new zzbys();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzeyd zzeydVar = new zzeyd(zzbysVar, zzgcuVar, zzeyk.zza(this.zza));
        zzhfk.zzb(zzgcuVar);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzfkf zzfkfVar = (zzfkf) this.zzm.zzb();
        zzdsk zzdskVar = (zzdsk) this.zzb.zzM.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzetw(zzeydVar, 0L, scheduledExecutorService));
        return new zzevr(contextZzb, zzgcuVar, hashSet, zzfkfVar, zzdskVar);
    }

    @Override // com.google.android.gms.internal.ads.zzexg
    public final zzfjl zzb() {
        return (zzfjl) this.zzl.zzb();
    }
}
