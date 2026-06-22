package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzauh;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzfoh;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfqd;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class lb2 implements Runnable, zzauk {
    public boolean j;
    public final boolean k;
    public final boolean l;
    public final ExecutorService m;
    public final zzfoh n;
    public Context o;
    public final Context p;
    public or1 q;
    public final or1 r;
    public final boolean s;
    public int u;
    public final Vector g = new Vector();
    public final AtomicReference h = new AtomicReference();
    public final AtomicReference i = new AtomicReference();
    public final CountDownLatch t = new CountDownLatch(1);

    public lb2(Context context, or1 or1Var) {
        this.o = context;
        this.p = context;
        this.q = or1Var;
        this.r = or1Var;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.m = executorServiceNewCachedThreadPool;
        zzbbn zzbbnVar = zzbbw.zzce;
        n42 n42Var = n42.d;
        boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
        this.s = zBooleanValue;
        this.n = zzfoh.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        zzbbn zzbbnVar2 = zzbbw.zzcb;
        zzbbu zzbbuVar = n42Var.c;
        this.k = ((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue();
        this.l = ((Boolean) zzbbuVar.zza(zzbbw.zzcf)).booleanValue();
        if (((Boolean) zzbbuVar.zza(zzbbw.zzcd)).booleanValue()) {
            this.u = 2;
        } else {
            this.u = 1;
        }
        if (!((Boolean) zzbbuVar.zza(zzbbw.zzdc)).booleanValue()) {
            this.j = a();
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzcW)).booleanValue()) {
            zzbzo.zza.execute(this);
            return;
        }
        ka2 ka2Var = x32.f.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzbzo.zza.execute(this);
        } else {
            run();
        }
    }

    public final boolean a() {
        Context context = this.o;
        ew1 ew1Var = new ew1(this, 7);
        return new zzfqd(context, zzfpj.zzb(context, this.n), ew1Var, ((Boolean) n42.d.c.zza(zzbbw.zzcc)).booleanValue()).zzd(1);
    }

    public final boolean b() {
        try {
            this.t.await();
            return true;
        } catch (InterruptedException unused) {
            k92.j(5);
            return false;
        }
    }

    public final zzauk c() {
        return ((!this.k || this.j) ? this.u : 1) == 2 ? (zzauk) this.i.get() : (zzauk) this.h.get();
    }

    public final void d() {
        Vector<Object[]> vector = this.g;
        zzauk zzaukVarC = c();
        if (vector.isEmpty() || zzaukVarC == null) {
            return;
        }
        for (Object[] objArr : vector) {
            int length = objArr.length;
            if (length == 1) {
                zzaukVarC.zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                zzaukVarC.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        vector.clear();
    }

    public final void e(boolean z) {
        String str = this.q.g;
        Context context = this.o;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.h.set(zzaun.zzu(str, context, z, this.u));
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch = this.t;
        try {
            zzbbn zzbbnVar = zzbbw.zzdc;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                this.j = a();
            }
            boolean z = this.q.j;
            boolean z2 = false;
            if (!((Boolean) n42Var.c.zza(zzbbw.zzaN)).booleanValue() && z) {
                z2 = true;
            }
            if (((!this.k || this.j) ? this.u : 1) == 1) {
                e(z2);
                if (this.u == 2) {
                    this.m.execute(new eh1(this, z2, 3));
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    String str = this.q.g;
                    Context context = this.o;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzauh zzauhVarZza = zzauh.zza(str, context, z2, this.s);
                    this.i.set(zzauhVarZza);
                    if (this.l && !zzauhVarZza.zzr()) {
                        this.u = 1;
                        e(z2);
                    }
                } catch (NullPointerException e) {
                    this.u = 1;
                    e(z2);
                    this.n.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e);
                }
            }
            countDownLatch.countDown();
            this.o = null;
            this.q = null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            this.o = null;
            this.q = null;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!b()) {
            return "";
        }
        zzauk zzaukVarC = c();
        if (((Boolean) n42.d.c.zza(zzbbw.zzjM)).booleanValue()) {
            cd2 cd2Var = hd2.B.c;
            cd2.h(4, view);
        }
        if (zzaukVarC == null) {
            return "";
        }
        d();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return zzaukVarC.zzf(context, str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        zzauk zzaukVarC;
        if (!b() || (zzaukVarC = c()) == null) {
            return "";
        }
        d();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return zzaukVarC.zzg(context);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, View view, Activity activity) {
        zzbbn zzbbnVar = zzbbw.zzjL;
        n42 n42Var = n42.d;
        boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
        zzbbu zzbbuVar = n42Var.c;
        if (!zBooleanValue) {
            zzauk zzaukVarC = c();
            if (((Boolean) zzbbuVar.zza(zzbbw.zzjM)).booleanValue()) {
                cd2 cd2Var = hd2.B.c;
                cd2.h(2, view);
            }
            return zzaukVarC != null ? zzaukVarC.zzh(context, view, activity) : "";
        }
        if (!b()) {
            return "";
        }
        zzauk zzaukVarC2 = c();
        if (((Boolean) zzbbuVar.zza(zzbbw.zzjM)).booleanValue()) {
            cd2 cd2Var2 = hd2.B.c;
            cd2.h(2, view);
        }
        return zzaukVarC2 != null ? zzaukVarC2.zzh(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzk(MotionEvent motionEvent) {
        zzauk zzaukVarC = c();
        if (zzaukVarC == null) {
            this.g.add(new Object[]{motionEvent});
        } else {
            d();
            zzaukVarC.zzk(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzl(int i, int i2, int i3) {
        zzauk zzaukVarC = c();
        if (zzaukVarC == null) {
            this.g.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            d();
            zzaukVarC.zzl(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzauk zzaukVarC;
        if (!b() || (zzaukVarC = c()) == null) {
            return;
        }
        zzaukVarC.zzn(stackTraceElementArr);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzo(View view) {
        zzauk zzaukVarC = c();
        if (zzaukVarC != null) {
            zzaukVarC.zzo(view);
        }
    }
}
