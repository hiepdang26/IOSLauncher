package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ls implements Parcelable {
    public static final Parcelable.Creator<ls> CREATOR = new z1(6);
    public final long g;

    public ls(long j) {
        this.g = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ls) && this.g == ((ls) obj).g;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.g)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.g);
    }
}
