package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzuv implements zzug, zzuf {
    private final zzug[] zza;
    private zzuf zze;
    private zzwi zzf;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzvz zzh = new zzts(zzfxr.zzm(), zzfxr.zzm());
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zzug[] zzg = new zzug[0];

    public zzuv(zztt zzttVar, long[] jArr, zzug... zzugVarArr) {
        this.zza = zzugVarArr;
        for (int i = 0; i < zzugVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzwf(zzugVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j, zzlj zzljVar) {
        zzug[] zzugVarArr = this.zzg;
        return (zzugVarArr.length > 0 ? zzugVarArr[0] : this.zza[0]).zza(j, zzljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzug zzugVar : this.zzg) {
            long jZzd = zzugVar.zzd();
            if (jZzd == -9223372036854775807L) {
                if (j != -9223372036854775807L && zzugVar.zze(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (zzug zzugVar2 : this.zzg) {
                    if (zzugVar2 == zzugVar) {
                        break;
                    }
                    if (zzugVar2.zze(jZzd) != jZzd) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzd;
            } else if (jZzd != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zze(long j) {
        long jZze = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzug[] zzugVarArr = this.zzg;
            if (i >= zzugVarArr.length) {
                return jZze;
            }
            if (zzugVarArr[i].zze(jZze) != jZze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zze;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzg(zzxv[] zzxvVarArr, boolean[] zArr, zzvx[] zzvxVarArr, boolean[] zArr2, long j) {
        int length;
        int length2 = zzxvVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        while (true) {
            length = zzxvVarArr.length;
            if (i >= length) {
                break;
            }
            zzvx zzvxVar = zzvxVarArr[i];
            Integer num = zzvxVar == null ? null : (Integer) this.zzb.get(zzvxVar);
            iArr[i] = num == null ? -1 : num.intValue();
            zzxv zzxvVar = zzxvVarArr[i];
            if (zzxvVar != null) {
                String str = zzxvVar.zze().zzb;
                iArr2[i] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i] = -1;
            }
            i++;
        }
        this.zzb.clear();
        zzvx[] zzvxVarArr2 = new zzvx[length];
        zzvx[] zzvxVarArr3 = new zzvx[length];
        zzxv[] zzxvVarArr2 = new zzxv[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i2 = 0;
        while (i2 < this.zza.length) {
            for (int i3 = 0; i3 < zzxvVarArr.length; i3++) {
                zzvxVarArr3[i3] = iArr[i3] == i2 ? zzvxVarArr[i3] : null;
                if (iArr2[i3] == i2) {
                    zzxv zzxvVar2 = zzxvVarArr[i3];
                    zzxvVar2.getClass();
                    zzcd zzcdVar = (zzcd) this.zzd.get(zzxvVar2.zze());
                    zzcdVar.getClass();
                    zzxvVarArr2[i3] = new zzuu(zzxvVar2, zzcdVar);
                } else {
                    zzxvVarArr2[i3] = null;
                }
            }
            ArrayList arrayList2 = arrayList;
            long jZzg = this.zza[i2].zzg(zzxvVarArr2, zArr, zzvxVarArr3, zArr2, j2);
            if (i2 == 0) {
                j2 = jZzg;
            } else if (jZzg != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i4 = 0; i4 < zzxvVarArr.length; i4++) {
                if (iArr2[i4] == i2) {
                    zzvx zzvxVar2 = zzvxVarArr3[i4];
                    zzvxVar2.getClass();
                    zzvxVarArr2[i4] = zzvxVar2;
                    this.zzb.put(zzvxVar2, Integer.valueOf(i2));
                    z = true;
                } else if (iArr[i4] == i2) {
                    zzdi.zzf(zzvxVarArr3[i4] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i2]);
            }
            i2++;
            arrayList = arrayList2;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzvxVarArr2, 0, zzvxVarArr, 0, length);
        this.zzg = (zzug[]) arrayList3.toArray(new zzug[0]);
        this.zzh = new zzts(arrayList3, zzfyh.zzb(arrayList3, new zzful() { // from class: com.google.android.gms.internal.ads.zzut
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return ((zzug) obj).zzi().zzc();
            }
        }));
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        this.zzc.remove(zzugVar);
        if (!this.zzc.isEmpty()) {
            return;
        }
        int i = 0;
        for (zzug zzugVar2 : this.zza) {
            i += zzugVar2.zzi().zzb;
        }
        zzcd[] zzcdVarArr = new zzcd[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzug[] zzugVarArr = this.zza;
            if (i2 >= zzugVarArr.length) {
                this.zzf = new zzwi(zzcdVarArr);
                zzuf zzufVar = this.zze;
                zzufVar.getClass();
                zzufVar.zzh(this);
                return;
            }
            zzwi zzwiVarZzi = zzugVarArr[i2].zzi();
            int i4 = zzwiVarZzi.zzb;
            int i5 = 0;
            while (i5 < i4) {
                zzcd zzcdVarZzb = zzwiVarZzi.zzb(i5);
                zzaf[] zzafVarArr = new zzaf[zzcdVarZzb.zza];
                for (int i6 = 0; i6 < zzcdVarZzb.zza; i6++) {
                    zzaf zzafVarZzb = zzcdVarZzb.zzb(i6);
                    zzad zzadVarZzb = zzafVarZzb.zzb();
                    String str = zzafVarZzb.zza;
                    if (str == null) {
                        str = "";
                    }
                    zzadVarZzb.zzK(i2 + ":" + str);
                    zzafVarArr[i6] = zzadVarZzb.zzad();
                }
                zzcd zzcdVar = new zzcd(i2 + ":" + zzcdVarZzb.zzb, zzafVarArr);
                this.zzd.put(zzcdVar, zzcdVarZzb);
                zzcdVarArr[i3] = zzcdVar;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        zzwi zzwiVar = this.zzf;
        zzwiVar.getClass();
        return zzwiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j, boolean z) {
        for (zzug zzugVar : this.zzg) {
            zzugVar.zzj(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        int i = 0;
        while (true) {
            zzug[] zzugVarArr = this.zza;
            if (i >= zzugVarArr.length) {
                return;
            }
            zzugVarArr[i].zzk();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j) {
        this.zze = zzufVar;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zzug[] zzugVarArr = this.zza;
            if (i >= zzugVarArr.length) {
                return;
            }
            zzugVarArr[i].zzl(this, j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzug zzn(int i) {
        zzug zzugVar = this.zza[i];
        return zzugVar instanceof zzwf ? ((zzwf) zzugVar).zzn() : zzugVar;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzkfVar);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            ((zzug) this.zzc.get(i)).zzo(zzkfVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
