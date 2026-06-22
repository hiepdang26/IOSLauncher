package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzagr implements zzbj {
    public static final Parcelable.Creator<zzagr> CREATOR = new zzagp();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzagr(long j, long j2, long j3, long j4, long j5) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagr.class == obj.getClass()) {
            zzagr zzagrVar = (zzagr) obj;
            if (this.zza == zzagrVar.zza && this.zzb == zzagrVar.zzb && this.zzc == zzagrVar.zzc && this.zzd == zzagrVar.zzd && this.zze == zzagrVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.zze;
        long j3 = this.zzd;
        long j4 = this.zzc;
        long j5 = this.zzb;
        return ((((((((i + 527) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.zza + ", photoSize=" + this.zzb + ", photoPresentationTimestampUs=" + this.zzc + ", videoStartPosition=" + this.zzd + ", videoSize=" + this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public final /* synthetic */ void zza(zzbf zzbfVar) {
    }

    public /* synthetic */ zzagr(Parcel parcel, zzagq zzagqVar) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }
}
