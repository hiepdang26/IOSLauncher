package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzboq extends zzaxm implements zzbos {
    public zzboq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zze() {
        zzdc(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzf() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzh(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzi(int i, String str) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        zzdc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzj(int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzk(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzl(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzm() {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzn() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzo() {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzp() {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzq(String str, String str2) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzr(zzbfx zzbfxVar, String str) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfxVar);
        parcelZza.writeString(str);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzs(zzbvz zzbvzVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzt(zzbwd zzbwdVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwdVar);
        zzdc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzu() {
        zzdc(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzv() {
        zzdc(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzw() {
        zzdc(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzx() {
        zzdc(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzy() {
        zzdc(13, zza());
    }
}
