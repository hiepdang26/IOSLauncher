package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class lg0 implements Parcelable {
    public static final Parcelable.Creator<lg0> CREATOR = new z1(11);
    public final IntentSender g;
    public final Intent h;
    public final int i;
    public final int j;

    public lg0(IntentSender intentSender, int i, int i2) {
        this.g = intentSender;
        this.h = null;
        this.i = i;
        this.j = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.h, i);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }

    public lg0(Parcel parcel) {
        this.g = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.h = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }
}
