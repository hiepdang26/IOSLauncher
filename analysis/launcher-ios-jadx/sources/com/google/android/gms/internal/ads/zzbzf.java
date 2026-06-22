package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.tb2;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzf {
    final String zzf;
    private final za2 zzk;
    long zza = -1;
    long zzb = -1;
    int zzc = -1;
    int zzd = -1;
    long zze = 0;
    private final Object zzj = new Object();
    int zzg = 0;
    int zzh = 0;
    int zzi = 0;

    public zzbzf(String str, za2 za2Var) {
        this.zzf = str;
        this.zzk = za2Var;
    }

    private final void zzi() {
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            synchronized (this.zzj) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final int zza() {
        int i;
        synchronized (this.zzj) {
            i = this.zzi;
        }
        return i;
    }

    public final Bundle zzb(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                bundle = new Bundle();
                if (!((ib2) this.zzk).q()) {
                    bundle.putString("session_id", this.zzf);
                }
                bundle.putLong("basets", this.zzb);
                bundle.putLong("currts", this.zza);
                bundle.putString("seq_num", str);
                bundle.putInt("preqs", this.zzc);
                bundle.putInt("preqs_in_session", this.zzd);
                bundle.putLong("time_in_session", this.zze);
                bundle.putInt("pclick", this.zzg);
                bundle.putInt("pimp", this.zzh);
                Context contextZza = zzbvl.zza(context);
                int identifier = contextZza.getResources().getIdentifier("Theme.Translucent", "style", "android");
                boolean z = false;
                if (identifier == 0) {
                    k92.g("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                } else {
                    try {
                        if (identifier == contextZza.getPackageManager().getActivityInfo(new ComponentName(contextZza.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                            z = true;
                        } else {
                            k92.g("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        k92.h("Fail to fetch AdActivity theme");
                        k92.g("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                }
                bundle.putBoolean("support_transparent_background", z);
                bundle.putInt("consent_form_action_identifier", zza());
            } catch (Throwable th) {
                throw th;
            }
        }
        return bundle;
    }

    public final void zzc() {
        synchronized (this.zzj) {
            this.zzg++;
        }
    }

    public final void zzd() {
        synchronized (this.zzj) {
            this.zzh++;
        }
    }

    public final void zze() {
        zzi();
    }

    public final void zzf() {
        zzi();
    }

    public final void zzg(tb2 tb2Var, long j) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                long jU = ((ib2) this.zzk).u();
                hd2.B.j.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.zzb == -1) {
                    if (jCurrentTimeMillis - jU > ((Long) n42.d.c.zza(zzbbw.zzaK)).longValue()) {
                        this.zzd = -1;
                    } else {
                        this.zzd = ((ib2) this.zzk).t();
                    }
                    this.zzb = j;
                    this.zza = j;
                } else {
                    this.zza = j;
                }
                if (((Boolean) n42.d.c.zza(zzbbw.zzdj)).booleanValue() || (bundle = tb2Var.i) == null || bundle.getInt("gw", 2) != 1) {
                    this.zzc++;
                    int i = this.zzd + 1;
                    this.zzd = i;
                    if (i == 0) {
                        this.zze = 0L;
                        ((ib2) this.zzk).d(jCurrentTimeMillis);
                    } else {
                        this.zze = jCurrentTimeMillis - ((ib2) this.zzk).v();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzh() {
        synchronized (this.zzj) {
            this.zzi++;
        }
    }
}
