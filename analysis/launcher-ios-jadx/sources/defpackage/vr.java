package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.luutinhit.weather.utils.RangeSeekBar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class vr extends m81 {
    public final LayoutInflater j;
    public int k;
    public int l;
    public ArrayList m = new ArrayList();
    public final SimpleDateFormat n;

    public vr(Context context) {
        new SimpleDateFormat("h:mm ", Locale.getDefault());
        this.n = new SimpleDateFormat("EEE ", Locale.getDefault());
        this.j = LayoutInflater.from(context);
    }

    @Override // defpackage.m81
    public final int c() {
        this.m.size();
        ArrayList arrayList = this.m;
        return (arrayList == null ? 0 : arrayList.size()) + 1;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        return i == 0 ? 10000 : 0;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        if (i > 0) {
            ur urVar = (ur) m91Var;
            lw1 lw1Var = (lw1) this.m.get(i - 1);
            urVar.A.setText(this.n.format(Long.valueOf(lw1Var.a)));
            urVar.C.c(lw1Var.d, lw1Var.c, this.k, this.l);
            urVar.D.setImageResource(lw1Var.b);
            urVar.B.setText(String.format(Locale.getDefault(), "%d%s", Integer.valueOf(lw1Var.e), "%"));
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = this.j;
        if (i == 10000) {
            return new tr(layoutInflater.inflate(m61.recycler_daily_forecast_header, viewGroup, false));
        }
        View viewInflate = layoutInflater.inflate(m61.recycler_daily_forecast, viewGroup, false);
        ur urVar = new ur(viewInflate);
        urVar.A = (TextView) viewInflate.findViewById(v51.daily_week);
        urVar.C = (RangeSeekBar) viewInflate.findViewById(v51.daily_temp_min_max);
        urVar.D = (ImageView) viewInflate.findViewById(v51.daily_weather_state);
        urVar.B = (TextView) viewInflate.findViewById(v51.daily_clouds_percent);
        return urVar;
    }
}
