package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ti1 implements Parcelable {
    public static final Parcelable.Creator<ti1> CREATOR = new zb1(3);
    public int g;
    public int h;
    public int i;
    public int[] j;
    public int k;
    public int[] l;
    public ArrayList m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        if (this.i > 0) {
            parcel.writeIntArray(this.j);
        }
        parcel.writeInt(this.k);
        if (this.k > 0) {
            parcel.writeIntArray(this.l);
        }
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeList(this.m);
    }
}
