package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzfsa {
    private static zzfsa zza;
    private final String zzb;
    private final SharedPreferences zzc;

    private zzfsa(Context context) {
        this.zzb = context.getPackageName();
        this.zzc = context.getSharedPreferences("paid_storage_sp", 0);
    }

    public static zzfsa zzb(Context context) {
        if (zza == null) {
            zza = new zzfsa(context);
        }
        return zza;
    }

    public final long zza(String str, long j) {
        return this.zzc.getLong(str, -1L);
    }

    public final String zzc(String str, String str2) {
        return this.zzc.getString(str, null);
    }

    public final void zzd(String str, Object obj) throws IOException {
        boolean zCommit;
        if (obj instanceof String) {
            zCommit = this.zzc.edit().putString(str, (String) obj).commit();
        } else if (obj instanceof Long) {
            zCommit = this.zzc.edit().putLong(str, ((Long) obj).longValue()).commit();
        } else {
            if (!(obj instanceof Boolean)) {
                String.valueOf(obj.getClass());
                throw new IOException("Failed to store " + str + " for app " + this.zzb);
            }
            zCommit = this.zzc.edit().putBoolean(str, ((Boolean) obj).booleanValue()).commit();
        }
        if (zCommit) {
            return;
        }
        throw new IOException("Failed to store " + str + " for app " + this.zzb);
    }

    public final void zze(String str) throws IOException {
        if (this.zzc.edit().remove(str).commit()) {
            return;
        }
        throw new IOException("Failed to remove " + str + " for app " + this.zzb);
    }

    public final boolean zzf(String str, boolean z) {
        return this.zzc.getBoolean(str, true);
    }

    public final boolean zzg(String str) {
        return this.zzc.contains(str);
    }
}
