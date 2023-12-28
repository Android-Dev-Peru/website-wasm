package models

sealed interface Element {
    data class Section(val title: String): Element
    data class Link(
        val title: String,
        val url: String,
        val icon: String? = null,
        val chevronVisible: Boolean = false
    ): Element
}

val elements: List<Element> = listOf(
    Element.Link(title = "Resultados de encuesta salarial", icon = "", url = "fasdfasfasfs"),
    Element.Link(title = "Llena la encuesta salarial aqui", icon = "", url = "fasdfasdf"),

    Element.Section(title = "Último meetup"),
    Element.Link(title = "Meetup #57 KMP stable", icon = "colored_youtube.png", url = "fasfas"),
    Element.Link(title = "Meetup #57", icon = "colored_twitter.png", url = "https://twitter.com/androiddevperu/status/1727862022287589605"),

    Element.Section(title = "Comunidad"),
    Element.Link(title = "Únete a nuestra comunidad en WhatsApp", icon = "colored_wsp", url = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm"),

    Element.Section(title = "Eventos pasados"),
    Element.Link(title = "Checa todo nuestro contenido posteado", icon = "", url = "https://dev.to/androiddevperu"),
    )