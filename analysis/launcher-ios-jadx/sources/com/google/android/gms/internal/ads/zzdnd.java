package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnd extends zzbfr {
    private final String zza;
    private final zzdiw zzb;
    private final zzdjb zzc;

    public zzdnd(String str, zzdiw zzdiwVar, zzdjb zzdjbVar) {
        this.zza = str;
        this.zzb = zzdiwVar;
        this.zzc = zzdjbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final double zzb() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final Bundle zzc() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final x82 zzd() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final zzbew zze() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final zzbfd zzf() {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final he0 zzg() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final he0 zzh() {
        return new gy0(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzi() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzj() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzk() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzl() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzm() {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzn() {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final List zzo() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzp() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzq(Bundle bundle) {
        this.zzb.zzG(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzr(Bundle bundle) {
        this.zzb.zzL(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final boolean zzs(Bundle bundle) {
        return this.zzb.zzY(bundle);
    }
}
