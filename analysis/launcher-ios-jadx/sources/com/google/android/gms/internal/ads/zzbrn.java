package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.s61;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrn extends zzbrq {
    private final Map zza;
    private final Context zzb;

    public zzbrn(zzcej zzcejVar, Map map) {
        super(zzcejVar, "storePicture");
        this.zza = map;
        this.zzb = zzcejVar.zzi();
    }

    public final void zzb() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available");
            return;
        }
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        if (!new zzbbe(context).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        cd2 cd2Var2 = hd2Var.c;
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZze = hd2Var.g.zze();
        cd2 cd2Var3 = hd2Var.c;
        AlertDialog.Builder builderI = cd2.i(this.zzb);
        builderI.setTitle(resourcesZze != null ? resourcesZze.getString(s61.s1) : "Save image");
        builderI.setMessage(resourcesZze != null ? resourcesZze.getString(s61.s2) : "Allow Ad to store image in Picture gallery?");
        builderI.setPositiveButton(resourcesZze != null ? resourcesZze.getString(s61.s3) : "Accept", new zzbrl(this, str, lastPathSegment));
        builderI.setNegativeButton(resourcesZze != null ? resourcesZze.getString(s61.s4) : "Decline", new zzbrm(this));
        builderI.create().show();
    }
}
