package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfyf extends zzfzw {
    final /* synthetic */ zzfyg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyf(zzfyg zzfygVar, ListIterator listIterator) {
        super(listIterator);
        this.zza = zzfygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
