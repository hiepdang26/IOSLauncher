package com.google.android.gms.internal.ads;

import defpackage.aw0;
import defpackage.bw0;
import defpackage.zv0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsa {
    private final aw0 zza;
    private final zv0 zzb;
    private bw0 zzc;

    public zzbsa(aw0 aw0Var, zv0 zv0Var) {
    }

    public static /* bridge */ /* synthetic */ zv0 zzc(zzbsa zzbsaVar) {
        zzbsaVar.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ aw0 zzd(zzbsa zzbsaVar) {
        zzbsaVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized bw0 zzf(zzbfx zzbfxVar) {
        bw0 bw0Var = this.zzc;
        if (bw0Var != null) {
            return bw0Var;
        }
        zzbsb zzbsbVar = new zzbsb(zzbfxVar);
        this.zzc = zzbsbVar;
        return zzbsbVar;
    }

    public final zzbgh zza() {
        return null;
    }

    public final zzbgk zzb() {
        return new zzbrz(this, null);
    }
}
