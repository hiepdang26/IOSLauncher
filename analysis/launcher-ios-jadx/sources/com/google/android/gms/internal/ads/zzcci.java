package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcci extends zzaqq {
    static final zzcci zzb = new zzcci();

    @Override // com.google.android.gms.internal.ads.zzaqq
    public final zzaqu zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzaqw() : "mvhd".equals(str) ? new zzaqx() : new zzaqy(str);
    }
}
