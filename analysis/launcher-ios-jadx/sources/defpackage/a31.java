package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public final class a31 extends r21 {
    public static final Parcelable.Creator<a31> CREATOR = new z1(28);
    public final int g;

    public a31(Parcel parcel) {
        super(parcel);
        this.g = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
    }

    public a31(int i) {
        super(AbsSavedState.EMPTY_STATE);
        this.g = i;
    }
}
