package com.example.makeupbeauty.viewModel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.R
import com.example.makeupbeauty.component.models.Comment
import com.example.makeupbeauty.component.models.User
import com.example.makeupbeauty.data.comment
import com.example.makeupbeauty.data.notesData
import com.example.makeupbeauty.notes.data.notes

class PostViewModel: ViewModel() {
    //val concernData = MutableLiveData<MutableList<notesData>>()
    //val recommendData = MutableLiveData<MutableList<notesData>>()
    val my_post = mutableListOf<notesData>()
    val img_uri_list = mutableListOf<String>()
    val my_concern= mutableListOf(
        notesData(
            1,
            "穿搭分享",
            "眼镜: MONTBLANC 万宝龙\n"
                    +"卫衣: DANIEL W . FLETCHER \n"
                    +"短裤: Stone lsland \n"
                    +"长袜: ZE by SANKUANZ × GOOD BAI\n "+"鞋子: ZE by SANKUANZ × GOOD BAI \n"
                    +"今日分享完毕",
            "白敬亭",
            "https://img.zrp.cool/2021/12/26/4baaf5499915f.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/25/caf6fe8f56ed9.jpg",
                "https://img.zrp.cool/2021/12/25/0e33228a04625.jpg",
                "https://img.zrp.cool/2021/12/25/d57e8a426dbf2.jpg",
                "https://img.zrp.cool/2021/12/25/d22409be82c23.jpg",
                "https://img.zrp.cool/2021/12/25/c45ec997a20bc.jpg",
                "https://img.zrp.cool/2021/12/25/9803b46f9696b.jpg"
            ),
            mutableStateListOf<Comment>(),

            "2021-12-26"
        )
    )


    val notes_detail= mutableListOf(
        notesData(
            1,
            "赫本，永远不会过时",
            "Elegance is the only beauty that never fades .--- Audrey Hepburn\n" +
                    "优雅是唯一不会褪色的美。———奥黛丽.赫本\n "+"onchic 小心诗比较法式的一款,但是也没有很浮夸,平时约会带配裙子很赞",
            "小羊",
            "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg",
                "https://img.zrp.cool/2021/12/25/ea230ef06162c.jpg",
                "https://img.zrp.cool/2021/12/25/c64f04dd0e747.jpg",
                "https://img.zrp.cool/2021/12/25/d7ec4a7ba3691.jpg",
                "https://img.zrp.cool/2021/12/25/7e25a3ee03ae4.jpg",
                "https://img.zrp.cool/2021/12/25/4880a230047c6.jpg"
            ),

            mutableStateListOf<Comment>(),

            "2021-12-26"
        ),
        notesData(
            2,
            "8个变丑的坏习惯，避雷",
            "想要变美不仅仅日常要做好护肤，而且还要规避一些变丑的坏习惯，不能一边在做着，一边在吃着，到最后还是回到了原点\n"
                    +"1.不喜欢喝水\n"
                    +"2.不吃早饭\n"
                    +"3.出门不防晒\n"
                    +"4.跷二郎腿\n"
                    +"5.低头玩手机\n"
                    +"6.熬夜\n"
                    +"7.习惯用一侧吃东西\n"
                    +"8.喜欢吃高糖食物\n"
                    +"！！关注点起，别错过后续继续给大家科普的知识喔！！",
            "蛋蛋",
            "https://img.zrp.cool/2021/12/26/750681cb79503.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/25/a00efa3a82a8c.jpg",
                "https://img.zrp.cool/2021/12/25/e42cd79ee3647.jpg",
                "https://img.zrp.cool/2021/12/25/bc48f7e5ae889.jpg",
                "https://img.zrp.cool/2021/12/25/abe9bc9864c0b.jpg",
                "https://img.zrp.cool/2021/12/25/a00efa3a82a8c.jpg",
                "https://img.zrp.cool/2021/12/25/e42cd79ee3647.jpg"
            ),

            mutableStateListOf<Comment>(),

            "2021-12-26"
        ),
        notesData(
            3,
            "杨超越异域少女写真",
            "九张图根本放不下！!!再发一条\n" +
                    "在香格里拉，本来想去租当地藏服拍照\n "+"o偶然看到一件这个衣服！！才有了我超喜欢的图◇\n"
                    +"谢谢小羊粉丝的夸赞，我爱小羊一万年摄影：亦卷古月",
            "小熊",
            "https://img.zrp.cool/2021/12/26/57af322acf184.jpg",
            mutableStateOf(0),
            0,
            mutableListOf(
                "https://img.zrp.cool/2021/12/25/de48e0908d87e.jpg",
                "https://img.zrp.cool/2021/12/25/4dc8c7e031caf.jpg",
                "https://img.zrp.cool/2021/12/25/64a6176a748c1.jpg",
                "https://img.zrp.cool/2021/12/25/ca44fafe2ae36.jpg",
                "https://img.zrp.cool/2021/12/25/cbffbfa63f529.jpg",
                "https://img.zrp.cool/2021/12/25/caae2cfc08ae7.jpg"
            ),
            mutableStateListOf<Comment>(),

            "2021-12-26"
        ),
        notesData(
            4,
            "《司藤》| 景甜",
            "来欣赏一下司藤小姐的美貌吧!从《大唐荣耀》认识景甜小姐姐这次的司藤真的美出天际啦!" ,
            "小猪",
            "https://img.zrp.cool/2021/12/26/f52bd498cc640.jpg",
            mutableStateOf(0),
            0,
            mutableListOf(
                "https://img.zrp.cool/2021/12/25/927f664b9b52a.jpg",
                "https://img.zrp.cool/2021/12/25/f34b4be5b178c.jpg",
                "https://img.zrp.cool/2021/12/25/1055b7d0df7c4.jpg",
                "https://img.zrp.cool/2021/12/25/5008089bdb1ac.jpg",
                "https://img.zrp.cool/2021/12/25/633eef2b3625c.jpg",
                "https://img.zrp.cool/2021/12/25/633eef2b3625c.jpg"
            )
            ,
            mutableStateListOf<Comment>(),

            "2021-12-26"
        ),

        notesData(
            5,
            "杨超越红衣雪山写真",
            "乌发红衣，肤白胜雪。\n"
                    +"她就像初来人间不谙世事的精灵。\n"
                    +"今天也是被超越妹妹惊艳的一天\n"
                    +"每套写真都好绝！ 彻底沦为颜粉了",
            "超越妹妹粉丝",
            "https://img.zrp.cool/2021/12/26/57d6c864c707a.jpg",
            mutableStateOf(0),
            0,
            mutableListOf(
                "https://img.zrp.cool/2021/12/25/5a4d1d5180571.jpg",
                "https://img.zrp.cool/2021/12/25/dbbc209ed765d.jpg",
                "https://img.zrp.cool/2021/12/25/affba07587b2d.jpg",
                "https://img.zrp.cool/2021/12/25/a2fed9a4b26eb.jpg",
                "https://img.zrp.cool/2021/12/25/e28dfbab37266.jpg",
                "https://img.zrp.cool/2021/12/25/f59516a9be270.jpg"
            )
            ,
            mutableStateListOf<Comment>(),

            "2021-12-26"
        ),
        )




    val userList = mutableListOf(
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            240,
            3880,
            concern = true
        )
    )


    val myAvatar = "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg" //本人头像
    val myName = "小羊" //本人头像
    var index by mutableStateOf(0)
    var option by mutableStateOf(0)    //0:concern, 1:recommend
 //   var isFavorited by mutableStateOf(3)   //3表示没有修改过
    var searchtext by mutableStateOf("")

//    fun init() {
//        concernData.postValue(my_concern)
//        recommendData.postValue(notes_detail)
//    }


    fun addPost(title:String, content: String, uri_list: ArrayList<String>) {
        Log.e("post", my_post.size.toString())
        var newPost = notesData(
            my_post.size+1,
            title,
            content,
            myName,
            myAvatar,
            mutableStateOf(0),
            0,
            uri_list,
            mutableStateListOf<Comment>(),
            "2021-12-28"
        )
        my_post.add(my_post.size, newPost)
    }


    fun postComment(id: Int, comment: Comment) {
        if (option == 1) {
            for (i in 0 until notes_detail.size) {
                if (notes_detail[i].id == id) {
                    notes_detail[i].commentlist.add(comment)
                    break
                }
            }
        } else if(option == 2){
            for (i in 0 until my_concern.size) {
                if (my_concern[i].id == id) {
                    my_concern[i].commentlist.add(comment)
                    break
                }
            }
        } else {
            for (i in 0 until my_post.size) {
                if (my_post[i].id == id) {
                    my_post[i].commentlist.add(comment)
                    break
                }
            }
        }
    }


    fun changeConcern(i: Int) {
        index = i;
        option = 1;
    }

    fun changeRecommend(i: Int) {
        index = i;
        option = 2;
    }

    fun changePost(i: Int) {
        index = i;
        option = 3;
    }

    fun getPost(): notesData {
        if(option == 1) {
            return my_concern.elementAt(index)
        } else if(option == 2){
            return notes_detail.elementAt(index)
        } else {
            return my_post.elementAt(index)
        }
    }

    fun clicklike(id: Int) {
        Log.e("like",option.toString())
        if(option == 1) {
            if(my_concern[id - 1].isliked.value == 1) {
                my_concern[id - 1].isliked.value = 0
            } else {
                my_concern[id - 1].isliked.value = 1
            }
        } else if(option == 2){
            notes_detail[id - 1].isliked.value = 1 - notes_detail[id - 1].isliked.value
        } else {
            my_post[id - 1].isliked.value = 1 - my_post[id - 1].isliked.value
        }
    }

    fun clickcollect(id: Int) {
        if(option == 1) {
            var former = my_concern[id-1].iscollected
            var temp = my_concern.get(id-1)
            temp.iscollected = 1 - former
            my_concern.set(id-1, temp)
        } else if(option == 2){
            var former = notes_detail[id-1].iscollected
            var temp = notes_detail.get(id-1)
            temp.iscollected = 1- former
            notes_detail.set(id-1, temp)
        } else{
            var former = my_post[id-1].iscollected
            var temp = my_post.get(id-1)
            temp.iscollected = 1- former
            my_post.set(id-1, temp)
        }
    }
}