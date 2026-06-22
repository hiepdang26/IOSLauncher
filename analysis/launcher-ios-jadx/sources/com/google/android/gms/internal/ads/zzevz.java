package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.do0;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzevz implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzevz(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzevx zzc() {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevz.zzc():com.google.android.gms.internal.ads.zzevx");
    }
}
