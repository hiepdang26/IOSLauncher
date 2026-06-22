package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.z1;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new z1(29);
    public final int g;
    public final float h;

    public RatingCompat(int i, float f) {
        this.g = i;
        this.h = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.g);
        sb.append(" rating=");
        float f = this.h;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeFloat(this.h);
    }
}
