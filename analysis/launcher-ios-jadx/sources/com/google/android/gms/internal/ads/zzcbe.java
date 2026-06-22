package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import defpackage.cd2;
import defpackage.n42;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcbe {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) n42.d.c.zza(zzbbw.zzx)).longValue());
    private boolean zzc = true;

    public final void zza(SurfaceTexture surfaceTexture, final zzcap zzcapVar) {
        if (zzcapVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j = timestamp - this.zzb;
            if (Math.abs(j) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbd
            @Override // java.lang.Runnable
            public final void run() {
                zzcapVar.zzk();
            }
        });
    }

    public final void zzb() {
        this.zzc = true;
    }
}
