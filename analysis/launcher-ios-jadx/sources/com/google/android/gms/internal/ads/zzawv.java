package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawv extends zzaxd {
    private final StackTraceElement[] zzh;

    public zzawv(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzavpVar, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzaroVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzavg zzavgVar = new zzavg((String) this.zze.invoke(null, stackTraceElementArr));
            synchronized (this.zzd) {
                try {
                    this.zzd.zzF(zzavgVar.zza.longValue());
                    if (zzavgVar.zzb.booleanValue()) {
                        this.zzd.zzac(true != zzavgVar.zzc.booleanValue() ? 2 : 1);
                    } else {
                        this.zzd.zzac(3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
