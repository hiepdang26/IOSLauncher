package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public final class zzaoz {
    private final String zza;
    private final String zzb;

    public zzaoz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaoz.class == obj.getClass()) {
            zzaoz zzaozVar = (zzaoz) obj;
            if (TextUtils.equals(this.zza, zzaozVar.zza) && TextUtils.equals(this.zzb, zzaozVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.zza);
        sb.append(",value=");
        return uo.k(sb, this.zzb, "]");
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
