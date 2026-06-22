package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfsx extends zzftp {
    private final String zza;
    private final String zzb;

    public /* synthetic */ zzfsx(String str, String str2, zzfsw zzfswVar) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftp) {
            zzftp zzftpVar = (zzftp) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzftpVar.zzb()) : zzftpVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzftpVar.zza()) : zzftpVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverlayDisplayUpdateRequest{sessionToken=");
        sb.append(this.zza);
        sb.append(", appId=");
        return uo.k(sb, this.zzb, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzftp
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzftp
    public final String zzb() {
        return this.zza;
    }
}
