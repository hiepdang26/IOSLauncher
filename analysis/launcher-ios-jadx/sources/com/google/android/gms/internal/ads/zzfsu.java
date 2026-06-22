package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfsu extends zzftm {
    private final int zza;
    private final String zzb;

    public /* synthetic */ zzfsu(int i, String str, zzfst zzfstVar) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftm) {
            zzftm zzftmVar = (zzftm) obj;
            if (this.zza == zzftmVar.zza() && ((str = this.zzb) != null ? str.equals(zzftmVar.zzb()) : zzftmVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverlayDisplayState{statusCode=");
        sb.append(this.zza);
        sb.append(", sessionToken=");
        return uo.k(sb, this.zzb, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final String zzb() {
        return this.zzb;
    }
}
