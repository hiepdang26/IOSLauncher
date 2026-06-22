package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzaad extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaab zzd;
    private boolean zze;

    public /* synthetic */ zzaad(zzaab zzaabVar, SurfaceTexture surfaceTexture, boolean z, zzaac zzaacVar) {
        super(surfaceTexture);
        this.zzd = zzaabVar;
        this.zza = z;
    }

    public static zzaad zza(Context context, boolean z) {
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzdi.zzf(z2);
        return new zzaab().zza(z ? zzb : 0);
    }

    public static synchronized boolean zzb(Context context) {
        try {
            if (!zzc) {
                zzb = zzdr.zzb(context) ? zzdr.zzc() ? 1 : 2 : 0;
                zzc = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzd) {
            try {
                if (!this.zze) {
                    this.zzd.zzb();
                    this.zze = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
