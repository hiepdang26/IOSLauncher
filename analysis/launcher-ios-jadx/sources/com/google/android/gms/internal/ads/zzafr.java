package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzafr extends zzagd {
    public static final Parcelable.Creator<zzafr> CREATOR = new zzafq();
    public final byte[] zza;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzafr(Parcel parcel) {
        String string = parcel.readString();
        int i = zzet.zza;
        super(string);
        this.zza = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafr.class == obj.getClass()) {
            zzafr zzafrVar = (zzafr) obj;
            if (this.zzf.equals(zzafrVar.zzf) && Arrays.equals(this.zza, zzafrVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        return Arrays.hashCode(this.zza) + (iHashCode * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzafr(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
