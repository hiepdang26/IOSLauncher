package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawl extends zzaxd {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzawl(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "tnRfJM39LV6MDlXml8e8fAfi5JhKcsRyFSmagsP97rbE/0XgA5fRVLlLbAYUcu57", "TvLSh+Eka5RyCXMK4IvAvP4vfksx/KqJwxjzSKu7qQs=", zzaroVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        if (zzh == null) {
            synchronized (zzi) {
                try {
                    if (zzh == null) {
                        zzh = (Long) this.zze.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.zzd) {
            this.zzd.zzy(zzh.longValue());
        }
    }
}
