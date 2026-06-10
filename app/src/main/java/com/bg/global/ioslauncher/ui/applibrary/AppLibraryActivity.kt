package com.bg.global.ioslauncher.ui.applibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bg.global.ioslauncher.data.model.LauncherAppCategory
import com.bg.global.ioslauncher.databinding.ActivityAppLibraryBinding
import com.bg.global.ioslauncher.di.RepositoryProvider
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconUiModel

class AppLibraryActivity : AppCompatActivity(), AppLibraryContract.View {
    private lateinit var binding: ActivityAppLibraryBinding
    private lateinit var presenter: AppLibraryPresenter
    private lateinit var adapter: AppLibraryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AppLibraryAdapter { item -> presenter.onAppClicked(item) }
        binding.appLibraryRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@AppLibraryActivity)
            adapter = this@AppLibraryActivity.adapter
            addItemDecoration(
                DividerItemDecoration(this@AppLibraryActivity, DividerItemDecoration.VERTICAL)
            )
        }
        binding.backButton.setOnClickListener { finish() }

        presenter = AppLibraryPresenter(
            RepositoryProvider.provideLauncherRepository(applicationContext)
        )
        presenter.attachView(this)
        presenter.loadApps()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showApps(apps: List<LauncherIconUiModel>) {
        adapter.submitApps(apps)
    }

    override fun showCategoryPicker(
        item: LauncherIconUiModel,
        selectedCategory: LauncherAppCategory
    ) {
        val categories = LauncherAppCategory.selectableEntries.toTypedArray()
        val labels = categories.map { category -> category.displayName }.toTypedArray()
        val checkedIndex = categories.indexOf(selectedCategory).coerceAtLeast(0)
        AlertDialog.Builder(this)
            .setTitle("Danh mục")
            .setSingleChoiceItems(labels, checkedIndex) { dialog, which ->
                presenter.onCategorySelected(item, categories[which])
                dialog.dismiss()
            }
            .show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
