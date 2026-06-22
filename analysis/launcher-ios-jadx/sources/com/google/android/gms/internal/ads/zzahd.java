package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
final class zzahd implements zzahf {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzahl zzc = new zzahl();
    private zzahe zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzacl zzaclVar, int i) throws EOFException, InterruptedIOException {
        ((zzaby) zzaclVar).zzn(this.zza, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zza[i2] & 255));
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(zzahe zzaheVar) {
        this.zzd = zzaheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[LOOP:0: B:3:0x0005->B:37:0x00b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0167 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzahf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r14) throws com.google.android.gms.internal.ads.zzbo, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahd.zzc(com.google.android.gms.internal.ads.zzacl):boolean");
    }
}
