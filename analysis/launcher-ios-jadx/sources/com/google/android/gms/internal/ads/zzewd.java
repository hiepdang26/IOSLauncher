package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzewd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzewd(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 39;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzewb zzc() {
        int i;
        boolean zIsActiveNetworkMetered;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        int i4 = -1;
        if (cd2.a(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int iOrdinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = iOrdinal;
            } else {
                i3 = -1;
            }
            zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
            i2 = i4;
            i = i3;
        } else {
            i = -2;
            zIsActiveNetworkMetered = false;
            i2 = -1;
        }
        return new zzewb(networkOperator, i, hd2Var.e.h(this.zzb), phoneType, zIsActiveNetworkMetered, i2);
    }
}
