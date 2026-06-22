package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public final class rm {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public final en f;

    public rm(Context context, XmlResourceParser xmlResourceParser) {
        this.a = Float.NaN;
        this.b = Float.NaN;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), j71.Variant);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == j71.Variant_constraints) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                this.e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    en enVar = new en();
                    this.f = enVar;
                    enVar.f((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == j71.Variant_region_heightLessThan) {
                this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
            } else if (index == j71.Variant_region_heightMoreThan) {
                this.b = typedArrayObtainStyledAttributes.getDimension(index, this.b);
            } else if (index == j71.Variant_region_widthLessThan) {
                this.c = typedArrayObtainStyledAttributes.getDimension(index, this.c);
            } else if (index == j71.Variant_region_widthMoreThan) {
                this.a = typedArrayObtainStyledAttributes.getDimension(index, this.a);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean a(float f, float f2) {
        float f3 = this.a;
        if (!Float.isNaN(f3) && f < f3) {
            return false;
        }
        float f4 = this.b;
        if (!Float.isNaN(f4) && f2 < f4) {
            return false;
        }
        float f5 = this.c;
        if (!Float.isNaN(f5) && f > f5) {
            return false;
        }
        float f6 = this.d;
        return Float.isNaN(f6) || f2 <= f6;
    }
}
