package defpackage;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;

/* JADX INFO: loaded from: classes.dex */
public final class vo0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ vo0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        switch (this.g) {
            case 0:
                if (z) {
                    wo0 wo0Var = (wo0) this.h;
                    wo0Var.a0.putInt("range", i);
                    wo0Var.a0.apply();
                }
                break;
            case 1:
                if (z) {
                    wo0 wo0Var2 = (wo0) this.h;
                    wo0Var2.a0.putInt("delay", i);
                    wo0Var2.a0.apply();
                }
                break;
            default:
                SeekBarPreference seekBarPreference = (SeekBarPreference) this.h;
                if (z && (seekBarPreference.b0 || !seekBarPreference.W)) {
                    int progress = seekBar.getProgress() + seekBarPreference.T;
                    if (progress != seekBarPreference.S) {
                        seekBarPreference.w(progress, false);
                    }
                } else {
                    int i2 = i + seekBarPreference.T;
                    TextView textView = seekBarPreference.Y;
                    if (textView != null) {
                        textView.setText(String.valueOf(i2));
                    }
                }
                break;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        switch (this.g) {
            case 0:
            case 1:
                break;
            default:
                ((SeekBarPreference) this.h).W = true;
                break;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        int progress;
        switch (this.g) {
            case 0:
            case 1:
                break;
            default:
                SeekBarPreference seekBarPreference = (SeekBarPreference) this.h;
                seekBarPreference.W = false;
                int progress2 = seekBar.getProgress();
                int i = seekBarPreference.T;
                if (progress2 + i != seekBarPreference.S && (progress = seekBar.getProgress() + i) != seekBarPreference.S) {
                    seekBarPreference.w(progress, false);
                    break;
                }
                break;
        }
    }

    private final void a(SeekBar seekBar) {
    }

    private final void b(SeekBar seekBar) {
    }

    private final void c(SeekBar seekBar) {
    }

    private final void d(SeekBar seekBar) {
    }
}
