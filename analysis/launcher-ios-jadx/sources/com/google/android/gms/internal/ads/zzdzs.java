package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import defpackage.do0;
import defpackage.ka2;
import defpackage.x32;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzs {
    private final zzgcu zza;
    private final zzdzn zzb;
    private final zzfjl zzc;

    public zzdzs(zzgcu zzgcuVar, zzdzn zzdznVar, zzfjl zzfjlVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdznVar;
        this.zzc = zzfjlVar;
    }

    public final do0 zza(final zzbvb zzbvbVar) {
        zzfjc zzfjcVarZzb = this.zzc.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzm(zzgcj.zzh(null), new zzful() { // from class: com.google.android.gms.internal.ads.zzdzp
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzbvb zzbvbVar2 = zzbvbVar;
                String strZzc = zzfvj.zzc(zzbvbVar2.zza.getString("ms"));
                ApplicationInfo applicationInfo = zzbvbVar2.zzc;
                String str = zzbvbVar2.zzh;
                return new zzbuc(applicationInfo, zzbvbVar2.zzd, zzbvbVar2.zzf, strZzc, -1, str, zzbvbVar2.zze, zzbvbVar2.zzk, zzbvbVar2.zzl);
            }
        }, this.zza));
        final zzdzn zzdznVar = this.zzb;
        Objects.requireNonNull(zzdznVar);
        return zzgcj.zzm(zzfjcVarZzb.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzq
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzdznVar.zzb((zzbuc) obj);
            }
        }).zza(), new zzful(this) { // from class: com.google.android.gms.internal.ads.zzdzr
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Bundle bundle = zzbvbVar.zza;
                if (bundle == null) {
                    return jSONObject;
                }
                try {
                    x32 x32Var = x32.f;
                    JSONObject jSONObjectG = x32Var.a.g(bundle);
                    try {
                        x32Var.a.getClass();
                        ka2.i(jSONObject, jSONObjectG);
                        return jSONObject;
                    } catch (JSONException unused) {
                        return jSONObjectG;
                    }
                } catch (JSONException unused2) {
                    return jSONObject;
                }
            }
        }, this.zza);
    }
}
