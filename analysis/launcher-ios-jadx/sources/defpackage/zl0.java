package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.CustomIconView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zl0 {
    public t a;
    public AppCompatImageView b;
    public int[] c;
    public ObjectAnimator d;

    public final void a(CustomIconView customIconView, Bitmap bitmap) {
        Objects.toString(customIconView);
        Objects.toString(bitmap);
        if (customIconView == null || bitmap == null) {
            return;
        }
        AppCompatImageView appCompatImageView = this.b;
        t tVar = this.a;
        if (appCompatImageView == null) {
            if (appCompatImageView == null) {
                ViewStub viewStub = (ViewStub) tVar.findViewById(v51.stub_expanded_image_anim);
                if (viewStub != null) {
                    this.b = (AppCompatImageView) viewStub.inflate().findViewById(v51.expanded_image_anim);
                } else {
                    this.b = (AppCompatImageView) tVar.findViewById(v51.expanded_image_anim);
                }
            }
            AppCompatImageView appCompatImageView2 = this.b;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
                this.b.setClickable(false);
                this.b.setFocusable(false);
            }
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(tVar.getResources(), bitmap);
        this.b.setVisibility(4);
        this.b.setBackground(bitmapDrawable);
        this.b.setScaleX(5.0f);
        this.b.setScaleY(5.0f);
        DragLayer dragLayer = tVar.getDragLayer();
        int[] iArr = this.c;
        dragLayer.getLocationInDragLayer(customIconView, iArr);
        pw pwVar = new pw(-2, -2);
        ((FrameLayout.LayoutParams) pwVar).leftMargin = iArr[0];
        ((FrameLayout.LayoutParams) pwVar).topMargin = iArr[1];
        try {
            tVar.getDragLayer().updateViewLayout(this.b, pwVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(ak0 ak0Var, d02 d02Var, d02 d02Var2, Runnable runnable) {
        Objects.toString(ak0Var);
        Objects.toString(d02Var);
        Objects.toString(d02Var2);
        Objects.toString(runnable);
        if (ak0Var == ak0.i || ak0Var == ak0.j) {
            return;
        }
        Objects.toString(d02Var);
        Objects.toString(d02Var2);
        Objects.toString(runnable);
        this.a.closeWidgetView(true);
    }
}
