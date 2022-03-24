package IA.Desastres;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.SuccessorFunction;

public class SuccessorFunction0 implements SuccessorFunction {
    
    public static int DEBUG;
	
    public SuccessorFunction0 ( ) {

    }

    @Override
    public List getSuccessors ( Object state ) {

        if ( !(state instanceof Estado ) ) 
            throw new IllegalArgumentException( "Please, only pass an Estado Instance.");
       
        Estado actual_state = (Estado) state;

        ArrayList <Estado> successors = new ArrayList<Estado>();

        for ( int i = 0; i < actual_state.getSizeX(); ++i ) {
            for ( int j = 0; j < actual_state.getSizeY(); ++j ) {

                Estado new_estado_delete = new Estado ( actual_state, i, j );
                if ( !new_estado_delete.equals(actual_state) && new_estado_delete.isValid() ) {
                    if ( this.DEBUG == 1 ) System.out.println ( "New State Created by delete (" + i + "," + j + ")");
                    successors.add(new_estado_delete);
                }

                for ( int k = 0; k < actual_state.getSizeX(); ++k ) {
                    for ( int l = 0; l < actual_state.getSizeY(); ++l ) {
                        if ( i != k && j != l ) {
                            Estado new_estado_swap = new Estado ( actual_state, i, j, k, l );
                            if ( !new_estado_swap.equals(actual_state) && new_estado_swap.isValid() ) {
                                if ( this.DEBUG == 1 ) System.out.println ( "New State Created by swap (" + i + "," + j + ";" + k + "," + l + ")");
                                successors.add(new_estado_swap);
                            }
                        }
                    }
                } 

            }
        }
        return successors;
    }

}
