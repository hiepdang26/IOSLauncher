package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzajg implements zzack {
    private zzacn zza;
    private zzajo zzb;
    private boolean zzc;

    private final boolean zza(zzacl zzaclVar) {
        zzaji zzajiVar = new zzaji();
        if (zzajiVar.zzb(zzaclVar, true) && (zzajiVar.zza & 2) == 2) {
            int iMin = Math.min(zzajiVar.zze, 8);
            zzek zzekVar = new zzek(iMin);
            ((zzaby) zzaclVar).zzm(zzekVar.zzM(), 0, iMin, false);
            zzekVar.zzK(0);
            if (zzekVar.zzb() >= 5 && zzekVar.zzm() == 127 && zzekVar.zzu() == 1179402563) {
                this.zzb = new zzajf();
            } else {
                zzekVar.zzK(0);
                if (zzadv.zzd(1, zzekVar, true)) {
                    this.zzb = new zzajq();
                } else {
                    zzekVar.zzK(0);
                    if (zzajk.zzd(zzekVar)) {
                        this.zzb = new zzajk();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws zzbo {
        zzdi.zzb(this.zza);
        if (this.zzb == null) {
            if (!zza(zzaclVar)) {
                throw zzbo.zza("Failed to determine bitstream type", null);
            }
            zzaclVar.zzj();
        }
        if (!this.zzc) {
            zzadp zzadpVarZzw = this.zza.zzw(0, 1);
            this.zza.zzD();
            this.zzb.zzh(this.zza, zzadpVarZzw);
            this.zzc = true;
        }
        return this.zzb.zze(zzaclVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zza = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        zzajo zzajoVar = this.zzb;
        if (zzajoVar != null) {
            zzajoVar.zzj(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        try {
            return zza(zzaclVar);
        } catch (zzbo unused) {
            return false;
        }
    }
}
