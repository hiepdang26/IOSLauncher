package defpackage;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class mb0 extends z81 {
    public int a = 0;

    @Override // defpackage.z81
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.a + i2;
        this.a = i3;
        c(i3);
    }

    public abstract void c(int i);

    public void d(Rect rect) {
    }
}
