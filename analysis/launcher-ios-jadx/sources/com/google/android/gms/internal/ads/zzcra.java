package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.gy0;
import defpackage.rc2;
import defpackage.x82;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcra extends zzcpk {
    private final zzbgu zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcra(zzcrt zzcrtVar, zzbgu zzbguVar, Runnable runnable, Executor executor) {
        super(zzcrtVar);
        this.zzc = zzbguVar;
        this.zzd = runnable;
        this.zze = executor;
    }

    public static /* synthetic */ void zzj(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final View zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final x82 zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final zzfem zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final zzfem zzg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zzk() {
        final zzcqy zzcqyVar = new zzcqy(new AtomicReference(this.zzd));
        this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzl(zzcqyVar);
            }
        });
    }

    public final void zzl(Runnable runnable) {
        try {
            if (this.zzc.zze(new gy0(runnable))) {
                return;
            }
            zzj(((zzcqy) runnable).zza);
        } catch (RemoteException unused) {
            zzj(((zzcqy) runnable).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpk
    public final void zzi(ViewGroup viewGroup, rc2 rc2Var) {
    }
}
