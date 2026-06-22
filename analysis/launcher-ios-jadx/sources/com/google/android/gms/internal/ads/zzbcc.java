package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbcc {
    public static final void zza(zzbcb zzbcbVar, zzbbz zzbbzVar) {
        if (zzbbzVar.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbbzVar.zzb())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzbcbVar.zzd(zzbbzVar.zza(), zzbbzVar.zzb(), zzbbzVar.zzc(), zzbbzVar.zzd());
    }
}
