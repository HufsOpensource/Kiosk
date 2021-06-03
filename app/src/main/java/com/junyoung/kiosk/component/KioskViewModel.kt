package com.junyoung.kiosk.component

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class KioskViewModel: ViewModel() {
    private var db = FirebaseFirestore.getInstance()
    var data = ArrayList<FireData>()
    var dataComponyName = ArrayList<FireComponyName>()
    var dataShoppingData =ArrayList<FireData>()
    val LiveData = MutableLiveData<ArrayList<FireData>>()
    val LiveComponyData = MutableLiveData<ArrayList<FireComponyName>>()
    val LiveShoppingData = MutableLiveData<ArrayList<FireData>>()
    fun getshopData() {
        db.collection("kioskpocha")
                .addSnapshotListener{value, e->
                    if(e!=null) {
                        return@addSnapshotListener
                    }
                    data.clear()
                    for(document in value!!) {
                        val firedata = FireData(
                                title=document.data["title"].toString(),
                                description = document.data["description"].toString(),
                                companyname = document.data["companyname"].toString(),
                                image=document.data["image"].toString(),
                                cost = document.data["cost"] as Long?
                        )
                        data.add(firedata)
                        LiveData.value = data
                    }
                }
    }
    //단일 상호명을 저장하기 위한 함수
    fun addcompanyname(item: String) {
        val hashdata = hashMapOf(
                "myname" to item,

        )
        db.collection("companyname")
                .add(hashdata)
    }
    //Home에 저장하기 위한 모든 상호명 목록
    fun getcompanyname() {
        db.collection("companyname")
                //데이터는 value  로 들어옴
                .addSnapshotListener { value, e ->
                    if (e != null) {
                        return@addSnapshotListener
                    }
                    dataComponyName.clear()
                    for (document in value!!) {
                        val firecomponydata = FireComponyName(
                                myname = document.data["myname"].toString()
                        )
                        dataComponyName.add(firecomponydata)
                        LiveComponyData.value = dataComponyName



                    }
                }
    }
    //상호명 안에 있는 데이터 넣기
    fun addData(item:FireData) {
        val hashdata = hashMapOf(
                "title" to item.title,
                "description" to item.description,
                "image" to item.image,
                "companyname" to item.companyname,
                "cost" to item.cost
        )
        db.collection("kioskpocha")
                .add(hashdata)
    }
    fun addShoppingData(item:FireData){
        val firedata = FireData(
                title=item.title,
                description = item.description,
                companyname = item.companyname,
                image=item.image,
                cost = item.cost
        )

        dataShoppingData.add(firedata)
        LiveShoppingData.value = dataShoppingData

    }
    fun getShoppingData(): ArrayList<FireData> {
        return dataShoppingData

    }
}


