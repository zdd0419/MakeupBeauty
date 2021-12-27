package com.example.makeupbeauty.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.makeupbeauty.data.detail
import com.example.makeupbeauty.data.notesData


class product_detailViewlModel: ViewModel() {
    val kh by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "【圣诞礼物】完美日记软陶唇泥新品柔雾唇釉女秋冬显白口红丝绒",
                        109.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/13116ea3eead9.jpg",
                            "https://img.zrp.cool/2021/12/27/23b7e2929d742.jpg",
                            "https://img.zrp.cool/2021/12/27/668dc43747557.jpg",
                            "https://img.zrp.cool/2021/12/27/6e15eaa2b0035.jpg",
                            "https://img.zrp.cool/2021/12/27/31a34e26e13df.jpg",
                            "https://img.zrp.cool/2021/12/27/56ad469dcccc0.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )


//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "【圣诞礼物】完美日记名片唇纱新品唇釉持久显色丝绒口红显白雾面",
                        119.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/4b298c26b0061.jpg",
                            "https://img.zrp.cool/2021/12/27/80a0c23e3dfeb.jpg",
                            "https://img.zrp.cool/2021/12/27/390d7a2b4e68e.jpg",
                            "https://img.zrp.cool/2021/12/27/220468fdff1dc.jpg",
                            "https://img.zrp.cool/2021/12/27/ce79799b38c8f.jpg",
                            "https://img.zrp.cool/2021/12/27/a17a43889eb93.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )

//                    )
//                )

            ),
//
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "标题：【圣诞礼物】完美日记小细跟口红丝绒哑光唇膏唇釉正品显白学生",
                        129.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/005ac2407528a.jpg",
                            "https://img.zrp.cool/2021/12/27/2d53197045064.jpg",
                            "https://img.zrp.cool/2021/12/27/34c1e768e12be.jpg",
                            "https://img.zrp.cool/2021/12/27/08a10b649d87c.jpg",
                            "https://img.zrp.cool/2021/12/27/85e32fa69ba07.jpg",
                            "https://img.zrp.cool/2021/12/27/af7431cb2301e.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )



//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "【圣诞礼物】完美日记名片唇釉女秋冬丝绒口红唇泥显白雾面哑光",
                        129.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/c7835297bebc8.jpg",
                            "https://img.zrp.cool/2021/12/27/d9858fe89cf9e.jpg",
                            "https://img.zrp.cool/2021/12/27/97494d4afedca.jpg",
                            "https://img.zrp.cool/2021/12/27/90a760158529b.jpg",
                            "https://img.zrp.cool/2021/12/27/c88c08bf347ed.jpg",
                            "https://img.zrp.cool/2021/12/27/8f7600812487d.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )

//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "【圣诞礼物】完美日记水光名片唇露镜面唇釉显白滋润口红唇彩唇蜜",
                        119.00,
                        0,
                        arrayListOf(

                            "https://img.zrp.cool/2021/12/27/d313fb57c04e2.jpg",
                            "https://img.zrp.cool/2021/12/27/d243191aa651f.jpg",
                            "https://img.zrp.cool/2021/12/27/6a08c74d1dddc.jpg",
                            "https://img.zrp.cool/2021/12/27/2299ad8aa3f78.jpg",
                            "https://img.zrp.cool/2021/12/27/e0c0f6ede7787.jpg",
                            "https://img.zrp.cool/2021/12/27/d7542a9fbfde8.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )


//                    )
//                )

            ),
//
//            product_detailData(
//                mutableStateListOf(
                    detail(       6,
                        "【圣诞礼物】完美日记天鹅绒唇釉莫奈红丝绒金丝绒口红女雾面哑光",
                        119.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/fcf688e653f9d.jpg",
                            "https://img.zrp.cool/2021/12/27/4f7f3e64b54d1.jpg",
                            "https://img.zrp.cool/2021/12/27/191f8942f48f6.jpg",
                            "https://img.zrp.cool/2021/12/27/f6c5b919f09aa.jpg",
                            "https://img.zrp.cool/2021/12/27/b54ec49e89876.jpg",
                            "https://img.zrp.cool/2021/12/27/70c13816991cb.jpg"
                        ),
                        arrayListOf(
                            "苹果红",
                            "银冀红棕",
                            "液体玫瑰",
                            "麋鹿棕"
                        )


//                    )
//                )

            ),
//
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        7,
                        "【官方正品】3CE丝绒唇釉唇泥 雾面显白保湿哑光慕斯口红唇泥",
                        110.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/e2a7c85ddc88b.jpg",
                            "https://img.zrp.cool/2021/12/27/f3a47051b187c.jpg",
                            "https://img.zrp.cool/2021/12/27/e53f82e033ed4.jpg",
                            "https://img.zrp.cool/2021/12/27/f75ee1ba40b0e.jpg",
                            "https://img.zrp.cool/2021/12/27/8fadcb820305c.jpg",
                            "https://img.zrp.cool/2021/12/27/65ff49ff72b96.jpg"
                        ),
                        arrayListOf(
                            "枯木赤陶",
                            "烟熏树莓",
                            "红荔色",
                            "砖红色"
                        )

//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        8,
                        "【官方正品】3CE水雾唇露 新品水光雾面唇露唇釉滋润持久红栗色",
                        110.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/9ba99f99ca852.jpg",
                            "https://img.zrp.cool/2021/12/27/2e88f61f7e444.jpg",
                            "https://img.zrp.cool/2021/12/27/70f6a41f67686.jpg",
                            "https://img.zrp.cool/2021/12/27/b876627154f66.jpg",
                            "https://img.zrp.cool/2021/12/27/0e07b6ce9dce5.jpg",
                            "https://img.zrp.cool/2021/12/27/8fadcb820305c.jpg"
                        ),
                        arrayListOf(
                            "乌龙奶茶色",
                            "焦糖红栗色",
                            " 玫瑰豆沙色",
                            "烟熏莓果色"
                        )


//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(

                        9,
                        "【官方正品】3CE三熹玉云朵唇釉 哑光雾面口红唇膏晚霞色铁锈红",
                        110.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/18e5c33a34858.jpg",
                            "https://img.zrp.cool/2021/12/27/2a4370279dc2b.jpg",
                            "https://img.zrp.cool/2021/12/27/5f7db0c7ea05a.jpg",
                            "https://img.zrp.cool/2021/12/27/d38f4c95ca155.jpg",
                            "https://img.zrp.cool/2021/12/27/e0351e19ad522.jpg",
                            "https://s2.loli.net/2021/12/24/tLE41u2crHh8leB.jpg"
                            ),
                        arrayListOf(
                            "烂番茄色",
                            "正红色",
                            " 胡萝卜色",
                            "AMUVE LOVE 铁锈红"
                        )

//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        10,
                        "【官方正品】3CE/三熹玉圣诞新品镜面银管口红滋润水玫瑰Overload",
                        129.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/6ef14107d322c.jpg",
                            "https://img.zrp.cool/2021/12/27/dc3051e0414e5.jpg",
                            "https://img.zrp.cool/2021/12/27/9312c7359480f.jpg",
                            "https://img.zrp.cool/2021/12/27/dc3051e0414e5.jpg",
                            "https://img.zrp.cool/2021/12/27/ed05fcde14468.jpg",
                            "https://img.zrp.cool/2021/12/27/c935ae5e42d98.jpg"
                        ),
                        arrayListOf(
                            "【热卖色】水玫瑰",
                            "冰糖番茄",
                            "杨梅茶",
                            "荔枝草莓"
                        )


//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        11,
                        "【官方正品】3CE哑光口红 吃土南瓜胡萝卜220脏橘 辣椒红唇膏",
                        129.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/96af383e0c673.jpg",
                            "https://img.zrp.cool/2021/12/27/b138b50f6442b.jpg",
                            "https://img.zrp.cool/2021/12/27/44ecc1e65065a.jpg",
                            "https://img.zrp.cool/2021/12/27/579386409a84f.jpg",
                            "https://img.zrp.cool/2021/12/27/9d845b9c0715a.jpg",
                            "https://img.zrp.cool/2021/12/27/24b85aea2c043.jpg"
                        ),
                        arrayListOf(
                            "南瓜色",
                            "DRY TANGERINE",
                            "BACKED ORANGE,红棕色",
                            "辣椒红",
                        )

//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        12,
                        "【官方正品】3CE三熹玉柔雾哑光透明口红 SPEAKTOME豆沙雾面",
                        129.00,
                        0,
                        arrayListOf(

                            "https://img.zrp.cool/2021/12/27/767060c1948cc.jpg",
                            "https://img.zrp.cool/2021/12/27/c833d747c0cf6.jpg",
                            "https://img.zrp.cool/2021/12/27/f2de5be28b931.jpg",
                            "https://img.zrp.cool/2021/12/27/79da2b7806fc0.jpg",
                            "https://img.zrp.cool/2021/12/27/77ea2c93a8b13.jpg",
                            "https://img.zrp.cool/2021/12/27/ab5cea5a46ac7.jpg"
                        ),
                        arrayListOf(
                            "【1M限定版】枣泥豆沙",
                            "红豆奶茶",
                            " 【浪漫宇宙限定】枣泥豆沙",
                            "香芋玫瑰"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        13,
                        "12.【官方正品】3CE细管唇膏 哑光丝绒雾面烟管口红plain铁锈红",
                        125.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/3d3dc40e7280e.jpg",
                            "https://img.zrp.cool/2021/12/27/16319958fdc56.jpg",
                            "https://img.zrp.cool/2021/12/27/3537dfc549ba4.jpg",
                            "https://img.zrp.cool/2021/12/27/c74bbb3678c17.jpg",
                            "https://img.zrp.cool/2021/12/27/2766418ba7f8a.jpg",
                            "https://img.zrp.cool/2021/12/27/9b9e2122a4a10.jpg"
                        ),
                        arrayListOf(
                            "【热卖色】红丝绒",
                            "【热卖色】红茶拿铁",
                            "烟熏玫瑰",
                            "铁锈红"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        14,
                        "【圣诞礼物】Dior迪奥烈艳蓝金唇膏口红 丝绒999 720 哑光 礼盒",
                        350.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/7b9df8bfc1084.jpg",
                            "https://img.zrp.cool/2021/12/27/d96bbd1d0c782.jpg",
                            "https://img.zrp.cool/2021/12/27/c58b1df995aa3.jpg",
                            "https://img.zrp.cool/2021/12/27/e96258f8f5dee.jpg",
                            "https://img.zrp.cool/2021/12/27/d234b7cb9217e.jpg",
                            "https://img.zrp.cool/2021/12/27/02e301e7643b9.jpg"
                        ),
                        arrayListOf(
                            "999 传奇红唇 哑光",
                            "999 传奇红唇 丝绒",
                            "720 偶像 豆沙红棕",
                            "840 光芒 枫叶砖红"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        15,
                        "【圣诞礼物】Dior迪奥烈艳蓝金唇膏口红花境梦工坊限量版999 速达",
                        370.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/019ffb68fe340.jpg",
                            "https://img.zrp.cool/2021/12/27/0f6155591b4ee.jpg",
                            "https://img.zrp.cool/2021/12/27/02e301e7643b9.jpg",
                            "https://img.zrp.cool/2021/12/27/4049503c0a8db.jpg",
                            "https://img.zrp.cool/2021/12/27/5c4d8deaa81c1.jpg",
                            "https://img.zrp.cool/2021/12/27/5c4d8deaa81c1.jpg"
                        ),
                        arrayListOf(

                            "999丝绒（限量版）",
                            "862丝绒（限量版）",
                            "466缎光（限量版）",
                            "858哑光（限量版）"
                        )
//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        16,
                        "【圣诞礼物速达】Dior迪奥烈艳蓝金锁色唇釉999 626轻盈持妆 口红",
                        350.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/19680d6a9aca1.jpg",
                            "https://img.zrp.cool/2021/12/27/cb4a8c1082268.jpg",
                            "https://img.zrp.cool/2021/12/27/511f44fee949e.jpg",
                            "https://img.zrp.cool/2021/12/27/895d5589b8ee5.jpg",
                            "https://img.zrp.cool/2021/12/27/fe73829577f01.jpg",
                            "https://img.zrp.cool/2021/12/27/5821180242a02.jpg"
                        ),
                        arrayListOf(
                            "999 Forever Dior传奇红唇",
                            "626 Forever Famous 名扬四海 红茶棕",
                            "741 枫糖棕",
                            "惊艳四座 复古正红",
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        17,
                        "【圣诞礼物速达】Dior迪奥烈艳蓝金挚红唇膏红管999 641半哑光",
                        350.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/27/ec58625bdf676.jpg",
                            "https://img.zrp.cool/2021/12/27/af1ae8c36c850.jpg",
                            "https://img.zrp.cool/2021/12/27/71e30e30aa8b6.jpg",
                            "https://img.zrp.cool/2021/12/27/8b0a262ef7886.jpg",
                            "https://img.zrp.cool/2021/12/27/96f0fa2748617.jpg",
                            "https://img.zrp.cool/2021/12/27/e502943bdd7c2.jpg"
                            ),

                        arrayListOf(
                            "999 传奇红唇",
                            "436 南瓜脏橘",
                            "641 枫叶砖红",
                            "545 元气橘红"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        18,
                        "【圣诞礼物】Dior迪奥金艳幻彩唇膏口红花境梦工坊限量版显色持妆",
                        350.00,
                        0,
                        arrayListOf(

                            "https://img.zrp.cool/2021/12/27/c88b37a5df4ba.jpg",
                            "https://img.zrp.cool/2021/12/27/c4b22cdc10761.jpg",
                            "https://img.zrp.cool/2021/12/27/c9b4c55ea647a.jpg",
                            "https://img.zrp.cool/2021/12/27/9fc02d9252752.jpg",
                            "https://img.zrp.cool/2021/12/27/a5ee41c81e169.jpg",
                            "https://img.zrp.cool/2021/12/27/bd533865ee20e.jpg"
                        ),
                        arrayListOf(
                            "074 冬日玫瑰",
                            "075 赤霞蔷薇",
                            "077 午夜紫罗兰",
                            "545 元气橘红"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        19,
                        "YSL圣罗兰方管口红 1966红棕色157赤豆沙正红色1缎光持久滋润",
                        335.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/28/8ae3ec19392dd.jpg",
                            "https://img.zrp.cool/2021/12/28/984fd39c3bb15.jpg",
                            "https://img.zrp.cool/2021/12/28/7a5518224e492.jpg",
                            "https://img.zrp.cool/2021/12/28/56510929b4a8b.jpg",
                            "https://img.zrp.cool/2021/12/28/d4068461a27b3.jpg",
                            "https://img.zrp.cool/2021/12/28/d56aca312e5db.jpg"
                        ),
                        arrayListOf(
                            "全新1966无法复刻的红棕",
                            "新色157 赤豆沙",
                            "新色21 复古红",
                            "新色153 枫糖棕",
                        )

//                    )
//                )

            ),

//            product_detailData(
//                    mutableStateListOf(
                        detail(
                            20,
                            "YSL圣罗兰小金条细管口红 哑光新色1966红棕色复古红21持久显色",
                            350.00,
                            0,
                            arrayListOf(
                                "https://img.zrp.cool/2021/12/28/bf685b281922e.jpg",
                                "https://img.zrp.cool/2021/12/28/002e3c97c0787.jpg",
                                "https://img.zrp.cool/2021/12/28/fdca698328ab3.jpg",
                                "https://img.zrp.cool/2021/12/28/bab6f8ccac013.jpg",
                                "https://img.zrp.cool/2021/12/28/3526b3306628c.jpg",
                                "https://img.zrp.cool/2021/12/28/d4b927e1fb1cd.jpg"
                            ),
                            arrayListOf(
                                "【青春亲荐】不羁复古红",
                                "热卖高阶胡萝卜",
                                "新色 糖渍金桔",
                                "热卖 枣泥红棕"
                                )
//                        )
//                    )

                    ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        21,
                        "YSL圣罗兰黑管唇釉 镜面滋润持久显色416番茄色409",
                        335.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/28/d89b287c16a99.jpg",
                            "https://img.zrp.cool/2021/12/28/17ab4aa45917b.jpg",
                            "https://img.zrp.cool/2021/12/28/d4760d15604af.jpg",
                            "https://img.zrp.cool/2021/12/28/984fd39c3bb15.jpg",
                            "https://img.zrp.cool/2021/12/28/5ae55814cdd9a.jpg",
                            "https://img.zrp.cool/2021/12/28/87a27fcad5b9a.jpg"
                        ),
                        arrayListOf(
                            "416 烂番茄",
                            "409 浆果红",
                            "401 血浆红",
                            "425 辣椒红"
                        )
                    ),


                    detail(
                        22,
                        "鞠婧祎推荐色】INTO YOU女主角唇泥雾面哑光唇釉唇彩不拔干显白",
                        59.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/28/6b3013190ef28.jpg",
                            "https://img.zrp.cool/2021/12/28/3b4c8525a4ed8.jpg",
                            "https://img.zrp.cool/2021/12/28/40a807ba7bfc8.jpg",
                            "https://img.zrp.cool/2021/12/28/14d61ba840b43.jpg",
                            "https://img.zrp.cool/2021/12/28/181fcc18b4204.jpg",
                            "https://img.zrp.cool/2021/12/28/dc333ec3197c8.jpg"
                        ),
                        arrayListOf(
                            "EM01赤茶柑橘色",
                            "EM02 桃红色",
                            "EM03 焦糖茶棕色",
                            "EM04 深莓果红色"
                        )




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(23,
                        "INTO YOU水感唇釉秋冬哑光口红唇彩水雾唇釉平价学生女官方正品女",
                        108.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/28/61c5d5b9522eb.jpg",
                            "https://img.zrp.cool/2021/12/28/81720886ffc97.jpg",
                            "https://img.zrp.cool/2021/12/28/016083616823e.jpg",
                            "https://img.zrp.cool/2021/12/28/06496263c7bd1.jpg",
                            "https://img.zrp.cool/2021/12/28/7f44cdf22bbfc.jpg",
                            "https://img.zrp.cool/2021/12/28/a0d3229cacabb.jpg"
                        ),


                        arrayListOf(
                            "W01 蜜桃荔枝",
                            "W02树莓荔枝",
                            "W03 西柚荔枝",
                            "W04 杨梅荔枝"
                        )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        24,
                        "INTO YOU糖浆唇蜜甜漾唇蜜水光口红小众品牌唇彩显白平价学生女",
                        108.00,
                        0,
                       arrayListOf(
                           "https://img.zrp.cool/2021/12/28/6ba01fe5481fd.jpg",
                           "https://img.zrp.cool/2021/12/28/649778f153770.jpg",
                           "https://img.zrp.cool/2021/12/28/f84b03b93cb97.jpg",
                           "https://img.zrp.cool/2021/12/28/4d758d1e8b80c.jpg",
                           "https://img.zrp.cool/2021/12/28/c4a87332d2e55.jpg",
                           "https://img.zrp.cool/2021/12/28/cf08efeb3ac20.jpg"),

                       arrayListOf(
                           "G01",
                           "G02",
                           "G03",
                           "G04"
                       )




//                    )
//                )

            ),



                    detail(
                        25,
                        "【直播专享】MAC/魅可丘比特唇釉唇彩唇油哑光显白 486脏橘色",
                        210.00,
                        0,
                       arrayListOf(
                           "https://img.zrp.cool/2021/12/28/4a5331bd25f92.jpg",
                           "https://img.zrp.cool/2021/12/28/05ba8379c25f7.jpg",
                           "https://img.zrp.cool/2021/12/28/53dbdb6843db0.jpg",
                           "https://img.zrp.cool/2021/12/28/05719074e7e1b.jpg",
                           "https://img.zrp.cool/2021/12/28/a93a341e3df31.jpg",
                           "https://img.zrp.cool/2021/12/28/f71002ddc4389.jpg",
                       ),


                        arrayListOf(
                            "486 沦陷摩纳哥",
                            "499 独占咖位",
                            "487 甜菊上瘾",
                            "480 紫醉金迷",
                        )




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        26,
                        "【直播专享-热门唇膏合集】MAC/魅可水漾子弹头尤雾弹口红316/544",
                        210.00,
                        0,
                      arrayListOf(

                          "https://img.zrp.cool/2021/12/28/7ef697efffd83.jpg",
                          "https://img.zrp.cool/2021/12/28/d38e16624d5ef.jpg",
                          "https://img.zrp.cool/2021/12/28/5a7c2eb7028e5.jpg",
                          "https://img.zrp.cool/2021/12/28/137c76d9eccc4.jpg",
                          "https://img.zrp.cool/2021/12/28/3aa4364440af7.jpg",
                          "https://img.zrp.cool/2021/12/28/9bad05cae6ad4.jpg"
                      ),


                      arrayListOf(
                          "486 沦陷摩纳哥",
                          "499 独占咖位",
                          "487 甜菊上瘾",
                          "480 紫醉金迷"
                      )



//                    )
//                )

            ),

            )
    )


    val eye by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "【新色】Judydoll橘朵七巧板玩趣眼影盘粉棕盘腮红高光大地",
                        79.80,
                        0,
                       arrayListOf(

                           "https://s2.loli.net/2021/12/25/4jLkodK9vzc7iMI.jpg",
                           "https://s2.loli.net/2021/12/25/YGFzgtBJqmy3bDO.jpg",
                           "https://s2.loli.net/2021/12/25/HBGNewdEObLmKJa.jpg",
                           "https://s2.loli.net/2021/12/25/JGxr8wH2CvjSVcl.jpg",
                           "https://s2.loli.net/2021/12/25/K5t6QfTgVPqsInH.jpg",
                           "https://s2.loli.net/2021/12/25/vZzreqOxGC4K2T3.jpg"
                       ),


                       arrayListOf( "生椰拿铁盘",
                           "粉芋灰棕盘",
                           "微光蜜桃盘",
                           "焦糖牛奶盘"
                       )


//                    )
//                )

            ),

//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "【秋冬新色】Judydoll橘朵大麦盘紫穗麦田20色眼影盘油画盘哑光",
                        118.80,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/a5XA2VLqlmnp3yi.jpg",
                            "https://s2.loli.net/2021/12/25/9GkCR1VqAhitxZu.jpg",
                            "https://s2.loli.net/2021/12/25/paBJfNGokOhA62Y.jpg",
                            "https://s2.loli.net/2021/12/25/93XBqxUIKLtclao.jpg",
                            "https://s2.loli.net/2021/12/25/k58An4FGlXvVuhg.jpg",
                            "https://s2.loli.net/2021/12/25/k58An4FGlXvVuhg.jpg"),


                        arrayListOf(
                            "紫穗麦田二十色眼影盘",
                            "夏目原野二十眼影盘",
                            "加州日落二十色眼影盘",
                            "焦糖牛奶盘",
                        )




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        3,
                        "【圣诞礼物】完美日记动物眼影赤狐盘王者荣耀联名限定红棕",
                        109.90,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/25/neadKTEzWMu5Fro.jpg",
                            "https://s2.loli.net/2021/12/25/neadKTEzWMu5Fro.jpg",
                            "https://s2.loli.net/2021/12/25/9qzPUZewMoJ2xDF.jpg",
                            "https://s2.loli.net/2021/12/25/neadKTEzWMu5Fro.jpg",
                            "https://s2.loli.net/2021/12/25/Dx2hYrpGwg7odSF.jpg",
                            "https://s2.loli.net/2021/12/25/ZYtoniKwbDsHI62.jpg"

                        ),


                        arrayListOf(  "貂蝉粉紫盘",
                            "西施大地盘",
                            "赤狐盘",
                            "小猪盘")




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "【圣诞礼物】3CE眼影盘，打造自然裸妆",
                        230.00,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/Qxtp2g8RaiXPSVN.jpg",
                            "https://s2.loli.net/2021/12/25/nPAEZef5rs9RIwG.jpg",
                            "https://s2.loli.net/2021/12/25/uPHqbjVvEJ28tOA.jpg",
                            "https://s2.loli.net/2021/12/25/Hindp6v7S81OqBr.jpg",
                            "https://s2.loli.net/2021/12/25/tyd7GnlmE95b6Ae.jpg",
                            "https://s2.loli.net/2021/12/25/cS61gEJXZiulU9R.jpg"),


                       arrayListOf(
                           "酒神盘",
                           "芋泥盘",
                           "橘棕盘",
                           "黄油盘",
                       )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "【官方正品】3CE三色眼影 自然持久裸妆哑光珠光南瓜大地色韩国",
                        129.00,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/c3o8DEvxKGYnUpT.jpg",
                            "https://s2.loli.net/2021/12/25/StoT7iuU8nAczOr.jpg",
                            "https://s2.loli.net/2021/12/25/Pxl7eoSNWgvbdCO.jpg",
                            "https://s2.loli.net/2021/12/25/vBfM9l26JNWVSho.jpg",
                            "https://s2.loli.net/2021/12/25/mG96YtfT2KrdpxD.jpg",
                            "https://s2.loli.net/2021/12/25/NYzcEySFb4lk98R.jpg"),



                     arrayListOf(  "SWOON",
                         "GO OVER",
                         "OVERSTAY",
                         "DAINTY TASTY",)



//                    )
//                )

            ),
        )
    )


    val hair by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "韩国爱茉莉美妆仙纯植物泡泡染发剂新款卡其棕/复古粉自助染发膏",
                        80.00,
                        0,
                      arrayListOf(
                          "https://s2.loli.net/2021/12/25/165Vl42IwbNJKZY.jpg",
                          "https://s2.loli.net/2021/12/25/MfUxw3GCmqjDTHl.jpg",
                          "https://s2.loli.net/2021/12/25/fOaD2NFh7gXbB68.jpg",
                          "https://s2.loli.net/2021/12/25/f1jHbN4MY5JFOcT.jpg",
                          "https://s2.loli.net/2021/12/25/7BY6Gt8oEAmJPkr.jpg",
                          "https://s2.loli.net/2021/12/25/fvYa7yNdLCU48Rq.jpg"

                      ),


                      arrayListOf(
                          "复古玫瑰粉",
                          "脏橘",
                          "深玫瑰红",
                          "焦糖色" ,
                      )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(

                        2,
                        "染发剂2021流行色显白黑茶女泡泡天然无刺激植物纯自己在家染发膏",
                        78.00,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/Sv42FBqZLMYjnyN.jpg",
                            "https://s2.loli.net/2021/12/25/X2HmqP7DtVEukOe.jpg",
                            "https://s2.loli.net/2021/12/25/4ekVWljdDf6t5vE.jpg",
                            "https://s2.loli.net/2021/12/25/ZIVuA2KqMs5Pt3y.jpg",
                            "https://s2.loli.net/2021/12/25/W4MqtHImEzu3PD8.jpg",
                            "https://s2.loli.net/2021/12/25/cmg7uPowyiZNAqz.jpg"),


                      arrayListOf(
                          "葡萄红",
                          "奶茶色",
                          "粉棕色",
                          "巧克力色"

                      )


//                    )
//                )

            ),
        )
    )

    val hufu by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "SK-II神仙水精华液护肤套装",
                        690.00,
                        0,
                     arrayListOf("https://img.zrp.cool/2021/12/25/0e644610b646f.png",
                         "https://img.zrp.cool/2021/12/25/298f9b893f7d3.jpg",
                         "https://img.zrp.cool/2021/12/25/f0d37d9086022.png",
                         "https://img.zrp.cool/2021/12/25/3dd8f71d65834.jpg",
                         "https://img.zrp.cool/2021/12/25/b693babfdeb5c.jpg",
                         "https://img.zrp.cool/2021/12/25/b3fc93d9559e2.jpg"),


                       arrayListOf(     "经典星品体验装",
                           "权限限定版神仙水-红色",
                           "SK-II倪妮心选晶透套装",
                           "SK-II汤唯心选奢宠套装",)



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "海蓝之谜修护精萃水补水保湿提亮修护紧致精华水",
                        830.00,
                        0,
                       arrayListOf("https://img.zrp.cool/2021/12/25/ad5e5f9869749.png",
                           "https://img.zrp.cool/2021/12/25/c4b03722756bf.jpg",
                           "https://img.zrp.cool/2021/12/25/5c4407a91790d.jpg",
                           "https://img.zrp.cool/2021/12/25/aaeccd38a10ce.jpg",
                           "https://img.zrp.cool/2021/12/25/cd9c484ef2bfc.jpg",
                           "https://img.zrp.cool/2021/12/25/2703f766e4d2f.jpg"),


                      arrayListOf("100ml",
                          "150ml",
                          "200ml",
                          "250ml",
                      )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "兰蔻小黑瓶发光眼霜",
                        530.00,
                        0,
                       arrayListOf("https://img.zrp.cool/2021/12/25/aae5b5f2a632f.png",
                           "https://img.zrp.cool/2021/12/25/27f15b5af20cd.png",
                           "https://img.zrp.cool/2021/12/25/f17ffe4c1ed40.png",
                           "https://img.zrp.cool/2021/12/25/ec9d2f1568cb6.png",
                           "https://img.zrp.cool/2021/12/25/113b71fd71a7a.png",
                           "https://img.zrp.cool/2021/12/25/113b71fd71a7a.png"),


                        arrayListOf(
                            "100ml",
                            "150ml",
                            "200ml",
                            "250ml"
                        )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "IPSA茵芙莎流金水",
                        350.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/160948dc3898c.jpg",
                            "https://img.zrp.cool/2021/12/25/547cb22b681f4.jpg",
                            "https://img.zrp.cool/2021/12/25/578b86f3b5f06.jpg",
                            "https://img.zrp.cool/2021/12/25/33d48a24bc3bb.jpg",
                            "https://img.zrp.cool/2021/12/25/d0c4393e896e4.jpg",
                            "https://img.zrp.cool/2021/12/25/d0c4393e896e4.jpg"),


                       arrayListOf(
                           "100ml",
                           "200ml",
                           "300ml",
                           "500ml",
                       )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "丝芙兰雅诗兰黛第七代小棕瓶精华特润修护精华露",
                        660.00,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/76598ba81d9a0.png",
                            "https://img.zrp.cool/2021/12/25/ce8f2884f89c2.jpg",
                            "https://img.zrp.cool/2021/12/25/023c86e84ed8f.jpg",
                            "https://img.zrp.cool/2021/12/25/792b354b2f36b.jpg",
                            "https://img.zrp.cool/2021/12/25/2976cfed34494.jpg",
                            "https://img.zrp.cool/2021/12/25/76598ba81d9a0.png"
                        ),


                      arrayListOf(   "20ml",
                          "30ml",
                          "50ml",
                          "70ml",)



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        6,
                        "科颜氏淡斑精华液",
                        540.00,
                        0,
                        arrayListOf("https://img.zrp.cool/2021/12/25/bd42836754d15.jpg",
                            "https://img.zrp.cool/2021/12/25/bb5e1f4fcf1a7.jpg",
                            "https://img.zrp.cool/2021/12/25/35eea3fdca381.jpg",
                            "https://img.zrp.cool/2021/12/25/0b3a13892c0b9.jpg",
                            "https://img.zrp.cool/2021/12/25/3c239d78df403.png",
                            "https://img.zrp.cool/2021/12/25/9d59112cdfb49.png",
                        ),

                       arrayListOf(
                           "20ml",
                           "30ml",
                           "50ml",
                           "100ml"
                       )






//                    )
//                )

            ),
        )
    )


    val nail by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "【美潮美甲工具套装全套初学者家用开店专用做指甲油胶专业光疗机灯】",
                        129.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/24/gG2cTjEkpB3lFra.jpg",
                            "https://s2.loli.net/2021/12/24/gG2cTjEkpB3lFra.jpg",
                            "https://s2.loli.net/2021/12/24/1GEUJVfuobgtTPe.jpg",
                            "https://s2.loli.net/2021/12/24/O15HvgkaQ4DEJSC.jpg",
                            "https://s2.loli.net/2021/12/24/fASOYu5GniVULyT.jpg",
                            "https://s2.loli.net/2021/12/24/1c4HEmfosz3qbGB.jpg",
                        ),


                      arrayListOf(
                          "美甲套装4色可选配美甲工具包-白色灯",
                          "美甲套装6色可选配美甲工具包-白色灯",
                          "美甲套装8色可选配美甲工具包-白色灯",
                          "美甲套装10色可选配美甲工具包-白色灯",
                      )




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "网红款固态三色甲油胶2021年新款日式罐装固体奶油胶套装美甲专用",
                        6.4,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/gJzKmrc4nZxpIOk.jpg",
                            "https://s2.loli.net/2021/12/25/gJzKmrc4nZxpIOk.jpg",
                            "https://s2.loli.net/2021/12/25/xdac9fRbtOYhyC3.jpg",
                            "https://s2.loli.net/2021/12/25/BOLKNICDUwYzyiA.jpg",
                            "https://s2.loli.net/2021/12/25/efO1Q7tGIkdYzbT.jpg",
                            "https://s2.loli.net/2021/12/25/lk4TtcvrXponBdy.jpg" ,    ),


                       arrayListOf(   "烟灰蓝+焦糖色+枯黄色",
                           "妖蓝色+雾霾焦糖+果冻焦黄",
                           "枫橘色+兰溪黄+青提慕斯",
                           "鲸鱼蓝+喜之蓝+箔银闪钻",)



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "KaSi美甲光疗灯迷你美甲灯烤指甲油胶专用小型家用速干光疗机蛋灯",
                        12.8,
                        0,
                      arrayListOf(
                          "https://s2.loli.net/2021/12/25/bt8SW6GEVNezr3k.jpg",
                          "https://s2.loli.net/2021/12/25/bt8SW6GEVNezr3k.jpg",
                          "https://s2.loli.net/2021/12/25/Esuwz8oyemNL45S.jpg",
                          "https://s2.loli.net/2021/12/25/jzabBgMN1IFA6uV.jpg",
                          "https://s2.loli.net/2021/12/25/5tfTUVerqSpCN3E.jpg",
                          "https://s2.loli.net/2021/12/25/sUQ2LN7TfZGjpkH.jpg",
                      ),


                       arrayListOf(
                           "3W萌趣QQ蛋+安卓电源线",
                           "3W柴犬00蛋【不带数据线】",
                           "3W柴犬QQ蛋+安卓电源线",
                           "5W萌趣恐龙蛋【不带数据线】",
                       )





//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "奶油蛋糕蝴蝶结酒红磨砂短款甲片假指甲贴片美甲成品拆卸穿戴式",
                        24.5,
                        0,
                      arrayListOf("https://s2.loli.net/2021/12/25/4clnQ9dCx7NVZwU.jpg",
                          "https://s2.loli.net/2021/12/25/4clnQ9dCx7NVZwU.jpg",
                          "https://s2.loli.net/2021/12/25/WT7mlgbNxckJzfS.jpg",
                          "https://s2.loli.net/2021/12/25/Q7uDH6LwCpgbUqN.jpg",
                          "https://s2.loli.net/2021/12/25/7BPtVfu8eMFQxLR.jpg",
                          "https://s2.loli.net/2021/12/25/8ly2463t9prevAi.jpg",),




                       arrayListOf( "AG61",
                           "AG72",
                           "AG68",
                           "AG65",
                       )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "12色固态奶油胶眼影盘日式固体甲油胶秋冬显白流行色美甲工具套装",
                        14.5,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/ZeUsrGkgyjumLAl.jpg",
                            "https://s2.loli.net/2021/12/25/ZeUsrGkgyjumLAl.jpg",
                            "https://s2.loli.net/2021/12/25/X97u3ZqiP2QUDRF.jpg",
                            "https://s2.loli.net/2021/12/25/a6kRoAvBNX3OSFL.jpg",
                            "https://s2.loli.net/2021/12/25/C4f2qWnlASDo9bO.jpg",
                            "https://s2.loli.net/2021/12/25/XsxveaM2JNlBUVi.jpg",),


                        arrayListOf(   "12宫格优色固态盘系列1-日光粉钻",
                            "12宫格优色固态盘系列2-焦糖栗子",
                            "12宫格优色固态盘系列3-千禧红",
                            "12宫格优色固态盘系列4-茶沐羽灰",
                        )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        6,
                        "美甲笔刷套装日式万能光疗彩绘拉线画花晕染渐变专业工具刷子全套",
                        19.8,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/sJ48SnR7VIyPqib.jpg",
                            "https://s2.loli.net/2021/12/25/sJ48SnR7VIyPqib.jpg",
                            "https://s2.loli.net/2021/12/25/TKCVA2qJcUEvzbl.jpg",
                            "https://s2.loli.net/2021/12/25/PGLDmaSgB5Kp7Eu.jpg",
                            "https://s2.loli.net/2021/12/25/cJ9EuwhngCbQda5.jpg",
                            "https://s2.loli.net/2021/12/25/VBbtJqWMu4wsZK5.jpg",),


                     arrayListOf(  "美甲笔刷套刷8件套-斑马色",
                         "珍珠白15只装",
                         "少女粉15只装",
                         "静谧黑15只装 ",)



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        7,
                        "小檬16色油画大麦日式固态罐装美甲眼影盘甲油胶摩卡蜜桃小套",
                        23.5,
                        0,
                        arrayListOf("https://s2.loli.net/2021/12/25/RikohtF39OmeGUc.jpg",
                            "https://s2.loli.net/2021/12/25/RikohtF39OmeGUc.jpg",
                            "https://s2.loli.net/2021/12/25/HywhGvWcqJDEL6p.jpg",
                            "https://s2.loli.net/2021/12/25/Z2l38vk4bYw5rGL.jpg",
                            "https://s2.loli.net/2021/12/25/jkmaTrt17XIiFJp.jpg",
                            "https://s2.loli.net/2021/12/25/O8H6UvaAjNwbGKW.jpg",),


                        arrayListOf(  "油画大麦(送光疗圆头笔)",
                            "摩卡蜜桃(送光疗圆头笔)",
                            "晨露玫瑰(送光疗圆头笔)",
                            "可可慕斯(送光疗圆头笔)",)




//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        8,
                        "OLiiii一井豚指甲贴片美甲成品穿戴式美甲贴甲片女成品",
                        12.95,
                        0,
                       arrayListOf( "https://s2.loli.net/2021/12/25/HmQFqhelDI8EA7c.jpg",
                           "https://s2.loli.net/2021/12/25/HmQFqhelDI8EA7c.jpg",
                           "https://s2.loli.net/2021/12/25/eTV53XL72KsabQF.jpg",
                           "https://s2.loli.net/2021/12/25/nkP5Wp4Bdf8r19Z.jpg",
                           "https://s2.loli.net/2021/12/25/R9tvQKT2Pp7CLJj.jpg",
                           "https://s2.loli.net/2021/12/25/PIjR9s3MCAByoS8.jpg",)                        ,
                        arrayListOf(
                            "303马蒂斯",
                            "304珍珠少女",
                            "305落日橘光",
                            "306阳光少女",
                        )



//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        9,
                        "KaSi日式固态指甲油胶2021年新款罐装小布胶奶油彩绘胶美甲店专用",
                        7.8,
                        0,
                      arrayListOf("https://s2.loli.net/2021/12/25/EBLYFo7iDXJk4fV.jpg",
                          "https://s2.loli.net/2021/12/25/EBLYFo7iDXJk4fV.jpg",
                          "https://s2.loli.net/2021/12/25/pl8MTzqGocXUvZ1.jpg",
                          "https://s2.loli.net/2021/12/25/yKAqG3uZTeVivkL.jpg",
                          "https://s2.loli.net/2021/12/25/THGja3dzZ5mEJvY.jpg",
                          "https://s2.loli.net/2021/12/25/i1WuZBUEIsywOat.jpg",)

                        ,
                                arrayListOf(
                            "DG030",
                            "DG052",
                            "DG001",
                            "DG002",
                    )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        10,
                        "指甲贴纸成品全贴贴片持久网红韩国可爱女人小清新女美甲贴纸饰品",
                        5.66,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/25/H4KR67eSxDwb58T.jpg",
                            "https://s2.loli.net/2021/12/25/H4KR67eSxDwb58T.jpg",
                            "https://s2.loli.net/2021/12/25/TVPd4ZAW3fCIorj.jpg",
                            "https://s2.loli.net/2021/12/25/zVyYAeNvjX8tU3D.jpg",
                            "https://s2.loli.net/2021/12/25/kim6cnaRUqgFdHD.jpg",
                            "https://s2.loli.net/2021/12/25/e5MkHaBF3tPicK7.jpg",
                        ),
                        arrayListOf(
                            "浅紫色DA301",
                            "蓝色 DA302",
                            "藏青色DA303",
                            "乳白色DA304",
                        )



//                    )
//                )

            ),
        )
    )

    val Beautiful_pupils by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "[正式开抢]moody美瞳日抛猫眼小情绪彩色隐形眼镜近视萌宠",
                        99.0,
                        0,
                        arrayListOf("https://img.zrp.cool/2021/12/25/995f77b972f64.jpg",
                            "https://img.zrp.cool/2021/12/25/995f77b972f64.jpg",
                            "https://img.zrp.cool/2021/12/25/1dcce0c340af9.jpg",
                            "https://img.zrp.cool/2021/12/25/998d43d9dd188.jpg",
                            "https://img.zrp.cool/2021/12/25/2e8c7eafa1ecf.jpg",
                            "https://img.zrp.cool/2021/12/25/f58677a0dd256.jpg",),
                        arrayListOf(
                            "#新花色#无语紫【可盐可奶灰紫色】",
                            "#新花色#神秘绿【微混血扩瞳猫眼绿】",
                            "无辜棕【日常百搭灰褐系】",
                            "高冷灰【混血灰清冷明眸】"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "POP元气小光环美瞳日抛女10片隐形近视眼镜旗舰店非半年抛月抛盒",
                        79.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/225f91de193f1.jpg",
                            "https://img.zrp.cool/2021/12/25/225f91de193f1.jpg",
                            "https://img.zrp.cool/2021/12/25/85864a0ac5500.jpg",
                            "https://img.zrp.cool/2021/12/25/8e5c35709d2d0.jpg",
                            "https://img.zrp.cool/2021/12/25/37cbd89e1495a.jpg",
                            "https://img.zrp.cool/2021/12/25/b58c0533902df.jpg",
                        ),
                        arrayListOf(

                            "星野灰蓝【元气小光环，冰川蓝瞳妆同款，14.2直径】",
                            "水光粉棕【元气小光环，14.2直径】",
                            "好甜鸭灰【小黄鸭联名款，141直径】",
                            "好甜鸭棕【小黄鸭联名款，14.1直径】"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "日本seed实瞳幻樱美瞳女日抛10片小直径近视隐形眼镜视客旗舰正品",
                        68.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/ff87dedc41aaf.jpg",
                            "https://img.zrp.cool/2021/12/25/ff87dedc41aaf.jpg",
                            "https://img.zrp.cool/2021/12/25/25271d5847878.jpg",
                            "https://img.zrp.cool/2021/12/25/73bb42c4e1db7.jpg",
                            "https://img.zrp.cool/2021/12/25/3ead2adf3d021.jpg",
                            "https://img.zrp.cool/2021/12/25/58273b9ef4083.jpg",
                        ),
                       arrayListOf(
                           "新上架-茶卡蓝",
                           "新上架-冰莓粉",
                           "新上架-冥想月光",
                           "新花色-茶糖棕"
                       )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "海俪恩美瞳日抛萌宠10片小直径隐形近视眼镜旗舰官网正品非半年抛",
                        59.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/d58355ec8cf11.jpg",
                            "https://img.zrp.cool/2021/12/25/d58355ec8cf11.jpg",
                            "https://img.zrp.cool/2021/12/25/bc8c67a1fefc8.jpg",
                            "https://img.zrp.cool/2021/12/25/7f62c4114d8d0.jpg",
                            "https://img.zrp.cool/2021/12/25/879e756dec822.jpg",
                            "https://img.zrp.cool/2021/12/25/b35093a400ec0.jpg",
                        ),
                        arrayListOf(
                            "小皇棕#罗小黑联名",
                            "小黑蓝#罗小黑联名",
                            "比丢棕#罗小黑联名",
                            "喵呜绿#罗小黑联名"
                        )

//                    )
//                )

            ),

        )
    )

    val remover by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "KT且初卸妆膏 深层清洁脸部温和土豆泥卸妆油乳女正品官方KIMTRUE",
                        99.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/fbc0fbd30cc62.jpg",
                            "https://img.zrp.cool/2021/12/25/fbc0fbd30cc62.jpg",
                            "https://img.zrp.cool/2021/12/25/1d421aeea00a5.jpg",
                            "https://img.zrp.cool/2021/12/25/7fbf0d53d3db5.jpg",
                            "https://img.zrp.cool/2021/12/25/df64cca81c3a8.jpg",
                            "https://img.zrp.cool/2021/12/25/6bd6db94756be.jpg",
                        ),
                        arrayListOf(
                            "镇店爆款卸妆膏-拍此链接 ￥99",
                            "眼唇部卸妆液-拍此链接 ￥49",
                            "卸妆油-拍此链接 ￥109",
                            "卸妆膏囤货礼盒-拍此链接 ￥259"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "【国内现货】Nursery娜斯丽进口柚子卸妆乳温和洁面敏感肌卸妆膏",
                        65.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/d32ddeedcf92d.jpg",
                            "https://img.zrp.cool/2021/12/25/d32ddeedcf92d.jpg",
                            "https://img.zrp.cool/2021/12/25/824427e0244b7.jpg",
                            "https://img.zrp.cool/2021/12/25/f2a92dd8af4b6.jpg",
                            "https://img.zrp.cool/2021/12/25/d8b15263d0824.jpg",
                            "https://img.zrp.cool/2021/12/25/07bdc8ec90eb9.jpg",
                        ),
                        arrayListOf(
                            "85ml",
                            "180ml",
                            "500ml",
                            "700ml"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "美宝莲纽约眼唇卸妆液卸妆水三合一温和深层清洁卸妆油女敏感肌",
                        29.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/5d6674f85aaef.jpg",
                            "https://img.zrp.cool/2021/12/25/5d6674f85aaef.jpg",
                            "https://img.zrp.cool/2021/12/25/b5b9b34982ef7.jpg",
                            "https://img.zrp.cool/2021/12/25/6de2f6ca0ae01.jpg",
                            "https://img.zrp.cool/2021/12/25/17dcc0eaf5354.jpg",
                            "https://img.zrp.cool/2021/12/25/53b949adaef17.jpg",

                        ),
                        arrayListOf(

                            "150ml",
                            "70ml",
                            "50ml",
                            "30ml"
                        ),

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "逐本森韵清欢晨蜜自在天然植物卸妆油敏感肌脸部深层清洁卸妆水",
                        188.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/2ccffaa7dc378.jpg",
                            "https://img.zrp.cool/2021/12/25/2ccffaa7dc378.jpg",
                            "https://img.zrp.cool/2021/12/25/2f87cb9eae82c.jpg",
                            "https://img.zrp.cool/2021/12/25/06abedab48fac.jpg",
                            "https://img.zrp.cool/2021/12/25/ad4ebf5bf6d94.jpg",
                            "https://img.zrp.cool/2021/12/25/1e71ea4e22822.jpg",
                        ),
                        arrayListOf(
                            "150ml",
                            "151ml",
                            "152ml",
                            "153ml"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "Nursery娜斯丽柚子卸妆啫喱深层清洁柚子卸妆膏温和卸妆乳女300ml",
                        148.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/68bab953c72c6.jpg",
                            "https://img.zrp.cool/2021/12/25/68bab953c72c6.jpg",
                            "https://img.zrp.cool/2021/12/25/2cc27ad535c4e.jpg",
                            "https://img.zrp.cool/2021/12/25/9c397ea99dce3.jpg",
                            "https://img.zrp.cool/2021/12/25/cb8e58e37d4ca.jpg",
                            "https://img.zrp.cool/2021/12/25/f65f334bec5cf.jpg",
                        ),
                        arrayListOf(
                            "【全肤质】柚子卸妆乳",
                            "【干皮保湿】西柚卸妆乳",
                            "【控油系列】柠檬卸妆乳",
                            "【提亮肤色】精油卸妆膏"
                        )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        6,
                        "王一博同款植村秀明星琥珀臻萃洁颜油强韧养肤深层清洁卸妆油正品",
                        390.0,
                        0,
                        arrayListOf(
                            "https://img.zrp.cool/2021/12/25/6141cdfdbc76a.jpg",
                            "https://img.zrp.cool/2021/12/25/6141cdfdbc76a.jpg",
                            "https://img.zrp.cool/2021/12/25/b3981ffe4b5ca.jpg",
                            "https://img.zrp.cool/2021/12/25/9f3daa5891a12.jpg",
                            "https://img.zrp.cool/2021/12/25/f1149fd690c1e.jpg",
                            "https://img.zrp.cool/2021/12/25/48aecc4fe25f0.jpg",
                        ),
                        arrayListOf(
                            "150ml",
                            "250ml",
                            "350ml",
                            "450ml"
                        )


//                    )
//                )

            ),
            )
    )

    //精选商品
    val featured by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        1,
                        "【立即付定】3CE九宫格眼影南瓜珠光奶茶盘哑光透明酒神盘圣诞礼",
                        230.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/24/3Yk8S1msPfo29je.jpg",
                            "https://s2.loli.net/2021/12/24/3Yk8S1msPfo29je.jpg",
                            "https://s2.loli.net/2021/12/24/iwzUfRXMBo7V1AC.jpg",
                            "https://s2.loli.net/2021/12/24/trExKUJdkQyXFzn.jpg",
                            "https://s2.loli.net/2021/12/24/s2dcXBQZEhOzmIY.jpg",
                            "https://s2.loli.net/2021/12/24/7rihHp2kXsJbnwt.jpg",
                        ),
                        arrayListOf(
                            "【1M限定版】 IN THE MOST 酒神盘",
                            "【1M限定版】# SOME DEF 【芋泥盘】",
                            "【明星爆款】# OVERTAKE 【橘棕盘】",
                            "【热卖色】# SMOOTHER 【深棕哑光盘】"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        2,
                        "【圣诞礼物】 Dior 迪奥锁妆凝脂恒久气垫粉底控油持久遮瑕 SPF",
                        350.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/27/LYziaNynRxFPtw1.jpg",
                           "https://s2.loli.net/2021/12/27/rsS9bcC2fBaLTWl.jpg",
                                "https://s2.loli.net/2021/12/27/3hjmHPBa5U8ZQTg.jpg",
                                "https://s2.loli.net/2021/12/27/GOr7c5hWsMHZt4e.jpg",
                                "https://s2.loli.net/2021/12/27/AKcX7BFVMUmIr2H.jpg",
                                "https://s2.loli.net/2021/12/27/hgBA1Ptm6uGrxNw.jpg"
                        ),
                        arrayListOf(

                            "ON",
                            "1N",
                            "1CR",
                            "2N"
                        )
//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(3,
                        "【圣诞礼物】 Dior 迪奥花秘瑰萃玫瑰微凝珠精华水气泡水保湿",
                        880.0,
                        0,
                        arrayListOf(

                            "https://s2.loli.net/2021/12/24/yCKSlDQJxrvj5cX.jpg",
                            "https://s2.loli.net/2021/12/24/yCKSlDQJxrvj5cX.jpg",
                            "https://s2.loli.net/2021/12/24/KNvsEqmLafwOiJ6.jpg",
                            "https://s2.loli.net/2021/12/24/Yiq4jQAnedS9azD.jpg",
                            "https://s2.loli.net/2021/12/24/cLypBqaoRCu9heT.jpg",
                            "https://s2.loli.net/2021/12/24/hJ1Aa9XOyrlgSme.jpg",
                        ),
                        arrayListOf(
                            "花秘瑰萃玫瑰微凝珠精华水",
                            "花秘瑰萃气泡水",

                        )
//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        4,
                        "【迷你套装】DIOR迪奥21圣诞限量口红999/772/824/100小样4支礼盒",
                        368.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/24/1AKvtp7GLuWEs2a.jpg",
                            "https://s2.loli.net/2021/12/24/1AKvtp7GLuWEs2a.jpg",
                            "https://s2.loli.net/2021/12/24/XsxRUbFyTWnd7fO.jpg",
                            "https://s2.loli.net/2021/12/24/5pG7n4BJMFyXLj1.jpg",
                            "https://s2.loli.net/2021/12/25/49PY6EjFGfxn5LA.jpg",
                            "https://s2.loli.net/2021/12/25/2vHVRIFXou4PeOG.jpg",
                        ),
                        arrayListOf(
                            "M01",
                            "M02",
                            "M03",
                            "M04"
                        )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        5,
                        "【顺丰速达】完美日记小细跟口红皮箱礼盒周迅口红哑光圣诞礼物",
                        689.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/24/dBw7Rsk3UhMZlJ6.jpg",
                            "https://s2.loli.net/2021/12/24/dBw7Rsk3UhMZlJ6.jpg",
                            "https://s2.loli.net/2021/12/24/SI8ZbNEsHmyrkw7.jpg",
                            "https://s2.loli.net/2021/12/24/fSur5BXW2VFJboy.jpg",
                            "https://s2.loli.net/2021/12/24/WILscO4avVNJqUj.jpg",
                            "https://s2.loli.net/2021/12/24/LxunJcyBROsqpgT.jpg",
                        ),
                        arrayListOf( "小细跟口红皮箱礼盒(经典版)",
                            "小细跟口红皮箱礼盒(永生花宠爱限定版)",
                            "小细跟口红皮箱礼盒(永生花挚爱高定版)",
                            "经典版（口红+眼影）"),


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
                    detail(
                        6,
                        "[正式开抢]经典畅销款moody美瞳日抛10片装大小直径彩色隐形眼镜",
                        89.0,
                        0,
                        arrayListOf(
                            "https://s2.loli.net/2021/12/24/1imWK8jnguPFJXO.jpg",
                            "https://s2.loli.net/2021/12/24/1imWK8jnguPFJXO.jpg",
                            "https://s2.loli.net/2021/12/24/wOkoKh6LX3R89EA.jpg",
                            "https://s2.loli.net/2021/12/24/d32TnXEUzNqwA4B.jpg",
                            "https://s2.loli.net/2021/12/24/3B9TFbxQXdVlmqE.jpg",
                            "https://s2.loli.net/2021/12/24/j1ObLF2uWXesHzm.jpg",
                        ),
                        arrayListOf(
                            "伽罗棕【热卖-百搭拿铁棕系】",
                            "#年度新花色#胶片棕【自然温柔棕褐系】",
                            "蜜糖棕【热卖-高光暖棕系】",
                            "勿扰灰【热卖-日常高级灰感】"
                        )


//                    )
//                )

            ),
        )
    )


    val dizhuang by mutableStateOf(
        listOf(
//            product_detailData(
//                mutableStateListOf(
            detail(
                1,
                "【圣诞礼物】Armani/阿玛尼权力无痕持妆粉底液权利轻薄控油遮瑕",
                600.00,
                0,
                arrayListOf(
                    "https://s2.loli.net/2021/12/25/ZnzUOfF6RAbSXpD.jpg",
                    "https://s2.loli.net/2021/12/25/EIa7pUh5N1cutoR.jpg",
                    "https://s2.loli.net/2021/12/25/8XoAxq2TpJZnklS.jpg",
                    "https://s2.loli.net/2021/12/25/6BbuDJL2APpYE9z.jpg",
                    "https://s2.loli.net/2021/12/25/sWXMLPOpKcEu6NB.jpg",
                    "https://s2.loli.net/2021/12/25/ZnzUOfF6RAbSXpD.jpg",
                ),
                arrayListOf(
                    "1.5",
                    "2",
                    "3",
                    "3.5"
                )

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
            detail(
                2,
                "YSL圣罗兰明彩精萃水粉霜 超模精华粉底霜滋润干皮持久遮瑕服帖",
                630.00,
                0,
                arrayListOf(
                    "https://s2.loli.net/2021/12/25/q8DG7zFpMAkvCNy.jpg",
                    "https://s2.loli.net/2021/12/25/1V7jJrxP5uLTo2m.jpg",
                    "https://s2.loli.net/2021/12/25/LlrmzbPNAk8UXBG.jpg",
                    "https://s2.loli.net/2021/12/25/Z6YxmrzkShiEG1P.jpg",
                    "https://s2.loli.net/2021/12/25/BbWYJmirS8xL1fh.jpg",
                    "https://s2.loli.net/2021/12/25/q8DG7zFpMAkvCNy.jpg",
                ),
                arrayListOf(
                    "B10",
                    "B20",
                    "B25",
                    "B30"
                )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
            detail(3,
                "【圣诞礼物】兰蔻菁纯粉底液 秋冬滋润养肤遮瑕 持久控油底妆自然",
                950.00,
                0,
                arrayListOf(
                    "https://s2.loli.net/2021/12/25/OIxjsv3XTzbyWr8.jpg",
                    "https://s2.loli.net/2021/12/25/OIxjsv3XTzbyWr8.jpg",
                    "https://s2.loli.net/2021/12/25/7DEWChKTpUFLkjq.jpg",
                    "https://s2.loli.net/2021/12/25/dezDYNf5HuZVJ7C.jpg",
                    "https://s2.loli.net/2021/12/25/OQA9e2aHBltcwTL.jpg",
                    "https://s2.loli.net/2021/12/25/OIxjsv3XTzbyWr8.jpg",

                    ),
                arrayListOf(

                    "100ml",
                    "110ml",
                    "120ml",
                    "130ml"
                ),

//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
            detail(
                4,
                "【圣诞礼物】Dior迪奥凝脂恒久亮泽粉底液 超长持妆 细腻水润",
                580.00,
                0,
                arrayListOf(
                    "https://s2.loli.net/2021/12/25/FuVfJgKHUDC9NmL.jpg",
                    "https://s2.loli.net/2021/12/25/b8LYM5Bi7U31vpI.jpg",
                    "https://s2.loli.net/2021/12/25/mEWSXokgG7w16HI.jpg",
                    "https://s2.loli.net/2021/12/25/Bj6osdUEuVMYitl.jpg",
                    "https://s2.loli.net/2021/12/25/uEM5aRNpSLzv7sA.jpg",
                    "https://s2.loli.net/2021/12/25/FuVfJgKHUDC9NmL.jpg",
                ),
                arrayListOf(
                    "0N",
                    "0.5N",
                    "1N",
                    "1.5N"
                )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
            detail(
                5,
                "植村秀新品小方瓶羽纱持妆粉底液控油自然遮瑕抗氧化持色",
                430.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/b33f24df9a7dc.jpg",
                    "https://img.zrp.cool/2021/12/25/4c6e6e1e1f3ac.jpg",
                    "https://img.zrp.cool/2021/12/25/921b975837cd1.jpg",
                    "https://img.zrp.cool/2021/12/25/b4d366683d579.jpg",
                    "https://img.zrp.cool/2021/12/25/6b9ccbef1d3d6.jpg",
                    "https://img.zrp.cool/2021/12/25/b33f24df9a7dc.jpg",
                ),
                arrayListOf(
                    "674",
                    "458",
                    "774",
                    "574"
                )


//                    )
//                )

            ),
//            product_detailData(
//                mutableStateListOf(
            detail(
                6,
                "【圣诞礼物】雅诗兰黛DW持妆粉底液 油皮亲妈持久不脱妆遮瑕防晒",
                410.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/fb2edf9984753.jpg",
                    "https://img.zrp.cool/2021/12/25/6c2c466af2506.jpg",
                    "https://img.zrp.cool/2021/12/25/f8de317b9dbaf.jpg",
                    "https://img.zrp.cool/2021/12/25/4698200b3d263.jpg",
                    "https://img.zrp.cool/2021/12/25/ca5d9d5f97f9e.jpg",
                    "https://img.zrp.cool/2021/12/25/fb2edf9984753.jpg",
                ),
                arrayListOf(
                    "2C0 自然色",
                    "1W1 象牙白",
                    "1C1 陶瓷白",
                    "2W0 柔沙色"
                )


//                    )
//                )

            ),

            detail(
                7,
                "【圣诞礼物】Givenchy纪梵希明星柔光粉底液 暗皮救星养肤不卡粉",
                530.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/9c0d05d207d7c.jpg",
                    "https://img.zrp.cool/2021/12/25/f052f87e49d83.jpg",
                    "https://img.zrp.cool/2021/12/25/b93df8e0df468.jpg",
                    "https://img.zrp.cool/2021/12/25/a1cc7fac01581.jpg",
                    "https://img.zrp.cool/2021/12/25/168d76d7fc21f.jpg",
                    "https://img.zrp.cool/2021/12/25/77a5abfb0e696.jpg",
                ),
                arrayListOf("N80",
                    "N95",
                    "1-W100",
                    "1-C105",
                )


//                    )
//                )

            ),

            detail(
                8,
                "【直播专享】MAC/魅可定制无瑕粉底液遮瑕保湿持久不脱妆 混油皮",
                340.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/50716d9cf5ad0.jpg",
                    "https://img.zrp.cool/2021/12/25/28196a0175301.jpg",
                    "https://img.zrp.cool/2021/12/25/fd449a54e5db0.jpg",
                    "https://img.zrp.cool/2021/12/25/bd48e624adcea.jpg",
                    "https://img.zrp.cool/2021/12/25/54538247954a8.jpg",
                    "https://img.zrp.cool/2021/12/25/2387521fdae21.jpg",
                ),
                arrayListOf(
                    "N12",
                    "N18",
                    "NC15",
                    "NC20"
                )


//                    )
//                )

            ),
            detail(
                9,
                "【圣诞礼物速达】CHANEL 香奈儿柔光持妆粉底液小磨方遮瑕控油",
                600.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/7b1470c5c7739.jpg",
                    "https://img.zrp.cool/2021/12/25/d1d11c59a988c.jpg",
                    "https://img.zrp.cool/2021/12/25/ec2ac22e79935.jpg",
                    "https://img.zrp.cool/2021/12/25/4c421135ae540.jpg",
                    "https://img.zrp.cool/2021/12/25/54e7830147d35.jpg",
                    "https://img.zrp.cool/2021/12/25/6ce9c7cfe07cc.jpg",
                ),
                arrayListOf(
                    "BD01",
                    "B10",
                    "BD11",
                    "BR12"
                )


//                    )
//                )

            ),
            detail(
                10,
                "【圣诞礼物】BOBBI BROWN芭比波朗虫草粉底液 持妆滋润 干皮粉底",
                620.00,
                0,
                arrayListOf(
                    "https://img.zrp.cool/2021/12/25/ec80428307ff3.jpg",
                    "https://img.zrp.cool/2021/12/25/55deb9d4a6a7c.jpg",
                    "https://img.zrp.cool/2021/12/25/ae17c8fbf204d.jpg",
                    "https://img.zrp.cool/2021/12/25/adbac96d56cdd.jpg",
                    "https://img.zrp.cool/2021/12/25/1a64263d676f3.jpg",
                    "https://img.zrp.cool/2021/12/25/8e6c75a4adf3e.jpg",
                ),
                arrayListOf(
                    "1",
                    "0",
                    "0.5",
                    "00"
                )


//                    )
//                )

            ),
        )
    )

    var currentList by mutableStateOf(kh)
    var featurelist by mutableStateOf(featured)
    var isFeature by mutableStateOf(false)
    var shopCar by mutableStateOf(0)
fun setChoose(storeid:Int){
    shopCar=storeid
}

    fun getChoose():detail{
        return currentList[shopCar]
    }

    fun changeCategory(newCatagory:String){
//        catagory = newCatagory

        if(newCatagory=="口红" )
            currentList = kh
        else if(newCatagory=="眼影")
            currentList = eye
        else if(newCatagory=="染发")
            currentList = hair
        else if(newCatagory=="护肤")
            currentList = hufu
        else if(newCatagory=="美甲")
            currentList = nail
        else if(newCatagory=="美瞳")
            currentList = Beautiful_pupils
        else if(newCatagory=="卸妆")
            currentList = remover
        else if(newCatagory=="底妆")
            currentList = dizhuang
        else
            currentList=featured

        Log.e(newCatagory, currentList[0].title)
    }
    fun getList():List<detail> {
        isFeature = false
        return currentList
    }
    var index by mutableStateOf(0)

    fun setId(id:Int){
        index=id-1
    }


    fun getFeature():List<detail> {
        isFeature = true;
        return featurelist
    }




    fun getItem(): detail{
        if(isFeature)
            return featurelist[index]
        else
            return currentList[index]
    }


}