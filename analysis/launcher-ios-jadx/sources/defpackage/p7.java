package defpackage;

import android.app.Activity;
import android.app.ActivityOptions;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.widget.Toast;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p7 extends m7 {
    public final UserManager e;
    public final PackageManager f;

    public p7(Context context) {
        super(context);
        this.f = context.getPackageManager();
        this.e = (UserManager) context.getSystemService("user");
    }

    @Override // defpackage.m7
    public final boolean a(int i, AppWidgetProviderInfo appWidgetProviderInfo, Bundle bundle) {
        return this.a.bindAppWidgetIdIfAllowed(i, appWidgetProviderInfo.getProfile(), appWidgetProviderInfo.provider, bundle);
    }

    @Override // defpackage.m7
    public final rk0 b(ComponentName componentName, jq1 jq1Var) {
        for (AppWidgetProviderInfo appWidgetProviderInfo : this.a.getInstalledProvidersForProfile(jq1Var.a)) {
            if (appWidgetProviderInfo.provider.equals(componentName)) {
                return rk0.a(appWidgetProviderInfo);
            }
        }
        return null;
    }

    @Override // defpackage.m7
    public final List c() {
        ArrayList arrayList = new ArrayList();
        Iterator<UserHandle> it = this.e.getUserProfiles().iterator();
        while (it.hasNext()) {
            arrayList.addAll(this.a.getInstalledProvidersForProfile(it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.m7
    public final HashMap d() {
        HashMap map = new HashMap();
        for (UserHandle userHandle : this.e.getUserProfiles()) {
            jq1 jq1VarA = jq1.a(userHandle);
            for (AppWidgetProviderInfo appWidgetProviderInfo : this.a.getInstalledProvidersForProfile(userHandle)) {
                map.put(new dl(appWidgetProviderInfo.provider, jq1VarA), appWidgetProviderInfo);
            }
        }
        return map;
    }

    @Override // defpackage.m7
    public final Bitmap e(rk0 rk0Var, Bitmap bitmap, int i, int i2) {
        rk0Var.getClass();
        if (rk0Var.getProfile().equals(Process.myUserHandle())) {
            return bitmap;
        }
        Resources resources = this.b.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(e51.profile_badge_minimum_top);
        int iMin = Math.min(resources.getDimensionPixelSize(e51.profile_badge_size), Math.min(i, i2 - dimensionPixelSize));
        Rect rect = new Rect(0, 0, iMin, iMin);
        int iMax = Math.max(i2 - iMin, dimensionPixelSize);
        if (resources.getConfiguration().getLayoutDirection() == 1) {
            rect.offset(0, iMax);
        } else {
            rect.offset(bitmap.getWidth() - iMin, iMax);
        }
        Drawable userBadgedDrawableForDensity = this.f.getUserBadgedDrawableForDensity(new BitmapDrawable(resources, bitmap), rk0Var.getProfile(), rect, 0);
        if (userBadgedDrawableForDensity instanceof BitmapDrawable) {
            return ((BitmapDrawable) userBadgedDrawableForDensity).getBitmap();
        }
        bitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmap);
        userBadgedDrawableForDensity.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        userBadgedDrawableForDensity.draw(canvas);
        canvas.setBitmap(null);
        return bitmap;
    }

    @Override // defpackage.m7
    public final jq1 h(rk0 rk0Var) {
        rk0Var.getClass();
        return jq1.a(rk0Var.getProfile());
    }

    @Override // defpackage.m7
    public final Drawable i(rk0 rk0Var, oe0 oe0Var) {
        rk0Var.getClass();
        return rk0Var.loadIcon(this.b, jk0.a().e.i);
    }

    @Override // defpackage.m7
    public final String j(rk0 rk0Var) {
        return rk0Var.loadLabel(this.f);
    }

    @Override // defpackage.m7
    public final Drawable k(rk0 rk0Var) {
        return rk0Var.loadPreviewImage(this.b, 0);
    }

    @Override // defpackage.m7
    public final void l(rk0 rk0Var, int i, t tVar, AppWidgetHost appWidgetHost, int i2) {
        Activity activity;
        try {
            activity = tVar;
            try {
                appWidgetHost.startAppWidgetConfigureActivityForResult(activity, i, 0, i2, ar1.k ? ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle() : null);
            } catch (ActivityNotFoundException | SecurityException unused) {
                Toast.makeText(activity, w61.activity_not_found, 0).show();
            }
        } catch (ActivityNotFoundException | SecurityException unused2) {
            activity = tVar;
        }
    }
}
