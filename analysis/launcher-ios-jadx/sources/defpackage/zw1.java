package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WidgetImageView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zw1 extends LinearLayout implements View.OnLayoutChangeListener {
    public int g;
    public int h;
    public final int i;
    public WidgetImageView j;
    public TextView k;
    public TextView l;
    public final String m;
    public Parcelable n;
    public gx1 o;
    public m21 p;
    public final jd q;
    public final t r;

    public zw1(Context context) {
        LinearLayout.LayoutParams layoutParams;
        super(context, null, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, g71.WidgetCell, 0, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(g71.WidgetCell_hideWidgetText, false);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(m61.widget_cell, (ViewGroup) this, true);
        this.j = (WidgetImageView) findViewById(v51.widget_preview);
        this.k = (TextView) findViewById(v51.widget_name);
        this.l = (TextView) findViewById(v51.widget_dims);
        if (z) {
            findViewById(v51.widget_text).setVisibility(8);
        }
        Resources resources = context.getResources();
        t tVar = (t) context;
        this.r = tVar;
        this.q = new jd(this);
        this.m = resources.getString(w61.widget_dims_format);
        this.i = (int) (tVar.getDeviceProfile().H * 2.6f);
        if (getId() == v51.widget_full_preview_item) {
            int i = (int) (this.i * 0.8f);
            this.h = i;
            this.g = i * 2;
        } else {
            int i2 = (int) (this.i * 0.8f);
            this.h = i2;
            this.g = i2;
        }
        setWillNotDraw(false);
        setClipToPadding(false);
        setAccessibilityDelegate(jk0.a().f);
        if (getId() == v51.widget_full_preview_item) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
        } else {
            int i3 = this.i;
            layoutParams = new LinearLayout.LayoutParams(i3, i3);
        }
        int i4 = z ? 0 : tVar.getDeviceProfile().C;
        layoutParams.rightMargin = i4;
        layoutParams.leftMargin = i4;
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setOrientation(1);
        setFocusable(true);
    }

    private String getTagToString() {
        return ((getTag() instanceof w11) || (getTag() instanceof v11)) ? getTag().toString() : "";
    }

    public final void a() {
        fx1 fx1Var;
        if (this.p != null) {
            return;
        }
        int[] previewSize = getPreviewSize();
        String.format("[tag=%s] ensurePreview (%d, %d):", getTagToString(), Integer.valueOf(previewSize[0]), Integer.valueOf(previewSize[1]));
        gx1 gx1Var = this.o;
        Parcelable parcelable = this.n;
        int i = previewSize[0];
        int i2 = previewSize[1];
        gx1Var.getClass();
        Objects.toString(parcelable);
        Objects.toString(this);
        String str = i + "x" + i2;
        Objects.toString(parcelable);
        if (parcelable instanceof rk0) {
            rk0 rk0Var = (rk0) parcelable;
            fx1Var = new fx1(((AppWidgetProviderInfo) rk0Var).provider, gx1Var.f.h(rk0Var), str);
        } else {
            ActivityInfo activityInfo = ((ResolveInfo) parcelable).activityInfo;
            fx1Var = new fx1(new ComponentName(activityInfo.packageName, activityInfo.name), jq1.b(), str);
        }
        new ex1(gx1Var, fx1Var, parcelable, i, i2, this).executeOnExecutor(ar1.q, new Void[0]);
        this.p = new m21();
    }

    public int getActualItemWidth() {
        qh0 qh0Var = (qh0) getTag();
        return Math.min(getPreviewSize()[0], qh0Var.m * this.r.getDeviceProfile().H);
    }

    public int[] getPreviewSize() {
        return new int[]{this.g, this.h};
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.j = (WidgetImageView) findViewById(v51.widget_preview);
        this.k = (TextView) findViewById(v51.widget_name);
        this.l = (TextView) findViewById(v51.widget_dims);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getId() == v51.widget_full_preview_item) {
            this.g = getWidth();
            this.h = getHeight();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        removeOnLayoutChangeListener(this);
        a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.q.a(motionEvent)) {
            return true;
        }
        return zOnTouchEvent;
    }
}
