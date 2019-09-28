val a = 10
println(a)
var b = 10

val numbers = Array(10,20, 30)

val numb : Array[Int] = Array(6, 4, 2)
print(numb(0))

val numb2 : Array[Int] = new Array[Int](10)

val temps = Array.ofDim[Int](10, 10)

numbers.max

val names = Map("Hannes"->"Foulds", "Elaine"->"Venter", "Yolanda"->"Muller")
names get "Hannes"

def specialFunction(a:Int) : Int = {
  a*a
}

specialFunction(10)
specialFunction(20)

class SpecialMath(a: Int, b: Int) {
  def multiply() : Int = {
    return a * b
  }
}

val mat = new SpecialMath(2, 4)
mat.multiply()






