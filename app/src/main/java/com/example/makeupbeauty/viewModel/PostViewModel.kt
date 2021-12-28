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
        ),
                notesData(
                2,
        "0033 7788",
        " ",
        "白敬亭",
        "https://img.zrp.cool/2021/12/26/4baaf5499915f.jpg",
         mutableStateOf(0),
        0,
        mutableListOf<String>(
            "https://img.zrp.cool/2021/12/27/d767b7a5ae55f.jpg",
            "https://img.zrp.cool/2021/12/27/8d3230f2095a4.jpg",
            "https://img.zrp.cool/2021/12/27/9927778b95634.jpg",
            "https://img.zrp.cool/2021/12/27/fb1d616c4dd1f.jpg",
            "https://img.zrp.cool/2021/12/27/56783993a8b5f.jpg",
            "https://img.zrp.cool/2021/12/27/e604b08fb0192.jpg"
        ),
        mutableListOf<Comment> (
            Comment("1", "1", "1", "1", 1)
        ),
        "2021-12-19"
    ),notesData(
    3,
    "●_●.TD",
    "卫衣：Dries Van Noten\n" +
    "\n" +
    "衬衫：ZEbySANKUANZ\n" +
    "\n" +
    "裤子：Anderssonbell\n" +
    "\n" +
    "鞋：GOODBAI",
    "白敬亭",
    "https://img.zrp.cool/2021/12/26/4baaf5499915f.jpg",
            mutableStateOf(0),
    0,
    mutableListOf<String>(
    "https://img.zrp.cool/2021/12/27/730b036e5989d.jpg",
    "https://img.zrp.cool/2021/12/27/278121c697c31.jpg",
    "https://img.zrp.cool/2021/12/27/6d06016326f64.jpg"
    ),
    mutableListOf<Comment> (
    Comment("1", "1", "1", "1", 1)
    ),
    "2021-11-20"
    ),notesData(
    4,
    "",
    "",
    "白敬亭",
    "https://img.zrp.cool/2021/12/26/4baaf5499915f.jpg",
            mutableStateOf(0),
    0,
    mutableListOf<String>(
        "https://img.zrp.cool/2021/12/27/730b036e5989d.jpg",
        "https://img.zrp.cool/2021/12/27/278121c697c31.jpg",
        "https://img.zrp.cool/2021/12/27/6d06016326f64.jpg"
    ),
    mutableListOf<Comment> (
    Comment("1", "1", "1", "1", 1)
    ),
    ""
    ))


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
        notesData(
            6,
            "6种圣诞节\uD83C\uDF84可爱眼线画法~简单好画！",
            "\n" +
                    "6种圣诞节\uD83C\uDF84可爱眼线画法~简单好画！\n" +
                    "\uD83C\uDF4E提前祝姐妹们圣诞节快乐~\n" +
                    "\n" +
                    "六种很简单的圣诞节眼线画法\n" +
                    "\n" +
                    "画起来其实都很简单\n" +
                    "\n" +
                    "过节出门！拿出眼线笔画起来❄️\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "感谢@宇智脆啵啵 笔记内容的支持，笔记转载已获得原作者授权\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "✨圣诞惊喜看这里✨\n" +
                    "\n" +
                    "12月17日-12月25日期间，小红书在直播间为大家准备了限量圣诞礼盒大家可以1元进行抢购哦，具体信息大家可以搜索 #我的礼想圣诞 进入话题页查看直播日历参与活动。\n" +
                    "\n" +
                    "大家快快行动起来哟\n" +
                    "\n" +
                    "#圣诞节就这么扮 #圣诞妆容怎么画 #圣诞妆容 #眼线到底怎么画 #新手眼妆 #我的礼想圣诞",
            "美妆情报局",
            "https://img.zrp.cool/2021/12/27/4c68b0ab021d2.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/d2ffb41845e0e.jpg",
                "https://img.zrp.cool/2021/12/27/2b0810e9642fe.jpg",
                "https://img.zrp.cool/2021/12/27/4f790914fd3dc.jpg",
                "https://img.zrp.cool/2021/12/27/a5e1398a4bc56.jpg",
                "https://img.zrp.cool/2021/12/27/24c6f1c2c55d7.jpg",
                "https://img.zrp.cool/2021/12/27/e36f5811813e5.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-24"
        ),notesData(
            7,
            "Mac新色 \uD83C\uDF6C 这个圣诞就靠它撑场面了\uD83C\uDF1F",
            "MAC圣诞新色 玫瑰波板糖,有被撩到！\uD83C\uDF6D\n" +
                    "\n" +
                    "是圣诞的新色 \uD83D\uDC84名字叫for my next trick\n" +
                    "\n" +
                    "薄涂晕开是比较嫩的玫瑰色\n" +
                    "\n" +
                    "厚涂是带一点点紫调的玫瑰豆沙色\n" +
                    "\n" +
                    "这支还是薄涂更好看哈\n" +
                    "\n" +
                    "我还叠涂了一个唇油,Y12璀璨时光\n" +
                    "\n" +
                    "像糖果纸一样的\n" +
                    "\n" +
                    "叠涂也好好看啊~\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "感谢@双下巴的凑凑 笔记内容的支持，笔记转载已获得原作者授权\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "✨圣诞惊喜看这里✨\n" +
                    "\n" +
                    "12月17日-12月25日期间，小红书在直播间为大家准备了限量圣诞礼盒大家可以1元进行抢购哦，具体信息大家可以搜索 #我的礼想圣诞 进入话题页查看直播日历参与活动。\n" +
                    "\n" +
                    "大家快快行动起来哟\n" +
                    "\n" +
                    "#我的口红日记 #口红 #无滤镜口红试色 #mac口红 #我的礼想圣诞 #圣诞",
            "美妆情报局",
            "https://img.zrp.cool/2021/12/27/4c68b0ab021d2.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/07b94dd7b6f53.jpg",
                "https://img.zrp.cool/2021/12/27/f78360d989e48.jpg",
                "https://img.zrp.cool/2021/12/27/df3ab3455a5af.jpg",
                "https://img.zrp.cool/2021/12/27/78b7dc6fcf6a8.jpg",
                "https://img.zrp.cool/2021/12/27/24d85f8b1abaa.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-23"
        ),notesData(
            8,
            "这色能连涂一年不？？！",
            "\n" +
                    "这色能连涂一年不？？！\n" +
                    "九敏这支也太绝了\n" +
                    "\n" +
                    "hin清透的质地一点都不油腻\n" +
                    "\n" +
                    "刚上嘴是慕斯质感\n" +
                    "\n" +
                    "用手晕开柔雾哑光质地\n" +
                    "\n" +
                    "上嘴显得嘴巴特别饱满\n" +
                    "\n" +
                    "黄皮可冲入股不亏\n" +
                    "\n" +
                    "\uD83D\uDC84：AVID03\n" +
                    "\n" +
                    "上嘴是冰润奶茶色\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "感谢@樱桃惠子 笔记内容的支持，笔记转载已获得原作者授权\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "✨专“薯”圣诞惊喜看这里✨\n" +
                    "\n" +
                    "12月17日-12月25日期间，小红书在直播间为大家准备了限量圣诞礼盒大家可以1元进行抢购哦，具体信息大家可以搜索#我的礼想圣诞 进入话题页查看直播日历参与活动。\n" +
                    "\n" +
                    "大家快快行动起来哟\n" +
                    "\n" +
                    "#我的口红日记 #无滤镜口红试色 #口红 #口红分享\n" +
                    "\n" +
                    "#我被口红控制了",
            "美妆情报局",
            "https://img.zrp.cool/2021/12/27/4c68b0ab021d2.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/43752b90f0dca.jpg",
                "https://img.zrp.cool/2021/12/27/46fbdc25eeef5.jpg",
                "https://img.zrp.cool/2021/12/27/8fd5f14cbb910.jpg",
                "https://img.zrp.cool/2021/12/27/f8334a834d6e7.jpg",
                "https://img.zrp.cool/2021/12/27/47533a583cfad.jpg",
                "https://img.zrp.cool/2021/12/27/2c99c39cb03f1.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-17"
        ),notesData(
            9,
            "jennie无辜小猫眼妆教程！上扬眼+下至绝惹~",
            "煎妮的平行四边形眼妆泰适合新手内双了！有手就会\n" +
                    "\n" +
                    "简单又日常的上扬猫系眼妆~调整眼形大眼消肿\uD83D\uDC02！\n" +
                    "\n" +
                    "用的是uhue桃气电波腮红画哒~\n" +
                    "\n" +
                    "深冬快速出门妆就这样化！！\n" +
                    "\n" +
                    "眼妆教程写在图里了记得康康~姐妹们快试试！\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "感谢@小刀 笔记内容的支持，笔记转载已获得原作者授权\n" +
                    "\n" +
                    "-\n" +
                    "\n" +
                    "✨圣诞惊喜看这里✨\n" +
                    "\n" +
                    "12月17日-12月25日期间，小红书在直播间为大家准备了限量圣诞礼盒大家可以1元进行抢购哦，具体信息大家可以搜索 #我的礼想圣诞 进入话题页查看直播日历参与活动。\n" +
                    "\n" +
                    "大家快快行动起来哟\n" +
                    "\n" +
                    "#日常眼妆怎么画 #新手眼妆 #秋冬必学的早八妆 #我的礼想圣诞 #眼影试色 #jennie仿妆",
            "美妆情报局",
            "https://img.zrp.cool/2021/12/27/4c68b0ab021d2.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/6f06a13ec0e77.jpg",
                "https://img.zrp.cool/2021/12/27/2b79cdc8a753e.jpg",
                "https://img.zrp.cool/2021/12/27/981320a3b201c.jpg",
                "https://img.zrp.cool/2021/12/27/e0d638f4a7c0e.jpg",
                "https://img.zrp.cool/2021/12/27/81046742a4cea.jpg",
                "https://img.zrp.cool/2021/12/27/407172aecbb51.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-12-22"
        ),notesData(
            10,
            "富江仿妆❗️厌世感甜酷少女漫画眼妆！",
            "川上富江仿妆又来啦~\n" +
                    "\n" +
                    "无意中发现这个川上富江的漫画图\n" +
                    "\n" +
                    "跟之前看到的不太一样，这张的眼妆甜丧又蛮日常~\n" +
                    "\n" +
                    "用到的是猫咪眼影，红棕大地色，消肿绝了！\n" +
                    "\n" +
                    "眼线是用眼线胶笔画滴，强调下眼线，一秒大眼！集美们快试试！",
            "美妆情报局",
            "https://img.zrp.cool/2021/12/27/4c68b0ab021d2.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/02303e39c089b.jpg",
                "https://img.zrp.cool/2021/12/27/194705177a02f.jpg",
                "https://img.zrp.cool/2021/12/27/cf4d39927bcf4.jpg",
                "https://img.zrp.cool/2021/12/27/714c77bf31deb.jpg",
                "https://img.zrp.cool/2021/12/27/a51766753f9ad.jpg",
                "https://img.zrp.cool/2021/12/27/56b9807335ba5.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2020-12-19"
        ),notesData(
            11,
            "铁丸的幼儿园生活",
            "老师镜头下的贝贝也是可爱的\n" +
                    "\n" +
                    "虽然进去前哭的眼睛一单一双的\n" +
                    "\n" +
                    "进去了还是听老师话很乖的宝贝\n" +
                    "\n" +
                    "希望之后越来越顺利吧\n" +
                    "\n" +
                    "#人类幼崽成长记",
            "SASA的丸子妹",
            "https://img.zrp.cool/2021/12/27/e32433c556bb4.jpg",
            mutableStateOf(0),
            0,
            mutableListOf<String>(
                "https://img.zrp.cool/2021/12/27/d34da346602d5.jpg",
                "https://img.zrp.cool/2021/12/27/2c38b4236217c.jpg",
                "https://img.zrp.cool/2021/12/27/e15605bf05830.jpg",
                "https://img.zrp.cool/2021/12/27/e32433c556bb4.jpg",
                "https://img.zrp.cool/2021/12/27/72fbba1f87301.jpg",
                "https://img.zrp.cool/2021/12/27/3b5ec79feeefd.jpg"
            ),
            mutableListOf<Comment> (
                Comment("1", "1", "1", "1", 1)
            ),
            "2021-09-09"
        ),
    )




    val userList = mutableListOf(
        User(
            R.drawable.user1,
            "白敬亭",
            "638112890",
            4,
            1021,
            concern = true
        ),
        User(
            R.drawable.user1,
            "小羊",
            "638112890",
            1,
            9,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "papi",
            "638112890",
            5,
            3,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "丹丹",
            "638112890",
            2,
            8,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "梦凝",
            "638112890",
            1,
            1,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "小熊",
            "638112890",
            2,
            3,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "小猪",
            "638112890",
            0,
            8,
            concern = true
        ),
        User(
            R.drawable.user1,
            "阿呆",
            "638112890",
            24,
            38,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "小桃子",
            "638112890",
            6,
            13,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "Dada",
            "638112890",
            10,
            22,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "小doudou",
            "638112890",
            4,
            3,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "Aria",
            "638112890",
            5,
            0,
            concern = true
        ),
        User(
            R.drawable.avatar,
            "Brandon",
            "638112890",
            1,
            100,
            concern = true
        )
    )


    val myAvatar = "https://img.zrp.cool/2021/12/26/3ae3b54bc4c12.jpg" //本人头像
    var myName by mutableStateOf("游客")  //本人头像
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
            for (i in 0 until my_concern.size) {
                if (my_concern[i].id == id) {
                    my_concern[i].commentlist.add(comment)
                    break
                }
            }

        } else if(option == 2){
            for (i in 0 until notes_detail.size) {
                if (notes_detail[i].id == id) {
                    notes_detail[i].commentlist.add(comment)
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
        index = i-1;
        option = 1;
    }

    fun changeRecommend(i: Int) {
        index = i-1;
        option = 2;
    }

    fun changePost(i: Int) {
        index = i-1;
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