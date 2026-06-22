package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsj {
    final /* synthetic */ zzdsk zza;
    private final Map zzb = new ConcurrentHashMap();

    public zzdsj(zzdsk zzdskVar) {
        this.zza = zzdskVar;
    }

    public static /* bridge */ /* synthetic */ zzdsj zza(zzdsj zzdsjVar) {
        zzdsjVar.zzb.putAll(zzdsjVar.zza.zzc);
        return zzdsjVar;
    }

    public final zzdsj zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsj zzc(zzfel zzfelVar) {
        zzb("aai", zzfelVar.zzw);
        zzb("request_id", zzfelVar.zzan);
        zzb("ad_format", zzfel.zza(zzfelVar.zzb));
        return this;
    }

    public final zzdsj zzd(zzfeo zzfeoVar) {
        zzb("gqi", zzfeoVar.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh();
            }
        });
    }

    public final void zzg() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsi
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi();
            }
        });
    }

    public final /* synthetic */ void zzh() {
        this.zza.zza.zzf(this.zzb);
    }

    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }
}
