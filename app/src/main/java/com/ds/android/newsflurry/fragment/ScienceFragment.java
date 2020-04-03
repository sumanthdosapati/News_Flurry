

package com.ds.android.newsflurry.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.loader.content.Loader;
import android.util.Log;

import com.ds.android.newsflurry.News;
import com.ds.android.newsflurry.NewsLoader;
import com.ds.android.newsflurry.NewsPreferences;
import com.ds.android.newsflurry.R;

import java.util.List;

/**
 * The ScienceFragment is a {@link BaseArticlesFragment} subclass that
 * reuses methods of the parent class by passing the specific type of article to be fetched.
 */
public class ScienceFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = ScienceFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String scienceUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.science));
        Log.e(LOG_TAG, scienceUrl);

        // Create a new loader for the given URL
        return new NewsLoader(getActivity(), scienceUrl);
    }
}
