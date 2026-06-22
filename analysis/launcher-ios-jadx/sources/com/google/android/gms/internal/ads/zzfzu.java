package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfzu extends zzfxw {
    final transient Object zza;

    public zzfzu(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzfya(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return uo.t("[", this.zza.toString(), "]");
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    public final zzfxr zzd() {
        return zzfxr.zzn(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    /* JADX INFO: renamed from: zze */
    public final zzfzx iterator() {
        return new zzfya(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return false;
    }
}
