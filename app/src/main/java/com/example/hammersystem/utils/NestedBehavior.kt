package com.example.hammersystem.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class NestedBehavior(context: Context, attr: AttributeSet) :
    CoordinatorLayout.Behavior<View>(context, attr) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ) = dependency is HorizontalScrollView

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        val bar = dependency as HorizontalScrollView
        child.y = bar.height.toFloat() + bar.y

        return super.onDependentViewChanged(parent, child, dependency)
    }

}