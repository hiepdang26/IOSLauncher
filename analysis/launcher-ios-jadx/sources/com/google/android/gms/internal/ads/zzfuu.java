package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzfuu {
    public static int zza(int i, int i2, String str) {
        String strZzb;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzb = zzfvj.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(k31.k(i2, "negative size: "));
            }
            strZzb = zzfvj.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzl(i, i2, "index"));
        }
        return i;
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzfvj.zzb(str, obj2));
    }

    public static void zze(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzf(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzg(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(zzfvj.zzb(str, Long.valueOf(j)));
        }
    }

    public static void zzh(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(zzfvj.zzb(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void zzi(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? zzl(i, i3, "start index") : (i2 < 0 || i2 > i3) ? zzl(i2, i3, "end index") : zzfvj.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void zzj(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzk(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzl(int i, int i2, String str) {
        if (i < 0) {
            return zzfvj.zzb("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzfvj.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(k31.k(i2, "negative size: "));
    }
}
