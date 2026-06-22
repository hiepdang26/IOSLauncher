package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzaqa {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public zzaqa(String str, zzaoq zzaoqVar) {
        String str2 = zzaoqVar.zzb;
        long j = zzaoqVar.zzc;
        long j2 = zzaoqVar.zzd;
        long j3 = zzaoqVar.zze;
        long j4 = zzaoqVar.zzf;
        ?? arrayList = zzaoqVar.zzh;
        if (arrayList == 0) {
            Map map = zzaoqVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzaoz((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    public static zzaqa zza(zzaqb zzaqbVar) throws IOException {
        if (zzaqd.zze(zzaqbVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqd.zzh(zzaqbVar);
        String strZzh2 = zzaqd.zzh(zzaqbVar);
        long jZzf = zzaqd.zzf(zzaqbVar);
        long jZzf2 = zzaqd.zzf(zzaqbVar);
        long jZzf3 = zzaqd.zzf(zzaqbVar);
        long jZzf4 = zzaqd.zzf(zzaqbVar);
        int iZze = zzaqd.zze(zzaqbVar);
        if (iZze < 0) {
            throw new IOException(k31.k(iZze, "readHeaderList size="));
        }
        List arrayList = iZze == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i = 0; i < iZze; i++) {
            arrayList.add(new zzaoz(zzaqd.zzh(zzaqbVar).intern(), zzaqd.zzh(zzaqbVar).intern()));
        }
        return new zzaqa(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, arrayList);
    }

    private zzaqa(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
