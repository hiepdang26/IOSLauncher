package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdez extends zzdch implements zzbjo {
    public zzdez(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final void zza(final zzbvz zzbvzVar) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdey
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzbjo) obj).zza(zzbvzVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final void zzb() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdex
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzbjo) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final synchronized void zzc() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdew
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzbjo) obj).zzc();
            }
        });
    }
}
