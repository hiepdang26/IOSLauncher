package com.google.android.gms.internal.ads;

import defpackage.tr1;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfl extends zzdch {
    private boolean zzb;

    public zzdfl(Set set) {
        super(set);
    }

    public final void zza() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfi
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((tr1) obj).onVideoEnd();
            }
        });
    }

    public final void zzb() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfh
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((tr1) obj).onVideoPause();
            }
        });
    }

    public final synchronized void zzc() {
        try {
            if (!this.zzb) {
                zzq(new zzdfj());
                this.zzb = true;
            }
            zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdfk
                @Override // com.google.android.gms.internal.ads.zzdcg
                public final void zza(Object obj) {
                    ((tr1) obj).onVideoPlay();
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd() {
        zzq(new zzdfj());
        this.zzb = true;
    }
}
