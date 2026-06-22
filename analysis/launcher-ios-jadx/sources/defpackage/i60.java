package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i60 implements Parcelable {
    public static final Parcelable.Creator<i60> CREATOR = new z1(9);
    public ArrayList g;
    public ArrayList h;
    public da[] i;
    public int j;
    public String k;
    public ArrayList l;
    public ArrayList m;
    public ArrayList n;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.g);
        parcel.writeStringList(this.h);
        parcel.writeTypedArray(this.i, i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeStringList(this.l);
        parcel.writeTypedList(this.m);
        parcel.writeTypedList(this.n);
    }
}
