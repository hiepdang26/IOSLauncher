package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzagi extends zzagd {
    public static final Parcelable.Creator<zzagi> CREATOR = new zzagh();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzagi(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzagd, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagi.class == obj.getClass()) {
            zzagi zzagiVar = (zzagi) obj;
            if (this.zza == zzagiVar.zza && this.zzb == zzagiVar.zzb && this.zzc == zzagiVar.zzc && Arrays.equals(this.zzd, zzagiVar.zzd) && Arrays.equals(this.zze, zzagiVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza + 527;
        int[] iArr = this.zzd;
        int iHashCode = Arrays.hashCode(iArr) + (((((i * 31) + this.zzb) * 31) + this.zzc) * 31);
        return Arrays.hashCode(this.zze) + (iHashCode * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    public zzagi(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        int[] iArrCreateIntArray = parcel.createIntArray();
        int i = zzet.zza;
        this.zzd = iArrCreateIntArray;
        this.zze = parcel.createIntArray();
    }
}
