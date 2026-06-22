package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzajd implements zzajj {
    private final zzaji zza;
    private final long zzb;
    private final long zzc;
    private final zzajo zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajd(zzajo zzajoVar, long j, long j2, long j3, long j4, boolean z) {
        zzdi.zzd(j >= 0 && j2 > j);
        this.zzd = zzajoVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzaji();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    @Override // com.google.android.gms.internal.ads.zzajj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzd(com.google.android.gms.internal.ads.zzacl r24) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajd.zzd(com.google.android.gms.internal.ads.zzacl):long");
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final /* bridge */ /* synthetic */ zzadi zze() {
        zzajb zzajbVar = null;
        if (this.zzf != 0) {
            return new zzajc(this, zzajbVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final void zzg(long j) {
        this.zzh = Math.max(0L, Math.min(j, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }
}
