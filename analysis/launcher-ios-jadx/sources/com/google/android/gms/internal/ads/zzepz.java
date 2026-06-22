package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzepz implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzepz(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    private final Intent zzd() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        return (!((Boolean) n42.d.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) ? this.zzb.registerReceiver(null, intentFilter) : this.zzb.registerReceiver(null, intentFilter, 4);
    }

    private static final boolean zze(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzeqa zzc() {
        double intExtra;
        boolean zZze;
        if (((Boolean) n42.d.c.zza(zzbbw.zzlb)).booleanValue()) {
            BatteryManager batteryManager = (BatteryManager) this.zzb.getSystemService("batterymanager");
            intExtra = batteryManager != null ? ((double) batteryManager.getIntProperty(4)) / 100.0d : -1.0d;
            zZze = (Build.VERSION.SDK_INT < 23 || batteryManager == null) ? zze(zzd()) : batteryManager.isCharging();
        } else {
            Intent intentZzd = zzd();
            boolean zZze2 = zze(intentZzd);
            intExtra = intentZzd != null ? ((double) intentZzd.getIntExtra("level", -1)) / ((double) intentZzd.getIntExtra("scale", -1)) : -1.0d;
            zZze = zZze2;
        }
        return new zzeqa(intExtra, zZze);
    }
}
