package com.google.android.gms.internal.ads;

import defpackage.b22;
import defpackage.j92;
import defpackage.ly0;
import defpackage.mc2;
import defpackage.u6;
import defpackage.xc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdba implements u6, ly0, zzcwq, b22, zzczb, zzcxk, zzcyp, mc2, zzcxg, zzdeq {
    private final zzday zza = new zzday(this, null);
    private zzemk zzb;
    private zzemo zzc;
    private zzfaj zzd;
    private zzfdo zze;

    private static void zzn(Object obj, zzdaz zzdazVar) {
        if (obj != null) {
            zzdazVar.zza(obj);
        }
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczq
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).onAdClicked();
            }
        });
        zzn(this.zzc, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczr
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemo) obj).onAdClicked();
            }
        });
    }

    @Override // defpackage.ly0
    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczw
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // defpackage.u6
    public final void onAppEvent(final String str, final String str2) {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdac
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdav
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zza();
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdaw
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zza();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdao
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzb();
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdap
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczx
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzc();
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczy
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdal
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzdG();
            }
        });
        zzn(this.zzc, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdaq
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemo) obj).zzdG();
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdar
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzdG();
            }
        });
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdas
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzdG();
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdH() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdaj
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdad
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzdf();
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdk() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczv
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdq() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdai
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzdq();
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdae
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzdr();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(final zzbvn zzbvnVar, final String str, final String str2) {
        zzn(this.zzb, new zzdaz(zzbvnVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzczz
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdab
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzds(zzbvnVar, str, str2);
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdt() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdak
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzdt();
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdu(final int i) {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdam
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzdu(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczp
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdaa
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczs
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczt
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final void zzg() {
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdan
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczb
    public final void zzh(final xc2 xc2Var) {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdaf
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzh(xc2Var);
            }
        });
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdag
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzh(xc2Var);
            }
        });
        zzn(this.zzd, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdah
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfaj) obj).zzh(xc2Var);
            }
        });
    }

    public final zzday zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcxg
    public final void zzq(final j92 j92Var) {
        zzn(this.zze, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdat
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzfdo) obj).zzq(j92Var);
            }
        });
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzdau
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzq(j92Var);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        zzn(this.zzb, new zzdaz() { // from class: com.google.android.gms.internal.ads.zzczu
            @Override // com.google.android.gms.internal.ads.zzdaz
            public final void zza(Object obj) {
                ((zzemk) obj).zzr();
            }
        });
    }
}
