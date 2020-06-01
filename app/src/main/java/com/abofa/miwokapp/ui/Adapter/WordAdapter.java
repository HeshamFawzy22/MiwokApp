package com.abofa.miwokapp.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abofa.miwokapp.R;
import com.abofa.miwokapp.model.Word;

import androidx.core.content.ContextCompat;

import java.util.List;



public class WordAdapter extends ArrayAdapter<Word> {

    // Resource id for background color of this list of words
    private int mColorResourceId;
    public WordAdapter(Context context, List<Word> objects) {
        super(context, 0, objects);
    }

    public WordAdapter(Context context, List<Word> objects , int colorResourceId ) {
        super(context, 0, objects);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the item_list.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok_text_view from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the item_list.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default_text_view from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getmDefaultTranlation());

        // Find the ImageView in the item_list.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to iconView

        if (currentWord.hasImage()) {
            // set imageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getmImageRecourceId());
            // make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else {

            // otherwise hide this image (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext() , mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}