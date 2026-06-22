package com.google.android.gms.internal.ads;

import defpackage.b22;
import defpackage.e22;
import defpackage.mc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzdod extends zzdnn implements zzdeq {
    private zzdeq zza;

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final synchronized void zzdG() {
        zzdeq zzdeqVar = this.zza;
        if (zzdeqVar != null) {
            zzdeqVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final synchronized void zzdf() {
        zzdeq zzdeqVar = this.zza;
        if (zzdeqVar != null) {
            zzdeqVar.zzdf();
        }
    }

    public final synchronized void zzi(b22 b22Var, zzbhn zzbhnVar, mc2 mc2Var, zzbhp zzbhpVar, e22 e22Var, zzdeq zzdeqVar) throws Throwable {
        try {
            try {
                zzh(b22Var, zzbhnVar, mc2Var, zzbhpVar, e22Var);
                this.zza = zzdeqVar;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
