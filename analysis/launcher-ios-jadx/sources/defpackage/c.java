package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Parcelable {
    private final Parcelable mSuperState;
    public static final c EMPTY_STATE = new a();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.mSuperState = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }
}
