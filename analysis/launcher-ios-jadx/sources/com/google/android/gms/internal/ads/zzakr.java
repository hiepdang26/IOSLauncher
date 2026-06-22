package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzakr implements zzaka {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzakq zzc;
    private final zzek zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzakr() {
        this(null);
    }

    private static float zzc(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzd(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zze(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = zzet.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzf(com.google.android.gms.internal.ads.zzek r7, java.nio.charset.Charset r8) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakr.zzf(com.google.android.gms.internal.ads.zzek, java.nio.charset.Charset):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b2 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(byte[] r23, int r24, int r25, com.google.android.gms.internal.ads.zzajz r26, com.google.android.gms.internal.ads.zzdn r27) {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakr.zza(byte[], int, int, com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzdn):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }

    public zzakr(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzek();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzA = zzet.zzA((byte[]) list.get(0));
        zzdi.zzd(strZzA.startsWith("Format:"));
        zzakq zzakqVarZza = zzakq.zza(strZzA);
        zzakqVarZza.getClass();
        this.zzc = zzakqVarZza;
        zzf(new zzek((byte[]) list.get(1)), zzfuj.zzc);
    }
}
