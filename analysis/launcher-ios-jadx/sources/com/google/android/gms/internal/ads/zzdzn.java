package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzn {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeaf zzc;

    public zzdzn(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzeaf zzeafVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzeafVar;
    }

    public final do0 zza(zzbuc zzbucVar) {
        return this.zzc.zza(zzbucVar, ((Long) n42.d.c.zza(zzbbw.zzkG)).longValue());
    }

    public final do0 zzb(final zzbuc zzbucVar) {
        String str = zzbucVar.zzb;
        cd2 cd2Var = hd2.B.c;
        return zzgcj.zzn(zzgcj.zzf(zzgca.zzu(cd2.c(str) ? zzgcj.zzg(new zzdyp(1, "Ads signal service force local")) : zzgcj.zzf(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzdzj
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return this.zza.zza(zzbucVar);
            }
        }, this.zza), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzk
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgcj.zzg(cause);
            }
        }, this.zzb)), zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzl
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(null);
            }
        }, this.zzb), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                InputStreamReader inputStreamReader;
                StringBuilder sb;
                char[] cArr;
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzgcj.zzh(jSONObject);
                }
                try {
                    cd2 cd2Var2 = hd2.B.c;
                    inputStreamReader = new InputStreamReader(inputStream);
                    sb = new StringBuilder(8192);
                    cArr = new char[2048];
                } catch (IOException | JSONException e) {
                    hd2.B.g.zzw(e, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                while (true) {
                    int i = inputStreamReader.read(cArr);
                    if (i == -1) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                    return zzgcj.zzh(jSONObject);
                }
                jSONObject = new JSONObject(sb.toString());
                return zzgcj.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
