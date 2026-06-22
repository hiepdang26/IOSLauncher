package defpackage;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class qo implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ qo(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.g) {
            case 0:
                ((CoordinatorLayout) this.h).i(0);
                break;
            case 1:
                o30 o30Var = (o30) this.h;
                float rotation = o30Var.s.getRotation();
                if (o30Var.o != rotation) {
                    o30Var.o = rotation;
                    o30Var.p();
                }
                break;
            default:
                Log.isLoggable("ViewTarget", 2);
                ju1 ju1Var = (ju1) ((WeakReference) this.h).get();
                if (ju1Var != null) {
                    ArrayList arrayList = ju1Var.b;
                    if (!arrayList.isEmpty()) {
                        ImageView imageView = ju1Var.a;
                        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int i = 0;
                        int iA = ju1Var.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                        int iA2 = ju1Var.a(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (iA > 0 || iA == Integer.MIN_VALUE) {
                            if (iA2 > 0 || iA2 == Integer.MIN_VALUE) {
                                ArrayList arrayList2 = new ArrayList(arrayList);
                                int size = arrayList2.size();
                                while (i < size) {
                                    Object obj = arrayList2.get(i);
                                    i++;
                                    ((yg1) ((mh1) obj)).i(iA, iA2);
                                }
                                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(ju1Var.c);
                                }
                                ju1Var.c = null;
                                arrayList.clear();
                            }
                        }
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public qo(ju1 ju1Var) {
        this.g = 2;
        this.h = new WeakReference(ju1Var);
    }
}
