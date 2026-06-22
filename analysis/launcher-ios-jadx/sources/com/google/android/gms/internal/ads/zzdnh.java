package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdnh implements zzber {
    final /* synthetic */ String zza = "_videoMediaView";
    final /* synthetic */ zzdni zzb;

    public zzdnh(zzdni zzdniVar, String str) {
        this.zzb = zzdniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzc() {
        zzdni zzdniVar = this.zzb;
        if (zzdniVar.zzd != null) {
            zzdniVar.zzd.zzF(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzd(MotionEvent motionEvent) {
    }
}
