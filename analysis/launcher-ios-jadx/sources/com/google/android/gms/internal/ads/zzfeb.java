package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzfeb implements zzemz {
    final /* synthetic */ zzfec zza;

    public zzfeb(zzfec zzfecVar) {
        this.zza = zzfecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zzb(Object obj) {
        synchronized (this.zza) {
            try {
                this.zza.zzi = (zzdop) obj;
                if (((Boolean) n42.d.c.zza(zzbbw.zzdg)).booleanValue()) {
                    ((zzdop) obj).zzd().zza = this.zza.zzd;
                }
                this.zza.zzi.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
