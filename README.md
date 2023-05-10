使用kotlin Multiplatform web完成 ，只是想感受一下比现在流行的vue书写UI的差距。

先上图
![web微信截图](art/截图.png)
![web微信gif](art/动图.gif)
这里只是使用kotlin 写web的试用，感受一下标签的书写方式，最终的编译产物还是html和js 。

注意：kotlin Multiplatform web不能像app (android IOS) 和Desktop 一样可以共用一套代码，因为前端标签的书写方式还是沿用了html的书写方式。

使用gradle 在浏览器预览
![预览](art/gradle.png)
部分代码

```kotlin

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
```
总结：kotlin Multiplatform web 是把html带入了一个新纪元，kotlin基本已经无所不能了，服务器、 Android、 ios、 web 、Desktop，web还会支持webAssembly，虽然kotlin现在主要还是用在Android 开发上，不过他的优势让谷歌的后端开发已经开始使用kotlin了，据说谷歌有60%的后端开发人员已经开始用kotlin了。近期值得期待的是k2编译器 和 IOS方面的正式版本吧。