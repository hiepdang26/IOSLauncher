package defpackage;

import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderPagedView;
import java.lang.ref.WeakReference;
import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: loaded from: classes.dex */
public final class g40 implements View.OnKeyListener {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ g40(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        SeekBar seekBar;
        Object obj = this.h;
        switch (this.g) {
            case 0:
                boolean zH = np1.H(i);
                if (keyEvent.getAction() != 1) {
                    if (!(view.getParent() instanceof ng1)) {
                        WeakReference weakReference = jk0.h;
                        return false;
                    }
                    ng1 ng1Var = (ng1) view.getParent();
                    CellLayout cellLayout = (CellLayout) ng1Var.getParent();
                    int iIndexOfChild = ng1Var.indexOfChild(view);
                    FolderPagedView folderPagedView = (FolderPagedView) cellLayout.getParent();
                    int iIndexOfChild2 = folderPagedView.indexOfChild(cellLayout);
                    int pageCount = folderPagedView.getPageCount();
                    boolean zV = ar1.v(view.getResources());
                    int[][] iArrG = np1.g(cellLayout);
                    int iW = np1.w(i, iIndexOfChild, iIndexOfChild2, pageCount, zV, iArrG);
                    Folder folder = (Folder) obj;
                    if (iW != -1) {
                        View viewB = null;
                        switch (iW) {
                            case -10:
                            case -9:
                                int i2 = iIndexOfChild2 + 1;
                                ng1 shortcutsAndWidgets = ((CellLayout) folderPagedView.getChildAt(i2)).getShortcutsAndWidgets();
                                if (shortcutsAndWidgets != null) {
                                    folderPagedView.Z(i2);
                                    int i3 = ((zg) view.getLayoutParams()).b;
                                    int countX = (iW == -9) ^ shortcutsAndWidgets.d() ? 0 : ((CellLayout) shortcutsAndWidgets.getParent()).getCountX() - 1;
                                    while (true) {
                                        if (countX >= 0) {
                                            for (int i4 = i3; i4 >= 0; i4--) {
                                                View viewB2 = shortcutsAndWidgets.b(countX, i4);
                                                if (viewB2 != null) {
                                                    viewB = viewB2;
                                                }
                                                break;
                                            }
                                            countX--;
                                        }
                                    }
                                }
                                break;
                            case -8:
                                int i5 = iIndexOfChild2 + 1;
                                ng1 shortcutsAndWidgets2 = ((CellLayout) folderPagedView.getChildAt(i5)).getShortcutsAndWidgets();
                                if (shortcutsAndWidgets2 != null) {
                                    folderPagedView.Z(i5);
                                    viewB = shortcutsAndWidgets2.b(0, 0);
                                }
                                break;
                            case -7:
                                viewB = folderPagedView.getLastItem();
                                break;
                            case -6:
                                viewB = cellLayout.I.b(0, 0);
                                break;
                            case -5:
                            case -2:
                                int i6 = iIndexOfChild2 - 1;
                                ng1 shortcutsAndWidgets3 = ((CellLayout) folderPagedView.getChildAt(i6)).getShortcutsAndWidgets();
                                if (shortcutsAndWidgets3 != null) {
                                    int i7 = ((zg) view.getLayoutParams()).b;
                                    folderPagedView.Z(i6);
                                    viewB = shortcutsAndWidgets3.b((iW == -5) ^ shortcutsAndWidgets3.d() ? 0 : iArrG.length - 1, i7);
                                }
                                break;
                            case -4:
                                int i8 = iIndexOfChild2 - 1;
                                ng1 shortcutsAndWidgets4 = ((CellLayout) folderPagedView.getChildAt(i8)).getShortcutsAndWidgets();
                                if (shortcutsAndWidgets4 != null) {
                                    folderPagedView.Z(i8);
                                    viewB = shortcutsAndWidgets4.b(iArrG.length - 1, iArrG[0].length - 1);
                                }
                                break;
                            case KeyAnalyzer.OUT_OF_BOUNDS_BIT_KEY /* -3 */:
                                int i9 = iIndexOfChild2 - 1;
                                ng1 shortcutsAndWidgets5 = ((CellLayout) folderPagedView.getChildAt(i9)).getShortcutsAndWidgets();
                                if (shortcutsAndWidgets5 != null) {
                                    folderPagedView.Z(i9);
                                    viewB = shortcutsAndWidgets5.b(0, 0);
                                }
                                break;
                            default:
                                viewB = ng1Var.getChildAt(iW);
                                break;
                        }
                        if (viewB != null) {
                            viewB.requestFocus();
                            bf1.r(i, view);
                        } else if (i == 20) {
                            folder.y.requestFocus();
                            bf1.r(i, view);
                        }
                    } else if (i == 20) {
                        folder.y.requestFocus();
                        bf1.r(i, view);
                    }
                }
                return zH;
            default:
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = (SeekBarPreference) obj;
                if ((!seekBarPreference.Z && (i == 21 || i == 22)) || i == 23 || i == 66 || (seekBar = seekBarPreference.X) == null) {
                    return false;
                }
                return seekBar.onKeyDown(i, keyEvent);
        }
    }
}
