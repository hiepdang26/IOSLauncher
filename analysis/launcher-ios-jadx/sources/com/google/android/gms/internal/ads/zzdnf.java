package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnf extends zzbft {
    private final String zza;
    private final zzdiw zzb;
    private final zzdjb zzc;

    public zzdnf(String str, zzdiw zzdiwVar, zzdjb zzdjbVar) {
        this.zza = str;
        this.zzb = zzdiwVar;
        this.zzc = zzdjbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final Bundle zzb() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final x82 zzc() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final zzbew zzd() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final zzbfd zze() {
        return this.zzc.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final he0 zzf() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final he0 zzg() {
        return new gy0(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String zzh() {
        return this.zzc.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String zzi() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String zzj() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String zzk() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String zzl() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final List zzm() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zzn() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zzo(Bundle bundle) {
        this.zzb.zzG(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zzp(Bundle bundle) {
        this.zzb.zzL(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final boolean zzq(Bundle bundle) {
        return this.zzb.zzY(bundle);
    }
}
