package defpackage;

import android.content.ComponentName;
import android.view.View;
import android.widget.Toast;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class s30 implements View.OnClickListener {
    public final /* synthetic */ z30 g;

    public s30(z30 z30Var) {
        this.g = z30Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z30 z30Var = this.g;
        t tVar = z30Var.x;
        try {
            View view2 = z30Var.z;
            if (view2 instanceof BubbleTextView) {
                tVar.startApplicationDetailsActivity(ComponentName.unflattenFromString(((BubbleTextView) view2).getComponentName()), jq1.b());
            }
            z30Var.postDelayed(new r30(z30Var, 0), 689L);
        } catch (Throwable unused) {
            Toast.makeText(tVar, w61.activity_not_found, 0).show();
        }
    }
}
