package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import defpackage.sc2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzsg {
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        defpackage.sc2.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
    
        if (zzb(r6, defpackage.sc2.a()) != 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(android.media.MediaCodecInfo.VideoCapabilities r2, int r3, int r4, double r5) {
        /*
            java.util.List r2 = defpackage.sc2.d(r2)
            r0 = 0
            if (r2 == 0) goto L9e
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto Lf
            goto L9e
        Lf:
            int r5 = (int) r5
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r3 = defpackage.sc2.b(r3, r4, r5)
            int r2 = zzb(r2, r3)
            r3 = 1
            if (r2 != r3) goto L9d
            java.lang.Boolean r4 = com.google.android.gms.internal.ads.zzsh.zzb()
            if (r4 != 0) goto L9d
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 35
            if (r4 < r5) goto L29
        L27:
            r3 = 0
            goto L8b
        L29:
            com.google.android.gms.internal.ads.zzad r4 = new com.google.android.gms.internal.ads.zzad     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            r4.<init>()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            java.lang.String r5 = "video/avc"
            r4.zzX(r5)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            com.google.android.gms.internal.ads.zzaf r4 = r4.zzad()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            java.lang.String r5 = r4.zzm     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r5 == 0) goto L8b
            com.google.android.gms.internal.ads.zzsq r5 = com.google.android.gms.internal.ads.zzsq.zza     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            java.util.List r4 = com.google.android.gms.internal.ads.zztc.zzf(r5, r4, r0, r0)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            r5 = 0
        L42:
            int r6 = r4.size()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r5 >= r6) goto L8b
            java.lang.Object r6 = r4.get(r5)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            com.google.android.gms.internal.ads.zzsf r6 = (com.google.android.gms.internal.ads.zzsf) r6     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r6 == 0) goto L88
            java.lang.Object r6 = r4.get(r5)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            com.google.android.gms.internal.ads.zzsf r6 = (com.google.android.gms.internal.ads.zzsf) r6     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r6 == 0) goto L88
            java.lang.Object r6 = r4.get(r5)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            com.google.android.gms.internal.ads.zzsf r6 = (com.google.android.gms.internal.ads.zzsf) r6     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            java.util.List r6 = defpackage.sc2.d(r6)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r6 == 0) goto L88
            boolean r1 = r6.isEmpty()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r1 != 0) goto L88
            defpackage.sc2.e()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = defpackage.sc2.a()     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            int r4 = zzb(r6, r4)     // Catch: com.google.android.gms.internal.ads.zzsw -> L86
            if (r4 != r3) goto L27
            goto L8b
        L86:
            goto L8b
        L88:
            int r5 = r5 + 1
            goto L42
        L8b:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            com.google.android.gms.internal.ads.zzsh.zzc(r3)
            java.lang.Boolean r3 = com.google.android.gms.internal.ads.zzsh.zzb()
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L9d
            goto L9e
        L9d:
            return r2
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsg.zza(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (sc2.c(list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
