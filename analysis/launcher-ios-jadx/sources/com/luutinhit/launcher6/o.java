package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {
    public final /* synthetic */ CellLayout g;
    public final /* synthetic */ FolderIcon h;
    public final /* synthetic */ t i;

    public o(t tVar, CellLayout cellLayout, FolderIcon folderIcon) {
        this.i = tVar;
        this.g = cellLayout;
        this.h = folderIcon;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        CellLayout cellLayout = this.g;
        if (cellLayout != null) {
            int[] iArr = cellLayout.x;
            iArr[0] = -1;
            iArr[1] = -1;
            cellLayout.invalidate();
            t tVar = this.i;
            tVar.mDragLayer.removeView(tVar.mFolderIconImageView);
            this.h.setVisibility(0);
        }
    }
}
