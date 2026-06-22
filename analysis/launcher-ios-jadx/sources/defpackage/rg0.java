package defpackage;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperService;

/* JADX INFO: loaded from: classes.dex */
public final class rg0 implements View.OnClickListener {
    public final /* synthetic */ sg0 g;

    public rg0(sg0 sg0Var) {
        this.g = sg0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        sg0 sg0Var = this.g;
        try {
            try {
                sg0Var.T(new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER").putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(sg0Var.p(), (Class<?>) LiveWallpaperService.class)).addFlags(268435456));
            } catch (ActivityNotFoundException unused) {
                sg0Var.T(new Intent("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER").addFlags(268435456));
            }
        } catch (ActivityNotFoundException unused2) {
            Toast.makeText(sg0Var.p(), w61.toast_failed_launch_wallpaper_chooser, 1).show();
        }
    }
}
