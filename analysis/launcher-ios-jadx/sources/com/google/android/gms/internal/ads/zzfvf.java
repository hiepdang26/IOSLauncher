package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfvf extends zzfue {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public zzfvf(zzfvh zzfvhVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzfue
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i = this.zzc;
        while (true) {
            int i2 = this.zzc;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i2);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zzc = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzc = iZzc;
            }
            if (iZzc != i) {
                if (i < iZzd) {
                    this.zzb.charAt(i);
                }
                if (i < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                int i3 = this.zzd;
                if (i3 == 1) {
                    iZzd = this.zzb.length();
                    this.zzc = -1;
                    if (iZzd > i) {
                        this.zzb.charAt(iZzd - 1);
                    }
                } else {
                    this.zzd = i3 - 1;
                }
                return this.zzb.subSequence(i, iZzd).toString();
            }
            int i4 = iZzc + 1;
            this.zzc = i4;
            if (i4 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
