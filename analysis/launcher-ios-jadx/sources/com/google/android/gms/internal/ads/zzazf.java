package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzazf {
    public static long zza(long j, int i) {
        if (i == 1) {
            return j;
        }
        int i2 = i >> 1;
        long j2 = (j * j) % 1073807359;
        return (i & 1) == 0 ? zza(j2, i2) % 1073807359 : ((zza(j2, i2) % 1073807359) * j) % 1073807359;
    }

    public static String zzb(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            k92.e("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i >= i4) {
                sb.append(strArr[i4]);
                return sb.toString();
            }
            sb.append(strArr[i]);
            sb.append(' ');
            i++;
        }
    }

    public static void zzc(String[] strArr, int i, int i2, PriorityQueue priorityQueue) {
        int length = strArr.length;
        if (length < 6) {
            zzd(i, zze(strArr, 0, length), zzb(strArr, 0, length), length, priorityQueue);
            return;
        }
        long jZze = zze(strArr, 0, 6);
        zzd(i, jZze, zzb(strArr, 0, 6), 6, priorityQueue);
        int i3 = 1;
        while (true) {
            int length2 = strArr.length;
            if (i3 >= length2 - 5) {
                return;
            }
            long jZza = zzazb.zza(strArr[i3 - 1]);
            long jZza2 = zzazb.zza(strArr[i3 + 5]);
            String strZzb = zzb(strArr, i3, 6);
            jZze = (((jZza2 + 2147483647L) % 1073807359) + (((((jZze + 1073807359) - ((((jZza + 2147483647L) % 1073807359) * zza(16785407L, 5)) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
            zzd(i, jZze, strZzb, length2, priorityQueue);
            i3++;
        }
    }

    public static void zzd(int i, long j, String str, int i2, PriorityQueue priorityQueue) {
        zzaze zzazeVar = new zzaze(j, str, i2);
        if ((priorityQueue.size() != i || (((zzaze) priorityQueue.peek()).zzc <= zzazeVar.zzc && ((zzaze) priorityQueue.peek()).zza <= zzazeVar.zza)) && !priorityQueue.contains(zzazeVar)) {
            priorityQueue.add(zzazeVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i, int i2) {
        long jZza = (((long) zzazb.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            jZza = (((((long) zzazb.zza(strArr[i3])) + 2147483647L) % 1073807359) + ((jZza * 16785407) % 1073807359)) % 1073807359;
        }
        return jZza;
    }
}
