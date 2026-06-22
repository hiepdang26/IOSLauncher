package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzfd implements zzbj {
    public static final Parcelable.Creator<zzfd> CREATOR = new zzfb();
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzfd(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfd)) {
            return false;
        }
        zzfd zzfdVar = (zzfd) obj;
        return this.zza == zzfdVar.zza && this.zzb == zzfdVar.zzb && this.zzc == zzfdVar.zzc;
    }

    public final int hashCode() {
        long j = this.zza;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.zzc;
        long j3 = this.zzb;
        return ((((i + 527) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public final /* synthetic */ void zza(zzbf zzbfVar) {
    }

    public /* synthetic */ zzfd(Parcel parcel, zzfc zzfcVar) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
    }
}
