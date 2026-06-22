package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import defpackage.d22;
import defpackage.gy0;
import defpackage.he0;
import defpackage.i92;
import defpackage.ov0;
import defpackage.ur1;
import defpackage.x82;
import defpackage.xp1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpt extends zzbpa {
    private final xp1 zza;

    public zzbpt(xp1 xp1Var) {
        this.zza = xp1Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzA() {
        return this.zza.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzB() {
        return this.zza.m;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final double zze() {
        Double d = this.zza.g;
        if (d != null) {
            return d.doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzf() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzg() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzh() {
        this.zza.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzi() {
        return this.zza.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final x82 zzj() {
        x82 x82Var;
        ur1 ur1Var = this.zza.j;
        if (ur1Var == null) {
            return null;
        }
        synchronized (ur1Var.a) {
            x82Var = ur1Var.b;
        }
        return x82Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbew zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbfd zzl() {
        ov0 ov0Var = this.zza.d;
        if (ov0Var != null) {
            return new zzbeq(ov0Var.getDrawable(), ov0Var.getUri(), ov0Var.getScale(), ov0Var.zzb(), ov0Var.zza());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzm() {
        this.zza.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzn() {
        this.zza.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final he0 zzo() {
        Object obj = this.zza.k;
        if (obj == null) {
            return null;
        }
        return new gy0(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzp() {
        return this.zza.f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzq() {
        return this.zza.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzr() {
        return this.zza.e;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzs() {
        return this.zza.a;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzt() {
        return this.zza.i;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzu() {
        return this.zza.h;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final List zzv() {
        List<ov0> list = this.zza.b;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (ov0 ov0Var : list) {
                arrayList.add(new zzbeq(ov0Var.getDrawable(), ov0Var.getUri(), ov0Var.getScale(), ov0Var.zzb(), ov0Var.zza()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzw(he0 he0Var) {
        this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzx() {
        this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzy(he0 he0Var, he0 he0Var2, he0 he0Var3) {
        View view = (View) gy0.r(he0Var);
        ((d22) this.zza).getClass();
        if (i92.a.get(view) != null) {
            throw new ClassCastException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzz(he0 he0Var) {
        this.zza.getClass();
    }
}
