package defpackage;

import android.view.View;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.FolderPagedView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class x40 implements Runnable {
    public final /* synthetic */ View g;
    public final /* synthetic */ float h;
    public final /* synthetic */ int i;
    public final /* synthetic */ FolderPagedView j;

    public x40(FolderPagedView folderPagedView, View view, float f, int i) {
        this.j = folderPagedView;
        this.g = view;
        this.h = f;
        this.i = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FolderPagedView folderPagedView = this.j;
        HashMap map = folderPagedView.w0;
        View view = this.g;
        map.remove(view);
        view.setTranslationX(this.h);
        ((CellLayout) view.getParent().getParent()).removeView(view);
        folderPagedView.i0(view, (og1) view.getTag(), this.i);
    }
}
