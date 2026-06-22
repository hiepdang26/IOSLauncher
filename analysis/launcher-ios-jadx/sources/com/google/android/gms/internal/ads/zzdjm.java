package com.google.android.gms.internal.ads;

import defpackage.ug1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjm {
    public static final zzdjm zza = new zzdjm(new zzdjk());
    private final zzbge zzb;
    private final zzbgb zzc;
    private final zzbgr zzd;
    private final zzbgo zze;
    private final zzblq zzf;
    private final ug1 zzg;
    private final ug1 zzh;

    public final zzbgb zza() {
        return this.zzc;
    }

    public final zzbge zzb() {
        return this.zzb;
    }

    public final zzbgh zzc(String str) {
        return (zzbgh) this.zzh.get(str);
    }

    public final zzbgk zzd(String str) {
        return (zzbgk) this.zzg.get(str);
    }

    public final zzbgo zze() {
        return this.zze;
    }

    public final zzbgr zzf() {
        return this.zzd;
    }

    public final zzblq zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.i);
        int i = 0;
        while (true) {
            ug1 ug1Var = this.zzg;
            if (i >= ug1Var.i) {
                return arrayList;
            }
            arrayList.add((String) ug1Var.f(i));
            i++;
        }
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    private zzdjm(zzdjk zzdjkVar) {
        this.zzb = zzdjkVar.zza;
        this.zzc = zzdjkVar.zzb;
        this.zzd = zzdjkVar.zzc;
        this.zzg = new ug1(zzdjkVar.zzf);
        this.zzh = new ug1(zzdjkVar.zzg);
        this.zze = zzdjkVar.zzd;
        this.zzf = zzdjkVar.zze;
    }
}
