package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class kd extends c {
    public static final Parcelable.Creator<kd> CREATOR = new b(1);
    public final int g;
    public final int h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public kd(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt() == 1;
        this.j = parcel.readInt() == 1;
        this.k = parcel.readInt() == 1;
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
    }

    public kd(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.g = bottomSheetBehavior.J;
        this.h = bottomSheetBehavior.d;
        this.i = bottomSheetBehavior.b;
        this.j = bottomSheetBehavior.G;
        this.k = bottomSheetBehavior.H;
    }
}
