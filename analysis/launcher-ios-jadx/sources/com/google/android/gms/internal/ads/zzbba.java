package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbba {
    final /* synthetic */ zzbbb zza;
    private final byte[] zzb;
    private int zzc;

    public /* synthetic */ zzbba(zzbbb zzbbbVar, byte[] bArr, zzbaz zzbazVar) {
        this.zza = zzbbbVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbb zzbbbVar = this.zza;
            if (zzbbbVar.zzb) {
                zzbbbVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException unused) {
            k92.j(3);
        }
    }

    public final zzbba zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbay
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }
}
