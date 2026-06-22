package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbnc implements zzblu, zzbnb {
    private final zzbnb zza;
    private final HashSet zzb = new HashSet();

    public zzbnc(zzbnb zzbnbVar) {
        this.zza = zzbnbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblu, com.google.android.gms.internal.ads.zzbme
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzblu, com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzb(String str, String str2) {
        zzblt.zzc(this, str, str2);
    }

    public final void zzc() {
        for (AbstractMap.SimpleEntry simpleEntry : this.zzb) {
            k92.a("Unregistering eventhandler: ".concat(String.valueOf(((zzbix) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbix) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zzd(String str, Map map) {
        zzblt.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzblu, com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzblt.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzblt.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzq(String str, zzbix zzbixVar) {
        this.zza.zzq(str, zzbixVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbixVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzr(String str, zzbix zzbixVar) {
        this.zza.zzr(str, zzbixVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbixVar));
    }
}
