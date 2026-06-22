package defpackage;

import android.view.ViewTreeObserver;
import com.luutinhit.launcherios.activity.HiddenAppsActivity;

/* JADX INFO: loaded from: classes.dex */
public final class cc0 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ HiddenAppsActivity g;

    public cc0(HiddenAppsActivity hiddenAppsActivity) {
        this.g = hiddenAppsActivity;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        HiddenAppsActivity hiddenAppsActivity = this.g;
        String str = hiddenAppsActivity.B;
        hiddenAppsActivity.Q.invalidate();
    }
}
