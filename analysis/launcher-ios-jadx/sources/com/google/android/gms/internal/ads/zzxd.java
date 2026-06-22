package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzxd extends zzxp implements Comparable {
    private final int zze;
    private final int zzf;

    public zzxd(int i, zzcd zzcdVar, int i2, zzxi zzxiVar, int i3) {
        super(i, zzcdVar, i2);
        this.zze = zzlf.zza(i3, zzxiVar.zzN) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxd zzxdVar) {
        return Integer.compare(this.zzf, zzxdVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        return false;
    }
}
