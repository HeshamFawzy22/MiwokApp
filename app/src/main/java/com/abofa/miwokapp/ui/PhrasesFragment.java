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

public class PhrasesFragment extends Fragment {
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.word_list,container,false);

        final ArrayList<Word> phrases = new ArrayList<>();

        phrases.add(new Word("Where are you going?" , "minto wuksus" , R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?" , "tinnә oyaase'nә" , R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is..." , "oyaaset..." , R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?" , "michәksәs?" , R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good." , "kuchi achit" , R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?" , "әәnәs'aa?" , R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming." , "hәә’ әәnәm" , R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming." , "әәnәm" , R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go." , "yoowutis" , R.raw.phrase_lets_go));
        phrases.add(new Word("Come here." , "әnni'nem" , R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(getContext() , phrases , R.color.category_phrases);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = phrases.get(i);

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
