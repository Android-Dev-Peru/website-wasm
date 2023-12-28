package models


data class Social(
    val icon: String,
    val url: String,
)

val socials = listOf<Social>(
    Social("icon_youtube.xml", "https://www.youtube.com/@AndroidDevPeru"),
    Social("icon_x.xml", "https://twitter.com/androiddevperu"),
    Social("icon_ig.xml", "https://instagram.com/androiddevperu"),
    Social("icon_linkedin.xml", "https://www.linkedin.com/company/android-dev-peru"),
    Social("icon_github.xml", "https://github.com/Android-Dev-Peru"),
    Social("icon_tiktok.xml", "https://tiktok.com/androiddevperu"),
    Social("icon_web.xml", "https://tiktok.com/androiddevperu"),
    Social("icon_email.xml", "mailto:adevpe14@gmail.com"),
)