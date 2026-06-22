package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfxq extends zzfxr {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfxr zzc;

    public zzfxq(zzfxr zzfxrVar, int i, int i2) {
        this.zzc = zzfxrVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfuu.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzfxr, java.util.List
    /* JADX INFO: renamed from: zzh */
    public final zzfxr subList(int i, int i2) {
        zzfuu.zzi(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
