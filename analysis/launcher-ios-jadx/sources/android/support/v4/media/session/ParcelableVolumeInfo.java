package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.z1;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new z1(25);
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.h);
    }
}
