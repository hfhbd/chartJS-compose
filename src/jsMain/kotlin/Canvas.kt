import androidx.compose.runtime.*
import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.*

fun AttrsBuilder<HTMLCanvasElement>.width(value: CSSSizeValue<out CSSUnitLengthOrPercentage>) =
    attr("width", value.toString())

fun AttrsBuilder<HTMLCanvasElement>.height(value: CSSSizeValue<out CSSUnitLengthOrPercentage>) =
    attr("height", value.toString())

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun Canvas(
    attrs: AttrBuilderContext<HTMLCanvasElement>,
    content: ContentBuilder<HTMLCanvasElement>? = null
) {
    TagElement(
        tagName = "canvas",
        applyAttrs = attrs,
        content = content
    )
}
