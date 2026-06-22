package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.np1;
import defpackage.or1;
import defpackage.s62;
import defpackage.uc2;
import defpackage.vb2;
import defpackage.y22;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcgj implements zzclv {
    private static zzcgj zza;

    private static synchronized zzcgj zzD(Context context, zzbom zzbomVar, int i, boolean z, int i2, zzchn zzchnVar) {
        try {
            zzcgj zzcgjVar = zza;
            if (zzcgjVar != null) {
                return zzcgjVar;
            }
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbbw.zza(context);
            if (((Boolean) zzbdk.zze.zze()).booleanValue()) {
                zzbbg.zzd(context);
            }
            zzfgc zzfgcVarZzd = zzfgc.zzd(context);
            or1 or1VarZzc = zzfgcVarZzd.zzc(242402000, false, i2);
            zzfgcVarZzd.zzf(zzbomVar);
            zzcjb zzcjbVar = new zzcjb(null);
            zzcgk zzcgkVar = new zzcgk();
            zzcgkVar.zzf(or1VarZzc);
            zzcgkVar.zze(context);
            zzcgkVar.zzd(jCurrentTimeMillis);
            zzcjbVar.zzb(new zzcgm(zzcgkVar, null));
            zzcjbVar.zzc(new zzcko(zzchnVar));
            zzcgj zzcgjVarZza = zzcjbVar.zza();
            hd2Var.g.zzu(context, or1VarZzc);
            hd2Var.i.zzi(context);
            hd2Var.c.A(context);
            hd2Var.c.z(context);
            np1.J(context);
            hd2Var.f.zzd(context);
            hd2Var.y.f(context);
            zzcgjVarZza.zza().a();
            zzbyb.zzd(context);
            zzbbn zzbbnVar = zzbbw.zzfB;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                if (!((Boolean) n42Var.c.zza(zzbbw.zzap)).booleanValue()) {
                    new zzecu(context, or1VarZzc, new zzbav(new zzbbb(context)), new zzebz(new zzebv(context), zzcgjVarZza.zzA())).zzb(((ib2) hd2Var.g.zzi()).q());
                }
            }
            zza = zzcgjVarZza;
            return zzcgjVarZza;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static zzcgj zzb(Context context, zzbom zzbomVar, int i) {
        return zzD(context, zzbomVar, 242402000, false, i, new zzchn());
    }

    public abstract zzgcu zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract s62 zza();

    public abstract zzcky zzc();

    public abstract zzcox zzd();

    public abstract zzcqk zze();

    public abstract zzczj zzf();

    public abstract zzdgo zzg();

    public abstract zzdhk zzh();

    public abstract zzdot zzi();

    public abstract zzdsk zzj();

    public abstract zzdtt zzk();

    public abstract zzdvi zzl();

    public abstract zzdwf zzm();

    public abstract zzeds zzn();

    public abstract vb2 zzo();

    public abstract uc2 zzp();

    public abstract y22 zzq();

    @Override // com.google.android.gms.internal.ads.zzclv
    public final zzewr zzr(zzbvb zzbvbVar, int i) {
        return zzs(new zzeyq(zzbvbVar, i));
    }

    public abstract zzewr zzs(zzeyq zzeyqVar);

    public abstract zzezl zzt();

    public abstract zzfaz zzu();

    public abstract zzfcq zzv();

    public abstract zzfee zzw();

    public abstract zzffv zzx();

    public abstract zzfgf zzy();

    public abstract zzfki zzz();
}
