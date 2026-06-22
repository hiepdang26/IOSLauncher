package com.google.android.gms.internal.ads;

import defpackage.k92;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
final class zzfbu implements zzful {
    final /* synthetic */ zzfby zza;

    public zzfbu(zzfby zzfbyVar) {
        this.zza = zzfbyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzful
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        k92.f();
        k92.a("Failed to get a cache key, reverting to legacy flow.");
        zzfby zzfbyVar = this.zza;
        zzfbyVar.zzd = new zzfbx(null, zzfbyVar.zze(), null);
        return this.zza.zzd;
    }
}
