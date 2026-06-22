package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaly implements zzack {
    private final zzalz zza = new zzalz(null, 0);
    private final zzek zzb = new zzek(16384);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) {
        int iZza = zzaclVar.zza(this.zzb.zzM(), 0, 16384);
        if (iZza == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(iZza);
        if (!this.zzc) {
            this.zza.zzd(0L, 4);
            this.zzc = true;
        }
        this.zza.zza(this.zzb);
        return 0;
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
        this.zza.zzb(zzacnVar, new zzans(RtlSpacingHelper.UNDEFINED, 0, 1));
        zzacnVar.zzD();
        zzacnVar.zzO(new zzadh(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
    
        r16.zzj();
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
    
        if ((r5 - r3) >= 8192) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        return false;
     */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(com.google.android.gms.internal.ads.zzacl r16) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r15 = this;
            com.google.android.gms.internal.ads.zzek r0 = new com.google.android.gms.internal.ads.zzek
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.zzM()
            r5 = r16
            com.google.android.gms.internal.ads.zzaby r5 = (com.google.android.gms.internal.ads.zzaby) r5
            r5.zzm(r4, r2, r1, r2)
            r0.zzK(r2)
            int r4 = r0.zzo()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L9c
            r16.zzj()
            r4 = r16
            com.google.android.gms.internal.ads.zzaby r4 = (com.google.android.gms.internal.ads.zzaby) r4
            r4.zzl(r3, r2)
            r5 = r3
        L2c:
            r1 = 0
        L2d:
            byte[] r6 = r0.zzM()
            r8 = 7
            r4.zzm(r6, r2, r8, r2)
            r0.zzK(r2)
            int r6 = r0.zzq()
            r9 = 44096(0xac40, float:6.1792E-41)
            r10 = 44097(0xac41, float:6.1793E-41)
            if (r6 == r9) goto L56
            if (r6 == r10) goto L56
            r16.zzj()
            int r5 = r5 + 1
            int r1 = r5 - r3
            r6 = 8192(0x2000, float:1.148E-41)
            if (r1 >= r6) goto L55
            r4.zzl(r5, r2)
            goto L2c
        L55:
            return r2
        L56:
            r9 = 1
            int r1 = r1 + r9
            r11 = 4
            if (r1 < r11) goto L5c
            return r9
        L5c:
            byte[] r9 = r0.zzM()
            int r12 = r9.length
            r13 = -1
            if (r12 >= r8) goto L66
            r12 = -1
            goto L93
        L66:
            r12 = 2
            r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r14 = r9[r7]
            int r12 = r12 << 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r12 = r12 | r14
            r14 = 65535(0xffff, float:9.1834E-41)
            if (r12 != r14) goto L8d
            r11 = r9[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r12 = 5
            r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            int r12 = r12 << 8
            r14 = 6
            r9 = r9[r14]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r11 = r11 | r12
            r12 = r11 | r9
            goto L8e
        L8d:
            r8 = 4
        L8e:
            if (r6 != r10) goto L92
            int r8 = r8 + 2
        L92:
            int r12 = r12 + r8
        L93:
            if (r12 != r13) goto L96
            return r2
        L96:
            int r12 = r12 + (-7)
            r4.zzl(r12, r2)
            goto L2d
        L9c:
            r0.zzL(r7)
            int r4 = r0.zzl()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.zzl(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaly.zzj(com.google.android.gms.internal.ads.zzacl):boolean");
    }
}
