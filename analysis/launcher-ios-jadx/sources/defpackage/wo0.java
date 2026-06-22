package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class wo0 extends w50 {
    public int Z = 0;
    public SharedPreferences.Editor a0;
    public TabLayout b0;

    @Override // defpackage.w50
    public final void B() {
        this.J = true;
    }

    @Override // defpackage.w50
    public final void H() {
        this.J = true;
        r00.b().i(this);
    }

    @Override // defpackage.w50
    public final void I() {
        this.J = true;
        r00.b().k(this);
    }

    @jk1(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(oo0 oo0Var) {
        throw null;
    }

    @Override // defpackage.w50
    public final void w(int i, int i2, Intent intent) {
        bm1 bm1VarG;
        super.w(i, i2, intent);
        if (i == 0) {
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                InputStream inputStreamOpenInputStream = null;
                if (data != null) {
                    try {
                        inputStreamOpenInputStream = d().getContentResolver().openInputStream(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        FileOutputStream fileOutputStreamOpenFileOutput = d().openFileOutput("custom_wallpaper", 0);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i3 = inputStreamOpenInputStream.read(bArr);
                            if (i3 <= 0) {
                                inputStreamOpenInputStream.close();
                                fileOutputStreamOpenFileOutput.flush();
                                fileOutputStreamOpenFileOutput.close();
                                int i4 = (this.Z % 2) + 1;
                                this.Z = i4;
                                this.a0.putInt("default_picture", i4);
                                this.a0.apply();
                                return;
                            }
                            fileOutputStreamOpenFileOutput.write(bArr, 0, i3);
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        Toast.makeText(d(), w61.toast_failed_set_picture, 1).show();
                    }
                } else {
                    Toast.makeText(d(), w61.toast_invalid_pic_path, 1).show();
                }
            }
            if (this.Z != 0 || (bm1VarG = this.b0.g(0)) == null) {
                return;
            }
            bm1VarG.a();
        }
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(m61.fragment_settings, viewGroup, false);
        ((TextView) viewInflate.findViewById(v51.introduction)).setText(new SpannableString(Html.fromHtml(s().getString(w61.introduction2))));
        SharedPreferences sharedPreferencesA = e31.a(p());
        this.a0 = sharedPreferencesA.edit();
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(v51.checkBoxPower);
        checkBox.setVisibility(0);
        checkBox.setChecked(sharedPreferencesA.getBoolean("power_saver", true));
        checkBox.setOnCheckedChangeListener(new to0(this, 0));
        this.b0 = (TabLayout) viewInflate.findViewById(v51.tabLayoutPictureChoose);
        int i = sharedPreferencesA.getInt("default_picture", 0);
        this.Z = i;
        bm1 bm1VarG = this.b0.g(i != 0 ? 1 : 0);
        if (bm1VarG != null) {
            bm1VarG.a();
        }
        TabLayout tabLayout = this.b0;
        uo0 uo0Var = new uo0(this, 0);
        ArrayList arrayList = tabLayout.N;
        if (!arrayList.contains(uo0Var)) {
            arrayList.add(uo0Var);
        }
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(v51.seekBarRange);
        seekBar.setProgress(sharedPreferencesA.getInt("range", 10));
        seekBar.setOnSeekBarChangeListener(new vo0(this, 0));
        SeekBar seekBar2 = (SeekBar) viewInflate.findViewById(v51.seekBarDelay);
        seekBar2.setProgress(sharedPreferencesA.getInt("delay", 10));
        seekBar2.setOnSeekBarChangeListener(new vo0(this, 1));
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(v51.checkBoxScroll);
        checkBox2.setChecked(sharedPreferencesA.getBoolean("scroll", true));
        checkBox2.setOnCheckedChangeListener(new to0(this, 1));
        return viewInflate;
    }
}
