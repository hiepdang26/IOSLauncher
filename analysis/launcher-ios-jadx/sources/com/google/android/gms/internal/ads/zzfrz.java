package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.k31;
import defpackage.uo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class zzfrz {
    static final String zza = new UUID(0, 0).toString();
    final zzfsa zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public zzfrz(Context context, String str, String str2, String str3) {
        this.zzb = zzfsa.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes(uo.i(str, str2, str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        StringBuilder sbM = k31.m(this.zzg, ": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        sbM.append(str2 == null ? "null" : "not null");
        sbM.append(", hashKey is ");
        sbM.append(str3 == null ? "null" : "not null");
        throw new IllegalArgumentException(sbM.toString());
    }

    public final long zza(boolean z) {
        return this.zzb.zza(z ? this.zzf : this.zze, -1L);
    }

    public final zzfry zzb(String str, String str2, long j, boolean z) throws IOException {
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String strZze = zze(true);
                    String strZzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (strZze != null && strZzc != null && !strZze.equals(zzh(str, str2, strZzc))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfry();
        }
        boolean z2 = str != null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        long jZza = zza(z2);
        if (jZza != -1) {
            if (jCurrentTimeMillis < jZza) {
                this.zzb.zzd(z2 ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
            } else if (jCurrentTimeMillis >= jZza + j) {
                return zzc(str, str2);
            }
        }
        String strZze2 = zze(z2);
        return (strZze2 != null || z) ? new zzfry(strZze2, zza(z2)) : zzc(str, str2);
    }

    public final zzfry zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", string);
        return zzd(zzh(str, str2, string), true);
    }

    public final zzfry zzd(String str, boolean z) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        this.zzb.zzd(z ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
        this.zzb.zzd(z ? this.zzd : this.zzc, str);
        return new zzfry(str, jCurrentTimeMillis);
    }

    public final String zze(boolean z) {
        return this.zzb.zzc(z ? this.zzd : this.zzc, null);
    }

    public final void zzf(boolean z) throws IOException {
        this.zzb.zze(z ? this.zzf : this.zze);
        this.zzb.zze(z ? this.zzd : this.zzc);
    }

    public final boolean zzg(boolean z) {
        return this.zzb.zzg(this.zzc);
    }
}
