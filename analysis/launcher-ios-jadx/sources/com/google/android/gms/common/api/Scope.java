package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.zb1;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends b0 implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zb1(14);
    public final int g;
    public final String h;

    public Scope(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.g = i;
        this.h = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.h.equals(((Scope) obj).h);
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    public final String toString() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.z(parcel, 2, this.h);
        os.F(iE, parcel);
    }
}
