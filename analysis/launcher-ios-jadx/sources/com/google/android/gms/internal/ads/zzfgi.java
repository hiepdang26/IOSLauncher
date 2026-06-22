package com.google.android.gms.internal.ads;

import defpackage.j92;
import defpackage.m42;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgi {
    public static j92 zza(Throwable th) {
        if (th instanceof zzeex) {
            zzeex zzeexVar = (zzeex) th;
            return zzc(zzeexVar.zza(), zzeexVar.zzb());
        }
        if (th instanceof zzdwl) {
            return th.getMessage() == null ? zzd(((zzdwl) th).zza(), null, null) : zzd(((zzdwl) th).zza(), th.getMessage(), null);
        }
        if (!(th instanceof m42)) {
            return zzd(1, null, null);
        }
        m42 m42Var = (m42) th;
        return new j92(m42Var.g, zzfvj.zzc(m42Var.getMessage()), "com.google.android.gms.ads", null, null);
    }

    public static j92 zzb(Throwable th, zzeey zzeeyVar) {
        j92 j92Var;
        j92 j92VarZza = zza(th);
        int i = j92VarZza.g;
        if ((i == 3 || i == 0) && (j92Var = j92VarZza.j) != null && !j92Var.i.equals("com.google.android.gms.ads")) {
            j92VarZza.j = null;
        }
        if (zzeeyVar != null) {
            j92VarZza.k = zzeeyVar.zzb();
        }
        return j92VarZza;
    }

    public static j92 zzc(int i, j92 j92Var) {
        if (i == 0) {
            throw null;
        }
        if (i == 8) {
            if (((Integer) n42.d.c.zza(zzbbw.zzhv)).intValue() > 0) {
                return j92Var;
            }
            i = 8;
        }
        return zzd(i, null, j92Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.j92 zzd(int r8, java.lang.String r9, defpackage.j92 r10) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgi.zzd(int, java.lang.String, j92):j92");
    }
}
