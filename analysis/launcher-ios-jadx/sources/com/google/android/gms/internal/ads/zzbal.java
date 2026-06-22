package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbal extends zzbzt {
    final /* synthetic */ zzbar zza;

    public zzbal(zzbar zzbarVar) {
        this.zza = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzt, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzbar.zze(this.zza);
        return super.cancel(z);
    }
}
