package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.rc2;
import defpackage.tb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyq extends b0 {
    public static final Parcelable.Creator<zzbyq> CREATOR = new zzbyr();
    public final String zza;
    public final String zzb;

    @Deprecated
    public final rc2 zzc;
    public final tb2 zzd;

    public zzbyq(String str, String str2, rc2 rc2Var, tb2 tb2Var) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = rc2Var;
        this.zzd = tb2Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        os.z(parcel, 2, this.zzb);
        os.y(parcel, 3, this.zzc, i);
        os.y(parcel, 4, this.zzd, i);
        os.F(iE, parcel);
    }
}
