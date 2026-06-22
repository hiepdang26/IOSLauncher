package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdka implements zzber {
    final /* synthetic */ zzdkx zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdka(zzdkx zzdkxVar, ViewGroup viewGroup) {
        this.zza = zzdkxVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzc() {
        zzfxr zzfxrVar = zzdjx.zza;
        Map mapZzm = this.zza.zzm();
        if (mapZzm == null) {
            return;
        }
        int size = zzfxrVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzm.get((String) zzfxrVar.get(i));
            i++;
            if (obj != null) {
                this.zza.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
