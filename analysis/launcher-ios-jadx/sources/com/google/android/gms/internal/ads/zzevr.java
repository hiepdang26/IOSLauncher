package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzevr {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfkf zzd;
    private final zzdsk zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzevr(Context context, Executor executor, Set set, zzfkf zzfkfVar, zzdsk zzdskVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfkfVar;
        this.zze = zzdskVar;
    }

    public final do0 zza(final Object obj, final Bundle bundle) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zza, 8);
        zzfjuVarZza.zzi();
        final ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        zzbbn zzbbnVar = zzbbw.zzkQ;
        n42 n42Var = n42.d;
        boolean zIsEmpty = ((String) n42Var.c.zza(zzbbnVar)).isEmpty();
        zzbbu zzbbuVar = n42Var.c;
        if (!zIsEmpty) {
            arrayList2 = Arrays.asList(((String) zzbbuVar.zza(zzbbnVar)).split(","));
        }
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        this.zzf = SystemClock.elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) zzbbuVar.zza(zzbbw.zzbS)).booleanValue() && bundle != null) {
            hd2Var.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdrt.CLIENT_SIGNALS_START.zza(), jCurrentTimeMillis);
            } else {
                bundle.putLong(zzdrt.GMS_SIGNALS_START.zza(), jCurrentTimeMillis);
            }
        }
        for (final zzevo zzevoVar : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzevoVar.zza()))) {
                if (!((Boolean) n42.d.c.zza(zzbbw.zzfo)).booleanValue() || zzevoVar.zza() != 44) {
                    hd2.B.j.getClass();
                    final long jElapsedRealtime = SystemClock.elapsedRealtime();
                    do0 do0VarZzb = zzevoVar.zzb();
                    do0VarZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzevp
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzb(jElapsedRealtime, zzevoVar, bundle2);
                        }
                    }, zzbzo.zzf);
                    arrayList.add(do0VarZzb);
                }
            }
        }
        do0 do0VarZza = zzgcj.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzevq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzevn zzevnVar = (zzevn) ((do0) it.next()).get();
                    if (zzevnVar != null) {
                        zzevnVar.zzj(obj2);
                    }
                }
                if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && (bundle3 = bundle) != null) {
                    Bundle bundle4 = bundle2;
                    hd2.B.j.getClass();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (obj2 instanceof Bundle) {
                        bundle3.putLong(zzdrt.CLIENT_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                        return obj2;
                    }
                    bundle3.putLong(zzdrt.GMS_SIGNALS_END.zza(), jCurrentTimeMillis2);
                    bundle3.putBundle("gms_sig_latency_key", bundle4);
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfki.zza()) {
            zzfke.zza(do0VarZza, this.zzd, zzfjuVarZza);
        }
        return do0VarZza;
    }

    public final void zzb(long j, zzevo zzevoVar, Bundle bundle) {
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (((Boolean) zzbdu.zza.zze()).booleanValue()) {
            k92.a("Signal runtime (ms) : " + zzfvj.zzc(zzevoVar.getClass().getCanonicalName()) + " = " + jElapsedRealtime);
        }
        zzbbn zzbbnVar = zzbbw.zzbS;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (((Boolean) n42Var.c.zza(zzbbw.zzbT)).booleanValue()) {
                synchronized (this) {
                    bundle.putLong("sig" + zzevoVar.zza(), jElapsedRealtime);
                }
            }
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzbQ)).booleanValue()) {
            zzdsj zzdsjVarZza = this.zze.zza();
            zzdsjVarZza.zzb("action", "lat_ms");
            zzdsjVarZza.zzb("lat_grp", "sig_lat_grp");
            zzdsjVarZza.zzb("lat_id", String.valueOf(zzevoVar.zza()));
            zzdsjVarZza.zzb("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) n42Var.c.zza(zzbbw.zzbR)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zzdsjVarZza.zzb("seq_num", hd2Var.g.zzh().zzd());
                synchronized (this) {
                    try {
                        if (this.zzg == this.zzb.size() && this.zzf != 0) {
                            this.zzg = 0;
                            hd2Var.j.getClass();
                            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.zzf);
                            if (zzevoVar.zza() <= 39 || zzevoVar.zza() >= 52) {
                                zzdsjVarZza.zzb("lat_clsg", strValueOf);
                            } else {
                                zzdsjVarZza.zzb("lat_gmssg", strValueOf);
                            }
                        }
                    } finally {
                    }
                }
            }
            zzdsjVarZza.zzg();
        }
    }
}
