package defpackage;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import android.view.View;
import com.luutinhit.launcher6.DragLayer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e90 implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ DragLayer c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e90(h90 h90Var, Bitmap bitmap, f90 f90Var, DragLayer dragLayer) {
        this.d = h90Var;
        this.b = bitmap;
        this.e = f90Var;
        this.c = dragLayer;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        switch (this.a) {
            case 0:
                h90 h90Var = (h90) this.d;
                Bitmap bitmap = this.b;
                f90 f90Var = (f90) this.e;
                DragLayer dragLayer = this.c;
                if (i != 0) {
                    h90Var.getClass();
                    h90.c(dragLayer, f90Var);
                } else {
                    h90Var.getClass();
                    bitmap.getWidth();
                    bitmap.getHeight();
                    f90Var.a(bitmap);
                }
                break;
            default:
                l90 l90Var = (l90) this.d;
                i90 i90Var = (i90) this.e;
                Bitmap bitmap2 = this.b;
                DragLayer dragLayer2 = this.c;
                if (i != 0) {
                    l90Var.getClass();
                    l90.g(dragLayer2, i90Var);
                } else {
                    l90Var.getClass();
                    i90Var.a(bitmap2);
                }
                break;
        }
    }

    public /* synthetic */ e90(l90 l90Var, i90 i90Var, Bitmap bitmap, DragLayer dragLayer) {
        this.d = l90Var;
        this.e = i90Var;
        this.b = bitmap;
        this.c = dragLayer;
    }
}
