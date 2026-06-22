package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.o71;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceImageView extends ImageView {
    public int g;
    public int h;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.PreferenceImageView, 0, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(o71.PreferenceImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(o71.PreferenceImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.h;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.g;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i = View.MeasureSpec.makeMeasureSpec(maxWidth, RtlSpacingHelper.UNDEFINED);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i2);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i2 = View.MeasureSpec.makeMeasureSpec(maxHeight, RtlSpacingHelper.UNDEFINED);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i) {
        this.h = i;
        super.setMaxHeight(i);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i) {
        this.g = i;
        super.setMaxWidth(i);
    }
}
