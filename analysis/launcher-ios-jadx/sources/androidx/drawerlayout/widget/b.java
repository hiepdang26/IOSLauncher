package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class b extends ViewGroup.MarginLayoutParams {
    public int a;
    public float b;
    public boolean c;
    public int d;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
        this.a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public b(int i, int i2) {
        super(i, i2);
        this.a = 0;
    }

    public b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 0;
    }
}
