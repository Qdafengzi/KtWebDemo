import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import data.ContactList
import data.Mock
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                height(100.vh)
                background("#3333333")
            }
        }) {
            val contactList = Mock.getContactList()

            val clickItem = remember {
                mutableStateOf(contactList.first())
            }
            First()
            Second(contactList) {
                console.log("点击了第${it}个")
                clickItem.value = it
            }
            Third(clickItem.value)
        }
    }
}

@Composable
fun First() {
    Div(attrs = {
        style {
            width(50.px)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            background("#EAE9EC")
            alignItems(alignItems = AlignItems.Center)
            justifyContent(JustifyContent.SpaceBetween)
        }
    }) {

        Div(attrs = {
            style {
                width(50.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(alignItems = AlignItems.Center)
            }
        }) {
            Img(src = "image/ic_head.jpg", attrs = {
                style {
                    marginTop(50.px)
                    width(30.px)
                    height(30.px)
                    borderRadius(4.percent)
                }
            })

            Img(src = "image/ic_msg.svg", attrs = {
                style {
                    marginTop(40.px)
                    width(24.px)
                    height(24.px)
                    borderRadius(50.percent)
                }
            })

            Img(src = "image/ic_contact.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                }
            })

            Img(src = "image/ic_collection.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                    borderRadius(50.percent)
                }
            })
            Img(src = "image/ic_dir.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                }
            })

            Img(src = "image/ic_friends_circle.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                    borderRadius(50.percent)
                }
            })
        }



        Div(attrs = {
            style {
                width(50.px)
                marginBottom(20.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(alignItems = AlignItems.Center)
            }
        }) {
            Img(src = "image/ic_mini_program.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                    borderRadius(50.percent)
                }
            })

            Img(src = "image/ic_phone.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                    borderRadius(50.percent)
                }
            })

            Img(src = "image/ic_setting.svg", attrs = {
                style {
                    marginTop(20.px)
                    width(24.px)
                    height(24.px)
                }
            })
        }
    }
}

@Composable
fun Second(contactList: List<ContactList>, itemClick: (contactList: ContactList) -> Unit) {
    val clickIndex = remember { mutableStateOf(0) }

    Div(attrs = {
        style {
            width(300.px)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            background("#F7F7F7")
        }
    }) {
        Div(attrs = {
            style {
                marginTop(20.px)
                marginLeft(10.px)
                marginRight(10.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                alignItems(alignItems = AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
            }
        }) {

            Div(attrs = {
                style {
                    flex(1)
                    paddingLeft(10.px)
                    paddingRight(10.px)
                    paddingTop(4.px)
                    paddingBottom(4.px)
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    background("#EAEAEA")
                    alignItems(alignItems = AlignItems.Center)
                }
            }) {
                Img(src = "image/ic_search.svg", attrs = {
                    style {
                        width(24.px)
                        height(24.px)
                        marginRight(10.px)
                    }
                })

                Text("搜索")
            }

            Img(src = "image/ic_add.svg", attrs = {
                style {
                    padding(4.px)
                    marginLeft(4.px)
                    background("#EAEAEA")
                    width(24.px)
                    height(24.px)
                }
            })
        }
        //联系人和群

        Div(attrs = {
            style {
                height(10.px)
            }
        }) {
        }

        contactList.forEachIndexed { index, contactList ->
            Div(attrs = {
                onClick {
                    console.log("点击了第${index}个")
                    clickIndex.value = index
                    itemClick(contactList)
                }
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    paddingLeft(10.px)
                    paddingRight(10.px)
                    paddingTop(8.px)
                    paddingBottom(8.px)
                    fontSize(12.px)
                    background(if (index == clickIndex.value) "#DEDEDE" else "#00000000")
                }
            }) {
                Img(src = contactList.img, attrs = {
                    style {
                        width(36.px)
                        height(36.px)
                        borderRadius(4.percent)
                        marginRight(10.px)
                    }
                })

                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column)
                        justifyContent(JustifyContent.SpaceBetween)
                        flexWrap(FlexWrap.Wrap)
                        flex(1)
                    }
                }) {
                    Div(attrs = {
                        style {
                            width(100.percent)
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            justifyContent(JustifyContent.SpaceBetween)
                        }
                    }) {
                        Div(attrs = {
                            style {
                                flex(1)
                                fontSize(14.px)
                                color(Color.black)
                                fontStyle("bold")
                                overflow("hidden")
                            }
                        }) {
                            Text(contactList.name)
                        }

                        Div(attrs = {
                            style {
                                fontSize(10.px)
                                color(Color.gray)
                                fontStyle("bold")
                                overflow("hidden")
                            }
                        }) {
                            Text(contactList.time)
                        }
                    }

                    Div(attrs = {
                        style {
                            fontSize(12.px)
                            color(Color.lightgray)
                            fontStyle("bold")
                            overflow("hidden")
                        }
                    }) {
                        Text(contactList.fistContent)
                    }
                }
            }
        }
    }
}

@Composable
fun Third(contact: ContactList) {
    Div(attrs = {
        style {
            width(500.px)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            background("#F3F3F3")
        }
    }) {
        //头部的姓名
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                justifyContent(JustifyContent.SpaceBetween)
                paddingRight(10.px)
                paddingLeft(20.px)
                marginTop(20.px)
                paddingBottom(10.px)
            }
        }) {
            Div(attrs = {
                style {
                    fontSize(16.px)
                    color(Color.black)
                    fontStyle("medium")
                    overflow("hidden")
                }
            }) {
                Text(contact.name)
            }

            Img(src = "third/ic_more.svg", attrs = {
                style {
                    width(24.px)
                    height(24.px)
                }
            })
        }

        Div(attrs = {
            style {
                flex(3)
                border {
                    width(0.5.px)
                    style(LineStyle.Solid)
                    color(Color.lightgray)
                }
            }
        }) {

        }
        //图标
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                justifyContent(JustifyContent.SpaceBetween)
                paddingRight(10.px)
                paddingLeft(10.px)
                paddingTop(10.px)
                paddingBottom(10.px)
                border {
                    width(0.5.px)
                    style(LineStyle.Solid)
                    color(Color.lightgray)
                }
            }
        }) {
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                }
            }) {
                Img(src = "third/ic_emoji.svg", attrs = {
                    style {
                        paddingRight(10.px)
                        paddingLeft(10.px)
                        width(24.px)
                        height(24.px)
                    }
                })

                Img(src = "image/ic_dir.svg", attrs = {
                    style {
                        paddingRight(10.px)
                        paddingLeft(10.px)
                        width(24.px)
                        height(24.px)
                    }
                })

                Div(attrs = {
                    style {
                        paddingLeft(10.px)
                        paddingRight(10.px)
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Row)
                        alignItems(AlignItems.Center)
                    }
                }) {
                    Img(src = "third/cut.svg", attrs = {
                        style {
                            width(24.px)
                            height(24.px)
                        }
                    })
                    Img(src = "third/ic_arrow_down.svg", attrs = {
                        style {
                            marginLeft(4.px)
                            width(12.px)
                            height(12.px)
                        }
                    })
                }


                Img(src = "third/ic_message.svg", attrs = {
                    style {
                        paddingRight(10.px)
                        paddingLeft(10.px)
                        width(24.px)
                        height(24.px)
                    }
                })
            }

            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                }
            }) {
                Img(src = "third/ic_call.svg", attrs = {
                    style {
                        paddingRight(10.px)
                        paddingLeft(10.px)
                        width(24.px)
                        height(24.px)
                    }
                })

                Img(src = "third/ic_video.svg", attrs = {
                    style {
                        paddingRight(10.px)
                        paddingLeft(10.px)
                        width(24.px)
                        height(24.px)
                    }
                })
            }
        }
        Div(attrs = {
            style {
                flex(1)
                border {
                    width(0.5.px)
                    style(LineStyle.Solid)
                    color(Color.lightgray)
                }
            }
        }) {

        }
    }
}

