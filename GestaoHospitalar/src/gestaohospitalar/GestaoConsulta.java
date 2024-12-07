package gestaohospitalar;

import gestaohospitalar.model.Consulta;

import java.util.ArrayList;
import java.util.List;


public class GestaoConsulta {
    private List<Consulta> consultas;

    public GestaoConsulta(){
        consultas = new ArrayList<Consulta>();
    }

    public GestaoConsulta(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
    
        
}
