package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqd implements zzaor {
    private final zzaqc zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqd(zzaqc zzaqcVar, int i) {
        this.zzc = zzaqcVar;
    }

    public static int zze(InputStream inputStream) {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    public static long zzf(InputStream inputStream) {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    public static String zzh(zzaqb zzaqbVar) {
        return new String(zzm(zzaqbVar, zzf(zzaqbVar)), "UTF-8");
    }

    public static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    public static byte[] zzm(zzaqb zzaqbVar, long j) throws IOException {
        long jZza = zzaqbVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaqbVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jZza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqa zzaqaVar) {
        if (this.zza.containsKey(str)) {
            this.zzb = (zzaqaVar.zza - ((zzaqa) this.zza.get(str)).zza) + this.zzb;
        } else {
            this.zzb += zzaqaVar.zza;
        }
        this.zza.put(str, zzaqaVar);
    }

    private final void zzp(String str) {
        zzaqa zzaqaVar = (zzaqa) this.zza.remove(str);
        if (zzaqaVar != null) {
            this.zzb -= zzaqaVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzaor
    public final synchronized zzaoq zza(String str) {
        zzaqa zzaqaVar = (zzaqa) this.zza.get(str);
        if (zzaqaVar == null) {
            return null;
        }
        File fileZzg = zzg(str);
        try {
            zzaqb zzaqbVar = new zzaqb(new BufferedInputStream(new FileInputStream(fileZzg)), fileZzg.length());
            try {
                zzaqa zzaqaVarZza = zzaqa.zza(zzaqbVar);
                if (!TextUtils.equals(str, zzaqaVarZza.zzb)) {
                    zzapt.zza("%s: key=%s, found=%s", fileZzg.getAbsolutePath(), str, zzaqaVarZza.zzb);
                    zzp(str);
                    return null;
                }
                byte[] bArrZzm = zzm(zzaqbVar, zzaqbVar.zza());
                zzaoq zzaoqVar = new zzaoq();
                zzaoqVar.zza = bArrZzm;
                zzaoqVar.zzb = zzaqaVar.zzc;
                zzaoqVar.zzc = zzaqaVar.zzd;
                zzaoqVar.zzd = zzaqaVar.zze;
                zzaoqVar.zze = zzaqaVar.zzf;
                zzaoqVar.zzf = zzaqaVar.zzg;
                List<zzaoz> list = zzaqaVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzaoz zzaozVar : list) {
                    treeMap.put(zzaozVar.zza(), zzaozVar.zzb());
                }
                zzaoqVar.zzg = treeMap;
                zzaoqVar.zzh = Collections.unmodifiableList(zzaqaVar.zzh);
                return zzaoqVar;
            } finally {
                zzaqbVar.close();
            }
        } catch (IOException e) {
            zzapt.zza("%s: %s", fileZzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaor
    public final synchronized void zzb() {
        synchronized (this) {
            File fileZza = this.zzc.zza();
            if (fileZza.exists()) {
                File[] fileArrListFiles = fileZza.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            zzaqb zzaqbVar = new zzaqb(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                zzaqa zzaqaVarZza = zzaqa.zza(zzaqbVar);
                                zzaqaVarZza.zza = length;
                                zzo(zzaqaVarZza.zzb, zzaqaVarZza);
                                zzaqbVar.close();
                            } catch (Throwable th) {
                                zzaqbVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!fileZza.mkdirs()) {
                zzapt.zzb("Unable to create cache dir %s", fileZza.getAbsolutePath());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaor
    public final synchronized void zzc(String str, boolean z) {
        zzaoq zzaoqVarZza = zza(str);
        if (zzaoqVarZza != null) {
            zzaoqVarZza.zzf = 0L;
            zzaoqVarZza.zze = 0L;
            zzd(str, zzaoqVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaor
    public final synchronized void zzd(String str, zzaoq zzaoqVar) {
        float f;
        try {
            long j = this.zzb;
            int length = zzaoqVar.zza.length;
            long j2 = j + ((long) length);
            int i = this.zzd;
            if (j2 <= i || length <= i * 0.9f) {
                File fileZzg = zzg(str);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzg));
                    zzaqa zzaqaVar = new zzaqa(str, zzaoqVar);
                    try {
                        zzj(bufferedOutputStream, 538247942);
                        zzl(bufferedOutputStream, zzaqaVar.zzb);
                        String str2 = zzaqaVar.zzc;
                        if (str2 == null) {
                            str2 = "";
                        }
                        zzl(bufferedOutputStream, str2);
                        zzk(bufferedOutputStream, zzaqaVar.zzd);
                        zzk(bufferedOutputStream, zzaqaVar.zze);
                        zzk(bufferedOutputStream, zzaqaVar.zzf);
                        zzk(bufferedOutputStream, zzaqaVar.zzg);
                        List<zzaoz> list = zzaqaVar.zzh;
                        if (list != null) {
                            zzj(bufferedOutputStream, list.size());
                            for (zzaoz zzaozVar : list) {
                                zzl(bufferedOutputStream, zzaozVar.zza());
                                zzl(bufferedOutputStream, zzaozVar.zzb());
                            }
                        } else {
                            zzj(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzaoqVar.zza);
                        bufferedOutputStream.close();
                        zzaqaVar.zza = fileZzg.length();
                        zzo(str, zzaqaVar);
                        if (this.zzb >= this.zzd) {
                            if (zzapt.zzb) {
                                zzapt.zzd("Pruning old cache entries.", new Object[0]);
                            }
                            long j3 = this.zzb;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.zza.entrySet().iterator();
                            int i2 = 0;
                            while (it.hasNext()) {
                                zzaqa zzaqaVar2 = (zzaqa) ((Map.Entry) it.next()).getValue();
                                if (zzg(zzaqaVar2.zzb).delete()) {
                                    f = 0.9f;
                                    this.zzb -= zzaqaVar2.zza;
                                } else {
                                    f = 0.9f;
                                    String str3 = zzaqaVar2.zzb;
                                    zzapt.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                                }
                                it.remove();
                                i2++;
                                if (this.zzb < this.zzd * f) {
                                    break;
                                }
                            }
                            if (zzapt.zzb) {
                                zzapt.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzb - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                            }
                        }
                    } catch (IOException e) {
                        zzapt.zza("%s", e.toString());
                        bufferedOutputStream.close();
                        zzapt.zza("Failed to write header for %s", fileZzg.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused) {
                    if (!fileZzg.delete()) {
                        zzapt.zza("Could not clean up file %s", fileZzg.getAbsolutePath());
                    }
                    if (!this.zzc.zza().exists()) {
                        zzapt.zza("Re-initializing cache after external clearing.", new Object[0]);
                        this.zza.clear();
                        this.zzb = 0L;
                        zzb();
                    }
                }
            }
        } finally {
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean zDelete = zzg(str).delete();
        zzp(str);
        if (zDelete) {
            return;
        }
        zzapt.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public zzaqd(File file, int i) {
        this.zzc = new zzapz(this, file);
    }
}
