package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeot implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzeot(zzgcu zzgcuVar, Context context) {
        this.zzb = zzgcuVar;
        this.zza = context;
    }

    private static final zzeou zzc() {
        return new zzeou(null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 61;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzlT)).booleanValue()) {
            return zzgcj.zzh(zzc());
        }
        final ContentResolver contentResolver = this.zza.getContentResolver();
        return contentResolver == null ? zzgcj.zzh(zzc()) : this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeos
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ContentResolver contentResolver2 = contentResolver;
                return new zzeou(Settings.Secure.getString(contentResolver2, "advertising_id"), Settings.Secure.getInt(contentResolver2, "limit_ad_tracking", 0) == 1);
            }
        });
    }
}
