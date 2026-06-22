package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import defpackage.x32;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeay extends zzbuj {
    private final Context zza;
    private final zzgcu zzb;
    private final zzebq zzc;
    private final zzclv zzd;
    private final ArrayDeque zze;
    private final zzfki zzf;
    private final zzbvj zzg;

    public zzeay(Context context, zzgcu zzgcuVar, zzbvj zzbvjVar, zzclv zzclvVar, zzebq zzebqVar, ArrayDeque arrayDeque, zzebn zzebnVar, zzfki zzfkiVar) {
        zzbbw.zza(context);
        this.zza = context;
        this.zzb = zzgcuVar;
        this.zzg = zzbvjVar;
        this.zzc = zzebqVar;
        this.zzd = zzclvVar;
        this.zze = arrayDeque;
        this.zzf = zzfkiVar;
    }

    private final synchronized zzeav zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeav zzeavVar = (zzeav) it.next();
            if (zzeavVar.zzc.equals(str)) {
                it.remove();
                return zzeavVar;
            }
        }
        return null;
    }

    private static do0 zzl(do0 do0Var, zzfjl zzfjlVar, zzbno zzbnoVar, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzbne zzbneVarZza = zzbnoVar.zza("AFMA_getAdDictionary", zzbnl.zza, new zzbng() { // from class: com.google.android.gms.internal.ads.zzeaq
            @Override // com.google.android.gms.internal.ads.zzbng
            public final Object zza(JSONObject jSONObject) {
                return new zzbvd(jSONObject);
            }
        });
        zzfke.zzd(do0Var, zzfjuVar);
        zzfiq zzfiqVarZza = zzfjlVar.zzb(zzfjf.BUILD_URL, do0Var).zzf(zzbneVarZza).zza();
        zzfke.zzc(zzfiqVarZza, zzfkfVar, zzfjuVar);
        return zzfiqVarZza;
    }

    private static do0 zzm(final zzbvb zzbvbVar, zzfjl zzfjlVar, final zzewr zzewrVar) {
        zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeak
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzewrVar.zzb().zza(x32.f.a.g((Bundle) obj), zzbvbVar.zzm);
            }
        };
        return zzfjlVar.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzh(zzbvbVar.zza)).zzf(zzgbqVar).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzeal
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                k92.a("Ad request signals:");
                k92.a(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzeav zzeavVar) {
        zzo();
        this.zze.addLast(zzeavVar);
    }

    private final synchronized void zzo() {
        int iIntValue = ((Long) zzbdz.zzc.zze()).intValue();
        while (this.zze.size() >= iIntValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(do0 do0Var, zzbuu zzbuuVar, zzbvb zzbvbVar) {
        zzgcj.zzr(zzgcj.zzn(do0Var, new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzear
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(zzfgh.zza((InputStream) obj));
            }
        }, zzbzo.zza), new zzeau(this, zzbuuVar, zzbvbVar), zzbzo.zzf);
    }

    public final do0 zzb(final zzbvb zzbvbVar, int i) {
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Split request is disabled."));
        }
        zzfhb zzfhbVar = zzbvbVar.zzi;
        if (zzfhbVar == null) {
            return zzgcj.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfhbVar.zzc == 0 || zzfhbVar.zzd == 0) {
            return zzgcj.zzg(new Exception("Caching is disabled."));
        }
        zzbno zzbnoVarZzb = hd2.B.p.zzb(this.zza, or1.a(), this.zzf);
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i);
        zzfjl zzfjlVarZzc = zzewrVarZzr.zzc();
        final do0 do0VarZzm = zzm(zzbvbVar, zzfjlVarZzc, zzewrVarZzr);
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        final zzfju zzfjuVarZza = zzfjt.zza(this.zza, 9);
        final do0 do0VarZzl = zzl(do0VarZzm, zzfjlVarZzc, zzbnoVarZzb, zzfkfVarZzd, zzfjuVarZza);
        return zzfjlVarZzc.zza(zzfjf.GET_URL_AND_CACHE_KEY, do0VarZzm, do0VarZzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeao
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzj(do0VarZzl, do0VarZzm, zzbvbVar, zzfjuVarZza);
            }
        }).zza();
    }

    public final do0 zzc(final zzbvb zzbvbVar, int i) {
        zzeav zzeavVarZzk;
        zzfiq zzfiqVarZza;
        zzbno zzbnoVarZzb = hd2.B.p.zzb(this.zza, or1.a(), this.zzf);
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i);
        zzbne zzbneVarZza = zzbnoVarZzb.zza("google.afma.response.normalize", zzeax.zza, zzbnl.zzb);
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            zzeavVarZzk = zzk(zzbvbVar.zzh);
            if (zzeavVarZzk == null) {
                k92.a("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbvbVar.zzj;
            zzeavVarZzk = null;
            if (str != null && !str.isEmpty()) {
                k92.a("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfju zzfjuVarZza = zzeavVarZzk == null ? zzfjt.zza(this.zza, 9) : zzeavVarZzk.zzd;
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        zzfkfVarZzd.zzd(zzbvbVar.zza.getStringArrayList("ad_types"));
        zzebp zzebpVar = new zzebp(zzbvbVar.zzg, zzfkfVarZzd, zzfjuVarZza);
        zzebm zzebmVar = new zzebm(this.zza, zzbvbVar.zzb.g, this.zzg, i);
        zzfjl zzfjlVarZzc = zzewrVarZzr.zzc();
        zzfju zzfjuVarZza2 = zzfjt.zza(this.zza, 11);
        if (zzeavVarZzk == null) {
            final do0 do0VarZzm = zzm(zzbvbVar, zzfjlVarZzc, zzewrVarZzr);
            final do0 do0VarZzl = zzl(do0VarZzm, zzfjlVarZzc, zzbnoVarZzb, zzfkfVarZzd, zzfjuVarZza);
            zzfju zzfjuVarZza3 = zzfjt.zza(this.zza, 10);
            final zzfiq zzfiqVarZza2 = zzfjlVarZzc.zza(zzfjf.HTTP, do0VarZzl, do0VarZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeam
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzbvb zzbvbVar2;
                    Bundle bundle;
                    zzbvd zzbvdVar = (zzbvd) do0VarZzl.get();
                    if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && (bundle = (zzbvbVar2 = zzbvbVar).zzm) != null) {
                        bundle.putLong(zzdrt.GET_AD_DICTIONARY_SDKCORE_START.zza(), zzbvdVar.zzc());
                        zzbvbVar2.zzm.putLong(zzdrt.GET_AD_DICTIONARY_SDKCORE_END.zza(), zzbvdVar.zzb());
                    }
                    return new zzebo((JSONObject) do0VarZzm.get(), zzbvdVar);
                }
            }).zze(zzebpVar).zze(new zzfka(zzfjuVarZza3)).zze(zzebmVar).zza();
            zzfke.zza(zzfiqVarZza2, zzfkfVarZzd, zzfjuVarZza3);
            zzfke.zzd(zzfiqVarZza2, zzfjuVarZza2);
            zzfiqVarZza = zzfjlVarZzc.zza(zzfjf.PRE_PROCESS, do0VarZzm, do0VarZzl, zzfiqVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzean
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
                        String strZza = zzdrt.HTTP_RESPONSE_READY.zza();
                        hd2.B.j.getClass();
                        bundle.putLong(strZza, System.currentTimeMillis());
                    }
                    return new zzeax((zzebl) zzfiqVarZza2.get(), (JSONObject) do0VarZzm.get(), (zzbvd) do0VarZzl.get());
                }
            }).zzf(zzbneVarZza).zza();
        } else {
            zzebo zzeboVar = new zzebo(zzeavVarZzk.zzb, zzeavVarZzk.zza);
            zzfju zzfjuVarZza4 = zzfjt.zza(this.zza, 10);
            final zzfiq zzfiqVarZza3 = zzfjlVarZzc.zzb(zzfjf.HTTP, zzgcj.zzh(zzeboVar)).zze(zzebpVar).zze(new zzfka(zzfjuVarZza4)).zze(zzebmVar).zza();
            zzfke.zza(zzfiqVarZza3, zzfkfVarZzd, zzfjuVarZza4);
            final do0 do0VarZzh = zzgcj.zzh(zzeavVarZzk);
            zzfke.zzd(zzfiqVarZza3, zzfjuVarZza2);
            zzfiqVarZza = zzfjlVarZzc.zza(zzfjf.PRE_PROCESS, zzfiqVarZza3, do0VarZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeaj
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzebl zzeblVar = (zzebl) zzfiqVarZza3.get();
                    do0 do0Var = do0VarZzh;
                    return new zzeax(zzeblVar, ((zzeav) do0Var.get()).zzb, ((zzeav) do0Var.get()).zza);
                }
            }).zzf(zzbneVarZza).zza();
        }
        zzfke.zza(zzfiqVarZza, zzfkfVarZzd, zzfjuVarZza2);
        return zzfiqVarZza;
    }

    public final do0 zzd(final zzbvb zzbvbVar, int i) {
        zzbno zzbnoVarZzb = hd2.B.p.zzb(this.zza, or1.a(), this.zzf);
        if (!((Boolean) zzbee.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Signal collection disabled."));
        }
        zzewr zzewrVarZzr = this.zzd.zzr(zzbvbVar, i);
        final zzevr zzevrVarZza = zzewrVarZzr.zza();
        zzbne zzbneVarZza = zzbnoVarZzb.zza("google.afma.request.getSignals", zzbnl.zza, zzbnl.zzb);
        zzfju zzfjuVarZza = zzfjt.zza(this.zza, 22);
        zzfiq zzfiqVarZza = zzewrVarZzr.zzc().zzb(zzfjf.GET_SIGNALS, zzgcj.zzh(zzbvbVar.zza)).zze(new zzfka(zzfjuVarZza)).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeas
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzevrVarZza.zza(x32.f.a.g((Bundle) obj), zzbvbVar.zzm);
            }
        }).zzb(zzfjf.JS_SIGNALS).zzf(zzbneVarZza).zza();
        zzfkf zzfkfVarZzd = zzewrVarZzr.zzd();
        zzfkfVarZzd.zzd(zzbvbVar.zza.getStringArrayList("ad_types"));
        zzfkfVarZzd.zzf(zzbvbVar.zza.getBundle("extras"));
        zzfke.zzb(zzfiqVarZza, zzfkfVarZzd, zzfjuVarZza);
        if (((Boolean) zzbds.zzg.zze()).booleanValue()) {
            zzebq zzebqVar = this.zzc;
            Objects.requireNonNull(zzebqVar);
            zzfiqVarZza.addListener(new zzeap(zzebqVar), this.zzb);
        }
        return zzfiqVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zze(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        zzp(zzb(zzbvbVar, Binder.getCallingUid()), zzbuuVar, zzbvbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzf(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Bundle bundle;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
            String strZza = zzdrt.SERVICE_CONNECTED.zza();
            hd2.B.j.getClass();
            bundle.putLong(strZza, System.currentTimeMillis());
        }
        zzp(zzd(zzbvbVar, Binder.getCallingUid()), zzbuuVar, zzbvbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzg(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Bundle bundle;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvbVar.zzm) != null) {
            String strZza = zzdrt.SERVICE_CONNECTED.zza();
            hd2.B.j.getClass();
            bundle.putLong(strZza, System.currentTimeMillis());
        }
        do0 do0VarZzc = zzc(zzbvbVar, Binder.getCallingUid());
        zzp(do0VarZzc, zzbuuVar, zzbvbVar);
        if (((Boolean) zzbds.zze.zze()).booleanValue()) {
            zzebq zzebqVar = this.zzc;
            Objects.requireNonNull(zzebqVar);
            do0VarZzc.addListener(new zzeap(zzebqVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzh(String str, zzbuu zzbuuVar) {
        zzp(zzi(str), zzbuuVar, null);
    }

    public final do0 zzi(String str) {
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzk(str) == null ? zzgcj.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgcj.zzh(new zzeat(this));
        }
        return zzgcj.zzg(new Exception("Split request is disabled."));
    }

    public final /* synthetic */ InputStream zzj(do0 do0Var, do0 do0Var2, zzbvb zzbvbVar, zzfju zzfjuVar) {
        String strZze = ((zzbvd) do0Var.get()).zze();
        zzn(new zzeav((zzbvd) do0Var.get(), (JSONObject) do0Var2.get(), zzbvbVar.zzh, strZze, zzfjuVar));
        return new ByteArrayInputStream(strZze.getBytes(zzfuj.zzc));
    }
}
