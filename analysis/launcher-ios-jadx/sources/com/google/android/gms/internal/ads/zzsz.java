package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: loaded from: classes.dex */
final class zzsz implements zzsx {
    private zzsz() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final MediaCodecInfo zzb(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zze() {
        return false;
    }

    public /* synthetic */ zzsz(zzsy zzsyVar) {
    }
}
