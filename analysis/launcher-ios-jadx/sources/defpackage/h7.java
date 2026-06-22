package defpackage;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class h7 extends m91 {
    public final ImageView A;
    public final /* synthetic */ i7 B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h7(i7 i7Var, View view) {
        super(view);
        this.B = i7Var;
        this.A = (ImageView) view.findViewById(v51.icon_suggestion);
        view.setOnClickListener(new g7(this, 0));
    }
}
