package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class u20 extends m91 {
    public final ImageView A;
    public final TextView B;
    public final /* synthetic */ y00 C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u20(y00 y00Var, View view) {
        super(view);
        this.C = y00Var;
        this.A = (ImageView) view.findViewById(v51.contact_avatar);
        this.B = (TextView) view.findViewById(v51.contact_name);
        view.setOnClickListener(new t20(this));
    }
}
