package aima.core.search.adversarial;

import java.util.ArrayList;
import java.util.List;

public class GameTree<V> {

    private V value;   			   		//Type integer, Double, Float
    private boolean max;			    // MAX or MIN node
    private ArrayList<GameTree<V>> children;
    private boolean visited=false; 		// node visited mark

    public GameTree(V value, boolean max) {
    	this.visited=false;
        this.value = value;
        this.max = max;
        children = new ArrayList<GameTree<V>>();
    }

    public GameTree(V value,
                    boolean max,
                    List<GameTree<V>> children) {
        this(value, max);
        for (GameTree<V> child : children)
            this.children.add(child);
    }

    public boolean isTerminal() {
        return children.isEmpty();
    }

    public boolean isMax() {
        return max;
    }

    public void addchild(GameTree<V> child) {
        this.children.add(child);
    }

    public V getvalue() {
        return this.value;
    }

    public void setvalue(V value) {
        this.value = value;
    }

    public ArrayList<GameTree<V>> getchildren() {
        return children;
    }

    public void setchildren(ArrayList<GameTree<V>> children) {
        this.children = children;
    }
    
    public void setvisited() {
        this.visited = true;
    }
    
    public boolean getvisited() {
        return this.visited;
    }

    public String toString() {
        return printTree(0);
      }
    
  
    public void printGameExplored() {
        System.out.println(printGameExplored(0));
        System.out.println();
    }

    private String printGameExplored(int increment) {
        String s = "";
        String inc = " ".repeat(increment);
        
        if (this.isTerminal()) {
            String mark = this.visited ? this.value.toString() : "X";
            s = inc + "[" + mark + "]";
        } else {
            String type = this.max ? "-MAX" : "-MIN";
            String mark = this.visited ? this.value.toString() : "X";
            s = inc + mark + type;
        }
        
        for (GameTree<V> child : children) {
            s += "\n" + child.printGameExplored(increment + 4);
        }
        return s;
    }


      private static final int indentacion = 4;

      private String printTree(int increment) {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
          inc = inc + " ";
        }
        if (this.isTerminal()){ 
        		String formato = "%"+increment+"s";
        		s = inc+ String.format(formato,"["+ value +"]");
    			//s = inc +"["+ value +"]"; 
        }
        else {
        		String type;
        		if (this.max) type ="-MAX"; 
        		else type="-MIN";
        		s = inc + value+type; 
        		
        }
        for (GameTree<V> child : children) {
        	  s += "\n" + child.printTree(increment + indentacion);
        }
        return s;
      }
      
     
      
    /*  
      public String toString() {
          String s = "";
          s += "value = " + value + " | ";
          s += "children = " + children;
          return s;
      }
     */
}