package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.j92;
import defpackage.n42;
import defpackage.us;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzeil implements zzgcf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzfel zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzflh zze;
    final /* synthetic */ zzfex zzf;
    final /* synthetic */ zzein zzg;

    public zzeil(zzein zzeinVar, long j, zzfeo zzfeoVar, zzfel zzfelVar, String str, zzflh zzflhVar, zzfex zzfexVar) {
        this.zza = j;
        this.zzb = zzfeoVar;
        this.zzc = zzfelVar;
        this.zzd = str;
        this.zze = zzflhVar;
        this.zzf = zzfexVar;
        this.zzg = zzeinVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        Integer numValueOf;
        int i;
        j92 j92VarZzb;
        j92 j92Var;
        ((us) this.zzg.zza).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            numValueOf = null;
            i = 2;
        } else if (th instanceof zzehv) {
            numValueOf = null;
            i = 3;
        } else if (th instanceof CancellationException) {
            numValueOf = null;
            i = 4;
        } else if (th instanceof zzffn) {
            numValueOf = null;
            i = 5;
        } else if (th instanceof zzdwl) {
            int i2 = zzfgi.zza(th).g == 3 ? 1 : 6;
            if (((Boolean) n42.d.c.zza(zzbbw.zzbs)).booleanValue() && (th instanceof zzeex) && (j92VarZzb = ((zzeex) th).zzb()) != null) {
                numValueOf = Integer.valueOf(j92VarZzb.g);
                i = i2;
            } else {
                i = i2;
                numValueOf = null;
            }
        } else {
            numValueOf = null;
            i = 6;
        }
        synchronized (this.zzg) {
            try {
                zzein zzeinVar = this.zzg;
                if (zzeinVar.zze) {
                    zzeinVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzeex ? (zzeex) th : null, jElapsedRealtime);
                    jElapsedRealtime = jElapsedRealtime;
                }
                if (((Boolean) n42.d.c.zza(zzbbw.zzhz)).booleanValue()) {
                    zzfll zzfllVar = this.zzg.zzc;
                    zzflh zzflhVar = this.zze;
                    zzfex zzfexVar = this.zzf;
                    zzfel zzfelVar = this.zzc;
                    zzfllVar.zzd(zzflhVar.zzc(zzfexVar, zzfelVar, zzfelVar.zzn));
                }
                zzein zzeinVar2 = this.zzg;
                if (zzeinVar2.zzg) {
                    return;
                }
                LinkedHashMap linkedHashMap = zzeinVar2.zzd;
                zzfel zzfelVar2 = this.zzc;
                linkedHashMap.put(zzfelVar2, new zzeim(this.zzd, zzfelVar2.zzaf, i, jElapsedRealtime, numValueOf));
                j92 j92VarZza = zzfgi.zza(th);
                int i3 = j92VarZza.g;
                if ((i3 == 3 || i3 == 0) && (j92Var = j92VarZza.j) != null && !j92Var.i.equals("com.google.android.gms.ads")) {
                    j92VarZza = zzfgi.zza(new zzeex(13, j92VarZza.j));
                }
                this.zzg.zzf.zzf(this.zzc, jElapsedRealtime, j92VarZza);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        long j;
        ((us) this.zzg.zza).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            try {
                zzein zzeinVar = this.zzg;
                if (zzeinVar.zze) {
                    j = jElapsedRealtime;
                    zzeinVar.zzb.zza(this.zzb, this.zzc, 0, null, j);
                } else {
                    j = jElapsedRealtime;
                }
                zzein zzeinVar2 = this.zzg;
                if (zzeinVar2.zzg) {
                    return;
                }
                if (zzeinVar2.zzq(this.zzc)) {
                    ((zzeim) this.zzg.zzd.get(this.zzc)).zzd = j;
                } else {
                    LinkedHashMap linkedHashMap = this.zzg.zzd;
                    zzfel zzfelVar = this.zzc;
                    long j2 = j;
                    j = j2;
                    linkedHashMap.put(zzfelVar, new zzeim(this.zzd, zzfelVar.zzaf, 0, j2, null));
                }
                this.zzg.zzf.zzg(this.zzc, j, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
