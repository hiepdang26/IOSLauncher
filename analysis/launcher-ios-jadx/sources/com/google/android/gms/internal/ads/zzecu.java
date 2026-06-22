package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.hd2;
import defpackage.k92;
import defpackage.or1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzecu {
    private final zzbav zza;
    private final Context zzb;
    private final zzebz zzc;
    private final or1 zzd;

    public zzecu(Context context, or1 or1Var, zzbav zzbavVar, zzebz zzebzVar) {
        this.zzb = context;
        this.zzd = or1Var;
        this.zza = zzbavVar;
        this.zzc = zzebzVar;
    }

    public final Void zza(boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(zzbbc.zzaf.zza.zzx(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzgyn e) {
                k92.e("Unable to deserialize proto from offline signals database:");
                k92.e(e.getMessage());
            }
        }
        cursorQuery.close();
        Context context = this.zzb;
        zzbbc.zzaf.zzc zzcVarZzi = zzbbc.zzaf.zzi();
        zzcVarZzi.zzv(context.getPackageName());
        zzcVarZzi.zzy(Build.MODEL);
        zzcVarZzi.zzA(zzeco.zza(sQLiteDatabase, 0));
        zzcVarZzi.zzh(arrayList);
        zzcVarZzi.zzE(zzeco.zza(sQLiteDatabase, 1));
        zzcVarZzi.zzx(zzeco.zza(sQLiteDatabase, 3));
        hd2.B.j.getClass();
        zzcVarZzi.zzF(System.currentTimeMillis());
        zzcVarZzi.zzB(zzeco.zzb(sQLiteDatabase, 2));
        final zzbbc.zzaf zzafVarZzbr = zzcVarZzi.zzbr();
        int size = arrayList.size();
        long jZze = 0;
        for (int i = 0; i < size; i++) {
            zzbbc.zzaf.zza zzaVar = (zzbbc.zzaf.zza) arrayList.get(i);
            if (zzaVar.zzk() == zzbbc.zzq.ENUM_TRUE && zzaVar.zze() > jZze) {
                jZze = zzaVar.zze();
            }
        }
        if (jZze != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(jZze));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzecs
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar2) {
                zzaVar2.zzW(zzafVarZzbr);
            }
        });
        or1 or1Var = this.zzd;
        zzbbc.zzar.zza zzaVarZzd = zzbbc.zzar.zzd();
        zzaVarZzd.zzg(or1Var.h);
        zzaVarZzd.zzi(this.zzd.i);
        zzaVarZzd.zzh(true != this.zzd.j ? 2 : 0);
        final zzbbc.zzar zzarVarZzbr = zzaVarZzd.zzbr();
        this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzect
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar2) {
                zzbbc.zzm.zza zzaVarZzbM = zzaVar2.zzg().zzbM();
                zzaVarZzbM.zzw(zzarVarZzbr);
                zzaVar2.zzK(zzaVarZzbM);
            }
        });
        this.zza.zzc(10004);
        zzeco.zze(sQLiteDatabase);
        return null;
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfio() { // from class: com.google.android.gms.internal.ads.zzecr
                @Override // com.google.android.gms.internal.ads.zzfio
                public final Object zza(Object obj) {
                    this.zza.zza(z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            k92.e("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
