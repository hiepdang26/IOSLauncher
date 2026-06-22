package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzagk extends zzagd {
    public static final Parcelable.Creator<zzagk> CREATOR = new zzagj();
    public final String zza;
    public final byte[] zzb;

    public zzagk(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        int i = zzet.zza;
        this.zza = string;
        this.zzb = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagk.class == obj.getClass()) {
            zzagk zzagkVar = (zzagk) obj;
            if (zzet.zzG(this.zza, zzagkVar.zza) && Arrays.equals(this.zzb, zzagkVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return Arrays.hashCode(this.zzb) + (((str != null ? str.hashCode() : 0) + 527) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final String toString() {
        return this.zzf + ": owner=" + this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzagk(String str, byte[] bArr) {
        super("PRIV");
        this.zza = str;
        this.zzb = bArr;
    }
}
