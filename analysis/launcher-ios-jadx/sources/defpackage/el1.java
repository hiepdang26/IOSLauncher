package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class el1 extends View.BaseSavedState {
    public static final Parcelable.Creator<el1> CREATOR = new zb1(4);
    public boolean g;

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g ? 1 : 0);
    }
}
