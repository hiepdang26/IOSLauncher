package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.hd2;
import defpackage.n42;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbcl {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbcl(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzbci zzf() {
        hd2.B.j.getClass();
        return new zzbci(SystemClock.elapsedRealtime(), null, null);
    }

    public final zzbck zza() {
        zzbck zzbckVar;
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.zzc) {
            try {
                for (zzbci zzbciVar : this.zza) {
                    long jZza = zzbciVar.zza();
                    String strZzc = zzbciVar.zzc();
                    zzbci zzbciVarZzb = zzbciVar.zzb();
                    if (zzbciVarZzb != null && jZza > 0) {
                        long jZza2 = jZza - zzbciVarZzb.zza();
                        sb.append(strZzc);
                        sb.append('.');
                        sb.append(jZza2);
                        sb.append(',');
                        if (zBooleanValue) {
                            if (map.containsKey(Long.valueOf(zzbciVarZzb.zza()))) {
                                StringBuilder sb2 = (StringBuilder) map.get(Long.valueOf(zzbciVarZzb.zza()));
                                sb2.append('+');
                                sb2.append(strZzc);
                            } else {
                                map.put(Long.valueOf(zzbciVarZzb.zza()), new StringBuilder(strZzc));
                            }
                        }
                    }
                }
                this.zza.clear();
                String string = null;
                if (!TextUtils.isEmpty(null)) {
                    sb.append((String) null);
                } else if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                StringBuilder sb3 = new StringBuilder();
                if (zBooleanValue) {
                    for (Map.Entry entry : map.entrySet()) {
                        sb3.append((CharSequence) entry.getValue());
                        sb3.append('.');
                        long jLongValue = ((Long) entry.getKey()).longValue();
                        hd2 hd2Var = hd2.B;
                        hd2Var.j.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        hd2Var.j.getClass();
                        sb3.append(jCurrentTimeMillis + (jLongValue - SystemClock.elapsedRealtime()));
                        sb3.append(',');
                    }
                    if (sb3.length() > 0) {
                        sb3.setLength(sb3.length() - 1);
                    }
                    string = sb3.toString();
                }
                zzbckVar = new zzbck(sb.toString(), string);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbckVar;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            hd2.B.g.zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbcl zzbclVar) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbcb zzbcbVarZzg;
        if (TextUtils.isEmpty(str2) || (zzbcbVarZzg = hd2.B.g.zzg()) == null) {
            return;
        }
        synchronized (this.zzc) {
            zzbch zzbchVarZza = zzbcbVarZzg.zza(str);
            Map map = this.zzb;
            map.put(str, zzbchVarZza.zza((String) map.get(str), str2));
        }
    }

    public final boolean zze(zzbci zzbciVar, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbci(j, strArr[0], zzbciVar));
        }
        return true;
    }
}
