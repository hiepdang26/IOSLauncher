package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzenj implements zzevn {
    private final boolean zza;

    public zzenj(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putString("adid_p", true != this.zza ? "0" : "1");
    }
}
