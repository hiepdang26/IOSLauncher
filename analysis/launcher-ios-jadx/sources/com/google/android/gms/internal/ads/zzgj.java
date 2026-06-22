package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public final class zzgj extends zzfl {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzgj() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws zzgi {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzc;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i3 = zzet.zza;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.zzc -= (long) i4;
                zzg(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new zzgi(e, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgi {
        Uri uri = zzfyVar.zza;
        this.zzb = uri;
        zzi(zzfyVar);
        try {
            String path = uri.getPath();
            if (path == null) {
                throw null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzfyVar.zze);
                long length = zzfyVar.zzf;
                if (length == -1) {
                    length = this.zza.length() - zzfyVar.zze;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzgi(null, null, 2008);
                }
                this.zzd = true;
                zzj(zzfyVar);
                return this.zzc;
            } catch (IOException e) {
                throw new zzgi(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                int i = zzet.zza;
                throw new zzgi(e2, true != zzgh.zzb(e2.getCause()) ? 2005 : 2006);
            }
            throw new zzgi("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e2, 1004);
        } catch (SecurityException e3) {
            throw new zzgi(e3, 2006);
        } catch (RuntimeException e4) {
            throw new zzgi(e4, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        this.zzb = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.zza;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.zza = null;
                if (this.zzd) {
                    this.zzd = false;
                    zzh();
                }
            } catch (IOException e) {
                throw new zzgi(e, 2000);
            }
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th;
        }
    }
}
