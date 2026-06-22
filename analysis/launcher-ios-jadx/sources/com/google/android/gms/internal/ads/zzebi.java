package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import defpackage.do0;
import defpackage.k92;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzebi extends zzbun {
    private final Context zza;
    private final zzexh zzb;
    private final zzexf zzc;
    private final zzebq zzd;
    private final zzgcu zze;
    private final zzbvj zzf;

    public zzebi(Context context, zzexh zzexhVar, zzexf zzexfVar, zzebn zzebnVar, zzebq zzebqVar, zzgcu zzgcuVar, zzbvj zzbvjVar) {
        this.zza = context;
        this.zzb = zzexhVar;
        this.zzc = zzexfVar;
        this.zzd = zzebqVar;
        this.zze = zzgcuVar;
        this.zzf = zzbvjVar;
    }

    private final void zzc(do0 do0Var, zzbur zzburVar) {
        zzgcj.zzr(zzgcj.zzn(zzgca.zzu(do0Var), new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzebf
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(zzfgh.zza((InputStream) obj));
            }
        }, zzbzo.zza), new zzebh(this, zzburVar), zzbzo.zzf);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.do0 zzb(com.google.android.gms.internal.ads.zzbug r8, int r9) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebi.zzb(com.google.android.gms.internal.ads.zzbug, int):do0");
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zze(zzbug zzbugVar, zzbur zzburVar) {
        zzc(zzb(zzbugVar, Binder.getCallingUid()), zzburVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzf(zzbuc zzbucVar, zzbur zzburVar) {
        zzeww zzewwVar = new zzeww(zzbucVar, Binder.getCallingUid());
        zzexh zzexhVar = this.zzb;
        zzexhVar.zza(zzewwVar);
        final zzexi zzexiVarZzb = zzexhVar.zzb();
        zzfjl zzfjlVarZzb = zzexiVarZzb.zzb();
        zzfiq zzfiqVarZza = zzfjlVarZzb.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzi()).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzebe
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzexiVarZzb.zza().zza(new JSONObject(), new Bundle());
            }
        }).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzebd
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                k92.a("GMS AdRequest Signals: ");
                k92.a(jSONObject.toString(2));
                return jSONObject;
            }
        }).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzebc
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
            }
        }).zza();
        zzc(zzfiqVarZza, zzburVar);
        if (((Boolean) zzbds.zzf.zze()).booleanValue()) {
            final zzebq zzebqVar = this.zzd;
            Objects.requireNonNull(zzebqVar);
            zzfiqVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebg
                @Override // java.lang.Runnable
                public final void run() {
                    zzebqVar.zzb();
                }
            }, this.zze);
        }
    }
}
