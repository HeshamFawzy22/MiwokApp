package com.abofa.miwokapp.ui;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.abofa.miwokapp.R;
import com.abofa.miwokapp.model.Word;
import com.abofa.miwokapp.ui.Adapter.WordAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    //**Handles audio focus when playing a sound file
    AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    List<Word> words;
    public NumbersFragment() {
        // Required empty public constructor
    }

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.word_list, container, false);

        // create and setup the AudioManager to request the audio focus
       // mAudioManager = (AudioManager) getSystemService(getContext(),Context.AUDIO_SERVICE);


        words = new ArrayList<>();
        words.add(new Word("one" , "lutti" , R.drawable.number_one , R.raw.number_one));
        words.add(new Word("two", "otiiko" , R.drawable.number_two , R.raw.number_two));
        words.add(new Word("three", "tolookosu" , R.drawable.number_three  , R.raw.number_three));
        words.add(new Word("four", "oyyisa" , R.drawable.number_four , R.raw.number_four));
        words.add(new Word("five", "massokka" , R.drawable.number_five , R.raw.number_five));
        words.add(new Word("six", "temmokka" , R.drawable.number_six , R.raw.number_six));
        words.add(new Word("seven", "kenekaku" , R.drawable.number_seven , R.raw.number_seven));
        words.add(new Word("eight", "kawinta" , R.drawable.number_eight , R.raw.number_eight));
        words.add(new Word("nine", "wo’e" , R.drawable.number_nine , R.raw.number_nine));
        words.add(new Word("ten", "na’aacha" , R.drawable.number_ten , R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(getActivity(),words,R.color.category_numbers);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);

                // Release the media player if it currently exists because we are about to
                // play a different sound file

//                releaseMediaPlayer();
//
//                // Request audio focus for playback
//                int result = mAudioManager.requestAudioFocus(afChangeListener,
//                        // Use the music stream.
//                        AudioManager.STREAM_MUSIC,
//                        // Request permanent focus.
//                        AudioManager.AUDIOFOCUS_GAIN);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    // Start playback
//                }
                mMediaPlayer = MediaPlayer.create(getContext() , word.getmAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        return view;

        //        WordAdapter Adapter = new WordAdapter(this,  words);
//
//        ListView listView = findViewById(R.id.list);
//
//        listView.setAdapter(Adapter);




//        LinearLayout rootView = findViewById(R.id.rootView);
//
//        for(int i = 0 ; i <words.size() ; i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }
    }


    @Override
    public void onStop() {
        super.onStop();
        // when the activity is stopped , release the media player resources because we wont
        // be playing any more sound
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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
