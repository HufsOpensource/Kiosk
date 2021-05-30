package com.junyoung.kiosk.component

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class KioskViewModel: ViewModel() {
    private var db = FirebaseFirestore.getInstance()
    var data = ArrayList<FireData>()
    var dataComponyName = ArrayList<FireComponyName>()
    val LiveData = MutableLiveData<ArrayList<FireData>>()
    val LiveComponyData = MutableLiveData<ArrayList<FireComponyName>>()
    fun getData() {
        db.collection("kiosk")
                .document("kioskdata")
                .addSnapshotListener{value, e->
                    if(e!=null) {
                        return@addSnapshotListener
                    }
                    val firedata = FireData(
                            title = value!!["title"].toString(),
                            description = value!!["description"].toString()
                    )
                    data.add(firedata)
                    LiveData.value = data
                }
    }
    //단일 상호명을 저장하기 위한 함수
    fun addcomponyname(item:FireComponyName) {
        val hashdata = hashMapOf(
                "myname" to item.myname
        )
        db.collection("kioskpocha")
                .document("componyname")
                .set(hashdata)
    }
    //Home에 저장하기 위한 모든 상호명 목록
    fun getcompanyname(item:FireComponyName) {
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