package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzadv {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzbk zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzet.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzea.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafj.zzb(new zzek(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e) {
                    zzea.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzaha(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbk(arrayList);
    }

    public static zzads zzc(zzek zzekVar, boolean z, boolean z2) throws zzbo {
        if (z) {
            zzd(3, zzekVar, false);
        }
        String strZzA = zzekVar.zzA((int) zzekVar.zzs(), zzfuj.zzc);
        int length = strZzA.length();
        long jZzs = zzekVar.zzs();
        String[] strArr = new String[(int) jZzs];
        int length2 = length + 15;
        for (int i = 0; i < jZzs; i++) {
            String strZzA2 = zzekVar.zzA((int) zzekVar.zzs(), zzfuj.zzc);
            strArr[i] = strZzA2;
            length2 = length2 + 4 + strZzA2.length();
        }
        if (z2 && (zzekVar.zzm() & 1) == 0) {
            throw zzbo.zza("framing bit expected to be set", null);
        }
        return new zzads(strZzA, strArr, length2 + 1);
    }

    public static boolean zzd(int i, zzek zzekVar, boolean z) throws zzbo {
        if (zzekVar.zzb() < 7) {
            if (z) {
                return false;
            }
            throw zzbo.zza("too short header: " + zzekVar.zzb(), null);
        }
        if (zzekVar.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzbo.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzekVar.zzm() == 118 && zzekVar.zzm() == 111 && zzekVar.zzm() == 114 && zzekVar.zzm() == 98 && zzekVar.zzm() == 105 && zzekVar.zzm() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzbo.zza("expected characters 'vorbis'", null);
    }
}
