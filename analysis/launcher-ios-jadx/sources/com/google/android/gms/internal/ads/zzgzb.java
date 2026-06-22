package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgzb implements zzhaf {
    private static final zzgzh zza = new zzgyz();
    private final zzgzh zzb;

    public zzgzb() {
        zzgxr zzgxrVarZza = zzgxr.zza();
        int i = zzgzt.zza;
        zzgza zzgzaVar = new zzgza(zzgxrVarZza, zza);
        byte[] bArr = zzgyl.zzb;
        this.zzb = zzgzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhaf
    public final zzhae zza(Class cls) {
        int i = zzhag.zza;
        if (!zzgxy.class.isAssignableFrom(cls)) {
            int i2 = zzgzt.zza;
        }
        zzgzg zzgzgVarZzb = this.zzb.zzb(cls);
        if (zzgzgVarZzb.zzb()) {
            int i3 = zzgzt.zza;
            return zzgzn.zzc(zzhag.zzm(), zzgxl.zza(), zzgzgVarZzb.zza());
        }
        int i4 = zzgzt.zza;
        return zzgzm.zzm(cls, zzgzgVarZzb, zzgzq.zza(), zzgyx.zza(), zzhag.zzm(), zzgzgVarZzb.zzc() + (-1) != 1 ? zzgxl.zza() : null, zzgzf.zza());
    }
}
