package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.k92;
import defpackage.n42;
import defpackage.x32;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzbhv implements zzbix {
    public final /* synthetic */ zzdeq zza;
    public final /* synthetic */ zzcni zzb;

    public /* synthetic */ zzbhv(zzdeq zzdeqVar, zzcni zzcniVar) {
        this.zza = zzdeqVar;
        this.zzb = zzcniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        zzbiw.zzc(map, this.zza);
        final String str = (String) map.get("u");
        if (str == null) {
            k92.h("URL missing from click GMSG.");
            return;
        }
        final zzcni zzcniVar = this.zzb;
        zzgca zzgcaVarZzu = zzgca.zzu(zzbiw.zza(zzcejVar, str));
        zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbhx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj2) {
                zzcni zzcniVar2;
                String str2 = (String) obj2;
                zzbix zzbixVar = zzbiw.zza;
                return (((Boolean) n42.d.c.zza(zzbbw.zzjg)).booleanValue() && (zzcniVar2 = zzcniVar) != null && zzcni.zzj(str)) ? zzcniVar2.zzb(str2, x32.f.e) : zzgcj.zzh(str2);
            }
        };
        zzgcu zzgcuVar = zzbzo.zza;
        zzgcj.zzr(zzgcj.zzn(zzgcaVarZzu, zzgbqVar, zzgcuVar), new zzbil(zzcejVar), zzgcuVar);
    }
}
