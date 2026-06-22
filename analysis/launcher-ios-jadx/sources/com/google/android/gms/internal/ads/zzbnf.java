package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.n42;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzbnf {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbno zzc;
    private zzbno zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbno zza(Context context, or1 or1Var, zzfki zzfkiVar) {
        zzbno zzbnoVar;
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    this.zzc = new zzbno(zzc(context), or1Var, (String) n42.d.c.zza(zzbbw.zza), zzfkiVar);
                }
                zzbnoVar = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbnoVar;
    }

    public final zzbno zzb(Context context, or1 or1Var, zzfki zzfkiVar) {
        zzbno zzbnoVar;
        synchronized (this.zzb) {
            try {
                if (this.zzd == null) {
                    this.zzd = new zzbno(zzc(context), or1Var, (String) zzbec.zza.zze(), zzfkiVar);
                }
                zzbnoVar = this.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbnoVar;
    }
}
