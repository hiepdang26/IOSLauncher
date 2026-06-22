package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgza implements zzgzh {
    private final zzgzh[] zza;

    public zzgza(zzgzh... zzgzhVarArr) {
        this.zza = zzgzhVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzg zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzgzh zzgzhVar = this.zza[i];
            if (zzgzhVar.zzc(cls)) {
                return zzgzhVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
