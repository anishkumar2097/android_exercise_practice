package com.example.ex_viewmodel;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomModel extends ViewModel {
    /**
     * ViewModel can be used without LiveDta
     * Primitive data are not allowed
     * ViewModel helps in surviving configuration changes
     * it acts as class which hold the UI data till the activity not end.
     */
 //   private Integer score;
 private MutableLiveData<Integer> score;

    /**
     *
     *
     * this method is implemented when ViewModel is used without LiveData
     */
  /*  public Integer getData() {
        if(score==null){
            return new Integer(0);
        }
        return score;
    }
*/

    /**MutableLiveData used setValue() and postValue() to add data into the mutable object
     * postValue() is used while working on worker thread
     */
    public MutableLiveData<Integer> getData() {
        if(score==null){
           score=new MutableLiveData<>();

           score.setValue(0);

        }
        return  score;
    }

  /*  public void addscore(){
        if(score==null){
            score=0;}
        score=score+1;
    }
*/
    public void addScore(){
        if(score.getValue()!=null){
          score.setValue(score.getValue()+1);
        }

    }
    public void resetScore(){
         score.setValue(0);
    }
}
