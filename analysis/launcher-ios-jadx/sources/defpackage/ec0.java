package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class ec0 extends m91 {
    public final TextView A;
    public final TextView B;
    public final ImageView C;

    public ec0(fc0 fc0Var, View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(v51.forecast_time);
        this.A = textView;
        this.C = (ImageView) view.findViewById(v51.forecast_weather);
        TextView textView2 = (TextView) view.findViewById(v51.forecast_temperature_min);
        this.B = textView2;
        if (fc0Var.l) {
            textView.setTextColor(-1);
            textView2.setTextColor(-1);
        }
    }
}
