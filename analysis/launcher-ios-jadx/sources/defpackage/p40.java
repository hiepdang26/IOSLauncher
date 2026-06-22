package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p40 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ViewGroup h;
    public final /* synthetic */ boolean i;

    public /* synthetic */ p40(ViewGroup viewGroup, boolean z, int i) {
        this.g = i;
        this.h = viewGroup;
        this.i = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        xg0 xg0Var;
        boolean z = this.i;
        ViewGroup viewGroup = this.h;
        switch (this.g) {
            case 0:
                boolean z2 = FolderIcon.D;
                ((FolderIcon) viewGroup).setGlassViewVisible(z);
                break;
            case 1:
                y80 y80Var = ((FolderIcon) viewGroup).l;
                if (y80Var != null) {
                    y80Var.setVisibility(z ? 0 : 4);
                }
                break;
            default:
                Workspace workspace = (Workspace) viewGroup;
                xu xuVar = workspace.F0;
                if (xuVar != null && (xg0Var = xuVar.a) != null) {
                    if (!z) {
                        CellLayout currentCellLayout = workspace.getCurrentCellLayout();
                        if (currentCellLayout != null) {
                            currentCellLayout.e(xg0Var, true);
                        }
                    } else {
                        int iI0 = workspace.I0();
                        while (iI0 < workspace.getPageCount()) {
                            View childAt = workspace.getChildAt(iI0);
                            if (childAt instanceof CellLayout) {
                                ((CellLayout) childAt).e(xg0Var, iI0 == workspace.getCurrentPage());
                            }
                            iI0++;
                        }
                    }
                    break;
                }
                break;
        }
    }
}
