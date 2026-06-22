package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxi extends zzdch {
    private boolean zzb;

    public zzcxi(Set set) {
        super(set);
        this.zzb = false;
    }

    public final synchronized void zza() {
        if (this.zzb) {
            return;
        }
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcxh
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcxk) obj).zzr();
            }
        });
        this.zzb = true;
    }
}
