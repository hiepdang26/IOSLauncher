package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawy extends zzaxd {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzawy(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "5kY1EQ+6snGNdZX1BEywItRy0EAwZ4DbRiPucqHAgfZR8kr75HzXIMEIf0cE9z11", "NtWyZSC7qBNyKPaXbOjRpNaZGUUAwpDpvYkB4v1ZH9M=", zzaroVar, i, 33);
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
            this.zzd.zzV(zzh.longValue());
        }
    }
}
