package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* JADX INFO: loaded from: classes.dex */
final class zzxl implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzxt zza;

    public zzxl(zzxm zzxmVar, zzxt zzxtVar) {
        this.zza = zzxtVar;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }
}
