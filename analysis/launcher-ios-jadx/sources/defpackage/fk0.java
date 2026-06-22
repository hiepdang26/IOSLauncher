package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class fk0 extends ek0 {
    public final ResolveInfo a;
    public final ActivityInfo b;
    public final ComponentName c;
    public final PackageManager d;

    public fk0(Context context, ResolveInfo resolveInfo) {
        this.a = resolveInfo;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        this.b = activityInfo;
        this.c = new ComponentName(activityInfo.packageName, activityInfo.name);
        this.d = context.getPackageManager();
    }

    @Override // defpackage.ek0
    public final ApplicationInfo a() {
        return this.b.applicationInfo;
    }

    @Override // defpackage.ek0
    public final ComponentName b() {
        return this.c;
    }

    @Override // defpackage.ek0
    public final long c() {
        try {
            PackageInfo packageInfo = this.d.getPackageInfo(this.b.packageName, 0);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0L;
        }
    }

    @Override // defpackage.ek0
    public final Drawable d(int i) {
        Drawable drawableLoadIcon;
        ResolveInfo resolveInfo = this.a;
        int iconResource = resolveInfo.getIconResource();
        PackageManager packageManager = this.d;
        if (i == 0 || iconResource == 0) {
            drawableLoadIcon = null;
        } else {
            try {
                drawableLoadIcon = packageManager.getResourcesForApplication(this.b.applicationInfo).getDrawableForDensity(iconResource, i);
            } catch (PackageManager.NameNotFoundException | Resources.NotFoundException unused) {
                drawableLoadIcon = null;
            }
        }
        if (drawableLoadIcon == null) {
            drawableLoadIcon = resolveInfo.loadIcon(packageManager);
        }
        return drawableLoadIcon == null ? Resources.getSystem().getDrawableForDensity(R.mipmap.sym_def_app_icon, i) : drawableLoadIcon;
    }

    @Override // defpackage.ek0
    public final CharSequence e() {
        try {
            return this.a.loadLabel(this.d);
        } catch (SecurityException unused) {
            return "";
        }
    }

    @Override // defpackage.ek0
    public final jq1 f() {
        return jq1.b();
    }
}
