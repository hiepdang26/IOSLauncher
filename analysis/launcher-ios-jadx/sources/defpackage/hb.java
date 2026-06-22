package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class hb extends z81 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ hb(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.z81
    public final void b(RecyclerView recyclerView, int i, int i2) {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                AllAppsRecyclerView allAppsRecyclerView = (AllAppsRecyclerView) obj;
                allAppsRecyclerView.Q0 = i2;
                allAppsRecyclerView.w0(i2);
                break;
            case 1:
                qg0.l(recyclerView, "recyclerView");
                int i3 = BouncyRecyclerView.b1;
                ((BouncyRecyclerView) obj).t0();
                break;
            case 2:
                ((wq) obj).m.invalidate();
                break;
            case 3:
                int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                r20 r20Var = (r20) obj;
                int iComputeVerticalScrollRange = r20Var.y.computeVerticalScrollRange();
                int i4 = r20Var.x;
                int i5 = iComputeVerticalScrollRange - i4;
                int i6 = r20Var.g;
                r20Var.z = i5 > 0 && i4 >= i6;
                int iComputeHorizontalScrollRange = r20Var.y.computeHorizontalScrollRange();
                int i7 = r20Var.w;
                boolean z = iComputeHorizontalScrollRange - i7 > 0 && i7 >= i6;
                r20Var.A = z;
                boolean z2 = r20Var.z;
                if (z2 || z) {
                    if (z2) {
                        float f = i4;
                        r20Var.r = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                        r20Var.q = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
                    }
                    if (r20Var.A) {
                        float f2 = iComputeHorizontalScrollOffset;
                        float f3 = i7;
                        r20Var.u = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                        r20Var.t = Math.min(i7, (i7 * i7) / iComputeHorizontalScrollRange);
                    }
                    int i8 = r20Var.B;
                    if (i8 == 0 || i8 == 1) {
                        r20Var.l(1);
                    }
                } else if (r20Var.B != 0) {
                    r20Var.l(0);
                }
                break;
            case 4:
                ((WallpaperActivity) obj).Q.invalidate();
                break;
            default:
                ((WidgetsContainerView) obj).postOnAnimation(new dw1(this, 3));
                break;
        }
    }
}
