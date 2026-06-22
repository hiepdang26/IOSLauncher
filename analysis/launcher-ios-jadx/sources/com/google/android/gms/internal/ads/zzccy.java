package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzccy extends zzccv {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzccy(zzcbk zzcbkVar) {
        super(zzcbkVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            k92.h("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfqu.zza(zzfqt.zza(), cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            k92.h("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        } else {
            if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
                return;
            }
            k92.h("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        }
    }

    private final File zza(File file) {
        return new File(zzfqu.zza(zzfqt.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b0  */
    @Override // com.google.android.gms.internal.ads.zzccv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzt(final java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 991
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zzt(java.lang.String):boolean");
    }
}
