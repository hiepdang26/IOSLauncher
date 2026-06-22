package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzaam {
    private final zzaah zza;
    private zzcp zzf;
    private long zzh;
    private final zzzi zzj;
    private final zzaaf zzb = new zzaaf();
    private final zzeq zzc = new zzeq(10);
    private final zzeq zzd = new zzeq(10);
    private final zzec zze = new zzec(16);
    private zzcp zzg = zzcp.zza;
    private long zzi = -9223372036854775807L;

    public zzaam(zzzi zzziVar, zzaah zzaahVar) {
        this.zzj = zzziVar;
        this.zza = zzaahVar;
    }

    private static Object zzf(zzeq zzeqVar) {
        zzdi.zzd(zzeqVar.zza() > 0);
        while (zzeqVar.zza() > 1) {
            zzeqVar.zzb();
        }
        Object objZzb = zzeqVar.zzb();
        objZzb.getClass();
        return objZzb;
    }

    public final void zza() {
        this.zze.zzc();
        this.zzi = -9223372036854775807L;
        zzeq zzeqVar = this.zzd;
        if (zzeqVar.zza() > 0) {
            Long l = (Long) zzf(zzeqVar);
            l.longValue();
            this.zzd.zzd(0L, l);
        }
        if (this.zzf != null) {
            this.zzc.zze();
            return;
        }
        zzeq zzeqVar2 = this.zzc;
        if (zzeqVar2.zza() > 0) {
            this.zzf = (zzcp) zzf(zzeqVar2);
        }
    }

    public final void zzb(long j, long j2) {
        this.zzd.zzd(j, Long.valueOf(j2));
    }

    public final void zzc(long j, long j2) {
        zzec zzecVar = this.zze;
        if (zzecVar.zzd()) {
            return;
        }
        zzeq zzeqVar = this.zzd;
        long jZza = zzecVar.zza();
        Long l = (Long) zzeqVar.zzc(jZza);
        if (l != null && l.longValue() != this.zzh) {
            this.zzh = l.longValue();
            this.zza.zzf();
        }
        int iZza = this.zza.zza(jZza, j, j2, this.zzh, false, this.zzb);
        if (iZza != 0 && iZza != 1) {
            if (iZza == 2 || iZza == 3 || iZza == 4) {
                this.zzi = jZza;
                this.zze.zzb();
                zzzi zzziVar = this.zzj;
                Iterator it = zzziVar.zza.zzg.iterator();
                while (it.hasNext()) {
                    ((zzzj) it.next()).zzb(zzziVar.zza);
                }
                zzdi.zzb(null);
                throw null;
            }
            return;
        }
        this.zzi = jZza;
        long jZzb = this.zze.zzb();
        zzcp zzcpVar = (zzcp) this.zzc.zzc(jZzb);
        if (zzcpVar != null && !zzcpVar.equals(zzcp.zza) && !zzcpVar.equals(this.zzg)) {
            this.zzg = zzcpVar;
            zzzi zzziVar2 = this.zzj;
            zzad zzadVar = new zzad();
            zzadVar.zzac(zzcpVar.zzb);
            zzadVar.zzI(zzcpVar.zzc);
            zzadVar.zzX("video/raw");
            zzziVar2.zza.zzi = zzadVar.zzad();
            Iterator it2 = zzziVar2.zza.zzg.iterator();
            while (it2.hasNext()) {
                ((zzzj) it2.next()).zzc(zzziVar2.zza, zzcpVar);
            }
        }
        zzzi zzziVar3 = this.zzj;
        long j3 = this.zzh;
        if (this.zza.zzo()) {
            zzzt zzztVar = zzziVar3.zza;
            if (zzztVar.zzl != null) {
                Iterator it3 = zzztVar.zzg.iterator();
                while (it3.hasNext()) {
                    ((zzzj) it3.next()).zza(zzziVar3.zza);
                }
            }
        }
        zzzt zzztVar2 = zzziVar3.zza;
        if (zzztVar2.zzj != null) {
            zzaf zzafVarZzad = zzztVar2.zzi == null ? new zzad().zzad() : zzztVar2.zzi;
            zzzt zzztVar3 = zzziVar3.zza;
            zzaae zzaaeVar = zzztVar3.zzj;
            zzdi.zzb(zzztVar3.zzh);
            zzaaeVar.zza(jZzb - j3, System.nanoTime(), zzafVarZzad, null);
        }
        zzdi.zzb(null);
        throw null;
    }

    public final void zzd(float f) {
        zzdi.zzd(f > 0.0f);
        this.zza.zzm(f);
    }

    public final boolean zze(long j) {
        long j2 = this.zzi;
        return j2 != -9223372036854775807L && j2 >= j;
    }
}
