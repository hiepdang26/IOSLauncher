package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawg extends zzaxd {
    private final long zzh;

    public zzawg(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, long j, int i, int i2) {
        super(zzavpVar, "Rx5KxmHu63h8QT7T4cYR2mu7F4LQnYkocG/Azb9HP8ZHyjUHnRxxCuB99BIp3kbl", "3fysZeGzwX+hqd2f4+qtlSho+oF+DeFl9kzKrTFOSWo=", zzaroVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        synchronized (this.zzd) {
            try {
                this.zzd.zzt(jLongValue);
                long j = this.zzh;
                if (j != 0) {
                    this.zzd.zzT(jLongValue - j);
                    this.zzd.zzU(this.zzh);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
