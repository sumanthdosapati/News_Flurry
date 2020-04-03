

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
 * The WorldFragment is a {@link BaseArticlesFragment} subclass that
 * reuses methods of the parent class by passing the specific type of article to be fetched.
 */
public class WorldFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = WorldFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String worldUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.world));
        Log.e(LOG_TAG, worldUrl);

        // Create a new loader for the given URL
        return new NewsLoader(getActivity(), worldUrl);
    }
}