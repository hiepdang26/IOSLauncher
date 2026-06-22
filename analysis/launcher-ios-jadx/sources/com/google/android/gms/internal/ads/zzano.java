package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzano implements zzack {
    private final int zza;
    private final List zzb;
    private final zzek zzc;
    private final SparseIntArray zzd;
    private final zzanr zze;
    private final zzajy zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzanl zzj;
    private zzank zzk;
    private zzacn zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzano() {
        this(1, 1, zzajy.zza, new zzer(0L), new zzamc(0), 112800);
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x01ba  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r20, com.google.android.gms.internal.ads.zzadf r21) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
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
        if (this.zza == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zzf);
        }
        this.zzl = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(long r10, long r12) {
        /*
            r9 = this;
            java.util.List r10 = r9.zzb
            int r10 = r10.size()
            r11 = 0
            r0 = 0
        L8:
            r1 = 0
            if (r0 >= r10) goto L37
            java.util.List r3 = r9.zzb
            java.lang.Object r3 = r3.get(r0)
            com.google.android.gms.internal.ads.zzer r3 = (com.google.android.gms.internal.ads.zzer) r3
            long r4 = r3.zzf()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L31
            long r4 = r3.zzd()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L34
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L34
            int r1 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r1 == 0) goto L34
        L31:
            r3.zzi(r12)
        L34:
            int r0 = r0 + 1
            goto L8
        L37:
            int r10 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r10 == 0) goto L42
            com.google.android.gms.internal.ads.zzank r10 = r9.zzk
            if (r10 == 0) goto L42
            r10.zzd(r12)
        L42:
            com.google.android.gms.internal.ads.zzek r10 = r9.zzc
            r10.zzH(r11)
            android.util.SparseIntArray r10 = r9.zzd
            r10.clear()
            r10 = 0
        L4d:
            android.util.SparseArray r12 = r9.zzg
            int r12 = r12.size()
            if (r10 >= r12) goto L63
            android.util.SparseArray r12 = r9.zzg
            java.lang.Object r12 = r12.valueAt(r10)
            com.google.android.gms.internal.ads.zzant r12 = (com.google.android.gms.internal.ads.zzant) r12
            r12.zzc()
            int r10 = r10 + 1
            goto L4d
        L63:
            r9.zzq = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzi(long, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(com.google.android.gms.internal.ads.zzacl r7) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzek r0 = r6.zzc
            byte[] r0 = r0.zzM()
            com.google.android.gms.internal.ads.zzaby r7 = (com.google.android.gms.internal.ads.zzaby) r7
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.zzm(r0, r2, r1, r2)
            r1 = 0
        Lf:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L2b
            r3 = 0
        L14:
            r4 = 5
            if (r3 >= r4) goto L26
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L23
            int r1 = r1 + 1
            goto Lf
        L23:
            int r3 = r3 + 1
            goto L14
        L26:
            r7.zzo(r1, r2)
            r7 = 1
            return r7
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzano.zzj(com.google.android.gms.internal.ads.zzacl):boolean");
    }

    public zzano(int i, int i2, zzajy zzajyVar, zzer zzerVar, zzanr zzanrVar, int i3) {
        this.zze = zzanrVar;
        this.zza = i2;
        this.zzf = zzajyVar;
        this.zzb = Collections.singletonList(zzerVar);
        this.zzc = new zzek(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzanl(112800);
        this.zzl = zzacn.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArray2.keyAt(i4), (zzant) sparseArray2.valueAt(i4));
        }
        this.zzg.put(0, new zzanh(new zzanm(this)));
    }
}
