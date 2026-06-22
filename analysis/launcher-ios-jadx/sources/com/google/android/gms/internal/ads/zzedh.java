package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import defpackage.cd2;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.r52;
import defpackage.tc2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzedh extends SQLiteOpenHelper {
    private final Context zza;
    private final zzgcu zzb;

    public zzedh(Context context, zzgcu zzgcuVar) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) n42.d.c.zza(zzbbw.zzhA)).intValue());
        this.zza = context;
        this.zzb = zzgcuVar;
    }

    public static /* synthetic */ Void zzb(tc2 tc2Var, SQLiteDatabase sQLiteDatabase) throws Throwable {
        zzj(sQLiteDatabase, tc2Var);
        return null;
    }

    public static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, tc2 tc2Var) throws Throwable {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, tc2Var);
    }

    public static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, tc2 tc2Var) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase2 = sQLiteDatabase;
            try {
                Cursor cursorQuery = sQLiteDatabase2.query("offline_buffered_pings", new String[]{"url"}, "event_state = 1", null, null, null, "timestamp ASC", null);
                int count = cursorQuery.getCount();
                String[] strArr = new String[count];
                int i = 0;
                while (cursorQuery.moveToNext()) {
                    int columnIndex = cursorQuery.getColumnIndex("url");
                    if (columnIndex != -1) {
                        strArr[i] = cursorQuery.getString(columnIndex);
                    }
                    i++;
                }
                cursorQuery.close();
                sQLiteDatabase2.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
                sQLiteDatabase2.setTransactionSuccessful();
                sQLiteDatabase2.endTransaction();
                for (int i2 = 0; i2 < count; i2++) {
                    tc2Var.zza(strArr[i2]);
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                sQLiteDatabase2.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final Void zza(zzedj zzedjVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzedjVar.zza));
        contentValues.put("gws_query_id", zzedjVar.zzb);
        contentValues.put("url", zzedjVar.zzc);
        contentValues.put("event_state", Integer.valueOf(zzedjVar.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        cd2 cd2Var = hd2.B.c;
        r52 r52VarJ = cd2.J(this.zza);
        if (r52VarJ != null) {
            try {
                r52VarJ.zze(new gy0(this.zza));
            } catch (RemoteException unused) {
                k92.b();
            }
        }
        return null;
    }

    public final void zzc(final String str) {
        zze(new zzfio(this) { // from class: com.google.android.gms.internal.ads.zzedf
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                zzedh.zzi((SQLiteDatabase) obj, str);
                return null;
            }
        });
    }

    public final void zzd(final zzedj zzedjVar) {
        zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzedb
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                this.zza.zza(zzedjVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    public final void zze(zzfio zzfioVar) {
        zzgcj.zzr(this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzedd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.getWritableDatabase();
            }
        }), new zzedg(this, zzfioVar), this.zzb);
    }

    public final void zzg(final SQLiteDatabase sQLiteDatabase, final tc2 tc2Var, final String str) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzede
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzedh.zzf(sQLiteDatabase, str, tc2Var);
            }
        });
    }

    public final void zzh(final tc2 tc2Var, final String str) {
        zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzedc
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                this.zza.zzg((SQLiteDatabase) obj, tc2Var, str);
                return null;
            }
        });
    }
}
