package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import defpackage.b0;
import defpackage.gy0;
import defpackage.os;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtl extends b0 {
    public static final Parcelable.Creator<zzbtl> CREATOR = new zzbtm();
    public final View zza;
    public final Map zzb;

    public zzbtl(IBinder iBinder, IBinder iBinder2) {
        this.zza = (View) gy0.r(gy0.q(iBinder));
        this.zzb = (Map) gy0.r(gy0.q(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        View view = this.zza;
        int iE = os.E(20293, parcel);
        os.x(parcel, 1, new gy0(view));
        os.x(parcel, 2, new gy0(this.zzb));
        os.F(iE, parcel);
    }
}
