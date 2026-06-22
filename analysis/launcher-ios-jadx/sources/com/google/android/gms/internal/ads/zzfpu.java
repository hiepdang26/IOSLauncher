package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfpu implements zzfok {
    private final Object zza;
    private final zzfpv zzb;
    private final zzfqg zzc;
    private final zzfoh zzd;

    public zzfpu(Object obj, zzfpv zzfpvVar, zzfqg zzfqgVar, zzfoh zzfohVar) {
        this.zza = obj;
        this.zzb = zzfpvVar;
        this.zzc = zzfqgVar;
        this.zzd = zzfohVar;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzasv zzasvVarZza = zzasw.zza();
        zzasvVarZza.zzc(5);
        zzasvVarZza.zza(zzgwm.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzasw) zzasvVarZza.zzbr()).zzaV(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put("f", "c");
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put("aid", null);
        mapZza.put("view", view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put("ctx", context);
        mapZzc.put("aid", null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", "q");
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final synchronized void zzd(String str, MotionEvent motionEvent) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("t", new Throwable());
            map.put("aid", null);
            map.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", Map.class).invoke(this.zza, map);
            this.zzd.zzd(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfqe(2005, e);
        }
    }

    public final synchronized int zze() {
        try {
        } catch (Exception e) {
            throw new zzfqe(2006, e);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", null).invoke(this.zza, null)).intValue();
    }

    public final zzfpv zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", null).invoke(this.zza, null);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfqe(2003, e);
        }
    }

    public final synchronized boolean zzh() {
        try {
        } catch (Exception e) {
            throw new zzfqe(2001, e);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", null).invoke(this.zza, null)).booleanValue();
    }
}
