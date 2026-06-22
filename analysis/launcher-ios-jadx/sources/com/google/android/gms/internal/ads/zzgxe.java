package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgxe implements zzhbh {
    private final zzgxd zza;

    private zzgxe(zzgxd zzgxdVar) {
        zzgyl.zzc(zzgxdVar, "output");
        this.zza = zzgxdVar;
        zzgxdVar.zze = this;
    }

    public static zzgxe zza(zzgxd zzgxdVar) {
        zzgxe zzgxeVar = zzgxdVar.zze;
        return zzgxeVar != null ? zzgxeVar : new zzgxe(zzgxdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzA(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzj(i, zzgyyVar.zza(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyyVar.size(); i6++) {
            zzgyyVar.zza(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzgyyVar.size()) {
            this.zza.zzk(zzgyyVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzB(int i, int i2) {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzC(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgxd zzgxdVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzgxdVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzD += zzgxd.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                zzgxd zzgxdVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzgxdVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                zzgxd zzgxdVar3 = this.zza;
                int iZzd = zzgxzVar.zzd(i2);
                zzgxdVar3.zzt(i, (iZzd >> 31) ^ (iZzd + iZzd));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgxzVar.size(); i4++) {
            int iZzd2 = zzgxzVar.zzd(i4);
            iZzD2 += zzgxd.zzD((iZzd2 >> 31) ^ (iZzd2 + iZzd2));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzgxzVar.size()) {
            zzgxd zzgxdVar4 = this.zza;
            int iZzd3 = zzgxzVar.zzd(i2);
            zzgxdVar4.zzu((iZzd3 >> 31) ^ (iZzd3 + iZzd3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzD(int i, long j) {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzE(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgxd zzgxdVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzgxdVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzE += zzgxd.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                zzgxd zzgxdVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzgxdVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                zzgxd zzgxdVar3 = this.zza;
                long jZza = zzgyyVar.zza(i2);
                zzgxdVar3.zzv(i, (jZza >> 63) ^ (jZza + jZza));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyyVar.size(); i4++) {
            long jZza2 = zzgyyVar.zza(i4);
            iZzE2 += zzgxd.zzE((jZza2 >> 63) ^ (jZza2 + jZza2));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzgyyVar.size()) {
            zzgxd zzgxdVar4 = this.zza;
            long jZza3 = zzgyyVar.zza(i2);
            zzgxdVar4.zzw((jZza3 >> 63) ^ (jZza3 + jZza3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    @Deprecated
    public final void zzF(int i) {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzG(int i, String str) {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzH(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzgyv)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzgyv zzgyvVar = (zzgyv) list;
        while (i2 < list.size()) {
            Object objZzc = zzgyvVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzq(i, (String) objZzc);
            } else {
                this.zza.zzO(i, (zzgwm) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzI(int i, int i2) {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzgxd.zzD(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                this.zza.zzt(i, zzgxzVar.zzd(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzgxzVar.size(); i4++) {
            iZzD2 += zzgxd.zzD(zzgxzVar.zzd(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzgxzVar.size()) {
            this.zza.zzu(zzgxzVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzK(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzL(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxd.zzE(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzv(i, zzgyyVar.zza(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyyVar.size(); i4++) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzgyyVar.size()) {
            this.zza.zzw(zzgyyVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzb(int i, boolean z) {
        this.zza.zzN(i, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzc(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgwc)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzN(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).getClass();
                i3++;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzM(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzgwc zzgwcVar = (zzgwc) list;
        if (!z) {
            while (i2 < zzgwcVar.size()) {
                this.zza.zzN(i, zzgwcVar.zzh(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgwcVar.size(); i6++) {
            zzgwcVar.zzh(i6);
            i5++;
        }
        this.zza.zzu(i5);
        while (i2 < zzgwcVar.size()) {
            this.zza.zzM(zzgwcVar.zzh(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzd(int i, zzgwm zzgwmVar) {
        this.zza.zzO(i, zzgwmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzO(i, (zzgwm) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzf(int i, double d) {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzg(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzgxf zzgxfVar = (zzgxf) list;
        if (!z) {
            while (i2 < zzgxfVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgxfVar.zzd(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxfVar.size(); i6++) {
            zzgxfVar.zzd(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzgxfVar.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(zzgxfVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    @Deprecated
    public final void zzh(int i) {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzi(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzj(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxd.zzE(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                this.zza.zzl(i, zzgxzVar.zzd(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgxzVar.size(); i4++) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzgxzVar.size()) {
            this.zza.zzm(zzgxzVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzk(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzl(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                this.zza.zzh(i, zzgxzVar.zzd(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxzVar.size(); i6++) {
            zzgxzVar.zzd(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzgxzVar.size()) {
            this.zza.zzi(zzgxzVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzm(int i, long j) {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzn(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzj(i, zzgyyVar.zza(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyyVar.size(); i6++) {
            zzgyyVar.zza(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzgyyVar.size()) {
            this.zza.zzk(zzgyyVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzo(int i, float f) {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzp(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgxp zzgxpVar = (zzgxp) list;
        if (!z) {
            while (i2 < zzgxpVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgxpVar.zzd(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxpVar.size(); i6++) {
            zzgxpVar.zzd(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzgxpVar.size()) {
            this.zza.zzi(Float.floatToRawIntBits(zzgxpVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzq(int i, Object obj, zzhae zzhaeVar) {
        zzgxd zzgxdVar = this.zza;
        zzgxdVar.zzs(i, 3);
        zzhaeVar.zzj((zzgzj) obj, zzgxdVar.zze);
        zzgxdVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzr(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzs(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxd.zzE(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                this.zza.zzl(i, zzgxzVar.zzd(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgxzVar.size(); i4++) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzgxzVar.size()) {
            this.zza.zzm(zzgxzVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzt(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzu(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzE += zzgxd.zzE(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzE);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzv(i, zzgyyVar.zza(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzE2 = 0;
        for (int i4 = 0; i4 < zzgyyVar.size(); i4++) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i4));
        }
        this.zza.zzu(iZzE2);
        while (i2 < zzgyyVar.size()) {
            this.zza.zzw(zzgyyVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzv(int i, Object obj, zzhae zzhaeVar) {
        this.zza.zzn(i, (zzgzj) obj, zzhaeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzw(int i, Object obj) {
        if (obj instanceof zzgwm) {
            this.zza.zzp(i, (zzgwm) obj);
        } else {
            this.zza.zzo(i, (zzgzj) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzx(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzy(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzgxz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        if (!z) {
            while (i2 < zzgxzVar.size()) {
                this.zza.zzh(i, zzgxzVar.zzd(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxzVar.size(); i6++) {
            zzgxzVar.zzd(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzgxzVar.size()) {
            this.zza.zzi(zzgxzVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final void zzz(int i, long j) {
        this.zza.zzj(i, j);
    }
}
