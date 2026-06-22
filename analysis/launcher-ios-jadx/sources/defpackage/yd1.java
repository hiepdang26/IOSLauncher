package defpackage;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.work.impl.WorkDatabase;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.Weather;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yd1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    public /* synthetic */ yd1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
        this.k = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.k;
        Object obj2 = this.j;
        Object obj3 = this.i;
        Object obj4 = this.h;
        switch (this.g) {
            case 0:
                List list = (List) obj4;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ud1) it.next()).a(((zy1) obj3).a);
                }
                fe1.b((rl) obj2, (WorkDatabase) obj, list);
                break;
            default:
                int i = WeatherWidget.H;
                WeatherWidget weatherWidget = (WeatherWidget) obj4;
                weatherWidget.getClass();
                CurrentResponse currentResponse = (CurrentResponse) obj3;
                if (currentResponse != null && ((Throwable) obj2) == null) {
                    weatherWidget.x = true;
                    weatherWidget.w = true;
                    String name = (String) obj;
                    if (TextUtils.isEmpty(name)) {
                        name = currentResponse.getName();
                    }
                    weatherWidget.o.setText(name);
                    weatherWidget.A.h("city", name);
                    List<Weather> weather = currentResponse.getWeather();
                    if (weather != null && !weather.isEmpty() && weather.get(0) != null) {
                        weatherWidget.p.setText(currentResponse.getWeather().get(0).getDescription());
                        weatherWidget.A.h("weather_state", currentResponse.getWeather().get(0).getDescription());
                        weatherWidget.q.setImageResource(WeatherWidget.x(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()));
                        weatherWidget.A.f(WeatherWidget.x(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()), "current_drawable_id");
                    }
                    weatherWidget.A.h("humidity", weatherWidget.k.getString(w61.humidity_value, currentResponse.getMain().getHumidity()));
                    TextView textView = weatherWidget.m;
                    int temp = currentResponse.getMain().getTemp();
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp);
                    sb.append((char) 176);
                    textView.setText(sb.toString());
                    bo1 bo1Var = weatherWidget.A;
                    int temp2 = currentResponse.getMain().getTemp();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(temp2);
                    sb2.append((char) 176);
                    bo1Var.h("current_temp", sb2.toString());
                    bo1 bo1Var2 = weatherWidget.A;
                    int feelsLike = currentResponse.getMain().getFeelsLike();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(feelsLike);
                    sb3.append((char) 176);
                    bo1Var2.h("feels_like", sb3.toString());
                    weatherWidget.A.h("CURRENT_DAY", currentResponse.getDt() + "");
                    weatherWidget.postDelayed(new dw1(weatherWidget, 1), 1000L);
                } else {
                    weatherWidget.o.setText(weatherWidget.A.e("city"));
                    weatherWidget.n.setText("H:" + weatherWidget.A.e("current_temp_high") + " L:" + weatherWidget.A.e("current_temp_low"));
                }
                break;
        }
    }
}
