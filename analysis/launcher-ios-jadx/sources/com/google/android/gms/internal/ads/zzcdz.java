package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import defpackage.k92;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzcdz extends zzfl implements zzgp {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgo zze;
    private zzfy zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    public zzcdz(String str, zzgu zzguVar, int i, int i2, long j, long j2) {
        super(true);
        zzdi.zzc(str);
        this.zzd = str;
        this.zze = new zzgo();
        this.zzb = i;
        this.zzc = i2;
        this.zzh = new ArrayDeque();
        this.zzq = j;
        this.zzr = j2;
        if (zzguVar != null) {
            zzf(zzguVar);
        }
    }

    private final void zzl() {
        while (!this.zzh.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzh.remove()).disconnect();
            } catch (Exception unused) {
                k92.f();
            }
        }
        this.zzg = null;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws zzgl {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            long j2 = this.zzm;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzn + j2;
            long j4 = i2;
            long j5 = j3 + j4 + this.zzr;
            long j6 = this.zzp;
            long j7 = j6 + 1;
            if (j5 > j7) {
                long j8 = this.zzo;
                if (j6 < j8) {
                    long jMin = Math.min(j8, Math.max(((this.zzq + j7) - r4) - 1, (-1) + j7 + j4));
                    zzk(j7, jMin, 2);
                    this.zzp = jMin;
                    j6 = jMin;
                }
            }
            int i3 = this.zzi.read(bArr, i, (int) Math.min(j4, ((j6 + 1) - this.zzn) - this.zzm));
            if (i3 == -1) {
                throw new EOFException();
            }
            this.zzm += (long) i3;
            zzg(i3);
            return i3;
        } catch (IOException e) {
            throw new zzgl(e, this.zzf, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgl {
        this.zzf = zzfyVar;
        this.zzm = 0L;
        long j = zzfyVar.zze;
        long j2 = zzfyVar.zzf;
        long jMin = j2 == -1 ? this.zzq : Math.min(this.zzq, j2);
        this.zzn = j;
        HttpURLConnection httpURLConnectionZzk = zzk(j, (jMin + j) - 1, 1);
        this.zzg = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j3 = Long.parseLong(matcher.group(2));
                    long j4 = Long.parseLong(matcher.group(3));
                    long j5 = zzfyVar.zzf;
                    if (j5 != -1) {
                        this.zzl = j5;
                        this.zzo = Math.max(j3, (this.zzn + j5) - 1);
                    } else {
                        this.zzl = j4 - this.zzn;
                        this.zzo = j4 - 1;
                    }
                    this.zzp = j3;
                    this.zzj = true;
                    zzj(zzfyVar);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    k92.e("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcdx(headerField, zzfyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzgl(e, this.zzf, 2000, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfl, com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final HttpURLConnection zzk(long j, long j2, int i) throws zzgl {
        int i2;
        IOException iOException;
        String string = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                try {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } catch (IOException e) {
                    iOException = e;
                    i2 = i;
                    throw new zzgl("Unable to connect to ".concat(String.valueOf(string)), iOException, this.zzf, 2000, i2);
                }
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty("User-Agent", this.zzd);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String string2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcdy(this.zzk, headerFields, this.zzf, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e2) {
                    zzl();
                    throw new zzgl(e2, this.zzf, 2000, i);
                }
            } catch (IOException e3) {
                zzl();
                throw new zzgl("Unable to connect to ".concat(String.valueOf(string2)), e3, this.zzf, 2000, i);
            }
        } catch (IOException e4) {
            i2 = i;
            iOException = e4;
        }
    }
}
