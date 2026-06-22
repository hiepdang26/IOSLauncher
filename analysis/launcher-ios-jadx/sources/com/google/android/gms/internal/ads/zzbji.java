package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.hd2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbji {
    public static final Intent zza(Uri uri, Context context, zzauo zzauoVar, View view, zzffk zzffkVar) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static final Intent zzb(Intent intent, ResolveInfo resolveInfo, Context context, zzauo zzauoVar, View view, zzffk zzffkVar) {
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    public static final ResolveInfo zzc(Intent intent, Context context, zzauo zzauoVar, View view, zzffk zzffkVar) {
        return zzd(intent, new ArrayList(), context, zzauoVar, view, zzffkVar);
    }

    public static final ResolveInfo zzd(Intent intent, ArrayList arrayList, Context context, zzauo zzauoVar, View view, zzffk zzffkVar) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= listQueryIntentActivities.size()) {
                        break;
                    }
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i).activityInfo.name)) {
                        resolveInfo = resolveInfoResolveActivity;
                        break;
                    }
                    i++;
                }
            }
            arrayList.addAll(listQueryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
            return resolveInfo;
        }
    }
}
