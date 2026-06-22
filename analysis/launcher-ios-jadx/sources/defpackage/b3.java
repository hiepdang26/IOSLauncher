package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class b3 extends th0 {
    public final /* synthetic */ int d;
    public final wh0 e;
    public final Paint f;
    public final Context g;

    public b3(wh0 wh0Var, Context context, int i) {
        this.d = i;
        switch (i) {
            case 1:
                this.f = new Paint();
                this.e = wh0Var;
                this.g = context;
                break;
            default:
                this.f = new Paint();
                this.e = wh0Var;
                this.g = context;
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.th0
    public final void a(RecyclerView recyclerView, m91 m91Var) {
        switch (this.d) {
            case 0:
                super.a(recyclerView, m91Var);
                ((xh0) m91Var).b(this.g);
                break;
            default:
                super.a(recyclerView, m91Var);
                ((xh0) m91Var).b(this.g);
                break;
        }
    }

    @Override // defpackage.th0
    public final long f(RecyclerView recyclerView, int i) {
        switch (this.d) {
            case 0:
                if (i == 8) {
                }
                break;
            default:
                if (i == 8) {
                }
                break;
        }
        return 350L;
    }

    @Override // defpackage.th0
    public final float g() {
        switch (this.d) {
        }
        return 0.1f;
    }

    @Override // defpackage.th0
    public final int h(RecyclerView recyclerView, m91 m91Var) {
        switch (this.d) {
        }
        return th0.m(3, 32);
    }

    @Override // defpackage.th0
    public final float i() {
        switch (this.d) {
        }
        return 0.9f;
    }

    @Override // defpackage.th0
    public final boolean k() {
        switch (this.d) {
        }
        return true;
    }

    @Override // defpackage.th0
    public final boolean l() {
        switch (this.d) {
        }
        return false;
    }

    @Override // defpackage.th0
    public final void n(Canvas canvas, RecyclerView recyclerView, m91 m91Var, float f, float f2, int i, boolean z) {
        switch (this.d) {
            case 0:
                super.n(canvas, recyclerView, m91Var, f, f2, i, z);
                if (i == 1 && f > 0.0f) {
                    Context context = this.g;
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), l51.ic_add_circle);
                    Paint paint = this.f;
                    paint.setColor(np1.k(context, x41.green));
                    View view = m91Var.g;
                    canvas.drawRect(view.getLeft() + m90.h(0), view.getTop(), f + m90.h(0), view.getBottom(), paint);
                    canvas.drawBitmap(bitmapDecodeResource, view.getLeft() + m90.h(20), (((view.getBottom() - view.getTop()) - bitmapDecodeResource.getHeight()) / 2.0f) + view.getTop(), paint);
                    bitmapDecodeResource.recycle();
                    break;
                }
                break;
            default:
                super.n(canvas, recyclerView, m91Var, f, f2, i, z);
                if (i == 1 && f > 0.0f) {
                    Context context2 = this.g;
                    Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(context2.getResources(), l51.ic_delete_image);
                    Paint paint2 = this.f;
                    paint2.setColor(np1.k(context2, x41.red));
                    View view2 = m91Var.g;
                    canvas.drawRect(view2.getLeft() + m90.h(0), view2.getTop(), m90.h(0) + f, view2.getBottom(), paint2);
                    canvas.drawBitmap(bitmapDecodeResource2, view2.getLeft() + m90.h(20), (((view2.getBottom() - view2.getTop()) - bitmapDecodeResource2.getHeight()) / 2.0f) + view2.getTop(), paint2);
                    bitmapDecodeResource2.recycle();
                    break;
                }
                break;
        }
    }

    @Override // defpackage.th0
    public final void o(m91 m91Var) {
        switch (this.d) {
            case 0:
                View view = m91Var.g;
                break;
            default:
                View view2 = m91Var.g;
                break;
        }
    }

    @Override // defpackage.th0
    public final boolean q(RecyclerView recyclerView, m91 m91Var, m91 m91Var2) {
        switch (this.d) {
            case 0:
                if (m91Var.l == m91Var2.l) {
                    this.e.b(m91Var.e(), m91Var2.e());
                    break;
                }
                break;
            default:
                if (m91Var.l == m91Var2.l) {
                    this.e.b(m91Var.e(), m91Var2.e());
                    break;
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.th0
    public final void t(m91 m91Var, int i) {
        switch (this.d) {
            case 0:
                if (i != 0) {
                    ((xh0) m91Var).a(this.g);
                }
                break;
            default:
                if (i != 0) {
                    ((xh0) m91Var).a(this.g);
                }
                break;
        }
    }

    @Override // defpackage.th0
    public final void u(m91 m91Var, int i) {
        switch (this.d) {
            case 0:
                this.e.a(m91Var.e());
                break;
            default:
                this.e.a(m91Var.e());
                break;
        }
    }
}
