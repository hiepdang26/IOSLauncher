package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.n42;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhb extends b0 {
    public static final Parcelable.Creator<zzfhb> CREATOR = new zzfhc();
    public final Context zza;
    public final zzfgy zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfgy[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfhb(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfgy[] zzfgyVarArrValues = zzfgy.values();
        this.zzh = zzfgyVarArrValues;
        int[] iArrZza = zzfgz.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfha.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = zzfgyVarArrValues[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = iArrZza[i5];
        this.zzk = i6;
        int i7 = iArrZza2[i6];
    }

    public static zzfhb zza(zzfgy zzfgyVar, Context context) {
        if (zzfgyVar == zzfgy.Rewarded) {
            zzbbn zzbbnVar = zzbbw.zzfI;
            n42 n42Var = n42.d;
            return new zzfhb(context, zzfgyVar, ((Integer) n42Var.c.zza(zzbbnVar)).intValue(), ((Integer) n42Var.c.zza(zzbbw.zzfO)).intValue(), ((Integer) n42Var.c.zza(zzbbw.zzfQ)).intValue(), (String) n42Var.c.zza(zzbbw.zzfS), (String) n42Var.c.zza(zzbbw.zzfK), (String) n42Var.c.zza(zzbbw.zzfM));
        }
        if (zzfgyVar == zzfgy.Interstitial) {
            zzbbn zzbbnVar2 = zzbbw.zzfJ;
            n42 n42Var2 = n42.d;
            return new zzfhb(context, zzfgyVar, ((Integer) n42Var2.c.zza(zzbbnVar2)).intValue(), ((Integer) n42Var2.c.zza(zzbbw.zzfP)).intValue(), ((Integer) n42Var2.c.zza(zzbbw.zzfR)).intValue(), (String) n42Var2.c.zza(zzbbw.zzfT), (String) n42Var2.c.zza(zzbbw.zzfL), (String) n42Var2.c.zza(zzbbw.zzfN));
        }
        if (zzfgyVar != zzfgy.AppOpen) {
            return null;
        }
        zzbbn zzbbnVar3 = zzbbw.zzfW;
        n42 n42Var3 = n42.d;
        return new zzfhb(context, zzfgyVar, ((Integer) n42Var3.c.zza(zzbbnVar3)).intValue(), ((Integer) n42Var3.c.zza(zzbbw.zzfY)).intValue(), ((Integer) n42Var3.c.zza(zzbbw.zzfZ)).intValue(), (String) n42Var3.c.zza(zzbbw.zzfU), (String) n42Var3.c.zza(zzbbw.zzfV), (String) n42Var3.c.zza(zzbbw.zzfX));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzc;
        os.G(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.zzd;
        os.G(parcel, 3, 4);
        parcel.writeInt(i4);
        int i5 = this.zze;
        os.G(parcel, 4, 4);
        parcel.writeInt(i5);
        os.z(parcel, 5, this.zzf);
        int i6 = this.zzj;
        os.G(parcel, 6, 4);
        parcel.writeInt(i6);
        int i7 = this.zzk;
        os.G(parcel, 7, 4);
        parcel.writeInt(i7);
        os.F(iE, parcel);
    }

    private zzfhb(Context context, zzfgy zzfgyVar, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfgy.values();
        this.zzl = zzfgz.zza();
        this.zzm = zzfha.zza();
        this.zza = context;
        this.zzi = zzfgyVar.ordinal();
        this.zzb = zzfgyVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else {
            i4 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
