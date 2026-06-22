package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class xt1 extends View.BaseSavedState {
    public static final Parcelable.Creator<xt1> CREATOR = new b(12);
    public int g;
    public int h;
    public Parcelable i;

    public xt1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readParcelable(classLoader);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeParcelable(this.i, i);
    }
}
