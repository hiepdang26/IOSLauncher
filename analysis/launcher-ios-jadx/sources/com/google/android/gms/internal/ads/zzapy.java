package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzapy {
    protected static final Comparator zza = new zzapx();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList(64);
    private int zzd = 0;

    public zzapy(int i) {
    }

    private final synchronized void zzc() {
        while (this.zzd > 4096) {
            byte[] bArr = (byte[]) this.zzb.remove(0);
            this.zzc.remove(bArr);
            this.zzd -= bArr.length;
        }
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (length <= 4096) {
                this.zzb.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.zzc, bArr, zza);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.zzc.add(iBinarySearch, bArr);
                this.zzd += length;
                zzc();
            }
        }
    }

    public final synchronized byte[] zzb(int i) {
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            byte[] bArr = (byte[]) this.zzc.get(i2);
            int length = bArr.length;
            if (length >= i) {
                this.zzd -= length;
                this.zzc.remove(i2);
                this.zzb.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
