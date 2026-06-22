package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ t g;

    public h(t tVar) {
        this.g = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar = this.g;
        tVar.mWorkspace.getClass();
        tVar.onClickSettingsButton(view);
    }
}
