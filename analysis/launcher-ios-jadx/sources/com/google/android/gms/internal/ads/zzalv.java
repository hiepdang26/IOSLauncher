package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzalv implements zzajv {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzalv(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i = 0; i < list.size(); i++) {
            zzalk zzalkVar = (zzalk) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzalkVar.zzb;
            jArr[i2 + 1] = zzalkVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final long zzb(int i) {
        zzdi.zzd(i >= 0);
        zzdi.zzd(i < this.zzc.length);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.zza.size(); i++) {
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzalk zzalkVar = (zzalk) this.zza.get(i);
                zzdb zzdbVar = zzalkVar.zza;
                if (zzdbVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzalkVar);
                } else {
                    arrayList.add(zzdbVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzalu
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((zzalk) obj).zzb, ((zzalk) obj2).zzb);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcz zzczVarZzb = ((zzalk) arrayList2.get(i3)).zza.zzb();
            zzczVarZzb.zze((-1) - i3, 1);
            arrayList.add(zzczVarZzb.zzp());
        }
        return arrayList;
    }
}
