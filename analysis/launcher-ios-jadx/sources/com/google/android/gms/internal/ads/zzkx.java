package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzkx {
    private static final zzui zzt = new zzui(new Object(), -1);
    public final zzcc zza;
    public final zzui zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzhw zzf;
    public final boolean zzg;
    public final zzwi zzh;
    public final zzyc zzi;
    public final List zzj;
    public final zzui zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzbq zzn;
    public final boolean zzo = false;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzkx(zzcc zzccVar, zzui zzuiVar, long j, long j2, int i, zzhw zzhwVar, boolean z, zzwi zzwiVar, zzyc zzycVar, List list, zzui zzuiVar2, boolean z2, int i2, zzbq zzbqVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzccVar;
        this.zzb = zzuiVar;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzhwVar;
        this.zzg = z;
        this.zzh = zzwiVar;
        this.zzi = zzycVar;
        this.zzj = list;
        this.zzk = zzuiVar2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzbqVar;
        this.zzp = j3;
        this.zzq = j4;
        this.zzr = j5;
        this.zzs = j6;
    }

    public static zzkx zzg(zzyc zzycVar) {
        zzcc zzccVar = zzcc.zza;
        zzui zzuiVar = zzt;
        return new zzkx(zzccVar, zzuiVar, -9223372036854775807L, 0L, 1, null, false, zzwi.zza, zzycVar, zzfxr.zzm(), zzuiVar, false, 0, zzbq.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzui zzh() {
        return zzt;
    }

    public final zzkx zza(zzui zzuiVar) {
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzuiVar, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final zzkx zzb(zzui zzuiVar, long j, long j2, long j3, long j4, zzwi zzwiVar, zzyc zzycVar, List list) {
        zzui zzuiVar2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        zzbq zzbqVar = this.zzn;
        long j5 = this.zzp;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzkx(this.zza, zzuiVar, j2, j3, this.zze, this.zzf, this.zzg, zzwiVar, zzycVar, list, zzuiVar2, z, i, zzbqVar, j5, j4, j, jElapsedRealtime, false);
    }

    public final zzkx zzc(boolean z, int i) {
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final zzkx zzd(zzhw zzhwVar) {
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzhwVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final zzkx zze(int i) {
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final zzkx zzf(zzcc zzccVar) {
        return new zzkx(zzccVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final boolean zzi() {
        return this.zze == 3 && this.zzl && this.zzm == 0;
    }
}
