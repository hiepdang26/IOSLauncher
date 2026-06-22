package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfsm extends zzfsy {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsy zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsy zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsy
    public final zzfsz zzc() {
        return new zzfso(this.zza, this.zzb, null);
    }
}
