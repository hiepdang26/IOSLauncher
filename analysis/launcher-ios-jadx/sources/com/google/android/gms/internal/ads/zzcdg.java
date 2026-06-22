package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.k92;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
final class zzcdg extends zzfl implements zzgp {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzgo zzg;
    private zzfy zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    public zzcdg(String str, zzgu zzguVar, int i, int i2, int i3) {
        super(true);
        this.zzc = new zzcdf(this);
        this.zzr = new HashSet();
        zzdi.zzc(str);
        this.zzf = str;
        this.zzg = new zzgo();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzguVar != null) {
            zzf(zzguVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
                k92.f();
            }
            this.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws zzgl {
        try {
            if (this.zzo != this.zzm) {
                byte[] bArr2 = (byte[]) zzb.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[MotionScene.Transition.TransitionOnClick.JUMP_TO_START];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzb.set(bArr2);
                        break;
                    }
                    int i3 = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i3 == -1) {
                        throw new EOFException();
                    }
                    this.zzo += (long) i3;
                    zzg(i3);
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j4);
            }
            int i4 = this.zzj.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.zzn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzp += (long) i4;
            zzg(i4);
            return i4;
        } catch (IOException e) {
            throw new zzgl(e, this.zzh, 2000, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x026e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5 A[Catch: IOException -> 0x003f, TryCatch #3 {IOException -> 0x003f, blocks: (B:3:0x000e, B:4:0x0024, B:6:0x002a, B:8:0x0034, B:12:0x0045, B:13:0x005d, B:15:0x0063, B:22:0x008b, B:24:0x00a5, B:25:0x00b7, B:26:0x00bc, B:28:0x00c5, B:29:0x00cc, B:42:0x00f4, B:96:0x0233, B:98:0x023e, B:100:0x024f, B:103:0x0258, B:104:0x0267, B:106:0x026e, B:107:0x0275, B:108:0x0276, B:109:0x028c), top: B:118:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023e A[Catch: IOException -> 0x003f, TryCatch #3 {IOException -> 0x003f, blocks: (B:3:0x000e, B:4:0x0024, B:6:0x002a, B:8:0x0034, B:12:0x0045, B:13:0x005d, B:15:0x0063, B:22:0x008b, B:24:0x00a5, B:25:0x00b7, B:26:0x00bc, B:28:0x00c5, B:29:0x00cc, B:42:0x00f4, B:96:0x0233, B:98:0x023e, B:100:0x024f, B:103:0x0258, B:104:0x0267, B:106:0x026e, B:107:0x0275, B:108:0x0276, B:109:0x028c), top: B:118:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzfs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzb(com.google.android.gms.internal.ads.zzfy r21) throws com.google.android.gms.internal.ads.zzgl {
        /*
            Method dump skipped, instruction units count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdg.zzb(com.google.android.gms.internal.ads.zzfy):long");
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                int i = zzet.zza;
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzgl(e, this.zzh, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfl, com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzm(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException unused) {
                    k92.j(5);
                }
            }
        }
    }
}
