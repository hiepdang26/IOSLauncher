package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbue extends b0 {
    public static final Parcelable.Creator<zzbue> CREATOR = new zzbuf();
    public final boolean zza;
    public final List zzb;

    public zzbue(boolean z, List list) {
        this.zza = z;
        this.zzb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        os.B(parcel, 3, this.zzb);
        os.F(iE, parcel);
    }

    public zzbue() {
        this(false, Collections.EMPTY_LIST);
    }
}
