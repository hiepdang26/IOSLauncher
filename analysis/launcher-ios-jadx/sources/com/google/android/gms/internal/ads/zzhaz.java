package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzhaz {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzhay zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    static {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhaz.<clinit>():void");
    }

    private zzhaz() {
    }

    public static boolean zzA() {
        return zzh;
    }

    public static boolean zzB() {
        return zzg;
    }

    private static int zzC(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzD(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i = zzgvz.zza;
        Field fieldZzF = zzF(Buffer.class, "effectiveDirectAddress");
        if (fieldZzF != null) {
            return fieldZzF;
        }
        Field fieldZzF2 = zzF(Buffer.class, "address");
        if (fieldZzF2 == null || fieldZzF2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzF2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzG(Object obj, long j, byte b) {
        zzhay zzhayVar = zzf;
        long j2 = (-4) & j;
        int i = zzhayVar.zza.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zzhayVar.zza.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzH(Object obj, long j, byte b) {
        zzhay zzhayVar = zzf;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzhayVar.zza.putInt(obj, j2, ((255 & b) << i) | (zzhayVar.zza.getInt(obj, j2) & (~(255 << i))));
    }

    public static byte zza(long j) {
        return zzf.zza(j);
    }

    public static double zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static float zzc(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    public static int zzd(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static long zze(ByteBuffer byteBuffer) {
        zzhay zzhayVar = zzf;
        return zzhayVar.zza.getLong(byteBuffer, zzi);
    }

    public static long zzf(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static Object zzg(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzh(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static Unsafe zzi() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhav());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzj(Throwable th) {
        Logger.getLogger(zzhaz.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void zzo(long j, byte[] bArr, long j2, long j3) {
        zzf.zzd(j, bArr, j2, j3);
    }

    public static void zzp(Object obj, long j, boolean z) {
        zzf.zze(obj, j, z);
    }

    public static void zzq(byte[] bArr, long j, byte b) {
        zzf.zzf(bArr, zza + j, b);
    }

    public static void zzr(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    public static void zzs(Object obj, long j, float f) {
        zzf.zzh(obj, j, f);
    }

    public static void zzt(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    public static void zzu(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    public static void zzv(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzw(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzx(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzy(Class cls) {
        int i = zzgvz.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzz(Object obj, long j) {
        return zzf.zzi(obj, j);
    }
}
