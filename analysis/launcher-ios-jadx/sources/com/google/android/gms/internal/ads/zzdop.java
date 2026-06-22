package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzdop extends zzcru {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdgx zze;
    private final zzddu zzf;
    private final zzcxd zzg;
    private final zzcyk zzh;
    private final zzcsp zzi;
    private final zzbwd zzj;
    private final zzfos zzk;
    private final zzfez zzl;
    private boolean zzm;

    public zzdop(zzcrt zzcrtVar, Context context, zzcej zzcejVar, zzdgx zzdgxVar, zzddu zzdduVar, zzcxd zzcxdVar, zzcyk zzcykVar, zzcsp zzcspVar, zzfel zzfelVar, zzfos zzfosVar, zzfez zzfezVar) {
        super(zzcrtVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdgxVar;
        this.zzd = new WeakReference(zzcejVar);
        this.zzf = zzdduVar;
        this.zzg = zzcxdVar;
        this.zzh = zzcykVar;
        this.zzi = zzcspVar;
        this.zzk = zzfosVar;
        zzbvz zzbvzVar = zzfelVar.zzl;
        this.zzj = new zzbwx(zzbvzVar != null ? zzbvzVar.zza : "", zzbvzVar != null ? zzbvzVar.zzb : 1);
        this.zzl = zzfezVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcej zzcejVar = (zzcej) this.zzd.get();
            if (((Boolean) n42.d.c.zza(zzbbw.zzga)).booleanValue()) {
                if (!this.zzm && zzcejVar != null) {
                    zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdoo
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcejVar.destroy();
                        }
                    });
                }
            } else if (zzcejVar != null) {
                zzcejVar.destroy();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwd zzc() {
        return this.zzj;
    }

    public final zzfez zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcej zzcejVar = (zzcej) this.zzd.get();
        return (zzcejVar == null || zzcejVar.zzaG()) ? false : true;
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
    public final boolean zzh(boolean z, Activity activity) {
        zzbbn zzbbnVar = zzbbw.zzat;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            cd2 cd2Var = hd2.B.c;
            if (cd2.e(this.zzc)) {
                k92.h("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) n42Var.c.zza(zzbbw.zzau)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            k92.h("The rewarded ad have been showed.");
            this.zzg.zza(zzfgi.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdgw e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
