package defpackage;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i7 extends m81 {
    public final Context j;
    public final LayoutInflater k;
    public ArrayList l = new ArrayList();
    public int m = -1;
    public final Animation n;

    public i7(Context context) {
        this.j = context;
        this.k = LayoutInflater.from(context);
        this.n = AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    @Override // defpackage.m81
    public final int c() {
        ArrayList arrayList = this.l;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        h7 h7Var = (h7) m91Var;
        ArrayList arrayList = this.l;
        if (arrayList == null || i >= arrayList.size()) {
            return;
        }
        h7Var.A.setImageBitmap(((gh0) this.l.get(i)).d);
        if (i > this.m) {
            h7Var.g.startAnimation(this.n);
            this.m = i;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return new h7(this, this.k.inflate(m61.suggestions_item, viewGroup, false));
    }
}
