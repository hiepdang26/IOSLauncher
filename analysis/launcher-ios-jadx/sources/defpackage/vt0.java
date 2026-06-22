package defpackage;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface vt0 {
    boolean collapseItemActionView(gt0 gt0Var, mt0 mt0Var);

    boolean expandItemActionView(gt0 gt0Var, mt0 mt0Var);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, gt0 gt0Var);

    void onCloseMenu(gt0 gt0Var, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(ik1 ik1Var);

    void setCallback(ut0 ut0Var);

    void updateMenuView(boolean z);
}
