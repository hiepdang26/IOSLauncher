package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import defpackage.a41;
import defpackage.cd2;
import defpackage.n42;
import defpackage.p2;
import defpackage.pd2;
import defpackage.rc2;
import defpackage.ta2;
import defpackage.tb2;
import defpackage.u62;
import defpackage.uv0;
import defpackage.wv0;
import defpackage.y62;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzffg {
    public final ta2 zza;
    public final zzblh zzb;
    public final zzemk zzc;
    public final tb2 zzd;
    public final rc2 zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbes zzi;
    public final pd2 zzj;
    public final int zzk;
    public final p2 zzl;
    public final a41 zzm;
    public final u62 zzn;
    public final zzfet zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final y62 zzt;

    public zzffg(zzffe zzffeVar, zzfff zzfffVar) {
        this.zze = zzffeVar.zzb;
        this.zzf = zzffeVar.zzc;
        this.zzt = zzffeVar.zzu;
        int i = zzffeVar.zza.g;
        long j = zzffeVar.zza.h;
        Bundle bundle = zzffeVar.zza.i;
        int i2 = zzffeVar.zza.j;
        List list = zzffeVar.zza.k;
        boolean z = zzffeVar.zza.l;
        int i3 = zzffeVar.zza.m;
        boolean z2 = true;
        if (!zzffeVar.zza.n && !zzffeVar.zze) {
            z2 = false;
        }
        this.zzd = new tb2(i, j, bundle, i2, list, z, i3, z2, zzffeVar.zza.o, zzffeVar.zza.p, zzffeVar.zza.q, zzffeVar.zza.r, zzffeVar.zza.s, zzffeVar.zza.t, zzffeVar.zza.u, zzffeVar.zza.v, zzffeVar.zza.w, zzffeVar.zza.x, zzffeVar.zza.y, zzffeVar.zza.z, zzffeVar.zza.A, zzffeVar.zza.B, cd2.t(zzffeVar.zza.C), zzffeVar.zza.D, zzffeVar.zza.E, zzffeVar.zza.F);
        this.zza = zzffeVar.zzd != null ? zzffeVar.zzd : zzffeVar.zzh != null ? zzffeVar.zzh.zzf : null;
        this.zzg = zzffeVar.zzf;
        this.zzh = zzffeVar.zzg;
        this.zzi = zzffeVar.zzf == null ? null : zzffeVar.zzh == null ? new zzbes(new wv0(new uv0())) : zzffeVar.zzh;
        this.zzj = zzffeVar.zzi;
        this.zzk = zzffeVar.zzm;
        this.zzl = zzffeVar.zzj;
        this.zzm = zzffeVar.zzk;
        this.zzn = zzffeVar.zzl;
        this.zzb = zzffeVar.zzn;
        this.zzo = new zzfet(zzffeVar.zzo, null);
        this.zzp = zzffeVar.zzp;
        this.zzq = zzffeVar.zzq;
        this.zzc = zzffeVar.zzr;
        this.zzr = zzffeVar.zzs;
        this.zzs = zzffeVar.zzt;
    }

    public final zzbgu zza() {
        a41 a41Var = this.zzm;
        if (a41Var == null && this.zzl == null) {
            return null;
        }
        if (a41Var != null) {
            IBinder iBinder = a41Var.i;
            if (iBinder == null) {
                return null;
            }
            return zzbgt.zzb(iBinder);
        }
        IBinder iBinder2 = this.zzl.h;
        if (iBinder2 == null) {
            return null;
        }
        return zzbgt.zzb(iBinder2);
    }

    public final boolean zzb() {
        return this.zzf.matches((String) n42.d.c.zza(zzbbw.zzcP));
    }
}
