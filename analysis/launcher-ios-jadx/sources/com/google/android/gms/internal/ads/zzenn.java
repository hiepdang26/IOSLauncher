package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import defpackage.do0;
import defpackage.n42;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzenn implements zzevo {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final Context zzc;
    private final zzffg zzd;
    private final View zze;

    public zzenn(zzgcu zzgcuVar, zzgcu zzgcuVar2, Context context, zzffg zzffgVar, ViewGroup viewGroup) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = context;
        this.zzd = zzffgVar;
        this.zze = viewGroup;
    }

    private final List zze() {
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 3;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzbbw.zza(this.zzc);
        return ((Boolean) n42.d.c.zza(zzbbw.zzkf)).booleanValue() ? this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzenl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        }) : this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzenm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
    }

    public final /* synthetic */ zzeno zzc() {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }

    public final /* synthetic */ zzeno zzd() {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }
}
