package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public final class xn0 extends r21 {
    public static final Parcelable.Creator<xn0> CREATOR = new z1(13);
    public String g;

    public xn0(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.g);
    }

    public xn0() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
