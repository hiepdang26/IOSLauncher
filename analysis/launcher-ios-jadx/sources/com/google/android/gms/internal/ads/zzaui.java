package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaui implements Runnable {
    final /* synthetic */ zzauj zza;

    public zzaui(zzauj zzaujVar) {
        this.zza = zzaujVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.zza.zzb != null) {
            return;
        }
        synchronized (zzauj.zzc) {
            if (this.zza.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzbbw.zzcl.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzauj.zza = zzfqj.zzb(this.zza.zze.zza, "ADSHIELD", null);
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z);
            zzauj.zzc.open();
        }
    }
}
