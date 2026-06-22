package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import defpackage.m42;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeah extends zzbuq {
    final /* synthetic */ zzeai zza;

    public zzeah(zzeai zzeaiVar) {
        this.zza = zzeaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zze(o42 o42Var) {
        zzbzt zzbztVar = this.zza.zza;
        o42Var.getClass();
        zzbztVar.zzd(new m42(o42Var.g, o42Var.h));
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
