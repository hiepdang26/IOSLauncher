package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.do0;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.wd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeup implements zzevo {
    final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final zzelg zzd;
    private final Context zze;
    private final zzffg zzf;
    private final zzelc zzg;
    private final zzdqb zzh;
    private final zzdup zzi;

    public zzeup(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, String str, zzelg zzelgVar, Context context, zzffg zzffgVar, zzelc zzelcVar, zzdqb zzdqbVar, zzdup zzdupVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzelgVar;
        this.zze = context;
        this.zzf = zzffgVar;
        this.zzg = zzelcVar;
        this.zzh = zzdqbVar;
        this.zzi = zzdupVar;
    }

    public static do0 zzc(zzeup zzeupVar) {
        zzeup zzeupVar2;
        zzbbn zzbbnVar = zzbbw.zzjW;
        n42 n42Var = n42.d;
        String lowerCase = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() ? zzeupVar.zzf.zzf.toLowerCase(Locale.ROOT) : zzeupVar.zzf.zzf;
        final Bundle bundleZzg = ((Boolean) n42Var.c.zza(zzbbw.zzbt)).booleanValue() ? zzeupVar.zzi.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) n42Var.c.zza(zzbbw.zzbC)).booleanValue()) {
            zzeupVar2 = zzeupVar;
            zzeupVar2.zzi(arrayList, zzeupVar2.zzd.zza(zzeupVar2.zza, lowerCase));
        } else {
            for (Map.Entry entry : ((zzfxu) zzeupVar.zzd.zzb(zzeupVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                zzeup zzeupVar3 = zzeupVar;
                arrayList.add(zzeupVar3.zzg(str, (List) entry.getValue(), zzeupVar.zzf(str), true, true));
                zzeupVar = zzeupVar3;
            }
            zzeupVar2 = zzeupVar;
            zzeupVar2.zzi(arrayList, zzeupVar2.zzd.zzc());
        }
        return zzgcj.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                JSONArray jSONArray = new JSONArray();
                for (do0 do0Var : arrayList) {
                    if (((JSONObject) do0Var.get()) != null) {
                        jSONArray.put(do0Var.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzeuq(jSONArray.toString(), bundleZzg);
            }
        }, zzeupVar2.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.s;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgca zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgca zzgcaVarZzu = zzgca.zzu(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeum
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return this.zza.zzd(str, list, bundle, z, z2);
            }
        }, this.zzb));
        zzbbn zzbbnVar = zzbbw.zzbp;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzgcaVarZzu = (zzgca) zzgcj.zzo(zzgcaVarZzu, ((Long) n42Var.c.zza(zzbbw.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgca) zzgcj.zze(zzgcaVarZzu, Throwable.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzeun
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                String str2 = str;
                k92.e("Error calling adapter: ".concat(String.valueOf(str2)));
                String strConcat = "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2));
                hd2.B.g.zzw((Throwable) obj, strConcat);
                return null;
            }
        }, this.zzb);
    }

    private final void zzh(zzbql zzbqlVar, Bundle bundle, List list, zzelj zzeljVar) {
        zzbqlVar.zzh(new gy0(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeljVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzelk zzelkVar = (zzelk) ((Map.Entry) it.next()).getValue();
            String str = zzelkVar.zza;
            list.add(zzg(str, Collections.singletonList(zzelkVar.zze), zzf(str), zzelkVar.zzb, zzelkVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzffg zzffgVar = this.zzf;
        if (zzffgVar.zzr) {
            if (!Arrays.asList(((String) n42.d.c.zza(zzbbw.zzbv)).split(",")).contains(wd.M(wd.O(zzffgVar.zzd)))) {
                return zzgcj.zzh(new zzeuq(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeuj
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return zzeup.zzc(this.zza);
            }
        }, this.zzb);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.do0 zzd(java.lang.String r8, final java.util.List r9, final android.os.Bundle r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbzt r3 = new com.google.android.gms.internal.ads.zzbzt
            r3.<init>()
            r0 = 0
            if (r12 == 0) goto L27
            com.google.android.gms.internal.ads.zzbbn r12 = com.google.android.gms.internal.ads.zzbbw.zzbu
            n42 r1 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c
            java.lang.Object r12 = r1.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L27
            com.google.android.gms.internal.ads.zzelc r12 = r7.zzg
            r12.zzb(r8)
            com.google.android.gms.internal.ads.zzelc r12 = r7.zzg
            com.google.android.gms.internal.ads.zzbql r12 = r12.zza(r8)
        L25:
            r2 = r12
            goto L32
        L27:
            com.google.android.gms.internal.ads.zzdqb r12 = r7.zzh     // Catch: android.os.RemoteException -> L2e
            com.google.android.gms.internal.ads.zzbql r12 = r12.zzb(r8)     // Catch: android.os.RemoteException -> L2e
            goto L25
        L2e:
            defpackage.k92.b()
            r2 = r0
        L32:
            if (r2 != 0) goto L4d
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzbk
            n42 r10 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r10 = r10.c
            java.lang.Object r9 = r10.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4c
            com.google.android.gms.internal.ads.zzelj.zzb(r8, r3)
            r1 = r7
            goto Lb6
        L4c:
            throw r0
        L4d:
            com.google.android.gms.internal.ads.zzelj r0 = new com.google.android.gms.internal.ads.zzelj
            hd2 r12 = defpackage.hd2.B
            us r12 = r12.j
            r12.getClass()
            long r4 = android.os.SystemClock.elapsedRealtime()
            r1 = r8
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbbn r8 = com.google.android.gms.internal.ads.zzbbw.zzbp
            n42 r12 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r1 = r12.c
            java.lang.Object r8 = r1.zza(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.google.android.gms.internal.ads.zzbbu r12 = r12.c
            if (r8 == 0) goto L8a
            java.util.concurrent.ScheduledExecutorService r8 = r7.zzc
            com.google.android.gms.internal.ads.zzeuo r1 = new com.google.android.gms.internal.ads.zzeuo
            r1.<init>()
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzbi
            java.lang.Object r4 = r12.zza(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            r8.schedule(r1, r4, r6)
        L8a:
            if (r11 == 0) goto Lb2
            com.google.android.gms.internal.ads.zzbbn r8 = com.google.android.gms.internal.ads.zzbbw.zzbw
            java.lang.Object r8 = r12.zza(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Lab
            com.google.android.gms.internal.ads.zzgcu r8 = r7.zzb
            r5 = r0
            com.google.android.gms.internal.ads.zzeul r0 = new com.google.android.gms.internal.ads.zzeul
            r1 = r7
            r4 = r9
            r6 = r3
            r3 = r10
            r0.<init>()
            r3 = r6
            r8.zza(r0)
            goto Lb6
        Lab:
            r1 = r7
            r4 = r9
            r8 = r10
            r7.zzh(r2, r8, r4, r0)
            goto Lb6
        Lb2:
            r1 = r7
            r0.zzd()
        Lb6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeup.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):do0");
    }

    public final /* synthetic */ void zze(zzbql zzbqlVar, Bundle bundle, List list, zzelj zzeljVar, zzbzt zzbztVar) {
        try {
            zzh(zzbqlVar, bundle, list, zzeljVar);
        } catch (RemoteException e) {
            zzbztVar.zzd(e);
        }
    }
}
