package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class zzcht extends zzewr {
    private final zzeyq zza;
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
    private final zzhfl zzn;
    private final zzhfl zzo;
    private final zzhfl zzp;
    private final zzhfl zzq;
    private final zzhfl zzr;
    private final zzhfl zzs;
    private final zzhfl zzt;
    private final zzhfl zzu;
    private final zzhfl zzv;
    private final zzhfl zzw;
    private final zzhfl zzx;
    private final zzhfl zzy;
    private final zzhfl zzz;

    public /* synthetic */ zzcht(zzcif zzcifVar, zzeyq zzeyqVar, zzchs zzchsVar) {
        this.zzb = zzcifVar;
        this.zza = zzeyqVar;
        this.zzc = zzhfb.zzc(new zzfkg(zzcifVar.zzz));
        zzeys zzeysVar = new zzeys(zzeyqVar);
        this.zzd = zzeysVar;
        zzeyt zzeytVar = new zzeyt(zzeyqVar);
        this.zze = zzeytVar;
        zzeyv zzeyvVar = new zzeyv(zzeyqVar);
        this.zzf = zzeyvVar;
        this.zzg = new zzewq(zzclq.zza, zzcifVar.zzh, zzcifVar.zze, zzfig.zza(), zzeysVar, zzeytVar, zzeyvVar);
        zzeyr zzeyrVar = new zzeyr(zzeyqVar);
        this.zzh = zzeyrVar;
        this.zzi = new zzext(zzclq.zza, zzeysVar, zzcifVar.zzh, zzcifVar.zzae, zzcifVar.zze, zzfig.zza(), zzeyrVar);
        this.zzj = new zzexx(zzclk.zza, zzfig.zza(), zzcifVar.zzh);
        this.zzk = new zzeyf(zzclm.zza, zzfig.zza(), zzeyrVar);
        this.zzl = new zzeyp(zzclo.zza, zzcifVar.zze, zzcifVar.zzh);
        this.zzm = new zzezk(zzfig.zza());
        zzeyu zzeyuVar = new zzeyu(zzeyqVar);
        this.zzn = zzeyuVar;
        this.zzo = new zzezg(zzcifVar.zzae, zzeyuVar, zzeyvVar, zzcls.zza, zzfig.zza(), zzeyrVar, zzcifVar.zze);
        this.zzp = new zzexn(zzeyrVar, zzcli.zza, zzcifVar.zzae, zzcifVar.zze, zzfig.zza());
        zzeyw zzeywVar = new zzeyw(zzeyqVar);
        this.zzq = zzeywVar;
        zzhfl zzhflVarZzc = zzhfb.zzc(zzdrf.zza());
        this.zzr = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(zzdrd.zza());
        this.zzs = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(zzdrh.zza());
        this.zzt = zzhflVarZzc3;
        zzhfl zzhflVarZzc4 = zzhfb.zzc(zzdrj.zza());
        this.zzu = zzhflVarZzc4;
        zzhff zzhffVarZzc = zzhfg.zzc(4);
        zzhffVarZzc.zzb(zzfjf.GMS_SIGNALS, zzhflVarZzc);
        zzhffVarZzc.zzb(zzfjf.BUILD_URL, zzhflVarZzc2);
        zzhffVarZzc.zzb(zzfjf.HTTP, zzhflVarZzc3);
        zzhffVarZzc.zzb(zzfjf.PRE_PROCESS, zzhflVarZzc4);
        zzhfg zzhfgVarZzc = zzhffVarZzc.zzc();
        this.zzv = zzhfgVarZzc;
        zzhfl zzhflVarZzc5 = zzhfb.zzc(new zzdrk(zzeywVar, zzcifVar.zzh, zzfig.zza(), zzhfgVarZzc));
        this.zzw = zzhflVarZzc5;
        zzhfp zzhfpVarZza = zzhfq.zza(0, 1);
        zzhfpVarZza.zza(zzhflVarZzc5);
        zzhfq zzhfqVarZzc = zzhfpVarZza.zzc();
        this.zzx = zzhfqVarZzc;
        zzfjo zzfjoVar = new zzfjo(zzhfqVarZzc);
        this.zzy = zzfjoVar;
        this.zzz = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcifVar.zze, zzfjoVar));
    }

    private final zzewu zze() {
        zzbyv zzbyvVar = new zzbyv();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzeyq zzeyqVar = this.zza;
        return new zzewu(zzbyvVar, zzgcuVar, zzeyqVar.zzd(), zzeyqVar.zzb(), zzeyqVar.zza());
    }

    private final zzeyh zzf() {
        zzbbf zzbbfVar = new zzbbf();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        List listZzf = this.zza.zzf();
        zzhfk.zzb(listZzf);
        return new zzeyh(zzbbfVar, zzgcuVar, listZzf);
    }

    @Override // com.google.android.gms.internal.ads.zzewr
    public final zzevr zza() {
        Context contextZzb = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb);
        zzbys zzbysVar = new zzbys();
        zzbyt zzbytVar = new zzbyt();
        Object objZzb = this.zzb.zzaL.zzb();
        zzhfl zzhflVar = this.zzp;
        zzhfl zzhflVar2 = this.zzo;
        zzhfl zzhflVar3 = this.zzm;
        zzhfl zzhflVar4 = this.zzl;
        zzhfl zzhflVar5 = this.zzk;
        zzhfl zzhflVar6 = this.zzj;
        zzhfl zzhflVar7 = this.zzi;
        zzhfl zzhflVar8 = this.zzg;
        zzewu zzewuVarZze = zze();
        zzeyh zzeyhVarZzf = zzf();
        zzhew zzhewVarZza = zzhfb.zza(zzhflVar8);
        zzhew zzhewVarZza2 = zzhfb.zza(zzhflVar7);
        zzhew zzhewVarZza3 = zzhfb.zza(zzhflVar6);
        zzhew zzhewVarZza4 = zzhfb.zza(zzhflVar5);
        zzhew zzhewVarZza5 = zzhfb.zza(zzhflVar4);
        zzhew zzhewVarZza6 = zzhfb.zza(zzhflVar3);
        zzhew zzhewVarZza7 = zzhfb.zza(zzhflVar2);
        zzhew zzhewVarZza8 = zzhfb.zza(zzhflVar);
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return zzezb.zza(contextZzb, zzbysVar, zzbytVar, objZzb, zzewuVarZze, zzeyhVarZzf, zzhewVarZza, zzhewVarZza2, zzhewVarZza3, zzhewVarZza4, zzhewVarZza5, zzhewVarZza6, zzhewVarZza7, zzhewVarZza8, zzgcuVar, (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzewr
    public final zzevr zzb() {
        Context contextZzb = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb);
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzbys zzbysVar = new zzbys();
        zzhfk.zzb(zzgcuVar);
        String strZzc = this.zza.zzc();
        zzhfk.zzb(strZzc);
        zzevo zzevoVarZza = zzeyz.zza(new zzeyd(zzbysVar, zzgcuVar, strZzc), zzetq.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), -1);
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
        zzeyq zzeyqVar = this.zza;
        zzevo zzevoVarZza2 = zzeza.zza(zzewq.zza(zzbyvVar, contextZzb3, scheduledExecutorService2, zzgcuVar, zzeyqVar.zza(), zzeyt.zzc(zzeyqVar), zzeyv.zzc(zzeyqVar)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzhfk.zzb(zzgcuVar);
        zzevo zzevoVarZzc = zzeyz.zzc(new zzezi(zzgcuVar), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzeyx zzeyxVar = new zzeyx();
        zzbak zzbakVar = new zzbak();
        zzhfk.zzb(zzgcuVar);
        Context contextZzb4 = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb4);
        zzexv zzexvVar = new zzexv(zzbakVar, zzgcuVar, contextZzb4);
        zzeyh zzeyhVarZzf = zzf();
        zzewu zzewuVarZze = zze();
        zzbyv zzbyvVar2 = new zzbyv();
        int iZza = this.zza.zza();
        Context contextZzb5 = this.zzb.zza.zzb();
        zzhfk.zzb(contextZzb5);
        zzbze zzbzeVar = (zzbze) this.zzb.zzae.zzb();
        ScheduledExecutorService scheduledExecutorService3 = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzhfk.zzb(zzgcuVar);
        String strZzc2 = this.zza.zzc();
        zzhfk.zzb(strZzc2);
        zzexr zzexrVar = new zzexr(zzbyvVar2, iZza, contextZzb5, zzbzeVar, scheduledExecutorService3, zzgcuVar, strZzc2);
        zzevo zzevoVar = (zzevo) this.zzb.zzaL.zzb();
        String strZzc3 = this.zza.zzc();
        zzhfk.zzb(strZzc3);
        zzazy zzazyVar = new zzazy();
        zzbze zzbzeVar2 = (zzbze) this.zzb.zzae.zzb();
        ScheduledExecutorService scheduledExecutorService4 = (ScheduledExecutorService) this.zzb.zze.zzb();
        zzhfk.zzb(zzgcuVar);
        return new zzevr(contextZzb, zzgcuVar, zzfxw.zzs(zzevoVarZza, zzevoVarZzb, zzevoVarZza2, zzevoVarZzc, zzeyxVar, zzexvVar, zzeyhVarZzf, zzewuVarZze, zzexrVar, zzevoVar, zzexn.zza(strZzc3, zzazyVar, zzbzeVar2, scheduledExecutorService4, zzgcuVar)), (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzewr
    public final zzfjl zzc() {
        return (zzfjl) this.zzz.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzewr
    public final zzfkf zzd() {
        return (zzfkf) this.zzc.zzb();
    }
}
