package com.example.quapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;

/**
 * Reusable helper to manage screen loading states:
 * - LOADING: Shows loading view with custom text, hides content, empty, and error views.
 * - CONTENT: Shows main content, hides loading, empty, and error views.
 * - EMPTY: Shows empty view, hides loading, content, and error views.
 * - ERROR: Shows error view with custom message and Retry action, hides loading, content, and empty views.
 */
public class LoadingStateHelper {

    public enum State {
        LOADING,
        CONTENT,
        EMPTY,
        ERROR
    }

    public interface OnRetryListener {
        void onRetry();
    }

    private final View contentView;
    private final View emptyView;
    private final View loadingView;
    private final View errorView;

    private TextView loadingTextView;
    private TextView errorMessageView;
    private MaterialButton errorRetryButton;
    @Nullable private State currentState;

    public LoadingStateHelper(@Nullable View contentView,
                              @Nullable View emptyView,
                              @Nullable View loadingView,
                              @Nullable View errorView) {
        this.contentView = contentView;
        this.emptyView = emptyView;
        this.loadingView = loadingView;
        this.errorView = errorView;

        if (loadingView != null) {
            loadingTextView = loadingView.findViewById(R.id.loading_text);
        }
        if (errorView != null) {
            errorMessageView = errorView.findViewById(R.id.error_message);
            errorRetryButton = errorView.findViewById(R.id.error_retry_button);
        }
    }

    public void setOnRetryListener(@NonNull final OnRetryListener listener) {
        if (errorRetryButton != null) {
            errorRetryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRetry();
                }
            });
        }
    }

    public void showLoading(@Nullable String loadingText) {
        if (loadingTextView != null && loadingText != null) {
            loadingTextView.setText(loadingText);
        }
        if (updateVisibility(State.LOADING)) {
            announce(loadingView, loadingTextView == null ? loadingText : loadingTextView.getText());
        }
    }

    public void showContent() {
        updateVisibility(State.CONTENT);
    }

    public void showEmpty() {
        if (updateVisibility(State.EMPTY)) {
            announce(emptyView, readableText(emptyView));
        }
    }

    public void showError(@Nullable String errorMessage) {
        if (errorMessageView != null && errorMessage != null) {
            errorMessageView.setText(errorMessage);
        }
        if (updateVisibility(State.ERROR)) {
            announce(errorView, readableText(errorView));
        }
    }

    private boolean updateVisibility(State state) {
        boolean changed = currentState != state;
        currentState = state;
        if (loadingView != null) {
            loadingView.setVisibility(state == State.LOADING ? View.VISIBLE : View.GONE);
        }
        if (contentView != null) {
            contentView.setVisibility(state == State.CONTENT ? View.VISIBLE : View.GONE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(state == State.EMPTY ? View.VISIBLE : View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(state == State.ERROR ? View.VISIBLE : View.GONE);
        }
        return changed;
    }

    private static void announce(@Nullable final View view, @Nullable final CharSequence text) {
        if (view == null || text == null || text.length() == 0) {
            return;
        }
        view.post(new Runnable() {
            @Override
            public void run() {
                if (view.isAttachedToWindow() && view.isShown()) {
                    view.announceForAccessibility(text);
                }
            }
        });
    }

    private static CharSequence readableText(@Nullable View view) {
        StringBuilder result = new StringBuilder();
        appendReadableText(view, result);
        return result;
    }

    private static void appendReadableText(@Nullable View view, StringBuilder result) {
        if (view == null || view.getVisibility() != View.VISIBLE) {
            return;
        }
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null && text.length() > 0) {
                if (result.length() > 0) {
                    result.append(". ");
                }
                result.append(text);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                appendReadableText(group.getChildAt(i), result);
            }
        }
    }
}
