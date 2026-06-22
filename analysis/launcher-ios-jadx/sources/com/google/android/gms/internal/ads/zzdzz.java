package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import defpackage.do0;
import defpackage.hd2;
import defpackage.or1;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzz {
    public do0 zza;
    private final zzczm zzb;
    private final zzdzh zzc;
    private final zzfjl zzd;
    private final zzffg zze;
    private final or1 zzf;
    private final zzfki zzg;
    private final zzfkf zzh;
    private final Context zzi;
    private final zzgcu zzj;

    public zzdzz(zzczm zzczmVar, zzdzh zzdzhVar, zzfjl zzfjlVar, zzffg zzffgVar, or1 or1Var, zzfki zzfkiVar, zzfkf zzfkfVar, Context context, zzgcu zzgcuVar) {
        this.zzb = zzczmVar;
        this.zzc = zzdzhVar;
        this.zzd = zzfjlVar;
        this.zze = zzffgVar;
        this.zzf = or1Var;
        this.zzg = zzfkiVar;
        this.zzh = zzfkfVar;
        this.zzi = context;
        this.zzj = zzgcuVar;
    }

    public final zzbug zza(zzbvb zzbvbVar, zzebk zzebkVar) {
        zzebkVar.zzc.put("Content-Type", zzebkVar.zze);
        zzebkVar.zzc.put("User-Agent", hd2.B.c.w(this.zzi, zzbvbVar.zzb.g));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzebkVar.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbug(zzebkVar.zza, zzebkVar.zzb, bundle, zzebkVar.zzd, zzebkVar.zzf, zzbvbVar.zzd, zzbvbVar.zzh);
    }

    public final do0 zzc(final zzbvb zzbvbVar, final JSONObject jSONObject, final zzbvd zzbvdVar) {
        this.zzb.zzdn(zzbvbVar);
        zzfjc zzfjcVarZzb = this.zzd.zzb(zzfjf.PROXY, zzgcj.zzm(this.zzd.zzb(zzfjf.PREPARE_HTTP_REQUEST, zzgcj.zzh(new zzebo(jSONObject, zzbvdVar))).zze(new zzebp(zzbvbVar.zzg, this.zzh, zzfjt.zza(this.zzi, 9))).zza(), new zzful() { // from class: com.google.android.gms.internal.ads.zzdzv
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zza(zzbvbVar, (zzebk) obj);
            }
        }, this.zzj));
        final zzdzh zzdzhVar = this.zzc;
        Objects.requireNonNull(zzdzhVar);
        zzfiq zzfiqVarZza = zzfjcVarZzb.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzdzhVar.zzc((zzbug) obj);
            }
        }).zza();
        this.zza = zzfiqVarZza;
        do0 do0VarZzn = zzgcj.zzn(this.zzd.zzb(zzfjf.PRE_PROCESS, zzfiqVarZza).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzdzu
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                return new zzeax(zzebl.zza(new InputStreamReader((InputStream) obj)), jSONObject, zzbvdVar);
            }
        }).zzf(hd2.B.p.zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzeax.zza, zzbnl.zzb)).zza(), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzd(zzbvbVar, (InputStream) obj);
            }
        }, this.zzj);
        zzgcj.zzr(do0VarZzn, new zzdzy(this), this.zzj);
        return do0VarZzn;
    }

    public final /* synthetic */ do0 zzd(zzbvb zzbvbVar, InputStream inputStream) {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zze), zzfew.zza(new InputStreamReader(inputStream), zzbvbVar)));
    }
}
