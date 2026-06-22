package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqa extends b0 {
    public static final Parcelable.Creator<zzfqa> CREATOR = new zzfqb();
    public final int zza;
    public final byte[] zzb;
    public final int zzc;

    public zzfqa(int i, byte[] bArr, int i2) {
        this.zza = i;
        this.zzb = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.zzc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        os.w(parcel, 2, this.zzb);
        int i3 = this.zzc;
        os.G(parcel, 3, 4);
        parcel.writeInt(i3);
        os.F(iE, parcel);
    }

    public zzfqa(byte[] bArr, int i) {
        this(1, null, 1);
    }
}
