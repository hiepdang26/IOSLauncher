package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.t;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    public AppCompatTextClassifierHelper(TextView textView) {
        textView.getClass();
        this.mTextView = textView;
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier = this.mTextClassifier;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManagerG = t.g(this.mTextView.getContext().getSystemService(t.m()));
        return textClassificationManagerG != null ? textClassificationManagerG.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }
}
