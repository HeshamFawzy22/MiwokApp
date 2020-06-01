package com.abofa.miwokapp.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.abofa.miwokapp.R;
import com.abofa.miwokapp.model.Word;
import com.abofa.miwokapp.ui.Adapter.WordAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorsFragment extends Fragment {

    View view;
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.word_list,container,false);

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("red" , "weṭeṭṭi" , R.drawable.color_red , R.raw.color_red));
        colors.add(new Word("green" , "chokokki" , R.drawable.color_green , R.raw.color_green));
        colors.add(new Word("brown" , "ṭakaakki" , R.drawable.color_brown , R.raw.color_brown));
        colors.add(new Word("gray" , "ṭopoppi" , R.drawable.color_gray , R.raw.color_gray));
        colors.add(new Word("black" , "kululli" , R.drawable.color_black , R.raw.color_black));
        colors.add(new Word("white" , "kelelli" , R.drawable.color_white , R.raw.color_white));
        colors.add(new Word("dusty yellow" , "ṭopiisә" , R.drawable.color_dusty_yellow , R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow" , "chiwiiṭә" , R.drawable.color_mustard_yellow , R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(getContext() , colors , R.color.category_colors);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = colors.get(i);

                // Release the media player if it currently exists because we are about to
                // play a different sound file

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(getContext() , word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        // when the activity is stopped , release the media player resources because we wont
        // be playing any more sound
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
