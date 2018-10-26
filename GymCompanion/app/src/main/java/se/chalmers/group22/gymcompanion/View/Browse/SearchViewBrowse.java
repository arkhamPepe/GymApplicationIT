package se.chalmers.group22.gymcompanion.View.Browse;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
/***
 * Title: SearchViewBrowse
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 23, 2018
 *
 * Purpose: Since the standard android SearchView doesn't support committing an empty query, a custom
 * SearchView had to be made. This class overrides the setOnQueryTextListener and allows
 * an empty string as search query
 */
public class SearchViewBrowse extends SearchView {
    SearchView.SearchAutoComplete mSearchSrcTextView;
    OnQueryTextListener listener;

    public SearchViewBrowse(Context context) {
        super(context);
    }

    public SearchViewBrowse(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchViewBrowse(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override public void setOnQueryTextListener(OnQueryTextListener listener) {
        super.setOnQueryTextListener(listener);
        this.listener = listener;
        mSearchSrcTextView = this.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        mSearchSrcTextView.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (listener != null) {
                listener.onQueryTextSubmit(getQuery().toString());
            }
            return true;
        });
    }
}
