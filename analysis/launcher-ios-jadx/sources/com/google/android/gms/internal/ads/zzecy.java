package com.google.android.gms.internal.ads;

import android.app.Activity;
import defpackage.uo;
import defpackage.yb2;

/* JADX INFO: loaded from: classes.dex */
final class zzecy extends zzedu {
    private final Activity zza;
    private final yb2 zzb;
    private final String zzc;
    private final String zzd;

    public /* synthetic */ zzecy(Activity activity, yb2 yb2Var, String str, String str2, zzecx zzecxVar) {
        this.zza = activity;
        this.zzb = yb2Var;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        yb2 yb2Var;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzedu) {
            zzedu zzeduVar = (zzedu) obj;
            if (this.zza.equals(zzeduVar.zza()) && ((yb2Var = this.zzb) != null ? yb2Var.equals(zzeduVar.zzb()) : zzeduVar.zzb() == null) && ((str = this.zzc) != null ? str.equals(zzeduVar.zzc()) : zzeduVar.zzc() == null) && ((str2 = this.zzd) != null ? str2.equals(zzeduVar.zzd()) : zzeduVar.zzd() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        yb2 yb2Var = this.zzb;
        int iHashCode2 = ((iHashCode * 1000003) ^ (yb2Var == null ? 0 : yb2Var.hashCode())) * 1000003;
        String str = this.zzc;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzd;
        return iHashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        yb2 yb2Var = this.zzb;
        String string = this.zza.toString();
        String strValueOf = String.valueOf(yb2Var);
        StringBuilder sb = new StringBuilder("OfflineUtilsParams{activity=");
        sb.append(string);
        sb.append(", adOverlay=");
        sb.append(strValueOf);
        sb.append(", gwsQueryId=");
        sb.append(this.zzc);
        sb.append(", uri=");
        return uo.k(sb, this.zzd, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    public final Activity zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    public final yb2 zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzedu
    public final String zzd() {
        return this.zzd;
    }
}
