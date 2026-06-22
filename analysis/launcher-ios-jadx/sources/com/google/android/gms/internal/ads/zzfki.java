package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import defpackage.cd2;
import defpackage.ea0;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfki implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final or1 zzf;
    private int zzi;
    private final zzdpy zzj;
    private final List zzk;
    private final zzbvj zzm;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfko zzg = zzfkr.zzc();
    private String zzh = "";
    private boolean zzl = false;

    public zzfki(Context context, or1 or1Var, zzdpy zzdpyVar, zzebn zzebnVar, zzbvj zzbvjVar) {
        this.zze = context;
        this.zzf = or1Var;
        this.zzj = zzdpyVar;
        this.zzm = zzbvjVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzhW)).booleanValue()) {
            this.zzk = cd2.x();
        } else {
            this.zzk = zzfxr.zzm();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    if (((Boolean) zzbdl.zzb.zze()).booleanValue()) {
                        zzb = Boolean.valueOf(Math.random() < ((Double) zzbdl.zza.zze()).doubleValue());
                    } else {
                        zzb = Boolean.FALSE;
                    }
                }
                zBooleanValue = zzb.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                try {
                    if (this.zzg.zza() == 0) {
                        return;
                    }
                    try {
                        synchronized (obj) {
                            bArrZzaV = ((zzfkr) this.zzg.zzbr()).zzaV();
                            this.zzg.zzc();
                        }
                        new zzebm(this.zze, this.zzf.g, this.zzm, Binder.getCallingUid()).zza(new zzebk((String) n42.d.c.zza(zzbbw.zzhQ), 60000, new HashMap(), bArrZzaV, "application/x-protobuf", false));
                    } catch (Exception e) {
                        if ((e instanceof zzdwl) && ((zzdwl) e).zza() == 3) {
                            return;
                        }
                        hd2.B.g.zzv(e, "CuiMonitor.sendCuiPing");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzb(final zzfjy zzfjyVar) {
        zzbzo.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfkh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(zzfjyVar);
            }
        });
    }

    public final void zzc(zzfjy zzfjyVar) {
        synchronized (zzd) {
            try {
                if (!this.zzl) {
                    this.zzl = true;
                    if (zza()) {
                        try {
                            cd2 cd2Var = hd2.B.c;
                            this.zzh = cd2.E(this.zze);
                        } catch (RemoteException | RuntimeException e) {
                            hd2.B.g.zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                        }
                        ea0 ea0Var = ea0.b;
                        Context context = this.zze;
                        ea0Var.getClass();
                        this.zzi = ea0.a(context);
                        zzbbn zzbbnVar = zzbbw.zzhR;
                        n42 n42Var = n42.d;
                        int iIntValue = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
                        if (((Boolean) n42Var.c.zza(zzbbw.zzkT)).booleanValue()) {
                            long j = iIntValue;
                            zzbzo.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                        } else {
                            long j2 = iIntValue;
                            zzbzo.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                        }
                    }
                }
            } finally {
            }
        }
        if (zza() && zzfjyVar != null) {
            synchronized (zzc) {
                try {
                    int iZza = this.zzg.zza();
                    zzbbn zzbbnVar2 = zzbbw.zzhS;
                    n42 n42Var2 = n42.d;
                    if (iZza >= ((Integer) n42Var2.c.zza(zzbbnVar2)).intValue()) {
                        return;
                    }
                    zzfkk zzfkkVarZza = zzfkm.zza();
                    zzfkkVarZza.zzu(zzfjyVar.zzm());
                    zzfkkVarZza.zzq(zzfjyVar.zzl());
                    zzfkkVarZza.zzg(zzfjyVar.zzb());
                    zzfkkVarZza.zzw(3);
                    zzfkkVarZza.zzn(this.zzf.g);
                    zzfkkVarZza.zzb(this.zzh);
                    zzfkkVarZza.zzk(Build.VERSION.RELEASE);
                    zzfkkVarZza.zzr(Build.VERSION.SDK_INT);
                    zzfkkVarZza.zzv(zzfjyVar.zzo());
                    zzfkkVarZza.zzj(zzfjyVar.zza());
                    zzfkkVarZza.zze(this.zzi);
                    zzfkkVarZza.zzt(zzfjyVar.zzn());
                    zzfkkVarZza.zzc(zzfjyVar.zze());
                    zzfkkVarZza.zzf(zzfjyVar.zzg());
                    zzfkkVarZza.zzh(zzfjyVar.zzh());
                    zzfkkVarZza.zzi(this.zzj.zzb(zzfjyVar.zzh()));
                    zzfkkVarZza.zzl(zzfjyVar.zzi());
                    zzfkkVarZza.zzm(zzfjyVar.zzd());
                    zzfkkVarZza.zzd(zzfjyVar.zzf());
                    zzfkkVarZza.zzs(zzfjyVar.zzk());
                    zzfkkVarZza.zzo(zzfjyVar.zzj());
                    zzfkkVarZza.zzp(zzfjyVar.zzc());
                    if (((Boolean) n42Var2.c.zza(zzbbw.zzhW)).booleanValue()) {
                        zzfkkVarZza.zza(this.zzk);
                    }
                    zzfko zzfkoVar = this.zzg;
                    zzfkp zzfkpVarZza = zzfkq.zza();
                    zzfkpVarZza.zza(zzfkkVarZza);
                    zzfkoVar.zzb(zzfkpVarZza);
                } finally {
                }
            }
        }
    }
}
