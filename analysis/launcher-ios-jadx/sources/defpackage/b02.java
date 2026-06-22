package defpackage;

import android.appwidget.AppWidgetHostView;
import android.os.Handler;
import com.luutinhit.launcher6.Workspace;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b02 implements Runnable {
    public final ArrayList g;
    public final lk0 h;
    public final Handler i;
    public boolean j;
    public final /* synthetic */ Workspace k;

    public b02(Workspace workspace, ArrayList arrayList, lk0 lk0Var) {
        this.k = workspace;
        this.g = arrayList;
        this.h = lk0Var;
        Handler handler = new Handler();
        this.i = handler;
        this.j = true;
        lk0Var.a.add(this);
        handler.postDelayed(this, 10000L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        lk0 lk0Var = this.h;
        if (lk0Var != null) {
            lk0Var.a.remove(this);
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        if (this.j) {
            this.j = false;
            ArrayList arrayList = this.g;
            if (arrayList != null) {
                Workspace workspace = this.k;
                if (workspace.S0 != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        qk0 qk0Var = (qk0) obj;
                        if (qk0Var != null) {
                            AppWidgetHostView appWidgetHostView = qk0Var.C;
                            if (appWidgetHostView instanceof x11) {
                                workspace.S0.removeItem((x11) appWidgetHostView, qk0Var, false);
                                workspace.S0.bindAppWidget(qk0Var);
                            }
                        }
                    }
                }
            }
        }
    }
}
