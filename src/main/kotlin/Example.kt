class CalcUtils{
    fun calculate(a: Int, b: Int): Int{
        return a + b
    }
}

class App{
    fun run(){
        println(CalcUtils().calculate(1,2))
    }
}

fun main(){
    App().run()
}