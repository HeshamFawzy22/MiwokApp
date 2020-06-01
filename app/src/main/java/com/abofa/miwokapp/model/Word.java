package com.abofa.miwokapp.model;

public class Word {

    private String mDefaultTranlation ;
    private String mMiwokTranslation ;
    private int mImageRecourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String mDefaultTranlation, String mMiwokTranslation) {
        this.mDefaultTranlation = mDefaultTranlation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public Word(String mDefaultTranlation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranlation = mDefaultTranlation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranlation, String mMiwokTranslation, int mImageRecourceId, int mAudioResourceId) {
        this.mDefaultTranlation = mDefaultTranlation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageRecourceId = mImageRecourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public String getmDefaultTranlation() {
        return mDefaultTranlation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageRecourceId() {
        return mImageRecourceId;
    }

    // returns whether or not there is an image for this word

    public boolean hasImage(){
        return mImageRecourceId != NO_IMAGE_PROVIDED;
    }

}
