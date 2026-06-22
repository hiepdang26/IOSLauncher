package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgxn {
    private static final zzgxn zzb = new zzgxn(true);
    final zzhao zza = new zzhah();
    private boolean zzc;
    private boolean zzd;

    private zzgxn() {
    }

    public static int zza(zzhbf zzhbfVar, int i, Object obj) {
        int iZzD = zzgxd.zzD(i << 3);
        if (zzhbfVar == zzhbf.zzj) {
            byte[] bArr = zzgyl.zzb;
            if (((zzgzj) obj) instanceof zzgvw) {
                throw null;
            }
            iZzD += iZzD;
        }
        return iZzD + zzb(zzhbfVar, obj);
    }

    public static int zzb(zzhbf zzhbfVar, Object obj) {
        int iZzd;
        int iZzD;
        zzhbf zzhbfVar2 = zzhbf.zza;
        zzhbg zzhbgVar = zzhbg.INT;
        switch (zzhbfVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzgxd.zzf;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzgxd.zzf;
                return 4;
            case 2:
                return zzgxd.zzE(((Long) obj).longValue());
            case 3:
                return zzgxd.zzE(((Long) obj).longValue());
            case 4:
                return zzgxd.zzE(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzgxd.zzf;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzgxd.zzf;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzgxd.zzf;
                return 1;
            case 8:
                if (!(obj instanceof zzgwm)) {
                    return zzgxd.zzC((String) obj);
                }
                int i6 = zzgxd.zzf;
                iZzd = ((zzgwm) obj).zzd();
                iZzD = zzgxd.zzD(iZzd);
                break;
                break;
            case 9:
                int i7 = zzgxd.zzf;
                return ((zzgzj) obj).zzaY();
            case 10:
                if (!(obj instanceof zzgyt)) {
                    return zzgxd.zzz((zzgzj) obj);
                }
                int i8 = zzgxd.zzf;
                iZzd = ((zzgyt) obj).zza();
                iZzD = zzgxd.zzD(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzgwm)) {
                    int i9 = zzgxd.zzf;
                    iZzd = ((byte[]) obj).length;
                    iZzD = zzgxd.zzD(iZzd);
                } else {
                    int i10 = zzgxd.zzf;
                    iZzd = ((zzgwm) obj).zzd();
                    iZzD = zzgxd.zzD(iZzd);
                }
                break;
            case 12:
                return zzgxd.zzD(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzgyc ? zzgxd.zzE(((zzgyc) obj).zza()) : zzgxd.zzE(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i11 = zzgxd.zzf;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i12 = zzgxd.zzf;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzgxd.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzgxd.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzD + iZzd;
    }

    public static int zzc(zzgxm zzgxmVar, Object obj) {
        zzhbf zzhbfVarZzb = zzgxmVar.zzb();
        int iZza = zzgxmVar.zza();
        if (!zzgxmVar.zze()) {
            return zza(zzhbfVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int iZza2 = 0;
        if (!zzgxmVar.zzd()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iZza2 += zza(zzhbfVarZzb, iZza, it.next());
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iZza2 += zzb(zzhbfVarZzb, it2.next());
        }
        return zzgxd.zzD(iZza2) + zzgxd.zzD(iZza << 3) + iZza2;
    }

    public static zzgxn zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgxm zzgxmVar = (zzgxm) entry.getKey();
        if (zzgxmVar.zzc() != zzhbg.MESSAGE) {
            return true;
        }
        if (!zzgxmVar.zze()) {
            return zzk(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzk(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgzk) {
            return ((zzgzk) obj).zzbw();
        }
        if (obj instanceof zzgyt) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int iZzD;
        int iZzz;
        zzgxm zzgxmVar = (zzgxm) entry.getKey();
        Object value = entry.getValue();
        if (zzgxmVar.zzc() != zzhbg.MESSAGE || zzgxmVar.zze() || zzgxmVar.zzd()) {
            return zzc(zzgxmVar, value);
        }
        if (value instanceof zzgyt) {
            int iZza = ((zzgxm) entry.getKey()).zza();
            int iZzD2 = zzgxd.zzD(8);
            i = iZzD2 + iZzD2;
            iZzD = zzgxd.zzD(iZza) + zzgxd.zzD(16);
            int iZzD3 = zzgxd.zzD(24);
            int iZza2 = ((zzgyt) value).zza();
            iZzz = k31.h(iZza2, iZza2, iZzD3);
        } else {
            int iZza3 = ((zzgxm) entry.getKey()).zza();
            int iZzD4 = zzgxd.zzD(8);
            i = iZzD4 + iZzD4;
            iZzD = zzgxd.zzD(iZza3) + zzgxd.zzD(16);
            iZzz = zzgxd.zzz((zzgzj) value) + zzgxd.zzD(24);
        }
        return i + iZzD + iZzz;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzm(com.google.android.gms.internal.ads.zzgxm r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.ads.zzhbf r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.ads.zzgyl.zzb
            r5.getClass()
            com.google.android.gms.internal.ads.zzhbf r1 = com.google.android.gms.internal.ads.zzhbf.zza
            com.google.android.gms.internal.ads.zzhbg r1 = com.google.android.gms.internal.ads.zzhbg.INT
            com.google.android.gms.internal.ads.zzhbg r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgzj
            if (r0 != 0) goto L21
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgyt
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgyc
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgwm
            if (r0 != 0) goto L33
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
        L33:
            return
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.ads.zzhbf r4 = r4.zzb()
            com.google.android.gms.internal.ads.zzhbg r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgxn.zzm(com.google.android.gms.internal.ads.zzgxm, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzgxn zzgxnVar = new zzgxn();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzgxnVar.zzh((zzgxm) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgxnVar.zzh((zzgxm) entry.getKey(), entry.getValue());
        }
        zzgxnVar.zzd = this.zzd;
        return zzgxnVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgxn) {
            return this.zza.equals(((zzgxn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        int iZzl = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzl += zzl(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzgys(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzgxy) {
                ((zzgxy) entryZzg.getValue()).zzbW();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzgxm zzgxmVar, Object obj) {
        if (!zzgxmVar.zze()) {
            zzm(zzgxmVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzm(zzgxmVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzgyt) {
            this.zzd = true;
        }
        this.zza.put(zzgxmVar, obj);
    }

    public final boolean zzi() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzj(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgxn(boolean z) {
        zzg();
        zzg();
    }
}
