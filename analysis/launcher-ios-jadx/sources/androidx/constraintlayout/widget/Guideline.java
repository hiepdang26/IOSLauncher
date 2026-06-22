package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import defpackage.nm;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    public boolean g;

    public Guideline(Context context) {
        super(context);
        this.g = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.g = z;
    }

    public void setGuidelineBegin(int i) {
        nm nmVar = (nm) getLayoutParams();
        if (this.g && nmVar.a == i) {
            return;
        }
        nmVar.a = i;
        setLayoutParams(nmVar);
    }

    public void setGuidelineEnd(int i) {
        nm nmVar = (nm) getLayoutParams();
        if (this.g && nmVar.b == i) {
            return;
        }
        nmVar.b = i;
        setLayoutParams(nmVar);
    }

    public void setGuidelinePercent(float f) {
        nm nmVar = (nm) getLayoutParams();
        if (this.g && nmVar.c == f) {
            return;
        }
        nmVar.c = f;
        setLayoutParams(nmVar);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = true;
        super.setVisibility(8);
    }
}
