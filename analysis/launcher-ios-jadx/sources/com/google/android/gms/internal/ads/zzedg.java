package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzedg implements zzgcf {
    final /* synthetic */ zzfio zza;

    public zzedg(zzedh zzedhVar, zzfio zzfioVar) {
        this.zza = zzfioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        k92.e("Failed to get offline buffered ping database: ".concat(String.valueOf(th.getMessage())));
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            k92.e("Error executing function on offline buffered ping database: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
