package defpackage;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class x00 extends m91 {
    public final View A;
    public final TextView B;
    public final TextView C;
    public final /* synthetic */ y00 D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x00(y00 y00Var, View view) {
        super(view);
        this.D = y00Var;
        this.A = view.findViewById(v51.event_color);
        this.B = (TextView) view.findViewById(v51.event_name);
        this.C = (TextView) view.findViewById(v51.event_time);
        view.setOnClickListener(new g7(this, 5));
    }
}
