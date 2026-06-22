package defpackage;

import android.view.View;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class be0 implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ u3 h;

    public /* synthetic */ be0(u3 u3Var, int i) {
        this.g = i;
        this.h = u3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u3 u3Var = this.h;
        switch (this.g) {
            case 0:
                u3Var.dismiss();
                break;
            case 1:
                int i = LabelChangeActivity.H;
                if (u3Var != null) {
                    u3Var.cancel();
                }
                break;
            case 2:
                int i2 = MainActivity.I;
                u3Var.dismiss();
                break;
            default:
                int i3 = MainActivity.I;
                u3Var.dismiss();
                break;
        }
    }
}
