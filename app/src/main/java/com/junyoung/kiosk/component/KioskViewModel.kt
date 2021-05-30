package com.junyoung.kiosk.component

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class KioskViewModel: ViewModel() {
    private var db = FirebaseFirestore.getInstance()
    var data = ArrayList<FireData>()
    var dataComponyName = ArrayList<FireComponyName>()
    val LiveData = MutableLiveData<ArrayList<FireData>>()
    val LiveComponyData = MutableLiveData<ArrayList<FireComponyName>>()
    fun getData() {
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
                                componyname = document.data["componyname"].toString(),
                                image=document.data["image"].toString()
                        )
                        data.add(firedata)
                        LiveData.value = data
                    }
                }
    }
    //단일 상호명을 저장하기 위한 함수
    fun addcomponyname(item: String) {

        db.collection("kioskpocha")
                .document("componyname")
                .set(item)
    }
    //Home에 저장하기 위한 모든 상호명 목록
    fun getcompanyname() {
        db.collection("kioskpocha")
                .document("componyname")
                .addSnapshotListener{value,e->
                    if(e!=null){
                        return@addSnapshotListener
                    }
                    val fireComponydata  = FireComponyName(
                            myname = value!!["myname"].toString()
                    )
                    dataComponyName.add(fireComponydata)
                    LiveComponyData.value = dataComponyName

                }
    }
    //상호명 안에 있는 데이터 넣기
    fun addData(item:FireData) {
        val hashdata = hashMapOf(
                "title" to item.title,
                "description" to item.description,
                "image" to item.image
        )
        db.collection("kioskpocha")
    }
}