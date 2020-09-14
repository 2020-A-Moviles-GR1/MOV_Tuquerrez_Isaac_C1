import kotlin.collections.ArrayList

public class Net{

    private var int_data:Int
    private var string_data:String
    private var float_data:Float
    private var double_data:Double
    private var boolean_data:Boolean
    private var net_size:Int
    private var node_list: ArrayList<Node>

    constructor(int_data: Int, string_data: String, float_data: Float,
                double_data: Double, boolean_data: Boolean, net_size: Int) {
        this.int_data = int_data
        this.string_data = string_data
        this.float_data = float_data
        this.double_data = double_data
        this.boolean_data = boolean_data
        this.net_size = net_size
        this.node_list = ArrayList<Node>()
        create_node_list()
    }

    constructor(int_data: Int, string_data: String, float_data: Float,
                double_data: Double, net_size: Int){
        this.int_data = int_data
        this.string_data = string_data
        this.float_data = float_data
        this.double_data = double_data
        this.boolean_data = float_data < 1.0
        this.net_size = net_size
        this.node_list = ArrayList<Node>()
        create_node_list()
        println("This node: $int_data $string_data has been initialized with boolean null value")
        println("its value has assigned by float_data value")
    }

    private fun create_node_list(){
        for (i in 0..this.net_size){
            this.node_list.add(
                Node(int_data=i, string_data = "Nodo$i", float_data = i.toFloat(), double_data = i.toDouble(),
                    boolean_data = (i%2==0), adj_list = ArrayList<Node>())
            )
        }
    }

    private fun all_assing_adj_list(){
        this.node_list.forEach{
            val all_adj_list :ArrayList<Node> = ArrayList<Node>()
            for (i in 0..net_size){
                if(i != it.get_int_data()){
                    all_adj_list.add(this.node_list.get(i))
                }
            }
            it.set_arrayList(adj_list = all_adj_list)
        }
    }

    public fun show_info(){
        println("\n")
        println("I'm net  $string_data and my values are: int_data: $int_data float_data: $float_data ")
        println("double_data: $double_data boolean_data: $boolean_data")
        println("My nodes are: ")
        this.node_list.forEach{
            println("\tNode name: ${it.get_string_data()}")
        }
    }

    public fun get_int_data(): Int{
        return this.int_data
    }

    public fun get_string_data(): String{
        return this.string_data
    }



}
