package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;
import defpackage.b22;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzdra implements zzczo, zzcye, zzcwt, zzcxk, b22, zzdca {
    private final zzbav zza;
    private boolean zzb = false;

    public zzdra(zzbav zzbavVar, zzfcg zzfcgVar) {
        this.zza = zzbavVar;
        zzbavVar.zzc(2);
        if (zzfcgVar != null) {
            zzbavVar.zzc(1101);
        }
    }

    @Override // defpackage.b22
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        switch (j92Var.g) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(final zzfex zzfexVar) {
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqw
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzbbc.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbbc.zzi.zza zzaVarZzbM = zzaVar.zze().zzad().zzbM();
                zzaVarZzbM.zzo(zzfexVar.zzb.zzb.zzb);
                zzbVarZzbM.zzT(zzaVarZzbM);
                zzaVar.zzG(zzbVarZzbM);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzi(final zzbbc.zzb zzbVar) {
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqz
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        });
        this.zza.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzj(final zzbbc.zzb zzbVar) {
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqx
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        });
        this.zza.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzm(final zzbbc.zzb zzbVar) {
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqy
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        });
        this.zza.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final synchronized void zzr() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        this.zza.zzc(3);
    }
}
