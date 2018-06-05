package app.pinlendandroid.widgets.recyclerViewPlus;

import app.pinlendandroid.app.bases.MvpView;

public interface RecyclerViewPlusView extends MvpView {
    boolean findRecyclerView();

    boolean findLoadingState();

    boolean findEmptyState();

    boolean findErrorState();

    void showContentState();

    void showContentStateAnimated();

    void hideContentState();

    void hideContentStateAnimated();

    void showLoadingState();

    void showLoadingStateAnimated();

    void hideLoadingState();

    void hideLoadingStateAnimated();

    void showEmptyState();

    void showEmptyStateAnimated();

    void hideEmptyState();

    void hideEmptyStateAnimated();

    void showErrorState();

    void showErrorStateAnimated();

    void hideErrorState();

    void hideErrorStateAnimated();
}
