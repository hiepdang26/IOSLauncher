package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawn extends zzaxd {
    private final zzavh zzh;

    public zzawn(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, zzavh zzavhVar) {
        super(zzavpVar, "QcEEfK1PwFv2Eb+NZQ+4kWKAUUVvycYqoBzmAjBexJV/sKEjaFlajeD5MAZYWXy5", "361aY1ErIwpwsXwpamiiDSCpkl/IcdBM93dd8sW9a/Y=", zzaroVar, i, 94);
        this.zzh = zzavhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zza())).intValue();
        synchronized (this.zzd) {
            this.zzd.zzae(zzasa.zza(iIntValue));
        }
    }
}
