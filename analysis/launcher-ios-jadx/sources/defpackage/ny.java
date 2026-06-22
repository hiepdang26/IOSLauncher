package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public final class ny extends r21 {
    public static final Parcelable.Creator<ny> CREATOR = new z1(7);
    public String g;

    public ny(Parcel parcel) {
        super(parcel);
        this.g = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.g);
    }

    public ny() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
