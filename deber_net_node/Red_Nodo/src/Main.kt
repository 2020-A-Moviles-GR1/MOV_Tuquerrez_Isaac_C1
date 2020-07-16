import kotlin.collections.ArrayList

var net_list : ArrayList<Net> = ArrayList<Net>()
var net_count : Int = 0
lateinit var  selected_net : Net

fun main(args : Array<String>) {
    Runtime.getRuntime().exec("clear")
    var option_p:Int = main_menu()
    while(option_p > 0) {
        when (option_p){
            1 -> create_net()
            2 -> show_nets()
            3 -> show_net()
            4 -> delete_net()
            5 -> select_net()
            //6 ->
        }
        println("Push ENTER to return main menu")
        readLine()!!
        option_p = main_menu()
    }
}

fun read_correctly(data_type:String, second_time :Boolean=false,
                   bad_int:Boolean=false,to_main_menu:Boolean=false): String {
    if(second_time||bad_int) print("Try again: ")
    try{
        when (data_type){
            "Int" -> {
                if (to_main_menu) {
                    val input_int: Int = readLine()!!.toInt()
                    if (input_int in 0..5) {
                        return input_int.toString()
                    } else {
                        return read_correctly(data_type, bad_int = true, to_main_menu = true)
                    }
                }else{
                    return readLine()!!.toInt().toString()
                }
            }
            "String" -> return readLine()!!.toString()
            "Float" -> return readLine()!!.toFloat().toString()
            "Double" -> return readLine()!!.toDouble().toString()
            "Boolean" -> return readLine()!!.toBoolean().toString()
            else -> {
                System.err.print("Error in read_correctly function")
                return "No item"
            }
        }
    } catch (e: Exception){
        return read_correctly(data_type,second_time=true, to_main_menu=to_main_menu)
    }
}

fun main_menu():Int{
    print("\n\n\n\n")
    println("""
        ################################################################################
        #                            MOBILE APPLICATION - GR1                          #
        #                 WILLAN ISAAC TUQUERREZ CALLE - KOTLIN HOMEWORK               #
        #                                                                              #
        #                          NETWORK - NODE IMPLEMENTATION                       #
        #                                      (*)                                     #
        #                                       |                                      #
        #                                       |                                      #
        #                                 ______|______                                #   
        #                            ____//     |     \\____                           #
        #                          _//                     \\_                         #
        #                          |                           |                       #
        #                          |     #####       #####     |                       #
        #                          |   #######       #######   |                       #
        #                          |   #####           #####   |                       #
        #                           \           ___           /                        #
        #                            \         /###\         /                         #
        #                             \       /#####\       /                          #
        #                              \__   ___   ___   __/                           #
        #                                 | |   | |   | |                              #
        #                                 |_|   |_|   |_|                              #
        #                                                                              #
        ################################################################################
        
        
    """.trimIndent())
    println("Choose and type one options (only numbers, other data type cause and error and end this program)")
    println("[1] Create a Network")
    println("[2] Show existing Networks")
    println("[3] Show a Network")
    println("[4] Delete a Network")
    println("[5] Select a Network")
    println("[6] Show Nodes")
    println("[7] Show a Node")
    println("[0] End this program")
    return read_correctly("Int", to_main_menu = true).toInt()
}

fun create_net(){
    println("Creating network...")
    println("Enter net size")
    net_list.add(
        Net(int_data = net_count, string_data = "Net$net_count", float_data = net_count.toFloat(),
            double_data = net_count.toDouble(), boolean_data = net_count%2==0,
            net_size = read_correctly("Int").toInt())
    )
    println("Adding net to net list")
    println("net added successfully")
    net_count ++
}

fun show_nets(net_info:Boolean = false){
    println("Showing nets:")
    net_list.forEach{
        println("This is net: ${it.get_int_data()} name: ${it.get_string_data()}")
    }

}

fun show_net(){
    println("Showing net info")
    if(selected_net != null){
        println("There aren't a selected net, please select one")
    }else
    net_list.get(read_correctly("Int").toInt()).show_info()
}

fun delete_net(){
    print("Deleting net")
    net_list.remove(net_list.get(read_correctly("Int").toInt()))
    println("Net deleted successfully")
}

fun select_net(){
    var index = read_correctly("Int").toInt()
    if (index >= net_list.size){
        selected_net = net_list.get(index)
    }else{
        println("Try again:")
        select_net()
    }

}