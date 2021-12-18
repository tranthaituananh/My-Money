package pl.cyfrogen.nhom16_mymoney.firebase;

public interface FirebaseObserver<T>
{
    void onChanged(T t);
}
