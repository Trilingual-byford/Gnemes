
package com.malygos.gnemes.extension

import android.content.Context
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
//import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback

///** get a material container arc transform. */
//internal fun getContentTransform(context: Context): MaterialContainerTransform {
//  return MaterialContainerTransform().apply {
//    addTarget(android.R.id.content)
//    duration = 450
//    pathMotion = MaterialArcMotion()
//  }
//}
//
///** apply material exit container transformation. */
//fun AppCompatActivity.applyExitMaterialTransform() {
//  window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
//  setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
//  window.sharedElementsUseOverlay = false
//}
//
///** apply material entered container transformation. */
//fun AppCompatActivity.applyMaterialTransform(transitionName: String) {
//  window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
//  ViewCompat.setTransitionName(findViewById(android.R.id.content), transitionName)
//  // set up shared element transition
//  setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
//  window.sharedElementEnterTransition = getContentTransform(this)
//  window.sharedElementReturnTransition = getContentTransform(this)
//}
