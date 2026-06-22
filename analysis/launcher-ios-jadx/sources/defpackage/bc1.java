package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class bc1 implements Parcelable {
    public static final Parcelable.Creator<bc1> CREATOR = new zb1(0);
    public je0 g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.g == null) {
                    this.g = new ac1(this);
                }
                parcel.writeStrongBinder(this.g.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i, Bundle bundle) {
    }
}
