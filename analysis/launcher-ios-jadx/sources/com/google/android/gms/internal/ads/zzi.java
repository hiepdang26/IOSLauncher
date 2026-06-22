package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {
    public final int zza = 0;

    public zzi(int i, float f) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzi.class == obj.getClass()) {
            if (Float.compare(0.0f, 0.0f) == 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + 16337;
    }
}
