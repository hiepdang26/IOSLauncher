package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzczg implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzczj zzczjVar = (zzczj) this.zza.get();
        if (zzczjVar != null) {
            zzczjVar.zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzczd
                @Override // com.google.android.gms.internal.ads.zzdcg
                public final void zza(Object obj) {
                    ((zzczc) obj).zza();
                }
            });
        }
    }
}
