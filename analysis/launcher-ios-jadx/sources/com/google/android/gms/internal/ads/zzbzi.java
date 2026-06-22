package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.nj;
import defpackage.tb2;
import defpackage.za2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzi implements zzayp {
    final zzbzf zza;
    private final za2 zze;
    private final Object zzd = new Object();
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private boolean zzg = false;
    private final zzbzg zzf = new zzbzg();

    public zzbzi(String str, za2 za2Var) {
        this.zza = new zzbzf(str, za2Var);
        this.zze = za2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final void zza(boolean z) {
        hd2.B.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (jCurrentTimeMillis - ((ib2) this.zze).u() > ((Long) n42.d.c.zza(zzbbw.zzaK)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = ((ib2) this.zze).t();
            }
            this.zzg = true;
            return;
        }
        ib2 ib2Var = (ib2) this.zze;
        ib2Var.r();
        synchronized (ib2Var.a) {
            try {
                if (ib2Var.o != jCurrentTimeMillis) {
                    ib2Var.o = jCurrentTimeMillis;
                    SharedPreferences.Editor editor = ib2Var.g;
                    if (editor != null) {
                        editor.putLong("app_last_background_time_ms", jCurrentTimeMillis);
                        ib2Var.g.apply();
                    }
                    ib2Var.s();
                }
            } finally {
            }
        }
        ((ib2) this.zze).j(this.zza.zzd);
    }

    public final int zzb() {
        int iZza;
        synchronized (this.zzd) {
            iZza = this.zza.zza();
        }
        return iZza;
    }

    public final zzbyx zzc(nj njVar, String str) {
        return new zzbyx(njVar, this, this.zzf.zza(), str);
    }

    public final String zzd() {
        return this.zzf.zzb();
    }

    public final void zze(zzbyx zzbyxVar) {
        synchronized (this.zzd) {
            this.zzb.add(zzbyxVar);
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zza.zzf();
        }
    }

    public final void zzj(tb2 tb2Var, long j) {
        synchronized (this.zzd) {
            this.zza.zzg(tb2Var, j);
        }
    }

    public final void zzk() {
        synchronized (this.zzd) {
            this.zza.zzh();
        }
    }

    public final void zzl(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzm() {
        return this.zzg;
    }

    public final Bundle zzn(Context context, zzfgo zzfgoVar) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zzb(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (it.hasNext()) {
            throw null;
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((zzbyx) it2.next()).zza());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzfgoVar.zzc(hashSet);
        return bundle;
    }
}
