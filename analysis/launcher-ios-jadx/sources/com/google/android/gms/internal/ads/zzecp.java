package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzecp implements zzfjm {
    private final zzecd zza;
    private final zzech zzb;

    public zzecp(zzecd zzecdVar, zzech zzechVar) {
        this.zza = zzecdVar;
        this.zzb = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjfVar && this.zza.zzc() != 0) {
            zzecd zzecdVar = this.zza;
            hd2.B.j.getClass();
            zzecdVar.zzf(SystemClock.elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjfVar && this.zza.zzc() != 0) {
            zzecd zzecdVar = this.zza;
            hd2.B.j.getClass();
            zzecdVar.zzf(SystemClock.elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzfB)).booleanValue()) {
            if (zzfjf.RENDERER == zzfjfVar) {
                zzecd zzecdVar = this.zza;
                hd2.B.j.getClass();
                zzecdVar.zzg(SystemClock.elapsedRealtime());
            } else if (zzfjf.PRELOADED_LOADER == zzfjfVar || zzfjf.SERVER_TRANSACTION == zzfjfVar) {
                zzecd zzecdVar2 = this.zza;
                hd2.B.j.getClass();
                zzecdVar2.zzh(SystemClock.elapsedRealtime());
                final zzech zzechVar = this.zzb;
                final long jZzd = this.zza.zzd();
                zzechVar.zza.zza(new zzfio() { // from class: com.google.android.gms.internal.ads.zzecg
                    @Override // com.google.android.gms.internal.ads.zzfio
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzechVar.zzf()) {
                            return null;
                        }
                        long j = jZzd;
                        zzbbc.zzaf.zza.C0002zza c0002zzaZzn = zzbbc.zzaf.zza.zzn();
                        c0002zzaZzn.zzP(j);
                        byte[] bArrZzaV = c0002zzaZzn.zzbr().zzaV();
                        zzeco.zzf(sQLiteDatabase, false, false);
                        zzeco.zzc(sQLiteDatabase, j, bArrZzaV);
                        return null;
                    }
                });
            }
        }
    }
}
