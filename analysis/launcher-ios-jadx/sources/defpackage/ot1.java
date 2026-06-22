package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ot1 extends c {
    public static final Parcelable.Creator<ot1> CREATOR = new b(11);
    public int g;
    public Parcelable h;
    public final ClassLoader i;

    public ot1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? ot1.class.getClassLoader() : classLoader;
        this.g = parcel.readInt();
        this.h = parcel.readParcelable(classLoader);
        this.i = classLoader;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" position=");
        return uo.j(sb, this.g, "}");
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
        parcel.writeParcelable(this.h, i);
    }
}
