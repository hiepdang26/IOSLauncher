package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamy implements zzang {
    private zzaf zza;
    private zzer zzb;
    private zzadp zzc;

    public zzamy(String str) {
        zzad zzadVar = new zzad();
        zzadVar.zzX(str);
        this.zza = zzadVar.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzek zzekVar) {
        zzdi.zzb(this.zzb);
        int i = zzet.zza;
        long jZze = this.zzb.zze();
        long jZzf = this.zzb.zzf();
        if (jZze == -9223372036854775807L || jZzf == -9223372036854775807L) {
            return;
        }
        zzaf zzafVar = this.zza;
        if (jZzf != zzafVar.zzq) {
            zzad zzadVarZzb = zzafVar.zzb();
            zzadVarZzb.zzab(jZzf);
            zzaf zzafVarZzad = zzadVarZzb.zzad();
            this.zza = zzafVarZzad;
            this.zzc.zzl(zzafVarZzad);
        }
        int iZzb = zzekVar.zzb();
        this.zzc.zzq(zzekVar, iZzb);
        this.zzc.zzs(jZze, 1, iZzb, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
        this.zzb = zzerVar;
        zzansVar.zzc();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzc = zzadpVarZzw;
        zzadpVarZzw.zzl(this.zza);
    }
}
