package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzblf extends b0 {
    public static final Parcelable.Creator<zzblf> CREATOR = new zzblg();
    public final String zza;
    public final Bundle zzb;

    public zzblf(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        os.v(parcel, 2, this.zzb);
        os.F(iE, parcel);
    }
}
