package aima.core.environment.canibales;

import java.util.Arrays;
import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 * @author Ravi Mohan
 * @author R. Lunde
 */
public class CanibalesBoard {

	public static Action MOVER1C = new DynamicAction("MOVER1C");

	public static Action MOVER2C = new DynamicAction("MOVER2C");

	public static Action MOVER1M = new DynamicAction("MOVER1M");

	public static Action MOVER2M = new DynamicAction("MOVER2M");
	
	public static Action MOVER1M1C = new DynamicAction("MOVER1M1C");
	
	
	
	private int[] state;

	//
	// PUBLIC METHODS
	//

	public CanibalesBoard() {
		state = new int[] { 3, 3 , 0 , 0 , 0};
		
	}

	public CanibalesBoard(int[] state) {
		this.state = new int[state.length];
		System.arraycopy(state, 0, this.state, 0, state.length);
	}

	public CanibalesBoard(CanibalesBoard copyBoard) {
		this(copyBoard.getState());
	}

	public int[] getState() {
		return state;
	}

	public int getValueAt(int loc) {
		return state[loc];
	}

	public int getLocationOf() {
		return state[2];
	}

	public void MOVER1C() {
		if(getLocationOf() == 1) { 
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha -1,canibalesIzqda +1, 0);
		}
		else {
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha +1,canibalesIzqda -1, 1);
		}

	}

	public void MOVER2C() {
		if(getLocationOf() == 1) { 
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha -2,canibalesIzqda +2, 0);
		}
		else {
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha +2,canibalesIzqda -2, 1);
		}

	}

	public void MOVER1M() {
		if(getLocationOf() == 1) { 
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha -1,misIzqda +1, 0);
		}
		else {
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha +1,misIzqda -1, 1);
		}

	}
	
	public void MOVER2M() {
		if(getLocationOf() == 1) { 
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha -2,misIzqda +2, 0);
		}
		else {
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha +2,misIzqda -2, 1);
		}
	}
	
	public void MOVER1M1C() {
		if(getLocationOf() == 1) { 
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha -1,misIzqda +1, 0);
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha -1,canibalesIzqda +1, 0);
		}
		else {
			int misDcha = getValueAt(3);
			int misIzqda = getValueAt(0);
			setValue(3,0,misDcha +1,misIzqda -1, 1);
			int canibalesDcha = getValueAt(4);
			int canibalesIzqda = getValueAt(1);
			setValue(4,1,canibalesDcha +1,canibalesIzqda -1, 1);
		}

	}



	public boolean canMoveGap(Action accion) {
		boolean retVal = false;
		if (accion.equals(MOVER1C))
			if(getValueAt(2)==0) {
				if(getValueAt(1)>=1 && (getValueAt(3)>= getValueAt(4)+1 || getValueAt(3)==0) ) {
					retVal=true;
				}
			}
			else {
				if(getValueAt(4)>=1 && (getValueAt(0)>= getValueAt(1)+1 || getValueAt(0)==0) ) {
					retVal=true;
				}
			}
		else if (accion.equals(MOVER2C))
			if(getValueAt(2)==0) {
				if(getValueAt(1)>=2 && ( getValueAt(3)>= getValueAt(4)+2 || getValueAt(3)==0 ) ) {
					retVal=true;
				}
			}
			else {
				if(getValueAt(4)>=2 && (getValueAt(0)>= getValueAt(1)+2 || getValueAt(0)==0) ) {
					retVal=true;
				}
			}
		else if (accion.equals(MOVER1M))
			if(getValueAt(2)==0) {
				if(getValueAt(0)>=1 && (getValueAt(0)>= getValueAt(1)+1 || getValueAt(0)==1) && (getValueAt(3)>=getValueAt(4)-1) ) {
					retVal=true;
				}
			}
			else {
				if(getValueAt(3)>=1 && (getValueAt(3)>= getValueAt(4)+1 || getValueAt(3)==1) && (getValueAt(0)>=getValueAt(1)-1) ) {
					retVal=true;
				}
			}
		else if (accion.equals(MOVER2M))
			if(getValueAt(2)==0) {
				if(getValueAt(0)>=2 && (getValueAt(0)>= getValueAt(1)+2 || getValueAt(0)==2) && (getValueAt(3)>=getValueAt(4)-2) ) {
					retVal=true;
				}
			}
			else {
				if(getValueAt(3)>=2 && (getValueAt(3)>= getValueAt(4)+2 || getValueAt(3)==2) && (getValueAt(0)>=getValueAt(1)-2) ) {
					retVal=true;
				}
			}
		else if (accion.equals(MOVER1M1C))
			if(getValueAt(2)==0) {
				if(getValueAt(0)>=1 && getValueAt(1)>=1 && getValueAt(3)>=getValueAt(4)) {
					retVal=true;
				}
			}
			else {
				if(getValueAt(3)>=1 && getValueAt(4)>=1 && getValueAt(0)>=getValueAt(1)) {
					retVal=true;
				}
			}
		return retVal;
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(state);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanibalesBoard other = (CanibalesBoard) obj;
		return Arrays.equals(state, other.state);
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    int[] state = getState();
	    int misionerosIzqda = state[0];
	    int canibalesIzqda = state[1];
	    int misionerosDcha = state[3];
	    int canibalesDcha = state[4];
	    int bote = state[2];

	    // Construir la cadena de salida
	    sb.append("RIBERA-IZQ ");
	    for (int i = 0; i < misionerosIzqda; i++) sb.append("M ");
	    for (int i = 0; i < canibalesIzqda; i++) sb.append("C ");
	    
	    if (bote == 0) {
	        sb.append("BOTE ");
	    }
	    
	    sb.append("--RIO-- ");
	    
	    if (bote == 1) {
	        sb.append("BOTE ");
	    }
	    
	    for (int i = 0; i < misionerosDcha; i++) sb.append("M ");
	    for (int i = 0; i < canibalesDcha; i++) sb.append("C ");
	    sb.append("RIBERA-DCH");
	    
	    return sb.toString();
	}

	//
	// PRIVATE METHODS
	//


	private void setValue(int pos1, int pos2, int cant1, int cant2, int loc) {
		state[pos1] = cant1;
		state[pos2] = cant2;
		state[2] = loc;

	}
}