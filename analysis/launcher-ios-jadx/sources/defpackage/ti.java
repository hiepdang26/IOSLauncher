package defpackage;

import android.view.View;
import com.luutinhit.weather.WeatherCitiesActivity;

/* JADX INFO: loaded from: classes.dex */
public final class ti implements View.OnClickListener {
    public final /* synthetic */ ui g;
    public final /* synthetic */ wi h;

    public ti(wi wiVar, ui uiVar) {
        this.h = wiVar;
        this.g = uiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WeatherCitiesActivity weatherCitiesActivity = this.h.n;
        int iF = this.g.f();
        wi wiVar = weatherCitiesActivity.D;
        wiVar.l.remove(iF);
        wiVar.g.f(iF, 1);
    }
}
