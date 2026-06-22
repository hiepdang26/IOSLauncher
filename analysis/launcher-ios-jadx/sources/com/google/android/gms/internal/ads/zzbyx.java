package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import defpackage.nj;
import defpackage.tb2;
import defpackage.us;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyx {
    private final nj zza;
    private final zzbzi zzb;
    private final String zze;
    private final String zzf;
    private final Object zzd = new Object();
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = 0;
    private long zzj = -1;
    private long zzk = -1;
    private final LinkedList zzc = new LinkedList();

    public zzbyx(nj njVar, zzbzi zzbziVar, String str, String str2) {
        this.zza = njVar;
        this.zzb = zzbziVar;
        this.zze = str;
        this.zzf = str2;
    }

    public final Bundle zza() {
        Bundle bundle;
        synchronized (this.zzd) {
            try {
                bundle = new Bundle();
                bundle.putString("seq_num", this.zze);
                bundle.putString("slotid", this.zzf);
                bundle.putBoolean("ismediation", false);
                bundle.putLong("treq", this.zzj);
                bundle.putLong("tresponse", this.zzk);
                bundle.putLong("timp", this.zzg);
                bundle.putLong("tload", this.zzh);
                bundle.putLong("pcc", this.zzi);
                bundle.putLong("tfetch", -1L);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzbyw) it.next()).zzb());
                }
                bundle.putParcelableArrayList("tclick", arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bundle;
    }

    public final String zzc() {
        return this.zze;
    }

    public final void zzd() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1) {
                    zzbyw zzbywVar = new zzbyw(this);
                    zzbywVar.zzd();
                    this.zzc.add(zzbywVar);
                    this.zzi++;
                    this.zzb.zzf();
                    this.zzb.zze(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1 && !this.zzc.isEmpty()) {
                    zzbyw zzbywVar = (zzbyw) this.zzc.getLast();
                    if (zzbywVar.zza() == -1) {
                        zzbywVar.zzc();
                        this.zzb.zze(this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1 && this.zzg == -1) {
                    ((us) this.zza).getClass();
                    this.zzg = SystemClock.elapsedRealtime();
                    this.zzb.zze(this);
                }
                this.zzb.zzg();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zzb.zzh();
        }
    }

    public final void zzh(boolean z) {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1) {
                    ((us) this.zza).getClass();
                    this.zzh = SystemClock.elapsedRealtime();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zzb.zzi();
        }
    }

    public final void zzj(tb2 tb2Var) {
        synchronized (this.zzd) {
            ((us) this.zza).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzj = jElapsedRealtime;
            this.zzb.zzj(tb2Var, jElapsedRealtime);
        }
    }

    public final void zzk(long j) {
        synchronized (this.zzd) {
            try {
                this.zzk = j;
                if (j != -1) {
                    this.zzb.zze(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
