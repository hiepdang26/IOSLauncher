package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbnx {
    private final zzbna zza;
    private do0 zzb;

    public zzbnx(zzbna zzbnaVar) {
        this.zza = zzbnaVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzbzt zzbztVar = new zzbzt();
            this.zzb = zzbztVar;
            this.zza.zzb(null).zzj(new zzbzx() { // from class: com.google.android.gms.internal.ads.zzbnu
                @Override // com.google.android.gms.internal.ads.zzbzx
                public final void zza(Object obj) {
                    zzbztVar.zzc((zzbnb) obj);
                }
            }, new zzbzv() { // from class: com.google.android.gms.internal.ads.zzbnv
                @Override // com.google.android.gms.internal.ads.zzbzv
                public final void zza() {
                    zzbztVar.zzd(new zzbnd("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzboa zza(String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        zzd();
        return new zzboa(this.zzb, "google.afma.activeView.handleUpdate", zzbnhVar, zzbngVar);
    }

    public final void zzb(final String str, final zzbix zzbixVar) {
        zzd();
        this.zzb = zzgcj.zzn(this.zzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbnw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                zzbnb zzbnbVar = (zzbnb) obj;
                zzbnbVar.zzq(str, zzbixVar);
                return zzgcj.zzh(zzbnbVar);
            }
        }, zzbzo.zzf);
    }

    public final void zzc(final String str, final zzbix zzbixVar) {
        this.zzb = zzgcj.zzm(this.zzb, new zzful() { // from class: com.google.android.gms.internal.ads.zzbnt
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzbnb zzbnbVar = (zzbnb) obj;
                zzbnbVar.zzr(str, zzbixVar);
                return zzbnbVar;
            }
        }, zzbzo.zzf);
    }
}
