package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzalw implements zzack {
    private final zzalx zza = new zzalx(null, 0);
    private final zzek zzb = new zzek(2786);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) {
        int iZza = zzaclVar.zza(this.zzb.zzM(), 0, 2786);
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
    
        if ((r5 - r3) >= 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        r9.zzj();
        r5 = r5 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(com.google.android.gms.internal.ads.zzacl r9) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzek r0 = new com.google.android.gms.internal.ads.zzek
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.zzM()
            r5 = r9
            com.google.android.gms.internal.ads.zzaby r5 = (com.google.android.gms.internal.ads.zzaby) r5
            r5.zzm(r4, r2, r1, r2)
            r0.zzK(r2)
            int r4 = r0.zzo()
            r6 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r6) goto L65
            r9.zzj()
            r4 = r9
            com.google.android.gms.internal.ads.zzaby r4 = (com.google.android.gms.internal.ads.zzaby) r4
            r4.zzl(r3, r2)
            r5 = r3
        L29:
            r1 = 0
        L2a:
            byte[] r6 = r0.zzM()
            r7 = 6
            r4.zzm(r6, r2, r7, r2)
            r0.zzK(r2)
            int r6 = r0.zzq()
            r7 = 2935(0xb77, float:4.113E-42)
            if (r6 == r7) goto L4d
            r9.zzj()
            int r5 = r5 + 1
            int r1 = r5 - r3
            r6 = 8192(0x2000, float:1.148E-41)
            if (r1 >= r6) goto L4c
            r4.zzl(r5, r2)
            goto L29
        L4c:
            return r2
        L4d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L53
            return r6
        L53:
            byte[] r6 = r0.zzM()
            int r6 = com.google.android.gms.internal.ads.zzabj.zzb(r6)
            r7 = -1
            if (r6 != r7) goto L5f
            return r2
        L5f:
            int r6 = r6 + (-6)
            r4.zzl(r6, r2)
            goto L2a
        L65:
            r4 = 3
            r0.zzL(r4)
            int r4 = r0.zzl()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.zzl(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalw.zzj(com.google.android.gms.internal.ads.zzacl):boolean");
    }
}
