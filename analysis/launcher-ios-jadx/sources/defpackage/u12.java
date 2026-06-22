package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class u12 extends b0 {
    public static final Parcelable.Creator<u12> CREATOR = new zb1(12);
    public final int g;
    public final Account h;
    public final int i;
    public final GoogleSignInAccount j;

    public u12(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.g = i;
        this.h = account;
        this.i = i2;
        this.j = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.y(parcel, 2, this.h, i);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i);
        os.y(parcel, 4, this.j, i);
        os.F(iE, parcel);
    }
}
