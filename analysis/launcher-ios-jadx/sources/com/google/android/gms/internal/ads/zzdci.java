package com.google.android.gms.internal.ads;

import defpackage.b22;
import defpackage.mc2;
import defpackage.u6;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdci {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzfbz zzo;

    public final zzdci zza(b22 b22Var, Executor executor) {
        this.zzc.add(new zzdei(b22Var, executor));
        return this;
    }

    public final zzdci zzb(zzcwt zzcwtVar, Executor executor) {
        this.zzi.add(new zzdei(zzcwtVar, executor));
        return this;
    }

    public final zzdci zzc(zzcxg zzcxgVar, Executor executor) {
        this.zzl.add(new zzdei(zzcxgVar, executor));
        return this;
    }

    public final zzdci zzd(zzcxk zzcxkVar, Executor executor) {
        this.zzf.add(new zzdei(zzcxkVar, executor));
        return this;
    }

    public final zzdci zze(zzcwq zzcwqVar, Executor executor) {
        this.zze.add(new zzdei(zzcwqVar, executor));
        return this;
    }

    public final zzdci zzf(zzcye zzcyeVar, Executor executor) {
        this.zzh.add(new zzdei(zzcyeVar, executor));
        return this;
    }

    public final zzdci zzg(zzcyp zzcypVar, Executor executor) {
        this.zzg.add(new zzdei(zzcypVar, executor));
        return this;
    }

    public final zzdci zzh(mc2 mc2Var, Executor executor) {
        this.zzn.add(new zzdei(mc2Var, executor));
        return this;
    }

    public final zzdci zzi(zzczb zzczbVar, Executor executor) {
        this.zzm.add(new zzdei(zzczbVar, executor));
        return this;
    }

    public final zzdci zzj(zzczo zzczoVar, Executor executor) {
        this.zzb.add(new zzdei(zzczoVar, executor));
        return this;
    }

    public final zzdci zzk(u6 u6Var, Executor executor) {
        this.zzk.add(new zzdei(u6Var, executor));
        return this;
    }

    public final zzdci zzl(zzdeq zzdeqVar, Executor executor) {
        this.zzd.add(new zzdei(zzdeqVar, executor));
        return this;
    }

    public final zzdci zzm(zzfbz zzfbzVar) {
        this.zzo = zzfbzVar;
        return this;
    }

    public final zzdck zzn() {
        return new zzdck(this, null);
    }
}
