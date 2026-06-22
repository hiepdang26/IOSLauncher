package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class gz0 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ gz0(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.onDown(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        switch (this.a) {
            case 0:
                hz0 hz0Var = (hz0) this.b;
                Objects.toString(hz0Var.l.getState());
                if (hz0Var.l.y()) {
                    float y = motionEvent2.getY() - motionEvent.getY();
                    if (Math.abs(hz0Var.g) > hz0Var.b && Math.abs(f2) > hz0Var.c && y > 0.0f) {
                        hz0Var.c(hz0Var.g, f2);
                        return true;
                    }
                    if (hz0Var.l.y() || hz0Var.l.x()) {
                        hz0Var.a(hz0Var.g);
                    }
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            default:
                OverScrollLayout overScrollLayout = (OverScrollLayout) this.b;
                if (!overScrollLayout.isOverScrollTop && !overScrollLayout.isOverScrollBottom && !overScrollLayout.isOverScrollLeft && !overScrollLayout.isOverScrollRight) {
                    m01 m01Var = overScrollLayout.flingRunnable;
                    m01Var.g = false;
                    OverScrollLayout overScrollLayout2 = m01Var.i;
                    if (overScrollLayout2.canOverScrollVertical) {
                        f = f2;
                    }
                    overScrollLayout2.flingScroller.fling(0, 0, 0, (int) (f * 3.0f), 0, 0, RtlSpacingHelper.UNDEFINED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    overScrollLayout2.postDelayed(m01Var, 10L);
                }
                return false;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        switch (this.a) {
            case 0:
                Objects.toString(motionEvent);
                Objects.toString(motionEvent2);
                hz0 hz0Var = (hz0) this.b;
                int i = hz0Var.b;
                boolean z = hz0Var.d;
                t tVar = hz0Var.k;
                SearchViewLayout searchViewLayout = hz0Var.l;
                if (z) {
                    float f3 = hz0Var.g + f2;
                    hz0Var.g = f3;
                    hz0Var.h += f2;
                    float fMin = Math.min(1.0f, (1.0f - Math.min(new AccelerateInterpolator(0.18f).getInterpolation(0.39f), 0.9f)) * Math.abs(f3 / hz0Var.e));
                    float fMin2 = (1.0f - Math.min(new AccelerateInterpolator(0.25f).getInterpolation(0.39f), 0.9f)) * hz0Var.h;
                    if (searchViewLayout.y()) {
                        searchViewLayout.getTranslationY();
                        searchViewLayout.getAlpha();
                        searchViewLayout.setAlpha(fMin);
                        searchViewLayout.setTranslationY(-fMin2);
                        if (!tVar.isRenderEffectSupport) {
                            tVar.showFolderBlurBackground(fMin);
                        } else {
                            hz0Var.d(fMin);
                        }
                    }
                } else if (Math.abs(f) <= Math.abs(f2)) {
                    float fAbs = Math.abs(f);
                    int i2 = hz0Var.b;
                    if (fAbs < i2 && Math.abs(f2) > i2 && f2 < 0.0f) {
                        hz0Var.d = true;
                        if (!tVar.isShaking() && !tVar.isWidgetsViewVisible()) {
                            if (!tVar.getDragController().f) {
                                Objects.toString(searchViewLayout.getState());
                                searchViewLayout.getTranslationY();
                                searchViewLayout.getAlpha();
                                if (searchViewLayout.g == xe1.i && !tVar.isOpeningFolder() && !tVar.isOpeningFloatingMenu() && !tVar.isOpeningAppsLibrary() && !tVar.isOpeningLeftPage()) {
                                    searchViewLayout.A();
                                }
                            } else {
                                tVar.getDragController().a();
                            }
                        }
                    }
                }
                break;
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }
}
