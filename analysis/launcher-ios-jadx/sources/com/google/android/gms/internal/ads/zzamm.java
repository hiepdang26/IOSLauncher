package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamm implements zzamf {
    private final zzani zza;
    private long zze;
    private String zzg;
    private zzadp zzh;
    private zzaml zzi;
    private boolean zzj;
    private boolean zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzamx zzb = new zzamx(7, 128);
    private final zzamx zzc = new zzamx(8, 128);
    private final zzamx zzd = new zzamx(6, 128);
    private long zzk = -9223372036854775807L;
    private final zzek zzm = new zzek();

    public zzamm(zzani zzaniVar, boolean z, boolean z2) {
        this.zza = zzaniVar;
    }

    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r19) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamm.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzg = zzansVar.zzb();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 2);
        this.zzh = zzadpVarZzw;
        this.zzi = new zzaml(zzadpVarZzw, false, false);
        this.zza.zzb(zzacnVar, zzansVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
        zzdi.zzb(this.zzh);
        int i = zzet.zza;
        if (z) {
            this.zzi.zza(this.zze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzk = j;
        int i2 = i & 2;
        this.zzl = (i2 != 0) | this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzfh.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzaml zzamlVar = this.zzi;
        if (zzamlVar != null) {
            zzamlVar.zzd();
        }
    }
}
