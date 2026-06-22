package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzafj implements zzbj {
    public static final Parcelable.Creator<zzafj> CREATOR = new zzafi();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzafj(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzafj zzb(zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        String strZze = zzbn.zze(zzekVar.zzA(zzekVar.zzg(), zzfuj.zza));
        String strZzA = zzekVar.zzA(zzekVar.zzg(), zzfuj.zzc);
        int iZzg2 = zzekVar.zzg();
        int iZzg3 = zzekVar.zzg();
        int iZzg4 = zzekVar.zzg();
        int iZzg5 = zzekVar.zzg();
        int iZzg6 = zzekVar.zzg();
        byte[] bArr = new byte[iZzg6];
        zzekVar.zzG(bArr, 0, iZzg6);
        return new zzafj(iZzg, strZze, strZzA, iZzg2, iZzg3, iZzg4, iZzg5, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafj.class == obj.getClass()) {
            zzafj zzafjVar = (zzafj) obj;
            if (this.zza == zzafjVar.zza && this.zzb.equals(zzafjVar.zzb) && this.zzc.equals(zzafjVar.zzc) && this.zzd == zzafjVar.zzd && this.zze == zzafjVar.zze && this.zzf == zzafjVar.zzf && this.zzg == zzafjVar.zzg && Arrays.equals(this.zzh, zzafjVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza + 527;
        int iHashCode = this.zzb.hashCode() + (i * 31);
        int iHashCode2 = this.zzc.hashCode() + (iHashCode * 31);
        byte[] bArr = this.zzh;
        return Arrays.hashCode(bArr) + (((((((((iHashCode2 * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public final void zza(zzbf zzbfVar) {
        zzbfVar.zza(this.zzh, this.zza);
    }

    public zzafj(Parcel parcel) {
        this.zza = parcel.readInt();
        String string = parcel.readString();
        int i = zzet.zza;
        this.zzb = string;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }
}
