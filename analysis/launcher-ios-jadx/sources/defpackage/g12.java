package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class g12 extends b12 implements fa0, ga0 {
    public static final q02 o = h12.a;
    public final Context h;
    public final t12 i;
    public final q02 j;
    public final Set k;
    public final mj l;
    public rg1 m;
    public wc0 n;

    public g12(Context context, t12 t12Var, mj mjVar) {
        super(0);
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.h = context;
        this.i = t12Var;
        this.l = mjVar;
        this.k = (Set) mjVar.a;
        this.j = o;
    }

    @Override // defpackage.fa0
    public final void f() {
        GoogleSignInAccount googleSignInAccountA;
        rg1 rg1Var = this.m;
        rg1Var.getClass();
        try {
            rg1Var.c.getClass();
            Account account = new Account(eb.DEFAULT_ACCOUNT, "com.google");
            if (eb.DEFAULT_ACCOUNT.equals(account.name)) {
                Context context = rg1Var.getContext();
                ReentrantLock reentrantLock = rj1.c;
                hg0.i(context);
                ReentrantLock reentrantLock2 = rj1.c;
                reentrantLock2.lock();
                try {
                    try {
                        if (rj1.d == null) {
                            rj1.d = new rj1(context.getApplicationContext());
                        }
                        rj1 rj1Var = rj1.d;
                        reentrantLock2.unlock();
                        String strA = rj1Var.a("defaultGoogleSignInAccount");
                        if (!TextUtils.isEmpty(strA)) {
                            StringBuilder sb = new StringBuilder(20 + String.valueOf(strA).length());
                            sb.append("googleSignInAccount:");
                            sb.append(strA);
                            String strA2 = rj1Var.a(sb.toString());
                            if (strA2 != null) {
                                try {
                                    googleSignInAccountA = GoogleSignInAccount.a(strA2);
                                } catch (JSONException unused) {
                                    googleSignInAccountA = null;
                                }
                            }
                        }
                        googleSignInAccountA = null;
                    } catch (RemoteException unused2) {
                        return;
                    }
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } else {
                googleSignInAccountA = null;
            }
            Integer num = rg1Var.e;
            hg0.i(num);
            u12 u12Var = new u12(2, account, num.intValue(), googleSignInAccountA);
            j12 j12Var = (j12) rg1Var.getService();
            j12Var.getClass();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(j12Var.i);
            int i = a12.a;
            parcelObtain.writeInt(1);
            int iE = os.E(20293, parcelObtain);
            os.G(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            os.y(parcelObtain, 2, u12Var, 0);
            os.F(iE, parcelObtain);
            parcelObtain.writeStrongBinder(this);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                j12Var.h.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable th2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th2;
            }
        } catch (RemoteException unused3) {
            this.i.post(new el0(this, new o12(1, new vl(8, null), null), 21));
        }
    }

    @Override // defpackage.ga0
    public final void onConnectionFailed(vl vlVar) {
        this.n.b(vlVar);
    }

    @Override // defpackage.fa0
    public final void onConnectionSuspended(int i) {
        this.m.disconnect();
    }
}
