package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: loaded from: classes.dex */
public final class zzgyi extends AbstractList {
    private final zzgyg zza;
    private final zzgyh zzb;

    public zzgyi(zzgyg zzgygVar, zzgyh zzgyhVar) {
        this.zza = zzgygVar;
        this.zzb = zzgyhVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzd(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
