package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class eb {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private vl zzB;
    private boolean zzC;
    private volatile qb2 zzD;
    kd2 zza;
    final Handler zzb;
    protected cb zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final aa0 zzn;
    private final ea0 zzo;
    private final Object zzp;
    private final Object zzq;
    private wd0 zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private g92 zzu;
    private int zzv;
    private final ab zzw;
    private final bb zzx;
    private final int zzy;
    private final String zzz;
    private static final v20[] zze = new v20[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX WARN: Illegal instructions before constructor call */
    public eb(Context context, Looper looper, ab abVar, bb bbVar, int i) {
        ad2 ad2VarA = aa0.a(context);
        ea0 ea0Var = ea0.b;
        hg0.i(abVar);
        hg0.i(bbVar);
        this(context, looper, ad2VarA, ea0Var, i, abVar, bbVar, null);
    }

    public static void zzj(eb ebVar, qb2 qb2Var) {
        ebVar.zzD = qb2Var;
        if (ebVar.usesClientTelemetry()) {
            am amVar = qb2Var.j;
            mc1 mc1VarR = mc1.r();
            nc1 nc1Var = amVar == null ? null : amVar.g;
            synchronized (mc1VarR) {
                if (nc1Var == null) {
                    mc1VarR.h = mc1.j;
                    return;
                }
                nc1 nc1Var2 = (nc1) mc1VarR.h;
                if (nc1Var2 == null || nc1Var2.g < nc1Var.g) {
                    mc1VarR.h = nc1Var;
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(eb ebVar, int i) {
        int i2;
        int i3;
        synchronized (ebVar.zzp) {
            i2 = ebVar.zzv;
        }
        if (i2 == 3) {
            ebVar.zzC = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = ebVar.zzb;
        handler.sendMessage(handler.obtainMessage(i3, ebVar.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(eb ebVar, int i, int i2, IInterface iInterface) {
        synchronized (ebVar.zzp) {
            try {
                if (ebVar.zzv != i) {
                    return false;
                }
                ebVar.b(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(eb ebVar) {
        if (ebVar.zzC || TextUtils.isEmpty(ebVar.getServiceDescriptor()) || TextUtils.isEmpty(ebVar.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(ebVar.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void b(int i, IInterface iInterface) {
        kd2 kd2Var;
        if ((i == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                if (i == 1) {
                    g92 g92Var = this.zzu;
                    if (g92Var != null) {
                        aa0 aa0Var = this.zzn;
                        String str = this.zza.a;
                        hg0.i(str);
                        String str2 = this.zza.b;
                        zze();
                        aa0Var.c(str, str2, g92Var, this.zza.c);
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    g92 g92Var2 = this.zzu;
                    if (g92Var2 != null && (kd2Var = this.zza) != null) {
                        String str3 = kd2Var.a;
                        aa0 aa0Var2 = this.zzn;
                        hg0.i(str3);
                        String str4 = this.zza.b;
                        zze();
                        aa0Var2.c(str3, str4, g92Var2, this.zza.c);
                        this.zzd.incrementAndGet();
                    }
                    g92 g92Var3 = new g92(this, this.zzd.get());
                    this.zzu = g92Var3;
                    kd2 kd2Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new kd2(getStartServicePackage(), getStartServiceAction(), getUseDynamicLookup()) : new kd2(getContext().getPackageName(), getLocalStartServiceAction(), false);
                    this.zza = kd2Var2;
                    if (kd2Var2.c && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.a)));
                    }
                    aa0 aa0Var3 = this.zzn;
                    String str5 = this.zza.a;
                    hg0.i(str5);
                    if (!aa0Var3.d(new kc2(str5, this.zza.b, this.zza.c), g92Var3, zze(), getBindServiceExecutor())) {
                        String str6 = this.zza.a;
                        zzl(16, null, this.zzd.get());
                    }
                } else if (i == 4) {
                    hg0.i(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int iC = this.zzo.c(this.zzl, getMinApkVersion());
        if (iC == 0) {
            connect(new fz1(this, 4));
        } else {
            b(1, null);
            triggerNotAvailable(new fz1(this, 4), iC, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(cb cbVar) {
        hg0.j(cbVar, "Connection progress callbacks cannot be null.");
        this.zzc = cbVar;
        b(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    ((x12) this.zzt.get(i)).c();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        b(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        wd0 wd0Var;
        synchronized (this.zzp) {
            i = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            wd0Var = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (wd0Var == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(wd0Var.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzh;
            printWriterAppend.println(j + " " + simpleDateFormat.format(new Date(j)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zzf;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzg;
            printWriterAppend2.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) n90.p(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzj;
            printWriterAppend3.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public v20[] getApiFeatures() {
        return zze;
    }

    public final v20[] getAvailableFeatures() {
        qb2 qb2Var = this.zzD;
        if (qb2Var == null) {
            return null;
        }
        return qb2Var.h;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        kd2 kd2Var;
        if (!isConnected() || (kd2Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return kd2Var.b;
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return ea0.a;
    }

    public void getRemoteService(sd0 sd0Var, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = this.zzA;
        int i = ea0.a;
        Scope[] scopeArr = i80.u;
        Bundle bundle = new Bundle();
        int i2 = this.zzy;
        v20[] v20VarArr = i80.v;
        i80 i80Var = new i80(6, i2, i, null, null, scopeArr, bundle, null, v20VarArr, v20VarArr, true, 0, false, str);
        i80Var.j = this.zzl.getPackageName();
        i80Var.m = getServiceRequestExtraArgs;
        if (set != null) {
            i80Var.l = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            i80Var.n = account;
            if (sd0Var != null) {
                i80Var.k = sd0Var.asBinder();
            }
        } else if (requiresAccount()) {
            i80Var.n = getAccount();
        }
        i80Var.o = zze;
        i80Var.p = getApiFeatures();
        if (usesClientTelemetry()) {
            i80Var.s = true;
        }
        try {
            try {
                synchronized (this.zzq) {
                    try {
                        wd0 wd0Var = this.zzr;
                        if (wd0Var != null) {
                            ((n22) wd0Var).f(new x72(this, this.zzd.get()), i80Var);
                        }
                    } finally {
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                onPostInitHandler(8, null, null, this.zzd.get());
            }
        } catch (DeadObjectException unused2) {
            triggerConnectionSuspended(3);
        } catch (SecurityException e) {
            throw e;
        }
    }

    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                iInterface = this.zzs;
                hg0.j(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                wd0 wd0Var = this.zzr;
                if (wd0Var == null) {
                    return null;
                }
                return wd0Var.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public am getTelemetryConfiguration() {
        qb2 qb2Var = this.zzD;
        if (qb2Var == null) {
            return null;
        }
        return qb2Var.j;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(vl vlVar) {
        this.zzi = vlVar.h;
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i2, -1, new na2(this, i, iBinder, bundle)));
    }

    public void onUserSignOut(db dbVar) {
        xz1 xz1Var = (xz1) dbVar;
        ((v02) xz1Var.g).s.t.post(new fl0(xz1Var, 24));
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i));
    }

    public void triggerNotAvailable(cb cbVar, int i, PendingIntent pendingIntent) {
        hg0.j(cbVar, "Connection progress callbacks cannot be null.");
        this.zzc = cbVar;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i, Bundle bundle, int i2) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i2, -1, new bb2(this, i)));
    }

    public eb(Context context, Looper looper, ad2 ad2Var, ea0 ea0Var, int i, ab abVar, bb bbVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        hg0.j(context, "Context must not be null");
        this.zzl = context;
        hg0.j(looper, "Looper must not be null");
        this.zzm = looper;
        hg0.j(ad2Var, "Supervisor must not be null");
        this.zzn = ad2Var;
        hg0.j(ea0Var, "API availability must not be null");
        this.zzo = ea0Var;
        this.zzb = new c42(this, looper);
        this.zzy = i;
        this.zzw = abVar;
        this.zzx = bbVar;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
