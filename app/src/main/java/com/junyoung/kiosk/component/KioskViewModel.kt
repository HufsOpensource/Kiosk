package com.junyoung.kiosk.component

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class KioskViewModel: ViewModel() {
    private var db = FirebaseFirestore.getInstance()
    var data = ArrayList<FireData>()
    val LiveData = MutableLiveData<ArrayList<FireData>>()
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
}