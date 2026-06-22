package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class zzagl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String string = parcel.readString();
        string.getClass();
        String string2 = parcel.readString();
        String[] strArrCreateStringArray = parcel.createStringArray();
        strArrCreateStringArray.getClass();
        return new zzagm(string, string2, zzfxr.zzl(strArrCreateStringArray));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagm[i];
    }
}
