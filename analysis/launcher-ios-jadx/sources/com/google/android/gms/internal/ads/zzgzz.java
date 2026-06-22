package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzgzz {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgzz() {
    }

    public static /* bridge */ /* synthetic */ zzgwm zza(zzgzz zzgzzVar, zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        zzgzzVar.zzb(zzgwmVar);
        zzgzzVar.zzb(zzgwmVar2);
        zzgwm zzhadVar = (zzgwm) zzgzzVar.zza.pop();
        while (!zzgzzVar.zza.isEmpty()) {
            zzhadVar = new zzhad((zzgwm) zzgzzVar.zza.pop(), zzhadVar);
        }
        return zzhadVar;
    }

    private final void zzb(zzgwm zzgwmVar) {
        zzhac zzhacVar;
        if (!zzgwmVar.zzh()) {
            if (!(zzgwmVar instanceof zzhad)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgwmVar.getClass())));
            }
            zzhad zzhadVar = (zzhad) zzgwmVar;
            zzb(zzhadVar.zzd);
            zzb(zzhadVar.zze);
            return;
        }
        int iZzc = zzc(zzgwmVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzhad.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzgwm) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzgwmVar);
            return;
        }
        int iZzc3 = zzhad.zzc(iZzc);
        zzgwm zzhadVar2 = (zzgwm) this.zza.pop();
        while (true) {
            zzhacVar = null;
            if (this.zza.isEmpty() || ((zzgwm) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzhadVar2 = new zzhad((zzgwm) this.zza.pop(), zzhadVar2);
            }
        }
        zzhad zzhadVar3 = new zzhad(zzhadVar2, zzgwmVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzhadVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzgwm) arrayDeque2.peek()).zzd() >= zzhad.zzc(iZzc4)) {
                break;
            } else {
                zzhadVar3 = new zzhad((zzgwm) this.zza.pop(), zzhadVar3);
            }
        }
        this.zza.push(zzhadVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzhad.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public /* synthetic */ zzgzz(zzgzy zzgzyVar) {
    }
}
