package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.do0;
import defpackage.n42;
import defpackage.or1;
import defpackage.pd2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzezt implements zzena {
    protected final zzcgj zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzfaj zzd;
    private final zzfcc zze;
    private final or1 zzf;
    private final ViewGroup zzg;
    private final zzfki zzh;
    private final zzffe zzi;
    private do0 zzj;

    public zzezt(Context context, Executor executor, zzcgj zzcgjVar, zzfcc zzfccVar, zzfaj zzfajVar, zzffe zzffeVar, or1 or1Var) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcgjVar;
        this.zze = zzfccVar;
        this.zzd = zzfajVar;
        this.zzi = zzffeVar;
        this.zzf = or1Var;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcgjVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzcvw zzm(zzfca zzfcaVar) {
        zzezs zzezsVar = (zzezs) zzfcaVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzhq)).booleanValue()) {
            zzcph zzcphVar = new zzcph(this.zzg);
            zzcvy zzcvyVar = new zzcvy();
            zzcvyVar.zze(this.zzb);
            zzcvyVar.zzi(zzezsVar.zza);
            zzcwa zzcwaVarZzj = zzcvyVar.zzj();
            zzdci zzdciVar = new zzdci();
            zzdciVar.zzc(this.zzd, this.zzc);
            zzdciVar.zzl(this.zzd, this.zzc);
            return zze(zzcphVar, zzcwaVarZzj, zzdciVar.zzn());
        }
        zzfaj zzfajVarZzi = zzfaj.zzi(this.zzd);
        zzdci zzdciVar2 = new zzdci();
        zzdciVar2.zzb(zzfajVarZzi, this.zzc);
        zzdciVar2.zzg(zzfajVarZzi, this.zzc);
        zzdciVar2.zzh(zzfajVarZzi, this.zzc);
        zzdciVar2.zzi(zzfajVarZzi, this.zzc);
        zzdciVar2.zzc(zzfajVarZzi, this.zzc);
        zzdciVar2.zzl(zzfajVarZzi, this.zzc);
        zzdciVar2.zzm(zzfajVarZzi);
        zzcph zzcphVar2 = new zzcph(this.zzg);
        zzcvy zzcvyVar2 = new zzcvy();
        zzcvyVar2.zze(this.zzb);
        zzcvyVar2.zzi(zzezsVar.zza);
        return zze(zzcphVar2, zzcvyVar2.zzj(), zzdciVar2.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        do0 do0Var = this.zzj;
        return (do0Var == null || do0Var.isDone()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // com.google.android.gms.internal.ads.zzena
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzb(defpackage.tb2 r10, java.lang.String r11, com.google.android.gms.internal.ads.zzemy r12, com.google.android.gms.internal.ads.zzemz r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezt.zzb(tb2, java.lang.String, com.google.android.gms.internal.ads.zzemy, com.google.android.gms.internal.ads.zzemz):boolean");
    }

    public abstract zzcvw zze(zzcph zzcphVar, zzcwa zzcwaVar, zzdck zzdckVar);

    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzl(pd2 pd2Var) {
        this.zzi.zzu(pd2Var);
    }
}
