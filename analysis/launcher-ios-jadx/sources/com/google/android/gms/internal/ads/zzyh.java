package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzyh {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyi zzyiVar) {
        zzc(zzyiVar);
        this.zza.add(new zzyg(handler, zzyiVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        for (final zzyg zzygVar : this.zza) {
            if (!zzygVar.zzc) {
                zzygVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyf
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzygVar.zzb.zzX(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzyi zzyiVar) {
        for (zzyg zzygVar : this.zza) {
            if (zzygVar.zzb == zzyiVar) {
                zzygVar.zzc();
                this.zza.remove(zzygVar);
            }
        }
    }
}
