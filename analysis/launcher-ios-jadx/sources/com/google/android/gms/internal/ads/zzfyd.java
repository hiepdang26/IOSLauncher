package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfyd extends zzfzw {
    final /* synthetic */ zzfye zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyd(zzfye zzfyeVar, ListIterator listIterator) {
        super(listIterator);
        this.zza = zzfyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
