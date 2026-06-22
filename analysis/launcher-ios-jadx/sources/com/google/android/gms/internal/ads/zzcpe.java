package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpe extends zzcru {
    private final zzcej zzc;
    private final int zzd;
    private final Context zze;
    private final zzcos zzf;
    private final zzdgx zzg;
    private final zzddu zzh;
    private final zzcxd zzi;
    private final boolean zzj;
    private final zzbzi zzk;
    private boolean zzl;

    public zzcpe(zzcrt zzcrtVar, Context context, zzcej zzcejVar, int i, zzcos zzcosVar, zzdgx zzdgxVar, zzddu zzdduVar, zzcxd zzcxdVar, zzbzi zzbziVar) {
        super(zzcrtVar);
        this.zzl = false;
        this.zzc = zzcejVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcosVar;
        this.zzg = zzdgxVar;
        this.zzh = zzdduVar;
        this.zzi = zzcxdVar;
        this.zzj = ((Boolean) n42.d.c.zza(zzbbw.zzeM)).booleanValue();
        this.zzk = zzbziVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zzb() {
        super.zzb();
        zzcej zzcejVar = this.zzc;
        if (zzcejVar != null) {
            zzcejVar.destroy();
        }
    }

    public final void zzc(zzazj zzazjVar) {
        zzcej zzcejVar = this.zzc;
        if (zzcejVar != null) {
            zzcejVar.zzak(zzazjVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzd(Activity activity, zzazw zzazwVar, boolean z) {
        zzcej zzcejVar;
        zzfel zzfelVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        if (this.zzj) {
            this.zzh.zzb();
        }
        zzbbn zzbbnVar = zzbbw.zzat;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            hd2 hd2Var = hd2.B;
            cd2 cd2Var = hd2Var.c;
            if (cd2.e(context)) {
                k92.h("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) n42Var.c.zza(zzbbw.zzau)).booleanValue()) {
                    new zzfos(context.getApplicationContext(), hd2Var.r.a()).zza(this.zza.zzb.zzb.zzb);
                    return;
                }
                return;
            }
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzkU)).booleanValue() && (zzcejVar = this.zzc) != null && (zzfelVarZzD = zzcejVar.zzD()) != null && zzfelVarZzD.zzar && zzfelVarZzD.zzas != this.zzk.zzb()) {
            k92.h("The app open consent form has been shown.");
            this.zzi.zza(zzfgi.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            k92.h("App open interstitial ad is already visible.");
            this.zzi.zza(zzfgi.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            this.zzg.zza(z, context, this.zzi);
            if (this.zzj) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdgw e) {
            this.zzi.zzc(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
