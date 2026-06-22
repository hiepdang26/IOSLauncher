package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbcb {
    String zzd;
    Context zze;
    String zzf;
    private AtomicBoolean zzh;
    private File zzi;
    final BlockingQueue zza = new ArrayBlockingQueue(100);
    final LinkedHashMap zzb = new LinkedHashMap();
    final Map zzc = new HashMap();
    private final HashSet zzg = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public static void zzc(zzbcb zzbcbVar) throws Throwable {
        while (true) {
            try {
                zzbcl zzbclVar = (zzbcl) zzbcbVar.zza.take();
                zzbck zzbckVarZza = zzbclVar.zza();
                if (!TextUtils.isEmpty(zzbckVarZza.zzb())) {
                    zzbcbVar.zzg(zzbcbVar.zzb(zzbcbVar.zzb, zzbclVar.zzb()), zzbckVarZza);
                }
            } catch (InterruptedException unused) {
                k92.j(5);
                return;
            }
        }
    }

    private final void zzg(Map map, zzbck zzbckVar) throws Throwable {
        FileOutputStream fileOutputStream;
        Uri.Builder builderBuildUpon = Uri.parse(this.zzd).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbckVar != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!TextUtils.isEmpty(zzbckVar.zzb())) {
                sb.append("&it=");
                sb.append(zzbckVar.zzb());
            }
            if (!TextUtils.isEmpty(zzbckVar.zza())) {
                sb.append("&blat=");
                sb.append(zzbckVar.zza());
            }
            string = sb.toString();
        }
        if (!this.zzh.get()) {
            cd2 cd2Var = hd2.B.c;
            cd2.j(this.zze, this.zzf, string);
            return;
        }
        File file = this.zzi;
        if (file == null) {
            k92.h("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (IOException unused) {
                    k92.j(5);
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.write(10);
            fileOutputStream.close();
        } catch (IOException unused3) {
            fileOutputStream2 = fileOutputStream;
            k92.j(5);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                    k92.j(5);
                }
            }
            throw th;
        }
    }

    public final zzbch zza(String str) {
        zzbch zzbchVar = (zzbch) this.zzc.get(str);
        return zzbchVar != null ? zzbchVar : zzbch.zza;
    }

    public final Map zzb(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zza(str).zza((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public final void zzd(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzh = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbdn.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(zzfqu.zza(zzfqt.zza(), externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbca
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzbcb.zzc(this.zza);
            }
        });
        Map map2 = this.zzc;
        zzbch zzbchVar = zzbch.zzb;
        map2.put("action", zzbchVar);
        this.zzc.put("ad_format", zzbchVar);
        this.zzc.put("e", zzbch.zzc);
    }

    public final void zze(String str) throws Throwable {
        if (this.zzg.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzf);
        linkedHashMap.put("ue", str);
        zzg(zzb(this.zzb, linkedHashMap), null);
    }

    public final boolean zzf(zzbcl zzbclVar) {
        return this.zza.offer(zzbclVar);
    }
}
