package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawf extends zzaxd {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzawf(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "KvkOAolI09ZSAixqGUOtipMDBdKXVlslzVnQOpfDZOEJW+xbFKrK173Gu3h1RVkI", "SkMlFTLt8H3eQLYvgf87g2pXBfp4xPpxL3RMs974XSU=", zzaroVar, i, 44);
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
            this.zzd.zzo(zzh.longValue());
        }
    }
}
