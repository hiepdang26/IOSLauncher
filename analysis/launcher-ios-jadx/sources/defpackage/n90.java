package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class n90 {
    public static final float[][] a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final byte[] f = {19, 29, 8, 77, 5, 6, 28, 27, 7, 78, 5, 12, 16, 71, 25, 12, 5, 78, 5, 4, 10, 19, 29, 84, 121, 105, 26, 3, 71, 10, 26, 7, 25, 73, 29, 9, 4, 4, 66, 9, 19, 71, 42, 67, 29, 58, 38, 12, 23, 7, 22, 29, 8, 21, 102, 0, 27, 29, 15, 1, 26, 4, 84, 93, 13, 12, 5, 2, 6, 26, 87, 54, 73, 26, 44, 48, 43, 43, 99, 13, 6, 30, 79, 99, 100, 29, 7, 29, 72, 3, 19, 24, 78, 21, 13, 6, 64, 73, 26, 44, 53, 6, 8, 89, 63, 28, 15, 17, 82, 100, 29, 7, 29, 72, 3, 19, 24, 78, 5, 4, 10, 19, 29, 79, 6, 60, 44, 2, 92, 2, 16, 7, 38, 8, 10, 1, 28, 7, 21, 102, 20, 27, 7, 5, 7, 23, 31, 73, 9, 31, 12, 14, 25, 14, 25, 42, 39, 17, 15, 28, 9, 10, 0, 71, 3, 15, 61, 11, 10, 15, 13, 6, 82, 101, 6, 13, 6, 11, 65, 30, 24, 85, 18, 5, 1, 9, 29, 84, 91, 51, 51, 16, 8, 17, 9, 6, 6, 0, 0, 29, 34, 2, 2, 91, 2, 1, 78, 126, 28, 0, 1, 15, 27, 92, 1, 65, 19, 2, 12, 9, 17, 82, 28, 48, 55, 6, 31, 25, 70, 41, 19, 19, 17, 10, 26, 83, 99, 1, 64, 5, 7, 26, 28, 14, 72, 3, 30, 6, 14, 7, 67, 26, 50, 125, 24, 7, 26, 31, 12, 57, 1, 13, 0, 70, 87, 107, 0, 0, 10, 14, 10, 0, 4, 79, 5, 6, 12, 95, 14, 25, 42, 55, 21, 10, 5, 15, 27, 27, 91, 2, 5, 38, 7, 25, 13, 94, 120, 28, 1, 26, 5, 0, 31, 67, 76, 3, 16, 23, 91, 78, 29, 54, 51, 66, 58, 8, 16, 25, 51, 7, 22, 27, 29, 6, 28, 13, 84, 103, 36, 15, 26, 27, 7, 29, 78, 30, 12, 23, 29, 76, 45, 32, 35, 34, 72, 88, 82, 31, 10, 16, 80, 71, 93, 0, 94, 76, 76, 88, 73, 94, 70, 92, 76, 25, 64, 65, 69, 64, 82, 89, 81, 91, 82, 101, 121, 21, 14, 31, 87, 5, 27, 18, 84, 31, 11, 11, 91, 84, 88, 51, 53, 16, 22, 32, 7, 10, 0, 13, 84, 121, 105, 9, 1, 65, 13, 1, 85, 7, 13, 60, 13, 10, 0, 79, 2, 6, 25, 11, 75, 30, 0, 17, 91, 79, 16, 12, 0, 31, 74, 64, 85, 3, 17, 10, 92, 72, 1, 21, 66, 10, 50, 28, 20, 6, 65, 69, 9, 99, 79, 83, 67, 79, 27, 75, 15, 71, 85, 16, 73, 83, 72, 8, 22, 93, 68, 2, 26, 1, 17, 12, 76, 82, 68, 79, 27, 2, 3, 11, 125, 5, 15, 16, 79, 99, 78, 72, 73, 84, 72, 0, 14, 20, 26, 67, 7, 16, 6, 26, 6, 23, 6, 79, 80, 14, 0, 16, 27, 19, 29, 6, 64, 4, 21, 86, 68, 5, 89, 78, 83, 70, 85, 91, 64, 84, 121, 67, 79, 77, 14, 10, 25, 26, 21, 29, 78, 1, 7, 7, 71, 8, 4, 85, 83, 67, 5, 12, 28, 65, 2, 18, 27, 71, 9, 0, 20, 89, 85, 16, 71, 23, 65, 69, 84, 30, 66, 81, 92, 85, 105, 72, 69, 82, 73, 29, 22, 23, 26, 31, 64, 76, 26, 0, 0, 26, 7, 12, 12, 84, 5, 76, 8, 27, 29, 10, 12, 0, 73, 99, 18, 121, 105, 9, 1, 65, 13, 1, 85, 7, 13, 60, 7, 28, 26, 74, 9, 5, 39, 11, 0, 28, 4, 28, 14, 3, 22, 75, 25, 8, 77, 94, 85, 22, 27, 6, 28, 12, 69, 84, 88, 9, 2, 71, 78, 11, 9, 9, 20, 58, 6, 9, 6, 67, 77, 72, 0, 26, 20, 0, 73, 13, 7, 27, 26, 75, 30, 51, 20, 10, 10, 29, 22, 91, 73, 20, 121, 67, 79, 77, 14, 26, 16, 22, 70, 73, 7, 6, 7, 17, 92, 36, 0, 25, 8, 48, 1, 31, 23, 73, 82, 83, 11, 14, 1, 72, 63, 28, 15, 17, 73, 67, 72, 31, 17, 77, 94, 73, 22, 1, 17, 6, 0, 0, 59, 14, 23, 10, 26, 30, 7, 87, 127, 85, 84, 73, 78, 26, 12, 0, 91, 30, 15, 85, 29, 7, 58, 0, 17, 29, 14, 29, 4, 3, 8, 6, 15, 26, 26, 6, 13, 66, 72, 0, 26, 64, 9, 19, 61, 15, 15, 14, 54, 27, 19, 10, 90, 67, 66, 77, 77, 3, 7, 27, 17, 27, 60, 9, 13, 29, 91, 31, 90, 127, 19, 105, 98, 19, 23, 10, 93, 83, 4, 29, 12, 74, 63, 17, 39, 27, 28, 0, 12, 12, 16, 124, 9, 2, 1, 15, 13, 15, 9, 23, 65, 25, 22, 0, 93, 77, 77, 3, 26, 7, 16, 69, 78, 30, 12, 23, 28, 76, 9, 20, 2, 5, 59, 12, 8, 12, 67, 83, 5, 3, 2, 79, 24, 85, 22, 27, 27, 0, 13, 27, 38, 79, 8, 8, 0, 29, 74, 72, 30, 120, 73, 79, 83, 67, 25, 8, 77, 94, 85, 28, 26, 7, 11, 26, 33, 21, 66, 10, 50, 28, 20, 6, 72, 88, 82, 1, 14, 31, 5, 60, 4, 84, 9, 85, 88, 84, 31, 11, 11, 91, 92, 77, 3, 19, 27, 11, 17, 58, 4, 22, 0, 26, 0, 74, 84, 103, 14, 76, 85, 85, 2, 12, 13, 90, 73, 23, 65, 30, 15, 16, 28, 32, 7, 10, 0, 13, 79, 78, 67, 14, 15, 93, 68, 22, 26, 27, 27, 10, 65, 73, 89, 14, 5, 15, 27, 11, 17, 32, 4, 30, 15, 60, 26, 25, 10, 86, 36, 102, 85, 85, 84, 73, 8, 4, 6, 21, 90, 76, 8, 27, 29, 10, 12, 0, 49, 6, 29, 29, 
    6, 29, 77, 19, 76, 6, 1, 17, 25, 70, 88, 71, 68, 2, 76, 12, 28, 0, 75, 11, 10, 0, 7, 10, 1, 32, 0, 2, 92, 8, 91, 13, 88, 73, 13, 7, 27, 26, 75, 30, 34, 26, 1, 17, 12, 75, 11, 64, 70, 72, 105, 79, 77, 14, 76, 19, 25, 27, 8, 26, 72, 17, 57, 79, 6, 14, 7, 78, 94, 72, 22, 6, 12, 31, 91, 0, 0, 31, 64, 9, 7, 54, 27, 6, 28, 12, 71, 13, 2, 76, 2, 26, 28, 13, 13, 23, 49, 6, 0, 1, 7, 65, 21, 7, 87, 127, 85, 84, 73, 78, 30, 12, 23, 28, 76, 6, 7, 15, 7, 45, 1, 21, 12, 79, 78, 67, 25, 8, 77, 94, 93, 13, 57, 8, 4, 7, 27, 88, 14, 93, 79, 69, 78, 78, 72, 29, 63, 8, 5, 28, 17, 70, 86, 36, 76, 85, 85, 84, 31, 11, 11, 91, 84, 73, 30, 0, 17, 45, 12, 26, 11, 23, 27, 79, 78, 67, 1, 2, 92, 1, 20, 25, 29, 19, 11, 64, 10, 27, 92, 2, 4, 7, 45, 12, 7, 23, 22, 64, 84, 121, 67, 79, 77, 14, 30, 16, 1, 1, 27, 0, 72, 26, 29, 73, 2, 73, 22, 1, 12, 26, 1, 91, 73, 69, 83, 14, 6, 21, 6, 11, 7, 20, 16, 44, 10, 15, 12, 88, 14, 11, 19, 20, 10, 32, 7, 23, 28, 12, 29, 95, 67, 6, 3, 93, 5, 17, 16, 55, 6, 28, 6, 12, 6, 7, 87, 107, 8, 100, 105, 14, 9, 29, 8, 27, 83, 0, 6, 31, 77, 0, 16, 56, 21, 25, 70, 14, 5, 27, 79, 24, 65, 13, 71, 67, 19, 111, 82, 73, 79, 83, 17, 10, 25, 91, 30, 27, 85, 69, 71, 94, 72, 68, 84, 93, 29, 19, 1, 70, 82, 70, 85, 82, 68, 79, 11, 67, 69, 77, 86, 69, 78, 127, 9, 99, 100, 14, 5, 27, 79, 24, 65, 24, 11, 7, 1, 4, 28, 65, 25, 22, 0, 92, 77, 88, 69, 85, 14, 126, 73, 78, 72, 73, 6, 75, 24, 20, 7, 0, 67, 5, 4, 10, 65, 2, 26, 13, 71, 27, 0, 30, 89, 85, 2, 71, 9, 65, 69, 84, 67, 5, 15, 93, 3, 2, 16, 77, 4, 71, 29, 95, 67, 25, 67, 73, 69, 89, 85, 2, 71, 12, 65, 64, 79, 36, 17, 107, 127, 24, 6, 11, 86, 82, 8, 11, 25, 22, 28, 25, 125, 13, 1, 0, 6, 8, 26, 1, 6, 26, 6, 26, 4, 22, 93, 67, 11, 10, 30, 6, 29, 95, 67, 9, 1, 65, 13, 1, 85, 7, 8, 26, 29, 27, 21, 90, 5, 14, 27, 71, 67, 19, 111, 82, 73, 79, 83, 5, 3, 2, 79, 24, 85, 18, 6, 8, 23, 72, 84, 84, 74, 3, 21, 93, 13, 12, 4, 10, 0, 69, 79, 63, 54, 34, 44, 7, 87, 90, 90, 84, 37, 27, 5, 0, 26, 79, 2, 2, 16, 100, 67, 72, 69, 82, 27, 10, 7, 22, 29, 3, 14, 1, 28, 13, 92, 31, 11, 11, 90, 92, 73, 30, 0, 12, 71, 79, 72, 6, 29, 5, 0, 1, 79, 79, 30, 79, 24, 0, 7, 21, 29, 7, 7, 7, 93, 21, 102, 28, 127, 100, 21, 7, 12, 22, 73, 2, 18, 10, 1, 69, 7, 76, 14, 127, 84, 73, 78, 72, 31, 17, 77, 94, 65, 23, 15, 0, 3, 2, 0, 6, 26, 29, 7, 63, 4, 86, 9, 25, 54, 27, 6, 28, 12, 73, 73, 14, 26, 62, 33, 11, 27, 43, 10, 29, 27, 11, 83, 73, 79, 24, 113, 58, 28, 16, 3, 58, 7, 18, 12, 84, 5, 76, 20, 42, 41, 15, 62, 12, 23, 30, 63, 28, 16, 6, 25, 71, 3, 27, 78, 126, 73, 78, 72, 73, 2, 75, 15, 83, 85, 8, 10, 6, 4, 30, 61, 10, 11, 23, 26, 31, 75, 47, 26, 26, 6, 13, 78, 85, 73, 22, 79, 15, 10, 18, 28, 12, 29, 11, 22, 57, 6, 11, 6, 3, 46, 65, 3, 7, 17, 84, 70, 78, 29, 54, 54, 79, 15, 10, 18, 28, 12, 29, 11, 22, 58, 6, 9, 6, 84, 103, 14, 76, 85, 85, 2, 12, 13, 90, 73, 28, 79, 0, 7, 38, 7, 25, 13, 69, 79, 73, 26, 44, 53, 6, 8, 89, 63, 28, 15, 17, 73, 68, 72, 89, 90, 27, 87, 107, 85, 78, 67, 72, 19, 23, 10, 93, 83, 0, 10, 3, 90, 9, 7, 16, 16, 42, 1, 7, 27, 16, 14, 81, 65, 93, 24, 60, 60, 0, 10, 42, 0, 28, 17, 11, 77, 3, 76, 69, 91, 65, 64, 78, 66, 73, 1, 113, 58, 8, 16, 25, 48, 1, 31, 23, 82, 101, 83, 67, 79, 77, 72, 0, 26, 20, 0, 73, 29, 12, 73, 73, 14, 31, 5, 39, 1, 22, 6, 1, 23, 13, 61, 22, 0, 27, 12, 64, 11, 25, 16, 92, 10, 11, 6, 29, 17, 92, 9, 5, 54, 1, 12, 26, 1, 94, 73, 7, 18, 15, 9, 62, 71, 22, 16, 89, 84, 28, 49, 43, 6, 6, 64, 9, 19, 39, 15, 7, 1, 16, 1, 64, 84, 121, 105, 79, 77, 14, 76, 3, 16, 23, 90, 78, 5, 26, 16, 72, 76, 92, 85, 26, 6, 16, 17, 7, 27, 10, 65, 39, 71, 24, 113, 63, 49, 51, 57, 8, 29, 3, 69, 84, 88, 51, 53, 16, 22, 32, 7, 10, 0, 13, 70, 93, 17, 8, 15, 21, 102, 85, 85, 84, 73, 8, 4, 6, 21, 90, 76, 5, 28, 29, 23, 83, 111, 82, 73, 79, 83, 24, 101, 77, 14, 76, 85, 85, 84, 73, 78, 14, 5, 27, 79, 24, 65, 7, 78, 94, 72, 8, 1, 13, 9, 93, 
    17, 67, 77, 73, 76, 72, 85, 25, 26, 10, 14, 71, 19, 2, 76, 3, 85, 83, 67, 5, 22, 22, 15, 65, 17, 88, 101, 77, 14, 76, 85, 85, 84, 73, 78, 14, 5, 27, 79, 24, 65, 24, 7, 13, 58, 34, 82, 84, 79, 30, 10, 1, 69, 92, 64, 85, 18, 93, 82, 100, 72, 73, 84, 14, 76, 65, 85, 78, 5, 4, 10, 19, 29, 79, 30, 2, 23, 63, 105, 76, 72, 85, 25, 8, 22, 64, 27, 88, 14, 11, 72, 78, 100, 67, 72, 69, 82, 73, 79, 83, 67, 11, 4, 93, 24, 85, 72, 84, 4, 15, 16, 65, 25, 71, 2, 51, 50, 66, 67, 5, 12, 28, 65, 2, 18, 27, 61, 42, 2, 76, 23, 92, 93, 73, 68, 72, 91, 90, 30, 76, 76, 85, 95, 77, 88, 94, 120, 73, 79, 83, 67, 18, 103, 36, 76, 85, 85, 84, 15, 2, 7, 8, 0, 14, 13, 0, 85, 83, 67, 5, 4, 10, 65, 94, 93, 83, 79, 66, 14, 25, 42, 35, 29, 12, 25, 59, 0, 14, 75, 66, 24, 89, 78, 83, 70, 85, 66, 92, 70, 72, 105, 79, 77, 14, 76, 19, 25, 27, 8, 26, 72, 8, 24, 94, 4, 0, 85, 83, 67, 11, 9, 19, 4, 31, 91, 7, 6, 30, 90, 76, 90, 85, 21, 8, 78, 67, 73, 68, 0, 89, 77, 85, 94, 77, 88, 73, 82, 88, 65, 67, 74, 84, 103, 36, 76, 85, 85, 84, 31, 11, 11, 93, 84, 72, 5, 15, 20, 2, 32, 7, 9, 29, 27, 84, 121, 67, 79, 77, 14, 5, 19, 85, 92, 68, 29, 12, 73, 74, 19, 76, 20, 42, 60, 6, 14, 23, 19, 10, 27, 26, 12, 1, 37, 75, 5, 18, 29, 0, 64, 78, 19, 99, 84, 14, 76, 65, 85, 78, 67, 72, 3, 27, 7, 14, 31, 32, 0, 1, 65, 30, 85, 72, 84, 29, 11, 16, 29, 1, 92, 9, 83, 49, 70, 22, 55, 49, 23, 17, 27, 6, 17, 10, 65, 14, 10, 28, 27, 21, 5, 58, 13, 17, 0, 91, 30, 4, 54, 1, 12, 26, 1, 91, 82, 101, 83, 67, 79, 77, 83, 76, 16, 25, 7, 12, 78, 19, 99, 84, 14, 76, 65, 85, 78, 67, 72, 3, 30, 6, 14, 7, 67, 2, 12, 86, 43, 7, 20, 16, 59, 15, 12, 0, 1, 93, 76, 92, 85, 3, 2, 16, 77, 31, 0, 1, 91, 11, 14, 1, 72, 63, 28, 15, 17, 71, 22, 68, 73, 28, 79, 0, 7, 38, 7, 25, 13, 75, 11, 64, 67, 83, 22, 48, 46, 65, 30, 27, 16, 6, 59, 15, 12, 0, 1, 93, 69, 90, 127, 78, 67, 72, 69, 82, 73, 79, 83, 5, 3, 2, 79, 24, 85, 18, 6, 8, 10, 58, 8, 16, 71, 25, 18, 85, 83, 67, 5, 12, 28, 65, 26, 44, 32, 0, 31, 64, 9, 7, 39, 21, 13, 7, 29, 26, 84, 4, 76, 80, 91, 91, 79, 72, 8, 19, 17, 40, 1, 2, 11, 63, 79, 8, 28, 0, 7, 64, 85, 98, 73, 84, 14, 76, 65, 85, 78, 67, 30, 0, 17, 91, 79, 29, 12, 29, 0, 79, 0, 85, 72, 84, 14, 28, 9, 13, 39, 74, 62, 14, 0, 0, 7, 13, 1, 32, 12, 12, 7, 2, 1, 10, 66, 9, 93, 22, 17, 7, 26, 13, 27, 17, 74, 47, 14, 26, 28, 7, 68, 69, 26, 8, 3, 21, 48, 6, 23, 75, 64, 85, 18, 6, 8, 10, 58, 8, 16, 71, 25, 18, 92, 85, 105, 98, 69, 82, 73, 79, 83, 67, 79, 77, 72, 0, 26, 20, 0, 73, 28, 13, 15, 6, 79, 15, 21, 16, 10, 39, 1, 22, 6, 8, 1, 16, 6, 79, 80, 14, 15, 28, 7, 23, 5, 11, 37, 8, 4, 6, 93, 79, 69, 78, 78, 72, 72, 1, 13, 79, 92, 67, 26, 50, 124, 9, 19, 7, 21, 10, 26, 1, 6, 26, 102, 9, 8, 18, 6, 23, 65, 69, 88, 73, 26, 44, 49, 10, 11, 92, 13, 22, 1, 29, 6, 0, 41, 4, 27, 91, 2, 21, 78, 100, 67, 72, 69, 82, 73, 79, 83, 67, 25, 8, 77, 94, 85, 7, 17, 15, 28, 9, 10, 0, 75, 8, 37, 28, 28, 6, 11, 17, 27, 6, 1, 83, 94, 79, 3, 65, 30, 24, 20, 24, 0, 20, 13, 65, 26, 65, 30, 12, 20, 2, 67, 67, 69, 7, 54, 43, 22, 19, 27, 5, 107, 10, 19, 16, 23, 29, 78, 66, 73, 26, 65, 30, 12, 20, 2, 10, 18, 0, 90, 10, 10, 29, 23, 10, 31, 75, 8, 54, 26, 27, 27, 10, 65, 64, 79, 36, 76, 65, 85, 78, 67, 72, 69, 82, 31, 10, 16, 81, 79, 31, 75, 10, 7, 20, 23, 29, 11, 12, 42, 27, 65, 30, 5, 85, 83, 67, 14, 12, 28, 8, 3, 39, 6, 23, 25, 91, 30, 16, 54, 27, 6, 28, 12, 73, 95, 14, 30, 4, 19, 28, 2, 11, 17, 23, 13, 43, 26, 16, 27, 12, 64, 15, 16, 85, 94, 73, 28, 13, 15, 6, 79, 15, 21, 16, 10, 39, 1, 23, 23, 10, 27, 26, 12, 1, 77, 1, 76, 0, 42, 54, 8, 13, 3, 14, 6, 65, 25, 15, 17, 61, 10, 18, 0, 73, 99, 101, 83, 67, 79, 77, 14, 76, 85, 85, 18, 0, 0, 9, 5, 55, 65, 0, 14, 7, 78, 94, 72, 17, 23, 17, 27, 6, 17, 10, 95, 106, 68, 0, 42, 32, 12, 22, 28, 28, 6, 75, 64, 65, 7, 11, 5, 26, 4, 17, 29, 10, 23, 32, 0, 2, 92, 8, 92, 78, 126, 99, 78, 72, 73, 84, 14, 76, 65, 85, 8, 15, 7, 4, 6, 73, 7, 18, 
    15, 9, 62, 90, 30, 26, 30, 17, 73, 83, 72, 28, 43, 125, 24, 19, 26, 5, 6, 63, 12, 22, 29, 7, 83, 73, 79, 93, 0, 89, 78, 127, 84, 73, 78, 72, 73, 84, 14, 76, 7, 25, 1, 2, 28, 69, 1, 29, 29, 28, 8, 10, 40, 74, 11, 16, 85, 73, 73, 29, 5, 6, 27, 90, 4, 18, 1, 11, 19, 64, 13, 19, 5, 9, 32, 23, 29, 2, 69, 9, 85, 94, 84, 8, 15, 68, 73, 28, 79, 0, 7, 38, 26, 17, 7, 14, 23, 73, 66, 83, 2, 14, 65, 14, 13, 23, 6, 92, 13, 7, 27, 29, 93, 7, 87, 107, 127, 78, 67, 72, 69, 82, 73, 79, 83, 21, 10, 14, 29, 76, 23, 7, 29, 14, 6, 28, 73, 73, 14, 10, 8, 27, 15, 15, 43, 10, 30, 6, 29, 93, 17, 8, 15, 14, 70, 85, 71, 90, 89, 85, 98, 73, 84, 14, 76, 65, 85, 78, 67, 30, 0, 17, 90, 79, 23, 2, 29, 6, 14, 81, 85, 23, 6, 0, 9, 0, 29, 84, 4, 76, 81, 91, 91, 86, 83, 111, 82, 73, 79, 83, 67, 79, 77, 14, 10, 25, 26, 21, 29, 78, 15, 27, 21, 74, 5, 4, 27, 26, 67, 85, 69, 67, 71, 95, 83, 78, 79, 12, 76, 31, 93, 3, 43, 61, 11, 16, 42, 27, 65, 30, 5, 91, 22, 67, 67, 69, 4, 54, 59, 22, 27, 44, 2, 65, 30, 17, 91, 13, 73, 67, 72, 88, 90, 30, 69, 90, 127, 78, 67, 72, 69, 82, 73, 79, 83, 21, 10, 14, 29, 76, 6, 1, 6, 6, 5, 13, 36, 29, 86, 76, 92, 85, 3, 10, 16, 77, 16, 27, 6, 20, 11, 27, 65, 14, 8, 20, 7, 31, 69, 78, 15, 27, 21, 74, 5, 4, 27, 26, 74, 83, 111, 82, 73, 79, 83, 67, 79, 77, 14, 26, 16, 22, 64, 73, 29, 28, 27, 27, 69, 9, 34, 26, 2, 67, 85, 69, 4, 12, 12, 71, 75, 28, 25, 92, 3, 30, 16, 57, 0, 22, 68, 73, 18, 71, 2, 0, 25, 45, 12, 4, 10, 0, 71, 14, 90, 88, 101, 103, 14, 76, 85, 85, 84, 73, 78, 72, 15, 29, 64, 13, 13, 54, 1, 15, 7, 23, 82, 84, 79, 30, 10, 23, 69, 72, 5, 27, 20, 24, 42, 1, 4, 6, 6, 2, 76, 18, 1, 28, 12, 3, 0, 49, 6, 3, 95, 67, 28, 25, 92, 3, 30, 16, 49, 13, 9, 13, 64, 79, 36, 102, 65, 85, 78, 67, 72, 69, 82, 73, 9, 26, 13, 14, 1, 109, 3, 25, 26, 6, 71, 15, 72, 67, 73, 14, 13, 13, 5, 6, 2, 83, 111, 82, 73, 79, 83, 30, 101, 103, 14, 76, 85, 85, 18, 5, 1, 9, 29, 84, 73, 30, 0, 12, 78, 94, 72, 1, 29, 29, 71, 21, 10, 1, 12, 66, 47, 26, 25, 27, 27, 64, 26, 14, 22, 2, 76, 45, 32, 35, 34, 65, 94, 120, 73, 79, 83, 67, 9, 4, 64, 13, 25, 54, 27, 5, 1, 26, 71, 6, 73, 14, 65, 72, 78, 14, 1, 29, 90, 31, 10, 16, 80, 71, 10, 92, 13, 12, 92, 88, 73, 8, 1, 7, 21, 66, 47, 14, 25, 1, 17, 70, 23, 21, 11, 67, 83, 82, 65, 88, 7, 87, 127, 127, 84, 73, 78, 72, 14, 24, 113, 42, 19, 20, 9, 32, 7, 9, 29, 27, 79, 78, 67, 9, 4, 64, 13, 25, 54, 27, 5, 1, 26, 82, 126, 83};
    public static final v20[] g = {new v20("name_ulr_private"), new v20("name_sleep_segment_request"), new v20("support_context_feature_id"), new v20("get_current_location"), new v20("get_last_activity_feature_id")};
    public static boolean h = false;
    public static Method i = null;
    public static boolean j = false;
    public static Field k = null;
    public static boolean l = true;

    public static final int C(int i2) {
        uo.p(i2, "state");
        int iV = uo.v(i2);
        if (iV == 0) {
            return 0;
        }
        int i3 = 1;
        if (iV != 1) {
            i3 = 2;
            if (iV != 2) {
                i3 = 3;
                if (iV != 3) {
                    i3 = 4;
                    if (iV != 4) {
                        if (iV == 5) {
                            return 5;
                        }
                        throw new wk(4);
                    }
                }
            }
        }
        return i3;
    }

    public static byte[] D(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
            i2 = i3;
        }
        return bArr;
    }

    public static void E(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (l) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                l = false;
            }
        }
    }

    public static final lz1 F(lz1 lz1Var) throws Throwable {
        qg0.l(lz1Var, "workSpec");
        nn nnVar = lz1Var.j;
        String name = ConstraintTrackingWorker.class.getName();
        String str = lz1Var.c;
        if (qg0.d(str, name) || !(nnVar.d || nnVar.e)) {
            return lz1Var;
        }
        is isVar = new is(1);
        isVar.a(lz1Var.e.a);
        isVar.a.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
        wr wrVar = new wr(isVar.a);
        wr.c(wrVar);
        String name2 = ConstraintTrackingWorker.class.getName();
        int i2 = lz1Var.b;
        nn nnVar2 = lz1Var.j;
        long j2 = lz1Var.n;
        boolean z = lz1Var.q;
        String str2 = lz1Var.a;
        qg0.l(str2, "id");
        uo.p(i2, "state");
        String str3 = lz1Var.d;
        qg0.l(str3, "inputMergerClassName");
        wr wrVar2 = lz1Var.f;
        qg0.l(wrVar2, "output");
        qg0.l(nnVar2, "constraints");
        int i3 = lz1Var.l;
        uo.p(i3, "backoffPolicy");
        int i4 = lz1Var.r;
        uo.p(i4, "outOfQuotaPolicy");
        return new lz1(str2, i2, name2, str3, wrVar, wrVar2, lz1Var.g, lz1Var.h, lz1Var.i, nnVar2, lz1Var.k, i3, lz1Var.m, j2, lz1Var.o, lz1Var.p, z, i4, lz1Var.s, lz1Var.t, lz1Var.u, lz1Var.v, lz1Var.w);
    }

    public static boolean G(in inVar, in inVar2, in inVar3, in inVar4) {
        in inVar5 = in.g;
        in inVar6 = in.j;
        in inVar7 = in.h;
        return (inVar3 == inVar5 || inVar3 == inVar7 || (inVar3 == inVar6 && inVar != inVar7)) || (inVar4 == inVar5 || inVar4 == inVar7 || (inVar4 == inVar6 && inVar2 != inVar7));
    }

    public static float H() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static final LinkedHashSet c(byte[] bArr) throws IOException {
        ObjectInputStream objectInputStream;
        qg0.l(bArr, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    int i2 = objectInputStream.readInt();
                    for (int i3 = 0; i3 < i2; i3++) {
                        Uri uri = Uri.parse(objectInputStream.readUTF());
                        boolean z = objectInputStream.readBoolean();
                        qg0.k(uri, "uri");
                        linkedHashSet.add(new ln(uri, z));
                    }
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } finally {
                }
            } finally {
            }
        }
        return linkedHashSet;
    }

    public static String d(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i2 = 0;
        for (byte b2 : bArr) {
            char[] cArr2 = e;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
            i2 += 2;
        }
        return new String(cArr);
    }

    public static void e(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static final void f(WorkDatabase workDatabase, rl rlVar, uy1 uy1Var) {
        int i2;
        qg0.l(workDatabase, "workDatabase");
        qg0.l(rlVar, "configuration");
        qg0.l(uy1Var, "continuation");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList arrayList = new ArrayList(new w8(new uy1[]{uy1Var}, i));
        int i3 = 0;
        while (!arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            List list = ((uy1) arrayList.remove(xj.u(arrayList))).i;
            if ((list instanceof Collection) && list.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (((mz0) it.next()).b.j.a() && (i2 = i2 + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i3 += i2;
        }
        if (i3 == 0) {
            return;
        }
        mz1 mz1VarU = workDatabase.u();
        mz1VarU.getClass();
        lc1 lc1VarA = lc1.a(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        WorkDatabase_Impl workDatabase_Impl = mz1VarU.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            i = cursorL.moveToFirst() ? cursorL.getInt(0) : 0;
            cursorL.close();
            lc1VarA.k();
            int i4 = i + i3;
            int i5 = rlVar.h;
            if (i4 > i5) {
                throw new IllegalArgumentException(uo.j(uo.n("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", i5, ";\nalready enqueued count: ", i, ";\ncurrent enqueue operation count: "), i3, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
            }
        } catch (Throwable th) {
            cursorL.close();
            lc1VarA.k();
            throw th;
        }
    }

    public static void g(Object obj) {
        h(obj, "Argument must not be null");
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = qs1.a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = ps1.d;
        ps1 ps1Var = (ps1) view.getTag(y51.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (ps1Var == null) {
            ps1Var = new ps1();
            ps1Var.a = null;
            ps1Var.b = null;
            ps1Var.c = null;
            view.setTag(y51.tag_unhandled_key_event_manager, ps1Var);
        }
        WeakReference weakReference2 = ps1Var.c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        ps1Var.c = new WeakReference(keyEvent);
        if (ps1Var.b == null) {
            ps1Var.b = new SparseArray();
        }
        SparseArray sparseArray = ps1Var.b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(y51.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    public static boolean j(fj0 fj0Var, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (fj0Var != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return fj0Var.d(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!h) {
                            try {
                                i = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            h = true;
                        }
                        Method method = i;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (qs1.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!j) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        k = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    j = true;
                }
                Field field = k;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (qs1.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && qs1.c(view, keyEvent)) || fj0Var.d(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static ax1 k(jn jnVar, int i2, ArrayList arrayList, ax1 ax1Var) {
        int i3;
        int i4 = i2 == 0 ? jnVar.r0 : jnVar.s0;
        if (i4 != -1 && (ax1Var == null || i4 != ax1Var.b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                ax1 ax1Var2 = (ax1) arrayList.get(i5);
                if (ax1Var2.b == i4) {
                    if (ax1Var != null) {
                        ax1Var.c(i2, ax1Var2);
                        arrayList.remove(ax1Var);
                    }
                    ax1Var = ax1Var2;
                } else {
                    i5++;
                }
            }
        } else if (i4 != -1) {
            return ax1Var;
        }
        if (ax1Var == null) {
            if (jnVar instanceof zb0) {
                zb0 zb0Var = (zb0) jnVar;
                int i6 = 0;
                while (true) {
                    if (i6 >= zb0Var.u0) {
                        i3 = -1;
                        break;
                    }
                    jn jnVar2 = zb0Var.t0[i6];
                    if ((i2 == 0 && (i3 = jnVar2.r0) != -1) || (i2 == 1 && (i3 = jnVar2.s0) != -1)) {
                        break;
                    }
                    i6++;
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        ax1 ax1Var3 = (ax1) arrayList.get(i7);
                        if (ax1Var3.b == i3) {
                            ax1Var = ax1Var3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (ax1Var == null) {
                ax1Var = new ax1();
                ax1Var.a = new ArrayList();
                ax1Var.d = null;
                ax1Var.e = -1;
                int i8 = ax1.f;
                ax1.f = i8 + 1;
                ax1Var.b = i8;
                ax1Var.c = i2;
            }
            arrayList.add(ax1Var);
        }
        ArrayList arrayList2 = ax1Var.a;
        if (arrayList2.contains(jnVar)) {
            return ax1Var;
        }
        arrayList2.add(jnVar);
        if (jnVar instanceof va0) {
            va0 va0Var = (va0) jnVar;
            va0Var.w0.c(va0Var.x0 == 0 ? 1 : 0, ax1Var, arrayList);
        }
        int i9 = ax1Var.b;
        if (i2 == 0) {
            jnVar.r0 = i9;
            jnVar.I.c(i2, ax1Var, arrayList);
            jnVar.K.c(i2, ax1Var, arrayList);
        } else {
            jnVar.s0 = i9;
            jnVar.J.c(i2, ax1Var, arrayList);
            jnVar.M.c(i2, ax1Var, arrayList);
            jnVar.L.c(i2, ax1Var, arrayList);
        }
        jnVar.P.c(i2, ax1Var, arrayList);
        return ax1Var;
    }

    public static float l(int i2, String[] strArr) {
        float f2 = Float.parseFloat(strArr[i2]);
        if (f2 >= 0.0f && f2 <= 1.0f) {
            return f2;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f2);
    }

    public static ArrayList m(PackageManager packageManager, String str) {
        ArrayList arrayList = new ArrayList();
        Intent intent = str.equals("android.intent.action.GET_CONTENT") ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        if (ar1.g) {
            arrayList.add(intent);
            return arrayList;
        }
        int i2 = 0;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        int size = arrayList.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            Intent intent3 = (Intent) obj;
            if (intent3.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                arrayList.remove(intent3);
                break;
            }
        }
        return arrayList;
    }

    public static Intent n(Activity activity, String str) {
        Intent intent;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = activity.getPackageManager();
        x(activity);
        ArrayList arrayListM = m(packageManager, "android.intent.action.GET_CONTENT");
        if (arrayListM.size() == 0) {
            arrayListM = m(packageManager, "android.intent.action.PICK");
        }
        arrayListM.toString();
        arrayList.addAll(arrayListM);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent intentCreateChooser = Intent.createChooser(intent, str);
        Objects.toString(intentCreateChooser);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        return intentCreateChooser;
    }

    public static final af1 o(Object obj) {
        if (obj == hs0.a) {
            throw new IllegalStateException("Does not contain segment");
        }
        qg0.i(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (af1) obj;
    }

    public static String p(int i2) {
        switch (i2) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return k31.k(i2, "unknown status code: ");
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case zzbbc.zzt.zzm /* 21 */:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static int q(float f2) {
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = c;
        return ik.b(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static final int r(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        throw new IllegalArgumentException(uo.d(i2, "Could not convert ", " to BackoffPolicy"));
    }

    public static final int s(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 == 2) {
            return 3;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 5;
        }
        if (Build.VERSION.SDK_INT < 30 || i2 != 5) {
            throw new IllegalArgumentException(uo.d(i2, "Could not convert ", " to NetworkType"));
        }
        return 6;
    }

    public static final int t(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        throw new IllegalArgumentException(uo.d(i2, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static final int u(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 == 2) {
            return 3;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 5;
        }
        if (i2 == 5) {
            return 6;
        }
        throw new IllegalArgumentException(uo.d(i2, "Could not convert ", " to State"));
    }

    public static final boolean v(Object obj) {
        return obj == hs0.a;
    }

    public static boolean w(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean x(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                String[] strArr = activity.getPackageManager().getPackageInfo(activity.getPackageName(), MotionScene.Transition.TransitionOnClick.JUMP_TO_START).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        if (!strArr[i2].equalsIgnoreCase("android.permission.CAMERA")) {
                            i2++;
                        } else if (activity.checkSelfPermission("android.permission.CAMERA") != 0) {
                            return true;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean y(CropImageActivity cropImageActivity, Uri uri) {
        if (Build.VERSION.SDK_INT < 23 || cropImageActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        try {
            InputStream inputStreamOpenInputStream = cropImageActivity.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return false;
            }
            inputStreamOpenInputStream.close();
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static float z(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public abstract void A(int i2);

    public abstract void B(Typeface typeface, boolean z);

    public s5 a(Context context, Looper looper, mj mjVar, Object obj, fa0 fa0Var, ga0 ga0Var) {
        return b(context, looper, mjVar, obj, (v02) fa0Var, (v02) ga0Var);
    }

    public s5 b(Context context, Looper looper, mj mjVar, Object obj, v02 v02Var, v02 v02Var2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }
}
