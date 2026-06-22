package defpackage;

import android.content.Intent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public final class uo0 implements xl1 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ uo0(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.wl1
    public final void a(bm1 bm1Var) {
        switch (this.a) {
            case 0:
                if (bm1Var.d == 1) {
                    Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent.setType("image/*");
                    intent.addCategory("android.intent.category.OPENABLE");
                    ((wo0) this.b).startActivityForResult(intent, 0);
                }
                break;
        }
    }

    @Override // defpackage.wl1
    public final void b(bm1 bm1Var) {
        switch (this.a) {
            case 0:
                int i = bm1Var.d;
                wo0 wo0Var = (wo0) this.b;
                if (i != 1) {
                    wo0Var.a0.putInt("default_picture", 0);
                    wo0Var.a0.apply();
                    wo0Var.Z = 0;
                } else {
                    Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent.setType("image/*");
                    intent.addCategory("android.intent.category.OPENABLE");
                    wo0Var.startActivityForResult(intent, 0);
                }
                break;
            default:
                ((ViewPager) this.b).setCurrentItem(bm1Var.d);
                break;
        }
    }

    private final void c(bm1 bm1Var) {
    }
}
