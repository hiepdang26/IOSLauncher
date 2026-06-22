package com.google.android.gms.internal.ads;

import defpackage.k31;
import defpackage.uo;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzbo extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzbo(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzbo zza(String str, Throwable th) {
        return new zzbo(str, th, true, 1);
    }

    public static zzbo zzb(String str, Throwable th) {
        return new zzbo(str, th, true, 0);
    }

    public static zzbo zzc(String str) {
        return new zzbo(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sbM = k31.m(super.getMessage(), "{contentIsMalformed=");
        sbM.append(this.zza);
        sbM.append(", dataType=");
        return uo.j(sbM, this.zzb, "}");
    }
}
