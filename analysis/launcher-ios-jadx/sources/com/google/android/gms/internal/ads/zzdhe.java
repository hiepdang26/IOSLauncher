package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdhe implements zzcrx {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhfu zzd;
    private final zzdjm zze;

    public zzdhe(Map map, Map map2, Map map3, zzhfu zzhfuVar, zzdjm zzdjmVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhfuVar;
        this.zze = zzdjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrx
    public final zzeet zza(int i, String str) {
        zzeet zzeetVarZza;
        zzeet zzeetVar = (zzeet) this.zza.get(str);
        if (zzeetVar != null) {
            return zzeetVar;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzehh zzehhVar = (zzehh) this.zzc.get(str);
            if (zzehhVar != null) {
                return new zzeeu(zzehhVar, new zzful() { // from class: com.google.android.gms.internal.ads.zzcrz
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return new zzcsc((List) obj);
                    }
                });
            }
            zzeetVarZza = (zzeet) this.zzb.get(str);
            if (zzeetVarZza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzeetVarZza = ((zzcrx) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzeeu(zzeetVarZza, new zzful() { // from class: com.google.android.gms.internal.ads.zzcsa
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzcsc((zzcru) obj);
            }
        });
    }
}
