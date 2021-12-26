package com.example.makeupbeauty.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
                            "https://s2.loli.net/2021/12/24/uFkHI9ySnd4JRsr.jpg",
                            "https://s2.loli.net/2021/12/24/2Rx5okVvUSz4pye.jpg",
                            "https://s2.loli.net/2021/12/24/EYqdeBwjAsWxX5I.jpg",
                            "https://s2.loli.net/2021/12/24/xp1vsbtHYkJMeK7.jpg",
                            "https://s2.loli.net/2021/12/24/RMevXr1zEHW4xSY.jpg",
                            "https://s2.loli.net/2021/12/24/Qe4VB57cld3oNwu.jpg"
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
                            "https://s2.loli.net/2021/12/24/LaBkTejWXKiHGhA.jpg",
                            "https://s2.loli.net/2021/12/24/2iypWEx5uAPRHLm.jpg",
                            "https://s2.loli.net/2021/12/24/Za8OotWVAGuJLYH.jpg",
                            "https://s2.loli.net/2021/12/24/SgDK3ZAM9cLHqYm.jpg",
                            "https://s2.loli.net/2021/12/24/n9dyWiBNegTR3Ls.jpg",
                            "https://s2.loli.net/2021/12/24/jYHLG4kDaJCq3Nx.jpg"
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
                            "https://s2.loli.net/2021/12/24/lN4BALHePiYKhFO.jpg",
                            "https://s2.loli.net/2021/12/24/eFQJhibxKS2zsLC.jpg",
                            "https://s2.loli.net/2021/12/24/yrwIaiO3NeC2jWf.jpg",
                            "https://s2.loli.net/2021/12/24/MZWXAPl7yLDT5i6.jpg",
                            "https://s2.loli.net/2021/12/24/vp1CZxFNVLRoPeD.jpg",
                            "https://s2.loli.net/2021/12/24/1wHzxWLlTpGCYEJ.jpg"
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
                            "https://s2.loli.net/2021/12/24/uTkn1YxWaoVfU2A.jpg",
                            "https://s2.loli.net/2021/12/24/wUsKQdzutO6qWG5.jpg",
                            "https://s2.loli.net/2021/12/24/r7ZtG14uay9jWTf.jpg",
                            "https://s2.loli.net/2021/12/24/FvxmGuIqin4twkf.jpg",
                            "https://s2.loli.net/2021/12/24/fkpJPIzoxBWTlrd.jpg",
                            "https://s2.loli.net/2021/12/24/ZFhB29LO6EGwKsr.jpg"
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

                            "https://s2.loli.net/2021/12/24/rjCLZXo48QFgDPu.jpg",
                            "https://s2.loli.net/2021/12/24/sRFG1xWlqJp79U2.jpg",
                            "https://s2.loli.net/2021/12/24/nxp9hrYOgdGSVF1.jpg",
                            "https://s2.loli.net/2021/12/24/qV4axWg9Mk2cXIK.jpg",
                            "https://s2.loli.net/2021/12/24/GgVX84obOEtkDKL.jpg",
                            "https://s2.loli.net/2021/12/24/umpn6WCzlZfJGea.jpg"
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
                            "https://s2.loli.net/2021/12/24/p5KJPvmnM7eRXsi.jpg",
                            "https://s2.loli.net/2021/12/24/ItDJreNY3RCAFxl.jpg",
                            "https://s2.loli.net/2021/12/24/7NcQdFWYxjaSJUL.jpg",
                            "https://s2.loli.net/2021/12/24/qS1DMYbx8Ft3rvu.jpg",
                            "https://s2.loli.net/2021/12/24/WhapMTPCIoeYqN8.jpg",
                            "https://s2.loli.net/2021/12/24/vhWRJbAN1eZjqf8.jpg"
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
                            "https://s2.loli.net/2021/12/24/d75vgmAiLUPRXW8.jpg",
                            "https://s2.loli.net/2021/12/24/QjRJUHua4EesnBC.jpg",
                            "https://s2.loli.net/2021/12/24/MrHNPjZLSqD2wWE.jpg",
                            "https://s2.loli.net/2021/12/24/YLcpwzuU2RFhDO6.jpg",
                            "https://s2.loli.net/2021/12/24/Qi3Cs7x5V4aHMdO.jpg",
                            "https://s2.loli.net/2021/12/24/Mxwd7Hmp8O6Qeun.jpg"
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
                            "https://s2.loli.net/2021/12/24/AFHBYdUSiOlKJhf.jpg",
                            "https://s2.loli.net/2021/12/24/w6vLEQIuHlF9P2m.jpg",
                            "https://s2.loli.net/2021/12/24/7cI6kT9NUPVXL8v.jpg",
                            "https://s2.loli.net/2021/12/24/megHBh4xVUk7piz.jpg",
                            "https://s2.loli.net/2021/12/24/9G1NEfWeixw8IRX.jpg",
                            "https://s2.loli.net/2021/12/24/fW36TyoAqMUXFjb.jpg"
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
                            "https://s2.loli.net/2021/12/24/K7GStefuvlq3Xhy.jpg",
                            "https://s2.loli.net/2021/12/24/dAHi413LvYq7lpD.jpg",
                            "https://s2.loli.net/2021/12/24/3z2jLnYEPgbf58c.jpg",
                            "https://s2.loli.net/2021/12/24/U83winBfzJadlIv.jpg",
                            "https://s2.loli.net/2021/12/24/DWMs4qeFp5rzB1Q.jpg",
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
                            "https://s2.loli.net/2021/12/24/qQesElnjcyrzVOt.jpg",
                            "https://s2.loli.net/2021/12/24/5XWoEASs1fF9Bjt.jpg",
                            "https://s2.loli.net/2021/12/24/2QYj4vJIWlEwNr8.jpg",
                            "https://s2.loli.net/2021/12/24/4QOUE8kKoqagX91.jpg",
                            "https://s2.loli.net/2021/12/24/54UiGFPNm8p1aHJ.jpg",
                            "https://s2.loli.net/2021/12/24/nVJAGHDB13puolt.jpg"
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
                            "https://s2.loli.net/2021/12/24/ViWoGRcEQML8AZz.jpg",
                            "https://s2.loli.net/2021/12/24/CkJnEpsXFuhBSQY.jpg",
                            "https://s2.loli.net/2021/12/24/jNyQmDr6SO7pILu.jpg",
                            "https://s2.loli.net/2021/12/24/6xB3vQit7Clsp4D.jpg",
                            "https://s2.loli.net/2021/12/24/CGDfpgITdxcKLRN.jpg",
                            "https://s2.loli.net/2021/12/24/melxv2HJjtLK4IF.jpg"
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

                            "https://s2.loli.net/2021/12/24/jkaqpnYhZKETgIQ.jpg",
                            "https://s2.loli.net/2021/12/24/vjmFrBG7knKqHUD.jpg",
                            "https://s2.loli.net/2021/12/24/aUSljuLw2nbmpMh.jpg",
                            "https://s2.loli.net/2021/12/24/PzFghXTaMsdZK2e.jpg",
                            "https://s2.loli.net/2021/12/24/Fauf3oZj1WwdyEK.jpg",
                            "https://s2.loli.net/2021/12/24/hUa7yWv2zFgiQjY.jpg"
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
                            "https://s2.loli.net/2021/12/24/tRJVGnxq1KaEbkP.jpg",
                            "https://s2.loli.net/2021/12/24/c8pLe46XqTvfB5S.jpg",
                            "https://s2.loli.net/2021/12/24/ZAlTY4w5phrf1HD.jpg",
                            "https://s2.loli.net/2021/12/24/fp2MaAG4sQeyrzo.jpg",
                            "https://s2.loli.net/2021/12/24/nLM8Kk7xJTNf6Fy.jpg",
                            "https://s2.loli.net/2021/12/24/HQieAnUl2ZwtYfy.jpg"
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
                            "https://s2.loli.net/2021/12/24/YzlgoVS9nAQdXBp.jpg",
                            "https://s2.loli.net/2021/12/24/lSsHtM9BrGpiTwn.jpg",
                            "https://s2.loli.net/2021/12/24/7SDOXQ6ozWGyUKN.jpg",
                            "https://s2.loli.net/2021/12/24/gzxtR5o79FedCKS.jpg",
                            "https://s2.loli.net/2021/12/24/9ZvI2NWL6BTdAk7.jpg",
                            "https://s2.loli.net/2021/12/24/r2FBUVaemczS8Kn.jpg"
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
                            "https://s2.loli.net/2021/12/25/O5pXBoJAjkF2xHh.jpg",
                            "https://s2.loli.net/2021/12/25/O5pXBoJAjkF2xHh.jpg",
                            "https://s2.loli.net/2021/12/25/sQ2b5EHZyCYO7Tc.jpg",
                            "https://s2.loli.net/2021/12/25/fLnXFpRQH5y9143.jpg",
                            "https://s2.loli.net/2021/12/25/KQIoCjFv9OGDZBq.jpg",
                            "https://s2.loli.net/2021/12/25/lzQIwk6CSRZqBsp.jpg"
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
                            "https://s2.loli.net/2021/12/25/e5JCS14PATai9bp.jpg",
                            "https://s2.loli.net/2021/12/25/VAhxfLFHGs7SzIW.jpg",
                            "https://s2.loli.net/2021/12/25/FxIk376nNbHQcSB.jpg",
                            "https://s2.loli.net/2021/12/25/IcviewQLHJFPtDy.jpg",
                            "https://s2.loli.net/2021/12/25/kLHYgNvPKbz7Alu.jpg",
                            "https://s2.loli.net/2021/12/25/TcpFAPv2j8be1Gm.jpg"
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
                            "https://s2.loli.net/2021/12/25/7o1GsIziFBgRpvm.jpg",
                            "https://s2.loli.net/2021/12/25/62D4Gl8BF7cAVQZ.jpg",
                            "https://s2.loli.net/2021/12/25/oUeWhtwqCklMZuK.jpg",
                            "https://s2.loli.net/2021/12/25/WFIzjAqtNZRHaUd.jpg",
                            "https://s2.loli.net/2021/12/25/g8YmifJxvb4XLEs.jpg",
                            "https://s2.loli.net/2021/12/25/Q1SOC5Htk2eIrfV.jpg"
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

                            "https://s2.loli.net/2021/12/25/zUjWhRFwL5xerVf.jpg",
                            "https://s2.loli.net/2021/12/25/l6HL4QeSXGuogjO.jpg",
                            "https://s2.loli.net/2021/12/25/b4xZMhTP2Qzq8W6.jpg",
                            "https://s2.loli.net/2021/12/25/a7D9MZA3qLKFrC4.jpg",
                            "https://s2.loli.net/2021/12/25/Sq6Tev9swo7mxb3.jpg",
                            "https://s2.loli.net/2021/12/25/iWKHt7ufZ9ldvIc.jpg"
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
                            "https://s2.loli.net/2021/12/25/VTSNOxudzYsjMi3.jpg",
                            "https://s2.loli.net/2021/12/25/YDAa8bhk6HndUjv.jpg",
                            "https://s2.loli.net/2021/12/25/s985NMGidKr7eaF.jpg",
                            "https://s2.loli.net/2021/12/25/dtTWRx2HZrqsiwU.jpg",
                            "https://s2.loli.net/2021/12/25/lFzwVQMHJejri5u.jpg",
                            "https://s2.loli.net/2021/12/25/hgCpvLJb6Zm3Fd2.jpg"
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
                                "https://s2.loli.net/2021/12/25/XWrBAxvfEhbD5ka.jpg",
                                "https://s2.loli.net/2021/12/25/yrbdVRKcaMjAvFh.jpg",
                                "https://s2.loli.net/2021/12/25/6exn2WXAU5zT4pC.jpg",
                                "https://s2.loli.net/2021/12/25/V5mZFYRDgxrS2Pc.jpg",
                                "https://s2.loli.net/2021/12/25/4PhdtUaSiuHRqoK.jpg",
                                "https://s2.loli.net/2021/12/25/NqlZfQGzMwoDXv3.jpg"
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
                            "https://s2.loli.net/2021/12/25/kVDjsbTJEM2gCyn.jpg",
                            "https://s2.loli.net/2021/12/25/NTY7jRighqLk9CV.jpg",
                            "https://s2.loli.net/2021/12/25/n5GRUJfqy7mDiXu.jpg",
                            "https://s2.loli.net/2021/12/25/N2Z9Lonl3IdRcQx.jpg",
                            "https://s2.loli.net/2021/12/25/fiRzeMQoqUGCkPB.jpg",
                            "https://s2.loli.net/2021/12/25/rwPKFA2cQeW3LCd.jpg"
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
                            "https://s2.loli.net/2021/12/25/H8UtAziWP7GxZEQ.jpg",
                            "https://s2.loli.net/2021/12/25/g7vjiMyDJ8UFWC5.jpg",
                            "https://s2.loli.net/2021/12/25/8tyZa9Pg3AvDc4W.jpg",
                            "https://s2.loli.net/2021/12/25/wE9d1UsJShRMOA2.jpg",
                            "https://s2.loli.net/2021/12/25/SVdfwgqbPC1L6aR.jpg",
                            "https://s2.loli.net/2021/12/25/Qtjr7EydhTNwx6i.jpg"
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
                            "https://s2.loli.net/2021/12/25/iQGfUj3L9CkZVP8.jpg",
                            "https://s2.loli.net/2021/12/25/eQJdfp5LUBFxA6b.jpg",
                            "https://s2.loli.net/2021/12/25/95VHc6JpZgwq3lG.jpg",
                            "https://s2.loli.net/2021/12/25/l8EAx3KvGf7JD4R.jpg",
                            "https://s2.loli.net/2021/12/25/DCsec1nd7QjuFyZ.jpg",
                            "https://s2.loli.net/2021/12/25/yaNG6uXM5Zred2A.jpg"
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
                           "https://s2.loli.net/2021/12/25/XwjqNLvntTbV1fc.jpg",
                           "https://s2.loli.net/2021/12/25/APCEasv3nox9ZNG.jpg",
                           "https://s2.loli.net/2021/12/25/IjcYgeBNVEilH7v.jpg",
                           "https://s2.loli.net/2021/12/25/5uE7S6gMYTyL2Hl.jpg",
                           "https://s2.loli.net/2021/12/25/r1EXFDCbGZnJI5l.jpg",
                           "https://s2.loli.net/2021/12/25/mUGJdsnVeTvuOAQ.jpg"),

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
                           "https://s2.loli.net/2021/12/25/Lr2aiHYRgtF97Wm.jpg",
                           "https://s2.loli.net/2021/12/25/PdWoTylMOHUNjKY.jpg",
                           "https://s2.loli.net/2021/12/25/ckv5urDSJ1R97Po.jpg",
                           "https://s2.loli.net/2021/12/25/T1DqfNPhKWbAyXv.jpg",
                           "https://s2.loli.net/2021/12/25/V8vQKj4zciIoMGX.jpg",
                           "https://s2.loli.net/2021/12/25/AgohYpSRsZfD4Wi.jpg",
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

                          "https://s2.loli.net/2021/12/25/PxVfYjCmBMp3DhG.jpg",
                          "https://s2.loli.net/2021/12/25/ztlE3xhawFHspkN.jpg",
                          "https://s2.loli.net/2021/12/25/WSY1QMhf4xeNiR6.jpg",
                          "https://s2.loli.net/2021/12/25/mB5egTFsZy4XDVI.jpg",
                          "https://s2.loli.net/2021/12/25/tTO7y4LYzuGIXhK.jpg",
                          "https://s2.loli.net/2021/12/25/aOhXSgruqTnLElw.jpg"
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
                            "https://s2.loli.net/2021/12/24/3Yk8S1msPfo29je.jpg",
                            "https://s2.loli.net/2021/12/24/3Yk8S1msPfo29je.jpg",
                            "https://s2.loli.net/2021/12/24/iwzUfRXMBo7V1AC.jpg",
                            "https://s2.loli.net/2021/12/24/trExKUJdkQyXFzn.jpg",
                            "https://s2.loli.net/2021/12/24/s2dcXBQZEhOzmIY.jpg",
                            "https://s2.loli.net/2021/12/24/7rihHp2kXsJbnwt.jpg",
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

    fun changeCategory(newCatagory:String){
//        catagory = newCatagory
        if(newCatagory.equals("口红") )
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
    }
    fun getList():List<detail> {
        return currentList
    }
    var index by mutableStateOf(0)

    fun setId(id:Int){
        index=id-1
    }

    fun getItem(): detail{

        return currentList[index]
    }


}