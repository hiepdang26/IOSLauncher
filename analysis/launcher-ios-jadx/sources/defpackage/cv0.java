package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class cv0 extends r21 {
    public static final Parcelable.Creator<cv0> CREATOR = new z1(21);
    public HashSet g;

    public cv0(Parcel parcel) {
        super(parcel);
        int i = parcel.readInt();
        this.g = new HashSet();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Collections.addAll(this.g, strArr);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g.size());
        HashSet hashSet = this.g;
        parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
    }

    public cv0() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
