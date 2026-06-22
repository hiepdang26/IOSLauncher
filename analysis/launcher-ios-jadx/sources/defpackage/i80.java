package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class i80 extends b0 {
    public static final Parcelable.Creator<i80> CREATOR = new d82(12);
    public static final Scope[] u = new Scope[0];
    public static final v20[] v = new v20[0];
    public final int g;
    public final int h;
    public final int i;
    public String j;
    public IBinder k;
    public Scope[] l;
    public Bundle m;
    public Account n;
    public v20[] o;
    public v20[] p;
    public final boolean q;
    public final int r;
    public boolean s;
    public final String t;

    public i80(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, v20[] v20VarArr, v20[] v20VarArr2, boolean z, int i4, boolean z2, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? u : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        v20[] v20VarArr3 = v;
        v20[] v20VarArr4 = v20VarArr == null ? v20VarArr3 : v20VarArr;
        v20VarArr3 = v20VarArr2 != null ? v20VarArr2 : v20VarArr3;
        this.g = i;
        this.h = i2;
        this.i = i3;
        if ("com.google.android.gms".equals(str)) {
            this.j = "com.google.android.gms";
        } else {
            this.j = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i5 = c1.h;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface nd2Var = iInterfaceQueryLocalInterface instanceof sd0 ? (sd0) iInterfaceQueryLocalInterface : new nd2(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                if (nd2Var != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        nd2 nd2Var2 = (nd2) nd2Var;
                        Parcel parcelF = nd2Var2.f(2, nd2Var2.p());
                        Account account3 = (Account) i62.a(parcelF, Account.CREATOR);
                        parcelF.recycle();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
            this.n = account2;
        } else {
            this.k = iBinder;
            this.n = account;
        }
        this.l = scopeArr2;
        this.m = bundle2;
        this.o = v20VarArr4;
        this.p = v20VarArr3;
        this.q = z;
        this.r = i4;
        this.s = z2;
        this.t = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        d82.a(this, parcel, i);
    }
}
