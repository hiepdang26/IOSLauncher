package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
final class zzecv extends zzecz {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    public zzecv(String str, String str2, Drawable drawable) {
        if (str == null) {
            throw new NullPointerException("Null advertiserName");
        }
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzecz) {
            zzecz zzeczVar = (zzecz) obj;
            if (this.zza.equals(zzeczVar.zzb()) && this.zzb.equals(zzeczVar.zzc()) && ((drawable = this.zzc) != null ? drawable.equals(zzeczVar.zza()) : zzeczVar.zza() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (iHashCode * 1000003) ^ (drawable == null ? 0 : drawable.hashCode());
    }

    public final String toString() {
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + ", icon=" + String.valueOf(this.zzc) + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzecz
    public final Drawable zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzecz
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzecz
    public final String zzc() {
        return this.zzb;
    }
}
