package com.example.bicroy_copy_d.Network;

public interface ResponsCallBack <T>{
    void Success(T data);
    void Failed(Throwable t);
}
