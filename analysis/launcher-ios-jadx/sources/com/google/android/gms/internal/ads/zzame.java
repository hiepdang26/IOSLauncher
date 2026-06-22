package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzame implements zzamf {
    private final List zza;
    private final zzadp[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzame(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    private final boolean zzf(zzek zzekVar, int i) {
        if (zzekVar.zzb() == 0) {
            return false;
        }
        if (zzekVar.zzm() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) {
        if (this.zzc) {
            if (this.zzd != 2 || zzf(zzekVar, 32)) {
                if (this.zzd != 1 || zzf(zzekVar, 0)) {
                    int iZzd = zzekVar.zzd();
                    int iZzb = zzekVar.zzb();
                    for (zzadp zzadpVar : this.zzb) {
                        zzekVar.zzK(iZzd);
                        zzadpVar.zzq(zzekVar, iZzb);
                    }
                    this.zze += iZzb;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzanp zzanpVar = (zzanp) this.zza.get(i);
            zzansVar.zzc();
            zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 3);
            zzad zzadVar = new zzad();
            zzadVar.zzK(zzansVar.zzb());
            zzadVar.zzX("application/dvbsubs");
            zzadVar.zzL(Collections.singletonList(zzanpVar.zzb));
            zzadVar.zzO(zzanpVar.zza);
            zzadpVarZzw.zzl(zzadVar.zzad());
            this.zzb[i] = zzadpVarZzw;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
        if (this.zzc) {
            zzdi.zzf(this.zzf != -9223372036854775807L);
            for (zzadp zzadpVar : this.zzb) {
                zzadpVar.zzs(this.zzf, 1, this.zze, 0, null);
            }
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzc = true;
        this.zzf = j;
        this.zze = 0;
        this.zzd = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
