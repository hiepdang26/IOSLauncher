package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public final class mp1 extends r21 {
    public static final Parcelable.Creator<mp1> CREATOR = new zb1(5);
    public boolean g;

    public mp1(Parcel parcel) {
        super(parcel);
        this.g = parcel.readInt() == 1;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g ? 1 : 0);
    }

    public mp1() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
