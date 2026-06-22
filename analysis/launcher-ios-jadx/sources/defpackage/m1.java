package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class m1 {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private k1 mSubUiVisibilityListener;
    private l1 mVisibilityListener;

    public m1(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public abstract boolean hasSubMenu();

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public abstract void onPrepareSubMenu(SubMenu subMenu);

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        l1 l1Var = this.mVisibilityListener;
        isVisible();
        gt0 gt0Var = ((mt0) ((nx0) l1Var).h).t;
        gt0Var.n = true;
        gt0Var.p(true);
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(k1 k1Var) {
        this.mSubUiVisibilityListener = k1Var;
    }

    public void setVisibilityListener(l1 l1Var) {
        this.mVisibilityListener = l1Var;
    }

    public void subUiVisibilityChanged(boolean z) {
        k1 k1Var = this.mSubUiVisibilityListener;
        if (k1Var != null) {
            k1Var.onSubUiVisibilityChanged(z);
        }
    }
}
