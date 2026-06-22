package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class nn0 {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public List k;
    public boolean l;

    public final void a(View view) {
        int iF;
        int size = this.k.size();
        View view2 = null;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((m91) this.k.get(i2)).g;
            v81 v81Var = (v81) view3.getLayoutParams();
            if (view3 != view && !v81Var.a.m() && (iF = (v81Var.a.f() - this.d) * this.e) >= 0 && iF < i) {
                view2 = view3;
                if (iF == 0) {
                    break;
                } else {
                    i = iF;
                }
            }
        }
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((v81) view2.getLayoutParams()).a.f();
        }
    }

    public final View b(c91 c91Var) {
        List list = this.k;
        if (list == null) {
            View view = c91Var.k(this.d, Long.MAX_VALUE).g;
            this.d += this.e;
            return view;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view2 = ((m91) this.k.get(i)).g;
            v81 v81Var = (v81) view2.getLayoutParams();
            if (!v81Var.a.m() && this.d == v81Var.a.f()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
