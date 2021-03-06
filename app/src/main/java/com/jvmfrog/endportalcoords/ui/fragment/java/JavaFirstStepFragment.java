package com.jvmfrog.endportalcoords.ui.fragment.java;

import static com.jvmfrog.endportalcoords.util.FragmentUtils.changeFragmentWithRightToLeftAnimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jvmfrog.endportalcoords.R;
import com.jvmfrog.endportalcoords.databinding.FragmentJavaFirstStepBinding;
import com.jvmfrog.endportalcoords.ui.Dialogs;
import com.shuhart.stepview.StepView;

public class JavaFirstStepFragment extends Fragment {

    private FragmentJavaFirstStepBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle bundle) {
        binding = FragmentJavaFirstStepBinding.inflate(inflater, container, false);

        StepView stepView = getActivity().findViewById(R.id.step_view);

        binding.firstStepBtn.setOnClickListener(view -> {
            if (!binding.firstXCoord.getText().toString().isEmpty() &&
                    !binding.firstZCoord.getText().toString().isEmpty() &&
                    !binding.firstThrowAngle.getText().toString().isEmpty()) {
                Bundle finalBundle = new Bundle();
                finalBundle.putFloat("firstX", Float.parseFloat(binding.firstXCoord.getText().toString()));
                finalBundle.putFloat("firstZ", Float.parseFloat(binding.firstZCoord.getText().toString()));
                finalBundle.putFloat("firstAngle", Float.parseFloat(binding.firstThrowAngle.getText().toString()));
                changeFragmentWithRightToLeftAnimation(getActivity(), new JavaSecondStepFragment(), R.id.wrapper, finalBundle);
                stepView.go(1, true);
            } else {
                System.out.println("Error fields must be filled");
                Dialogs.checkAllFields(view.getContext());
            }
        });

        return binding.getRoot();
    }
}