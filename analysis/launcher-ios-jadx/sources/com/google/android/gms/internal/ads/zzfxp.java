package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfxp extends zzfvr {
    private final zzfxr zza;

    public zzfxp(zzfxr zzfxrVar, int i) {
        super(zzfxrVar.size(), i);
        this.zza = zzfxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvr
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
