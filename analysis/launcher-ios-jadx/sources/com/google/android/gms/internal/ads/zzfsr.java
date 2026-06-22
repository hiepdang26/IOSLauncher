package com.google.android.gms.internal.ads;

import android.os.IBinder;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfsr extends zzftk {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    public /* synthetic */ zzfsr(IBinder iBinder, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfsq zzfsqVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftk) {
            zzftk zzftkVar = (zzftk) obj;
            if (this.zza.equals(zzftkVar.zzf()) && ((str = this.zzb) != null ? str.equals(zzftkVar.zzh()) : zzftkVar.zzh() == null) && this.zzc == zzftkVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzftkVar.zza())) {
                zzftkVar.zzb();
                zzftkVar.zzd();
                zzftkVar.zzj();
                if (this.zze == zzftkVar.zze()) {
                    zzftkVar.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzftkVar.zzg()) : zzftkVar.zzg() == null) {
                        zzftkVar.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int iHashCode2 = (((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i = this.zze;
        String str2 = this.zzf;
        return ((((iHashCode2 * 1525764945) ^ i) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        StringBuilder sbO = uo.o("OverlayDisplayShowRequest{windowToken=", this.zza.toString(), ", appId=");
        sbO.append(this.zzb);
        sbO.append(", layoutGravity=");
        sbO.append(this.zzc);
        sbO.append(", layoutVerticalMargin=");
        sbO.append(this.zzd);
        sbO.append(", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=");
        sbO.append(this.zze);
        sbO.append(", deeplinkUrl=null, adFieldEnifd=");
        return uo.k(sbO, this.zzf, ", thirdPartyAuthCallerId=null}");
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final int zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final IBinder zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final String zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final String zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final String zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzftk
    public final String zzk() {
        return null;
    }
}
