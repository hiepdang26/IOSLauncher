package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class zzceo implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbxl zza;
    final /* synthetic */ zzcer zzb;

    public zzceo(zzcer zzcerVar, zzbxl zzbxlVar) {
        this.zza = zzbxlVar;
        this.zzb = zzcerVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzW(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
