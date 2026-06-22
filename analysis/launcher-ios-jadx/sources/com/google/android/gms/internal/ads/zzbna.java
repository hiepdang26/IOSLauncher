package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a62;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import defpackage.t42;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbna {
    private final Context zzb;
    private final String zzc;
    private final or1 zzd;
    private final zzfki zze;
    private final t42 zzf;
    private final t42 zzg;
    private zzbmz zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbna(Context context, or1 or1Var, String str, t42 t42Var, t42 t42Var2, zzfki zzfkiVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = or1Var;
        this.zze = zzfkiVar;
        this.zzf = t42Var;
        this.zzg = t42Var2;
    }

    public final zzbmu zzb(zzauo zzauoVar) {
        k92.a("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                k92.a("getEngine: Lock acquired");
                k92.a("refreshIfDestroyed: Trying to acquire lock");
                synchronized (this.zza) {
                    try {
                        k92.a("refreshIfDestroyed: Lock acquired");
                        zzbmz zzbmzVar = this.zzh;
                        if (zzbmzVar != null && this.zzi == 0) {
                            zzbmzVar.zzj(new zzbzx() { // from class: com.google.android.gms.internal.ads.zzbmg
                                @Override // com.google.android.gms.internal.ads.zzbzx
                                public final void zza(Object obj) {
                                    this.zza.zzk((zzblv) obj);
                                }
                            }, new zzbzv() { // from class: com.google.android.gms.internal.ads.zzbmh
                                @Override // com.google.android.gms.internal.ads.zzbzv
                                public final void zza() {
                                }
                            });
                        }
                    } finally {
                    }
                }
                k92.a("refreshIfDestroyed: Lock released");
                zzbmz zzbmzVar2 = this.zzh;
                if (zzbmzVar2 != null && zzbmzVar2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        k92.a("getEngine (NO_UPDATE): Lock released");
                        return this.zzh.zza();
                    }
                    if (i != 1) {
                        k92.a("getEngine (UPDATING): Lock released");
                        return this.zzh.zza();
                    }
                    this.zzi = 2;
                    zzd(null);
                    k92.a("getEngine (PENDING_UPDATE): Lock released");
                    return this.zzh.zza();
                }
                this.zzi = 2;
                this.zzh = zzd(null);
                k92.a("getEngine (NULL or REJECTED): Lock released");
                return this.zzh.zza();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbmz zzd(zzauo zzauoVar) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zzb, 6);
        zzfjuVarZza.zzi();
        final zzbmz zzbmzVar = new zzbmz(this.zzg);
        k92.a("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzauo zzauoVar2 = null;
        zzbzo.zze.execute(new Runnable(zzauoVar2, zzbmzVar) { // from class: com.google.android.gms.internal.ads.zzbmk
            public final /* synthetic */ zzbmz zzb;

            {
                this.zzb = zzbmzVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(null, this.zzb);
            }
        });
        k92.a("loadNewJavascriptEngine: Promise created");
        zzbmzVar.zzj(new zzbmp(this, zzbmzVar, zzfjuVarZza), new zzbmq(this, zzbmzVar, zzfjuVarZza));
        return zzbmzVar;
    }

    public final void zzi(zzbmz zzbmzVar, final zzblv zzblvVar, ArrayList arrayList, long j) {
        k92.a("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            try {
                k92.a("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
                if (zzbmzVar.zze() != -1 && zzbmzVar.zze() != 1) {
                    zzbbn zzbbnVar = zzbbw.zzgS;
                    n42 n42Var = n42.d;
                    if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                        zzbmzVar.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbmzVar.zzg();
                    }
                    zzgcu zzgcuVar = zzbzo.zze;
                    Objects.requireNonNull(zzblvVar);
                    zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzblvVar.zzc();
                        }
                    });
                    String strValueOf = String.valueOf(n42Var.c.zza(zzbbw.zzb));
                    int iZze = zzbmzVar.zze();
                    int i = this.zzi;
                    String strValueOf2 = String.valueOf(arrayList.get(0));
                    hd2.B.j.getClass();
                    k92.a("Could not receive /jsLoaded in " + strValueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + iZze + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + strValueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + (System.currentTimeMillis() - j) + " ms. Rejecting.");
                    k92.a("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
                k92.a("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj(zzauo zzauoVar, zzbmz zzbmzVar) {
        hd2.B.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            k92.a("loadJavascriptEngine > Before createJavascriptEngine");
            zzbmd zzbmdVar = new zzbmd(this.zzb, this.zzd, null, null);
            k92.a("loadJavascriptEngine > After createJavascriptEngine");
            k92.a("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbmdVar.zzk(new zzbmj(this, arrayList, jCurrentTimeMillis, zzbmzVar, zzbmdVar));
            k92.a("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbmdVar.zzq("/jsLoaded", new zzbml(this, jCurrentTimeMillis, zzbmzVar, zzbmdVar));
            a62 a62Var = new a62();
            zzbmm zzbmmVar = new zzbmm(this, null, zzbmdVar, a62Var);
            a62Var.a = zzbmmVar;
            k92.a("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbmdVar.zzq("/requestReload", zzbmmVar);
            k92.a("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                k92.a("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbmdVar.zzh(this.zzc);
                k92.a("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                k92.a("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbmdVar.zzf(this.zzc);
                k92.a("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                k92.a("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbmdVar.zzg(this.zzc);
                k92.a("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            k92.a("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            cd2.l.postDelayed(new zzbmo(this, zzbmzVar, zzbmdVar, arrayList, jCurrentTimeMillis), ((Integer) n42.d.c.zza(zzbbw.zzc)).intValue());
        } catch (Throwable th) {
            k92.f();
            zzbbn zzbbnVar = zzbbw.zzgS;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                zzbmzVar.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) n42Var.c.zza(zzbbw.zzgU)).booleanValue()) {
                hd2.B.g.zzv(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbmzVar.zzg();
            } else {
                hd2.B.g.zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbmzVar.zzg();
            }
        }
    }

    public final /* synthetic */ void zzk(zzblv zzblvVar) {
        if (zzblvVar.zzi()) {
            this.zzi = 1;
        }
    }
}
