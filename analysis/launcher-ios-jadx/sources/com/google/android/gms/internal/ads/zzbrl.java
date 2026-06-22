package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import defpackage.cd2;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzbrl implements DialogInterface.OnClickListener {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbrn zzc;

    public zzbrl(zzbrn zzbrnVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbrnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzc.zzb.getSystemService("download");
        try {
            String str = this.zza;
            String str2 = this.zzb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            cd2 cd2Var = hd2.B.c;
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzc.zzh("Could not store picture.");
        }
    }
}
