package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ag0 extends FrameLayout.LayoutParams {
    public final boolean a;

    public ag0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        this.a = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public ag0(int i, int i2) {
        super(i, i2);
        this.a = false;
    }

    public ag0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = false;
    }
}
