package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import defpackage.an;
import defpackage.j71;
import defpackage.jn;
import defpackage.kn;
import defpackage.nm;
import defpackage.sa;
import defpackage.zb0;
import defpackage.zm;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends a {
    public int g;
    public int h;
    public sa i;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public final void f(jn jnVar, int i, boolean z) {
        this.h = i;
        if (z) {
            int i2 = this.g;
            if (i2 == 5) {
                this.h = 1;
            } else if (i2 == 6) {
                this.h = 0;
            }
        } else {
            int i3 = this.g;
            if (i3 == 5) {
                this.h = 0;
            } else if (i3 == 6) {
                this.h = 1;
            }
        }
        if (jnVar instanceof sa) {
            ((sa) jnVar).v0 = this.h;
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.i.w0;
    }

    public int getMargin() {
        return this.i.x0;
    }

    public int getType() {
        return this.g;
    }

    @Override // androidx.constraintlayout.widget.a
    public final void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.i = new sa();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j71.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == j71.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == j71.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.i.w0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == j71.ConstraintLayout_Layout_barrierMargin) {
                    this.i.x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.i;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.a
    public final void loadParameters(zm zmVar, zb0 zb0Var, nm nmVar, SparseArray sparseArray) {
        super.loadParameters(zmVar, zb0Var, nmVar, sparseArray);
        if (zb0Var instanceof sa) {
            sa saVar = (sa) zb0Var;
            f(saVar, zmVar.e.g0, ((kn) zb0Var.U).y0);
            an anVar = zmVar.e;
            saVar.w0 = anVar.o0;
            saVar.x0 = anVar.h0;
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public final void resolveRtl(jn jnVar, boolean z) {
        f(jnVar, this.g, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.i.w0 = z;
    }

    public void setDpMargin(int i) {
        this.i.x0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.i.x0 = i;
    }

    public void setType(int i) {
        this.g = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
