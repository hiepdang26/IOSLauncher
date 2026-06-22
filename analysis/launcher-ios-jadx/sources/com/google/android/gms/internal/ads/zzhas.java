package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhas {
    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i, int i2);

    public abstract void zze(Object obj, int i, long j);

    public abstract void zzf(Object obj, int i, Object obj2);

    public abstract void zzg(Object obj, int i, zzgwm zzgwmVar);

    public abstract void zzh(Object obj, int i, long j);

    public abstract void zzi(Object obj);

    public final boolean zzj(Object obj, zzgzw zzgzwVar) throws zzgyn {
        int iZzd = zzgzwVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzh(obj, i, zzgzwVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zze(obj, i, zzgzwVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzg(obj, i, zzgzwVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzgyn.zza();
            }
            zzd(obj, i, zzgzwVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i3 = i << 3;
        while (zzgzwVar.zzc() != Integer.MAX_VALUE && zzj(objZzb, zzgzwVar)) {
        }
        if ((4 | i3) != zzgzwVar.zzd()) {
            throw zzgyn.zzb();
        }
        zzc(objZzb);
        zzf(obj, i, objZzb);
        return true;
    }
}
