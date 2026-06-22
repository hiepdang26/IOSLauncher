package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import com.luutinhit.launcherios.activity.StatusBarAndNotificationActivity;

/* JADX INFO: loaded from: classes.dex */
public final class lj1 implements View.OnClickListener {
    public final /* synthetic */ StatusBarAndNotificationActivity g;

    public lj1(StatusBarAndNotificationActivity statusBarAndNotificationActivity) {
        this.g = statusBarAndNotificationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatusBarAndNotificationActivity statusBarAndNotificationActivity = this.g;
        boolean zIsChecked = statusBarAndNotificationActivity.D.isChecked();
        statusBarAndNotificationActivity.getClass();
        try {
            SharedPreferences.Editor editorEdit = statusBarAndNotificationActivity.E.edit();
            editorEdit.putBoolean("hide_navigation", zIsChecked);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
        ar1.z(statusBarAndNotificationActivity);
    }
}
