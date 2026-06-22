package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Trace;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzry implements zzsa {
    private final Context zza;

    @Deprecated
    public zzry() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzsa
    public final zzsc zzd(zzrz zzrzVar) throws Throwable {
        MediaCodec mediaCodecCreateByCodecName;
        Context context;
        int i = zzet.zza;
        if (i >= 23 && (i >= 31 || ((context = this.zza) != null && i >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen")))) {
            int iZzb = zzbn.zzb(zzrzVar.zzc.zzm);
            zzea.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzet.zzC(iZzb)));
            zzro zzroVar = new zzro(iZzb);
            zzroVar.zze(true);
            return zzroVar.zzc(zzrzVar);
        }
        MediaCodec mediaCodec = null;
        try {
            String str = zzrzVar.zza.zza;
            Trace.beginSection("createCodec:".concat(str));
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        try {
            Trace.beginSection("configureCodec");
            mediaCodecCreateByCodecName.configure(zzrzVar.zzb, zzrzVar.zzd, (MediaCrypto) null, 0);
            Trace.endSection();
            Trace.beginSection("startCodec");
            mediaCodecCreateByCodecName.start();
            Trace.endSection();
            return new zzte(mediaCodecCreateByCodecName, null);
        } catch (IOException | RuntimeException e3) {
            e = e3;
            mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
    }

    public zzry(Context context) {
        this.zza = context;
    }
}
