package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzakc implements zzacn {
    private final zzacn zzb;
    private final zzajy zzc;
    private final SparseArray zzd = new SparseArray();

    public zzakc(zzacn zzacnVar, zzajy zzajyVar) {
        this.zzb = zzacnVar;
        this.zzc = zzajyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzD() {
        this.zzb.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzO(zzadi zzadiVar) {
        this.zzb.zzO(zzadiVar);
    }

    public final void zza() {
        for (int i = 0; i < this.zzd.size(); i++) {
            ((zzake) this.zzd.valueAt(i)).zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final zzadp zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzake zzakeVar = (zzake) this.zzd.get(i);
        if (zzakeVar != null) {
            return zzakeVar;
        }
        zzake zzakeVar2 = new zzake(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzakeVar2);
        return zzakeVar2;
    }
}
