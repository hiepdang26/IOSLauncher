package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzxs extends zzxp {
    private final boolean zze;
    private final zzxi zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final boolean zzp;
    private final boolean zzq;
    private final int zzr;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzxs(int r5, com.google.android.gms.internal.ads.zzcd r6, int r7, com.google.android.gms.internal.ads.zzxi r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.<init>(int, com.google.android.gms.internal.ads.zzcd, int, com.google.android.gms.internal.ads.zzxi, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzxs zzxsVar, zzxs zzxsVar2) {
        zzfzc zzfzcVarZza = (zzxsVar.zze && zzxsVar.zzh) ? zzxt.zzb : zzxt.zzb.zza();
        zzfxg zzfxgVarZzj = zzfxg.zzj();
        boolean z = zzxsVar.zzf.zzy;
        return zzfxgVarZzj.zzc(Integer.valueOf(zzxsVar.zzk), Integer.valueOf(zzxsVar2.zzk), zzfzcVarZza).zzc(Integer.valueOf(zzxsVar.zzj), Integer.valueOf(zzxsVar2.zzj), zzfzcVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzxs zzxsVar, zzxs zzxsVar2) {
        zzfxg zzfxgVarZzc = zzfxg.zzj().zzd(zzxsVar.zzh, zzxsVar2.zzh).zzb(zzxsVar.zzm, zzxsVar2.zzm).zzd(zzxsVar.zzn, zzxsVar2.zzn).zzd(zzxsVar.zzi, zzxsVar2.zzi).zzd(zzxsVar.zze, zzxsVar2.zze).zzd(zzxsVar.zzg, zzxsVar2.zzg).zzc(Integer.valueOf(zzxsVar.zzl), Integer.valueOf(zzxsVar2.zzl), zzfzc.zzc().zza());
        boolean z = zzxsVar.zzp;
        zzfxg zzfxgVarZzd = zzfxgVarZzc.zzd(z, zzxsVar2.zzp);
        boolean z2 = zzxsVar.zzq;
        zzfxg zzfxgVarZzd2 = zzfxgVarZzd.zzd(z2, zzxsVar2.zzq);
        if (z && z2) {
            zzfxgVarZzd2 = zzfxgVarZzd2.zzb(zzxsVar.zzr, zzxsVar2.zzr);
        }
        return zzfxgVarZzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        zzxs zzxsVar = (zzxs) zzxpVar;
        if (!zzet.zzG(this.zzd.zzm, zzxsVar.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzF;
        return this.zzp == zzxsVar.zzp && this.zzq == zzxsVar.zzq;
    }
}
