package com.ray.language.presentation.ui.common.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.ray.language.R

inline fun <reified F : Fragment> FragmentActivity.slideFragment(
    @IdRes containerViewId: Int = R.id.container,
    fragment: F,
    leftToRight: Boolean = true,
    addToBackStack: Boolean = true
) {
    supportFragmentManager.commit {
        val tag = F::class.simpleName
        if (leftToRight) {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        } else {
            setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }
        replace(containerViewId, fragment, tag)
        setReorderingAllowed(true)
        if (addToBackStack) addToBackStack(tag)
    }
}