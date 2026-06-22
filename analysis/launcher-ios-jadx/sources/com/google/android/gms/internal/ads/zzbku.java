package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzbku implements zzapa {
    private volatile zzbkh zza;
    private final Context zzb;

    public zzbku(Context context) {
        this.zzb = context;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzbku zzbkuVar) {
        if (zzbkuVar.zza == null) {
            return;
        }
        zzbkuVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final zzapd zza(zzaph zzaphVar) throws zzapq {
        Parcelable.Creator<zzbki> creator = zzbki.CREATOR;
        Map mapZzl = zzaphVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbki zzbkiVar = new zzbki(zzaphVar.zzk(), strArr, strArr2);
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            zzbzt zzbztVar = new zzbzt();
            this.zza = new zzbkh(this.zzb, hd2Var.r.a(), new zzbks(this, zzbztVar), new zzbkt(this, zzbztVar));
            this.zza.checkAvailabilityAndConnect();
            zzbkq zzbkqVar = new zzbkq(this, zzbkiVar);
            zzgcu zzgcuVar = zzbzo.zza;
            do0 do0VarZzo = zzgcj.zzo(zzgcj.zzn(zzbztVar, zzbkqVar, zzgcuVar), ((Integer) n42.d.c.zza(zzbbw.zzdY)).intValue(), TimeUnit.MILLISECONDS, zzbzo.zzd);
            do0VarZzo.addListener(new zzbkr(this), zzgcuVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) do0VarZzo.get();
            hd2Var.j.getClass();
            k92.a("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbkk zzbkkVar = (zzbkk) new zzbuz(parcelFileDescriptor).zza(zzbkk.CREATOR);
            if (zzbkkVar != null) {
                if (zzbkkVar.zza) {
                    throw new zzapq(zzbkkVar.zzb);
                }
                if (zzbkkVar.zze.length == zzbkkVar.zzf.length) {
                    HashMap map = new HashMap();
                    while (true) {
                        String[] strArr3 = zzbkkVar.zze;
                        if (i >= strArr3.length) {
                            return new zzapd(zzbkkVar.zzc, zzbkkVar.zzd, map, zzbkkVar.zzg, zzbkkVar.zzh);
                        }
                        map.put(strArr3[i], zzbkkVar.zzf[i]);
                        i++;
                    }
                }
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            hd2.B.j.getClass();
            k92.a("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            hd2.B.j.getClass();
            k92.a("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th;
        }
    }
}
