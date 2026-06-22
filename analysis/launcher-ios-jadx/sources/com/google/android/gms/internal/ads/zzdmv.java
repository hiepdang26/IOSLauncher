package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import defpackage.n42;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmv {
    private final Executor zza;
    private final zzcop zzb;
    private final zzdek zzc;
    private final zzcni zzd;

    public zzdmv(Executor executor, zzcop zzcopVar, zzdek zzdekVar, zzcni zzcniVar) {
        this.zza = executor;
        this.zzc = zzdekVar;
        this.zzb = zzcopVar;
        this.zzd = zzcniVar;
    }

    public final void zza(final zzcej zzcejVar) {
        if (zzcejVar == null) {
            return;
        }
        this.zzc.zza(zzcejVar.zzF());
        this.zzc.zzo(new zzaxw() { // from class: com.google.android.gms.internal.ads.zzdmr
            @Override // com.google.android.gms.internal.ads.zzaxw
            public final void zzdp(zzaxv zzaxvVar) {
                zzcgb zzcgbVarZzN = zzcejVar.zzN();
                Rect rect = zzaxvVar.zzd;
                zzcgbVarZzN.zzq(rect.left, rect.top, false);
            }
        }, this.zza);
        this.zzc.zzo(new zzaxw() { // from class: com.google.android.gms.internal.ads.zzdms
            @Override // com.google.android.gms.internal.ads.zzaxw
            public final void zzdp(zzaxv zzaxvVar) {
                HashMap map = new HashMap();
                map.put("isVisible", true != zzaxvVar.zzj ? "0" : "1");
                zzcejVar.zzd("onAdVisibilityChanged", map);
            }
        }, this.zza);
        this.zzc.zzo(this.zzb, this.zza);
        this.zzb.zzf(zzcejVar);
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        if (((Boolean) n42.d.c.zza(zzbbw.zzjl)).booleanValue() && zzcgbVarZzN != null) {
            zzcgbVarZzN.zzJ(this.zzd);
            zzcgbVarZzN.zzK(this.zzd, null, null);
        }
        zzcejVar.zzag("/trackActiveViewUnit", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdmt
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcej) obj, map);
            }
        });
        zzcejVar.zzag("/untrackActiveViewUnit", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdmu
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcej) obj, map);
            }
        });
    }

    public final /* synthetic */ void zzb(zzcej zzcejVar, Map map) {
        this.zzb.zzb();
    }

    public final /* synthetic */ void zzc(zzcej zzcejVar, Map map) {
        this.zzb.zza();
    }
}
