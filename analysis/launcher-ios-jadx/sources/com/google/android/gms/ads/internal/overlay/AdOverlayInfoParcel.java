package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcxd;
import com.google.android.gms.internal.ads.zzdeq;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdvt;
import com.google.android.gms.internal.ads.zzeds;
import defpackage.b0;
import defpackage.b22;
import defpackage.d82;
import defpackage.e22;
import defpackage.gy0;
import defpackage.m62;
import defpackage.mc2;
import defpackage.n42;
import defpackage.or1;
import defpackage.os;
import defpackage.sb2;

/* JADX INFO: loaded from: classes.dex */
public final class AdOverlayInfoParcel extends b0 implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new d82(13);
    public final zzdeq A;
    public final zzbsg B;
    public final boolean C;
    public final m62 g;
    public final b22 h;
    public final mc2 i;
    public final zzcej j;
    public final zzbhp k;
    public final String l;
    public final boolean m;
    public final String n;
    public final e22 o;
    public final int p;
    public final int q;
    public final String r;
    public final or1 s;
    public final String t;
    public final sb2 u;
    public final zzbhn v;
    public final String w;
    public final String x;
    public final String y;
    public final zzcxd z;

    public AdOverlayInfoParcel(zzcej zzcejVar, or1 or1Var, String str, String str2, zzbsg zzbsgVar) {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = zzcejVar;
        this.v = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = 14;
        this.q = 5;
        this.r = null;
        this.s = or1Var;
        this.t = null;
        this.u = null;
        this.w = str;
        this.x = str2;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = zzbsgVar;
        this.C = false;
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.y(parcel, 2, this.g, i);
        os.x(parcel, 3, new gy0(this.h));
        os.x(parcel, 4, new gy0(this.i));
        os.x(parcel, 5, new gy0(this.j));
        os.x(parcel, 6, new gy0(this.k));
        os.z(parcel, 7, this.l);
        os.G(parcel, 8, 4);
        parcel.writeInt(this.m ? 1 : 0);
        os.z(parcel, 9, this.n);
        os.x(parcel, 10, new gy0(this.o));
        os.G(parcel, 11, 4);
        parcel.writeInt(this.p);
        os.G(parcel, 12, 4);
        parcel.writeInt(this.q);
        os.z(parcel, 13, this.r);
        os.y(parcel, 14, this.s, i);
        os.z(parcel, 16, this.t);
        os.y(parcel, 17, this.u, i);
        os.x(parcel, 18, new gy0(this.v));
        os.z(parcel, 19, this.w);
        os.z(parcel, 24, this.x);
        os.z(parcel, 25, this.y);
        os.x(parcel, 26, new gy0(this.z));
        os.x(parcel, 27, new gy0(this.A));
        os.x(parcel, 28, new gy0(this.B));
        os.G(parcel, 29, 4);
        parcel.writeInt(this.C ? 1 : 0);
        os.F(iE, parcel);
    }

    public AdOverlayInfoParcel(zzdgm zzdgmVar, zzcej zzcejVar, int i, or1 or1Var, String str, sb2 sb2Var, String str2, String str3, String str4, zzcxd zzcxdVar, zzeds zzedsVar) {
        this.g = null;
        this.h = null;
        this.i = zzdgmVar;
        this.j = zzcejVar;
        this.v = null;
        this.k = null;
        this.m = false;
        if (((Boolean) n42.d.c.zza(zzbbw.zzaA)).booleanValue()) {
            this.l = null;
            this.n = null;
        } else {
            this.l = str2;
            this.n = str3;
        }
        this.o = null;
        this.p = i;
        this.q = 1;
        this.r = null;
        this.s = or1Var;
        this.t = str;
        this.u = sb2Var;
        this.w = null;
        this.x = null;
        this.y = str4;
        this.z = zzcxdVar;
        this.A = null;
        this.B = zzedsVar;
        this.C = false;
    }

    public AdOverlayInfoParcel(zzdvt zzdvtVar, zzcej zzcejVar, or1 or1Var) {
        this.i = zzdvtVar;
        this.j = zzcejVar;
        this.p = 1;
        this.s = or1Var;
        this.g = null;
        this.h = null;
        this.v = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = null;
        this.t = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = false;
    }

    public AdOverlayInfoParcel(b22 b22Var, mc2 mc2Var, zzbhn zzbhnVar, zzbhp zzbhpVar, e22 e22Var, zzcej zzcejVar, boolean z, int i, String str, or1 or1Var, zzdeq zzdeqVar, zzeds zzedsVar, boolean z2) {
        this.g = null;
        this.h = b22Var;
        this.i = mc2Var;
        this.j = zzcejVar;
        this.v = zzbhnVar;
        this.k = zzbhpVar;
        this.l = null;
        this.m = z;
        this.n = null;
        this.o = e22Var;
        this.p = i;
        this.q = 3;
        this.r = str;
        this.s = or1Var;
        this.t = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = zzdeqVar;
        this.B = zzedsVar;
        this.C = z2;
    }

    public AdOverlayInfoParcel(b22 b22Var, mc2 mc2Var, zzbhn zzbhnVar, zzbhp zzbhpVar, e22 e22Var, zzcej zzcejVar, boolean z, int i, String str, String str2, or1 or1Var, zzdeq zzdeqVar, zzeds zzedsVar) {
        this.g = null;
        this.h = b22Var;
        this.i = mc2Var;
        this.j = zzcejVar;
        this.v = zzbhnVar;
        this.k = zzbhpVar;
        this.l = str2;
        this.m = z;
        this.n = str;
        this.o = e22Var;
        this.p = i;
        this.q = 3;
        this.r = null;
        this.s = or1Var;
        this.t = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = zzdeqVar;
        this.B = zzedsVar;
        this.C = false;
    }

    public AdOverlayInfoParcel(b22 b22Var, mc2 mc2Var, e22 e22Var, zzcej zzcejVar, boolean z, int i, or1 or1Var, zzdeq zzdeqVar, zzeds zzedsVar) {
        this.g = null;
        this.h = b22Var;
        this.i = mc2Var;
        this.j = zzcejVar;
        this.v = null;
        this.k = null;
        this.l = null;
        this.m = z;
        this.n = null;
        this.o = e22Var;
        this.p = i;
        this.q = 2;
        this.r = null;
        this.s = or1Var;
        this.t = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = zzdeqVar;
        this.B = zzedsVar;
        this.C = false;
    }

    public AdOverlayInfoParcel(m62 m62Var, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, or1 or1Var, String str4, sb2 sb2Var, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z2) {
        this.g = m62Var;
        this.h = (b22) gy0.r(gy0.q(iBinder));
        this.i = (mc2) gy0.r(gy0.q(iBinder2));
        this.j = (zzcej) gy0.r(gy0.q(iBinder3));
        this.v = (zzbhn) gy0.r(gy0.q(iBinder6));
        this.k = (zzbhp) gy0.r(gy0.q(iBinder4));
        this.l = str;
        this.m = z;
        this.n = str2;
        this.o = (e22) gy0.r(gy0.q(iBinder5));
        this.p = i;
        this.q = i2;
        this.r = str3;
        this.s = or1Var;
        this.t = str4;
        this.u = sb2Var;
        this.w = str5;
        this.x = str6;
        this.y = str7;
        this.z = (zzcxd) gy0.r(gy0.q(iBinder7));
        this.A = (zzdeq) gy0.r(gy0.q(iBinder8));
        this.B = (zzbsg) gy0.r(gy0.q(iBinder9));
        this.C = z2;
    }

    public AdOverlayInfoParcel(m62 m62Var, b22 b22Var, mc2 mc2Var, e22 e22Var, or1 or1Var, zzcej zzcejVar, zzdeq zzdeqVar) {
        this.g = m62Var;
        this.h = b22Var;
        this.i = mc2Var;
        this.j = zzcejVar;
        this.v = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = e22Var;
        this.p = -1;
        this.q = 4;
        this.r = null;
        this.s = or1Var;
        this.t = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = zzdeqVar;
        this.B = null;
        this.C = false;
    }
}
