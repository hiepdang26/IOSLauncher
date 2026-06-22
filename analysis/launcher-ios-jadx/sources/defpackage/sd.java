package defpackage;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class sd extends q81 {
    public final /* synthetic */ BouncyRecyclerView a;
    public final /* synthetic */ BouncyRecyclerView b;

    public sd(BouncyRecyclerView bouncyRecyclerView, BouncyRecyclerView bouncyRecyclerView2) {
        this.a = bouncyRecyclerView;
        this.b = bouncyRecyclerView2;
    }

    @Override // defpackage.q81
    public final EdgeEffect a(RecyclerView recyclerView, int i) {
        qg0.l(recyclerView, "recyclerView");
        return new rd(recyclerView, i, this.a, this.b, recyclerView.getContext());
    }
}
