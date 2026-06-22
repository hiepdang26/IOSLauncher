package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzagu implements Parcelable {
    public static final Parcelable.Creator<zzagu> CREATOR = new zzagt();
    public final long zza;
    public final long zzb;
    public final int zzc;

    public zzagu(long j, long j2, int i) {
        zzdi.zzd(j < j2);
        this.zza = j;
        this.zzb = j2;
        this.zzc = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagu.class == obj.getClass()) {
            zzagu zzaguVar = (zzagu) obj;
            if (this.zza == zzaguVar.zza && this.zzb == zzaguVar.zzb && this.zzc == zzaguVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        long j = this.zza;
        long j2 = this.zzb;
        int i = this.zzc;
        Locale locale = Locale.US;
        return "Segment: startTimeMs=" + j + ", endTimeMs=" + j2 + ", speedDivisor=" + i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeInt(this.zzc);
    }
}
