package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzgzx extends zzgwf {
    final zzhab zza;
    zzgwh zzb = zzb();
    final /* synthetic */ zzhad zzc;

    public zzgzx(zzhad zzhadVar) {
        this.zzc = zzhadVar;
        this.zza = new zzhab(zzhadVar, null);
    }

    private final zzgwh zzb() {
        zzhab zzhabVar = this.zza;
        if (zzhabVar.hasNext()) {
            return zzhabVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwh
    public final byte zza() {
        zzgwh zzgwhVar = this.zzb;
        if (zzgwhVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzgwhVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
