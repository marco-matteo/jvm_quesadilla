import tornadofx.*

class MainApp : App(MainView::class)

class MainView : View("File Search") {
    private val queryField = textfield()
}