package defpackage;

import android.view.ViewTreeObserver;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v7 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ ua h;

    public /* synthetic */ v7(ua uaVar, int i) {
        this.g = i;
        this.h = uaVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        switch (this.g) {
            case 0:
                ((AppsLibraryCategoryActivity) this.h).D.invalidate();
                break;
            case 1:
                ((IconChangeActivity) this.h).E.invalidate();
                break;
            default:
                ((LabelChangeActivity) this.h).C.invalidate();
                break;
        }
    }
}
