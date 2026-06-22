package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class l80 extends Drawable implements q80, Animatable {
    public final j5 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int l;
    public boolean n;
    public Paint o;
    public Rect p;
    public boolean k = true;
    public final int m = -1;

    public l80(j5 j5Var) {
        this.g = j5Var;
    }

    public final void a() {
        n90.e("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.j);
        r80 r80Var = (r80) this.g.b;
        if (r80Var.a.l.c == 1) {
            invalidateSelf();
            return;
        }
        if (this.h) {
            return;
        }
        this.h = true;
        if (r80Var.j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        ArrayList arrayList = r80Var.c;
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !r80Var.f) {
            r80Var.f = true;
            r80Var.j = false;
            r80Var.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.j) {
            return;
        }
        if (this.n) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.p == null) {
                this.p = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.p);
            this.n = false;
        }
        r80 r80Var = (r80) this.g.b;
        p80 p80Var = r80Var.i;
        Bitmap bitmap = p80Var != null ? p80Var.m : r80Var.l;
        if (this.p == null) {
            this.p = new Rect();
        }
        Rect rect = this.p;
        if (this.o == null) {
            this.o = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.o);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((r80) this.g.b).p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((r80) this.g.b).o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.o == null) {
            this.o = new Paint(2);
        }
        this.o.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.o == null) {
            this.o = new Paint(2);
        }
        this.o.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        n90.e("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.j);
        this.k = z;
        if (!z) {
            this.h = false;
            r80 r80Var = (r80) this.g.b;
            ArrayList arrayList = r80Var.c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                r80Var.f = false;
            }
        } else if (this.i) {
            a();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.i = true;
        this.l = 0;
        if (this.k) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.i = false;
        this.h = false;
        r80 r80Var = (r80) this.g.b;
        ArrayList arrayList = r80Var.c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            r80Var.f = false;
        }
    }
}
