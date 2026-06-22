package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpm extends b0 {
    public static final Parcelable.Creator<zzfpm> CREATOR = new zzfpn();
    public final int zza;
    public final byte[] zzb;

    public zzfpm(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        os.w(parcel, 2, this.zzb);
        os.F(iE, parcel);
    }

    public zzfpm(byte[] bArr) {
        this(1, bArr);
    }
}
