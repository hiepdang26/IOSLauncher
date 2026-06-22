package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpr extends b0 {
    public static final Parcelable.Creator<zzfpr> CREATOR = new zzfps();
    public final int zza;
    private zzasj zzb = null;
    private byte[] zzc;

    public zzfpr(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzasj zzasjVar = this.zzb;
        if (zzasjVar != null || this.zzc == null) {
            if (zzasjVar == null || this.zzc != null) {
                if (zzasjVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzasjVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        byte[] bArrZzaV = this.zzc;
        if (bArrZzaV == null) {
            bArrZzaV = this.zzb.zzaV();
        }
        os.w(parcel, 2, bArrZzaV);
        os.F(iE, parcel);
    }

    public final zzasj zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzasj.zze(this.zzc, zzgxi.zza());
                this.zzc = null;
            } catch (zzgyn | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }
}
