package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.qr1;
import defpackage.rr1;
import defpackage.z1;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new z1(23);
    public final rr1 g;

    public ParcelImpl(Parcel parcel) {
        this.g = new qr1(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new qr1(parcel).k(this.g);
    }
}
