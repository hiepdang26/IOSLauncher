package defpackage;

import android.content.Intent;
import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t30 implements View.OnClickListener {
    public final /* synthetic */ z30 g;

    public t30(z30 z30Var) {
        this.g = z30Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z30 z30Var = this.g;
        bo1 bo1Var = z30Var.y;
        try {
            z30Var.d();
            if (z30Var.z instanceof BubbleTextView) {
                ArrayList arrayListD = bo1Var.d("list_hidden_apps");
                arrayListD.add(((BubbleTextView) z30Var.z).getComponentName());
                bo1Var.i("list_hidden_apps", arrayListD);
                Intent intent = new Intent("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
                intent.putExtra("HIDDEN_APPS_UPDATED", new String[0]);
                intent.putExtra("HIDDEN_APPS_REMOVED", (String[]) arrayListD.toArray(new String[0]));
                z30Var.x.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
