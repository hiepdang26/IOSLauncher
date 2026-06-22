package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.ja2;
import defpackage.k92;
import defpackage.n42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzayo implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    private Runnable zzh;
    private long zzj;
    private final Object zzc = new Object();
    private boolean zzd = true;
    private boolean zze = false;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private boolean zzi = false;

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            try {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.zza = activity;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            try {
                Activity activity2 = this.zza;
                if (activity2 == null) {
                    return;
                }
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (((zzazd) it.next()).zza()) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        hd2.B.g.zzw(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        k92.f();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzazd) it.next()).zzb();
                } catch (Exception e) {
                    hd2.B.g.zzw(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    k92.f();
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            cd2.l.removeCallbacks(runnable);
        }
        ja2 ja2Var = cd2.l;
        zzayn zzaynVar = new zzayn(this);
        this.zzh = zzaynVar;
        ja2Var.postDelayed(zzaynVar, this.zzj);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z = this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            cd2.l.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzazd) it.next()).zzc();
                } catch (Exception e) {
                    hd2.B.g.zzw(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    k92.f();
                }
            }
            if (z) {
                k92.d("App is still foreground.");
            } else {
                Iterator it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    try {
                        ((zzayp) it2.next()).zza(true);
                    } catch (Exception unused) {
                        k92.f();
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzayp zzaypVar) {
        synchronized (this.zzc) {
            this.zzf.add(zzaypVar);
        }
    }

    public final void zzg(Application application, Context context) {
        if (this.zzi) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            zzk((Activity) context);
        }
        this.zzb = application;
        this.zzj = ((Long) n42.d.c.zza(zzbbw.zzaJ)).longValue();
        this.zzi = true;
    }

    public final void zzh(zzayp zzaypVar) {
        synchronized (this.zzc) {
            this.zzf.remove(zzaypVar);
        }
    }
}
