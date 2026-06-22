package com.google.android.gms.internal.ads;

import android.net.Network;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class zzfrp extends zzfrd {
    private zzfvk<Integer> zza;
    private zzfvk<Integer> zzb;
    private zzfro zzc;
    private HttpURLConnection zzd;

    public zzfrp(zzfvk<Integer> zzfvkVar, zzfvk<Integer> zzfvkVar2, zzfro zzfroVar) {
        this.zza = zzfvkVar;
        this.zzb = zzfvkVar2;
        this.zzc = zzfroVar;
    }

    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfre.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() {
        zzfre.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfro zzfroVar = this.zzc;
        zzfroVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfroVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfro zzfroVar, final int i, final int i2) {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrh
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfri
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = zzfroVar;
        return zzm();
    }

    public HttpURLConnection zzo(final Network network, final URL url, final int i, final int i2) {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrj
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrk
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = new zzfro() { // from class: com.google.android.gms.internal.ads.zzfrl
            @Override // com.google.android.gms.internal.ads.zzfro
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(final URL url, final int i) {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrm
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzc = new zzfro() { // from class: com.google.android.gms.internal.ads.zzfrn
            @Override // com.google.android.gms.internal.ads.zzfro
            public final URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzm();
    }

    public zzfrp() {
        this(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrf
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return zzfrp.zzf();
            }
        }, new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrg
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return zzfrp.zzg();
            }
        }, null);
    }
}
