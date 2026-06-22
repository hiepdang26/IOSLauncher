package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
final class zzaky {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzale zzf;
    public final String zzg;
    public final String zzh;
    public final zzaky zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzaky(String str, String str2, long j, long j2, zzale zzaleVar, String[] strArr, String str3, String str4, zzaky zzakyVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzaleVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzakyVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzaky zzb(String str, long j, long j2, zzale zzaleVar, String[] strArr, String str2, String str3, zzaky zzakyVar) {
        return new zzaky(str, null, j, j2, zzaleVar, strArr, str2, str3, zzakyVar);
    }

    public static zzaky zzc(String str) {
        return new zzaky(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcz zzczVar = new zzcz();
            zzczVar.zzl(new SpannableStringBuilder());
            map.put(str, zzczVar);
        }
        CharSequence charSequenceZzq = ((zzcz) map.get(str)).zzq();
        charSequenceZzq.getClass();
        return (SpannableStringBuilder) charSequenceZzq;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z || zEquals || (zEquals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzaky zzakyVar = (zzaky) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzakyVar.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (zzg(j) && "div".equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zza(); i++) {
            zzd(i).zzk(j, str, list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzl(long r19, java.util.Map r21, java.util.Map r22, java.lang.String r23, java.util.Map r24) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaky.zzl(long, java.util.Map, java.util.Map, java.lang.String, java.util.Map):void");
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        long j2;
        Map map2;
        boolean z2;
        this.zzk.clear();
        this.zzl.clear();
        if ("metadata".equals(this.zza)) {
            return;
        }
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        String str2 = str;
        if (this.zzc && z) {
            SpannableStringBuilder spannableStringBuilderZzi = zzi(str2, map);
            String str3 = this.zzb;
            str3.getClass();
            spannableStringBuilderZzi.append((CharSequence) str3);
            return;
        }
        if ("br".equals(this.zza) && z) {
            zzi(str2, map).append('\n');
            return;
        }
        if (zzg(j)) {
            for (Map.Entry entry : map.entrySet()) {
                HashMap map3 = this.zzk;
                String str4 = (String) entry.getKey();
                CharSequence charSequenceZzq = ((zzcz) entry.getValue()).zzq();
                charSequenceZzq.getClass();
                map3.put(str4, Integer.valueOf(charSequenceZzq.length()));
            }
            boolean zEquals = "p".equals(this.zza);
            int i = 0;
            while (i < zza()) {
                zzaky zzakyVarZzd = zzd(i);
                if (z || zEquals) {
                    j2 = j;
                    map2 = map;
                    z2 = true;
                } else {
                    j2 = j;
                    map2 = map;
                    z2 = false;
                }
                zzakyVarZzd.zzm(j2, z2, str2, map2);
                i++;
                j = j2;
                map = map2;
            }
            Map map4 = map;
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzi2 = zzi(str2, map4);
                int length = spannableStringBuilderZzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzi2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzi2.charAt(length) != '\n') {
                    spannableStringBuilderZzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map4.entrySet()) {
                HashMap map5 = this.zzl;
                String str5 = (String) entry2.getKey();
                CharSequence charSequenceZzq2 = ((zzcz) entry2.getValue()).zzq();
                charSequenceZzq2.getClass();
                map5.put(str5, Integer.valueOf(charSequenceZzq2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzaky zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzaky) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        zzk(j, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j, false, this.zzg, treeMap);
        zzl(j, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzalc zzalcVar = (zzalc) map2.get(pair.first);
                zzalcVar.getClass();
                zzcz zzczVar = new zzcz();
                zzczVar.zzc(bitmapDecodeByteArray);
                zzczVar.zzh(zzalcVar.zzb);
                zzczVar.zzi(0);
                zzczVar.zze(zzalcVar.zzc, 0);
                zzczVar.zzf(zzalcVar.zze);
                zzczVar.zzk(zzalcVar.zzf);
                zzczVar.zzd(zzalcVar.zzg);
                zzczVar.zzo(zzalcVar.zzj);
                arrayList2.add(zzczVar.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalc zzalcVar2 = (zzalc) map2.get(entry.getKey());
            zzalcVar2.getClass();
            zzcz zzczVar2 = (zzcz) entry.getValue();
            CharSequence charSequenceZzq = zzczVar2.zzq();
            charSequenceZzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzq;
            for (zzakw zzakwVar : (zzakw[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzakw.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzakwVar), spannableStringBuilder.getSpanEnd(zzakwVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzczVar2.zze(zzalcVar2.zzc, zzalcVar2.zzd);
            zzczVar2.zzf(zzalcVar2.zze);
            zzczVar2.zzh(zzalcVar2.zzb);
            zzczVar2.zzk(zzalcVar2.zzf);
            zzczVar2.zzn(zzalcVar2.zzi, zzalcVar2.zzh);
            zzczVar2.zzo(zzalcVar2.zzj);
            arrayList2.add(zzczVar2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzaky zzakyVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzakyVar);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }
}
