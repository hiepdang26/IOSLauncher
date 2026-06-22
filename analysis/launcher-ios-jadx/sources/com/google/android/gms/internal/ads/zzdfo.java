package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.n42;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfo extends zzcru {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzddu zze;
    private final zzdgx zzf;
    private final zzcsp zzg;
    private final zzfos zzh;
    private final zzcxd zzi;
    private final zzbzi zzj;
    private boolean zzk;

    public zzdfo(zzcrt zzcrtVar, Context context, zzcej zzcejVar, zzddu zzdduVar, zzdgx zzdgxVar, zzcsp zzcspVar, zzfos zzfosVar, zzcxd zzcxdVar, zzbzi zzbziVar) {
        super(zzcrtVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcejVar);
        this.zze = zzdduVar;
        this.zzf = zzdgxVar;
        this.zzg = zzcspVar;
        this.zzh = zzfosVar;
        this.zzi = zzcxdVar;
        this.zzj = zzbziVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcej zzcejVar = (zzcej) this.zzd.get();
            if (((Boolean) n42.d.c.zza(zzbbw.zzga)).booleanValue()) {
                if (!this.zzk && zzcejVar != null) {
                    zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdfn
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

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(boolean r5, android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzddu r0 = r4.zze
            r0.zzb()
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzat
            n42 r1 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r2 = r1.c
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L4d
            hd2 r0 = defpackage.hd2.B
            cd2 r0 = r0.c
            android.content.Context r0 = r4.zzc
            boolean r0 = defpackage.cd2.e(r0)
            if (r0 == 0) goto L4d
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            defpackage.k92.h(r5)
            com.google.android.gms.internal.ads.zzcxd r5 = r4.zzi
            r5.zzb()
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzau
            com.google.android.gms.internal.ads.zzbbu r6 = r1.c
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto Lc1
            com.google.android.gms.internal.ads.zzfos r5 = r4.zzh
            com.google.android.gms.internal.ads.zzfex r6 = r4.zza
            com.google.android.gms.internal.ads.zzfew r6 = r6.zzb
            com.google.android.gms.internal.ads.zzfeo r6 = r6.zzb
            java.lang.String r6 = r6.zzb
            r5.zza(r6)
            goto Lc1
        L4d:
            java.lang.ref.WeakReference r0 = r4.zzd
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzcej r0 = (com.google.android.gms.internal.ads.zzcej) r0
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkU
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c
            java.lang.Object r1 = r1.zza(r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r3 = 0
            if (r1 == 0) goto L8f
            if (r0 == 0) goto L8f
            com.google.android.gms.internal.ads.zzfel r0 = r0.zzD()
            if (r0 == 0) goto L8f
            boolean r1 = r0.zzar
            if (r1 == 0) goto L8f
            int r0 = r0.zzas
            com.google.android.gms.internal.ads.zzbzi r1 = r4.zzj
            int r1 = r1.zzb()
            if (r0 == r1) goto L8f
            java.lang.String r5 = "The interstitial consent form has been shown."
            defpackage.k92.h(r5)
            com.google.android.gms.internal.ads.zzcxd r5 = r4.zzi
            r6 = 12
            java.lang.String r0 = "The consent form has already been shown."
            j92 r6 = com.google.android.gms.internal.ads.zzfgi.zzd(r6, r0, r3)
            r5.zza(r6)
            goto Lc1
        L8f:
            boolean r0 = r4.zzk
            if (r0 == 0) goto La3
            java.lang.String r0 = "The interstitial ad has been shown."
            defpackage.k92.h(r0)
            com.google.android.gms.internal.ads.zzcxd r0 = r4.zzi
            r1 = 10
            j92 r1 = com.google.android.gms.internal.ads.zzfgi.zzd(r1, r3, r3)
            r0.zza(r1)
        La3:
            boolean r0 = r4.zzk
            if (r0 != 0) goto Lc1
            if (r6 != 0) goto Lab
            android.content.Context r6 = r4.zzc
        Lab:
            com.google.android.gms.internal.ads.zzdgx r0 = r4.zzf     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbb
            com.google.android.gms.internal.ads.zzcxd r1 = r4.zzi     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbb
            r0.zza(r5, r6, r1)     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbb
            com.google.android.gms.internal.ads.zzddu r5 = r4.zze     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbb
            r5.zza()     // Catch: com.google.android.gms.internal.ads.zzdgw -> Lbb
            r5 = 1
            r4.zzk = r5
            return r5
        Lbb:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcxd r6 = r4.zzi
            r6.zzc(r5)
        Lc1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfo.zzc(boolean, android.app.Activity):boolean");
    }
}
