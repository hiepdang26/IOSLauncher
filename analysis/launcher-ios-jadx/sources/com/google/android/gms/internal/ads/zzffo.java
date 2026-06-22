package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzffo implements zzbix {
    public final /* synthetic */ zzdeq zza;
    public final /* synthetic */ zzcni zzb;
    public final /* synthetic */ zzfll zzc;
    public final /* synthetic */ zzedh zzd;

    public /* synthetic */ zzffo(zzdeq zzdeqVar, zzcni zzcniVar, zzfll zzfllVar, zzedh zzedhVar) {
        this.zza = zzdeqVar;
        this.zzb = zzcniVar;
        this.zzc = zzfllVar;
        this.zzd = zzedhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        zzbiw.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            k92.h("URL missing from click GMSG.");
            return;
        }
        zzedh zzedhVar = this.zzd;
        zzfll zzfllVar = this.zzc;
        zzgcj.zzr(zzbiw.zza(zzcejVar, str), new zzffq(zzcejVar, this.zzb, zzfllVar, zzedhVar), zzbzo.zza);
    }
}
