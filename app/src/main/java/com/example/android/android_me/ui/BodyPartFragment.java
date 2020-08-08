package com.example.android.android_me.ui;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.content.ContentValues.TAG;

public class BodyPartFragment extends Fragment {


    public  static final String IMAGE_ID_LIST="image_ids";
    public  static final String LIST_INDEX="list_index";



    private static final String TAG="BodyPartFragment";


    private List<Integer>mImageIds;
    private int mListIndex;

    public BodyPartFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState!=null) {

            mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex=savedInstanceState.getInt(LIST_INDEX);
        }


        //Inflate the fragment layout
        View rootView= inflater.inflate(R.layout.fragment_body_part,container,false);

        //Get a reference to the ImageView in the layout
       final ImageView imageView=(ImageView)rootView.findViewById(R.id.body_part_image_view);

        //Set the image resource to display
       // imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        if(mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex<mImageIds.size()-1){
                        mListIndex++;
                    }

                    else {
                        mListIndex=0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        }





        else
            Log.v(TAG, "This fragment has a full list of image id's");

        //Return root view
        return  rootView;



    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }
}
