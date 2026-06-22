package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfwi extends zzfwg implements ListIterator {
    final /* synthetic */ zzfwj zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwi(zzfwj zzfwjVar) {
        super(zzfwjVar);
        this.zzd = zzfwjVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        this.zzd.zzf.zzb++;
        if (zIsEmpty) {
            this.zzd.zza();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwi(zzfwj zzfwjVar, int i) {
        super(zzfwjVar, ((List) zzfwjVar.zzb).listIterator(i));
        this.zzd = zzfwjVar;
    }
}
