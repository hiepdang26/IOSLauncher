package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzbdc {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzbdc(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbdc zza(String str, double d) {
        return new zzbdc(str, Double.valueOf(d), 3);
    }

    public static zzbdc zzb(String str, long j) {
        return new zzbdc(str, Long.valueOf(j), 2);
    }

    public static zzbdc zzc(String str, String str2) {
        return new zzbdc(str, str2, 4);
    }

    public static zzbdc zzd(String str, boolean z) {
        return new zzbdc(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbeh zzbehVarZza = zzbej.zza();
        if (zzbehVarZza != null) {
            int i = this.zzc - 1;
            return i != 0 ? i != 1 ? i != 2 ? zzbehVarZza.zzd(this.zza, (String) this.zzb) : zzbehVarZza.zzb(this.zza, ((Double) this.zzb).doubleValue()) : zzbehVarZza.zzc(this.zza, ((Long) this.zzb).longValue()) : zzbehVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzbej.zzb() != null) {
            zzbej.zzb().zza();
        }
        return this.zzb;
    }
}
