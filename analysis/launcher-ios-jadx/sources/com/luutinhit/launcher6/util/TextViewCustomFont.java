package com.luutinhit.launcher6.util;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.wc;

/* JADX INFO: loaded from: classes.dex */
public class TextViewCustomFont extends AppCompatTextView {
    public static final /* synthetic */ int g = 0;

    public TextViewCustomFont(Context context) {
        super(context);
        post(new wc(this, null, 18));
    }

    public TextViewCustomFont(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        post(new wc(this, attributeSet, 18));
    }
}
