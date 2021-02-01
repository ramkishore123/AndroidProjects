package com.example.calculatordemo;

public interface IFragmentClickListener {
    void sendDataToActivity(String data);
}
//parent interface

//child class implements interfacname{


//override methods to get the data


//send the object of child class to fragment


//}

//in fragment create constructor which has parent interface object reference
//PhotoFragment(Parent p1){
//this.listener=p1;
//now we got the obj ref of the parent
//if we call parent object methods it will call child class override methods automatically

//}