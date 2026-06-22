package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzgwe extends zzgwf {
    final /* synthetic */ zzgwm zza;
    private int zzb = 0;
    private final int zzc;

    public zzgwe(zzgwm zzgwmVar) {
        this.zza = zzgwmVar;
        this.zzc = zzgwmVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwh
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
