package defpackage;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class er1 extends fr1 {
    public final Matrix a;
    public final ArrayList b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final Matrix j;
    public String k;

    public er1() {
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Matrix();
        this.k = null;
    }

    @Override // defpackage.fr1
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((fr1) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // defpackage.fr1
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((fr1) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.j;
        matrix.reset();
        matrix.postTranslate(-this.d, -this.e);
        matrix.postScale(this.f, this.g);
        matrix.postRotate(this.c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.d, this.i + this.e);
    }

    public String getGroupName() {
        return this.k;
    }

    public Matrix getLocalMatrix() {
        return this.j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.h) {
            this.h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public er1(er1 er1Var, e9 e9Var) {
        gr1 cr1Var;
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.j = matrix;
        this.k = null;
        this.c = er1Var.c;
        this.d = er1Var.d;
        this.e = er1Var.e;
        this.f = er1Var.f;
        this.g = er1Var.g;
        this.h = er1Var.h;
        this.i = er1Var.i;
        String str = er1Var.k;
        this.k = str;
        if (str != null) {
            e9Var.put(str, this);
        }
        matrix.set(er1Var.j);
        ArrayList arrayList = er1Var.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof er1) {
                this.b.add(new er1((er1) obj, e9Var));
            } else {
                if (obj instanceof dr1) {
                    dr1 dr1Var = (dr1) obj;
                    dr1 dr1Var2 = new dr1(dr1Var);
                    dr1Var2.e = 0.0f;
                    dr1Var2.g = 1.0f;
                    dr1Var2.h = 1.0f;
                    dr1Var2.i = 0.0f;
                    dr1Var2.j = 1.0f;
                    dr1Var2.k = 0.0f;
                    dr1Var2.l = Paint.Cap.BUTT;
                    dr1Var2.m = Paint.Join.MITER;
                    dr1Var2.n = 4.0f;
                    dr1Var2.d = dr1Var.d;
                    dr1Var2.e = dr1Var.e;
                    dr1Var2.g = dr1Var.g;
                    dr1Var2.f = dr1Var.f;
                    dr1Var2.c = dr1Var.c;
                    dr1Var2.h = dr1Var.h;
                    dr1Var2.i = dr1Var.i;
                    dr1Var2.j = dr1Var.j;
                    dr1Var2.k = dr1Var.k;
                    dr1Var2.l = dr1Var.l;
                    dr1Var2.m = dr1Var.m;
                    dr1Var2.n = dr1Var.n;
                    cr1Var = dr1Var2;
                } else if (obj instanceof cr1) {
                    cr1Var = new cr1((cr1) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.b.add(cr1Var);
                Object obj2 = cr1Var.b;
                if (obj2 != null) {
                    e9Var.put(obj2, cr1Var);
                }
            }
        }
    }
}
