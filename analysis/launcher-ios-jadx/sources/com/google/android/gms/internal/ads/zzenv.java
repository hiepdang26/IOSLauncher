package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzenv implements zzevn {
    private final String zza;

    public zzenv(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        String str = this.zza;
        Bundle bundle = (Bundle) obj;
        if (str != null) {
            bundle.putString("arek", str);
        }
    }
}
