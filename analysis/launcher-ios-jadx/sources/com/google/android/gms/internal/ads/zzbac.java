package com.google.android.gms.internal.ads;

import defpackage.bb;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
final class zzbac implements bb {
    final /* synthetic */ zzbad zza;

    public zzbac(zzbad zzbadVar) {
        this.zza = zzbadVar;
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        synchronized (this.zza.zzc) {
            try {
                this.zza.zzf = null;
                zzbad zzbadVar = this.zza;
                if (zzbadVar.zzd != null) {
                    zzbadVar.zzd = null;
                }
                this.zza.zzc.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
