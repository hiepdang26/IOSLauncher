package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.appslibrary.AppsLibraryItemFull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class u7 extends m81 {
    public final /* synthetic */ int j;
    public ArrayList k;

    public /* synthetic */ u7(int i) {
        this.j = i;
    }

    @Override // defpackage.m81
    public final int c() {
        switch (this.j) {
            case 0:
                ArrayList arrayList = this.k;
                if (arrayList != null) {
                    return arrayList.size();
                }
                return 0;
            default:
                ArrayList arrayList2 = this.k;
                if (arrayList2 != null) {
                    return arrayList2.size();
                }
                return 0;
        }
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        switch (this.j) {
            case 0:
                t7 t7Var = (t7) m91Var;
                t7Var.A.setTitle(((x7) this.k.get(i)).a);
                t7Var.A.setApps(((x7) this.k.get(i)).b);
                break;
            default:
                ((kx1) m91Var).A.setImageDrawable(((ix1) this.k.get(i)).a);
                break;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        switch (this.j) {
            case 0:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.apps_library_item, viewGroup, false);
                t7 t7Var = new t7(viewInflate);
                if (viewInflate instanceof AppsLibraryItemFull) {
                    t7Var.A = (AppsLibraryItemFull) viewInflate;
                }
                return t7Var;
            default:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widgets_app_style_item, viewGroup, false);
                kx1 kx1Var = new kx1(viewInflate2);
                kx1Var.A = (AppCompatImageView) viewInflate2;
                return kx1Var;
        }
    }
}
