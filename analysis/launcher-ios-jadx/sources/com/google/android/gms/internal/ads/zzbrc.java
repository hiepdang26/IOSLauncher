package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.mc2;

/* JADX INFO: loaded from: classes.dex */
final class zzbrc implements mc2 {
    final /* synthetic */ zzbre zza;

    public zzbrc(zzbre zzbreVar) {
        this.zza = zzbreVar;
    }

    @Override // defpackage.mc2
    public final void zzdH() {
        k92.d("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // defpackage.mc2
    public final void zzdk() {
        k92.d("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // defpackage.mc2
    public final void zzdq() {
        k92.d("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        k92.d("Opening AdMobCustomTabsAdapter overlay.");
        zzbre zzbreVar = this.zza;
        zzbreVar.zzb.onAdOpened(zzbreVar);
    }

    @Override // defpackage.mc2
    public final void zzdt() {
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
        k92.d("AdMobCustomTabsAdapter overlay is closed.");
        zzbre zzbreVar = this.zza;
        zzbreVar.zzb.onAdClosed(zzbreVar);
    }
}
