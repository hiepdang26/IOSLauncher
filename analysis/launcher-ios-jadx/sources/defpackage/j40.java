package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final class j40 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ View h;
    public final /* synthetic */ nx i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ ViewGroup k;

    public /* synthetic */ j40(ViewGroup viewGroup, View view, nx nxVar, boolean z, int i) {
        this.g = i;
        this.k = viewGroup;
        this.h = view;
        this.i = nxVar;
        this.j = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                View view = this.h;
                nx nxVar = this.i;
                Folder folder = (Folder) this.k;
                folder.l(view, nxVar, this.j);
                folder.S = null;
                break;
            default:
                View view2 = this.h;
                nx nxVar2 = this.i;
                Workspace workspace = (Workspace) this.k;
                workspace.l(view2, nxVar2, this.j);
                workspace.D1 = null;
                break;
        }
    }
}
