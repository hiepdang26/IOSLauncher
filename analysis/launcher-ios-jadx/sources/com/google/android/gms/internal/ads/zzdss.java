package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import defpackage.fq;
import defpackage.k92;
import defpackage.n42;
import defpackage.qg0;
import defpackage.tc2;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class zzdss {
    protected final Map zza;
    protected final Context zzb;
    protected final Executor zzc;
    protected final tc2 zzd;
    protected final boolean zze;
    private final fq zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final AtomicBoolean zzi;
    private final AtomicReference zzj;

    public zzdss(Executor executor, tc2 tc2Var, fq fqVar, Context context) {
        this.zza = new HashMap();
        this.zzi = new AtomicBoolean();
        this.zzj = new AtomicReference(new Bundle());
        this.zzc = executor;
        this.zzd = tc2Var;
        zzbbn zzbbnVar = zzbbw.zzbN;
        n42 n42Var = n42.d;
        this.zze = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
        this.zzf = fqVar;
        this.zzg = ((Boolean) n42Var.c.zza(zzbbw.zzbQ)).booleanValue();
        this.zzh = ((Boolean) n42Var.c.zza(zzbbw.zzgp)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map, boolean z) {
        Bundle bundleT;
        if (map.isEmpty()) {
            k92.d("Empty paramMap.");
            return;
        }
        if (map.isEmpty()) {
            k92.d("Empty or null paramMap.");
        } else {
            if (!this.zzi.getAndSet(true)) {
                final String str = (String) n42.d.c.zza(zzbbw.zzjF);
                Context context = this.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.ads.zzdsr
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                        this.zza.zzd(str, sharedPreferences, str2);
                    }
                };
                if (TextUtils.isEmpty(str)) {
                    bundleT = Bundle.EMPTY;
                } else {
                    PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    bundleT = qg0.T(context, str);
                }
                this.zzj.set(bundleT);
            }
            Bundle bundle = (Bundle) this.zzj.get();
            for (String str2 : bundle.keySet()) {
                map.put(str2, String.valueOf(bundle.get(str2)));
            }
        }
        final String strA = this.zzf.a(map);
        k92.a(strA);
        boolean z2 = Boolean.parseBoolean((String) map.get("scar"));
        if (this.zze) {
            if (!z || this.zzg) {
                if (!z2 || this.zzh) {
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd.zza(strA);
                        }
                    });
                }
            }
        }
    }

    public final String zzb(Map map) {
        return this.zzf.a(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zza);
    }

    public final /* synthetic */ void zzd(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzj.set(qg0.T(this.zzb, str));
    }

    public final void zze(Map map) {
        zza(map, true);
    }

    public final void zzf(Map map) {
        zza(map, false);
    }
}
