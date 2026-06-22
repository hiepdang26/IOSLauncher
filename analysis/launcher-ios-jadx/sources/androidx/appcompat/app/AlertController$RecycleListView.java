package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import defpackage.q71;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {
    public final int g;
    public final int h;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q71.RecycleListView);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(q71.RecycleListView_paddingBottomNoButtons, -1);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(q71.RecycleListView_paddingTopNoTitle, -1);
    }
}
