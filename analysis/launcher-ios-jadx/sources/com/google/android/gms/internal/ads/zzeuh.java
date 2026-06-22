package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuh implements zzevn {
    private final String zza;
    private final String zzb;

    public zzeuh(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgl)).booleanValue()) {
            bundle.putString("request_id", this.zzb);
        } else {
            bundle.putString("request_id", this.zza);
        }
    }
}
