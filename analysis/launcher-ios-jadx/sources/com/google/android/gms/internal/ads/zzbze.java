package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.do0;
import defpackage.e42;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.j02;
import defpackage.k92;
import defpackage.n42;
import defpackage.nc2;
import defpackage.or1;
import defpackage.os;
import defpackage.x32;
import defpackage.za2;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzbze {
    private final Object zza = new Object();
    private final ib2 zzb;
    private final zzbzi zzc;
    private boolean zzd;
    private Context zze;
    private or1 zzf;
    private String zzg;
    private zzbcb zzh;
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzbzd zzl;
    private final Object zzm;
    private do0 zzn;
    private final AtomicBoolean zzo;

    public zzbze() {
        ib2 ib2Var = new ib2();
        this.zzb = ib2Var;
        this.zzc = new zzbzi(x32.f.c, ib2Var);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzbzd(null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public final boolean zzA(Context context) {
        if (os.j()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzhC)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    public final Context zzd() {
        return this.zze;
    }

    public final Resources zze() {
        if (this.zzf.j) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) n42.d.c.zza(zzbbw.zzjV)).booleanValue()) {
                return e42.x(this.zze).a.getResources();
            }
            e42.x(this.zze).a.getResources();
            return null;
        } catch (nc2 unused) {
            k92.j(5);
            return null;
        }
    }

    public final zzbcb zzg() {
        zzbcb zzbcbVar;
        synchronized (this.zza) {
            zzbcbVar = this.zzh;
        }
        return zzbcbVar;
    }

    public final zzbzi zzh() {
        return this.zzc;
    }

    public final za2 zzi() {
        ib2 ib2Var;
        synchronized (this.zza) {
            ib2Var = this.zzb;
        }
        return ib2Var;
    }

    public final do0 zzk() {
        if (this.zze != null) {
            if (!((Boolean) n42.d.c.zza(zzbbw.zzcv)).booleanValue()) {
                synchronized (this.zzm) {
                    try {
                        do0 do0Var = this.zzn;
                        if (do0Var != null) {
                            return do0Var;
                        }
                        do0 do0VarZzb = zzbzo.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzbyz
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return this.zza.zzo();
                            }
                        });
                        this.zzn = do0VarZzb;
                        return do0VarZzb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return zzgcj.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    public final /* synthetic */ ArrayList zzo() {
        Context contextZza = zzbvl.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfoG = j02.a(contextZza).g(MotionScene.Transition.TransitionOnClick.JUMP_TO_START, contextZza.getApplicationInfo().packageName);
            if (packageInfoG.requestedPermissions != null && packageInfoG.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfoG.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfoG.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    public final void zzu(Context context, or1 or1Var) {
        zzbcb zzbcbVar;
        synchronized (this.zza) {
            try {
                if (!this.zzd) {
                    this.zze = context.getApplicationContext();
                    this.zzf = or1Var;
                    hd2.B.f.zzc(this.zzc);
                    this.zzb.D(this.zze);
                    zzbtq.zzb(this.zze, this.zzf);
                    zzbbn zzbbnVar = zzbbw.zzbN;
                    n42 n42Var = n42.d;
                    if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                        zzbcbVar = new zzbcb();
                    } else {
                        k92.a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                        zzbcbVar = null;
                    }
                    this.zzh = zzbcbVar;
                    if (zzbcbVar != null) {
                        zzbzr.zza(new zzbza(this).zzb(), "AppState.registerCsiReporter");
                    }
                    if (os.j()) {
                        if (((Boolean) n42Var.c.zza(zzbbw.zzhC)).booleanValue()) {
                            try {
                                ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzbzb(this));
                            } catch (RuntimeException unused) {
                                k92.j(5);
                                this.zzo.set(true);
                            }
                        }
                    }
                    this.zzd = true;
                    zzk();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        hd2.B.c.w(context, or1Var.g);
    }

    public final void zzv(Throwable th, String str) {
        zzbtq.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbeb.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbtq.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzx(Throwable th, String str) {
        zzbtq.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzy(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzz(String str) {
        this.zzg = str;
    }
}
