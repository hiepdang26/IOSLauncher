package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class rw0 extends c {
    public static final Parcelable.Creator<rw0> CREATOR = new b(7);
    public Bundle g;

    public rw0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = parcel.readBundle(classLoader);
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.g);
    }
}
