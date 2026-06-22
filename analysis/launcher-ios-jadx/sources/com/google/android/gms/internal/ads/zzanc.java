package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
final class zzanc extends zzabu {
    public zzanc(zzer zzerVar, long j, long j2) {
        super(new zzabp(), new zzanb(zzerVar, null), j, 0L, j + 1, 0L, j2, 188L, zzbbc.zzq.zzf);
    }

    public static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
