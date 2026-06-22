package defpackage;

import android.appwidget.AppWidgetHostView;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class bx1 implements lw {
    public final t i;
    public final View k;
    public final w11 l;
    public el0 g = null;
    public xm h = null;
    public int m = -1;
    public final Handler j = new Handler();

    public bx1(t tVar, View view) {
        this.i = tVar;
        this.k = view;
        this.l = (w11) view.getTag();
    }

    public static Bundle a(t tVar, w11 w11Var) {
        Rect rect = new Rect();
        if (!ar1.o) {
            return null;
        }
        r7.a(tVar, w11Var.m, w11Var.n, rect);
        Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(tVar, w11Var.x, null);
        float f = tVar.getResources().getDisplayMetrics().density;
        int i = (int) ((defaultPaddingForWidget.left + defaultPaddingForWidget.right) / f);
        int i2 = (int) ((defaultPaddingForWidget.top + defaultPaddingForWidget.bottom) / f);
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMinWidth", rect.left - i);
        bundle.putInt("appWidgetMinHeight", rect.top - i2);
        bundle.putInt("appWidgetMaxWidth", rect.right - i);
        bundle.putInt("appWidgetMaxHeight", rect.bottom - i2);
        return bundle;
    }

    @Override // defpackage.lw
    public final void t() {
        t tVar = this.i;
        tVar.getDragController().m.remove(this);
        Handler handler = this.j;
        handler.removeCallbacks(this.h);
        handler.removeCallbacks(this.g);
        if (this.m != -1) {
            tVar.getAppWidgetHost().deleteAppWidgetId(this.m);
            this.m = -1;
        }
        w11 w11Var = this.l;
        if (w11Var.A != null) {
            tVar.getDragLayer().removeView(w11Var.A);
            tVar.getAppWidgetHost().deleteAppWidgetId(w11Var.A.getAppWidgetId());
            w11Var.A = null;
        }
    }

    @Override // defpackage.lw
    public final void s(xw xwVar, Object obj) {
    }
}
