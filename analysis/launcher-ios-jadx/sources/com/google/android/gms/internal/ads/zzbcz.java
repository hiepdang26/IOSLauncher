package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import defpackage.do0;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcz {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final ScheduledExecutorService zzc;

    public zzbcz(Context context, ScheduledExecutorService scheduledExecutorService, zzbdb zzbdbVar, zzfkf zzfkfVar) {
        this.zzc = scheduledExecutorService;
    }

    public final do0 zza() {
        return (zzgca) zzgcj.zzo(zzgca.zzu(zzgcj.zzh(null)), ((Long) zzbdr.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
    }

    public final void zzb(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else {
            if (motionEvent.getAction() != 0 || motionEvent.getEventTime() <= this.zzb.getEventTime()) {
                return;
            }
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }
}
