package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ux1 extends bf1 implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final AccelerateInterpolator U = new AccelerateInterpolator();
    public static final DecelerateInterpolator V = new DecelerateInterpolator();
    public ActionBarContextView A;
    public final View B;
    public boolean C;
    public tx1 D;
    public tx1 E;
    public tu F;
    public boolean G;
    public final ArrayList H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public bu1 O;
    public boolean P;
    public boolean Q;
    public final sx1 R;
    public final sx1 S;
    public final iw1 T;
    public Context v;
    public Context w;
    public ActionBarOverlayLayout x;
    public ActionBarContainer y;
    public DecorToolbar z;

    public ux1(Dialog dialog) {
        new ArrayList();
        this.H = new ArrayList();
        this.J = 0;
        this.K = true;
        this.N = true;
        this.R = new sx1(this, 0);
        this.S = new sx1(this, 1);
        this.T = new iw1(this);
        G(dialog.getWindow().getDecorView());
    }

    public final void E(boolean z) {
        zt1 zt1Var;
        zt1 zt1Var2;
        if (z) {
            if (!this.M) {
                this.M = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.x;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                J(false);
            }
        } else if (this.M) {
            this.M = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.x;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            J(false);
        }
        ActionBarContainer actionBarContainer = this.y;
        WeakHashMap weakHashMap = qs1.a;
        if (!actionBarContainer.isLaidOut()) {
            if (z) {
                this.z.setVisibility(4);
                this.A.setVisibility(0);
                return;
            } else {
                this.z.setVisibility(0);
                this.A.setVisibility(8);
                return;
            }
        }
        if (z) {
            zt1Var2 = this.z.setupAnimatorToVisibility(4, 100L);
            zt1Var = this.A.setupAnimatorToVisibility(0, 200L);
        } else {
            zt1Var = this.z.setupAnimatorToVisibility(0, 200L);
            zt1Var2 = this.A.setupAnimatorToVisibility(8, 100L);
        }
        bu1 bu1Var = new bu1();
        ArrayList arrayList = bu1Var.a;
        arrayList.add(zt1Var2);
        View view = (View) zt1Var2.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) zt1Var.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(zt1Var);
        bu1Var.b();
    }

    public final Context F() {
        if (this.w == null) {
            TypedValue typedValue = new TypedValue();
            this.v.getTheme().resolveAttribute(r41.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.w = new ContextThemeWrapper(this.v, i);
            } else {
                this.w = this.v;
            }
        }
        return this.w;
    }

    public final void G(View view) {
        DecorToolbar wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(w51.decor_content_parent);
        this.x = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(w51.action_bar);
        if (callbackFindViewById instanceof DecorToolbar) {
            wrapper = (DecorToolbar) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.z = wrapper;
        this.A = (ActionBarContextView) view.findViewById(w51.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(w51.action_bar_container);
        this.y = actionBarContainer;
        DecorToolbar decorToolbar = this.z;
        if (decorToolbar == null || this.A == null || actionBarContainer == null) {
            throw new IllegalStateException(ux1.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        this.v = decorToolbar.getContext();
        boolean z = (this.z.getDisplayOptions() & 4) != 0;
        if (z) {
            this.C = true;
        }
        f1 f1VarD = f1.d(this.v);
        this.z.setHomeButtonEnabled(f1VarD.h.getApplicationInfo().targetSdkVersion < 14 || z);
        I(f1VarD.h.getResources().getBoolean(u41.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.v.obtainStyledAttributes(null, q71.ActionBar, r41.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(q71.ActionBar_hideOnContentScroll, false)) {
            if (!this.x.isInOverlayMode()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.Q = true;
            this.x.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(q71.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.y;
            WeakHashMap weakHashMap = qs1.a;
            hs1.l(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void H(boolean z) {
        if (this.C) {
            return;
        }
        int i = z ? 4 : 0;
        int displayOptions = this.z.getDisplayOptions();
        this.C = true;
        this.z.setDisplayOptions((i & 4) | (displayOptions & (-5)));
    }

    public final void I(boolean z) {
        this.I = z;
        if (z) {
            this.y.setTabContainer(null);
            this.z.setEmbeddedTabView(null);
        } else {
            this.z.setEmbeddedTabView(null);
            this.y.setTabContainer(null);
        }
        boolean z2 = false;
        boolean z3 = this.z.getNavigationMode() == 2;
        this.z.setCollapsible(!this.I && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.x;
        if (!this.I && z3) {
            z2 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    public final void J(boolean z) {
        boolean z2 = this.M || !this.L;
        View view = this.B;
        final iw1 iw1Var = this.T;
        if (!z2) {
            if (this.N) {
                this.N = false;
                bu1 bu1Var = this.O;
                if (bu1Var != null) {
                    bu1Var.a();
                }
                int i = this.J;
                sx1 sx1Var = this.R;
                if (i != 0 || (!this.P && !z)) {
                    sx1Var.onAnimationEnd(null);
                    return;
                }
                this.y.setAlpha(1.0f);
                this.y.setTransitioning(true);
                bu1 bu1Var2 = new bu1();
                float f = -this.y.getHeight();
                if (z) {
                    this.y.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                zt1 zt1VarA = qs1.a(this.y);
                zt1VarA.f(f);
                final View view2 = (View) zt1VarA.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(iw1Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: yt1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((ux1) iw1Var.g).y.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z3 = bu1Var2.e;
                ArrayList arrayList = bu1Var2.a;
                if (!z3) {
                    arrayList.add(zt1VarA);
                }
                if (this.K && view != null) {
                    zt1 zt1VarA2 = qs1.a(view);
                    zt1VarA2.f(f);
                    if (!bu1Var2.e) {
                        arrayList.add(zt1VarA2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = U;
                boolean z4 = bu1Var2.e;
                if (!z4) {
                    bu1Var2.c = accelerateInterpolator;
                }
                if (!z4) {
                    bu1Var2.b = 250L;
                }
                if (!z4) {
                    bu1Var2.d = sx1Var;
                }
                this.O = bu1Var2;
                bu1Var2.b();
                return;
            }
            return;
        }
        if (this.N) {
            return;
        }
        this.N = true;
        bu1 bu1Var3 = this.O;
        if (bu1Var3 != null) {
            bu1Var3.a();
        }
        this.y.setVisibility(0);
        int i2 = this.J;
        sx1 sx1Var2 = this.S;
        if (i2 == 0 && (this.P || z)) {
            this.y.setTranslationY(0.0f);
            float f2 = -this.y.getHeight();
            if (z) {
                this.y.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.y.setTranslationY(f2);
            bu1 bu1Var4 = new bu1();
            zt1 zt1VarA3 = qs1.a(this.y);
            zt1VarA3.f(0.0f);
            final View view3 = (View) zt1VarA3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(iw1Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: yt1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((ux1) iw1Var.g).y.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z5 = bu1Var4.e;
            ArrayList arrayList2 = bu1Var4.a;
            if (!z5) {
                arrayList2.add(zt1VarA3);
            }
            if (this.K && view != null) {
                view.setTranslationY(f2);
                zt1 zt1VarA4 = qs1.a(view);
                zt1VarA4.f(0.0f);
                if (!bu1Var4.e) {
                    arrayList2.add(zt1VarA4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = V;
            boolean z6 = bu1Var4.e;
            if (!z6) {
                bu1Var4.c = decelerateInterpolator;
            }
            if (!z6) {
                bu1Var4.b = 250L;
            }
            if (!z6) {
                bu1Var4.d = sx1Var2;
            }
            this.O = bu1Var4;
            bu1Var4.b();
        } else {
            this.y.setAlpha(1.0f);
            this.y.setTranslationY(0.0f);
            if (this.K && view != null) {
                view.setTranslationY(0.0f);
            }
            sx1Var2.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.x;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = qs1.a;
            fs1.c(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void enableContentAnimations(boolean z) {
        this.K = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void hideForSystem() {
        if (this.L) {
            return;
        }
        this.L = true;
        J(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void onContentScrollStarted() {
        bu1 bu1Var = this.O;
        if (bu1Var != null) {
            bu1Var.a();
            this.O = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void onWindowVisibilityChanged(int i) {
        this.J = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void showForSystem() {
        if (this.L) {
            this.L = false;
            J(true);
        }
    }

    public ux1(boolean z, Activity activity) {
        new ArrayList();
        this.H = new ArrayList();
        this.J = 0;
        this.K = true;
        this.N = true;
        this.R = new sx1(this, 0);
        this.S = new sx1(this, 1);
        this.T = new iw1(this);
        View decorView = activity.getWindow().getDecorView();
        G(decorView);
        if (z) {
            return;
        }
        this.B = decorView.findViewById(R.id.content);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void onContentScrollStopped() {
    }
}
