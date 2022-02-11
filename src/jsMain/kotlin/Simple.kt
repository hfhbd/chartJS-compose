import org.jetbrains.compose.web.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

inline fun <T : Any> jso(): T =
    js("({})")

inline fun <T : Any> jso(builder: T.() -> Unit): T =
    jso<T>().apply(builder)

fun main() {
    Chart.register(
        ArcElement,
        LineElement,
        BarElement,
        PointElement,
        BarController,
        BubbleController,
        DoughnutController,
        LineController,
        PieController,
        PolarAreaController,
        RadarController,
        ScatterController,
        CategoryScale,
        LinearScale,
        LogarithmicScale,
        RadialLinearScale,
        TimeScale,
        TimeSeriesScale,
        Decimation,
        Filler,
        Legend,
        Title,
        Tooltip,
        SubTitle
    )
    renderComposableInBody {
        H1 {
            Text("Hello chart.js from Compose Web")
        }
        Div({
            style {
                height(400.px)
                width(400.px)
            }
        }) {
            Canvas({
                ref {
                    Chart(it, jso {
                        type = Type.bar
                        data = jso {
                            labels = arrayOf("Red", "Blue", "Yellow", "Green", "Purple", "Orange")
                            datasets = arrayOf(jso {
                                label = "# of Votes"
                                data = arrayOf(12, 19, 3, 5, 2, 3)
                                backgroundColor = arrayOf(
                                    "rgba(255, 99, 132, 0.2)",
                                    "rgba(54, 162, 235, 0.2)",
                                    "rgba(255, 206, 86, 0.2)",
                                    "rgba(75, 192, 192, 0.2)",
                                    "rgba(153, 102, 255, 0.2)",
                                    "rgba(255, 159, 64, 0.2)"
                                )
                                borderColor = arrayOf(
                                    "rgba(255, 99, 132, 1)",
                                    "rgba(54, 162, 235, 1)",
                                    "rgba(255, 206, 86, 1)",
                                    "rgba(75, 192, 192, 1)",
                                    "rgba(153, 102, 255, 1)",
                                    "rgba(255, 159, 64, 1)"
                                )
                                borderWidth = 1
                            })
                        }
                    })
                    onDispose { }
                }
            })
        }
    }
}
