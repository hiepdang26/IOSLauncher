package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class s21 implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
    public final Preference g;

    public s21(Preference preference) {
        this.g = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.g;
        CharSequence charSequenceE = preference.e();
        if (!preference.H || TextUtils.isEmpty(charSequenceE)) {
            return;
        }
        contextMenu.setHeaderTitle(charSequenceE);
        contextMenu.add(0, 0, 0, r61.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.g;
        ClipboardManager clipboardManager = (ClipboardManager) preference.g.getSystemService("clipboard");
        CharSequence charSequenceE = preference.e();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceE));
        Context context = preference.g;
        Toast.makeText(context, context.getString(r61.preference_copied, charSequenceE), 0).show();
        return true;
    }
}
