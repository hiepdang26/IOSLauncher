package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamo implements zzamf {
    private final zzani zza;
    private String zzb;
    private zzadp zzc;
    private zzamn zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzamx zzg = new zzamx(32, 128);
    private final zzamx zzh = new zzamx(33, 128);
    private final zzamx zzi = new zzamx(34, 128);
    private final zzamx zzj = new zzamx(39, 128);
    private final zzamx zzk = new zzamx(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzek zzn = new zzek();

    public zzamo(zzani zzaniVar) {
        this.zza = zzaniVar;
    }

    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r30) {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzb = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 2);
        this.zzc = zzadpVarZzw;
        this.zzd = new zzamn(zzadpVarZzw);
        this.zza.zzb(zzacnVar, zzansVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
        zzdi.zzb(this.zzc);
        int i = zzet.zza;
        if (z) {
            this.zzd.zza(this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfh.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzamn zzamnVar = this.zzd;
        if (zzamnVar != null) {
            zzamnVar.zzd();
        }
    }
}
