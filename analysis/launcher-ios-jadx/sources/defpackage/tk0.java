package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class tk0 extends qg0 {
    public PackageManager g;
    public Context h;
    public ArrayList i;
    public m6 j;

    @Override // defpackage.qg0
    public final boolean A(String str, jq1 jq1Var) {
        return az1.v(this.g, str, 0);
    }

    @Override // defpackage.qg0
    public final ek0 F(Intent intent, jq1 jq1Var) {
        ResolveInfo resolveInfoResolveActivity = this.g.resolveActivity(intent, 0);
        if (resolveInfoResolveActivity != null) {
            return new fk0(this.h, resolveInfoResolveActivity);
        }
        return null;
    }

    @Override // defpackage.qg0
    public final void L(ComponentName componentName, jq1 jq1Var) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", componentName.getPackageName(), null));
        intent.setFlags(276856832);
        this.h.startActivity(intent, null);
    }

    @Override // defpackage.qg0
    public final void M(ComponentName componentName, jq1 jq1Var, Rect rect, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(componentName);
        intent.setSourceBounds(rect);
        intent.addFlags(268435456);
        this.h.startActivity(intent, bundle);
    }

    public final synchronized ArrayList V() {
        return new ArrayList(this.i);
    }

    public final void W() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme("package");
        boolean z = ar1.j;
        m6 m6Var = this.j;
        Context context = this.h;
        if (z) {
            context.registerReceiver(m6Var, intentFilter, 2);
        } else {
            context.registerReceiver(m6Var, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        intentFilter2.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        if (z) {
            context.registerReceiver(m6Var, intentFilter2, 2);
        } else {
            context.registerReceiver(m6Var, intentFilter2);
        }
    }

    @Override // defpackage.qg0
    public final synchronized void a(rl0 rl0Var) {
        if (!this.i.contains(rl0Var)) {
            this.i.add(rl0Var);
            if (this.i.size() == 1) {
                W();
            }
        }
    }

    @Override // defpackage.qg0
    public final List r(String str, jq1 jq1Var) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = this.g.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList(listQueryIntentActivities.size());
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(new fk0(this.h, it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.qg0
    public final boolean x(ComponentName componentName, jq1 jq1Var) {
        try {
            ActivityInfo activityInfo = this.g.getActivityInfo(componentName, 0);
            if (activityInfo != null) {
                if (activityInfo.isEnabled()) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
