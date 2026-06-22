package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzddp extends zzdch implements zzddr {
    public zzddp(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zza(String str) {
        final String str2 = "MalformedJson";
        zzq(new zzdcg(str2) { // from class: com.google.android.gms.internal.ads.zzddj
            public final /* synthetic */ String zza = "MalformedJson";

            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zzb(final String str, final String str2) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzddm
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zzb(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zzc(final String str) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzddl
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zzc(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zzd(final String str) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzddn
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zzd(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zze() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzddo
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddr
    public final void zzf() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzddk
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzddr) obj).zzf();
            }
        });
    }
}
