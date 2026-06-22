package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class si1 implements Parcelable {
    public static final Parcelable.Creator<si1> CREATOR = new zb1(2);
    public int g;
    public int h;
    public int[] i;
    public boolean j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.g + ", mGapDir=" + this.h + ", mHasUnwantedGapAfter=" + this.j + ", mGapPerSpan=" + Arrays.toString(this.i) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.j ? 1 : 0);
        int[] iArr = this.i;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.i);
        }
    }
}
