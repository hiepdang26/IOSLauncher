package defpackage;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class qk0 extends qh0 {
    public boolean B;
    public int x;
    public final ComponentName y;
    public int z;
    public int A = -1;
    public AppWidgetHostView C = null;

    public qk0(int i, ComponentName componentName) {
        this.x = -1;
        if (i == -100) {
            this.h = 5;
        } else {
            this.h = 4;
        }
        this.x = i;
        this.y = componentName;
        this.m = -1;
        this.n = -1;
        this.w = jq1.b();
        this.z = 0;
    }

    @Override // defpackage.qh0
    public final void d(Context context, ContentValues contentValues) {
        super.d(context, contentValues);
        contentValues.put("appWidgetId", Integer.valueOf(this.x));
        contentValues.put("appWidgetProvider", this.y.flattenToString());
        contentValues.put("restored", Integer.valueOf(this.z));
    }

    @Override // defpackage.qh0
    public final void e() {
        this.C = null;
    }

    public final boolean f(int i) {
        return (this.z & i) == i;
    }

    @Override // defpackage.qh0
    public final String toString() {
        return "AppWidget(id=" + Integer.toString(this.x) + ")";
    }
}
