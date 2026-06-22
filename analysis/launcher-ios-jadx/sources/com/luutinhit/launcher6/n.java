package com.luutinhit.launcher6;

import android.content.DialogInterface;
import android.os.HandlerThread;
import defpackage.jq1;
import defpackage.rl0;
import defpackage.tu;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ String g;
    public final /* synthetic */ t h;

    public n(t tVar, String str) {
        this.h = tVar;
        this.g = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        jq1 jq1VarB = jq1.b();
        Workspace workspace = this.h.mWorkspace;
        workspace.getClass();
        Objects.toString(jq1VarB);
        HashSet hashSet = new HashSet(1);
        String str = this.g;
        hashSet.add(str);
        t tVar = workspace.S0;
        HandlerThread handlerThread = rl0.w;
        Objects.toString(tVar);
        Objects.toString(jq1VarB);
        Objects.toString(jq1VarB);
        rl0.f(tVar, rl0.h(rl0.B, new tu(str, jq1VarB, 5, false)));
        workspace.Y0(hashSet, jq1VarB);
    }
}
