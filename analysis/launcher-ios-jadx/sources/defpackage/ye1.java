package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public final class ye1 extends r21 {
    public static final Parcelable.Creator<ye1> CREATOR = new zb1(1);
    public int g;
    public int h;
    public int i;

    public ye1(Parcel parcel) {
        super(parcel);
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
    }

    public ye1() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
