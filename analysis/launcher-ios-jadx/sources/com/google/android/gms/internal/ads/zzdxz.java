package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import defpackage.m42;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxz extends zzbut {
    final /* synthetic */ zzdya zza;

    public zzdxz(zzdya zzdyaVar) {
        this.zza = zzdyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zze(o42 o42Var) {
        zzbzt zzbztVar = this.zza.zza;
        o42Var.getClass();
        zzbztVar.zzd(new m42(o42Var.g, o42Var.h));
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdya zzdyaVar = this.zza;
        zzdyaVar.zza.zzc(new zzdyq(autoCloseInputStream, zzdyaVar.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzbuu
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvb zzbvbVar) {
        this.zza.zza.zzc(new zzdyq(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvbVar));
    }
}
