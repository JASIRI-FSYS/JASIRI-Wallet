/*
 * Copyright 2019 Algorand, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.algorand.android.utils

import android.view.View
import android.view.ViewTreeObserver
import com.algorand.android.R

class KeyboardToggleListener(
    private val root: View,
    private val onKeyboardToggleAction: (shown: Boolean) -> Unit
) : ViewTreeObserver.OnGlobalLayoutListener {

    var isKeyboardShown = false
    private val minimumKeyboardHeight by lazy {
        root.resources.getDimensionPixelSize(R.dimen.minimum_keyboard_height)
    }

    override fun onGlobalLayout() {
        root.run {
            val heightDiff = rootView.height - height
            val keyboardShown = heightDiff > minimumKeyboardHeight
            if (keyboardShown != isKeyboardShown) {
                onKeyboardToggleAction.invoke(keyboardShown)
                isKeyboardShown = keyboardShown
            }
        }
    }
}
