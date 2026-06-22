package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class gb implements vt0 {
    private ut0 mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected gt0 mMenu;
    private int mMenuLayoutRes;
    protected yt0 mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public gb(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    public void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    @Override // defpackage.vt0
    public boolean collapseItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    public xt0 createItemView(ViewGroup viewGroup) {
        return (xt0) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    @Override // defpackage.vt0
    public boolean expandItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    public abstract boolean filterLeftoverView(ViewGroup viewGroup, int i);

    public ut0 getCallback() {
        return this.mCallback;
    }

    @Override // defpackage.vt0
    public int getId() {
        return this.mId;
    }

    public abstract View getItemView(mt0 mt0Var, View view, ViewGroup viewGroup);

    public yt0 getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            yt0 yt0Var = (yt0) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView = yt0Var;
            yt0Var.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    @Override // defpackage.vt0
    public void initForMenu(Context context, gt0 gt0Var) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = gt0Var;
    }

    @Override // defpackage.vt0
    public void onCloseMenu(gt0 gt0Var, boolean z) {
        ut0 ut0Var = this.mCallback;
        if (ut0Var != null) {
            ut0Var.onCloseMenu(gt0Var, z);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.vt0
    public boolean onSubMenuSelected(ik1 ik1Var) {
        ut0 ut0Var = this.mCallback;
        gt0 gt0Var = ik1Var;
        if (ut0Var == null) {
            return false;
        }
        if (ik1Var == null) {
            gt0Var = this.mMenu;
        }
        return ut0Var.onOpenSubMenu(gt0Var);
    }

    @Override // defpackage.vt0
    public void setCallback(ut0 ut0Var) {
        this.mCallback = ut0Var;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public abstract boolean shouldIncludeItem(int i, mt0 mt0Var);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.vt0
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return;
        }
        gt0 gt0Var = this.mMenu;
        int i = 0;
        if (gt0Var != null) {
            gt0Var.i();
            ArrayList arrayListL = this.mMenu.l();
            int size = arrayListL.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                mt0 mt0Var = (mt0) arrayListL.get(i3);
                if (shouldIncludeItem(i2, mt0Var)) {
                    View childAt = viewGroup.getChildAt(i2);
                    mt0 itemData = childAt instanceof xt0 ? ((xt0) childAt).getItemData() : null;
                    View itemView = getItemView(mt0Var, childAt, viewGroup);
                    if (mt0Var != itemData) {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    }
                    if (itemView != childAt) {
                        addItemView(itemView, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!filterLeftoverView(viewGroup, i)) {
                i++;
            }
        }
    }
}
