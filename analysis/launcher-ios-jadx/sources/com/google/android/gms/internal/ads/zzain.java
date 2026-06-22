package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzain {
    /* JADX WARN: Removed duplicated region for block: B:130:0x0262 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:9:0x0030, B:11:0x003b, B:14:0x004a, B:17:0x0056, B:20:0x0063, B:23:0x0072, B:26:0x007f, B:29:0x008d, B:31:0x0097, B:39:0x00b0, B:40:0x00c1, B:41:0x00d4, B:44:0x00e0, B:47:0x00ed, B:50:0x00fa, B:53:0x0107, B:56:0x0114, B:59:0x0121, B:62:0x012e, B:65:0x013b, B:68:0x014b, B:71:0x015b, B:75:0x016f, B:77:0x0175, B:79:0x0189, B:80:0x0190, B:82:0x0197, B:87:0x01a2, B:92:0x01ae, B:130:0x0262, B:93:0x01c3, B:95:0x01ca, B:97:0x01d4, B:98:0x01e8, B:111:0x0214, B:114:0x0221, B:117:0x022d, B:120:0x0239, B:123:0x0245, B:126:0x0251, B:129:0x025b, B:131:0x0276, B:132:0x027d), top: B:137:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbj zza(com.google.android.gms.internal.ads.zzek r14) {
        /*
            Method dump skipped, instruction units count: 651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zza(com.google.android.gms.internal.ads.zzek):com.google.android.gms.internal.ads.zzbj");
    }

    private static int zzb(zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzL(8);
            int i = iZzg - 16;
            if (i == 1) {
                return zzekVar.zzm();
            }
            if (i == 2) {
                return zzekVar.zzq();
            }
            if (i == 3) {
                return zzekVar.zzo();
            }
            if (i == 4 && (zzekVar.zzf() & 128) == 0) {
                return zzekVar.zzp();
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzagd zzc(int i, String str, zzek zzekVar, boolean z, boolean z2) {
        int iZzb = zzb(zzekVar);
        if (z2) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z ? new zzagm(str, null, zzfxr.zzn(Integer.toString(iZzb))) : new zzafx("und", str, Integer.toString(iZzb));
        }
        zzea.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzahx.zzf(i)));
        return null;
    }

    private static zzagm zzd(int i, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385 && iZzg >= 22) {
            zzekVar.zzL(10);
            int iZzq = zzekVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzq);
                String string = sb.toString();
                int iZzq2 = zzekVar.zzq();
                if (iZzq2 > 0) {
                    string = string + "/" + iZzq2;
                }
                return new zzagm(str, null, zzfxr.zzn(string));
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzahx.zzf(i)));
        return null;
    }

    private static zzagm zze(int i, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzL(8);
            return new zzagm(str, null, zzfxr.zzn(zzekVar.zzz(iZzg - 16)));
        }
        zzea.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzahx.zzf(i)));
        return null;
    }
}
