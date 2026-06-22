package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.xh;
import defpackage.z52;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxx implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) n42.d.c.zza(zzbbw.zzbd)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzayj zzj;
    private final z52 zzk = new z52(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzaxx(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zze = application;
            this.zzj = new zzayj(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i) {
        return (int) (i / this.zzo.density);
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb == null || (window = activity.getWindow()) == null) {
            return;
        }
        WeakReference weakReference = this.zzb;
        View viewPeekDecorView = window.peekDecorView();
        View view = (View) weakReference.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.zzm = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r29v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r30v0, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(int r32) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxx.zzj(int):void");
    }

    private final void zzk() {
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaxt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzaxu zzaxuVar = new zzaxu(this);
            this.zza = zzaxuVar;
            Context context = this.zzd;
            xh xhVar = hd2.B.y;
            synchronized (xhVar) {
                if (xhVar.b) {
                    ((WeakHashMap) xhVar.d).put(zzaxuVar, intentFilter);
                } else {
                    zzbbw.zza(context);
                    if (!((Boolean) n42.d.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                        context.registerReceiver(zzaxuVar, intentFilter);
                    } else {
                        context.registerReceiver(zzaxuVar, intentFilter, 4);
                    }
                }
            }
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused) {
                k92.f();
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception unused) {
            k92.f();
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
            k92.f();
        }
        BroadcastReceiver broadcastReceiver = this.zza;
        if (broadcastReceiver != null) {
            try {
                hd2.B.y.g(this.zzd, broadcastReceiver);
            } catch (IllegalStateException unused3) {
                k92.f();
            } catch (Exception e) {
                hd2.B.g.zzw(e, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused4) {
                k92.f();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzj(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzaxw zzaxwVar) {
        this.zzn.add(zzaxwVar);
        zzj(3);
    }

    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzaxw zzaxwVar) {
        this.zzn.remove(zzaxwVar);
    }

    public final void zzf() {
        z52 z52Var = this.zzk;
        long j = zzc;
        synchronized (z52Var.c) {
            z52Var.a = j;
        }
    }

    public final void zzg(long j) {
        z52 z52Var = this.zzk;
        synchronized (z52Var.c) {
            z52Var.a = j;
        }
    }
}
