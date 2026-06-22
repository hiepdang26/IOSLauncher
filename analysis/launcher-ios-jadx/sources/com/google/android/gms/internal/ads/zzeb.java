package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzeb {
    private int zza;
    private long[] zzb;

    public zzeb() {
        throw null;
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i) {
        if (i < 0 || i >= this.zza) {
            throw new IndexOutOfBoundsException(k31.j(i, this.zza, "Invalid index ", ", size is "));
        }
        return this.zzb[i];
    }

    public final void zzc(long j) {
        int i = this.zza;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i + i);
        }
        long[] jArr2 = this.zzb;
        int i2 = this.zza;
        this.zza = i2 + 1;
        jArr2[i2] = j;
    }

    public zzeb(int i) {
        this.zzb = new long[32];
    }
}
