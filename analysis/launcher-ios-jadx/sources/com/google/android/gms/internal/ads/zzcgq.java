package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgq implements zzhfc {
    private final zzcgm zza;

    public zzcgq(zzcgm zzcgmVar) {
        this.zza = zzcgmVar;
    }

    public final WeakReference zza() {
        WeakReference weakReferenceZzg = this.zza.zzg();
        zzhfk.zzb(weakReferenceZzg);
        return weakReferenceZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        WeakReference weakReferenceZzg = this.zza.zzg();
        zzhfk.zzb(weakReferenceZzg);
        return weakReferenceZzg;
    }
}
