package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzcex implements Runnable {
    public final /* synthetic */ zzcej zza;

    public /* synthetic */ zzcex(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.destroy();
    }
}
