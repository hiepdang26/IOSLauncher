package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.tb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvu extends b0 {
    public static final Parcelable.Creator<zzbvu> CREATOR = new zzbvv();
    public final tb2 zza;
    public final String zzb;

    public zzbvu(tb2 tb2Var, String str) {
        this.zza = tb2Var;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        tb2 tb2Var = this.zza;
        int iE = os.E(20293, parcel);
        os.y(parcel, 2, tb2Var, i);
        os.z(parcel, 3, this.zzb);
        os.F(iE, parcel);
    }
}
