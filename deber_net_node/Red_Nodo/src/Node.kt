import kotlin.collections.ArrayList

public class Node {
    private var int_data: Int
    private var string_data: String
    private var float_data: Float
    private var double_data: Double
    private var boolean_data: Boolean
    private var adj_list: ArrayList<Node>

    constructor(int_data: Int, string_data: String, float_data: Float,
                double_data: Double, boolean_data: Boolean, adj_list: ArrayList<Node>) {
        this.int_data = int_data
        this.string_data = string_data
        this.float_data = float_data
        this.double_data = double_data
        this.boolean_data = boolean_data
        this.adj_list = adj_list
        if(adj_list == null) println("This node: $int_data $string_data has been initialized without an adjacent list")
    }

    constructor(int_data: Int, string_data: String, float_data: Float,
                double_data: Double, adj_list: ArrayList<Node>){
        this.int_data = int_data
        this.string_data = string_data
        this.float_data = float_data
        this.double_data = double_data
        this.boolean_data = float_data < 1.0
        this.adj_list = adj_list

        println("This node: $int_data $string_data has been initialized with boolean null value")
        if(adj_list == null) println("This node: $int_data $string_data has been initialized without an adjacent list")
    }

    public fun show_info(){
        println("\n")
        println("I'm node " + string_data + "and my values are: int_data: $int_data float_data: $float_data ")
        println("double_data: $double_data boolean_data: $boolean_data")
        println("My adjacent nodes are: ")
        this.adj_list.forEach{
            println("\tNode name: ${it.string_data}")
        }
        println("\n\n")
    }

    public fun set_new_values(float_data: Float, double_data: Double, boolean_data: Boolean?, adj_list: ArrayList<Node>){
        this.float_data = float_data
        this.double_data = double_data
        if (boolean_data != null) {
            this.boolean_data = boolean_data
        } else {
            this.boolean_data = float_data < 1.0
        }
        this.adj_list = adj_list
    }

    public fun set_arrayList(adj_list:ArrayList<Node>){
        this.adj_list = adj_list
    }

    public fun get_node(int_data_node: Int) : Node{
        return this.adj_list.get(int_data_node)
    }

    public fun get_adj_list(): ArrayList<Node>{
        return this.adj_list
    }

    public fun get_int_data(): Int{
        return this.int_data
    }

    public fun get_string_data(): String{
        return this.string_data
    }
    
}


















