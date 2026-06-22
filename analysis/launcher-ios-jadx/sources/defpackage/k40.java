package defpackage;

import android.view.View;
import android.view.ViewParent;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class k40 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Folder h;

    public /* synthetic */ k40(Folder folder, int i) {
        this.g = i;
        this.h = folder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View viewCreateShortcut;
        switch (this.g) {
            case 0:
                Folder folder = this.h;
                int size = folder.p.x.size();
                if (size <= 1) {
                    t tVar = folder.n;
                    if (size == 1) {
                        w40 w40Var = folder.p;
                        CellLayout cellLayout = tVar.getCellLayout(w40Var.i, w40Var.j);
                        og1 og1Var = (og1) folder.p.x.remove(0);
                        viewCreateShortcut = tVar.createShortcut(cellLayout, og1Var);
                        w40 w40Var2 = folder.p;
                        rl0.c(folder.n, og1Var, w40Var2.i, w40Var2.j, w40Var2.k, w40Var2.l);
                    } else {
                        viewCreateShortcut = null;
                    }
                    View view = viewCreateShortcut;
                    folder.q.clearAnimation();
                    tVar.removeItem(folder.q, folder.p, true);
                    ViewParent viewParent = folder.q;
                    if (viewParent instanceof ox) {
                        folder.o.l.remove((ox) viewParent);
                    }
                    if (view != null) {
                        Workspace workspace = tVar.getWorkspace();
                        w40 w40Var3 = folder.p;
                        long j = w40Var3.i;
                        long j2 = w40Var3.j;
                        int i = w40Var3.k;
                        int i2 = w40Var3.l;
                        int i3 = w40Var3.m;
                        int i4 = w40Var3.n;
                        workspace.getClass();
                        Objects.toString(view);
                        workspace.j0(view, j, j2, i, i2, i3, i4, false, true);
                        view.requestFocus();
                    }
                }
                break;
            case 1:
                this.h.n.exitSpringLoadedDragModeDelayed(true, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            case 2:
                Folder folder2 = this.h;
                if (folder2.getItemCount() <= 1) {
                    folder2.I();
                }
                break;
            case 3:
                this.h.setLayerType(0, null);
                break;
            default:
                this.h.s.setLayerType(0, null);
                break;
        }
    }
}
