package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.graphics.Rect;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class vk0 extends qg0 {
    public LauncherApps g;
    public HashMap h;

    @Override // defpackage.qg0
    public final boolean A(String str, jq1 jq1Var) {
        return this.g.isPackageEnabled(str, jq1Var.a);
    }

    @Override // defpackage.qg0
    public final ek0 F(Intent intent, jq1 jq1Var) {
        LauncherActivityInfo launcherActivityInfoResolveActivity = this.g.resolveActivity(intent, jq1Var.a);
        if (launcherActivityInfoResolveActivity != null) {
            return new gk0(launcherActivityInfoResolveActivity);
        }
        return null;
    }

    @Override // defpackage.qg0
    public final void L(ComponentName componentName, jq1 jq1Var) {
        this.g.startAppDetailsActivity(componentName, jq1Var.a, null, null);
    }

    @Override // defpackage.qg0
    public final void M(ComponentName componentName, jq1 jq1Var, Rect rect, Bundle bundle) {
        this.g.startMainActivity(componentName, jq1Var.a, rect, bundle);
    }

    @Override // defpackage.qg0
    public final void a(rl0 rl0Var) {
        uk0 uk0Var = new uk0();
        uk0Var.a = rl0Var;
        synchronized (this.h) {
            this.h.put(rl0Var, uk0Var);
        }
        this.g.registerCallback(uk0Var);
    }

    @Override // defpackage.qg0
    public final List r(String str, jq1 jq1Var) {
        List<LauncherActivityInfo> activityList = this.g.getActivityList(str, jq1Var.a);
        if (activityList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(activityList.size());
        Iterator<LauncherActivityInfo> it = activityList.iterator();
        while (it.hasNext()) {
            arrayList.add(new gk0(it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.qg0
    public final boolean x(ComponentName componentName, jq1 jq1Var) {
        return this.g.isActivityEnabled(componentName, jq1Var.a);
    }
}
