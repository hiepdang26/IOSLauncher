package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.LauncherRootView;
import com.luutinhit.launcher6.t;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class e8 extends b70 {
    public final t k;
    public final RecyclerView l;
    public final b8 m;

    public e8(Context context) {
        super(context);
        setId(v51.apps_library_folder_expand);
        setX(0.0f);
        setY(0.0f);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        t tVar = (t) context;
        this.k = tVar;
        ag0 ag0Var = new ag0(tVar.screenWidth, tVar.screenHeight);
        ((FrameLayout.LayoutParams) ag0Var).gravity = 1;
        setLayoutParams(ag0Var);
        RecyclerView recyclerView = new RecyclerView(context, null);
        this.l = recyclerView;
        int i = tVar.getDeviceProfile().C;
        setPadding(i, 0, i, 0);
        ag0 ag0Var2 = new ag0(tVar.screenWidth - (i * 2), -2);
        ((FrameLayout.LayoutParams) ag0Var2).gravity = 17;
        addView(recyclerView, ag0Var2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        gridLayoutManager.K = new c8(this, gridLayoutManager, 0);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setOverScrollMode(2);
        b8 b8Var = new b8(tVar);
        this.m = b8Var;
        recyclerView.setAdapter(b8Var);
        b8Var.n = this;
    }

    public final void a() {
        int i = 1;
        if (getParent() instanceof LauncherRootView) {
            ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.3f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.3f));
            objectAnimatorD.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
            objectAnimatorD.addListener(new d8(this, i));
            objectAnimatorD.setDuration(368L);
            setLayerType(2, null);
            objectAnimatorD.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (keyEvent == null || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        a();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView;
        Objects.toString(motionEvent);
        if (motionEvent.getAction() == 0 && (recyclerView = this.l) != null) {
            Rect rect = new Rect();
            recyclerView.getGlobalVisibleRect(rect);
            if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
