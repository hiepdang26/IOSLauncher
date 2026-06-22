package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import defpackage.ab;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbab implements ab {
    final /* synthetic */ zzbad zza;

    public zzbab(zzbad zzbadVar) {
        this.zza = zzbadVar;
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        zzbad zzbadVar;
        synchronized (this.zza.zzc) {
            try {
                zzbadVar = this.zza;
            } catch (DeadObjectException unused) {
                k92.f();
                zzbad.zzh(this.zza);
            }
            if (zzbadVar.zzd != null) {
                zzbadVar.zzf = zzbadVar.zzd.zzq();
                this.zza.zzc.notifyAll();
            } else {
                this.zza.zzc.notifyAll();
            }
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
