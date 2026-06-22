package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class hn1 extends c {
    public static final Parcelable.Creator<hn1> CREATOR = new b(10);
    public CharSequence g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;

    public hn1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.g = (CharSequence) creator.createFromParcel(parcel);
        this.h = parcel.readInt() == 1;
        this.i = (CharSequence) creator.createFromParcel(parcel);
        this.j = (CharSequence) creator.createFromParcel(parcel);
        this.k = (CharSequence) creator.createFromParcel(parcel);
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.g) + " hint=" + ((Object) this.i) + " helperText=" + ((Object) this.j) + " placeholderText=" + ((Object) this.k) + "}";
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.g, parcel, i);
        parcel.writeInt(this.h ? 1 : 0);
        TextUtils.writeToParcel(this.i, parcel, i);
        TextUtils.writeToParcel(this.j, parcel, i);
        TextUtils.writeToParcel(this.k, parcel, i);
    }
}
