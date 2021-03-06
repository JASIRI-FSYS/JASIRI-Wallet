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

package com.algorand.android.customviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.algorand.android.R
import com.algorand.android.databinding.DialogFragmentLoadingBinding
import com.algorand.android.utils.showWithStateCheck
import com.algorand.android.utils.viewbinding.viewBinding

class LoadingDialogFragment : DialogFragment() {

    private val binding by viewBinding(DialogFragmentLoadingBinding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_loading, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.LoadingDialogStyle)
        isCancelable = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statusTextView.text = getString(requireArguments().getInt(LOADING_DESCRIPTION_KEY))
    }

    companion object {
        private const val LOADING_DESCRIPTION_KEY = "loading_description"

        fun show(childFragmentManager: FragmentManager, descriptionResId: Int): LoadingDialogFragment {
            return LoadingDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(LOADING_DESCRIPTION_KEY, descriptionResId)
                }
            }.also {
                it.showWithStateCheck(childFragmentManager)
            }
        }
    }
}
