package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.ka2;

/* JADX INFO: loaded from: classes.dex */
public final class zzccz extends zzccv {
    public zzccz(zzcbk zzcbkVar) {
        super(zzcbkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzt(String str) {
        String strA = ka2.a(str, "MD5");
        zzcbk zzcbkVar = (zzcbk) this.zzc.get();
        if (zzcbkVar != null && strA != null) {
            zzcbkVar.zzt(strA, this);
        }
        k92.h("VideoStreamNoopCache is doing nothing.");
        zzg(str, strA, "noop", "Noop cache is a noop.");
        return false;
    }
}
