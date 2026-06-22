package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zznz {
    public final String zza;
    private final zzny zzb;
    private final Object zzc;

    static {
        if (zzet.zza < 31) {
            new zznz("");
        } else {
            int i = zzny.zzb;
        }
    }

    public zznz(LogSessionId logSessionId, String str) {
        this.zzb = new zzny(logSessionId);
        this.zza = str;
        this.zzc = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznz)) {
            return false;
        }
        zznz zznzVar = (zznz) obj;
        return Objects.equals(this.zza, zznzVar.zza) && Objects.equals(this.zzb, zznzVar.zzb) && Objects.equals(this.zzc, zznzVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    public final LogSessionId zza() {
        zzny zznyVar = this.zzb;
        zznyVar.getClass();
        return zznyVar.zza;
    }

    public zznz(String str) {
        zzdi.zzf(zzet.zza < 31);
        this.zza = str;
        this.zzb = null;
        this.zzc = new Object();
    }
}
