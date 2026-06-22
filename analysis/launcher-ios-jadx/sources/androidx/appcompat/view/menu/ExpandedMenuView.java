package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;
import defpackage.ft0;
import defpackage.gt0;
import defpackage.mt0;
import defpackage.yt0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements ft0, yt0, AdapterView.OnItemClickListener {
    public static final int[] h = {R.attr.background, R.attr.divider};
    public gt0 g;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, h, R.attr.listViewStyle, 0);
        if (tintTypedArrayObtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            setDivider(tintTypedArrayObtainStyledAttributes.getDrawable(1));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // defpackage.yt0
    public final void initialize(gt0 gt0Var) {
        this.g = gt0Var;
    }

    @Override // defpackage.ft0
    public final boolean invokeItem(mt0 mt0Var) {
        return this.g.q(mt0Var, null, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((mt0) getAdapter().getItem(i));
    }
}
