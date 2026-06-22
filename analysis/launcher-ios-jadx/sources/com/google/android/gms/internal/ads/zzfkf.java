package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import defpackage.j92;
import defpackage.n42;
import defpackage.wd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkf implements Runnable {
    private final zzfki zzb;
    private String zzc;
    private String zze;
    private zzfew zzf;
    private j92 zzg;
    private Future zzh;
    private final List zza = new ArrayList();
    private int zzi = 2;
    private zzfkl zzd = zzfkl.SCAR_REQUEST_TYPE_UNSPECIFIED;

    public zzfkf(zzfki zzfkiVar) {
        this.zzb = zzfkiVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzfkf zza(zzfju zzfjuVar) {
        try {
            if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                List list = this.zza;
                zzfjuVar.zzj();
                list.add(zzfjuVar);
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                this.zzh = zzbzo.zzd.schedule(this, ((Integer) n42.d.c.zza(zzbbw.zzhT)).intValue(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfkf zzb(String str) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue() && zzfke.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfkf zzc(j92 j92Var) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzg = j92Var;
        }
        return this;
    }

    public final synchronized zzfkf zzd(ArrayList arrayList) {
        try {
            if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                if (arrayList.contains("banner") || arrayList.contains("BANNER")) {
                    this.zzi = 3;
                } else if (arrayList.contains("interstitial") || arrayList.contains("INTERSTITIAL")) {
                    this.zzi = 4;
                } else if (arrayList.contains("native") || arrayList.contains("NATIVE")) {
                    this.zzi = 8;
                } else if (arrayList.contains("rewarded") || arrayList.contains("REWARDED")) {
                    this.zzi = 5;
                } else if (arrayList.contains("app_open_ad")) {
                    this.zzi = 7;
                } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains("REWARDED_INTERSTITIAL")) {
                    this.zzi = 6;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfkf zze(String str) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzfkf zzf(Bundle bundle) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzd = wd.L(bundle);
        }
        return this;
    }

    public final synchronized zzfkf zzg(zzfew zzfewVar) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzf = zzfewVar;
        }
        return this;
    }

    public final synchronized void zzh() {
        try {
            if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                Future future = this.zzh;
                if (future != null) {
                    future.cancel(false);
                }
                for (zzfju zzfjuVar : this.zza) {
                    int i = this.zzi;
                    if (i != 2) {
                        zzfjuVar.zzn(i);
                    }
                    if (!TextUtils.isEmpty(this.zzc)) {
                        zzfjuVar.zze(this.zzc);
                    }
                    if (!TextUtils.isEmpty(this.zze) && !zzfjuVar.zzl()) {
                        zzfjuVar.zzd(this.zze);
                    }
                    zzfew zzfewVar = this.zzf;
                    if (zzfewVar != null) {
                        zzfjuVar.zzb(zzfewVar);
                    } else {
                        j92 j92Var = this.zzg;
                        if (j92Var != null) {
                            zzfjuVar.zza(j92Var);
                        }
                    }
                    zzfjuVar.zzf(this.zzd);
                    this.zzb.zzb(zzfjuVar.zzm());
                }
                this.zza.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzfkf zzi(int i) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
