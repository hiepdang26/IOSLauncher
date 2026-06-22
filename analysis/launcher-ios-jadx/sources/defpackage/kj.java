package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class kj extends View {
    public final float g;

    public kj(Context context) {
        super(context);
        new Paint(2).setColor(-16777216);
        this.g = getResources().getDimension(e51.blur_size_click_shadow);
        getResources().getDimension(e51.click_shadow_high_shift);
    }

    public int getExtraSize() {
        return (int) (this.g * 3.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}
