package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamk implements zzamf {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzanv zzb;
    private final zzek zzc;
    private final boolean[] zzd;
    private final zzami zze;
    private final zzamx zzf;
    private zzamj zzg;
    private long zzh;
    private String zzi;
    private zzadp zzj;
    private boolean zzk;
    private long zzl;

    public zzamk() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01d5  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r21) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamk.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzi = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 2);
        this.zzj = zzadpVarZzw;
        this.zzg = new zzamj(zzadpVarZzw);
        zzanv zzanvVar = this.zzb;
        if (zzanvVar != null) {
            zzanvVar.zzb(zzacnVar, zzansVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
        zzdi.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        zzfh.zzf(this.zzd);
        this.zze.zzb();
        zzamj zzamjVar = this.zzg;
        if (zzamjVar != null) {
            zzamjVar.zzd();
        }
        zzamx zzamxVar = this.zzf;
        if (zzamxVar != null) {
            zzamxVar.zzb();
        }
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    public zzamk(zzanv zzanvVar) {
        zzek zzekVar;
        this.zzb = zzanvVar;
        this.zzd = new boolean[4];
        this.zze = new zzami(128);
        this.zzl = -9223372036854775807L;
        if (zzanvVar != null) {
            this.zzf = new zzamx(178, 128);
            zzekVar = new zzek();
        } else {
            zzekVar = null;
            this.zzf = null;
        }
        this.zzc = zzekVar;
    }
}
