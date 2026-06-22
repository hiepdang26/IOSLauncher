package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import defpackage.do0;
import defpackage.j52;
import defpackage.k92;
import defpackage.l52;
import defpackage.n42;
import defpackage.nj;
import defpackage.uo;
import defpackage.us;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdln {
    private final l52 zza;
    private final nj zzb;
    private final Executor zzc;

    public zzdln(l52 l52Var, nj njVar, Executor executor) {
        this.zza = l52Var;
        this.zzb = njVar;
        this.zzc = executor;
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        ((us) this.zzb).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        ((us) this.zzb).getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        if (bitmapDecodeByteArray != null) {
            long j = jElapsedRealtime2 - jElapsedRealtime;
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            int allocationByteCount = bitmapDecodeByteArray.getAllocationByteCount();
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sbN = uo.n("Decoded image w: ", width, " h:", height, " bytes: ");
            sbN.append(allocationByteCount);
            sbN.append(" time: ");
            sbN.append(j);
            sbN.append(" on ui thread: ");
            sbN.append(z);
            k92.a(sbN.toString());
        }
        return bitmapDecodeByteArray;
    }

    public final Bitmap zza(double d, boolean z, zzapd zzapdVar) {
        byte[] bArr = zzapdVar.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        zzbbn zzbbnVar = zzbbw.zzfy;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i - 1) / ((Integer) n42Var.c.zza(zzbbw.zzfz)).intValue())) / 2);
            }
        }
        return zzc(bArr, options);
    }

    public final do0 zzb(String str, final double d, final boolean z) {
        this.zza.getClass();
        zzbzt zzbztVar = new zzbzt();
        l52.a.zza(new j52(str, zzbztVar));
        return zzgcj.zzm(zzbztVar, new zzful() { // from class: com.google.android.gms.internal.ads.zzdlm
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zza(d, z, (zzapd) obj);
            }
        }, this.zzc);
    }
}
