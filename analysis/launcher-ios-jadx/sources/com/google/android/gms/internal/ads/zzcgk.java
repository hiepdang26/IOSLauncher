package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgk {
    private or1 zza;
    private Context zzb;
    private long zzc;
    private WeakReference zzd;

    public final zzcgk zzd(long j) {
        this.zzc = j;
        return this;
    }

    public final zzcgk zze(Context context) {
        this.zzd = new WeakReference(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzcgk zzf(or1 or1Var) {
        this.zza = or1Var;
        return this;
    }
}
