package app.pinlendandroid.ui.fragments.tutorial;

import android.databinding.Bindable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.BR;
import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.databinding.FragmentTutorialBinding;
import app.pinlendandroid.utils.Constants;

import javax.inject.Inject;


public class TutorialFragment extends BaseFragment implements TutorialView {

    @Inject
    TutorialPresenter presenter;
    FragmentTutorialBinding binding;

    public static TutorialFragment newInstance(int drawableId, String content) {
        TutorialFragment fragment = new TutorialFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.BUNDLEKEY.DRAWABLE_ID, drawableId);
        bundle.putString(Constants.BUNDLEKEY.CONTENT_TUTORIAL, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentTutorialBinding.inflate(inflater);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setToolBar() {
        super.setToolBar();
    }

    @Override
    public void initVariable() {
        getFragmentComponent().inject(this);
        presenter.attachView(this);
        if (getArguments() != null) {
            binding.setDrawableId(getArguments().getInt(Constants.BUNDLEKEY.DRAWABLE_ID, -1));
            binding.setContent(getArguments().getString(Constants.BUNDLEKEY.CONTENT_TUTORIAL, ""));
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public String getFragmentLabel() {
        return getString(R.string.fragment_tutorial_label);
    }

    @Override
    public void refresh(boolean isRefreshData) {

    }

    @Override
    public void resetView() {

    }
}
