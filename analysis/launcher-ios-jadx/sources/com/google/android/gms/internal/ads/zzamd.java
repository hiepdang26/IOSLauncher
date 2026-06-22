package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzamd implements zzamf {
    private final zzek zza;
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadp zzf;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzaf zzk;
    private int zzl;
    private int zzm;
    private int zzg = 0;
    private long zzp = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzn = -1;
    private int zzo = -1;

    public zzamd(String str, int i, int i2) {
        this.zza = new zzek(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final void zzf(zzacg zzacgVar) {
        int i;
        int i2 = zzacgVar.zzb;
        if (i2 == -2147483647 || (i = zzacgVar.zzc) == -1) {
            return;
        }
        zzaf zzafVar = this.zzk;
        if (zzafVar != null && i == zzafVar.zzz && i2 == zzafVar.zzA && zzet.zzG(zzacgVar.zza, zzafVar.zzm)) {
            return;
        }
        zzaf zzafVar2 = this.zzk;
        zzad zzadVar = zzafVar2 == null ? new zzad() : zzafVar2.zzb();
        zzadVar.zzK(this.zze);
        zzadVar.zzX(zzacgVar.zza);
        zzadVar.zzy(zzacgVar.zzc);
        zzadVar.zzY(zzacgVar.zzb);
        zzadVar.zzO(this.zzc);
        zzadVar.zzV(this.zzd);
        zzaf zzafVarZzad = zzadVar.zzad();
        this.zzk = zzafVarZzad;
        this.zzf.zzl(zzafVarZzad);
    }

    private final boolean zzg(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zzb(), i - this.zzh);
        zzekVar.zzG(bArr, this.zzh, iMin);
        int i2 = this.zzh + iMin;
        this.zzh = i2;
        return i2 == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ef  */
    @Override // com.google.android.gms.internal.ads.zzamf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.ads.zzek r20) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamd.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zze = zzansVar.zzb();
        this.zzf = zzacnVar.zzw(zzansVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzp = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzp = -9223372036854775807L;
        this.zzb.set(0);
    }
}
