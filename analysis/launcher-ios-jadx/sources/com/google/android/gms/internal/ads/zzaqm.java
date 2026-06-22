package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzaqm extends zzaph {
    private final Object zza;
    private final zzapm zzb;

    public zzaqm(int i, String str, zzapm zzapmVar, zzapl zzaplVar) {
        super(i, str, zzaplVar);
        this.zza = new Object();
        this.zzb = zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapn zzh(zzapd zzapdVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapdVar.zzb;
            Map map = zzapdVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapdVar.zzb);
        }
        return zzapn.zzb(str, zzaqe.zzb(zzapdVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzapm zzapmVar;
        synchronized (this.zza) {
            zzapmVar = this.zzb;
        }
        zzapmVar.zza(str);
    }
}
