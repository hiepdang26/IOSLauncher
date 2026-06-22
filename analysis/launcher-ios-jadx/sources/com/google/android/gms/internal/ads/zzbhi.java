package com.google.android.gms.internal.ads;

import defpackage.ha2;
import defpackage.va2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhi {
    private final va2 zza;
    private final ha2 zzb;
    private zzbfy zzc;

    public zzbhi(va2 va2Var, ha2 ha2Var) {
        this.zza = va2Var;
        this.zzb = ha2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzbfy zzf(zzbfx zzbfxVar) {
        zzbfy zzbfyVar = this.zzc;
        if (zzbfyVar != null) {
            return zzbfyVar;
        }
        zzbfy zzbfyVar2 = new zzbfy(zzbfxVar);
        this.zzc = zzbfyVar2;
        return zzbfyVar2;
    }

    public final zzbgh zzc() {
        zzbhe zzbheVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzbhf(this, zzbheVar);
    }

    public final zzbgk zzd() {
        return new zzbhh(this, null);
    }
}
