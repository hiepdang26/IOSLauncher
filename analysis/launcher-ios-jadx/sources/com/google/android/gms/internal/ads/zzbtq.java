package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import defpackage.ea0;
import defpackage.j02;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.or1;
import defpackage.tc2;
import defpackage.uo;
import defpackage.x32;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtq implements zzbts {
    public static zzbts zza;
    static zzbts zzb;
    static zzbts zzc;
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final or1 zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbtq(android.content.Context r4, defpackage.or1 r5) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.zzf = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r3.zzh = r0
            com.google.android.gms.internal.ads.zzfrt.zza()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r3.zzi = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r3.zzn = r0
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto L2f
            android.content.Context r4 = r4.getApplicationContext()
        L2f:
            r3.zzg = r4
            r3.zzj = r5
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzgX
            n42 r0 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r0 = r0.c
            java.lang.Object r5 = r0.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0 = 0
            if (r5 == 0) goto L50
            com.google.android.gms.internal.ads.zzfru r5 = defpackage.ka2.b
            if (r4 == 0) goto L50
            android.content.pm.ApplicationInfo r5 = r4.getApplicationInfo()
            if (r5 != 0) goto L52
        L50:
            r4 = r0
            goto L61
        L52:
            f1 r5 = defpackage.j02.a(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            r1 = 0
            android.content.pm.PackageInfo r4 = r5.g(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
        L61:
            r3.zzk = r4
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzgV
            n42 r5 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r1 = r5.c
            java.lang.Object r1 = r1.zza(r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r2 = "unknown"
            if (r1 == 0) goto L80
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getCountry()
            goto L81
        L80:
            r1 = r2
        L81:
            r3.zzl = r1
            com.google.android.gms.internal.ads.zzbbu r5 = r5.c
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto Lae
            android.content.Context r4 = r3.zzg
            com.google.android.gms.internal.ads.zzfru r5 = defpackage.ka2.b
            if (r4 != 0) goto L98
            goto Laf
        L98:
            f1 r4 = defpackage.j02.a(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Laf
            java.lang.String r5 = "com.android.vending"
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.PackageInfo r4 = r4.g(r1, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Laf
            if (r4 != 0) goto La7
            goto Laf
        La7:
            int r4 = r4.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Laf
            java.lang.String r0 = java.lang.Integer.toString(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Laf
            goto Laf
        Lae:
            r0 = r2
        Laf:
            r3.zzm = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.<init>(android.content.Context, or1):void");
    }

    public static zzbts zza(Context context) {
        synchronized (zze) {
            try {
                if (zza == null) {
                    if (zzl()) {
                        zza = new zzbtq(context, or1.a());
                    } else {
                        zza = new zzbtr();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static zzbts zzb(Context context, or1 or1Var) {
        synchronized (zze) {
            try {
                if (zzc == null) {
                    boolean z = false;
                    if (((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                        if (!((Boolean) n42.d.c.zza(zzbbw.zzgQ)).booleanValue() || ((Boolean) zzbdk.zza.zze()).booleanValue()) {
                            z = true;
                        }
                    }
                    if (zzl()) {
                        zzbtq zzbtqVar = new zzbtq(context, or1Var);
                        zzbtqVar.zzk();
                        zzbtqVar.zzj();
                        zzc = zzbtqVar;
                    } else if (z) {
                        zzbtq zzbtqVar2 = new zzbtq(context, or1Var, true);
                        zzbtqVar2.zzk();
                        zzbtqVar2.zzj();
                        zzc = zzbtqVar2;
                    } else {
                        zzc = new zzbtr();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x0029, B:13:0x0037, B:14:0x003e), top: B:19:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbts zzc(android.content.Context r4) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbtq.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbts r1 = com.google.android.gms.internal.ads.zzbtq.zzb     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L3e
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgR     // Catch: java.lang.Throwable -> L35
            n42 r2 = defpackage.n42.d     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbbu r3 = r2.c     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r3.zza(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L35
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L37
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgQ     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L35
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L37
            com.google.android.gms.internal.ads.zzbtq r1 = new com.google.android.gms.internal.ads.zzbtq     // Catch: java.lang.Throwable -> L35
            or1 r2 = defpackage.or1.a()     // Catch: java.lang.Throwable -> L35
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbtq.zzb = r1     // Catch: java.lang.Throwable -> L35
            goto L3e
        L35:
            r4 = move-exception
            goto L42
        L37:
            com.google.android.gms.internal.ads.zzbtr r4 = new com.google.android.gms.internal.ads.zzbtr     // Catch: java.lang.Throwable -> L35
            r4.<init>()     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbtq.zzb = r4     // Catch: java.lang.Throwable -> L35
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            com.google.android.gms.internal.ads.zzbts r4 = com.google.android.gms.internal.ads.zzbtq.zzb
            return r4
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.zzc(android.content.Context):com.google.android.gms.internal.ads.zzbts");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x0029, B:13:0x0033, B:14:0x003a), top: B:19:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbts zzd(android.content.Context r4, defpackage.or1 r5) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbtq.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzbts r1 = com.google.android.gms.internal.ads.zzbtq.zzb     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L3a
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgR     // Catch: java.lang.Throwable -> L31
            n42 r2 = defpackage.n42.d     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzbbu r3 = r2.c     // Catch: java.lang.Throwable -> L31
            java.lang.Object r1 = r3.zza(r1)     // Catch: java.lang.Throwable -> L31
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L31
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L33
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgQ     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c     // Catch: java.lang.Throwable -> L31
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L31
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L31
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L33
            com.google.android.gms.internal.ads.zzbtq r1 = new com.google.android.gms.internal.ads.zzbtq     // Catch: java.lang.Throwable -> L31
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzbtq.zzb = r1     // Catch: java.lang.Throwable -> L31
            goto L3a
        L31:
            r4 = move-exception
            goto L3e
        L33:
            com.google.android.gms.internal.ads.zzbtr r4 = new com.google.android.gms.internal.ads.zzbtr     // Catch: java.lang.Throwable -> L31
            r4.<init>()     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzbtq.zzb = r4     // Catch: java.lang.Throwable -> L31
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.internal.ads.zzbts r4 = com.google.android.gms.internal.ads.zzbtq.zzb
            return r4
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L31
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.zzd(android.content.Context, or1):com.google.android.gms.internal.ads.zzbts");
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfvj.zzc(ka2.a(zze(th), "SHA-256"));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbto(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return;
        }
        synchronized (this.zzf) {
            this.zzh.put(thread, Boolean.TRUE);
        }
        thread.setUncaughtExceptionHandler(new zzbtp(this, thread.getUncaughtExceptionHandler()));
    }

    private static boolean zzl() {
        zzbbn zzbbnVar = zzbbw.zzlO;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (((Boolean) zzbeb.zze.zze()).booleanValue()) {
                if (!((Boolean) n42Var.c.zza(zzbbw.zzgQ)).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        synchronized (zze) {
            try {
                if (zzd == null) {
                    zzd = Boolean.valueOf(x32.f.e.nextInt(100) < ((Integer) n42Var.c.zza(zzbbw.zzlL)).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) n42Var.c.zza(zzbbw.zzgQ)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean zJ = false;
            boolean zEquals = false;
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zJ |= ka2.j(stackTraceElement.getClassName());
                    zEquals |= zzbtq.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (!zJ || zEquals) {
                return;
            }
            if (!this.zzo) {
                zzh(th, "");
            }
            if (this.zzn.getAndSet(true) || !((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                return;
            }
            zzbbg.zzc(this.zzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbts
    public final void zzh(Throwable th, String str) {
        if (this.zzo) {
            return;
        }
        zzi(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbts
    public final void zzi(Throwable th, String str, float f) {
        Throwable th2;
        boolean zI;
        String packageName;
        PackageInfo packageInfoG;
        ActivityManager activityManager;
        ActivityManager.MemoryInfo memoryInfo;
        if (this.zzo) {
            return;
        }
        zzfru zzfruVar = ka2.b;
        int i = 0;
        if (((Boolean) zzbeb.zzf.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                boolean z = ((Boolean) n42.d.c.zza(zzbbw.zzbY)).booleanValue() && stackTrace != null && stackTrace.length == 0 && ka2.j(th3.getClass().getName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (ka2.j(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z) {
                    th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String strZze = zze(th);
            String strZzf = ((Boolean) n42.d.c.zza(zzbbw.zzhV)).booleanValue() ? zzf(th) : "";
            double d = f;
            double dRandom = Math.random();
            int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
            if (dRandom < d) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    zI = j02.a(this.zzg).i();
                } catch (Throwable unused) {
                    k92.f();
                    zI = false;
                }
                try {
                    packageName = this.zzg.getPackageName();
                } catch (Throwable unused2) {
                    k92.h("Cannot obtain package name, proceeding.");
                    packageName = "unknown";
                }
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zI)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE);
                int i3 = Build.VERSION.SDK_INT;
                Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("api", String.valueOf(i3));
                String str2 = Build.MANUFACTURER;
                String strI = Build.MODEL;
                if (!strI.startsWith(str2)) {
                    strI = uo.i(str2, " ", strI);
                }
                Uri.Builder builderAppendQueryParameter3 = builderAppendQueryParameter2.appendQueryParameter("device", strI).appendQueryParameter("js", this.zzj.g).appendQueryParameter("appid", packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strZze);
                n42 n42Var = n42.d;
                Uri.Builder builderAppendQueryParameter4 = builderAppendQueryParameter3.appendQueryParameter("eids", TextUtils.join(",", n42Var.a.zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "661295874").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbeb.zzc.zze()));
                Context context = this.zzg;
                ea0.b.getClass();
                Uri.Builder builderAppendQueryParameter5 = builderAppendQueryParameter4.appendQueryParameter("gmscv", String.valueOf(ea0.a(context))).appendQueryParameter("lite", true != this.zzj.k ? "0" : "1");
                if (!TextUtils.isEmpty(strZzf)) {
                    builderAppendQueryParameter5.appendQueryParameter("hash", strZzf);
                }
                zzbbn zzbbnVar = zzbbw.zzgW;
                zzbbu zzbbuVar = n42Var.c;
                if (((Boolean) zzbbuVar.zza(zzbbnVar)).booleanValue()) {
                    Context context2 = this.zzg;
                    if (context2 == null || (activityManager = (ActivityManager) context2.getSystemService("activity")) == null) {
                        memoryInfo = null;
                    } else {
                        memoryInfo = new ActivityManager.MemoryInfo();
                        try {
                            activityManager.getMemoryInfo(memoryInfo);
                        } catch (NullPointerException unused3) {
                            k92.h("Error retrieving the memory information.");
                        }
                    }
                    if (memoryInfo != null) {
                        builderAppendQueryParameter5.appendQueryParameter("available_memory", Long.toString(memoryInfo.availMem));
                        builderAppendQueryParameter5.appendQueryParameter("total_memory", Long.toString(memoryInfo.totalMem));
                        builderAppendQueryParameter5.appendQueryParameter("is_low_memory", true != memoryInfo.lowMemory ? "0" : "1");
                    }
                }
                if (((Boolean) zzbbuVar.zza(zzbbw.zzgV)).booleanValue()) {
                    if (!TextUtils.isEmpty(this.zzl)) {
                        builderAppendQueryParameter5.appendQueryParameter("countrycode", this.zzl);
                    }
                    if (!TextUtils.isEmpty(this.zzm)) {
                        builderAppendQueryParameter5.appendQueryParameter("psv", this.zzm);
                    }
                    Context context3 = this.zzg;
                    if (i3 >= 26) {
                        packageInfoG = WebView.getCurrentWebViewPackage();
                    } else if (context3 == null) {
                        packageInfoG = null;
                    } else {
                        try {
                            packageInfoG = j02.a(context3).g(128, "com.android.webview");
                        } catch (PackageManager.NameNotFoundException unused4) {
                            packageInfoG = null;
                        }
                    }
                    if (packageInfoG != null) {
                        builderAppendQueryParameter5.appendQueryParameter("wvvc", Integer.toString(packageInfoG.versionCode));
                        builderAppendQueryParameter5.appendQueryParameter("wvvn", packageInfoG.versionName);
                        builderAppendQueryParameter5.appendQueryParameter("wvpn", packageInfoG.packageName);
                    }
                }
                PackageInfo packageInfo = this.zzk;
                if (packageInfo != null) {
                    builderAppendQueryParameter5.appendQueryParameter("appvc", String.valueOf(packageInfo.versionCode));
                    builderAppendQueryParameter5.appendQueryParameter("appvn", this.zzk.versionName);
                }
                arrayList2.add(builderAppendQueryParameter5.toString());
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    final String str3 = (String) obj;
                    final tc2 tc2Var = new tc2(null);
                    this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbtn
                        @Override // java.lang.Runnable
                        public final void run() {
                            tc2Var.zza(str3);
                        }
                    });
                }
            }
        }
    }

    public zzbtq(Context context, or1 or1Var, boolean z) {
        this(context, or1Var);
        this.zzo = true;
    }
}
