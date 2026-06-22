package defpackage;

import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.FolderPagedView;

/* JADX INFO: loaded from: classes.dex */
public final class o40 extends kw {
    public final int B;
    public final FolderPagedView C;

    public o40(CellLayout cellLayout) {
        super(cellLayout);
        FolderPagedView folderPagedView = (FolderPagedView) cellLayout.getParent();
        this.C = folderPagedView;
        this.B = cellLayout.getCountY() * cellLayout.getCountX() * folderPagedView.indexOfChild(cellLayout);
    }

    @Override // defpackage.kw
    public final int A(int i) {
        return Math.min(i, (this.C.getAllocatedContentSize() - this.B) - 1);
    }

    @Override // defpackage.kw
    public final String x(int i) {
        return this.x.getString(w61.item_moved);
    }

    @Override // defpackage.kw
    public final String z(int i) {
        return this.x.getString(w61.move_to_position, Integer.valueOf(i + this.B + 1));
    }
}
