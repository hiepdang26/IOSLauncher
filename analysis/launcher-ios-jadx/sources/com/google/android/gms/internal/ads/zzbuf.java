package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        ArrayList arrayListN = null;
        boolean z = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                z = wd.z(i, parcel);
            } else if (c != 3) {
                wd.H(i, parcel);
            } else {
                arrayListN = wd.n(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbue(z, arrayListN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbue[i];
    }
}
