package defpackage;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;
import com.luutinhit.launcher6.t;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n7 extends m7 {
    @Override // defpackage.m7
    public final boolean a(int i, AppWidgetProviderInfo appWidgetProviderInfo, Bundle bundle) {
        boolean z = ar1.o;
        AppWidgetManager appWidgetManager = this.a;
        return z ? appWidgetManager.bindAppWidgetIdIfAllowed(i, appWidgetProviderInfo.provider, bundle) : appWidgetManager.bindAppWidgetIdIfAllowed(i, appWidgetProviderInfo.provider);
    }

    @Override // defpackage.m7
    public final rk0 b(ComponentName componentName, jq1 jq1Var) {
        for (AppWidgetProviderInfo appWidgetProviderInfo : this.a.getInstalledProviders()) {
            if (appWidgetProviderInfo.provider.equals(componentName)) {
                return rk0.a(appWidgetProviderInfo);
            }
        }
        return null;
    }

    @Override // defpackage.m7
    public final List c() {
        return this.a.getInstalledProviders();
    }

    @Override // defpackage.m7
    public final HashMap d() {
        HashMap map = new HashMap();
        jq1 jq1VarB = jq1.b();
        for (AppWidgetProviderInfo appWidgetProviderInfo : this.a.getInstalledProviders()) {
            map.put(new dl(appWidgetProviderInfo.provider, jq1VarB), appWidgetProviderInfo);
        }
        return map;
    }

    @Override // defpackage.m7
    public final jq1 h(rk0 rk0Var) {
        return jq1.b();
    }

    @Override // defpackage.m7
    public final Drawable i(rk0 rk0Var, oe0 oe0Var) {
        Resources resourcesForApplication;
        String packageName = ((AppWidgetProviderInfo) rk0Var).provider.getPackageName();
        int i = ((AppWidgetProviderInfo) rk0Var).icon;
        oe0Var.getClass();
        try {
            resourcesForApplication = oe0Var.h.getResourcesForApplication(packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            resourcesForApplication = null;
        }
        return (resourcesForApplication == null || i == 0) ? oe0Var.m() : oe0Var.n(i, resourcesForApplication);
    }

    @Override // defpackage.m7
    public final String j(rk0 rk0Var) {
        return ar1.B(((AppWidgetProviderInfo) rk0Var).label);
    }

    @Override // defpackage.m7
    public final Drawable k(rk0 rk0Var) {
        return this.b.getPackageManager().getDrawable(((AppWidgetProviderInfo) rk0Var).provider.getPackageName(), ((AppWidgetProviderInfo) rk0Var).previewImage, null);
    }

    @Override // defpackage.m7
    public final void l(rk0 rk0Var, int i, t tVar, AppWidgetHost appWidgetHost, int i2) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");
        intent.setComponent(((AppWidgetProviderInfo) rk0Var).configure);
        intent.putExtra("appWidgetId", i);
        Rect rect = ar1.a;
        try {
            tVar.startActivityForResult(intent, i2);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(tVar, w61.activity_not_found, 0).show();
        } catch (SecurityException unused2) {
            Toast.makeText(tVar, w61.activity_not_found, 0).show();
            Objects.toString(intent);
        }
    }

    @Override // defpackage.m7
    public final Bitmap e(rk0 rk0Var, Bitmap bitmap, int i, int i2) {
        return bitmap;
    }
}
