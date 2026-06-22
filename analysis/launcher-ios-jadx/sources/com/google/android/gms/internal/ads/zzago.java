package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzago extends zzagd {
    public static final Parcelable.Creator<zzago> CREATOR = new zzagn();
    public final String zza;
    public final String zzb;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzago(Parcel parcel) {
        String string = parcel.readString();
        int i = zzet.zza;
        super(string);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzago.class == obj.getClass()) {
            zzago zzagoVar = (zzago) obj;
            if (this.zzf.equals(zzagoVar.zzf) && zzet.zzG(this.zza, zzagoVar.zza) && zzet.zzG(this.zzb, zzagoVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        int iHashCode2 = str != null ? str.hashCode() : 0;
        int i = iHashCode * 31;
        String str2 = this.zzb;
        return ((i + iHashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final String toString() {
        return this.zzf + ": url=" + this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzago(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}
