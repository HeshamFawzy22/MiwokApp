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

public class FamilyFragment extends Fragment {

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.word_list,container,false);

        final ArrayList<Word> familyPhrases = new ArrayList<>();
        familyPhrases.add(new Word("father" , "әpә" , R.drawable.family_father , R.raw.family_father));
        familyPhrases.add(new Word("mother" , "әṭa" , R.drawable.family_mother , R.raw.family_mother));
        familyPhrases.add(new Word("son" , "angsi" , R.drawable.family_son , R.raw.family_son));
        familyPhrases.add(new Word("daughter" , "tune" , R.drawable.family_daughter , R.raw.family_daughter));
        familyPhrases.add(new Word("older brother" , "taachi" , R.drawable.family_older_brother , R.raw.family_older_brother));
        familyPhrases.add(new Word("younger brother" , "chalitti" , R.drawable.family_younger_brother , R.raw.family_younger_brother));
        familyPhrases.add(new Word("older sister" , "teṭe" , R.drawable.family_older_sister , R.raw.family_older_sister));
        familyPhrases.add(new Word("younger sister" , "kolliti" , R.drawable.family_younger_sister , R.raw.family_younger_sister));
        familyPhrases.add(new Word("grandmother" , "ama" , R.drawable.family_grandmother , R.raw.family_grandmother));
        familyPhrases.add(new Word("grandfather" , "paapa" , R.drawable.family_grandfather , R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(getContext() , familyPhrases , R.color.category_family);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = familyPhrases.get(i);

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
