package defpackage;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.luutinhit.launcher6.widget.SwipeMenuLayout;
import com.luutinhit.weather.WeatherCitiesActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class wi extends m81 {
    public SparseArray j;
    public LayoutInflater k;
    public ArrayList l;
    public WeatherCitiesActivity m;
    public WeatherCitiesActivity n;

    @Override // defpackage.m81
    public final int c() {
        int size = this.j.size();
        ArrayList arrayList = this.l;
        return (arrayList == null ? 0 : arrayList.size()) + size;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        if (this.j.size() > 0) {
            ArrayList arrayList = this.l;
            if (i >= (arrayList == null ? 0 : arrayList.size())) {
                SparseArray sparseArray = this.j;
                ArrayList arrayList2 = this.l;
                return sparseArray.keyAt(i - (arrayList2 != null ? arrayList2.size() : 0));
            }
        }
        return 0;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        ui uiVar = (ui) m91Var;
        if (this.j.size() > 0) {
            ArrayList arrayList = this.l;
            if (i >= (arrayList == null ? 0 : arrayList.size())) {
                return;
            }
        }
        kw1 kw1Var = (kw1) this.l.get(i);
        vi viVar = (vi) uiVar;
        if (kw1Var.d.equals("0")) {
            viVar.A.setSwipeEnable(false);
        }
        viVar.D.setText(kw1Var.a);
        viVar.E.setText(kw1Var.b);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(kw1Var.c);
        viVar.C.setText(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        if (this.m != null) {
            viVar.B.setOnClickListener(new si(this, uiVar));
        }
        if (this.n != null) {
            viVar.F.setOnClickListener(new ti(this, uiVar));
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        if (this.j.size() > 0) {
            SparseArray sparseArray = this.j;
            if (sparseArray.get(i) != null) {
                return new ui((View) sparseArray.get(i));
            }
        }
        View viewInflate = this.k.inflate(m61.recycler_weather_city, viewGroup, false);
        vi viVar = new vi(viewInflate);
        viVar.A = (SwipeMenuLayout) viewInflate.findViewById(v51.swipe_out);
        viVar.B = (RelativeLayout) viewInflate.findViewById(v51.item_visible);
        viVar.C = (TextView) viewInflate.findViewById(v51.local_time);
        viVar.D = (TextView) viewInflate.findViewById(v51.local_city);
        viVar.E = (TextView) viewInflate.findViewById(v51.local_temperature);
        viVar.F = (TextView) viewInflate.findViewById(v51.item_delete);
        return viVar;
    }
}
