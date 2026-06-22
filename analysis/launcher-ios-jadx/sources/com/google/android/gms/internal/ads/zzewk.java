package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzewk implements zzevn {
    final String zza;
    final int zzb;

    public /* synthetic */ zzewk(String str, int i, zzewj zzewjVar) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) n42.d.c.zza(zzbbw.zzjz)).booleanValue()) {
            if (!TextUtils.isEmpty(this.zza)) {
                bundle.putString("topics", this.zza);
            }
            int i = this.zzb;
            if (i != -1) {
                bundle.putInt("atps", i);
            }
        }
    }
}
