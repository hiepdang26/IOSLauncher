package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import defpackage.b82;
import defpackage.e3;
import defpackage.f3;
import defpackage.gb2;
import defpackage.hg0;
import defpackage.od2;
import defpackage.pm1;
import defpackage.ty0;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpa {
    private final Context zza;
    private final Executor zzb;
    private final zzfoh zzc;
    private final zzfoj zzd;
    private final zzfoz zze;
    private final zzfoz zzf;
    private pm1 zzg;
    private pm1 zzh;

    public zzfpa(Context context, Executor executor, zzfoh zzfohVar, zzfoj zzfojVar, zzfox zzfoxVar, zzfoy zzfoyVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfohVar;
        this.zzd = zzfojVar;
        this.zze = zzfoxVar;
        this.zzf = zzfoyVar;
    }

    public static zzfpa zze(Context context, Executor executor, zzfoh zzfohVar, zzfoj zzfojVar) {
        final zzfpa zzfpaVar = new zzfpa(context, executor, zzfohVar, zzfojVar, new zzfox(), new zzfoy());
        if (zzfpaVar.zzd.zzd()) {
            zzfpaVar.zzg = zzfpaVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfou
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc();
                }
            });
        } else {
            zzasj zzasjVarZza = zzfpaVar.zze.zza();
            od2 od2Var = new od2();
            od2Var.h(zzasjVarZza);
            zzfpaVar.zzg = od2Var;
        }
        zzfpaVar.zzh = zzfpaVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfov
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
        return zzfpaVar;
    }

    private static zzasj zzg(pm1 pm1Var, zzasj zzasjVar) {
        return !pm1Var.d() ? zzasjVar : (zzasj) pm1Var.b();
    }

    private final pm1 zzh(Callable callable) {
        Executor executor = this.zzb;
        hg0.j(executor, "Executor must not be null");
        hg0.j(callable, "Callback must not be null");
        od2 od2Var = new od2();
        executor.execute(new gb2(od2Var, callable, 7));
        od2Var.b.f(new b82(this.zzb, new ty0() { // from class: com.google.android.gms.internal.ads.zzfow
            @Override // defpackage.ty0
            public final void onFailure(Exception exc) {
                this.zza.zzf(exc);
            }
        }));
        od2Var.k();
        return od2Var;
    }

    public final zzasj zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzasj zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    public final zzasj zzc() {
        zzaro zzaroVarZza = zzasj.zza();
        e3 e3VarA = f3.a(this.zza);
        String strEncodeToString = e3VarA.a;
        if (strEncodeToString != null && strEncodeToString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID uuidFromString = UUID.fromString(strEncodeToString);
            byte[] bArr = new byte[16];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
            byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
            strEncodeToString = Base64.encodeToString(bArr, 11);
        }
        if (strEncodeToString != null) {
            zzaroVarZza.zzs(strEncodeToString);
            zzaroVarZza.zzr(e3VarA.b);
            zzaroVarZza.zzab(6);
        }
        return (zzasj) zzaroVarZza.zzbr();
    }

    public final /* synthetic */ zzasj zzd() throws PackageManager.NameNotFoundException {
        Context context = this.zza;
        return zzfop.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}
