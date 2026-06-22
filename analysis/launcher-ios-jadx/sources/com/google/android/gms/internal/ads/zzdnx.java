package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a22;
import defpackage.or1;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnx implements Callable {
    private final a22 zza;
    private final Context zzb;
    private final zzdsk zzc;
    private final zzedh zzd;
    private final Executor zze;
    private final zzauo zzf;
    private final or1 zzg;
    private final zzfll zzh;
    private final zzeds zzi;
    private final zzffk zzj;

    public zzdnx(Context context, Executor executor, zzauo zzauoVar, or1 or1Var, a22 a22Var, zzcew zzcewVar, zzedh zzedhVar, zzfll zzfllVar, zzdsk zzdskVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzauoVar;
        this.zzg = or1Var;
        this.zza = a22Var;
        this.zzd = zzedhVar;
        this.zzh = zzfllVar;
        this.zzc = zzdskVar;
        this.zzi = zzedsVar;
        this.zzj = zzffkVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzdoa zzdoaVar = new zzdoa(this);
        zzdoaVar.zzk();
        return zzdoaVar;
    }
}
