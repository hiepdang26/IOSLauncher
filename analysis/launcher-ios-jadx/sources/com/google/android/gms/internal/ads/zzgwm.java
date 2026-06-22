package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import defpackage.k31;
import defpackage.uo;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgwm implements Iterable<Byte>, Serializable {
    public static final zzgwm zzb = new zzgwk(zzgyl.zzb);
    private int zza = 0;

    static {
        int i = zzgvz.zza;
    }

    private static zzgwm zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(uo.d(i, "length (", ") must be >= 1"));
        }
        if (i == 1) {
            return (zzgwm) it.next();
        }
        int i2 = i >>> 1;
        zzgwm zzgwmVarZzc = zzc(it, i2);
        zzgwm zzgwmVarZzc2 = zzc(it, i - i2);
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - zzgwmVarZzc.zzd() >= zzgwmVarZzc2.zzd()) {
            return zzhad.zzC(zzgwmVarZzc, zzgwmVarZzc2);
        }
        throw new IllegalArgumentException(k31.j(zzgwmVarZzc.zzd(), zzgwmVarZzc2.zzd(), "ByteString would be too long: ", "+"));
    }

    public static int zzq(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(uo.d(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(k31.j(i2, i3, "End index: ", " >= "));
    }

    public static zzgwl zzt() {
        return new zzgwl(128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgwm zzu(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = iterable.size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzc(iterable.iterator(), size);
    }

    public static zzgwm zzv(byte[] bArr, int i, int i2) {
        zzq(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgwk(bArr2);
    }

    public static zzgwm zzw(String str) {
        return new zzgwk(str.getBytes(zzgyl.zza));
    }

    public static void zzy(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i >= 0) {
                throw new ArrayIndexOutOfBoundsException(k31.j(i, i2, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(k31.k(i, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzhaq.zza(this) : zzhaq.zza(zzk(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return uo.k(sb, strZza, "\">");
    }

    public final byte[] zzA() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzgyl.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i, int i2, int i3);

    public abstract int zzj(int i, int i2, int i3);

    public abstract zzgwm zzk(int i, int i2);

    public abstract zzgww zzl();

    public abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    public abstract void zzo(zzgwd zzgwdVar);

    public abstract boolean zzp();

    public final int zzr() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public zzgwh iterator() {
        return new zzgwe(this);
    }

    public final String zzx() {
        return zzd() == 0 ? "" : zzm(zzgyl.zza);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i, int i2, int i3) {
        zzq(0, i3, zzd());
        zzq(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }
}
