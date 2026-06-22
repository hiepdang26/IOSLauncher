package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import defpackage.uo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzayl {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzaza zze;
    private final zzazi zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzayl(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
        this.zze = new zzaza(i4);
        this.zzf = new zzazi(i5, i6, i7);
    }

    private final void zzp(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                try {
                    this.zzh.add(str);
                    this.zzk += str.length();
                    if (z) {
                        this.zzi.add(str);
                        this.zzj.add(new zzayw(f, f2, f3, f4, this.zzi.size() - 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final String zzq(ArrayList arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append((String) arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzayl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzayl) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        int i = this.zzl;
        int i2 = this.zzn;
        int i3 = this.zzk;
        String strZzq = zzq(arrayList, 100);
        String strZzq2 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        StringBuilder sbN = uo.n("ActivityContent fetchId: ", i, " score:", i2, " total_length:");
        sbN.append(i3);
        sbN.append("\n text: ");
        sbN.append(strZzq);
        sbN.append("\n viewableText");
        sbN.append(strZzq2);
        sbN.append("\n signture: ");
        sbN.append(str);
        sbN.append("\n viewableSignture: ");
        sbN.append(str2);
        sbN.append("\n viewableSignatureForVertical: ");
        sbN.append(str3);
        return sbN.toString();
    }

    public final int zza(int i, int i2) {
        if (this.zzd) {
            return this.zzb;
        }
        return (i2 * this.zzb) + (i * this.zza);
    }

    public final int zzb() {
        return this.zzn;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzo;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzh() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzj(int i) {
        this.zzl = i;
    }

    public final void zzk(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
    }

    public final void zzl(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
        synchronized (this.zzg) {
            try {
                if (this.zzm < 0) {
                    k92.d("ActivityContent: negative number of WebViews.");
                }
                zzm();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzm() {
        synchronized (this.zzg) {
            try {
                int iZza = zza(this.zzk, this.zzl);
                if (iZza > this.zzn) {
                    this.zzn = iZza;
                    hd2 hd2Var = hd2.B;
                    if (!((ib2) hd2Var.g.zzi()).n()) {
                        this.zzo = this.zze.zza(this.zzh);
                        this.zzp = this.zze.zza(this.zzi);
                    }
                    if (!((ib2) hd2Var.g.zzi()).o()) {
                        this.zzq = this.zzf.zza(this.zzi, this.zzj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzn() {
        synchronized (this.zzg) {
            try {
                int iZza = zza(this.zzk, this.zzl);
                if (iZza > this.zzn) {
                    this.zzn = iZza;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzo() {
        boolean z;
        synchronized (this.zzg) {
            z = this.zzm == 0;
        }
        return z;
    }
}
