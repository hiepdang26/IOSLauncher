package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzbyf {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbxq zzd;

    public zzbyf(Context context, zzbxq zzbxqVar) {
        this.zzc = context;
        this.zzd = zzbxqVar;
    }

    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzd();
        }
    }

    public final synchronized void zzc(String str) {
        try {
            if (this.zza.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
            zzbye zzbyeVar = new zzbye(this, str);
            this.zza.put(str, zzbyeVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbyeVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(zzbyd zzbydVar) {
        this.zzb.add(zzbydVar);
    }
}
