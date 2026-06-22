package com.google.android.gms.internal.ads;

import defpackage.n42;
import defpackage.xc2;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyz extends zzdch implements zzcxk, zzcyp {
    private final zzfel zzb;
    private final AtomicBoolean zzc;

    public zzcyz(Set set, zzfel zzfelVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfelVar;
    }

    private final void zzb() {
        xc2 xc2Var;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgY)).booleanValue() && this.zzc.compareAndSet(false, true) && (xc2Var = this.zzb.zzae) != null && xc2Var.g == 3) {
            zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcyy
                @Override // com.google.android.gms.internal.ads.zzdcg
                public final void zza(Object obj) {
                    this.zza.zza((zzczb) obj);
                }
            });
        }
    }

    public final /* synthetic */ void zza(zzczb zzczbVar) {
        zzczbVar.zzh(this.zzb.zzae);
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
