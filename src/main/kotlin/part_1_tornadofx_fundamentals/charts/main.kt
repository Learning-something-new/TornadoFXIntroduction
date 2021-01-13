package part_1_tornadofx_fundamentals.charts

import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*

class ChartView : View() {
    override val root =
       hbox {
           vbox {
               piechart("Desktop/Laptop OS Market Share") {
                   data("Windows", 77.62)
                   data("OS X", 9.52)
                   data("Other", 3.06)
                   data("Linux", 1.55)
                   data("Chrome OS", 0.55)
               }
               barchart("Unit Sales Q2 2016", CategoryAxis(), NumberAxis()) {
                   series("Product X") {
                       data("MAR", 10245)
                       data("APR", 23963)
                       data("MAY", 15038)
                   }
                   series("Product Y") {
                       data("MAR", 28443)
                       data("APR", 22845)
                       data("MAY", 19045)
                   }
               }
           }
           vbox{
               linechart("Unit Sales Q2 2016", CategoryAxis(), NumberAxis()) {
                   series("Product X") {
                       data("MAR", 10245)
                       data("APR", 23963)
                       data("MAY", 15038)
                   }
                   series("Product Y") {
                       data("MAR", 28443)
                       data("APR", 22845)
                       data("MAY", 19045)
                   }
               }

               scatterchart("Machine Capacity by Product/Week", NumberAxis(), NumberAxis()) {
                   series("Product X") {
                       data(1,24)
                       data(2,22)
                       data(3,23)
                       data(4,19)
                       data(5,18)
                   }
                   series("Product Y") {
                       data(1,12)
                       data(2,15)
                       data(3,9)
                       data(4,11)
                       data(5,7)
                   }
               }
           }
           vbox{
               bubblechart("Machine Capacity by Output/Week", NumberAxis(), NumberAxis()) {
                   series("Product X") {
                       data(1,24,1)
                       data(2,46,2)
                       data(3,23,1)
                       data(4,27,2)
                       data(5,18,1)
                   }
                   series("Product Y") {
                       data(1,12,1)
                       data(2,31,2)
                       data(3,9,1)
                       data(4,11,1)
                       data(5,15,2)
                   }
               }
           }
       }
}


class ChartApp : App(ChartView::class)


fun main() {
    launch<ChartApp>()
}