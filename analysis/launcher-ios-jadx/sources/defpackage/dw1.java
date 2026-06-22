package defpackage;

import android.content.Intent;
import android.view.View;
import com.luutinhit.launcher6.util.SpeedLinearLayoutManager;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.WeatherWidget_2x2;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dw1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ dw1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.h;
        switch (this.g) {
            case 0:
                fw1 fw1Var = (fw1) obj;
                fw1Var.getClass();
                Intent intent = new Intent(fw1Var.Z, (Class<?>) WeatherAppWidgetProvider.class);
                intent.setAction("com.luutinhit.ACTION_UPDATE_WEATHER_WIDGET_FROM_DB");
                fw1Var.Z.sendBroadcast(intent);
                break;
            case 1:
                int i = WeatherWidget.H;
                WeatherWidget weatherWidget = (WeatherWidget) obj;
                weatherWidget.getClass();
                Intent intent2 = new Intent(weatherWidget.k, (Class<?>) WeatherAppWidgetProvider.class);
                intent2.setAction("com.luutinhit.ACTION_UPDATE_WEATHER_WIDGET_FROM_DB");
                weatherWidget.k.sendBroadcast(intent2);
                break;
            case 2:
                WeatherWidget_2x2 weatherWidget_2x2 = (WeatherWidget_2x2) obj;
                weatherWidget_2x2.o.setText(weatherWidget_2x2.y.e("city"));
                weatherWidget_2x2.n.setText("H:" + weatherWidget_2x2.y.e("current_temp_high") + " L:" + weatherWidget_2x2.y.e("current_temp_low"));
                break;
            default:
                int i2 = v51.divider_line_widget;
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) ((hb) obj).b;
                View viewFindViewById = widgetsContainerView.findViewById(i2);
                SpeedLinearLayoutManager speedLinearLayoutManager = widgetsContainerView.V;
                View viewR0 = speedLinearLayoutManager.R0(0, speedLinearLayoutManager.v(), true, false);
                viewFindViewById.setVisibility((viewR0 == null ? -1 : u81.J(viewR0)) == 0 ? 8 : 0);
                break;
        }
    }
}
