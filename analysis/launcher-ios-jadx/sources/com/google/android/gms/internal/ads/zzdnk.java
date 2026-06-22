package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.p72;
import defpackage.s72;
import defpackage.u82;
import defpackage.x82;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnk extends zzbgz {
    private final String zza;
    private final zzdiw zzb;
    private final zzdjb zzc;
    private final zzdsk zzd;

    public zzdnk(String str, zzdiw zzdiwVar, zzdjb zzdjbVar, zzdsk zzdskVar) {
        this.zza = str;
        this.zzb = zzdiwVar;
        this.zzc = zzdjbVar;
        this.zzd = zzdskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzA() {
        this.zzb.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzB(Bundle bundle) {
        this.zzb.zzL(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzC() {
        this.zzb.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzD(p72 p72Var) {
        this.zzb.zzO(p72Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzE(m82 m82Var) {
        try {
            if (!m82Var.zzf()) {
                this.zzd.zze();
            }
        } catch (RemoteException unused) {
            k92.j(3);
        }
        this.zzb.zzP(m82Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzF(zzbgx zzbgxVar) {
        this.zzb.zzQ(zzbgxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzG() {
        return this.zzb.zzV();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzH() {
        return (this.zzc.zzH().isEmpty() || this.zzc.zzk() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzI(Bundle bundle) {
        return this.zzb.zzY(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final double zze() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final Bundle zzf() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final u82 zzg() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue()) {
            return this.zzb.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final x82 zzh() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbew zzi() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfa zzj() {
        return this.zzb.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfd zzk() {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final he0 zzl() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final he0 zzm() {
        return new gy0(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzn() {
        return this.zzc.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzo() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzp() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzq() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzr() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzs() {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzt() {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzu() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzv() {
        return zzH() ? this.zzc.zzH() : Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzw() {
        this.zzb.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzx() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzy(s72 s72Var) {
        this.zzb.zzC(s72Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzz(Bundle bundle) {
        this.zzb.zzG(bundle);
    }
}
