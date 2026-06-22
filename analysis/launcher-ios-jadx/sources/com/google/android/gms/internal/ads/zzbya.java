package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import defpackage.dy;
import defpackage.ea0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.ra2;
import defpackage.tb2;
import defpackage.x32;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzbya {
    private final Object zzi;
    private final AtomicReference zzb = new AtomicReference(null);
    private final Object zzc = new Object();
    private String zzd = null;
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicInteger zze = new AtomicInteger(-1);
    private final AtomicReference zzf = new AtomicReference(null);
    private final AtomicReference zzg = new AtomicReference(null);
    private final ConcurrentMap zzh = new ConcurrentHashMap(9);

    public zzbya() {
        new AtomicReference(null);
        new ArrayBlockingQueue(20);
        this.zzi = new Object();
    }

    public static final boolean zzq(Context context) {
        zzbbn zzbbnVar = zzbbw.zzac;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return false;
        }
        if (dy.a(context, ModuleDescriptor.MODULE_ID) < ((Integer) n42Var.c.zza(zzbbw.zzad)).intValue()) {
            return false;
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzae)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final Object zzr(String str, Context context) {
        if (!zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            return null;
        }
        try {
            return zzs(context, str).invoke(this.zzf.get(), null);
        } catch (Exception unused) {
            zzv(str, true);
            return null;
        }
    }

    private final Method zzs(Context context, String str) {
        Method method = (Method) this.zzh.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, null);
            this.zzh.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzv(str, false);
            return null;
        }
    }

    private final void zzt(Context context, String str, String str2) {
        if (zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            Method declaredMethod = (Method) this.zzh.get(str2);
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, String.class);
                    this.zzh.put(str2, declaredMethod);
                } catch (Exception unused) {
                    zzv(str2, false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzf.get(), str);
                k92.a("Invoke Firebase method " + str2 + ", Ad Unit Id: " + str);
            } catch (Exception unused2) {
                zzv(str2, false);
            }
        }
    }

    private final void zzu(Context context, String str, String str2, Bundle bundle) {
        if (zzp(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException unused) {
                "Invalid event ID: ".concat(String.valueOf(str2));
                k92.f();
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
                Method declaredMethod = (Method) this.zzh.get("logEventInternal");
                if (declaredMethod == null) {
                    try {
                        declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
                        this.zzh.put("logEventInternal", declaredMethod);
                    } catch (Exception unused2) {
                        zzv("logEventInternal", true);
                        declaredMethod = null;
                    }
                }
                try {
                    declaredMethod.invoke(this.zzf.get(), "am", str, bundle2);
                } catch (Exception unused3) {
                    zzv("logEventInternal", true);
                }
            }
        }
    }

    private final void zzv(String str, boolean z) {
        if (this.zza.get()) {
            return;
        }
        k92.h("Invoke Firebase method " + str + " error.");
        if (z) {
            k92.h("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zza.set(true);
        }
    }

    private final boolean zzw(Context context, String str, AtomicReference atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                zzbxx.zza(atomicReference, null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception unused) {
                zzv("getInstance", z);
                return false;
            }
        }
        return true;
    }

    public final String zza(Context context) {
        Object objZzr;
        if (zzp(context) && (objZzr = zzr("generateEventId", context)) != null) {
            return objZzr.toString();
        }
        return null;
    }

    public final String zzb(final Context context) {
        if (!zzp(context)) {
            return null;
        }
        zzbbn zzbbnVar = zzbbw.zzaa;
        n42 n42Var = n42.d;
        long jLongValue = ((Long) n42Var.c.zza(zzbbnVar)).longValue();
        if (jLongValue < 0) {
            return (String) zzr("getAppInstanceId", context);
        }
        if (this.zzb.get() == null) {
            zzbbn zzbbnVar2 = zzbbw.zzab;
            zzbxx.zza(this.zzb, null, new ThreadPoolExecutor(((Integer) n42Var.c.zza(zzbbnVar2)).intValue(), ((Integer) n42Var.c.zza(zzbbnVar2)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzbxz(this)));
        }
        try {
            return (String) ((ExecutorService) this.zzb.get()).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzbxy
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zze(context);
                }
            }).get(jLongValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return "TIME_OUT";
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String zzc(Context context) {
        if (zzp(context) && zzw(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            try {
                String str = (String) zzs(context, "getCurrentScreenName").invoke(this.zzf.get(), null);
                if (str == null) {
                    str = (String) zzs(context, "getCurrentScreenClass").invoke(this.zzf.get(), null);
                }
                return str == null ? "" : str;
            } catch (Exception unused) {
                zzv("getCurrentScreenName", false);
            }
        }
        return "";
    }

    public final String zzd(Context context) {
        if (!zzp(context)) {
            return null;
        }
        synchronized (this.zzc) {
            try {
                String str = this.zzd;
                if (str != null) {
                    return str;
                }
                String str2 = (String) zzr("getGmpAppId", context);
                this.zzd = str2;
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ String zze(Context context) {
        return (String) zzr("getAppInstanceId", context);
    }

    public final void zzf(Context context, String str) {
        if (zzp(context)) {
            zzt(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzg(Context context, String str) {
        if (zzp(context)) {
            zzt(context, str, "endAdUnitExposure");
        }
    }

    public final void zzh(Context context, String str) {
        zzu(context, "_aa", str, null);
    }

    public final void zzi(Context context, String str) {
        zzu(context, "_aq", str, null);
    }

    public final void zzj(Context context, String str, Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String str2 : map.keySet()) {
                bundle.putString(str2, (String) map.get(str2));
            }
        }
        zzu(context, "_ac", str, bundle);
    }

    public final void zzk(Context context, String str, Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String str2 : map.keySet()) {
                bundle.putString(str2, (String) map.get(str2));
            }
        }
        zzu(context, "_ai", str, bundle);
    }

    public final void zzl(Context context, String str, String str2, String str3, int i) {
        if (zzp(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zzu(context, "_ar", str, bundle);
            k92.a("Log a Firebase reward video event, reward type: " + str3 + ", reward value: " + i);
        }
    }

    public final void zzm(Context context, tb2 tb2Var) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzah)).booleanValue() && zzp(context) && zzq(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    public final void zzn(Context context, ra2 ra2Var) {
        zzbyb.zzd(context).zzb().zzc(ra2Var);
        if (((Boolean) n42.d.c.zza(zzbbw.zzah)).booleanValue() && zzp(context) && zzq(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    @Deprecated
    public final void zzo(Context context, String str) {
        if (zzp(context) && (context instanceof Activity) && zzw(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzg, false)) {
            Method declaredMethod = (Method) this.zzh.get("setCurrentScreen");
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", Activity.class, String.class, String.class);
                    this.zzh.put("setCurrentScreen", declaredMethod);
                } catch (Exception unused) {
                    zzv("setCurrentScreen", false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzg.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception unused2) {
                zzv("setCurrentScreen", false);
            }
        }
    }

    public final boolean zzp(Context context) {
        int iC;
        zzbbn zzbbnVar = zzbbw.zzU;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && !this.zza.get()) {
            if (!((Boolean) n42Var.c.zza(zzbbw.zzaf)).booleanValue()) {
                if (this.zze.get() == -1) {
                    ka2 ka2Var = x32.f.a;
                    ea0 ea0Var = ea0.b;
                    if (ea0Var.c(context, 12451000) != 0 && ((iC = ea0Var.c(context, 12451000)) == 0 || iC == 2)) {
                        k92.h("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zze.set(0);
                    } else {
                        this.zze.set(1);
                    }
                }
                if (this.zze.get() == 1) {
                }
            }
            return true;
        }
        return false;
    }
}
