package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwk extends zzfrx {
    private final Context zza;
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdwj zzf;
    private boolean zzg;

    public zzdwk(Context context) {
        super("ShakeDetector", "ads");
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfrx
    public final void zza(SensorEvent sensorEvent) {
        zzbbn zzbbnVar = zzbbw.zzie;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0] / 9.80665f;
            float f2 = fArr[1] / 9.80665f;
            float f3 = fArr[2] / 9.80665f;
            float f4 = f3 * f3;
            float fSqrt = (float) Math.sqrt(f4 + (f2 * f2) + (f * f));
            zzbbn zzbbnVar2 = zzbbw.zzif;
            zzbbu zzbbuVar = n42Var.c;
            if (fSqrt >= ((Float) zzbbuVar.zza(zzbbnVar2)).floatValue()) {
                hd2.B.j.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzbbuVar.zza(zzbbw.zzig)).intValue()) <= jCurrentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzbbuVar.zza(zzbbw.zzih)).intValue()) < jCurrentTimeMillis) {
                        this.zze = 0;
                    }
                    k92.a("Shake detected.");
                    this.zzd = jCurrentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzdwj zzdwjVar = this.zzf;
                    if (zzdwjVar == null || i != ((Integer) zzbbuVar.zza(zzbbw.zzii)).intValue()) {
                        return;
                    }
                    zzdvi zzdviVar = (zzdvi) zzdwjVar;
                    zzdviVar.zzh(new zzdvf(zzdviVar), zzdvh.GESTURE);
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            try {
                if (this.zzg) {
                    SensorManager sensorManager = this.zzb;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(this, this.zzc);
                        k92.a("Stopped listening for shake gestures.");
                    }
                    this.zzg = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                zzbbn zzbbnVar = zzbbw.zzie;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                    if (this.zzb == null) {
                        SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                        this.zzb = sensorManager2;
                        if (sensorManager2 == null) {
                            k92.h("Shake detection failed to initialize. Failed to obtain accelerometer.");
                            return;
                        }
                        this.zzc = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        hd2.B.j.getClass();
                        this.zzd = System.currentTimeMillis() - ((long) ((Integer) n42Var.c.zza(zzbbw.zzig)).intValue());
                        this.zzg = true;
                        k92.a("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(zzdwj zzdwjVar) {
        this.zzf = zzdwjVar;
    }
}
