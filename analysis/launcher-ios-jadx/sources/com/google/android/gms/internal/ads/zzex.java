package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzex implements zzbj {
    public static final Parcelable.Creator<zzex> CREATOR = new zzev();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzex(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzex.class == obj.getClass()) {
            zzex zzexVar = (zzex) obj;
            if (this.zza.equals(zzexVar.zza) && Arrays.equals(this.zzb, zzexVar.zzb) && this.zzc == zzexVar.zzc && this.zzd == zzexVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        return ((((Arrays.hashCode(this.zzb) + (iHashCode * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String strZzA;
        int i = this.zzd;
        if (i == 1) {
            strZzA = zzet.zzA(this.zzb);
        } else if (i == 23) {
            strZzA = String.valueOf(Float.intBitsToFloat(zzgap.zzd(this.zzb)));
        } else if (i != 67) {
            byte[] bArr = this.zzb;
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(length + length);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                sb.append(Character.forDigit(bArr[i2] & 15, 16));
            }
            strZzA = sb.toString();
        } else {
            strZzA = String.valueOf(zzgap.zzd(this.zzb));
        }
        return "mdta: key=" + this.zza + ", value=" + strZzA;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public final /* synthetic */ void zza(zzbf zzbfVar) {
    }

    public /* synthetic */ zzex(Parcel parcel, zzew zzewVar) {
        String string = parcel.readString();
        int i = zzet.zza;
        this.zza = string;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }
}
