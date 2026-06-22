package defpackage;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class mt extends u9 {
    public final /* synthetic */ qt c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt(qt qtVar) {
        super(qtVar, 0);
        this.c = qtVar;
    }

    @Override // defpackage.u9
    public final long b(XmlResourceParser xmlResourceParser) {
        String strE = y9.e(xmlResourceParser, "uri");
        if (!TextUtils.isEmpty(strE)) {
            try {
                Intent uri = Intent.parseUri(strE, 0);
                qt qtVar = this.c;
                ResolveInfo resolveInfoResolveActivity = qtVar.b.resolveActivity(uri, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
                PackageManager packageManager = qtVar.b;
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(uri, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
                int i = 0;
                while (true) {
                    if (i < listQueryIntentActivities.size()) {
                        ResolveInfo resolveInfo = listQueryIntentActivities.get(i);
                        if (resolveInfo.activityInfo.name.equals(resolveInfoResolveActivity.activityInfo.name) && resolveInfo.activityInfo.packageName.equals(resolveInfoResolveActivity.activityInfo.packageName)) {
                            break;
                        }
                        i++;
                    } else {
                        int size = listQueryIntentActivities.size();
                        ResolveInfo resolveInfo2 = null;
                        for (int i2 = 0; i2 < size; i2++) {
                            if ((packageManager.getApplicationInfo(listQueryIntentActivities.get(i2).activityInfo.packageName, 0).flags & 1) != 0) {
                                if (resolveInfo2 != null) {
                                    resolveInfoResolveActivity = null;
                                    break;
                                }
                                resolveInfo2 = listQueryIntentActivities.get(i2);
                            }
                        }
                        resolveInfoResolveActivity = resolveInfo2;
                        if (resolveInfoResolveActivity == null) {
                            uri.toString();
                            return -1L;
                        }
                    }
                }
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(activityInfo.packageName);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(270532608);
                    return qtVar.a(activityInfo.loadLabel(packageManager).toString(), launchIntentForPackage, 0);
                }
            } catch (URISyntaxException unused) {
            }
        }
        return -1L;
    }
}
