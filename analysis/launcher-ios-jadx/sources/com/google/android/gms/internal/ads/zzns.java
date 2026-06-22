package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzns {
    final /* synthetic */ zznt zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzui zze;
    private boolean zzf;
    private boolean zzg;

    public zzns(zznt zzntVar, String str, int i, zzui zzuiVar) {
        this.zza = zzntVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzuiVar == null ? -1L : zzuiVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            return;
        }
        this.zze = zzuiVar;
    }

    public final void zzg(int i, zzui zzuiVar) {
        if (this.zzd == -1 && i == this.zzc && zzuiVar != null) {
            zznt zzntVar = this.zza;
            long j = zzuiVar.zzd;
            if (j >= zzntVar.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzui zzuiVar) {
        if (zzuiVar == null) {
            return i == this.zzc;
        }
        zzui zzuiVar2 = this.zze;
        return zzuiVar2 == null ? !zzuiVar.zzb() && zzuiVar.zzd == this.zzd : zzuiVar.zzd == zzuiVar2.zzd && zzuiVar.zzb == zzuiVar2.zzb && zzuiVar.zzc == zzuiVar2.zzc;
    }

    public final boolean zzk(zzlo zzloVar) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null) {
            return this.zzc != zzloVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zzuiVar.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcc zzccVar = zzloVar.zzb;
        int iZza = zzccVar.zza(zzuiVar.zza);
        int iZza2 = zzccVar.zza(this.zze.zza);
        zzui zzuiVar2 = zzloVar.zzd;
        if (zzuiVar2.zzd < this.zze.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzuiVar2.zzb()) {
            int i = zzloVar.zzd.zze;
            return i == -1 || i > this.zze.zzb;
        }
        zzui zzuiVar3 = zzloVar.zzd;
        int i2 = zzuiVar3.zzb;
        int i3 = zzuiVar3.zzc;
        zzui zzuiVar4 = this.zze;
        int i4 = zzuiVar4.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzuiVar4.zzc;
        }
        return true;
    }

    public final boolean zzl(zzcc zzccVar, zzcc zzccVar2) {
        int i = this.zzc;
        if (i < zzccVar.zzc()) {
            zzccVar.zze(i, this.zza.zzc, 0L);
            for (int i2 = this.zza.zzc.zzn; i2 <= this.zza.zzc.zzo; i2++) {
                int iZza = zzccVar2.zza(zzccVar.zzf(i2));
                if (iZza != -1) {
                    i = zzccVar2.zzd(iZza, this.zza.zzd, false).zzc;
                    break;
                }
            }
            i = -1;
        } else if (i >= zzccVar2.zzc()) {
            i = -1;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzui zzuiVar = this.zze;
        return zzuiVar == null || zzccVar2.zza(zzuiVar.zza) != -1;
    }
}
