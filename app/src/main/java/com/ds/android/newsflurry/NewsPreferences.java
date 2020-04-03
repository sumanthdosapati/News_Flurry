

package com.ds.android.newsflurry;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import com.ds.android.newsflurry.utils.Constants;

import static com.ds.android.newsflurry.utils.Constants.API_KEY;
import static com.ds.android.newsflurry.utils.Constants.API_KEY_PARAM;
import static com.ds.android.newsflurry.utils.Constants.FORMAT;
import static com.ds.android.newsflurry.utils.Constants.FORMAT_PARAM;
import static com.ds.android.newsflurry.utils.Constants.FROM_DATE_PARAM;
import static com.ds.android.newsflurry.utils.Constants.ORDER_BY_PARAM;
import static com.ds.android.newsflurry.utils.Constants.ORDER_DATE_PARAM;
import static com.ds.android.newsflurry.utils.Constants.PAGE_SIZE_PARAM;
import static com.ds.android.newsflurry.utils.Constants.QUERY_PARAM;
import static com.ds.android.newsflurry.utils.Constants.SECTION_PARAM;
import static com.ds.android.newsflurry.utils.Constants.SHOW_FIELDS;
import static com.ds.android.newsflurry.utils.Constants.SHOW_FIELDS_PARAM;
import static com.ds.android.newsflurry.utils.Constants.SHOW_TAGS;
import static com.ds.android.newsflurry.utils.Constants.SHOW_TAGS_PARAM;

public final class NewsPreferences {

    /**
     * Get Uri.Builder based on stored SharedPreferences.
     * @param context Context used to access SharedPreferences
     * @return Uri.Builder
     */
    public static Uri.Builder getPreferredUri(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        // getString retrieves a String value from the preferences. The second parameter is the
        // default value for this preference.
        String numOfItems = sharedPrefs.getString(
                context.getString(R.string.settings_number_of_items_key),
                context.getString(R.string.settings_number_of_items_default));

        // Get the information from SharedPreferences and check for the value associated with the key
        String orderBy = sharedPrefs.getString(
                context.getString(R.string.settings_order_by_key),
                context.getString(R.string.settings_order_by_default));

        // Get the orderDate information from SharedPreferences and check for the value associated with the key
        String orderDate = sharedPrefs.getString(
                context.getString(R.string.settings_order_date_key),
                context.getString(R.string.settings_order_date_default));

        // Get the fromDate information from SharedPreferences and check for the value associated with the key
        String fromDate = sharedPrefs.getString(
                context.getString(R.string.settings_from_date_key),
                context.getString(R.string.settings_from_date_default));

        // Parse breaks apart the URI string that is passed into its parameter
        Uri baseUri = Uri.parse(Constants.NEWS_REQUEST_URL);

        // buildUpon prepares the baseUri that we just parsed so we can add query parameters to it
        Uri.Builder uriBuilder = baseUri.buildUpon();

        // Append query parameter and its value. (e.g. the 'show-tag=contributor')
        uriBuilder.appendQueryParameter(QUERY_PARAM, "");
        uriBuilder.appendQueryParameter(ORDER_BY_PARAM, orderBy);
        uriBuilder.appendQueryParameter(PAGE_SIZE_PARAM, numOfItems);
        uriBuilder.appendQueryParameter(ORDER_DATE_PARAM, orderDate);
        uriBuilder.appendQueryParameter(FROM_DATE_PARAM, fromDate);
        uriBuilder.appendQueryParameter(SHOW_FIELDS_PARAM, SHOW_FIELDS);
        uriBuilder.appendQueryParameter(FORMAT_PARAM, FORMAT);
        uriBuilder.appendQueryParameter(SHOW_TAGS_PARAM, SHOW_TAGS);
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY); // Use your API key when API rate limit exceeded

        return uriBuilder;
    }

    /**
     * Returns String Url for query
     * @param context Context used to access getPreferredUri method
     * @param section News section
     */
    public static String getPreferredUrl(Context context, String section) {
        Uri.Builder uriBuilder = getPreferredUri(context);
        return uriBuilder.appendQueryParameter(SECTION_PARAM, section).toString();
    }
}
