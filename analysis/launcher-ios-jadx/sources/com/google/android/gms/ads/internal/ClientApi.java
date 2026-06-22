package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdjv;
import com.google.android.gms.internal.ads.zzdjx;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzeln;
import com.google.android.gms.internal.ads.zzezl;
import com.google.android.gms.internal.ads.zzfaz;
import com.google.android.gms.internal.ads.zzfcq;
import com.google.android.gms.internal.ads.zzfee;
import com.google.android.gms.internal.ads.zzfei;
import defpackage.ca2;
import defpackage.dd2;
import defpackage.gy0;
import defpackage.he0;
import defpackage.l72;
import defpackage.n42;
import defpackage.o22;
import defpackage.or1;
import defpackage.q52;
import defpackage.q82;
import defpackage.rc2;
import defpackage.v52;
import defpackage.vd2;
import defpackage.x62;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ClientApi extends zzaxn implements x62 {
    public ClientApi() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // defpackage.x62
    public final v52 a(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        Context context = (Context) gy0.r(he0Var);
        zzezl zzezlVarZzt = zzcgj.zzb(context, zzbomVar, i).zzt();
        zzezlVarZzt.zza(str);
        zzezlVarZzt.zzb(context);
        return i >= ((Integer) n42.d.c.zza(zzbbw.zzeK)).intValue() ? zzezlVarZzt.zzc().zza() : new ca2();
    }

    @Override // defpackage.x62
    public final v52 c(he0 he0Var, rc2 rc2Var, String str, int i) {
        return new dd2((Context) gy0.r(he0Var), rc2Var, str, new or1(242402000, i, true, false));
    }

    @Override // defpackage.x62
    public final zzbfh d(he0 he0Var, he0 he0Var2) {
        return new zzdjx((FrameLayout) gy0.r(he0Var), (FrameLayout) gy0.r(he0Var2), 242402000);
    }

    @Override // defpackage.x62
    public final q82 g(he0 he0Var, zzbom zzbomVar, int i) {
        return zzcgj.zzb((Context) gy0.r(he0Var), zzbomVar, i).zzm();
    }

    @Override // defpackage.x62
    public final zzbym h(he0 he0Var, zzbom zzbomVar, int i) {
        return zzcgj.zzb((Context) gy0.r(he0Var), zzbomVar, i).zzq();
    }

    @Override // defpackage.x62
    public final zzbsg i(he0 he0Var, zzbom zzbomVar, int i) {
        return zzcgj.zzb((Context) gy0.r(he0Var), zzbomVar, i).zzn();
    }

    @Override // defpackage.x62
    public final zzbjz k(he0 he0Var, zzbom zzbomVar, int i, zzbjw zzbjwVar) {
        Context context = (Context) gy0.r(he0Var);
        zzdtt zzdttVarZzk = zzcgj.zzb(context, zzbomVar, i).zzk();
        zzdttVarZzk.zzb(context);
        zzdttVarZzk.zza(zzbjwVar);
        return zzdttVarZzk.zzc().zzd();
    }

    @Override // defpackage.x62
    public final v52 l(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        Context context = (Context) gy0.r(he0Var);
        zzfcq zzfcqVarZzv = zzcgj.zzb(context, zzbomVar, i).zzv();
        zzfcqVarZzv.zzc(context);
        zzfcqVarZzv.zza(rc2Var);
        zzfcqVarZzv.zzb(str);
        return zzfcqVarZzv.zzd().zza();
    }

    @Override // defpackage.x62
    public final v52 m(he0 he0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        Context context = (Context) gy0.r(he0Var);
        zzfaz zzfazVarZzu = zzcgj.zzb(context, zzbomVar, i).zzu();
        zzfazVarZzu.zzc(context);
        zzfazVarZzu.zza(rc2Var);
        zzfazVarZzu.zzb(str);
        return zzfazVarZzu.zzd().zza();
    }

    @Override // defpackage.x62
    public final q52 n(he0 he0Var, String str, zzbom zzbomVar, int i) {
        Context context = (Context) gy0.r(he0Var);
        return new zzeln(zzcgj.zzb(context, zzbomVar, i), context, str);
    }

    @Override // defpackage.x62
    public final zzbwg o(he0 he0Var, String str, zzbom zzbomVar, int i) {
        Context context = (Context) gy0.r(he0Var);
        zzfee zzfeeVarZzw = zzcgj.zzb(context, zzbomVar, i).zzw();
        zzfeeVarZzw.zzb(context);
        zzfeeVarZzw.zza(str);
        return zzfeeVarZzw.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                String string = parcel.readString();
                zzbom zzbomVarZzf = zzbol.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzaxo.zzc(parcel);
                v52 v52VarM = m(he0VarQ, rc2Var, string, zzbomVarZzf, i3);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, v52VarM);
                return true;
            case 2:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var2 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                String string2 = parcel.readString();
                zzbom zzbomVarZzf2 = zzbol.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzaxo.zzc(parcel);
                v52 v52VarL = l(he0VarQ2, rc2Var2, string2, zzbomVarZzf2, i4);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, v52VarL);
                return true;
            case 3:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbom zzbomVarZzf3 = zzbol.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzaxo.zzc(parcel);
                q52 q52VarN = n(he0VarQ3, string3, zzbomVarZzf3, i5);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, q52VarN);
                return true;
            case 4:
                gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 5:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbfh zzbfhVarD = d(he0VarQ4, he0VarQ5);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfhVarD);
                return true;
            case 6:
                he0 he0VarQ6 = gy0.q(parcel.readStrongBinder());
                zzbom zzbomVarZzf4 = zzbol.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzaxo.zzc(parcel);
                Context context = (Context) gy0.r(he0VarQ6);
                zzfee zzfeeVarZzw = zzcgj.zzb(context, zzbomVarZzf4, i6).zzw();
                zzfeeVarZzw.zzb(context);
                zzfei zzfeiVarZzb = zzfeeVarZzw.zzc().zzb();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzfeiVarZzb);
                return true;
            case 7:
                gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 8:
                he0 he0VarQ7 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbsn zzbsnVarZzm = zzm(he0VarQ7);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbsnVarZzm);
                return true;
            case 9:
                he0 he0VarQ8 = gy0.q(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzaxo.zzc(parcel);
                l72 l72VarZzg = zzg(he0VarQ8, i7);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, l72VarZzg);
                return true;
            case 10:
                he0 he0VarQ9 = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var3 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzaxo.zzc(parcel);
                v52 v52VarC = c(he0VarQ9, rc2Var3, string4, i8);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, v52VarC);
                return true;
            case 11:
                he0 he0VarQ10 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ11 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ12 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdjv zzdjvVar = new zzdjv((View) gy0.r(he0VarQ10), (HashMap) gy0.r(he0VarQ11), (HashMap) gy0.r(he0VarQ12));
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdjvVar);
                return true;
            case 12:
                he0 he0VarQ13 = gy0.q(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbom zzbomVarZzf5 = zzbol.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbwg zzbwgVarO = o(he0VarQ13, string5, zzbomVarZzf5, i9);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbwgVarO);
                return true;
            case 13:
                he0 he0VarQ14 = gy0.q(parcel.readStrongBinder());
                rc2 rc2Var4 = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                String string6 = parcel.readString();
                zzbom zzbomVarZzf6 = zzbol.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzaxo.zzc(parcel);
                v52 v52VarA = a(he0VarQ14, rc2Var4, string6, zzbomVarZzf6, i10);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, v52VarA);
                return true;
            case 14:
                he0 he0VarQ15 = gy0.q(parcel.readStrongBinder());
                zzbom zzbomVarZzf7 = zzbol.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbym zzbymVarH = h(he0VarQ15, zzbomVarZzf7, i11);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbymVarH);
                return true;
            case 15:
                he0 he0VarQ16 = gy0.q(parcel.readStrongBinder());
                zzbom zzbomVarZzf8 = zzbol.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbsg zzbsgVarI = i(he0VarQ16, zzbomVarZzf8, i12);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbsgVarI);
                return true;
            case 16:
                he0 he0VarQ17 = gy0.q(parcel.readStrongBinder());
                zzbom zzbomVarZzf9 = zzbol.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzbjw zzbjwVarZzc = zzbjv.zzc(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbjz zzbjzVarK = k(he0VarQ17, zzbomVarZzf9, i13, zzbjwVarZzc);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbjzVarK);
                return true;
            case 17:
                he0 he0VarQ18 = gy0.q(parcel.readStrongBinder());
                zzbom zzbomVarZzf10 = zzbol.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzaxo.zzc(parcel);
                q82 q82VarG = g(he0VarQ18, zzbomVarZzf10, i14);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, q82VarG);
                return true;
            default:
                return false;
        }
    }

    @Override // defpackage.x62
    public final l72 zzg(he0 he0Var, int i) {
        return zzcgj.zzb((Context) gy0.r(he0Var), null, i).zzc();
    }

    @Override // defpackage.x62
    public final zzbsn zzm(he0 he0Var) {
        Activity activity = (Activity) gy0.r(he0Var);
        AdOverlayInfoParcel adOverlayInfoParcelA = AdOverlayInfoParcel.a(activity.getIntent());
        if (adOverlayInfoParcelA == null) {
            return new o22(activity, 4);
        }
        int i = adOverlayInfoParcelA.q;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new o22(activity, 4) : new o22(activity, 0) : new vd2(activity, adOverlayInfoParcelA) : new o22(activity, 2) : new o22(activity, 1) : new o22(activity, 3);
    }
}
