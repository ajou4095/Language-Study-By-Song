package com.ray.language.presentation.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ray.language.presentation.ui.main.home.exam.LanguageExamSelectFragmentHelper
import com.ray.language.presentation.ui.main.home.settings.SettingsFragmentHelper
import com.ray.language.presentation.ui.main.home.studymethod.StudyMethodSelectFragmentHelper

class HomeTabAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    private val tabs: List<Fragment> = listOf(
        StudyMethodSelectFragmentHelper.newInstance(),
        LanguageExamSelectFragmentHelper.newInstance(),
        SettingsFragmentHelper.newInstance(),
    )

    private val fragmentIdList: List<Long> = tabs.map {
        it.hashCode().toLong()
    }

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment = tabs[position]

    override fun getItemId(position: Int): Long = fragmentIdList[position]

    override fun containsItem(itemId: Long): Boolean = fragmentIdList.contains(itemId)
}
