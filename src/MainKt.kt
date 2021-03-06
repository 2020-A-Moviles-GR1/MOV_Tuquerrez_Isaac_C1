import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    print("Hola")
    // Ejemplo java:
    // Int edad = 31;
    // Mutables
    var edadProfesor = 31   // No especificamos el tipo de dato
    // ; No es necesario
    // Duck Typing
    // var edadCachorro; X -> necesitamos el tipo de datos
    var edadCachorro: Int
    edadCachorro = 3
    edadProfesor = 32
    edadCachorro = 4
    // Inmutables
    val numeroCuenta = 123456 // NO SE PUEDEN REASIGNAR
    // numeroCuenta = 123

    // Tipos variables
    val nombreProfesor: String = "Vicente Adrian"
    val sueldo: Double = 12.20
    val apellidosProfesor: Char = 'a'
    val fechaNacimiento = Date() // new Date()

    if (sueldo == 12.20) {

    } else {

    }

    when (sueldo) {
        12.20 -> println("Sueldo normal")
        -12.20 -> println("Sueldo negativo")
        else -> println("No se reconoce el sueldo")
    }

    val esSueldoMayorAlEstablecido = if (sueldo == 12.20) true else false
    // EXPRESION ? X : Y
    // calcularSueldo(1000.00, 14.00)
    calcularSueldo(1000.00, 14.00)
    calcularSueldo(
        tasa = 16.00,
        sueldo = 800.00
    ) // Named Parameters
    calcularSueldo(700.00)
    calcularSueldo(sueldo = 650.00)

    val arregloConstante: Array<Int> = arrayOf(1, 2, 3)
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(30, 31, 22, 23, 20)
    print(arregloCumpleanos)
    arregloCumpleanos.add(24)
    print(arregloCumpleanos)
    // arregloCumpleanos.remove(30)
    arregloCumpleanos.remove(30)
    print(arregloCumpleanos)


    arregloCumpleanos
        .forEach { valorIteracion: Int ->
            println("Valor iteracion: " + valorIteracion)
        }
    arregloCumpleanos
        .forEach(
            { valorIteracion: Int ->
                println("Valor iteracion: " + valorIteracion)
            }
        )

    // Operadores -> TODOS LOS LENGUAJES
    // ForEach no devuelve nada -> Unit
    arregloCumpleanos
        .forEach { iteracion: Int ->
            println("Valor de la iteracion " + iteracion)
            println("Valor con -1 = ${iteracion * -1} ")
        }

    val respuestaArregloForEach = arregloCumpleanos
        .forEachIndexed { index: Int, iteracion: Int ->
            println("Valor de la iteracion " + iteracion)
        }
    println(respuestaArregloForEach) // Void Unit

    // MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados
    val respuestaMap = arregloCumpleanos
        .map { iterador: Int ->
            iterador * -1
        }
    val respuestaMapDos = arregloCumpleanos
        .map { iterador: Int ->
            val nuevoValor = iterador * -1
            val otroValor = nuevoValor * 2
            return@map Date()
        }
    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanos)

    // Filter -> FILTRAR EL ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo que cumpla esa expresion
    val respuestaFilter = arregloCumpleanos
        .filter { iteracion: Int ->
            val esMayorA23 = iteracion > 23
            return@filter esMayorA23
        }
    arregloCumpleanos
        .filter { iteracion: Int ->
            iteracion > 23
        }
    println(respuestaFilter)
    println(arregloCumpleanos)

    //Any -> OR
    //ALL -> AND
    // no devuelve un arreglo
    val respuestaAny: Boolean = arregloCumpleanos
            .any { itera: Int ->
        return@any itera > 25
    }
    print("\nRespuesta any ")
    print(respuestaAny)

    val respuestaAll: Boolean = arregloCumpleanos
            .all { itera: Int ->
        return@all itera < 65
    }
    print("\nrespuesta all ")
    print(respuestaAll)

    val respuestaReduce: Int = arregloCumpleanos
            .reduce { acumulador, iteracion ->
        return@reduce acumulador + iteracion
    }

    print("\nrespuesta reduce ")
    print(respuestaReduce)

    val respuestaFold: Int = arregloCumpleanos
        .fold(
            100,
            { acumulador, iteracion ->
                return@fold acumulador - iteracion
            }
        )

    print("\nrespuesta fold ")
    print(respuestaFold)

    val vidaAcutal: Double = arregloCumpleanos.map { it * 0.8 }
        .filter { it > 18 }
        .fold(
            100.00, { acc, d -> acc - d }
        ).also {
            print("\n")
            println(it)
        }

    val nuevoNum1 = SumarDosNumeros( 1, 2)
    val nuevoNum2 = SumarDosNumeros(null, 2)
    val nuevoNum3 = SumarDosNumeros(1, null)
    val nuevoNum4 = SumarDosNumeros(null, null)

    println(SumarDosNumeros.arreglo)
    SumarDosNumeros.agregarNumero(1)
    println(SumarDosNumeros.arreglo)
    SumarDosNumeros.eliminarNumer(0)
    println(SumarDosNumeros.arreglo)




}

fun calcularSueldo(
    sueldo: Double, // Requeridos!
    tasa: Double = 12.00, // Tiene valor defecto
    calculoEspecial: Int? = null // Pueden ser nulos
): Double {
    if (calculoEspecial != null) {
        return sueldo * tasa * calculoEspecial
    } else {
        return sueldo * tasa
    }
}


fun imprimirMensaje() { // Unit = Void
    println("")
}




//Clase Abstracta
abstract class Numeros(
    protected var numero1:Int,
    protected var numero2:Int){

}


class SumarDosNumeros(uno:Int, dos:Int):Numeros(uno, dos){

    constructor(uno:Int?, dos:Int):this(
            if (uno == null) 0 else uno,
            dos
    ){
        println("hola1")
    }
    constructor(uno:Int, dos:Int?):this(
            uno ,if (dos == null) 0 else dos
    ){
        println("hola2")
    }
    constructor(uno:Int?, dos:Int?):this(
            if (uno == null) 0 else uno,
            if (dos == null) 0 else dos
    )
    {
        println("hola3")
    }

    companion object{
        val arreglo = arrayListOf(1,2,3,4,5)
        fun agregarNumero(nuevoNum:Int){
            this.arreglo.add(nuevoNum)
        }
        fun eliminarNumer(index:Int){
            this.arreglo.removeAt(index)
        }

    }

}