package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import defpackage.n90;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpw {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfpw(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfpx.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfpx.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzaxi r8, com.google.android.gms.internal.ads.zzfqc r9) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfpw.zza(com.google.android.gms.internal.ads.zzaxi, com.google.android.gms.internal.ads.zzfqc):boolean");
    }

    public final zzaxl zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrD = n90.D(string);
            zzaxl zzaxlVarZzh = zzaxl.zzh(zzgwm.zzv(bArrD, 0, bArrD.length));
            String strZzk = zzaxlVarZzh.zzk();
            File fileZzb = zzfpx.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfpx.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfpx.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists()) {
                if (fileZzb2.exists()) {
                    return zzaxlVarZzh;
                }
            }
        } catch (zzgyn unused) {
        }
        return null;
    }

    public final zzfpv zzc(int i) {
        zzaxl zzaxlVarZzb = zzb(1);
        if (zzaxlVarZzb == null) {
            return null;
        }
        String strZzk = zzaxlVarZzb.zzk();
        File fileZzb = zzfpx.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfpx.zzb(strZzk, "pcam", zzd());
        }
        return new zzfpv(zzaxlVarZzb, fileZzb, zzfpx.zzb(strZzk, "pcbc", zzd()), zzfpx.zzb(strZzk, "pcopt", zzd()));
    }
}
