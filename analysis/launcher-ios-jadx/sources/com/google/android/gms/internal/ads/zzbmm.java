package com.google.android.gms.internal.ads;

import defpackage.a62;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbmm implements zzbix {
    final /* synthetic */ zzblv zza;
    final /* synthetic */ a62 zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmm(zzbna zzbnaVar, zzauo zzauoVar, zzblv zzblvVar, a62 a62Var) {
        this.zza = zzblvVar;
        this.zzb = a62Var;
        this.zzc = zzbnaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbix, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        k92.a("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        synchronized (this.zzc.zza) {
            try {
                k92.a("loadJavascriptEngine > /requestReload handler: Lock acquired");
                k92.g("JS Engine is requesting an update");
                if (this.zzc.zzi == 0) {
                    k92.g("Starting reload.");
                    this.zzc.zzi = 2;
                    this.zzc.zzd(null);
                }
                this.zza.zzr("/requestReload", this.zzb.a);
            } catch (Throwable th) {
                throw th;
            }
        }
        k92.a("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
