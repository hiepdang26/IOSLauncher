package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzadw implements zzack {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final int zze;
    private final byte[] zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private zzacn zzo;
    private zzadp zzp;
    private zzadi zzq;
    private boolean zzr;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzb = iArr;
        int i = zzet.zza;
        Charset charset = zzfuj.zzc;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
        zze = iArr[8];
    }

    public zzadw() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[Catch: EOFException -> 0x00b1, TryCatch #0 {EOFException -> 0x00b1, blocks: (B:5:0x000c, B:7:0x0020, B:21:0x003e, B:24:0x0049, B:23:0x0044, B:41:0x0087, B:42:0x009f, B:43:0x00a0, B:44:0x00b0), top: B:46:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: EOFException -> 0x00b1, TryCatch #0 {EOFException -> 0x00b1, blocks: (B:5:0x000c, B:7:0x0020, B:21:0x003e, B:24:0x0049, B:23:0x0044, B:41:0x0087, B:42:0x009f, B:43:0x00a0, B:44:0x00b0), top: B:46:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(com.google.android.gms.internal.ads.zzacl r14) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r13 = this;
            java.lang.String r0 = "Illegal AMR "
            java.lang.String r1 = "Invalid padding bits for frame header "
            int r2 = r13.zzj
            r3 = -1
            r4 = 1
            r5 = 0
            if (r2 == 0) goto Lc
            goto L5b
        Lc:
            r14.zzj()     // Catch: java.io.EOFException -> Lb1
            byte[] r2 = r13.zzf     // Catch: java.io.EOFException -> Lb1
            r6 = r14
            com.google.android.gms.internal.ads.zzaby r6 = (com.google.android.gms.internal.ads.zzaby) r6     // Catch: java.io.EOFException -> Lb1
            r6.zzm(r2, r5, r4, r5)     // Catch: java.io.EOFException -> Lb1
            byte[] r2 = r13.zzf     // Catch: java.io.EOFException -> Lb1
            r2 = r2[r5]     // Catch: java.io.EOFException -> Lb1
            r6 = r2 & 131(0x83, float:1.84E-43)
            r7 = 0
            if (r6 > 0) goto La0
            int r1 = r2 >> 3
            boolean r2 = r13.zzg     // Catch: java.io.EOFException -> Lb1
            r1 = r1 & 15
            if (r2 == 0) goto L31
            r6 = 10
            if (r1 < r6) goto L3c
            r6 = 13
            if (r1 <= r6) goto L31
            goto L3c
        L31:
            if (r2 != 0) goto L80
            r6 = 12
            if (r1 < r6) goto L3c
            r6 = 14
            if (r1 > r6) goto L3c
            goto L80
        L3c:
            if (r2 == 0) goto L44
            int[] r0 = com.google.android.gms.internal.ads.zzadw.zzb     // Catch: java.io.EOFException -> Lb1
            r0 = r0[r1]     // Catch: java.io.EOFException -> Lb1
        L42:
            r2 = r0
            goto L49
        L44:
            int[] r0 = com.google.android.gms.internal.ads.zzadw.zza     // Catch: java.io.EOFException -> Lb1
            r0 = r0[r1]     // Catch: java.io.EOFException -> Lb1
            goto L42
        L49:
            r13.zzi = r2     // Catch: java.io.EOFException -> Lb1
            r13.zzj = r2
            int r0 = r13.zzl
            if (r0 != r3) goto L54
            r13.zzl = r2
            r0 = r2
        L54:
            if (r0 != r2) goto L5b
            int r0 = r13.zzm
            int r0 = r0 + r4
            r13.zzm = r0
        L5b:
            com.google.android.gms.internal.ads.zzadp r0 = r13.zzp
            int r14 = r0.zzf(r14, r2, r4)
            if (r14 != r3) goto L64
            return r3
        L64:
            int r0 = r13.zzj
            int r0 = r0 - r14
            r13.zzj = r0
            if (r0 <= 0) goto L6c
            return r5
        L6c:
            com.google.android.gms.internal.ads.zzadp r6 = r13.zzp
            long r7 = r13.zzh
            int r10 = r13.zzi
            r11 = 0
            r12 = 0
            r9 = 1
            r6.zzs(r7, r9, r10, r11, r12)
            long r0 = r13.zzh
            r2 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r2
            r13.zzh = r0
            return r5
        L80:
            java.lang.String r14 = "WB"
            java.lang.String r5 = "NB"
            if (r4 == r2) goto L87
            r14 = r5
        L87:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> Lb1
            r2.<init>(r0)     // Catch: java.io.EOFException -> Lb1
            r2.append(r14)     // Catch: java.io.EOFException -> Lb1
            java.lang.String r14 = " frame type "
            r2.append(r14)     // Catch: java.io.EOFException -> Lb1
            r2.append(r1)     // Catch: java.io.EOFException -> Lb1
            java.lang.String r14 = r2.toString()     // Catch: java.io.EOFException -> Lb1
            com.google.android.gms.internal.ads.zzbo r14 = com.google.android.gms.internal.ads.zzbo.zza(r14, r7)     // Catch: java.io.EOFException -> Lb1
            throw r14     // Catch: java.io.EOFException -> Lb1
        La0:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> Lb1
            r14.<init>(r1)     // Catch: java.io.EOFException -> Lb1
            r14.append(r2)     // Catch: java.io.EOFException -> Lb1
            java.lang.String r14 = r14.toString()     // Catch: java.io.EOFException -> Lb1
            com.google.android.gms.internal.ads.zzbo r14 = com.google.android.gms.internal.ads.zzbo.zza(r14, r7)     // Catch: java.io.EOFException -> Lb1
            throw r14     // Catch: java.io.EOFException -> Lb1
        Lb1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadw.zza(com.google.android.gms.internal.ads.zzacl):int");
    }

    private static boolean zzg(zzacl zzaclVar, byte[] bArr) {
        zzaclVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzaby) zzaclVar).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        byte[] bArr = zzc;
        if (zzg(zzaclVar, bArr)) {
            this.zzg = false;
            ((zzaby) zzaclVar).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzaclVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        ((zzaby) zzaclVar).zzo(bArr2.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws zzbo {
        zzdi.zzb(this.zzp);
        int i = zzet.zza;
        if (zzaclVar.zzf() == 0 && !zzh(zzaclVar)) {
            throw zzbo.zza("Could not find AMR header.", null);
        }
        if (!this.zzr) {
            this.zzr = true;
            boolean z = this.zzg;
            String str = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            zzadp zzadpVar = this.zzp;
            zzad zzadVar = new zzad();
            zzadVar.zzX(str);
            zzadVar.zzP(zze);
            zzadVar.zzy(1);
            zzadVar.zzY(i2);
            zzadpVar.zzl(zzadVar.zzad());
        }
        int iZza = zza(zzaclVar);
        if (this.zzk) {
            return iZza;
        }
        zzadh zzadhVar = new zzadh(-9223372036854775807L, 0L);
        this.zzq = zzadhVar;
        this.zzo.zzO(zzadhVar);
        this.zzk = true;
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzo = zzacnVar;
        this.zzp = zzacnVar.zzw(0, 1);
        zzacnVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        return zzh(zzaclVar);
    }

    public zzadw(int i) {
        this.zzf = new byte[1];
        this.zzl = -1;
    }
}
