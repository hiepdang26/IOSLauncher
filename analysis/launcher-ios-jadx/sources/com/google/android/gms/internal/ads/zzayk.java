package com.google.android.gms.internal.ads;

import defpackage.r62;
import defpackage.u6;

/* JADX INFO: loaded from: classes.dex */
public final class zzayk extends r62 {
    private final u6 zza;

    public zzayk(u6 u6Var) {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
        this.zza = u6Var;
    }

    public final u6 zzb() {
        return this.zza;
    }

    @Override // defpackage.u62
    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
