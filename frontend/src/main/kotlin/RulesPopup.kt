import kotlinx.css.*
import kotlinx.html.js.*
import react.*
import react.dom.*
import styled.*

external interface RulesPopupProps : RProps {
    var close: () -> Unit
}

class RulesPopup : RComponent<RulesPopupProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css { +PopupStyles.wrapper }
            styledDiv {
                css { +PopupStyles.popup }
                styledDiv {
                    css { +PopupStyles.header }
                    styledH1 {
                        css { +PopupStyles.label }
                        +"Rules"
                    }
                    styledButton {
                        css {
                            +CommonStyles.iconButton
                            +CommonStyles.transparentButton
                            +PopupStyles.close
                        }
                        span("fas fa-times") {}
                        attrs {
                            onClickFunction = {
                                props.close()
                            }
                        }
                    }
                }
                styledDiv {
                    css { +PopupStyles.content }
                    p {
                        +"""You have to build a polygonal chain using the vertices of the
                            |grid, starting and ending at """.trimMargin()
                        span("fas fa-circle") {}
                        +""". Each segment should be a knight move, and they shouldn't intersect.
                            |The score is the number of segments in the polyline.
                            |Try to get the highest score!
                        """.trimMargin()
                    }
                    p {
                        +"""You can add a segment to your polyline by clicking the corresponding node.
                            |To delete several segments from the end, click the node of your chain, and
                            |it will become an end. An animated example is below:
                        """.trimMargin()
                    }
                    styledImg("example", "example.gif") {
                        css {
                            width = 200.px
                        }
                    }
                }
            }
        }
    }
}