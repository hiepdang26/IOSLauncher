package com.google.android.gms.internal.ads;

import defpackage.v32;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdff extends zzdch {
    public zzdff(Set set) {
        super(set);
    }

    public final synchronized void zza(final v32 v32Var) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfd
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzdfc) obj).zze(v32Var);
            }
        });
    }

    public final synchronized void zzb(final String str) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfe
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzdfc) obj).zzf(str);
            }
        });
    }
}
