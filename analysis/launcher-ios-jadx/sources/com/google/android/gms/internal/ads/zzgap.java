package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgap extends zzgaq {
    public static /* bridge */ /* synthetic */ int zza(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int zzb(long j) {
        int i = (int) j;
        zzfuu.zzg(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int zzc(int i, int i2, int i3) {
        zzfuu.zzh(true, "min (%s) must be less than or equal to max (%s)", i2, 1073741823);
        return Math.min(Math.max(i, i2), 1073741823);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        zzfuu.zzh(length >= 4, "array too small: %s < %s", length, 4);
        return (bArr[3] & 255) | (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public static int zze(long j) {
        return j > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : j < -2147483648L ? RtlSpacingHelper.UNDEFINED : (int) j;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer zzf(java.lang.String r12, int r13) {
        /*
            r12.getClass()
            boolean r13 = r12.isEmpty()
            r0 = 0
            if (r13 == 0) goto Ld
        La:
            r12 = r0
            goto L70
        Ld:
            r13 = 0
            char r1 = r12.charAt(r13)
            r2 = 45
            if (r1 != r2) goto L17
            r13 = 1
        L17:
            int r3 = r12.length()
            if (r13 != r3) goto L1e
            goto La
        L1e:
            int r3 = r13 + 1
            char r13 = r12.charAt(r13)
            int r13 = com.google.android.gms.internal.ads.zzgar.zza(r13)
            if (r13 < 0) goto La
            r4 = 10
            if (r13 < r4) goto L2f
            goto La
        L2f:
            int r13 = -r13
            long r5 = (long) r13
        L31:
            int r13 = r12.length()
            r7 = -9223372036854775808
            if (r3 >= r13) goto L5f
            int r13 = r3 + 1
            char r3 = r12.charAt(r3)
            int r3 = com.google.android.gms.internal.ads.zzgar.zza(r3)
            if (r3 < 0) goto La
            if (r3 >= r4) goto La
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 >= 0) goto L51
            goto La
        L51:
            r9 = 10
            long r5 = r5 * r9
            long r9 = (long) r3
            long r7 = r7 + r9
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 >= 0) goto L5c
            goto La
        L5c:
            long r5 = r5 - r9
            r3 = r13
            goto L31
        L5f:
            if (r1 != r2) goto L66
            java.lang.Long r12 = java.lang.Long.valueOf(r5)
            goto L70
        L66:
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 != 0) goto L6b
            goto La
        L6b:
            long r12 = -r5
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
        L70:
            if (r12 == 0) goto L89
            long r1 = r12.longValue()
            int r13 = r12.intValue()
            long r3 = (long) r13
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 == 0) goto L80
            goto L89
        L80:
            int r12 = r12.intValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            return r12
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgap.zzf(java.lang.String, int):java.lang.Integer");
    }

    public static List zzg(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.EMPTY_LIST : new zzgao(iArr, 0, length);
    }

    public static int[] zzh(Collection collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }
}
