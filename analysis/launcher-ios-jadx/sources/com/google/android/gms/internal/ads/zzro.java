package com.google.android.gms.internal.ads;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public final class zzro implements zzsa {
    private final zzfvk zza;
    private final zzfvk zzb;
    private boolean zzc;

    public zzro(int i) {
        zzrm zzrmVar = new zzrm(i);
        zzrn zzrnVar = new zzrn(i);
        this.zza = zzrmVar;
        this.zzb = zzrnVar;
        this.zzc = true;
    }

    public static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzrq.zzs(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    public static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzrq.zzs(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: Exception -> 0x0034, TryCatch #2 {Exception -> 0x0034, blocks: (B:4:0x001a, B:6:0x001e, B:11:0x002b, B:16:0x0036, B:18:0x004d, B:17:0x003d), top: B:34:0x001a }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzrp] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.gms.internal.ads.zzrq] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzrq zzc(com.google.android.gms.internal.ads.zzrz r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.lang.String r0 = "createCodec:"
            com.google.android.gms.internal.ads.zzsf r1 = r7.zza
            java.lang.String r1 = r1.zza
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
            r3.<init>(r0)     // Catch: java.lang.Exception -> L6a
            r3.append(r1)     // Catch: java.lang.Exception -> L6a
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L6a
            android.os.Trace.beginSection(r0)     // Catch: java.lang.Exception -> L6a
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch: java.lang.Exception -> L6a
            boolean r1 = r6.zzc     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L3d
            com.google.android.gms.internal.ads.zzaf r1 = r7.zzc     // Catch: java.lang.Exception -> L34
            int r3 = com.google.android.gms.internal.ads.zzet.zza     // Catch: java.lang.Exception -> L34
            r4 = 34
            if (r3 >= r4) goto L27
            goto L3d
        L27:
            r4 = 35
            if (r3 >= r4) goto L36
            java.lang.String r1 = r1.zzm     // Catch: java.lang.Exception -> L34
            boolean r1 = com.google.android.gms.internal.ads.zzbn.zzi(r1)     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L3d
            goto L36
        L34:
            r7 = move-exception
            goto L6c
        L36:
            com.google.android.gms.internal.ads.zztf r1 = new com.google.android.gms.internal.ads.zztf     // Catch: java.lang.Exception -> L34
            r1.<init>(r0)     // Catch: java.lang.Exception -> L34
            r3 = 4
            goto L4d
        L3d:
            com.google.android.gms.internal.ads.zzru r1 = new com.google.android.gms.internal.ads.zzru     // Catch: java.lang.Exception -> L34
            com.google.android.gms.internal.ads.zzfvk r3 = r6.zzb     // Catch: java.lang.Exception -> L34
            com.google.android.gms.internal.ads.zzrn r3 = (com.google.android.gms.internal.ads.zzrn) r3     // Catch: java.lang.Exception -> L34
            int r3 = r3.zza     // Catch: java.lang.Exception -> L34
            android.os.HandlerThread r3 = zzb(r3)     // Catch: java.lang.Exception -> L34
            r1.<init>(r0, r3)     // Catch: java.lang.Exception -> L34
            r3 = 0
        L4d:
            com.google.android.gms.internal.ads.zzrq r4 = new com.google.android.gms.internal.ads.zzrq     // Catch: java.lang.Exception -> L34
            com.google.android.gms.internal.ads.zzfvk r5 = r6.zza     // Catch: java.lang.Exception -> L34
            com.google.android.gms.internal.ads.zzrm r5 = (com.google.android.gms.internal.ads.zzrm) r5     // Catch: java.lang.Exception -> L34
            int r5 = r5.zza     // Catch: java.lang.Exception -> L34
            android.os.HandlerThread r5 = zza(r5)     // Catch: java.lang.Exception -> L34
            r4.<init>(r0, r5, r1, r2)     // Catch: java.lang.Exception -> L34
            android.os.Trace.endSection()     // Catch: java.lang.Exception -> L67
            android.media.MediaFormat r1 = r7.zzb     // Catch: java.lang.Exception -> L67
            android.view.Surface r7 = r7.zzd     // Catch: java.lang.Exception -> L67
            com.google.android.gms.internal.ads.zzrq.zzh(r4, r1, r7, r2, r3)     // Catch: java.lang.Exception -> L67
            return r4
        L67:
            r7 = move-exception
            r2 = r4
            goto L6c
        L6a:
            r7 = move-exception
            r0 = r2
        L6c:
            if (r2 != 0) goto L74
            if (r0 == 0) goto L77
            r0.release()
            goto L77
        L74:
            r2.zzl()
        L77:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzro.zzc(com.google.android.gms.internal.ads.zzrz):com.google.android.gms.internal.ads.zzrq");
    }

    @Override // com.google.android.gms.internal.ads.zzsa
    public final /* bridge */ /* synthetic */ zzsc zzd(zzrz zzrzVar) {
        throw null;
    }

    public final void zze(boolean z) {
        this.zzc = true;
    }
}
