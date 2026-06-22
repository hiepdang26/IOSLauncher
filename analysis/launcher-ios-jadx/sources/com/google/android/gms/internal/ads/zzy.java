package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzy implements Comparator<zzx>, Parcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzv();
    public final String zza;
    public final int zzb;
    private final zzx[] zzc;
    private int zzd;

    public zzy(Parcel parcel) {
        this.zza = parcel.readString();
        zzx[] zzxVarArr = (zzx[]) parcel.createTypedArray(zzx.CREATOR);
        int i = zzet.zza;
        this.zzc = zzxVarArr;
        this.zzb = zzxVarArr.length;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzx zzxVar, zzx zzxVar2) {
        zzx zzxVar3 = zzxVar;
        zzx zzxVar4 = zzxVar2;
        UUID uuid = zzk.zza;
        return uuid.equals(zzxVar3.zza) ? !uuid.equals(zzxVar4.zza) ? 1 : 0 : zzxVar3.zza.compareTo(zzxVar4.zza);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzy.class == obj.getClass()) {
            zzy zzyVar = (zzy) obj;
            if (zzet.zzG(this.zza, zzyVar.zza) && Arrays.equals(this.zzc, zzyVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int iHashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.zzc);
        this.zzd = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzc, 0);
    }

    public final zzx zza(int i) {
        return this.zzc[i];
    }

    public final zzy zzb(String str) {
        return zzet.zzG(this.zza, str) ? this : new zzy(str, false, this.zzc);
    }

    private zzy(String str, boolean z, zzx... zzxVarArr) {
        this.zza = str;
        zzxVarArr = z ? (zzx[]) zzxVarArr.clone() : zzxVarArr;
        this.zzc = zzxVarArr;
        this.zzb = zzxVarArr.length;
        Arrays.sort(zzxVarArr, this);
    }

    public zzy(String str, zzx... zzxVarArr) {
        this(null, true, zzxVarArr);
    }

    public zzy(List list) {
        this(null, false, (zzx[]) list.toArray(new zzx[0]));
    }
}
