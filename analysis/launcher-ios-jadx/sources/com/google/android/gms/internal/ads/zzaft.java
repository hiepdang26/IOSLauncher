package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzaft extends zzagd {
    public static final Parcelable.Creator<zzaft> CREATOR = new zzafs();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzagd[] zzg;

    public zzaft(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i = zzet.zza;
        this.zza = string;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int i2 = parcel.readInt();
        this.zzg = new zzagd[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.zzg[i3] = (zzagd) parcel.readParcelable(zzagd.class.getClassLoader());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagd, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaft.class == obj.getClass()) {
            zzaft zzaftVar = (zzaft) obj;
            if (this.zzb == zzaftVar.zzb && this.zzc == zzaftVar.zzc && this.zzd == zzaftVar.zzd && this.zze == zzaftVar.zze && zzet.zzG(this.zza, zzaftVar.zza) && Arrays.equals(this.zzg, zzaftVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return ((((((((this.zzb + 527) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzagd zzagdVar : this.zzg) {
            parcel.writeParcelable(zzagdVar, 0);
        }
    }

    public zzaft(String str, int i, int i2, long j, long j2, zzagd[] zzagdVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzagdVarArr;
    }
}
