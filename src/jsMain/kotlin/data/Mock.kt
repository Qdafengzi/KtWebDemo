package data

object Mock {

    private val list = mutableListOf<ContactList>()

    fun getContactList(): MutableList<ContactList> {
        list.add(ContactList("05/10", "head/ic_person_3.jpeg", "二娃", "听说你最近回老家了"))
        list.add(ContactList("05/10", "head/ic_person_1.jpg", "Lucas", "我要赶紧学习Compose了"))
        list.add(ContactList("05/9", "head/ic_group_1.png", "Compose学习群", "有什么推荐的学习Compose的方法吗？"))
        list.add(ContactList("05/9", "head/ic_person_6.jpeg", "潘子", "好"))
        list.add(ContactList("05/9", "head/ic_file_transform.png", "文件传输", "666"))
        list.add(ContactList("05/9", "head/ic_group_2.png", "相亲群", "昨天见到的小姐姐可漂亮了"))
        list.add(ContactList("05/8", "head/ic_person_2.jpeg", "小仙女", "你几点下班？"))
        list.add(ContactList("05/8", "head/ic_wechat.png", "微信团队", "[链接]登录操作通知"))
        list.add(ContactList("05/8", "head/ic_person_4.jpeg", "三姨", "啥时候来家里给你做好吃的"))
        list.add(ContactList("05/8", "head/ic_public_account.png", "微信公众号", "程序IT圈[链接]程序员为什么越来越卷？"))
        list.add(ContactList("05/6", "head/ic_person_5.jpeg", "大鹏", "我今天还有电影要拍"))

        return list
    }
}