package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzfeg implements zzemz {
    final /* synthetic */ zzfei zza;

    public zzfeg(zzfei zzfeiVar) {
        this.zza = zzfeiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zzb(Object obj) {
        synchronized (this.zza) {
            try {
                this.zza.zzd = (zzdop) obj;
                if (((Boolean) n42.d.c.zza(zzbbw.zzdg)).booleanValue()) {
                    ((zzdop) obj).zzd().zza = this.zza.zzc;
                }
                this.zza.zzd.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
