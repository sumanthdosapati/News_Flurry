

package com.ds.android.newsflurry.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ds.android.newsflurry.R;
import com.ds.android.newsflurry.fragment.BusinessFragment;
import com.ds.android.newsflurry.fragment.CultureFragment;
import com.ds.android.newsflurry.fragment.EnvironmentFragment;
import com.ds.android.newsflurry.fragment.FashionFragment;
import com.ds.android.newsflurry.fragment.HomeFragment;
import com.ds.android.newsflurry.fragment.ScienceFragment;
import com.ds.android.newsflurry.fragment.SocietyFragment;
import com.ds.android.newsflurry.fragment.SportFragment;
import com.ds.android.newsflurry.fragment.WorldFragment;
import com.ds.android.newsflurry.utils.Constants;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryFragmentPagerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     * across swipes.
     */
    public CategoryFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constants.HOME:
                return new HomeFragment();
            case Constants.WORLD:
                return new WorldFragment();
            case Constants.SCIENCE:
                return new ScienceFragment();
            case Constants.SPORT:
                return new SportFragment();
            case Constants.ENVIRONMENT:
                return new EnvironmentFragment();
            case Constants.SOCIETY:
                return new SocietyFragment();
            case Constants.FASHION:
                return new FashionFragment();
            case Constants.BUSINESS:
                return new BusinessFragment();
            case Constants.CULTURE:
                return new CultureFragment();
            default:
                return null;
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 9;
    }

    /**
     * Return page title of the tap
     */
    @Override
    public CharSequence getPageTitle(int position) {
        int titleResId;
        switch (position) {
            case Constants.HOME:
                titleResId = R.string.ic_title_home;
                break;
            case Constants.WORLD:
                titleResId = R.string.ic_title_world;
                break;
            case Constants.SCIENCE:
                titleResId = R.string.ic_title_science;
                break;
            case Constants.SPORT:
                titleResId = R.string.ic_title_sport;
                break;
            case Constants.ENVIRONMENT:
                titleResId = R.string.ic_title_environment;
                break;
            case Constants.SOCIETY:
                titleResId = R.string.ic_title_society;
                break;
            case Constants.FASHION:
                titleResId = R.string.ic_title_fashion;
                break;
            case Constants.BUSINESS:
                titleResId = R.string.ic_title_business;
                break;
            default:
                titleResId = R.string.ic_title_culture;
                break;
        }
        return mContext.getString(titleResId);
    }
}