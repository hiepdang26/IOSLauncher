package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class v20 extends b0 {
    public static final Parcelable.Creator<v20> CREATOR = new zb1(26);
    public final String g;
    public final int h;
    public final long i;

    public v20(String str) {
        this.g = str;
        this.i = 1L;
        this.h = -1;
    }

    public final long a() {
        long j = this.i;
        return j == -1 ? this.h : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v20) {
            v20 v20Var = (v20) obj;
            String str = this.g;
            if (((str != null && str.equals(v20Var.g)) || (str == null && v20Var.g == null)) && a() == v20Var.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.g, Long.valueOf(a())});
    }

    public final String toString() {
        tu tuVar = new tu(this);
        tuVar.c(this.g, "name");
        tuVar.c(Long.valueOf(a()), "version");
        return tuVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        long jA = a();
        os.G(parcel, 3, 8);
        parcel.writeLong(jA);
        os.F(iE, parcel);
    }

    public v20(String str, int i, long j) {
        this.g = str;
        this.h = i;
        this.i = j;
    }
}
