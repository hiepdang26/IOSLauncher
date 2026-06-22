package defpackage;

import androidx.work.impl.foreground.SystemForegroundService;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final class yf implements Runnable {
    public final /* synthetic */ int g;
    public int h;
    public final Object i;

    public /* synthetic */ yf(Object obj, int i, int i2) {
        this.g = i2;
        this.i = obj;
        this.h = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                qb1 qb1Var = (qb1) ((nx0) this.i).h;
                if (qb1Var != null) {
                    qb1Var.onFontRetrievalFailed(this.h);
                }
                break;
            case 1:
                mw mwVar = (mw) this.i;
                ww wwVar = mwVar.q;
                if (wwVar != null) {
                    if (this.h == 0) {
                        ((Workspace) wwVar).V();
                    } else {
                        ((Workspace) wwVar).W();
                    }
                    mwVar.r = 0;
                    mwVar.x = 0;
                    Workspace workspace = (Workspace) mwVar.q;
                    if (workspace.i1) {
                        workspace.invalidate();
                        CellLayout currentDropLayout = workspace.getCurrentDropLayout();
                        workspace.setCurrentDropLayout(currentDropLayout);
                        workspace.setCurrentDragOverlappingLayout(currentDropLayout);
                        workspace.i1 = false;
                    }
                    mwVar.a.getDragLayer().onExitScrollArea();
                    if (mwVar.f) {
                        int[] iArr = mwVar.v;
                        mwVar.b(iArr[0], iArr[1]);
                    }
                }
                break;
            case 2:
                ((ir0) this.i).g0.o0(this.h);
                break;
            case 3:
                ((SystemForegroundService) this.i).k.cancel(this.h);
                break;
            case 4:
                ((wt1) this.i).o0(this.h);
                break;
            case 5:
                WeatherActivity weatherActivity = (WeatherActivity) this.i;
                u71 u71Var = weatherActivity.J;
                int i = weatherActivity.N;
                int i2 = weatherActivity.O;
                u71Var.getClass();
                int i3 = this.h;
                if (i3 < 1) {
                    i3 = 1;
                }
                u71Var.k = i3;
                u71Var.i = i;
                u71Var.j = i2;
                u71Var.a();
                weatherActivity.J.setWaterRadius(1.5f);
                break;
            default:
                ((v02) this.i).g(this.h);
                break;
        }
    }

    public yf(mw mwVar) {
        this.g = 1;
        this.i = mwVar;
    }

    public yf(int i, wt1 wt1Var) {
        this.g = 4;
        this.h = i;
        this.i = wt1Var;
    }
}
