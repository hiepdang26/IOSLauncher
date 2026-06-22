package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.a41;
import defpackage.hg0;
import defpackage.p2;
import defpackage.pd2;
import defpackage.rc2;
import defpackage.ta2;
import defpackage.tb2;
import defpackage.u62;
import defpackage.y62;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzffe {
    private tb2 zza;
    private rc2 zzb;
    private String zzc;
    private ta2 zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbes zzh;
    private pd2 zzi;
    private p2 zzj;
    private a41 zzk;
    private u62 zzl;
    private zzblh zzn;
    private zzemk zzr;
    private Bundle zzt;
    private y62 zzu;
    private int zzm = 1;
    private final zzfer zzo = new zzfer();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;

    public final zzffe zzA(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzffe zzB(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzffe zzC(int i) {
        this.zzm = i;
        return this;
    }

    public final zzffe zzD(zzbes zzbesVar) {
        this.zzh = zzbesVar;
        return this;
    }

    public final zzffe zzE(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzffe zzF(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzffe zzG(a41 a41Var) {
        this.zzk = a41Var;
        if (a41Var != null) {
            this.zze = a41Var.g;
            this.zzl = a41Var.h;
        }
        return this;
    }

    public final zzffe zzH(tb2 tb2Var) {
        this.zza = tb2Var;
        return this;
    }

    public final zzffe zzI(ta2 ta2Var) {
        this.zzd = ta2Var;
        return this;
    }

    public final zzffg zzJ() {
        hg0.j(this.zzc, "ad unit must not be null");
        hg0.j(this.zzb, "ad size must not be null");
        hg0.j(this.zza, "ad request must not be null");
        return new zzffg(this, null);
    }

    public final String zzL() {
        return this.zzc;
    }

    public final boolean zzS() {
        return this.zzp;
    }

    public final boolean zzT() {
        return this.zzq;
    }

    public final zzffe zzV(y62 y62Var) {
        this.zzu = y62Var;
        return this;
    }

    public final tb2 zzf() {
        return this.zza;
    }

    public final rc2 zzh() {
        return this.zzb;
    }

    public final zzfer zzp() {
        return this.zzo;
    }

    public final zzffe zzq(zzffg zzffgVar) {
        this.zzo.zza(zzffgVar.zzo.zza);
        this.zza = zzffgVar.zzd;
        this.zzb = zzffgVar.zze;
        this.zzu = zzffgVar.zzt;
        this.zzc = zzffgVar.zzf;
        this.zzd = zzffgVar.zza;
        this.zzf = zzffgVar.zzg;
        this.zzg = zzffgVar.zzh;
        this.zzh = zzffgVar.zzi;
        this.zzi = zzffgVar.zzj;
        zzr(zzffgVar.zzl);
        zzG(zzffgVar.zzm);
        this.zzp = zzffgVar.zzp;
        this.zzq = zzffgVar.zzq;
        this.zzr = zzffgVar.zzc;
        this.zzs = zzffgVar.zzr;
        this.zzt = zzffgVar.zzs;
        return this;
    }

    public final zzffe zzr(p2 p2Var) {
        this.zzj = p2Var;
        if (p2Var != null) {
            this.zze = p2Var.g;
        }
        return this;
    }

    public final zzffe zzs(rc2 rc2Var) {
        this.zzb = rc2Var;
        return this;
    }

    public final zzffe zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzffe zzu(pd2 pd2Var) {
        this.zzi = pd2Var;
        return this;
    }

    public final zzffe zzv(zzemk zzemkVar) {
        this.zzr = zzemkVar;
        return this;
    }

    public final zzffe zzw(zzblh zzblhVar) {
        this.zzn = zzblhVar;
        this.zzd = new ta2(false, true, false);
        return this;
    }

    public final zzffe zzx(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzffe zzy(boolean z) {
        this.zzq = z;
        return this;
    }

    public final zzffe zzz(boolean z) {
        this.zzs = true;
        return this;
    }
}
