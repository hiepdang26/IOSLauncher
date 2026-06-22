package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f3 {
    public uc a;
    public ga2 b;
    public boolean c;
    public final Object d = new Object();
    public g42 e;
    public final Context f;
    public final long g;

    public f3(Context context, long j, boolean z) {
        Context applicationContext;
        hg0.i(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.c = false;
        this.g = j;
    }

    public static e3 a(Context context) {
        f3 f3Var = new f3(context, -1L, true);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            f3Var.d(false);
            e3 e3VarF = f3Var.f();
            e(e3VarF, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return e3VarF;
        } finally {
        }
    }

    public static boolean b(Context context) {
        boolean z;
        f3 f3Var = new f3(context, -1L, false);
        try {
            f3Var.d(false);
            hg0.h("Calling this from your main thread can lead to deadlock");
            synchronized (f3Var) {
                try {
                    if (!f3Var.c) {
                        synchronized (f3Var.d) {
                            g42 g42Var = f3Var.e;
                            if (g42Var == null || !g42Var.j) {
                                throw new IOException("AdvertisingIdClient is not connected.");
                            }
                        }
                        try {
                            f3Var.d(false);
                            if (!f3Var.c) {
                                throw new IOException("AdvertisingIdClient cannot reconnect.");
                            }
                        } catch (Exception e) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                        }
                    }
                    hg0.i(f3Var.a);
                    hg0.i(f3Var.b);
                    try {
                        y72 y72Var = (y72) f3Var.b;
                        y72Var.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        Parcel parcelF = y72Var.f(6, parcelObtain);
                        int i = g62.a;
                        z = parcelF.readInt() != 0;
                        parcelF.recycle();
                    } catch (RemoteException unused) {
                        throw new IOException("Remote exception");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            f3Var.g();
            return z;
        } finally {
            f3Var.c();
        }
    }

    public static void e(e3 e3Var, long j, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (e3Var != null) {
                map.put("limit_ad_tracking", true != e3Var.b ? "0" : "1");
                String str = e3Var.a;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j));
            new z12(map, 0).start();
        }
    }

    public final void c() {
        hg0.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.a == null) {
                    return;
                }
                try {
                    if (this.c) {
                        bm.a().b(this.f, this.a);
                    }
                } catch (Throwable unused) {
                }
                this.c = false;
                this.b = null;
                this.a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(boolean z) {
        hg0.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.c) {
                    c();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iC = ea0.b.c(context, 12451000);
                    if (iC != 0 && iC != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    uc ucVar = new uc();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!bm.a().c(context, context.getClass().getName(), intent, ucVar, 1, null)) {
                            throw new IOException("Connection failure");
                        }
                        this.a = ucVar;
                        try {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            IBinder iBinderA = ucVar.a();
                            int i = h92.g;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.b = iInterfaceQueryLocalInterface instanceof ga2 ? (ga2) iInterfaceQueryLocalInterface : new y72(iBinderA);
                            this.c = true;
                            if (z) {
                                g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new ia0();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final e3 f() {
        e3 e3Var;
        hg0.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.c) {
                    synchronized (this.d) {
                        g42 g42Var = this.e;
                        if (g42Var == null || !g42Var.j) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                hg0.i(this.a);
                hg0.i(this.b);
                try {
                    y72 y72Var = (y72) this.b;
                    y72Var.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    Parcel parcelF = y72Var.f(1, parcelObtain);
                    String string = parcelF.readString();
                    parcelF.recycle();
                    y72 y72Var2 = (y72) this.b;
                    y72Var2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i = g62.a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelF2 = y72Var2.f(2, parcelObtain2);
                    boolean z = parcelF2.readInt() != 0;
                    parcelF2.recycle();
                    e3Var = new e3(string, z);
                } catch (RemoteException unused) {
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return e3Var;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.d) {
            g42 g42Var = this.e;
            if (g42Var != null) {
                g42Var.i.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.g;
            if (j > 0) {
                this.e = new g42(this, j);
            }
        }
    }
}
