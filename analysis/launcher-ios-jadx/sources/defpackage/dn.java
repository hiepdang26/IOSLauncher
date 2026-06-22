package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public final class dn {
    public static final SparseIntArray o;
    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public float n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.append(j71.Transform_android_rotation, 1);
        sparseIntArray.append(j71.Transform_android_rotationX, 2);
        sparseIntArray.append(j71.Transform_android_rotationY, 3);
        sparseIntArray.append(j71.Transform_android_scaleX, 4);
        sparseIntArray.append(j71.Transform_android_scaleY, 5);
        sparseIntArray.append(j71.Transform_android_transformPivotX, 6);
        sparseIntArray.append(j71.Transform_android_transformPivotY, 7);
        sparseIntArray.append(j71.Transform_android_translationX, 8);
        sparseIntArray.append(j71.Transform_android_translationY, 9);
        sparseIntArray.append(j71.Transform_android_translationZ, 10);
        sparseIntArray.append(j71.Transform_android_elevation, 11);
        sparseIntArray.append(j71.Transform_transformPivotTarget, 12);
    }

    public final void a(dn dnVar) {
        this.a = dnVar.a;
        this.b = dnVar.b;
        this.c = dnVar.c;
        this.d = dnVar.d;
        this.e = dnVar.e;
        this.f = dnVar.f;
        this.g = dnVar.g;
        this.h = dnVar.h;
        this.i = dnVar.i;
        this.j = dnVar.j;
        this.k = dnVar.k;
        this.l = dnVar.l;
        this.m = dnVar.m;
        this.n = dnVar.n;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j71.Transform);
        this.a = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (o.get(index)) {
                case 1:
                    this.b = typedArrayObtainStyledAttributes.getFloat(index, this.b);
                    break;
                case 2:
                    this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                    break;
                case 3:
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 4:
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 5:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 6:
                    this.g = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                    break;
                case 7:
                    this.h = typedArrayObtainStyledAttributes.getDimension(index, this.h);
                    break;
                case 8:
                    this.j = typedArrayObtainStyledAttributes.getDimension(index, this.j);
                    break;
                case 9:
                    this.k = typedArrayObtainStyledAttributes.getDimension(index, this.k);
                    break;
                case 10:
                    this.l = typedArrayObtainStyledAttributes.getDimension(index, this.l);
                    break;
                case 11:
                    this.m = true;
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    break;
                case 12:
                    this.i = en.o(typedArrayObtainStyledAttributes, index, this.i);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
