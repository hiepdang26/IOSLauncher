package defpackage;

import android.view.View;
import com.luutinhit.launcher6.FocusIndicatorView;
import com.luutinhit.launcher6.allapps.AllAppsContainerView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;

/* JADX INFO: loaded from: classes.dex */
public final class v3 implements View.OnFocusChangeListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ v3(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        Object obj = this.h;
        switch (this.g) {
            case 0:
                if (z) {
                    ((AllAppsContainerView) obj).t.requestFocus();
                }
                break;
            case 1:
                jj jjVar = (jj) obj;
                jjVar.e(jj.d(jjVar));
                break;
            case 2:
                ux uxVar = (ux) obj;
                uxVar.a.setEndIconActivated(z);
                if (!z) {
                    uxVar.i(false);
                    uxVar.l = false;
                }
                break;
            case 3:
                if (z) {
                    int i = FocusIndicatorView.o;
                    FocusIndicatorView focusIndicatorView = (FocusIndicatorView) obj;
                    focusIndicatorView.c();
                    focusIndicatorView.setAlpha(0.0f);
                }
                break;
            default:
                if (z) {
                    SearchViewLayout searchViewLayout = (SearchViewLayout) obj;
                    if (searchViewLayout.x()) {
                        searchViewLayout.postOnAnimationDelayed(new fl0(this, 11), 200L);
                    }
                }
                break;
        }
    }
}
