package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.j92;
import defpackage.k92;
import defpackage.n42;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.v42;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfax implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzemk zzd;
    private final zzemo zze;
    private final ViewGroup zzf;
    private zzbcr zzg;
    private final zzczj zzh;
    private final zzfki zzi;
    private final zzdbp zzj;
    private final zzffe zzk;
    private do0 zzl;
    private boolean zzm;
    private j92 zzn;
    private zzemz zzo;

    public zzfax(Context context, Executor executor, rc2 rc2Var, zzcgj zzcgjVar, zzemk zzemkVar, zzemo zzemoVar, zzffe zzffeVar, zzdbp zzdbpVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zzd = zzemkVar;
        this.zze = zzemoVar;
        this.zzk = zzffeVar;
        this.zzh = zzcgjVar.zzf();
        this.zzi = zzcgjVar.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdbpVar;
        zzffeVar.zzs(rc2Var);
        this.zzm = true;
        this.zzn = null;
        this.zzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        this.zzl = null;
        if (((Boolean) n42.d.c.zza(zzbbw.zzhp)).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfat
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk();
                }
            });
        }
        zzemz zzemzVar = this.zzo;
        if (zzemzVar != null) {
            zzemzVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        do0 do0Var = this.zzl;
        return (do0Var == null || do0Var.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(tb2 tb2Var, String str, zzemy zzemyVar, zzemz zzemzVar) {
        zzcql zzcqlVarZzk;
        if (str == null) {
            k92.e("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfav
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl();
                }
            });
            return false;
        }
        if (!zza()) {
            zzbbn zzbbnVar = zzbbw.zzia;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && tb2Var.l) {
                this.zzc.zzl().zzo(true);
            }
            Pair pair = new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(tb2Var.F));
            String strZza = zzdrt.DYNAMITE_ENTER.zza();
            hd2.B.j.getClass();
            Bundle bundleZza = zzdrv.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
            zzffe zzffeVar = this.zzk;
            zzffeVar.zzt(str);
            zzffeVar.zzH(tb2Var);
            zzffeVar.zzA(bundleZza);
            Context context = this.zza;
            zzffg zzffgVarZzJ = zzffeVar.zzJ();
            zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 3, tb2Var);
            zzfkf zzfkfVarZzj = null;
            if (!((Boolean) zzbdy.zze.zze()).booleanValue() || !this.zzk.zzh().q) {
                if (((Boolean) n42Var.c.zza(zzbbw.zzhp)).booleanValue()) {
                    zzcqk zzcqkVarZze = this.zzc.zze();
                    zzcvy zzcvyVar = new zzcvy();
                    zzcvyVar.zze(this.zza);
                    zzcvyVar.zzi(zzffgVarZzJ);
                    zzcqkVarZze.zzi(zzcvyVar.zzj());
                    zzdci zzdciVar = new zzdci();
                    zzdciVar.zzj(this.zzd, this.zzb);
                    zzdciVar.zzk(this.zzd, this.zzb);
                    zzcqkVarZze.zzf(zzdciVar.zzn());
                    zzcqkVarZze.zze(new zzekt(this.zzg));
                    zzcqkVarZze.zzd(new zzdhg(zzdjm.zza, null));
                    zzcqkVarZze.zzg(new zzcrm(this.zzh, this.zzj));
                    zzcqkVarZze.zzc(new zzcph(this.zzf));
                    zzcqlVarZzk = zzcqkVarZze.zzh();
                } else {
                    zzcqk zzcqkVarZze2 = this.zzc.zze();
                    zzcvy zzcvyVar2 = new zzcvy();
                    zzcvyVar2.zze(this.zza);
                    zzcvyVar2.zzi(zzffgVarZzJ);
                    zzcqkVarZze2.zzi(zzcvyVar2.zzj());
                    zzdci zzdciVar2 = new zzdci();
                    zzdciVar2.zzj(this.zzd, this.zzb);
                    zzdciVar2.zza(this.zzd, this.zzb);
                    zzdciVar2.zza(this.zze, this.zzb);
                    zzdciVar2.zzl(this.zzd, this.zzb);
                    zzdciVar2.zzd(this.zzd, this.zzb);
                    zzdciVar2.zze(this.zzd, this.zzb);
                    zzdciVar2.zzf(this.zzd, this.zzb);
                    zzdciVar2.zzb(this.zzd, this.zzb);
                    zzdciVar2.zzk(this.zzd, this.zzb);
                    zzdciVar2.zzi(this.zzd, this.zzb);
                    zzcqkVarZze2.zzf(zzdciVar2.zzn());
                    zzcqkVarZze2.zze(new zzekt(this.zzg));
                    zzcqkVarZze2.zzd(new zzdhg(zzdjm.zza, null));
                    zzcqkVarZze2.zzg(new zzcrm(this.zzh, this.zzj));
                    zzcqkVarZze2.zzc(new zzcph(this.zzf));
                    zzcqlVarZzk = zzcqkVarZze2.zzh();
                }
                if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                    zzfkfVarZzj = zzcqlVarZzk.zzj();
                    zzfkfVarZzj.zzi(3);
                    zzfkfVarZzj.zzb(tb2Var.v);
                    zzfkfVarZzj.zzf(tb2Var.s);
                }
                this.zzo = zzemzVar;
                zzctc zzctcVarZzd = zzcqlVarZzk.zzd();
                do0 do0VarZzi = zzctcVarZzd.zzi(zzctcVarZzd.zzj());
                this.zzl = do0VarZzi;
                zzgcj.zzr(do0VarZzi, new zzfaw(this, zzfkfVarZzj, zzfjuVarZzb, zzcqlVarZzk), this.zzb);
                return true;
            }
            zzemk zzemkVar = this.zzd;
            if (zzemkVar != null) {
                zzemkVar.zzdB(zzfgi.zzd(7, null, null));
            }
        } else if (!this.zzk.zzS()) {
            this.zzm = true;
            return false;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzffe zzg() {
        return this.zzk;
    }

    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(this.zzn);
    }

    public final /* synthetic */ void zzl() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzm() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzn() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzo(v42 v42Var) {
        this.zze.zza(v42Var);
    }

    public final void zzp(zzczc zzczcVar) {
        this.zzh.zzo(zzczcVar, this.zzb);
    }

    public final void zzq(zzbcr zzbcrVar) {
        this.zzg = zzbcrVar;
    }

    public final void zzr() {
        synchronized (this) {
            try {
                do0 do0Var = this.zzl;
                if (do0Var != null && do0Var.isDone()) {
                    try {
                        zzcpk zzcpkVar = (zzcpk) this.zzl.get();
                        this.zzl = null;
                        this.zzf.removeAllViews();
                        if (zzcpkVar.zzd() != null) {
                            ViewParent parent = zzcpkVar.zzd().getParent();
                            if (parent instanceof ViewGroup) {
                                k92.h("Banner view provided from " + (zzcpkVar.zzm() != null ? zzcpkVar.zzm().zzg() : "") + " already has a parent view. Removing its old parent.");
                                ((ViewGroup) parent).removeView(zzcpkVar.zzd());
                            }
                        }
                        zzbbn zzbbnVar = zzbbw.zzhp;
                        n42 n42Var = n42.d;
                        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                            zzday zzdayVarZzo = zzcpkVar.zzo();
                            zzdayVarZzo.zza(this.zzd);
                            zzdayVarZzo.zzc(this.zze);
                        }
                        this.zzf.addView(zzcpkVar.zzd());
                        this.zzo.zzb(zzcpkVar);
                        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                            Executor executor = this.zzb;
                            final zzemk zzemkVar = this.zzd;
                            Objects.requireNonNull(zzemkVar);
                            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfau
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzemkVar.zzs();
                                }
                            });
                        }
                        if (zzcpkVar.zza() >= 0) {
                            this.zzm = false;
                            this.zzh.zzd(zzcpkVar.zza());
                            this.zzh.zze(zzcpkVar.zzc());
                        } else {
                            this.zzm = true;
                            this.zzh.zzd(zzcpkVar.zzc());
                        }
                    } catch (InterruptedException | ExecutionException unused) {
                        zzu();
                        k92.b();
                        this.zzm = true;
                        this.zzh.zza();
                    }
                } else if (this.zzl != null) {
                    k92.a("Show timer went off but there is an ongoing ad request.");
                    this.zzm = true;
                } else {
                    k92.a("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                    this.zzm = true;
                    this.zzh.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzt() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        cd2 cd2Var = hd2.B.c;
        Context context = view.getContext();
        Context applicationContext = context.getApplicationContext();
        KeyguardManager keyguardManager = null;
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return cd2.o(view, powerManager, keyguardManager);
    }
}
