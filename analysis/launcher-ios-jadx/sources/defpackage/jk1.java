package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface jk1 {
    int priority() default 0;

    boolean sticky() default false;

    ThreadMode threadMode() default ThreadMode.POSTING;
}
