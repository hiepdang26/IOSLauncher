package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class zzcib extends zzexi {
    private final zzeww zza;
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

    public /* synthetic */ zzcib(zzcif zzcifVar, zzeww zzewwVar, zzcia zzciaVar) {
        this.zzb = zzcifVar;
        this.zza = zzewwVar;
        this.zzc = zzhfb.zzc(new zzfkg(zzcifVar.zzz));
        zzexe zzexeVar = new zzexe(zzewwVar);
        this.zzd = zzexeVar;
        zzhfl zzhflVarZzc = zzhfb.zzc(zzdrf.zza());
        this.zze = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(zzdrd.zza());
        this.zzf = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(zzdrh.zza());
        this.zzg = zzhflVarZzc3;
        zzhfl zzhflVarZzc4 = zzhfb.zzc(zzdrj.zza());
        this.zzh = zzhflVarZzc4;
        zzhff zzhffVarZzc = zzhfg.zzc(4);
        zzhffVarZzc.zzb(zzfjf.GMS_SIGNALS, zzhflVarZzc);
        zzhffVarZzc.zzb(zzfjf.BUILD_URL, zzhflVarZzc2);
        zzhffVarZzc.zzb(zzfjf.HTTP, zzhflVarZzc3);
        zzhffVarZzc.zzb(zzfjf.PRE_PROCESS, zzhflVarZzc4);
        zzhfg zzhfgVarZzc = zzhffVarZzc.zzc();
        this.zzi = zzhfgVarZzc;
        zzhfl zzhflVarZzc5 = zzhfb.zzc(new zzdrk(zzexeVar, zzcifVar.zzh, zzfig.zza(), zzhfgVarZzc));
        this.zzj = zzhflVarZzc5;
        zzhfp zzhfpVarZza = zzhfq.zza(0, 1);
        zzhfpVarZza.zza(zzhflVarZzc5);
        zzhfq zzhfqVarZzc = zzhfpVarZza.zzc();
        this.zzk = zzhfqVarZzc;
        zzfjo zzfjoVar = new zzfjo(zzhfqVarZzc);
        this.zzl = zzfjoVar;
        this.zzm = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcifVar.zze, zzfjoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzexi
    public final zzevr zza() {
        Context contextZzb = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb);
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzbys zzbysVar = new zzbys();
        zzhfk.zzb(zzgcuVar);
        zzevo zzevoVarZza = zzeyz.zza(new zzeyd(zzbysVar, zzgcuVar, zzewx.zza(this.zza)), zzetq.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), 0);
        zzbsr zzbsrVar = new zzbsr();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zze.zzb();
        Context contextZzb2 = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb2);
        zzevo zzevoVarZzb = zzeyz.zzb(new zzeyn(zzbsrVar, scheduledExecutorService, contextZzb2), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzbyv zzbyvVar = new zzbyv();
        Context contextZzb3 = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb3);
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzhfk.zzb(zzgcuVar);
        zzeww zzewwVar = this.zza;
        zzevo zzevoVarZza2 = zzeza.zza(zzewq.zza(zzbyvVar, contextZzb3, scheduledExecutorService2, zzgcuVar, zzewy.zza(zzewwVar), zzexa.zza(zzewwVar), zzexb.zza(zzewwVar)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzhfk.zzb(zzgcuVar);
        zzevo zzevoVarZzc = zzeyz.zzc(new zzezi(zzgcuVar), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzeyx zzeyxVar = new zzeyx();
        zzbak zzbakVar = new zzbak();
        zzhfk.zzb(zzgcuVar);
        Context contextZzb4 = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb4);
        zzexv zzexvVar = new zzexv(zzbakVar, zzgcuVar, contextZzb4);
        zzbbf zzbbfVar = new zzbbf();
        zzhfk.zzb(zzgcuVar);
        zzeyh zzeyhVar = new zzeyh(zzbbfVar, zzgcuVar, zzewz.zza(this.zza));
        zzbyv zzbyvVar2 = new zzbyv();
        zzhfk.zzb(zzgcuVar);
        zzeww zzewwVar2 = this.zza;
        zzewu zzewuVar = new zzewu(zzbyvVar2, zzgcuVar, zzexc.zza(zzewwVar2), zzexd.zza(zzewwVar2), zzewy.zza(zzewwVar2));
        zzbyv zzbyvVar3 = new zzbyv();
        zzeww zzewwVar3 = this.zza;
        zzcif zzcifVar = this.zzb;
        int iZza = zzewy.zza(zzewwVar3);
        Context contextZzb5 = zzcifVar.zza.zzb();
        zzhfk.zzb(contextZzb5);
        zzbze zzbzeVar = (zzbze) this.zzb.zzae.zzb();
        ScheduledExecutorService scheduledExecutorService3 = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzhfk.zzb(zzgcuVar);
        zzexr zzexrVar = new zzexr(zzbyvVar3, iZza, contextZzb5, zzbzeVar, scheduledExecutorService3, zzgcuVar, zzewx.zza(this.zza));
        zzevo zzevoVar = (zzevo) this.zzb.zzaL.zzb();
        String strZza = zzewx.zza(this.zza);
        zzazy zzazyVar = new zzazy();
        zzbze zzbzeVar2 = (zzbze) this.zzb.zzae.zzb();
        ScheduledExecutorService scheduledExecutorService4 = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzhfk.zzb(zzgcuVar);
        return new zzevr(contextZzb, zzgcuVar, zzfxw.zzs(zzevoVarZza, zzevoVarZzb, zzevoVarZza2, zzevoVarZzc, zzeyxVar, zzexvVar, zzeyhVar, zzewuVar, zzexrVar, zzevoVar, zzexn.zza(strZza, zzazyVar, zzbzeVar2, scheduledExecutorService4, zzgcuVar)), (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzexi
    public final zzfjl zzb() {
        return (zzfjl) this.zzm.zzb();
    }
}
