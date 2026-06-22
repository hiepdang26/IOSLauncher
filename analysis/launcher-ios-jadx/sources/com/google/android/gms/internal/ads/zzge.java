package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzge extends zzfxh {
    private final Map zza;

    public zzge(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final boolean containsValue(Object obj) {
        return zzd(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final Set entrySet() {
        return zzfzt.zzc(this.zza.entrySet(), new zzfuv() { // from class: com.google.android.gms.internal.ads.zzgc
            @Override // com.google.android.gms.internal.ads.zzfuv
            public final boolean zza(Object obj) {
                return ((Map.Entry) obj).getKey() != null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && zze(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final /* synthetic */ Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.zza.get(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final int hashCode() {
        return zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final boolean isEmpty() {
        if (this.zza.isEmpty()) {
            return true;
        }
        return super.size() == 1 && super.containsKey(null);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final Set keySet() {
        return zzfzt.zzc(this.zza.keySet(), new zzfuv() { // from class: com.google.android.gms.internal.ads.zzgd
            @Override // com.google.android.gms.internal.ads.zzfuv
            public final boolean zza(Object obj) {
                return ((String) obj) != null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, java.util.Map
    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh, com.google.android.gms.internal.ads.zzfxi
    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxh
    public final Map zzb() {
        return this.zza;
    }
}
