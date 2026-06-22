package defpackage;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.graphics.Rect;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class rk0 extends AppWidgetProviderInfo {
    public int g;
    public int h;
    public int i;
    public int j;

    public static rk0 a(AppWidgetProviderInfo appWidgetProviderInfo) {
        Parcel parcelObtain = Parcel.obtain();
        appWidgetProviderInfo.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        rk0 rk0Var = new rk0(parcelObtain);
        rk0Var.b();
        parcelObtain.recycle();
        return rk0Var;
    }

    public final void b() {
        ComponentName componentName = ((AppWidgetProviderInfo) this).provider;
        if (componentName != null) {
            componentName.getClassName();
            String className = ((AppWidgetProviderInfo) this).provider.getClassName();
            className.getClass();
            switch (className) {
                case "com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider":
                    this.i = 4;
                    this.g = 4;
                    this.j = 2;
                    this.h = 2;
                    break;
                case "com.luutinhit.launcher6.widget.widgetprovider.BatteryWidgetProvider":
                case "com.luutinhit.launcher6.widget.widgetprovider.PictureAppWidgetProvider":
                    this.i = 2;
                    this.g = 2;
                    this.j = 2;
                    this.h = 2;
                    break;
                default:
                    xg0 xg0Var = jk0.a().e;
                    xu xuVar = xg0Var.r;
                    float f = xuVar.H;
                    float f2 = xuVar.I;
                    int i = xg0Var.r.I;
                    Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(jk0.i, ((AppWidgetProviderInfo) this).provider, null);
                    this.g = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minWidth + defaultPaddingForWidget.left) + defaultPaddingForWidget.right) / f));
                    int iMax = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minHeight + defaultPaddingForWidget.top) + defaultPaddingForWidget.bottom) / f2));
                    this.h = iMax;
                    int i2 = this.g;
                    if (i2 == 1 && iMax > 1) {
                        i2 = 2;
                    }
                    this.g = i2;
                    this.h = (iMax != 1 || i2 <= 1) ? iMax : 2;
                    ((AppWidgetProviderInfo) this).provider.toString();
                    this.i = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minResizeWidth + defaultPaddingForWidget.left) + defaultPaddingForWidget.right) / f));
                    this.j = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minResizeHeight + defaultPaddingForWidget.top) + defaultPaddingForWidget.bottom) / f2));
                    ((AppWidgetProviderInfo) this).provider.toString();
                    ((AppWidgetProviderInfo) this).provider.toString();
                    break;
            }
        }
    }
}
