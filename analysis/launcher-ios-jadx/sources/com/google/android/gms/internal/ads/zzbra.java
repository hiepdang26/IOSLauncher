package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.nr1;
import defpackage.os;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbra extends b0 {
    public static final Parcelable.Creator<zzbra> CREATOR = new zzbrb();
    public final int zza;
    public final int zzb;
    public final int zzc;

    public zzbra(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzbra zza(nr1 nr1Var) {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbra)) {
            zzbra zzbraVar = (zzbra) obj;
            if (zzbraVar.zzc == this.zzc && zzbraVar.zzb == this.zzb && zzbraVar.zza == this.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        return this.zza + "." + this.zzb + "." + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        os.G(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.zzc;
        os.G(parcel, 3, 4);
        parcel.writeInt(i4);
        os.F(iE, parcel);
    }
}
