package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.or1;
import defpackage.qg0;
import defpackage.u42;
import defpackage.v21;
import defpackage.wb2;
import defpackage.x32;
import defpackage.z42;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcbl {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final or1 zzd;
    private final zzbci zze;
    private final zzbcl zzf;
    private final z42 zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcaq zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = x32.f.e.nextInt(100) < ((Integer) n42.d.c.zza(zzbbw.zzlK)).intValue();
    }

    public zzcbl(Context context, or1 or1Var, String str, zzbcl zzbclVar, zzbci zzbciVar) {
        wb2 wb2Var = new wb2(27);
        wb2Var.E("min_1", Double.MIN_VALUE, 1.0d);
        wb2Var.E("1_5", 1.0d, 5.0d);
        wb2Var.E("5_10", 5.0d, 10.0d);
        wb2Var.E("10_20", 10.0d, 20.0d);
        wb2Var.E("20_30", 20.0d, 30.0d);
        wb2Var.E("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = new z42(wb2Var);
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = or1Var;
        this.zzc = str;
        this.zzf = zzbclVar;
        this.zze = zzbciVar;
        String str2 = (String) n42.d.c.zza(zzbbw.zzu);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException unused) {
                k92.j(5);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcaq zzcaqVar) {
        zzbcd.zza(this.zzf, this.zze, "vpc2");
        this.zzj = true;
        this.zzf.zzd("vpn", zzcaqVar.zzj());
        this.zzo = zzcaqVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbcd.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbcd.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzd() {
        Bundle bundleT;
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzc);
        bundle.putString("player", this.zzo.zzj());
        z42 z42Var = this.zzg;
        z42Var.getClass();
        String[] strArr = z42Var.a;
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            double d = z42Var.c[i];
            double d2 = z42Var.b[i];
            int i2 = z42Var.d[i];
            arrayList.add(new u42(str, d, d2, ((double) i2) / ((double) z42Var.e), i2));
            i++;
            bundle = bundle;
        }
        Bundle bundle2 = bundle;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            u42 u42Var = (u42) obj;
            String strValueOf = String.valueOf(u42Var.a);
            bundle2.putString("fps_c_".concat(strValueOf), Integer.toString(u42Var.e));
            String strValueOf2 = String.valueOf(u42Var.a);
            bundle2.putString("fps_p_".concat(strValueOf2), Double.toString(u42Var.d));
        }
        int i4 = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i4 >= jArr.length) {
                break;
            }
            String str2 = this.zzi[i4];
            if (str2 != null) {
                bundle2.putString("fh_".concat(Long.valueOf(jArr[i4]).toString()), str2);
            }
            i4++;
        }
        final Context context = this.zzb;
        or1 or1Var = this.zzd;
        final cd2 cd2Var = hd2.B.c;
        String str3 = or1Var.g;
        cd2Var.getClass();
        bundle2.putString("device", cd2.G());
        zzbbn zzbbnVar = zzbbw.zza;
        n42 n42Var = n42.d;
        bundle2.putString("eids", TextUtils.join(",", n42Var.a.zza()));
        if (bundle2.isEmpty()) {
            k92.d("Empty or null bundle.");
        } else {
            final String str4 = (String) n42Var.c.zza(zzbbw.zzjG);
            boolean andSet = cd2Var.d.getAndSet(true);
            AtomicReference atomicReference = cd2Var.c;
            if (!andSet) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: zb2
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str5) {
                        cd2Var.c.set(qg0.T(context, str4));
                    }
                };
                if (TextUtils.isEmpty(str4)) {
                    bundleT = Bundle.EMPTY;
                } else {
                    PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    bundleT = qg0.T(context, str4);
                }
                atomicReference.set(bundleT);
            }
            bundle2.putAll((Bundle) atomicReference.get());
        }
        ka2 ka2Var = x32.f.a;
        ka2.m(context, str3, bundle2, new v21(context, str3, 10));
        this.zzp = true;
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcaq zzcaqVar) {
        if (this.zzl && !this.zzm) {
            if (k92.b() && !this.zzm) {
                k92.a("VideoMetricsMixin first frame");
            }
            zzbcd.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        hd2.B.j.getClass();
        long jNanoTime = System.nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            long j = jNanoTime - this.zzr;
            z42 z42Var = this.zzg;
            double d = nanos / j;
            z42Var.e++;
            int i = 0;
            while (true) {
                double[] dArr = z42Var.c;
                if (i >= dArr.length) {
                    break;
                }
                double d2 = dArr[i];
                if (d2 <= d && d < z42Var.b[i]) {
                    int[] iArr = z42Var.d;
                    iArr[i] = iArr[i] + 1;
                }
                if (d < d2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.zzq = this.zzn;
        this.zzr = jNanoTime;
        long jLongValue = ((Long) n42.d.c.zza(zzbbw.zzv)).longValue();
        long jZza = zzcaqVar.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && jLongValue > Math.abs(jZza - this.zzh[i2])) {
                String[] strArr2 = this.zzi;
                int i3 = 8;
                Bitmap bitmap = zzcaqVar.getBitmap(8, 8);
                long j2 = 63;
                long j3 = 0;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        j3 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1L : 0L) << ((int) j2);
                        j2--;
                        i5++;
                        i3 = 8;
                    }
                    i4++;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i2++;
        }
    }
}
