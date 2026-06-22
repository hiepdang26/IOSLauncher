package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.do0;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import defpackage.za2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdun {
    private final long zzd;
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdqb zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsu zzl;
    private final or1 zzm;
    private final zzddp zzo;
    private final zzfki zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzbzt zze = new zzbzt();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;

    public zzdun(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdqb zzdqbVar, ScheduledExecutorService scheduledExecutorService, zzdsu zzdsuVar, or1 or1Var, zzddp zzddpVar, zzfki zzfkiVar) {
        this.zzh = zzdqbVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsuVar;
        this.zzm = or1Var;
        this.zzo = zzddpVar;
        this.zzp = zzfkiVar;
        hd2.B.j.getClass();
        this.zzd = SystemClock.elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static void zzj(final zzdun zzdunVar, String str) {
        zzdum zzdumVar;
        zzdum zzdumVar2;
        int i = 5;
        final zzfju zzfjuVarZza = zzfjt.zza(zzdunVar.zzf, 5);
        zzfjuVarZza.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfju zzfjuVarZza2 = zzfjt.zza(zzdunVar.zzf, i);
                zzfjuVarZza2.zzi();
                zzfjuVarZza2.zzd(next);
                final Object obj = new Object();
                final zzbzt zzbztVar = new zzbzt();
                do0 do0VarZzo = zzgcj.zzo(zzbztVar, ((Long) n42.d.c.zza(zzbbw.zzbE)).longValue(), TimeUnit.SECONDS, zzdunVar.zzk);
                zzdunVar.zzl.zzc(next);
                zzdunVar.zzo.zzc(next);
                hd2.B.j.getClass();
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                do0VarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdue
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzq(obj, zzbztVar, next, jElapsedRealtime, zzfjuVarZza2);
                    }
                }, zzdunVar.zzi);
                arrayList.add(do0VarZzo);
                zzdum zzdumVar3 = new zzdum(zzdunVar, obj, next, jElapsedRealtime, zzfjuVarZza2, zzbztVar);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String strOptString = jSONObject2.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    zzdumVar = zzdumVar3;
                                    try {
                                        bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                        zzdumVar3 = zzdumVar;
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            zzdum zzdumVar4 = zzdumVar3;
                            arrayList2.add(new zzblf(strOptString, bundle));
                            i2++;
                            zzdumVar3 = zzdumVar4;
                        }
                    } catch (JSONException unused2) {
                    }
                    zzdumVar = zzdumVar3;
                } else {
                    zzdumVar = zzdumVar3;
                }
                zzdunVar.zzv(next, false, "", 0);
                try {
                    final zzfge zzfgeVarZzc = zzdunVar.zzh.zzc(next, new JSONObject());
                    Executor executor = zzdunVar.zzj;
                    final zzdum zzdumVar5 = zzdumVar;
                    try {
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdui
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzn(next, zzdumVar5, zzfgeVarZzc, arrayList2);
                            }
                        };
                        zzdumVar2 = zzdumVar5;
                        try {
                            executor.execute(runnable);
                        } catch (zzffn unused3) {
                            try {
                                zzdumVar2.zze("Failed to create Adapter.");
                            } catch (RemoteException unused4) {
                                k92.f();
                            }
                        }
                    } catch (zzffn unused5) {
                        zzdumVar2 = zzdumVar5;
                    }
                } catch (zzffn unused6) {
                    zzdumVar2 = zzdumVar;
                }
                i = 5;
            }
            zzgcj.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzduf
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    this.zza.zzf(zzfjuVarZza);
                    return null;
                }
            }, zzdunVar.zzi);
        } catch (JSONException e) {
            k92.b();
            zzdunVar.zzo.zza("MalformedJson");
            zzdunVar.zzl.zza("MalformedJson");
            zzdunVar.zze.zzd(e);
            hd2.B.g.zzw(e, "AdapterInitializer.updateAdapterStatus");
            zzfki zzfkiVar = zzdunVar.zzp;
            zzfjuVarZza.zzh(e);
            zzfjuVarZza.zzg(false);
            zzfkiVar.zzb(zzfjuVarZza.zzm());
        }
    }

    private final synchronized do0 zzu() {
        hd2 hd2Var = hd2.B;
        String strZzc = ((ib2) hd2Var.g.zzi()).x().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzgcj.zzh(strZzc);
        }
        final zzbzt zzbztVar = new zzbzt();
        za2 za2VarZzi = hd2Var.g.zzi();
        ((ib2) za2VarZzi).c.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdug
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(zzbztVar);
            }
        });
        return zzbztVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbkv(str, z, i, str2));
    }

    public final /* synthetic */ Object zzf(zzfju zzfjuVar) {
        this.zze.zzc(Boolean.TRUE);
        zzfjuVar.zzg(true);
        this.zzp.zzb(zzfjuVar.zzm());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbkv zzbkvVar = (zzbkv) this.zzn.get(str);
            arrayList.add(new zzbkv(str, zzbkvVar.zzb, zzbkvVar.zzc, zzbkvVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    public final void zzm() {
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                hd2.B.j.getClass();
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (SystemClock.elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzn(String str, zzbkz zzbkzVar, zzfge zzfgeVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbkzVar.zzf();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfgeVar.zzi(context, zzbkzVar, list);
            } catch (RemoteException unused) {
                k92.f();
            }
        } catch (RemoteException e) {
            throw new zzfvq(e);
        } catch (zzffn unused2) {
            zzbkzVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    public final /* synthetic */ void zzo(final zzbzt zzbztVar) {
        this.zzi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdud
            @Override // java.lang.Runnable
            public final void run() {
                String strZzc = ((ib2) hd2.B.g.zzi()).x().zzc();
                boolean zIsEmpty = TextUtils.isEmpty(strZzc);
                zzbzt zzbztVar2 = zzbztVar;
                if (zIsEmpty) {
                    zzbztVar2.zzd(new Exception());
                } else {
                    zzbztVar2.zzc(strZzc);
                }
            }
        });
    }

    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    public final void zzq(Object obj, zzbzt zzbztVar, String str, long j, zzfju zzfjuVar) {
        synchronized (obj) {
            try {
                if (!zzbztVar.isDone()) {
                    hd2.B.j.getClass();
                    zzv(str, false, "Timeout.", (int) (SystemClock.elapsedRealtime() - j));
                    this.zzl.zzb(str, "timeout");
                    this.zzo.zzb(str, "timeout");
                    zzfki zzfkiVar = this.zzp;
                    zzfjuVar.zzc("Timeout");
                    zzfjuVar.zzg(false);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                    zzbztVar.zzc(Boolean.FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbdy.zza.zze()).booleanValue()) {
            int i = this.zzm.i;
            zzbbn zzbbnVar = zzbbw.zzbD;
            n42 n42Var = n42.d;
            if (i >= ((Integer) n42Var.c.zza(zzbbnVar)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.zza) {
                            return;
                        }
                        this.zzl.zzf();
                        this.zzo.zzf();
                        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduj
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzp();
                            }
                        }, this.zzi);
                        this.zza = true;
                        do0 do0VarZzu = zzu();
                        this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduc
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzm();
                            }
                        }, ((Long) n42Var.c.zza(zzbbw.zzbF)).longValue(), TimeUnit.SECONDS);
                        zzgcj.zzr(do0VarZzu, new zzdul(this), this.zzi);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzblc zzblcVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduh
            @Override // java.lang.Runnable
            public final void run() {
                zzdun zzdunVar = this.zza;
                try {
                    zzblcVar.zzb(zzdunVar.zzg());
                } catch (RemoteException unused) {
                    k92.f();
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
