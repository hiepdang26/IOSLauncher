package com.google.android.gms.internal.ads;

import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public class zzekh extends zzbor {
    private final zzcwo zza;
    private final zzdeo zzb;
    private final zzcxi zzc;
    private final zzcxx zzd;
    private final zzcyc zze;
    private final zzdbn zzf;
    private final zzcyw zzg;
    private final zzdfl zzh;
    private final zzdbj zzi;
    private final zzcxd zzj;

    public zzekh(zzcwo zzcwoVar, zzdeo zzdeoVar, zzcxi zzcxiVar, zzcxx zzcxxVar, zzcyc zzcycVar, zzdbn zzdbnVar, zzcyw zzcywVar, zzdfl zzdflVar, zzdbj zzdbjVar, zzcxd zzcxdVar) {
        this.zza = zzcwoVar;
        this.zzb = zzdeoVar;
        this.zzc = zzcxiVar;
        this.zzd = zzcxxVar;
        this.zze = zzcycVar;
        this.zzf = zzdbnVar;
        this.zzg = zzcywVar;
        this.zzh = zzdflVar;
        this.zzi = zzdbjVar;
        this.zzj = zzcxdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdG();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzf() {
        this.zzg.zzdu(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzg(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzi(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    @Deprecated
    public final void zzj(int i) {
        zzk(new j92(i, "", "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzk(j92 j92Var) {
        this.zzj.zza(zzfgi.zzc(8, j92Var));
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzl(String str) {
        zzk(new j92(0, str, "undefined", null, null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzn() {
        this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzo() {
        this.zze.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzp() {
        this.zzg.zzdr();
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzr(zzbfx zzbfxVar, String str) {
    }

    public void zzs(zzbvz zzbvzVar) {
    }

    public void zzt(zzbwd zzbwdVar) {
    }

    public void zzu() {
    }

    public void zzv() {
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzw() {
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzx() {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzh(j92 j92Var) {
    }
}
