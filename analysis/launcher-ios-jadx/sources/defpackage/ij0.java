package defpackage;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.activity.LabelChangeActivity;

/* JADX INFO: loaded from: classes.dex */
public final class ij0 extends m91 implements View.OnClickListener {
    public final TextViewCustomFont A;
    public final AppCompatImageView B;
    public final /* synthetic */ sg C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij0(sg sgVar, View view) {
        super(view);
        this.C = sgVar;
        this.A = (TextViewCustomFont) view.findViewById(v51.label);
        this.B = (AppCompatImageView) view.findViewById(v51.icon_app);
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        sg sgVar = this.C;
        if (((LabelChangeActivity) sgVar.l) == null || sgVar.k == null) {
            return;
        }
        int iE = e();
        int i = ((y6) sgVar.k.get(iE)).a;
        String str = ((y6) sgVar.k.get(iE)).c;
        String str2 = ((y6) sgVar.k.get(iE)).d;
        LabelChangeActivity labelChangeActivity = (LabelChangeActivity) sgVar.l;
        labelChangeActivity.getClass();
        try {
            labelChangeActivity.A(iE, str2, str);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
