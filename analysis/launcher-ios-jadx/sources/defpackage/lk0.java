package defpackage;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lk0 extends AppWidgetHost {
    public final ArrayList a;
    public final int b;
    public final t c;

    public lk0(t tVar) {
        super(tVar, 1024);
        this.a = new ArrayList();
        this.b = -1;
        this.c = tVar;
    }

    @Override // android.appwidget.AppWidgetHost
    public final AppWidgetHostView onCreateView(Context context, int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        return i == this.b ? new kk0(context) : new pk0(context);
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProviderChanged(int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        rk0 rk0VarA = rk0.a(appWidgetProviderInfo);
        super.onProviderChanged(i, rk0VarA);
        rk0VarA.b();
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProvidersChanged() {
        ArrayList arrayList = this.a;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        if (ar1.i) {
            this.c.notifyWidgetProvidersChanged();
        }
    }

    @Override // android.appwidget.AppWidgetHost
    public final void startListening() {
        try {
            super.startListening();
        } catch (Throwable unused) {
        }
    }

    @Override // android.appwidget.AppWidgetHost
    public final void stopListening() {
        super.stopListening();
        clearViews();
    }
}
