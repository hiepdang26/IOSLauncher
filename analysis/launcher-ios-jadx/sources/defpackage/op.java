package defpackage;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class op implements Parcelable {
    public static final Parcelable.Creator<op> CREATOR = new z1(4);
    public final Uri g;
    public final Uri h;
    public final Exception i;
    public final float[] j;
    public final Rect k;
    public final Rect l;
    public final int m;
    public final int n;

    public op(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
        this.g = uri;
        this.h = uri2;
        this.i = exc;
        this.j = fArr;
        this.k = rect;
        this.l = rect2;
        this.m = i;
        this.n = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.h, i);
        parcel.writeSerializable(this.i);
        parcel.writeFloatArray(this.j);
        parcel.writeParcelable(this.k, i);
        parcel.writeParcelable(this.l, i);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }
}
