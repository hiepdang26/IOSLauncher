package defpackage;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class f02 {
    public final t a;
    public final Workspace b;
    public AnimatorSet c;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public float h;
    public final o02 i = new o02();
    public final float j;
    public final float k;
    public final float l;
    public final int m;
    public final int n;
    public final int o;
    public final boolean p;

    public f02(t tVar, Workspace workspace) {
        this.a = tVar;
        this.b = workspace;
        xu deviceProfile = tVar.getDeviceProfile();
        Resources resources = tVar.getResources();
        this.m = resources.getInteger(g61.config_allAppsTransitionTime);
        this.n = resources.getInteger(g61.config_overviewTransitionTime);
        this.o = resources.getInteger(g61.config_overlayTransitionTime);
        this.j = resources.getInteger(g61.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        this.k = resources.getInteger(g61.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.l = resources.getInteger(g61.config_workspaceScrimAlpha) / 100.0f;
        this.p = deviceProfile.c;
    }
}
