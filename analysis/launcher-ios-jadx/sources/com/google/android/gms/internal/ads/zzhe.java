package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhe extends zzcc {
    private final int zzb;
    private final zzwa zzc;

    public zzhe(boolean z, zzwa zzwaVar) {
        this.zzc = zzwaVar;
        this.zzb = zzwaVar.zzc();
    }

    private final int zzw(int i, boolean z) {
        if (z) {
            return this.zzc.zzd(i);
        }
        if (i >= this.zzb - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzc.zze(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zza(Object obj) {
        int iZza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int iZzp = zzp(obj2);
            if (iZzp != -1 && (iZza = zzu(iZzp).zza(obj3)) != -1) {
                return zzs(iZzp) + iZza;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i, zzca zzcaVar, boolean z) {
        int iZzq = zzq(i);
        int iZzt = zzt(iZzq);
        zzu(iZzq).zzd(i - zzs(iZzq), zzcaVar, z);
        zzcaVar.zzc += iZzt;
        if (z) {
            Object objZzv = zzv(iZzq);
            Object obj = zzcaVar.zzb;
            obj.getClass();
            zzcaVar.zzb = Pair.create(objZzv, obj);
        }
        return zzcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzcb zze(int i, zzcb zzcbVar, long j) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzs = zzs(iZzr);
        zzu(iZzr).zze(i - iZzt, zzcbVar, j);
        Object objZzv = zzv(iZzr);
        if (!zzcb.zza.equals(zzcbVar.zzb)) {
            objZzv = Pair.create(objZzv, zzcbVar.zzb);
        }
        zzcbVar.zzb = objZzv;
        zzcbVar.zzn += iZzs;
        zzcbVar.zzo += iZzs;
        return zzcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final Object zzf(int i) {
        int iZzq = zzq(i);
        return Pair.create(zzv(iZzq), zzu(iZzq).zzf(i - zzs(iZzq)));
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzg(boolean z) {
        if (this.zzb != 0) {
            int iZza = z ? this.zzc.zza() : 0;
            while (zzu(iZza).zzo()) {
                iZza = zzw(iZza, z);
                if (iZza == -1) {
                }
            }
            return zzu(iZza).zzg(z) + zzt(iZza);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzh(boolean z) {
        int i = this.zzb;
        if (i != 0) {
            int iZzb = z ? this.zzc.zzb() : i - 1;
            while (zzu(iZzb).zzo()) {
                iZzb = zzx(iZzb, z);
                if (iZzb == -1) {
                }
            }
            return zzu(iZzb).zzh(z) + zzt(iZzb);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzj(int i, int i2, boolean z) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzj = zzu(iZzr).zzj(i - iZzt, i2 == 2 ? 0 : i2, z);
        if (iZzj != -1) {
            return iZzt + iZzj;
        }
        int iZzw = zzw(iZzr, z);
        while (iZzw != -1 && zzu(iZzw).zzo()) {
            iZzw = zzw(iZzw, z);
        }
        if (iZzw != -1) {
            return zzu(iZzw).zzg(z) + zzt(iZzw);
        }
        if (i2 == 2) {
            return zzg(z);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzk(int i, int i2, boolean z) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzk = zzu(iZzr).zzk(i - iZzt, 0, false);
        if (iZzk != -1) {
            return iZzt + iZzk;
        }
        int iZzx = zzx(iZzr, false);
        while (iZzx != -1 && zzu(iZzx).zzo()) {
            iZzx = zzx(iZzx, false);
        }
        if (iZzx == -1) {
            return -1;
        }
        return zzu(iZzx).zzh(false) + zzt(iZzx);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzn(Object obj, zzca zzcaVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzp = zzp(obj2);
        int iZzt = zzt(iZzp);
        zzu(iZzp).zzn(obj3, zzcaVar);
        zzcaVar.zzc += iZzt;
        zzcaVar.zzb = obj;
        return zzcaVar;
    }

    public abstract int zzp(Object obj);

    public abstract int zzq(int i);

    public abstract int zzr(int i);

    public abstract int zzs(int i);

    public abstract int zzt(int i);

    public abstract zzcc zzu(int i);

    public abstract Object zzv(int i);
}
