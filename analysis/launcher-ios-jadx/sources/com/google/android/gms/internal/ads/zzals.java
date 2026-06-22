package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzals implements zzaka {
    private final zzek zza = new zzek();
    private final zzali zzb = new zzali();

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdn zzdnVar) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzek zzekVar = this.zza;
            int iZzd = zzekVar.zzd();
            Charset charset = zzfuj.zzc;
            String strZzy = zzekVar.zzy(charset);
            if (strZzy == null || !strZzy.startsWith("WEBVTT")) {
                zzekVar.zzK(iZzd);
                throw zzbo.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzekVar.zzy(charset))), null);
            }
            while (!TextUtils.isEmpty(this.zza.zzy(zzfuj.zzc))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzek zzekVar2 = this.zza;
                byte b = -1;
                int iZzd2 = 0;
                while (b == -1) {
                    iZzd2 = zzekVar2.zzd();
                    String strZzy2 = zzekVar2.zzy(zzfuj.zzc);
                    b = strZzy2 == null ? (byte) 0 : "STYLE".equals(strZzy2) ? (byte) 2 : strZzy2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                }
                zzekVar2.zzK(iZzd2);
                if (b == 0) {
                    zzaju.zza(new zzalv(arrayList2), zzajzVar, zzdnVar);
                    return;
                }
                if (b == 1) {
                    while (!TextUtils.isEmpty(this.zza.zzy(zzfuj.zzc))) {
                    }
                } else if (b != 2) {
                    zzalk zzalkVarZzc = zzalr.zzc(this.zza, arrayList);
                    if (zzalkVarZzc != null) {
                        arrayList2.add(zzalkVarZzc);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.zza.zzy(zzfuj.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                }
            }
        } catch (zzbo e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
