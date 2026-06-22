package com.luutinhit.launcher6.appslibrary;

import android.content.Context;
import android.util.AttributeSet;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;
import defpackage.e8;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryBubbleTextView extends BubbleTextView {
    public final t G;
    public final e8 H;

    public AppsLibraryBubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (context instanceof t) {
            this.G = (t) context;
        }
        this.H = new e8(context);
    }
}
