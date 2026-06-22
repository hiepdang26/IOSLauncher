package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class on0 implements Parcelable {
    public static final Parcelable.Creator<on0> CREATOR = new z1(12);
    public int g;
    public int h;
    public boolean i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i ? 1 : 0);
    }
}
