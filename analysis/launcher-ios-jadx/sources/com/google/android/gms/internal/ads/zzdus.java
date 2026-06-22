package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import defpackage.cd2;
import defpackage.f1;
import defpackage.hd2;
import defpackage.j02;
import defpackage.ja2;
import defpackage.n42;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdus {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final int zzc;
    private final int zzd;
    private String zze = "";

    public zzdus(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        zzbbn zzbbnVar = zzbbw.zzin;
        n42 n42Var = n42.d;
        this.zzc = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        this.zzd = ((Integer) n42Var.c.zza(zzbbw.zzio)).intValue();
    }

    public final JSONObject zza() throws JSONException {
        String strE;
        String strEncodeToString;
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.zza;
            String str = this.zzb.packageName;
            ja2 ja2Var = cd2.l;
            Context context2 = j02.a(context).h;
            jSONObject.put("name", context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(str, 0)));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("packageName", this.zzb.packageName);
        cd2 cd2Var = hd2.B.c;
        Drawable applicationIcon = null;
        try {
            strE = cd2.E(this.zza);
        } catch (RemoteException unused2) {
            strE = null;
        }
        jSONObject.put("adMobAppId", strE);
        if (this.zze.isEmpty()) {
            try {
                f1 f1VarA = j02.a(this.zza);
                String str2 = this.zzb.packageName;
                Context context3 = f1VarA.h;
                ApplicationInfo applicationInfo = context3.getPackageManager().getApplicationInfo(str2, 0);
                context3.getPackageManager().getApplicationLabel(applicationInfo);
                applicationIcon = context3.getPackageManager().getApplicationIcon(applicationInfo);
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (applicationIcon == null) {
                strEncodeToString = "";
            } else {
                applicationIcon.setBounds(0, 0, this.zzc, this.zzd);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.zzc, this.zzd, Bitmap.Config.ARGB_8888);
                applicationIcon.draw(new Canvas(bitmapCreateBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = strEncodeToString;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
