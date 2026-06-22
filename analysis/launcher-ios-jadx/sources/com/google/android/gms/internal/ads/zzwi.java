package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzwi {
    public static final zzwi zza = new zzwi(new zzcd[0]);
    public final int zzb;
    private final zzfxr zzc;
    private int zzd;

    static {
        Integer.toString(0, 36);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzwi(zzcd... zzcdVarArr) {
        this.zzc = zzfxr.zzl(zzcdVarArr);
        this.zzb = zzcdVarArr.length;
        int i = 0;
        while (i < this.zzc.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zzc.size(); i3++) {
                if (((zzcd) this.zzc.get(i)).equals(this.zzc.get(i3))) {
                    zzea.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwi.class == obj.getClass()) {
            zzwi zzwiVar = (zzwi) obj;
            if (this.zzb == zzwiVar.zzb && this.zzc.equals(zzwiVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zzc.hashCode();
        this.zzd = iHashCode;
        return iHashCode;
    }

    public final int zza(zzcd zzcdVar) {
        int iIndexOf = this.zzc.indexOf(zzcdVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzcd zzb(int i) {
        return (zzcd) this.zzc.get(i);
    }

    public final zzfxr zzc() {
        return zzfxr.zzk(zzfyh.zzb(this.zzc, new zzful() { // from class: com.google.android.gms.internal.ads.zzwh
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzwi zzwiVar = zzwi.zza;
                return Integer.valueOf(((zzcd) obj).zzc);
            }
        }));
    }
}
