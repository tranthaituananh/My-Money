package pl.cyfrogen.nhom16_mymoney.firebase.viewmodels;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import com.google.firebase.database.FirebaseDatabase;

import pl.cyfrogen.nhom16_mymoney.firebase.FirebaseElement;
import pl.cyfrogen.nhom16_mymoney.firebase.FirebaseObserver;
import pl.cyfrogen.nhom16_mymoney.firebase.FirebaseQueryLiveDataElement;
import pl.cyfrogen.nhom16_mymoney.firebase.models.User;

public class UserProfileBaseViewModel extends ViewModel
{
    private final FirebaseQueryLiveDataElement<User> liveData;

    public UserProfileBaseViewModel(String uid)
    {
        liveData = new FirebaseQueryLiveDataElement<>(User.class, FirebaseDatabase.getInstance().getReference()
                .child("users").child(uid));
    }

    public void observe(LifecycleOwner owner, FirebaseObserver<FirebaseElement<User>> observer)
    {
        if(liveData.getValue() != null) observer.onChanged(liveData.getValue());
        liveData.observe(owner, firebaseElement -> {
            if(firebaseElement != null) observer.onChanged(firebaseElement);
        });
    }

}